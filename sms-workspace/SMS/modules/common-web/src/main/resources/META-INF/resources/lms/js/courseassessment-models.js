var courseAssessmentDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=178";
var courseAssessmentDefId = 178;
var courseAssessmentBaseUrl = "/api/jsonws/lms.courseassessment";

var CourseAssessment = Backbone.Model.extend({
	label : 'Course Assessment',
	icon : '$ModelIconUrl$',
	visible : {
		"courseId" : {
			"type" : "Select",
			"title" : "Course",
			"validators" : [ "required" ],
			"options" : "<Course>",
			"fieldclass" : 0
		},
		"noOfQuestionsPerLesson" : {
			"type" : "Hidden",
			"title" : "Questions from Each Lesson"
		},
		"testType" : {
			"type" : "Select",
			"title" : "Test Type",
			"validators" : [ "required" ],
			"options" : [ {
				"val" : "",
				"label" : "Please Select"
			}, {
				"val" : "PRETEST",
				"label" : "PRETEST"
			}, {
				"val" : "POSTTEST",
				"label" : "POSTTEST"
			}],
			"fieldclass" : 0
		},
		"assessmentLevel" : {
			"type" : "Select",
			"title" : "Assessment Level",
			"validators" : [ "required" ],
			"options" : "<AssessmentLevel>",
			"fieldclass" : 0
		},
		"passingScore" : {
			"title" : "Passing Score",
			"type" : "Text",
			"validators" : [ "required", "number" ]
		},
		"maxNoOfAttempt" : {
			"title" : "No Of Attempt",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md"
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-courseassessment'),
	url : courseAssessmentBaseUrl + "/find",
	create : function() {
		this.url = courseAssessmentBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createV2 : function() {
		this.url = courseAssessmentBaseUrl + "/create-v2";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function() {
		return courseAssessmentBaseUrl + "/create";
	},
	update : function() {
		this.url = courseAssessmentBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	updateV2 : function() {
		this.url = courseAssessmentBaseUrl + "/update-v2";
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function() {
		return courseAssessmentBaseUrl + "/update";
	},
	remove : function() {
		this.url = courseAssessmentBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	publishCourseAssessment : function(courseAssessmentId) {
		this.url = courseAssessmentBaseUrl + "/publish-course-assessment";
		this.attributes['courseAssessmentId'] = courseAssessmentId;
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('assessmentLevel');
	},
	updateStatus:function (){
    	this.url = courseAssessmentBaseUrl + "/update-status";
    	return Backbone.ajaxSync('create', this);
    }
});

var CourseAssessmentCollection = Backbone.Collection.extend({
	model : CourseAssessment,
	url : courseAssessmentBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-courseassessment'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	}
});
var CourseAssessmentsCollection = Backbone.Collection.extend({
	model : CourseAssessment,
	url : courseAssessmentBaseUrl + "/find-all-course-assessment",
	localStorage : new Backbone.LocalStorage('tbl-courseassessment'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	}
});

var CourseAssessmentTabCollection = Backbone.Collection.extend({
	model : CourseAssessment,
	url : courseAssessmentBaseUrl + "/find-all-course-assessment-tab",
	localStorage : new Backbone.LocalStorage('tbl-courseassessment'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	}
});

var CourseAssessmentCreateForm = Backbone.Form.extend({
	schema : {
		"courseId" : {
			"type" : "Select",
			"title" : "Course",
			"validators" : [ "required" ],
			"options" : new CourseCollection(),
			"editorClass" : "form-control"
		},
		"noOfQuestionsPerLesson" : {
			"type" : "Hidden",
			"title" : "Questions from Each Lesson"
		},
		"testType" : {
			"type" : "Select",
			"title" : "Test Type",
			"validators" : [ "required" ],
			"options" : [ {
				"val" : "",
				"label" : "Please Select"
			}, {
				"val" : "PRETEST",
				"label" : "PRETEST"
			}, {
				"val" : "POSTTEST",
				"label" : "POSTTEST"
			} ],
			"editorClass" : "form-control"
		},
		"assessmentLevel" : {
			"type" : "Select",
			"title" : "Assessment Level",
			"validators" : [ "required" ],
			"options" : new AssessmentLevelCollection(),
			"editorClass" : "form-control"
		},
		"passingScore" : {
			"title" : "Passing Score",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : '33',
				"maxlength" : 5
			}
		},
		"maxNoOfAttempt" : {
			"title" : "No Of Attempt",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md"
		}
	}
});

var CourseAssessmentEditForm = Backbone.Form.extend({
	schema : {
		"courseId" : {
			"type" : "Select",
			"title" : "Course",
			"validators" : [ "required" ],
			"options" : new CourseCollection(),
			"editorClass" : "form-control"
		},
		"noOfQuestionsPerLesson" : {
			"type" : "Hidden",
			"title" : "Questions from Each Lesson"
		},
		"testType" : {
			"type" : "Select",
			"title" : "Test Type",
			"validators" : [ "required" ],
			"options" : [ {
				"val" : "",
				"label" : "Please Select"
			}, {
				"val" : "PRETEST",
				"label" : "PRETEST"
			}, {
				"val" : "POSTTEST",
				"label" : "POSTTEST"
			} ],
			"editorClass" : "form-control"
		},
		"assessmentLevel" : {
			"type" : "Select",
			"title" : "Assessment Level",
			"validators" : [ "required" ],
			"options" : new AssessmentLevelCollection(),
			"editorClass" : "form-control"
		},
		"passingScore" : {
			"title" : "Passing Score",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : '33',
				"maxlength" : 5
			}
		},
		"maxNoOfAttempt" : {
			"title" : "No Of Attempt",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md"
		}
	}
});

var LevelCounter = Backbone.Model.extend({
	label : 'Course Assessment',
	icon : '$ModelIconUrl$',
	visible : {
		"count" : {
			"title" : "Count",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : '33',
				"maxlength" : 5
			}
		}
	}
});

var LevelCounterCreateForm = Backbone.Form.extend({
	schema : {
		"count" : {
			"title" : "Count",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : '33',
				"maxlength" : 5
			}
		}
	}
});

var LevelCounterEditForm = Backbone.Form.extend({
	schema : {
		"id" : {
			"title" : "Id",
			"type" : "Hidden"
		},
		"count" : {
			"title" : "Count",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : '33',
				"maxlength" : 5
			}
		}
	}
});
