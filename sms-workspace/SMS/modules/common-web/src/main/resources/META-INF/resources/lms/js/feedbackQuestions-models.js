
var  feedbackQuestionBaseUrl = "/api/jsonws/lms.feedbackquestion";

var FeedbackQuestion = Backbone.Model.extend({
	label:'FeedbackQuestion',
	icon:'$ModelIconUrl$',
	visible: {
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
			},
		"content":{"type":"Text","title":"Content","validators":["required"]},
		"ratingType": {type:'Select', "title":"Rating Type" ,"validators":["required"], options: [ { val: '', label: 'Select' },{ val: 'STAR', label: "STAR" } ,{ val: 'SMILE', label: "SMILE" }, {val: 'THUMB', label: "THUMB" }, {val: 'HEART', label: "HEART"} ] }
		
	},
	localStorage : new Backbone.LocalStorage('tbl-feedback'),
	url : feedbackQuestionBaseUrl + "/find",
	create : function() {
		this.url = feedbackQuestionBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function() {
		this.url = feedbackQuestionBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	update : function() {
		this.url = feedbackQuestionBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function() {
		return feedbackQuestionBaseUrl + "/update";
	},
	remove : function() {
		this.url = feedbackQuestionBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	findByLocaleCode : function(id,localeCode) {
		this.url = feedbackQuestionBaseUrl + "/find-by-locale-code";
		this.attributes["id"] = id;
		this.attributes["localeCode"] = localeCode;
		return Backbone.ajaxSync('create', this);
	}
});



var FeedbackQuestionCollection = Backbone.Collection.extend({
	model: FeedbackQuestion,
	url: feedbackQuestionBaseUrl + "/find-all",
    localStorage: new Backbone.LocalStorage('tbl-feedback'),
    download: function(filter)
    {
    	return Backbone.ajaxSync('read', this);
    },
    
    listFeedbackQuestionByFeedbackId:  function(feedbackId)
         {
 	   
     	this.url=feedbackQuestionBaseUrl + "/find-questions-by-feedback-id?feedbackId="+feedbackId;
         	return Backbone.ajaxSync('read', this);
         }




});


var FeedbackQuestionEditForm = Backbone.Form.extend({

	schema: {
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
			},
		"content":{
			"type":"TextArea",
			"title":"Content",
			"validators":["required"],  
			"editorClass" : "form-control input-md",
             editorAttrs : {
    			placeholder : 'Type the question'
    		}},
		"ratingType": {
			type:'Select', 
			"title":"Rating Type" ,
			"validators":["required"], 
			"editorClass" : "form-control input-md",
			options: [ 
				{ val: '', label: 'Select' },
				{ val: 'STAR', label: "STAR" } ,
				{ val: 'SMILE', label: "SMILE" }, 
				{val: 'THUMB', label: "THUMB" }, 
				{val: 'HEART', label: "HEART"} ] 
    		}
	}
});



var FeedbackQuestionCreateForm = Backbone.Form.extend({

	schema: {
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
			},
		"content":{
			"type":"TextArea",
			"title":"Content",
			"validators":["required"],
			"editorClass" : "form-control input-md",
            editorAttrs : {
   			placeholder : 'Type the question'
   		}},
		"ratingType": {
			type:'Select', 
			"title":"Rating Type" ,
			"validators":["required"],
			"editorClass" : "form-control input-md",
			options: [ 
				{ val: '', label: 'Select' },
				{ val: 'STAR', label: "STAR" } ,
				{ val: 'SMILE', label: "SMILE" }, 
				{val: 'THUMB', label: "THUMB" }, 
				{val: 'HEART', label: "HEART"} ] 
   		}
		
	}


});


