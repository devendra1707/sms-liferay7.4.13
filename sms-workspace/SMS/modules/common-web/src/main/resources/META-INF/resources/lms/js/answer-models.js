		var  AnswerSetDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=168";
		var 	 AnswerSetDefId = 168;
		var  answerSetBaseUrl = "/api/jsonws/lms.answerset";
		var  quizAnswerSetBaseUrl = "/api/jsonws/lms.quizquesanswer";

		var AnswerSet = Backbone.Model.extend({
		label:'AnswerSet',
		icon:'$ModelIconUrl$',
		visible: {
			"questionId":{"type":"Hidden","value":"","title":"Select Question","validators":["required"],"options":["1","2","3","4"],"fieldclass":0},
			"optionId":{"type":"Hidden","value":"","title":"Select Option","validators":["required"],"options":["1","2","3","4"],"fieldclass":0}
		},
	    localStorage: new Backbone.LocalStorage('tbl-AnswerSet'),
	    url: answerSetBaseUrl + "/find",
	    create:function (){
	    	this.url=answerSetBaseUrl + "/create";
	    	return Backbone.ajaxSync('create', this);
	    },
		createUrl:function (){
			return answerSetBaseUrl + "/create";
	    },
	    update:function (){
	    		this.url=answerSetBaseUrl + "/update";
	    		return Backbone.ajaxSync('create', this);
	    },
	    updateUrl:function (){
	    		return answerSetBaseUrl + "/update";
	    },
	    remove:function (){
	    	this.url=answerSetBaseUrl + "/delete";
	    	return Backbone.ajaxSync('create', this);
	    },
	    toString: function() {
        	return this.get('title');
    	}
	});
		
	var AnswerSetCollection = Backbone.Collection.extend({
		model: AnswerSet,
		url: answerSetBaseUrl + "/find-all",
	    localStorage: new Backbone.LocalStorage('tbl-answerSet'),
	    download: function(filter){
	    	return Backbone.ajaxSync('read', this);
	    }
	
	});

	
	var AnswerSetCollectionByQuestionId = Backbone.Collection.extend({
		model: OptionItem,
		url: answerSetBaseUrl + "/find-by-question-id",
	    localStorage: new Backbone.LocalStorage('tbl-answerSet'),
	    download: function(questionId,defaultLocaleCode){
	    	this.url= answerSetBaseUrl + "/find-by-question-id?questionId="+questionId+"&localeCode="+defaultLocaleCode;
	    	return Backbone.ajaxSync('read', this);
	    }
	
	});
	
	var QuizAnswerSetCollectionByQuestionId = Backbone.Collection.extend({
		model: OptionItem,
		url: quizAnswerSetBaseUrl + "/find-by-quiz-ques-id",
	    localStorage: new Backbone.LocalStorage('tbl-answerSet'),
	    download: function(questionId,defaultLocaleCode){
	    	this.url= quizAnswerSetBaseUrl + "/find-by-quiz-ques-id?quizQuesId="+questionId+"&localeCode="+defaultLocaleCode;
	    	return Backbone.ajaxSync('read', this);
	    }
	
	});
	
	var OptionCreateForm = Backbone.Form.extend({
		schema: {
			"title":{"type":"Text","title":"Title","validators":["required"],"fieldclass":0},
			"value":{"type":"Text","title":"Value","validators":["required"],"fieldclass":0}
		}
	});
	
	var OptionEditForm = Backbone.Form.extend({
		schema: {
			"title":{"type":"Text","title":"Title","validators":["required"],"fieldclass":0},
			"value":{"type":"Text","title":"Value","validators":["required"],"fieldclass":0}
		}
	});