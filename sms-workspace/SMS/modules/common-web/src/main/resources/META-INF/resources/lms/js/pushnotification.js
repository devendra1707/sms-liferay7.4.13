var pushNotification,receivedNotificationCollection;

var deviceRegistrationUrl = baseUrl + "/advance-survey-portlet.surveydevice/register";


var GCMID = Backbone.Model.extend({
	    localStorage: new Backbone.LocalStorage('tbl_gcmid'),
	    url: deviceRegistrationUrl,
	    pushToServer:function(){
	    	//alert(JSON.stringify(this));
		    return Backbone.ajaxSync('create', this);
	    }
});


var GCMIDCollection = Backbone.Collection.extend({
	    model: GCMID,
	    url: baseUrl + '/odata/UserProfiles',
	    localStorage: new Backbone.LocalStorage('tbl_gcmid')
});

var ReceivedNotification = Backbone.Model.extend({
	localStorage: new Backbone.LocalStorage('tbl_notification'),
	url : baseUrl+"api/UserDepartmentNotificationMapperBatch",
});

var ReceivedNotificationCollection = Backbone.Collection.extend({
    model: ReceivedNotification,
    localStorage: new Backbone.LocalStorage('tbl_notification'),
});


function updateNotificationCountView(){

	if(receivedNotificationCollection==undefined){
		receivedNotificationCollection = new ReceivedNotificationCollection();
		receivedNotificationCollection.fetch();
	}

	var uncheckedNotifications = receivedNotificationCollection.where({checked:false});
		
	if(uncheckedNotifications.length>0){
		$('#notificationcount').html(uncheckedNotifications.length);
		$('#notificationcount').addClass("activeNotification");
		var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
		$('#notificationcount').addClass("animated bounce").one(animationEnd, function() {
            $(this).removeClass('animated bounce');
        });
		
		pushNotification.setApplicationIconBadgeNumber(function() {
                console.log('success');
            }, function() {
                console.log('error');
            }, uncheckedNotifications.length);
	}else{
		$('#notificationcount').html(0);
		$('#notificationcount').removeClass("activeNotification");

		try{
			pushNotification.setApplicationIconBadgeNumber(function() {
                console.log('success');
            }, function() {
                console.log('error');
            }, 0);
		}catch(e){}
		
	}

}

function pushRegistration(){
	
	updateNotificationCountView();

	var gcmIdCollection = new GCMIDCollection();
	gcmIdCollection.fetch();
	
	pushNotification = PushNotification.init({
    android: {
        senderID: "1072765258141",
        icon:"icon"
    },
    ios: {
        alert: "true",
        badge: "true",
        sound: "true"
    },
    windows: {}
	});
	
	pushNotification.on('registration', function(data) {
    	saveOnServer(data.registrationId, (deviceType=='iPhone')?'Apple':'Google')
	});

	pushNotification.on('notification', function(data) {
        updateNotificationCountAndPage(data);
	});

	pushNotification.on('error', function(e) {
    	console.log("Push noification error " + e);
	});
	
	//syncOnPushReceived();
}

document.addEventListener("resume", onResume, false);

document.addEventListener("deviceready", onResume, false);

function onResume() {
    var prefs = plugins.appPreferences;
	prefs.fetch (function(o){
		var jsonArray = o==null?[]:JSON.parse(o);
		jsonArray.forEach(function(data){
			updateNotificationCountAndPage(data)
		});
		prefs.remove(function(e){}, function(e){}, 'push_notification');
	}, function(o){
		alert(o);
	}, 'push_notification');
}

function updateNotificationCountAndPage(data){

var message = data.message==undefined?data.Message:data.message;
	var title = data.title==undefined?data.Title:data.title;
	
	if(title==undefined || title=='' || title== null || title=='null'){
		title = data.additionalData.Title;
	}
	
	if(message.indexOf("{")>=0){
		message = JSON.parse(message);
		message = message.aps.alert.body;
		//title = message.Title;
	}
	
	var notification = new ReceivedNotification();
	notification.set("id", (receivedNotificationCollection.length+1))
	notification.set("message", message);
	notification.set("title", title);
	notification.set("receivedOn", new Date());
	notification.set("checked", false);
	notification.save();
	
	receivedNotificationCollection.add(notification);
		
	if(activePage=='notification-page'){
		updateNotificationListPage();
	}else{
		updateNotificationCountView();
	}
}


$(document).on('panelbeforeload', '#notification-page', function(){
	updateNotificationListPage();
});


function updateNotificationListPage(){
	
	if(receivedNotificationCollection==undefined){
		receivedNotificationCollection = new ReceivedNotificationCollection();
		receivedNotificationCollection.fetch();
	}
	
	renderList(receivedNotificationCollection.models.reverse(), 'notification-list-template', 'notification-list-container');
	
	notificationListScroll.myScroll.refresh();
	
	receivedNotificationCollection.where({checked:false}).forEach(function(model){
		model.set('checked', true);
		model.save();
		receivedNotificationCollection.add(model, {merge:true});
	});
	
	//console.log(JSON.stringify(receivedNotificationCollection));
	
	updateNotificationCountView();

}


function saveOnServer(regid, provider){
	        var gcmid = new GCMID();
            gcmid.set("id", 0);
            gcmid.set('deviceid', deviceId);
            gcmid.set('provider', provider);
            gcmid.set('regid', regid);
            gcmid.set('other', '');
            
            // Your GCM push server needs to know the regID before it can push to this device
            // here is where you might want to send it the regID for later use.
            
            console.log("Registration data " + JSON.stringify(gcmid));
            
            gcmid.pushToServer().done(function(model){
            	console.log("Registration response = " + JSON.stringify(model));
            	if(model.info=='Done'){
            		console.log("Registration successful");
            		gcmid.save();
            	}
            }).fail(function(e){
            	//alert("Error " + JSON.stringify(e));
            	handleError(e);
            });
}

function alertDismissed() {
    // do something
}
