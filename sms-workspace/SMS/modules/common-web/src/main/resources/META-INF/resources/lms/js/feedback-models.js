
var  feedbackBaseUrl = "/api/jsonws/lms.feedback";
var  feedbackResponseBaseUrl = "/api/jsonws/lms.feedbackresponse";
var  feedbackCommentBaseUrl = "/api/jsonws/lms.feedbackcomment";
var  feedbacQuestionBaseUrl = "/api/jsonws/lms.feedbackquestion";
var  feedbackResponseRatingsBaseUrl = "/api/jsonws/lms.feedbackresponseratings";

var Feedback = Backbone.Model.extend({
	label:'Feedback',
	icon:'$ModelIconUrl$',
	visible: {
			"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
			},
		"title":{"type":"Text","title":"Title","validators":["required"]},
		"commentRequired": {type:'Select', "title":"Comment Required" ,"validators":["required"], options: [{ val: '', label: 'Select' },{ val: "Yes", label: "Yes" } ,{ val: "No", label: "No" }] },
		"feedbackType": {type:'Select',"title":"Feedback Types" , "validators":["required"], options: [ { val: '', label: 'Select' },{ val: 'TOPIC', label: 'TOPIC' }, { val: 'WEBSITE', label: 'WEBSITE' }] }
	},
    localStorage : new Backbone.LocalStorage('tbl-feedback'),
	url : feedbackBaseUrl + "/find",
	create : function() {
		this.url = feedbackBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function() {
		this.url = feedbackBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	update : function() {
		this.url = feedbackBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function() {
		return feedbackBaseUrl + "/update";
	},
	remove : function() {
		this.url = feedbackBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},

	saveFeedbackResponse : function() {
		this.url = feedbackResponseBaseUrl + "/save-feedback-response";
		return Backbone.ajaxSync('create', this);
	},
	saveFeedbackComment : function() {
		this.url = feedbackCommentBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	updateStatus : function() {
		this.url = feedbackBaseUrl + "/update-status";
		return Backbone.ajaxSync('create', this);
	},
	findByLocaleCode : function(id,localeCode) {
		this.url = feedbackBaseUrl + "/find-by-locale-code";
		this.attributes["id"] = id;
		this.attributes["localeCode"] = localeCode;
		return Backbone.ajaxSync('create', this);
	}
});




var FeedbackCollection = Backbone.Collection.extend({
	model: Feedback,
	url: feedbackBaseUrl + "/find-all",
    localStorage: new Backbone.LocalStorage('tbl-feedback'),
    download: function(filter)
    {
    	return Backbone.ajaxSync('read', this);
    },
    findFeedbackDetailsByFeedbackId:  function(feedbackId)
    {
    	this.url=feedbackBaseUrl + "/find-feedback-details-with-question-by-feedback-id?feedbackId="+feedbackId;
        return Backbone.ajaxSync('read', this);
    },
	findActiveFeedback:  function(courseId,feedbackType)
    {
    	this.url=feedbackBaseUrl + "/find-active-feedback?courseId="+courseId+"&feedbackType="+feedbackType;
        return Backbone.ajaxSync('read', this);
    },
	findByFeedbackId:  function(feedbackId)
    {
    	this.url=feedbackBaseUrl + "/find-by-feedback-id?feedbackId="+feedbackId;
        return Backbone.ajaxSync('read', this);
    },
	listFeedbackResponseByFeedbackId:  function(feedbackId)
    {   
        this.url=feedbackResponseBaseUrl + "/find-by-feedback-id?feedbackId="+feedbackId;
        return Backbone.ajaxSync('read', this);
    },
    listofQuestionsWithRatings:  function(feedbackId,studentId,classPK)
    {
        this.url=feedbacQuestionBaseUrl + "/find-questions-with-ratings?feedbackId="+feedbackId+"&studentId="+studentId+"&classPK="+classPK+"";
        return Backbone.ajaxSync('read', this);
    },
    findQuestionsWithAverageRating:  function(feedbackId)
    {
        this.url=feedbacQuestionBaseUrl + "/find-questions-with-average-rating?feedbackId="+feedbackId;
        return Backbone.ajaxSync('read', this);
    },
	findQuestionsWithAverageRatingByFeedbackId_ClassPK:  function(feedbackId,classPK)
    {
        this.url=feedbacQuestionBaseUrl + "/find-questions-with-average-rating-by-feedback-id_-class-pk?feedbackId="+feedbackId+"&classPK="+classPK;
        return Backbone.ajaxSync('read', this);
    },
    findContentFeedbackResponseByCourseId: function(courseId)
	{
		this.url=feedbackResponseRatingsBaseUrl + "/find-content-feedback-response-by-course-id?courseId="+courseId;
        return Backbone.ajaxSync('read', this);
	},
	 findFeedbackResponseByFeedbackId_ClassPK: function(feedbackId,classPK)
	{
		this.url=feedbackResponseBaseUrl + "/find-by-feedback-id_-class-pk?feedbackId="+feedbackId+"&classPK="+classPK;
        return Backbone.ajaxSync('read', this);
	}
	,findQuestionsWithAverageRatingByCourseId:  function(courseId)
    {
        this.url=feedbacQuestionBaseUrl + "/find-questions-with-average-rating-by-course?courseId="+courseId;
        return Backbone.ajaxSync('read', this);
    },findFeedbackTypeArray:  function()
    {
        this.url=feedbackBaseUrl + "/find-feedback-type-array";
        return Backbone.ajaxSync('read', this);
    }
});

var FeedbackEditForm = Backbone.Form.extend({

	schema: {
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
			},
		"title":{
		"type":"Text",
		"title":"Title",
		"validators":["required"],
		"editorClass" : "form-control input-md",
		editorAttrs : {
			placeholder : 'Title'
		}
		},
		"commentRequired": {
			type:'Select', 
			"title":"Comment Required" ,
			"validators":["required"],
			"editorClass" : "form-control input-md",
			options: [ 
				{ val: '', label: 'Select' },
				{ val: "Yes", label: "Yes" } ,
				{ val: "No", label: "No" }] 
		},
		"feedbackType": {
			type:'Select',
			"title":"Feedback Types" ,
			"validators":["required"], 
			"editorClass" : "form-control input-md",
			options: [ 
				] 
				}
	}
});

var FeedbackCreateForm = Backbone.Form.extend({

	schema: {
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
			},
		"title":{
			"type":"Text",
			"title":"Title",
			"validators":["required"],
            "editorClass" : "form-control input-md",
            editorAttrs : {
    			placeholder : 'Title'
    		}
          },
		"commentRequired": {
			type:'Select', 
			"title":"Comment Required" ,
			"validators":["required"],
			"editorClass" : "form-control input-md",
			options: [ 
				{ val: '', label: 'Select' },
				{ val: "Yes", label: "Yes" } ,
				{ val: "No", label: "No" }]
          },
		"feedbackType": {
			type:'Select',
			"title":"Feedback Types" , 
			"validators":["required"],
			"editorClass" : "form-control input-md",
			options: [ 
				
				] 
		}
	}


});
var lmsFeedbackTypeMap = {};
var feedbackCollection = new FeedbackCollection();
	feedbackCollection.findFeedbackTypeArray().done(function(response){
		if(response.exception==undefined){
			response.forEach(function(model) {
				lmsFeedbackTypeMap[model.id]=model.title;
			});
		}		
	}).fail(function(e){
		handleError(e)		
	});










