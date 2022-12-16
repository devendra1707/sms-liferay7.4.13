var env;

var Version = Backbone.Model.extend({
	localStorage: new Backbone.LocalStorage('tbl_version'),
	url : "/",
	checkForUpdate: function() {
	
	if(baseUrl == liveRoot){
		env = 'prod';
		this.url = "http://www.armantecsystems.com/6eapps/android/checklist/manifest.json?t=" + new Date();
	}else{
		env = 'test';
		this.url = "http://www.armantecsystems.com/6eapps/android/checklist/manifest.json?t=" + new Date();
	}
	return Backbone.ajaxSync('read', this);
	}
});

document.addEventListener("deviceready", checkForUpdate, false);


function checkForUpdate(){
	
	var appVersion = new Version();
	appVersion.checkForUpdate().done(function(versionInfo){
		
		var versionInfo = JSON.parse(JSON.stringify(versionInfo));
		var  envPlatforms = versionInfo[env];
		var version = envPlatforms[cordova.platformId].version;
		
		if(parseInt(version.replace(/\./g, '')) > parseInt(AppVersion.version.replace(/\./g, ''))){
		
		navigator.notification.confirm(
    	'New version ' + version + ' is available to download', // message
	     function(buttonIndex){
	     	if(buttonIndex==1){
	     	if(cordova.platformId=='android'){
	     		showProgress("Downloading version " + version);
     			downloadApkAndroid(envPlatforms[cordova.platformId].url);
	     	}else{
	    	 	cordova.InAppBrowser.open(envPlatforms[cordova.platformId].url, '_blank', 'location=yes,hidden=yes');
		    }
		    }
	     },
		// callback to invoke with index of button pressed
    	'App Update',           // title
	    ['Download','Later']  // buttonLabels
		);
		}		
	});
}	



function downloadApkAndroid(url) {

    window.requestFileSystem(LocalFileSystem.PERSISTENT, 0, function(fileSystem){
        
    var fileName = url.substring(url.lastIndexOf("/")+1);

    var localPath = cordova.file.externalDataDirectory + "/" + fileName,
    fileTransfer = new FileTransfer();        
    fileTransfer.download(url, localPath, function(entry) {
    	hideProgress();
        window.plugins.webintent.startActivity({
            action: window.plugins.webintent.ACTION_VIEW,
    	        url: localPath,
	            type: 'application/vnd.android.package-archive'
            },
            function(e){
            	
            },
            function(e){
                
            }
        );                              

    }, function (error) {
        alert("Failed to download updates. Please try later.");
  });
  }, function(evt){
      
  });

}
