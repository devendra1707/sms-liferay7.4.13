var questionDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=174";
var questionDefId = 174;
var questionBaseUrl = "/api/jsonws/lms.question";

var Question = Backbone.Model.extend({
	label : 'Question',
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
		"lessonId" : {
			"type" : "Select",
			"title" : "Select Lesson",
			"validators" : [ "required" ],
			"options" : new LessonCollection(),
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
		"difficultyLevelId" : {
			"title" : "Select Difficulty Level",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new DifficultyLevelCollection(),
			"editorClass" : "form-control"
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
		"testType" : {
			"type" : "Select",
			"title" : "Test Type",
			"validators" : [ "required" ],
			"options" : [ "PRETEST", "POSTTEST" ],
			"regexp" : 0,
			"fieldclass" : 0
		},
	/* lab hide "questionType" : {
			"type" : "Select",
			"title" : "Question Type",
			"options" : [ "Topic", "Lab" ],
			"regexp" : 0,
			"fieldclass" : 0
		},*/
		"questionType" : {
			"type" : "Select",
			"title" : "Question Type",
			"options" : [ "Topic" ],
			"regexp" : 0,
			"fieldclass" : 0
		},
		/* lab hide "labId" : {
			"title" : "Select Lab",
			"type" : "Select",
			"options" : new LabCollection()
		},*/
		"labId" : {
			"title" : "Select Lab",
			"type" : "Hidden"
		},
		"assessmentCategoryTitle" : {
			"title" : "Assessment Category Title",
			"type" : "Text"
		}

	},
	localStorage : new Backbone.LocalStorage('tbl-question'),
	url : questionBaseUrl + "/find",
	create : function(courseId, testType, type, optionJson, answerJson) {
		this.url = questionBaseUrl + "/create-v3";
		this.attributes["courseId"] = courseId;
		this.attributes["testType"] = testType;
		this.attributes["type"] = type;
		this.attributes["optionJson"] = optionJson;
		this.attributes["answerJson"] = answerJson;
		if (this.attributes["questionType"] == "Topic"
				&& this.attributes["labId"] == "") {
			this.attributes["labId"] = 0;
		}
		return Backbone.ajaxSync('create', this);
	},
	update : function(courseId, testType, type, optionJson, answerJson) {
		this.url = questionBaseUrl + "/update-v3";
		this.attributes["courseId"] = courseId;
		this.attributes["testType"] = testType;
		this.attributes["type"] = type;
		this.attributes["optionJson"] = optionJson;
		this.attributes["answerJson"] = answerJson;
		if (this.attributes["questionType"] == "Topic"
				&& this.attributes["labId"] == "") {
			this.attributes["labId"] = 0;
		}
		return Backbone.ajaxSync('create', this);
	},
	remove : function() {
		this.url = questionBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('question');
	},
	importQuestionList : function() {
		return questionBaseUrl + "/import-question-list";
	},
	findByLocaleCode : function(id, localeCode) {
		this.url = questionBaseUrl + "/find-by-locale-code";
		this.attributes["id"] = id;
		this.attributes["localeCode"] = localeCode;
		return Backbone.ajaxSync('create', this);
	}
});

var QuestionCollection = Backbone.Collection.extend({
	model : Question,
	url : questionBaseUrl + "/find-all-questions",
	localStorage : new Backbone.LocalStorage('tbl-question'),
	download : function(courseId, testType, localeCode) {
		this.url = questionBaseUrl + "/find-all-questions-v2?courseId="
				+ courseId + "&testType=" + testType + "&localeCode="
				+ localeCode;
		return Backbone.ajaxSync('read', this);
	}
});

/*
 * var QuestionCreateForm = Backbone.Form.extend({ schema:
 * {"type":{"type":"Select","title":"Type","validators":["required"],"options":["MCQ","MMCQ","FIB","MTC"],"fieldclass":0},"question":{"type":"Text","title":"Question","validators":["required"],"fieldclass":0},"answer":{"type":"Text","title":"Answer","validators":["required"],"fieldclass":0},"options":{"type":"Select","title":"Options","validators":["required"],"options":["Yes","No"],"fieldclass":0}}
 * });
 */
var QuestionCreateForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
			"title" : "Select Language",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"lessonId" : {
			"title" : "Select Lesson",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new LessonCollection(),
			"editorClass" : "form-control"
		},
		"difficultyLevelId" : {
			"title" : "Select Difficulty Level",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new DifficultyLevelCollection(),
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
				placeholder : 'Enter Question...',
				rows : '10'
			}
		},
		/* lab hide "questionType" : {
			"type" : "Select",
			"title" : "Question Type",
			"options" : [ {
				"val" : "Topic",
				"label" : "Topic"
			}, {
				"val" : "Lab",
				"label" : "Lab"
			} ],
			"regexp" : 0,
			"fieldclass" : 0,
			"editorClass" : "form-control"
		},*/
		"questionType" : {
			"type" : "Select",
			"title" : "Question Type",
			"options" : [ {
				"val" : "Topic",
				"label" : "Topic"
			}],
			"regexp" : 0,
			"fieldclass" : 0,
			"editorClass" : "form-control"
		},
		/* lab hide "labId" : {
			"title" : "Select Lab",
			"type" : "Select",
			"options" : new LabCollection(),
			"editorClass" : "form-control"
		},*/
		"labId" : {
			"title" : "Select Lab",
			"type" : "Hidden",
		},
		"contentType" : {
			"type" : "Select",
			"title" : "Select Content Type",
			"options" : [ {
				"val" : "Instruction",
				"label" : "Instruction"
			}, {
				"val" : "Question",
				"label" : "Question"
			} ],
			"regexp" : 0,
			"fieldclass" : 0,
			"editorClass" : "form-control"
		},
		"instructionText" : {
			"type" : "TextArea",
			"title" : "Instruction",
			"options" : "",
			"regexp" : 0,
			"fieldclass" : 0,
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Enter Instruction...',
				rows : '10'
			}
		}

	}
});

