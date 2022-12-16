var localeBaseUrl = "/api/jsonws/lms.localeinfo";
var translationBaseUrl = "/api/jsonws/lms.translation";
var propertiesBaseUrl = "/api/jsonws/lms.properties";

var LocaleInfo = Backbone.Model.extend({
		label:'LocaleInfo',
		icon:'$ModelIconUrl$',
		idAttribute : 'localeCode',
		visible: {
			"localeCode" : {
				"title":"Locale Code",
				"type":"Text",
				"validators":["required"],
				"editorClass" : "form-control"
			},
			"displayName" : { 
				"type":"Text", 
				"title":"Display Name", 
				"validators":["required"], 
				"options":"",
				"editorClass" : "form-control"
			}
		},
	    localStorage: new Backbone.LocalStorage('tbl-localeInfo'),
	    url: localeBaseUrl + "/find",
	    create:function (){
	    	this.url = localeBaseUrl + "/create";
	    	return Backbone.ajaxSync('create', this);
	    },
	    update:function (){
	    		this.url = localeBaseUrl + "/update";
	    		return Backbone.ajaxSync('create', this);
	    },
	    remove:function (){
	    	this.url = localeBaseUrl + "/delete";
	    	return Backbone.ajaxSync('create', this);
	    },
	    findTranslation:function (columnName,modelName,recordId,localeCode){
	    	this.url = translationBaseUrl + "/find-by-column-name-model-name-record-id-locale-code";
	    	this.attributes["columnName"] = columnName;
	    	this.attributes["modelName"] = modelName;
	    	this.attributes["recordId"] = recordId;
	    	this.attributes["localeCode"] = localeCode;
	    	return Backbone.ajaxSync('create', this);
	    },
	    statusMapKey:'status-map-v4',
	    findStatusMap:function (){
	    	this.url = propertiesBaseUrl + "/find-status-map";
	    	return Backbone.ajaxSync('read', this);
	    },
	    toString: function() {
        	return this.get('countryName');
    	}
	});
	
var LocaleInfoCollection = Backbone.Collection.extend({
	model: LocaleInfo,
	url: localeBaseUrl + "/find-all",
	localStorage: new Backbone.LocalStorage('tbl-localeInfo'),
	download: function(){
	return Backbone.ajaxSync('read', this);
  },
  getSupportedLocales:function (){
  	this.url = translationBaseUrl + "/get-supported-locales";
  	return Backbone.ajaxSync('read', this);
  }
});
var lmsStatusMap;
$(document).ready(function() {
	try{
		var localeInfo = new LocaleInfo();
		if(localStorage.getItem(localeInfo.statusMapKey) != null){
			try{
			lmsStatusMap = JSON.parse(localStorage.getItem(localeInfo.statusMapKey));
			}catch(err) {
				downloadStatusMap();
			}
		}else{
			downloadStatusMap();
		}
	}catch(err) {
		downloadStatusMap();
	}
});
var downloadStatusMap = function(){
	var localeInfo = new LocaleInfo();
	localeInfo.findStatusMap().done(function(response){
		if(response.exception==undefined){
			try{
				localStorage.setItem(localeInfo.statusMapKey, JSON.stringify(response));
			}catch(err) {}
			lmsStatusMap = response;
		}		
	}).fail(function(e){
		handleError(e)		
	});
}
	