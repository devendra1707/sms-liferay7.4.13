		var  assessmentLevelDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=177";
		var 	 assessmentLevelDefId = 177;
		var  assessmentLevelBaseUrl = "/api/jsonws/lms.assessmentlevel";

		var AssessmentLevel = Backbone.Model.extend({
		label:'AssessmentLevel',
		icon:'$ModelIconUrl$',
		visible: {
  "title": { "type":"Text", "title":"Assessment Title", "validators":["required"], "options":0, "regexp":0, "fieldclass":0},
  "description": { "type":"TextArea", "title":"Description", "validators":["required"], "options":0, "regexp":0, "fieldclass":0}
},
	    localStorage: new Backbone.LocalStorage('tbl-assessmentlevel'),
	    url: assessmentLevelBaseUrl + "/default",
	    create:function (){
	    	this.url=assessmentLevelBaseUrl + "/create";
	    	return Backbone.ajaxSync('create', this);
	    },
		createUrl:function (){
			return assessmentLevelBaseUrl + "/create";
	    },
	    update:function (){
	    		this.url=assessmentLevelBaseUrl + "/update";
	    		return Backbone.ajaxSync('create', this);
	    },
	    updateUrl:function (){
	    		return assessmentLevelBaseUrl + "/update";
	    },
	    remove:function (){
	    	this.url=assessmentLevelBaseUrl + "/delete";
	    	return Backbone.ajaxSync('create', this);
	    },
	    toString: function() {
        	return this.get('title');
    	}
	});
	
	var AssessmentLevelCollection = Backbone.Collection.extend({
		model: AssessmentLevel,
		url: assessmentLevelBaseUrl + "/find-all",
	    localStorage: new Backbone.LocalStorage('tbl-assessmentlevel'),
	    download: function(filter){
	    	return Backbone.ajaxSync('read', this);
	    }
	});
	
	var AssessmentLevelCreateForm = Backbone.Form.extend({
		schema: {"title":{"type":"Text","title":"Assessment Title","validators":["required"],"fieldclass":0},"description":{"type":"TextArea","title":"Description","validators":["required","description"],"fieldclass":0}}
	});
	
	var AssessmentLevelEditForm = Backbone.Form.extend({
		schema: {
  "title": { "type":"Text", "title":"Assessment Title", "validators":["required"], "options":0, "regexp":0, "fieldclass":0},
  "description": { "type":"TextArea", "title":"Description", "validators":["required","description"], "options":0, "regexp":0, "fieldclass":0}
}
	});