var QuestionEditForm = Backbone.Form.extend({
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
		"lessonId" : {
			"title" : "Select Lesson",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new LessonCollection(),
			"editorClass" : "form-control"
		},
		"difficultyLevelId" : {
			"title" : "Select Difficulty Level",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new DifficultyLevelCollection(),
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
				placeholder : 'Enter Question...',
				rows : '10'
			}
		},
		/* lab hide "questionType" : {
			"type" : "Select",
			"title" : "Question Type",
			"options" : [ {
				"val" : "Topic",
				"label" : "Topic"
			}, {
				"val" : "Lab",
				"label" : "Lab"
			} ],
			"regexp" : 0,
			"fieldclass" : 0,
			"editorClass" : "form-control"
		},*/
		"questionType" : {
			"type" : "Select",
			"title" : "Question Type",
			"options" : [ {
				"val" : "Topic",
				"label" : "Topic"
			} ],
			"regexp" : 0,
			"fieldclass" : 0,
			"editorClass" : "form-control"
		},
		/*lab hide "labId" : {
			"title" : "Select Lab",
			"type" : "Select",
			"options" : new LabCollection(),
			"editorClass" : "form-control"
		},*/
		"labId" : {
			"title" : "Select Lab",
			"type" : "Hidden"
		},
		"contentType" : {
			"type" : "Select",
			"title" : "Select Content Type",
			"options" : [ {
				"val" : "Instruction",
				"label" : "Instruction"
			}, {
				"val" : "Question",
				"label" : "Question"
			} ],
			"regexp" : 0,
			"fieldclass" : 0,
			"editorClass" : "form-control"
		},
		"instructionText" : {
			"type" : "TextArea",
			"title" : "Instruction",
			"options" : "",
			"regexp" : 0,
			"fieldclass" : 0,
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Enter Instruction...',
				rows : '10'
			}
		}
	}
});

var labQuestionBaseUrl = "/api/jsonws/lms.labquestion";
var studentLabPracticeBaseUrl = "/api/jsonws/lms.studentlabpractice";
var studentLabScoreBaseUrl = "/api/jsonws/lms.studentlabscore";

