var quizQuestionBaseUrl = "/api/jsonws/lms.quizquestion";

var QuizQuestion = Backbone.Model.extend({
	label : 'QuizQuestion',
	icon : '$ModelIconUrl$',
	visible : {
		"localeCode" : {
			"title" : "Select Language",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"courseId" : {
			"type" : "Select",
			"title" : "Select Course",
			"validators" : [ "required" ],
			"options" : new CourseCollection(),
			"fieldclass" : 0
		},
		"question" : {
			"type" : "Text",
			"title" : "Question",
			"validators" : [ "required" ],
			"options" : "",
			"regexp" : 0,
			"fieldclass" : 0
		},
		"hint" : {
			"type" : "Text",
			"title" : "Hint",
			"options" : "",
			"regexp" : 0,
			"fieldclass" : 0
		},
		"type" : {
			"type" : "Select",
			"title" : "Type",
			"validators" : [ "required" ],
			"options" : [ "MCQ", "MMCQ" ],
			"regexp" : 0,
			"fieldclass" : 0
		},
		"assessmentCategoryTitle" : {
			"title" : "Assessment Category Title",
			"type" : "Text"
		}

	},
	localStorage : new Backbone.LocalStorage('tbl-quizquestion'),
	url : quizQuestionBaseUrl + "/find",
	create : function(courseId, type, optionJson, answerJson) {
		this.url = quizQuestionBaseUrl + "/create-quiz-question";
		this.attributes["courseId"] = courseId;
		this.attributes["optionJson"] = optionJson;
		this.attributes["answerJson"] = answerJson;
		this.attributes["type"] = type;
		return Backbone.ajaxSync('create', this);
	},
	update : function(courseId, type, optionJson, answerJson) {
		this.url = quizQuestionBaseUrl + "/update-quiz-question";
		this.attributes["courseId"] = courseId;
		this.attributes["optionJson"] = optionJson;
		this.attributes["answerJson"] = answerJson;
		this.attributes["type"] = type;
		return Backbone.ajaxSync('create', this);
	},
	remove : function() {
		this.url = quizQuestionBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('quizQuestion');
	},
	importQuestionList : function() {
		return quizQuestionBaseUrl + "/import-question-list";
	},
	findByLocaleCode : function(id, localeCode) {
		this.url = quizQuestionBaseUrl + "/find-by-locale-code";
		this.attributes["id"] = id;
		this.attributes["localeCode"] = localeCode;
		return Backbone.ajaxSync('create', this);
	}
});

var QuizQuestionCollection = Backbone.Collection.extend({
	model : QuizQuestion,
	url : quizQuestionBaseUrl + "/find-all-quizQuestions",
	localStorage : new Backbone.LocalStorage('tbl-quizQuestion'),
	download : function(courseId, testType, localeCode) {
		this.url = quizQuestionBaseUrl + "/find-all-questions?courseId="
				+ courseId + "&localeCode=" + localeCode;
		return Backbone.ajaxSync('read', this);
	},
	findByLesson : function(lessonId, localeCode) {
		this.url = quizQuestionBaseUrl + "/find-all-questions-of-lesson?lessonId="
				+ lessonId + "&localeCode=" + localeCode;
		return Backbone.ajaxSync('read', this);
	},
	findByQuiz : function(quizId, localeCode) {
		this.url = quizQuestionBaseUrl + "/find-all-questions-of-quiz?quizId="
				+ quizId + "&localeCode=" + localeCode;
		return Backbone.ajaxSync('read', this);
	}
});

/*
 * var QuizQuestionCreateForm = Backbone.Form.extend({ schema:
 * {"type":{"type":"Select","title":"Type","validators":["required"],"options":["MCQ","MMCQ","FIB","MTC"],"fieldclass":0},"quizQuestion":{"type":"Text","title":"QuizQuestion","validators":["required"],"fieldclass":0},"answer":{"type":"Text","title":"Answer","validators":["required"],"fieldclass":0},"options":{"type":"Select","title":"Options","validators":["required"],"options":["Yes","No"],"fieldclass":0}}
 * });
 */
var QuizQuestionCreateForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
			"title" : "Select Language",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"question" : {
			"type" : "TextArea",
			"title" : "Question",
			"validators" : [ "required" ],
			"options" : "",
			"regexp" : 0,
			"fieldclass" : 0,
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Enter Hint...',
				rows : '10'
			}
		},
		"hint" : {
			"type" : "TextArea",
			"title" : "Hint",
			"options" : "",
			"regexp" : 0,
			"fieldclass" : 0,
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Enter QuizQuestion...',
				rows : '10'
			}
		}
	}
});

var QuizQuestionEditForm = Backbone.Form.extend({
	schema : {
		"id" : {
			"title" : "ID",
			"type" : "Hidden"
		},
		"localeCode" : {
			"title" : "Select Language",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"question" : {
			"type" : "TextArea",
			"title" : "Question",
			"validators" : [ "required" ],
			"options" : "",
			"regexp" : 0,
			"fieldclass" : 0,
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Enter Hint...',
				rows : '10'
			}
		},
		"hint" : {
			"type" : "TextArea",
			"title" : "Hint",
			"options" : "",
			"regexp" : 0,
			"fieldclass" : 0,
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Enter QuizQuestion...',
				rows : '10'
			}
		}
	}
});


var QuizQuestionImportForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
			"title" : "Select Language",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"quizQuestionData" : {
			"title" : "Import File",
			"type" : "UploadExcelFilePicker",
			"help" : ".xls file only"
		},
		"courseId" : {
			"title" : "Course",
			"type" : "Hidden"
		},
		"lessonId" : {
			"title" : "Lesson",
			"type" : "Hidden"
		},
		"quizId" : {
			"title" : "Quiz",
			"type" : "Hidden"
		}
	}
});