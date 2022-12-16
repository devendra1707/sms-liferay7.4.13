var quizBaseUrl = "/api/jsonws/lms.quiz";

var Quiz = Backbone.Model.extend({
	label : 'Quiz',
	icon : '$ModelIconUrl$',
	visible : {
		"localeCode" : {
		"title":"Select Language",
		"type":"Select",
		"validators":["required"],
		"options" : new LocaleInfoCollection(),
		"editorClass" : "form-control"
		},
		"title" : {
			"title" : "Quiz Name",
			"type" : "Text",
			"validators" : [ "required" ]
		},
		"summary" : {
			"title" : "Summary",
			"type" : "TextArea",
			"validators" : [ "required" ]
		},
		"courseId" : {
			"title" : "Course",
			"type" : "Hidden"
		},
		"lessonId" : {
			"title" : "Lesson",
			"type" : "Hidden"
		},
		"position" : {
			"title" : "Position",
			"type" : "Text",
			"validators" : [ "required", "number" ]
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-quiz'),
	url : quizBaseUrl + "/find",
	create : function() {
		this.url = quizBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function() {
		return quizBaseUrl + "/create";
	},
	update : function() {
		this.url = quizBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function() {
		return quizBaseUrl + "/update";
	},
	remove : function() {
		this.url = quizBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	findByLocaleCode : function(id,localeCode) {
		this.url = quizBaseUrl + "/find-by-locale-code";
		this.attributes["id"] = id;
		this.attributes["localeCode"] = localeCode;
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('title');
	}
});

var QuizCollection = Backbone.Collection.extend({
	model : Quiz,
	url : quizBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-quiz'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	},
	findByLesson : function(id,localeCode) {
		//alert(id);
		this.url = quizBaseUrl + "/find-all-in-lesson?lessonId="+id+"&localeCode="+localeCode;
		//this.attributes["lessonId"] = id;
		//this.attributes["localeCode"] = localeCode;
		return Backbone.ajaxSync('read', this);
	}
});
var QuizByCourseCollection = Backbone.Collection.extend({
	model : Quiz,
	url : quizBaseUrl + "/find-by-course-id",
	localStorage : new Backbone.LocalStorage('tbl-quiz'),
	download : function(courseId) {
		this.url = quizBaseUrl + "/find-by-course-id/course-id/" + courseId;
		return Backbone.ajaxSync('read', this);
	}

});

var QuizCreateForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
			},
		"title" : {
			"title" : "Quiz Name",
			"type" : "Text",
			"validators" : [ "required", "description" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Quiz Title'
			}
		},
		"summary" : {
			"title" : "Summary",
			"type" : "TextArea",
			"validators" : [ "required", "description" ],
			"editorClass" : "form-control",
			editorAttrs : {
				placeholder : 'Quiz Description'
			}
		},
		"position" : {
			"title" : "Position",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : '5'
			}
		},
		"courseId" : {
			"title" : "Course",
			"type" : "Hidden"
		},
		"lessonId" : {
			"title" : "Lesson",
			"type" : "Hidden"
		}
	}
});

var QuizEditForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
			},
		"title" : {
			"title" : "Quiz Name",
			"type" : "Text",
			"validators" : [ "required", "description" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Quiz Title'
			}
		},
		"summary" : {
			"title" : "Summary",
			"type" : "TextArea",
			"validators" : [ "required", "description" ],
			"editorClass" : "form-control",
			editorAttrs : {
				placeholder : 'Quiz Description'
			}
		},
		"position" : {
			"title" : "Position",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : '5'
			}
		},
		"courseId" : {
			"title" : "Course",
			"type" : "Hidden"
		},
		"lessonId" : {
			"title" : "Lesson",
			"type" : "Hidden"
		}
	}
});
