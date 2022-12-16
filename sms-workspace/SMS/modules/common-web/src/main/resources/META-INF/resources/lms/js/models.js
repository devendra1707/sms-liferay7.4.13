	var localRoot = 'http://192.168.2.2:8080/api/jsonws';
	var liveRoot = '/api/jsonws';
	var baseUrl = liveRoot;
	
	/*
		System Models
	*/

	var User = Backbone.Model.extend({
	    localStorage: new Backbone.LocalStorage('tbl_user_detail'),
	    url: baseUrl + '/advance-survey-portlet.surveyquestion/login',
	    login: function() {
	        return Backbone.ajaxSync('read', this);    
	    }
	});
	
	var UserCollection = Backbone.Collection.extend({
	    localStorage: new Backbone.LocalStorage('tbl_user_detail')
	});
	
	var LocationHistory = Backbone.Model.extend({
	    localStorage: new Backbone.LocalStorage('tbl_location_history'),
	    url: baseUrl + "/advance-survey-portlet.surveyerlocationhistory/add-many",
	    upload: function(){
	    		return Backbone.ajaxSync('create', this);
	    }
	});
	
	var LocationHistoryCollection = Backbone.Collection.extend({
		model: LocationHistory,
		url: baseUrl + "/advance-survey-portlet.surveyerlocationhistory/add-many",
	    localStorage: new Backbone.LocalStorage('tbl_location_history'),
	    upload: function(){
	    		return Backbone.ajaxSync('create', this);
	    }
	});
	
	var ModuleDefinition = Backbone.Model.extend({
	    localStorage: new Backbone.LocalStorage('tbl_module_definition'),
	    url: ""	    
	});
	
	var ModuleDefinitionCollection = Backbone.Collection.extend({
		model: ModuleDefinition,
		url: "/api/jsonws/mobile-app-builder-portlet.module/find-my-modules",
	    localStorage: new Backbone.LocalStorage('tbl_module_definition'),
	    download: function(){
	    		return Backbone.ajaxSync('read', this);
	    }
	});
