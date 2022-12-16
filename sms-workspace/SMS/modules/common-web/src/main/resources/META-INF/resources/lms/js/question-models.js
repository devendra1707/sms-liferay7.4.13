		var  questionDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=174";
		var 	 questionDefId = 174;
		var  questionBaseUrl = "/api/jsonws/lms.question";

		var Question = Backbone.Model.extend({
		label:'Question',
		icon:'$ModelIconUrl$',
		visible: {
			"courseId":{"type":"Select","title":"Select Course","validators":["required"],"options":new CourseCollection(),"fieldclass":0},
			"lessonId":{"type":"Select","title":"Select Lesson","validators":["required"],"options":new LessonCollection(),"fieldclass":0},
			"type": { "type":"Select", "title":"Type", "validators":["required"], "options":["MCQ","MMCQ"], "regexp":0, "fieldclass":0},
			"question": { "type":"Text", "title":"Question", "validators":["required"], "options":"", "regexp":0, "fieldclass":0},
			"hint": { "type":"Text", "title":"Hint", "options":"", "regexp":0, "fieldclass":0},
			"testType": { "type":"Select", "title":"Test Type", "validators":["required"], "options":["PRETEST","POSTTEST"], "regexp":0, "fieldclass":0},
			"assessmentDuration": { "type":"Text", "title":"Duration(In Sec)", "validators":["number","required"], "options":"", "regexp":0, "fieldclass":0}
		},
	    localStorage: new Backbone.LocalStorage('tbl-question'),
	    url: questionBaseUrl + "/find",
	    create:function (optionJson,answerJson,courseId,lessonId,testType){
	    	
	    	this.url=questionBaseUrl + "/create";
	    	this.attributes["optionJson"] = optionJson;
	    	this.attributes["answerJson"] = answerJson;
	    	this.attributes["courseId"] = courseId;
	    	this.attributes["lessonId"] = lessonId;
	    	this.attributes["testType"] = testType;
	    	return Backbone.ajaxSync('create', this);
	    },
		createUrl:function (){
			return questionBaseUrl + "/create";
	    },
	    update:function (optionJson,answerJson,courseId,lessonId,testType){
	    		this.url=questionBaseUrl + "/update";
	    		this.attributes["optionJson"] = optionJson;
		    	this.attributes["answerJson"] = answerJson;
		    	this.attributes["courseId"] = courseId;
		    	this.attributes["lessonId"] = lessonId;
		    	this.attributes["testType"] = testType;
	    		return Backbone.ajaxSync('create', this);
	    },
	    updateUrl:function (){
	    		return questionBaseUrl + "/update";
	    },
	    remove:function (){
	    	this.url=questionBaseUrl + "/delete";
	    	return Backbone.ajaxSync('create', this);
	    },
	    toString: function() {
        	return this.get('question');
    	}
	});
	
	var QuestionCollection = Backbone.Collection.extend({
		model: Question,
		url: questionBaseUrl + "/find-all",
	    localStorage: new Backbone.LocalStorage('tbl-question'),
	    download: function(filter){
	    	return Backbone.ajaxSync('read', this);
	    }
	});
	
	var QuestionsCollection = Backbone.Collection.extend({
		model: Question,
		url: questionBaseUrl + "/find-all-questions",
	    localStorage: new Backbone.LocalStorage('tbl-question'),
	    download: function(filter){
	    	return Backbone.ajaxSync('read', this);
	    },
	    findQuestionsByLesson: function(filter){
	     	this.url=questionBaseUrl + "/find-questions-by-lesson";
	     	this.attributes["lessonId"] = lessonId;
	    	return Backbone.ajaxSync('create', this);
	    }
	});
	
	/*var QuestionCreateForm = Backbone.Form.extend({
		schema: {"type":{"type":"Select","title":"Type","validators":["required"],"options":["MCQ","MMCQ","FIB","MTC"],"fieldclass":0},"question":{"type":"Text","title":"Question","validators":["required"],"fieldclass":0},"answer":{"type":"Text","title":"Answer","validators":["required"],"fieldclass":0},"options":{"type":"Select","title":"Options","validators":["required"],"options":["Yes","No"],"fieldclass":0}}
	});*/
	var QuestionCreateForm = Backbone.Form.extend({
		schema: {
			"type": { "type":"Select", "title":"Type", "validators":["required"], "options":["MCQ","MMCQ"], "regexp":0, "fieldclass":0},
			"question": { "type":"TextArea", "title":"Question", "validators":["required"], "options":"", "regexp":0, "fieldclass":0},
			"hint": { "type":"TextArea", "title":"Hint", "options":"", "regexp":0, "fieldclass":0},
			"assessmentDuration": { "type":"Text", "title":"Duration (In Sec)", "validators":["number","required"], "options":"", "regexp":0, "fieldclass":0}
			}
	});
	
	var QuestionEditForm = Backbone.Form.extend({
		schema: {
			"id":{"title":"ID","type":"Hidden"},
			"type": { "type":"Select", "title":"Type", "validators":["required"], "options":["MCQ","MMCQ"], "regexp":0, "fieldclass":0},
			"question": { "type":"TextArea", "title":"Question", "validators":["required"], "options":"", "regexp":0, "fieldclass":0},
			"hint": { "type":"TextArea", "title":"Hint", "options":"", "regexp":0, "fieldclass":0},
			"assessmentDuration": { "type":"Text", "title":"Duration (In Sec)", "validators":["number","required"], "options":"", "regexp":0, "fieldclass":0}
				}
	});
	
	
