var quizAssessmentDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=178";
var quizAssessmentDefId = 178;
var quizAssessmentBaseUrl = "/api/jsonws/lms.quizassessment";

var QuizAssessment = Backbone.Model.extend({
	quizel : 'Quiz Assessment',
	icon : '$ModelIconUrl$',
	visible : {
		"courseId" : {
			"type" : "Select",
			"title" : "Course",
			"validators" : [ "required" ],
			"options" : "<Course>",
			"fieldclass" : 0
		},
		"lessonId" : {
			"type" : "Select",
			"title" : "Lesson",
			"validators" : [ "required" ],
			"options" : "<Lesson>",
			"fieldclass" : 0
		},
		"quizId" : {
			"type" : "Select",
			"title" : "Quiz",
			"validators" : [ "required" ],
			"options" : "<Quiz>",
			"fieldclass" : 0
		},
		"passingScore" : {
			"title" : "Passing Score",
			"type" : "Text",
			"validators" : [ "required", "number" ]
		},
		"noOfQuesPerLesson" : {
			"title" : "No Of Question",
			"type" : "Text",
			"validators" : [ "required", "number" ]
		},
		"noOfAttempt" : {
			"title" : "No Of Attempt",
			"type" : "Text",
			"validators" : [ "required", "number" ]
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-quizassessment'),
	url : quizAssessmentBaseUrl + "/find",
	create : function() {
		this.url = quizAssessmentBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function() {
		return quizAssessmentBaseUrl + "/create";
	},
	update : function() {
		this.url = quizAssessmentBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function() {
		return quizAssessmentBaseUrl + "/update";
	},
	remove : function() {
		this.url = quizAssessmentBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	publishQuizAssessment : function(quizAssessmentId) {
		this.url = quizAssessmentBaseUrl + "/publish-quiz-assessment";
		this.attributes['quizAssessmentId'] = quizAssessmentId;
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('assessmentLevel');
	}
});

var QuizAssessmentCollection = Backbone.Collection.extend({
	model : QuizAssessment,
	url : quizAssessmentBaseUrl + "/find-all-quiz-assessment-tab",
	localStorage : new Backbone.LocalStorage('tbl-quizassessment'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	}
});
var QuizAssessmentCreateForm = Backbone.Form.extend({
	schema : {
		"courseId" : {
			"type" : "Select",
			"title" : "Course",
			"validators" : [ "required" ],
			"options" : new CourseCollection(),
			"editorClass" : "form-control"
		},
		"lessonId" : {
			"type" : "Select",
			"title" : "Lesson",
			"validators" : [ "required" ],
			"options" : new LessonCollection(),
			"editorClass" : "form-control"
		},
		"quizId" : {
			"type" : "Select",
			"title" : "Quiz",
			"validators" : [ "required" ],
			"options" : new QuizCollection(),
			"editorClass" : "form-control"
		},
		"passingScore" : {
			"title" : "Passing Score",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: '33',"maxlength" : 5}
		},
		"noOfQuesPerLesson" : {
			"title" : "no of Question",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: '3',"maxlength" : 5}
		},
		"noOfAttempt" : {
			"title" : "No of Attempt",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: '5',"maxlength" : 5}
		}
	}
});

var QuizAssessmentEditForm = Backbone.Form.extend({
	schema : {
		"courseId" : {
			"type" : "Select",
			"title" : "Course",
			"validators" : [ "required" ],
			"options" : new CourseCollection(),
			"editorClass" : "form-control"
		},
		"lessonId" : {
			"type" : "Select",
			"title" : "Lesson",
			"validators" : [ "required" ],
			"options" : new LessonCollection(),
			"editorClass" : "form-control"
		},
		"quizId" : {
			"type" : "Select",
			"title" : "Quiz",
			"validators" : [ "required" ],
			"options" : new QuizCollection(),
			"editorClass" : "form-control"
		},
		"passingScore" : {
			"title" : "Passing Score",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: '33',"maxlength" : 5}
		},
		"noOfQuesPerLesson" : {
			"title" : "No of Question",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: '3',"maxlength" : 5}
		},
		"noOfAttempt" : {
			"title" : "No of Attempt",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: '5',"maxlength" : 5}
		}
	}
});

