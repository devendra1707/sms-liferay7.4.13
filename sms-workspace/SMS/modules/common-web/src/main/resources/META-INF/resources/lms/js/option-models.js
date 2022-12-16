		var  OptionItemDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=168";
		var 	 OptionItemDefId = 168;
		var  optionItemBaseUrl = "/api/jsonws/lms.optionitem";
		var  quizOptionItemBaseUrl = "/api/jsonws/lms.quizquesoption";

		var OptionItem = Backbone.Model.extend({
		label:'OptionItem',
		icon:'$ModelIconUrl$',
		visible: {
			"title":{"type":"Text","title":"Title","validators":["required"],"fieldclass":0},
			"value":{"type":"Text","title":"Value","validators":["required"],"fieldclass":0}
		},
	    localStorage: new Backbone.LocalStorage('tbl-OptionItem'),
	    url: optionItemBaseUrl + "/find",
	    create:function (){
	    	this.url=optionItemBaseUrl + "/create";
	    	return Backbone.ajaxSync('create', this);
	    },
		createUrl:function (){
			return optionItemBaseUrl + "/create";
	    },
	    update:function (){
	    		this.url=optionItemBaseUrl + "/update";
	    		return Backbone.ajaxSync('create', this);
	    },
	    updateUrl:function (){
	    		return optionItemBaseUrl + "/update";
	    },
	    remove:function (){
	    	this.url=optionItemBaseUrl + "/delete";
	    	return Backbone.ajaxSync('create', this);
	    },
	    toString: function() {
        	return this.get('title');
    	}
	});
		
	var OptionItemCollection = Backbone.Collection.extend({
		model: OptionItem,
		url: optionItemBaseUrl + "/find-all",
	    localStorage: new Backbone.LocalStorage('tbl-optionItem'),
	    download: function(filter){
	    	return Backbone.ajaxSync('read', this);
	    }
	
	});
	
	var OptionCollectionByQuestionId = Backbone.Collection.extend({
		model: OptionItem,
		url: optionItemBaseUrl + "/find-by-question-id",
	    localStorage: new Backbone.LocalStorage('tbl-optionItem'),
	    download: function(questionId,defaultLocaleCode){
	    	this.url= optionItemBaseUrl + "/find-by-question-id?questionId="+questionId+"&localeCode="+defaultLocaleCode;
	    	return Backbone.ajaxSync('read', this);
	    }
	
	});
	var QuizOptionCollectionByQuestionId = Backbone.Collection.extend({
		model: OptionItem,
		url: quizOptionItemBaseUrl + "/find-by-quiz-ques-id",
	    localStorage: new Backbone.LocalStorage('tbl-optionItem'),
	    download: function(questionId,defaultLocaleCode){
	    	this.url= quizOptionItemBaseUrl + "/find-by-quiz-ques-id?quizQuesId="+questionId+"&localeCode="+defaultLocaleCode;;
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