var LabQuestion = Backbone.Model.extend({
	label : 'LabQuestion',
	icon : '$ModelIconUrl$',
	idAttribute : 'id',
	visible : {
		"localeCode" : {
			"title" : "Select Language",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"lessonId" : {
			"title" : "Select Lesson",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new LessonCollection(),
			"editorClass" : "form-control"
		},
		"labId" : {
			"title" : "Select Lab",
			"type" : "Select",
			"options" : new LabCollection(),
			"validators" : [ "required" ],
			"editorClass" : "form-control"
		},
		"contentType" : {
			"type" : "Select",
			"title" : "Select Content Type",
			"validators" : [ "required" ],
			"options" : [ {
				"val" : "Instruction",
				"label" : "Instruction"
			}, {
				"val" : "Question",
				"label" : "Question"
			} ],
			"regexp" : 0,
			"fieldclass" : 0,
			"editorClass" : "form-control"
		},
		"content" : {
			"type" : "TextArea",
			"title" : "Question / Instruction",
			"options" : "",
			"regexp" : 0,
			"fieldclass" : 0,
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Enter Question / Instruction ...',
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
				placeholder : 'Enter Question...',
				rows : '10'
			}
		},
		"sequenceNo" : {
			"type" : "Text",
			"title" : "Sequence Number",
			"validators" : [ "required", "number" ],
			"options" : "",
			"regexp" : 0,
			"fieldclass" : 0,
			"editorClass" : "form-control"
		},
		"contentImgUrl" : {
			"title" : "Image Content",
			"type" : "ImagePicker"
		}

	},
	localStorage : new Backbone.LocalStorage('tbl-labquestion'),
	url : labQuestionBaseUrl + "/find",
	create : function(courseId, lessonId, labId, type, optionJson, answerJson) {
		this.url = labQuestionBaseUrl + "/create-lab-question";
		this.attributes["courseId"] = courseId;
		this.attributes["lessonId"] = lessonId;
		this.attributes["labId"] = labId;
		if (type == undefined) {
			this.attributes["type"] = "";
		} else {
			this.attributes["type"] = type;
		}
		this.attributes["optionJson"] = optionJson;
		this.attributes["answerJson"] = answerJson;
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function() {
		return labQuestionBaseUrl + "/create-lab-question";
	},
	update : function(courseId, lessonId, labId, type, optionJson, answerJson) {
		this.url = labQuestionBaseUrl + "/update-lab-question";
		this.attributes["courseId"] = courseId;
		this.attributes["lessonId"] = lessonId;
		this.attributes["labId"] = labId;
		if (type == undefined) {
			this.attributes["type"] = "";
		} else {
			this.attributes["type"] = type;
		}
		this.attributes["optionJson"] = optionJson;
		this.attributes["answerJson"] = answerJson;
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function() {
		return labQuestionBaseUrl + "/update-lab-question";
	},
	remove : function() {
		this.url = labQuestionBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('question');
	},
	findByLocaleCode : function(id, localeCode) {
		this.url = labQuestionBaseUrl + "/find-by-locale-code";
		this.attributes["id"] = id;
		this.attributes["localeCode"] = localeCode;
		return Backbone.ajaxSync('create', this);
	},
	createStudentLabPractice : function(labId) {
		this.url = studentLabPracticeBaseUrl + "/create-student-lab-practice";
		this.attributes["labId"] = labId;
		return Backbone.ajaxSync('create', this);
	},
	updateStudentLabPractice : function(labId, questionAttempt) {
		this.url = studentLabPracticeBaseUrl + "/update-student-lab-practice";
		this.attributes["labId"] = labId;
		this.attributes["questionAttempt"] = questionAttempt;
		return Backbone.ajaxSync('create', this);
	},
	submitStudentLabPractice : function(labId, questionAttempt) {
		this.url = studentLabPracticeBaseUrl + "/submit-student-lab-practice";
		this.attributes["labId"] = labId;
		this.attributes["questionAttempt"] = questionAttempt;
		return Backbone.ajaxSync('create', this);
	},
	checkTimeRemaining : function(labId) {
		this.url = studentLabPracticeBaseUrl + "/check-time-remaining";
		this.attributes["labId"] = labId;
		return Backbone.ajaxSync('create', this);
	},
	getStudentLabScore : function(labId) {
		this.url = studentLabScoreBaseUrl + "/find-student-lab-score";
		this.attributes["labId"] = labId;
		return Backbone.ajaxSync('create', this);
	},
	updateReattempt : function(selectedStudentLabScoreId,reattempt) {
		this.url = studentLabScoreBaseUrl + "/update-reattempt";
		this.attributes["id"] = selectedStudentLabScoreId;
		this.attributes["reattempt"] = reattempt;
		return Backbone.ajaxSync('create', this);
	},
	updateWalkthrough : function(selectedStudentLabScoreId,walkthroughUsed) {
		this.url = studentLabScoreBaseUrl + "/update-walkthrough";
		this.attributes["id"] = selectedStudentLabScoreId;
		this.attributes["walkthroughUsed"] = walkthroughUsed;
		return Backbone.ajaxSync('create', this);
	},
	updateHint : function(selectedStudentLabScoreId,hintUsed) {
		this.url = studentLabScoreBaseUrl + "/update-hint";
		this.attributes["id"] = selectedStudentLabScoreId;
		this.attributes["hintUsed"] = hintUsed;
		return Backbone.ajaxSync('create', this);
	},
	checkIfQuestionsReadyForStudentPractice: function(labId) {
		this.url = labQuestionBaseUrl + "/check-if-questions-ready-for-student-practice";
		this.attributes["labId"] = labId;
		return Backbone.ajaxSync('create', this);
	},
	importLabQuestions : function() {
		return labQuestionBaseUrl + "/import-lab-questions";
	},
	createStudentLabScore : function(labId) {
		this.url = studentLabPracticeBaseUrl + "/create-student-lab-score";
		this.attributes["labId"] = labId;
		return Backbone.ajaxSync('create', this);
	},
	updateLabQuestionPosition : function(id,position) {
		this.url = labQuestionBaseUrl + "/update-lab-question-position";
		this.attributes["id"] = id;
		this.attributes["position"] = position;
		return Backbone.ajaxSync('create', this);
	},
	updateWithDeleteImage : function() {
		return labQuestionBaseUrl + "/update-lab-question-with-delete-image";
	}
});

var LabQuestionCollection = Backbone.Collection.extend({
	model : LabQuestion,
	url : labQuestionBaseUrl + "/find-all-questions",
	localStorage : new Backbone.LocalStorage('tbl-labquestion'),
	download : function(localeCode) {
		this.url = labQuestionBaseUrl + "/find-all-questions";
		return Backbone.ajaxSync('read', this);
	},
	findAllQuestionsByLab : function(labId, localeCode) {
		this.url = labQuestionBaseUrl + "/find-all-questions-by-lab?labId="
				+ labId + "&localeCode=" + localeCode;
		return Backbone.ajaxSync('read', this);
	},
	findAllQuestionsForStudentPractice : function(labId) {
		this.url = labQuestionBaseUrl + "/find-all-questions-for-student-practice?labId="
				+ labId;
		return Backbone.ajaxSync('read', this);
	},
	findAllQuestionsForStudentPracticeReview : function(labId) {
		this.url = labQuestionBaseUrl + "/find-all-questions-for-student-practice-review?labId="
		+ labId;
		return Backbone.ajaxSync('read', this);
	},
	comparator : function(a) {
		return a.get('sequenceNo');
	}
});

/*
 * var QuestionCreateForm = Backbone.Form.extend({ schema:
 * {"type":{"type":"Select","title":"Type","validators":["required"],"options":["MCQ","MMCQ","FIB","MTC"],"fieldclass":0},"question":{"type":"Text","title":"Question","validators":["required"],"fieldclass":0},"answer":{"type":"Text","title":"Answer","validators":["required"],"fieldclass":0},"options":{"type":"Select","title":"Options","validators":["required"],"options":["Yes","No"],"fieldclass":0}}
 * });
 */
var LabQuestionCreateForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
			"title" : "Select Language",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"lessonId" : {
			"title" : "Select Lesson",
			"type" : "Select",
			"options" : new LessonCollection(),
			"editorClass" : "form-control"
		},
		"labId" : {
			"title" : "Select Lab",
			"type" : "Select",
			"options" : new LabCollection(),
			"editorClass" : "form-control"
		},
		"contentType" : {
			"type" : "Select",
			"title" : "Select Content Type",
			"validators" : [ "required" ],
			"options" : [ {
				"val" : "Instruction",
				"label" : "Instruction"
			}, {
				"val" : "Question",
				"label" : "Question"
			} ],
			"regexp" : 0,
			"fieldclass" : 0,
			"editorClass" : "form-control"
		},
		"content" : {
			"type" : "TextArea",
			"title" : "Question / Instruction",
			"options" : "",
			"regexp" : 0,
			"fieldclass" : 0,
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Enter Question / Instruction...',
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
				placeholder : 'Enter Hint...',
				rows : '10'
			}
		},
		"sequenceNo" : {
			"type" : "Text",
			"title" : "Sequence Number",
			"validators" : [ "required", "number" ],
			"options" : "",
			"regexp" : 0,
			"fieldclass" : 0,
			"editorClass" : "form-control"
		}, 
		"contentImgUrl" : {
			"title" : "Image Content",
			"type" : "ImagePicker",
			"help" : ".png, .jpg, .gif, .svg files only upto 1MB",
			"editorClass" : "input-file"
		}
	}
});

