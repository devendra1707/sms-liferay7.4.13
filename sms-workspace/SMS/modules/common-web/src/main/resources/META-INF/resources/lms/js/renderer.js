var templateMap = {};

function renderList(list, templateId, containerId){
    uniqueValues=[];
    if(templateMap[templateId]==undefined){
	    var source = $('#' + templateId).html();
    	var template = Handlebars.compile(source);
    	templateMap[templateId] = template;
    }
    var array = JSON.parse(JSON.stringify(list));
    var html = templateMap[templateId](array);
    $('#' + containerId).html(html);
    
}



function renderModel(model, templateId, containerId){
    uniqueValues=[];
    if(templateMap[templateId]==undefined){
	    var source = $('#' + templateId).html();
	    var template = Handlebars.compile(source);
		templateMap[templateId] = template;
    }
    var array = JSON.parse(JSON.stringify(model));
    var html = templateMap[templateId](array);
    $('#' + containerId).html(html);
    
}
function renderModelV1(model, templateId, containerId){
	  setTimeout(function(){

    uniqueValues=[];
    if(templateMap[templateId]==undefined){
	    var source = $('#' + templateId).html();
	  
	    	   var template = Handlebars.compile(source);
	    		templateMap[templateId] = template;
		
	 
    }
    var array = JSON.parse(JSON.stringify(model));
    var html = templateMap[templateId](array);
    $('#' + containerId).html(html);
	  }, 20);
}

function replaceModelView(model, templateId, containerId){
    uniqueValues=[];
    if(templateMap[templateId]==undefined){
	    var source = $('#' + templateId).html();
    	var template = Handlebars.compile(source);
    	templateMap[templateId] = template;
    }
    var array = JSON.parse(JSON.stringify(model));
    var html = templateMap[templateId](array);
    $('#' + containerId).replaceWith(html);
}

function renderForm(form, containerId, onsubmit, append){
	if(form==null){
		return;
	}
	
	form.render().on('submit', function(e) {
		  e.preventDefault();
		  var validationError = this.validate();
		  if(validationError==null){
		  	form.commit();
		  	for(k in form.schema) {
        		if(form.schema[k].type=='Date' || form.schema[k].type=='DatePickerBootstrap' ){
        			console.log("Inside Date  :::"+form.getValue(k));
        			var dt = new Date(form.getValue(k));
        			form.model.set(k, dt.getTime());        			
        		}
        		else if(form.schema[k].type=='DateTimePickerBootstrap'){  
        			//DateTimePickerBootstrap
        			var dt = moment(form.getValue(k), 'YYYY-MM-DD HH:mm').toDate();
        			form.model.set(k, dt.getTime());
        		}
	      	}
		  	if(onsubmit!=null){
		  		onsubmit(form);
		  	}
		  }else{
			  var invalidElement = $(form.el.elements.namedItem(Object.keys(validationError)[0]));
			  try{
				  invalidElement.focus()
			  }catch(e){}
			  invalidElement.addClass('bounceIn animated');
			  setTimeout(function(){
				  invalidElement.removeClass('bounceIn animated');
			  }, 1000);
			   openOkBox(liferayMessagesAsPerLocale['invalid_input_detected']);
		  }
	});
	if(append){
		$('#' + containerId).append(form.el);
	}else{
		$('#' + containerId).html(form.el);
	}

	return form.el;

}

function setCachedImage(target, remoteUrl){

	ImgCache.isCached(remoteUrl, function(path, success) {
			  if (success) {
			  	ImgCache.getCachedFileURL(remoteUrl, function(img, localPath){
			  		target.attr("src", localPath);
			  	});
			  } else {
				// not there, need to cache the image
				ImgCache.cacheFile(remoteUrl, function () {
				  	ImgCache.getCachedFileURL(remoteUrl, function(img, localPath){
				  		target.attr("src", localPath);
				  	});
				});
			  }
			});
}

Handlebars.registerHelper({
	eq : function(v1, v2) {
		return v1 === v2;
	},
	ne : function(v1, v2) {
		return v1 !== v2;
	},
	lt : function(v1, v2) {
		return v1 < v2;
	},
	gt : function(v1, v2) {
		return v1 > v2;
	},
	lte : function(v1, v2) {
		return v1 <= v2;
	},
	gte : function(v1, v2) {
		return v1 >= v2;
	},
	and : function(v1, v2) {
		return v1 && v2;
	},
	or : function(v1, v2) {
		return v1 || v2;
	}
});

String.prototype.capitalize = function () {

    return this.toLowerCase().replace(/\b[a-z]/g, function (letter) {
        return letter.toUpperCase();
    });
};

Date.prototype.getUTCTime = function () {
    return this.getTime() - (this.getTimezoneOffset() * 60000);
};

var msToTime = function(duration) {
    var milliseconds = parseInt((duration%1000)/100)
        , seconds = parseInt((duration/1000)%60)
        , minutes = parseInt((duration/(1000*60))%60)
        , hours = parseInt((duration/(1000*60*60))%24);

    hours = (hours < 10) ? "0" + hours : hours;
    minutes = (minutes < 10) ? "0" + minutes : minutes;
    seconds = (seconds < 10) ? "0" + seconds : seconds;

    //return hours + ":" + minutes + ":" + seconds + "." + milliseconds;
    return hours + ":" + minutes + ":" + seconds;
}