var LabQuestionEditForm = Backbone.Form.extend({
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
		"lessonId" : {
			"title" : "Select Lesson",
			"type" : "Select",
			"options" : new LessonCollection(),
			"editorClass" : "form-control"
		},
		"labId" : {
			"title" : "Select Lab",
			"type" : "Select",
			"options" : new LabCollection(),
			"editorClass" : "form-control"
		},
		"contentType" : {
			"type" : "Select",
			"title" : "Select Content Type",
			"validators" : [ "required" ],
			"options" : [ {
				"val" : "Instruction",
				"label" : "Instruction"
			}, {
				"val" : "Question",
				"label" : "Question"
			} ],
			"regexp" : 0,
			"fieldclass" : 0,
			"editorClass" : "form-control"
		},
		"content" : {
			"type" : "TextArea",
			"title" : "Question / Instruction",
			"options" : "",
			"regexp" : 0,
			"fieldclass" : 0,
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Enter Question / Instruction...',
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
				placeholder : 'Enter Hint...',
				rows : '10'
			}
		},
		"sequenceNo" : {
			"type" : "Text",
			"title" : "Sequence Number",
			"validators" : [ "required", "number" ],
			"options" : "",
			"regexp" : 0,
			"fieldclass" : 0,
			"editorClass" : "form-control"
		}, 
		"contentImgUrl" : {
			"title" : "Image Content",
			"type" : "ShowImagePicker",
			"help" : ".png, .jpg, .gif, .svg files only upto 1MB",
			"editorClass" : "input-file"
		}
	}
});


var LabQuestionImportForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
			"title" : "Select Language",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"questionData" : {
			"title" : "Import File",
			"type" : "UploadZipFilePicker",
			"help" : "zip file only"
		},
		"courseId" : {
			"title" : "Course",
			"type" : "Hidden"
		},
		"lessonId" : {
			"title" : "Lesson",
			"type" : "Hidden"
		},
		"labId" : {
			"title" : "Lab",
			"type" : "Hidden"
		}
	}
});



var QuestionImportForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
			"title" : "Select Language",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"questionData" : {
			"title" : "Import File",
			"type" : "UploadExcelFilePicker",
			"help" : ".xls file only"
		},
		"courseId" : {
			"title" : "Course",
			"type" : "Hidden"
		},
		"testType" : {
			"title" : "Type",
			"type" : "Hidden"
		}
	}
});