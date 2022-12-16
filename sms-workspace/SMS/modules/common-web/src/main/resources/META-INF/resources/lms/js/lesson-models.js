var lessonDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=168";
var lessonDefId = 168;
var lessonBaseUrl = "/api/jsonws/lms.lesson";

var Lesson = Backbone.Model.extend({
	label : 'Lesson',
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
			"title" : "Lesson Name",
			"type" : "Text",
			"validators" : [ "required" ]
		},
		"summary" : {
			"title" : "Summary",
			"type" : "TextArea",
			"validators" : [ "required" ]
		},
		"completionTime" : {
			"title" : "Completion Time (In Hrs)",
			"type" : "Text",
			"validators" : [ "required", "number" ]
		},
		"active" : {
			"title" : "Radio",
			"type" : "Select",
			"options" : [ "Yes", "No" ]
		},
		"courseId" : {
			"title" : "Course",
			"type" : "Select",
			"options" : "<Course>"
		},
		"day" : {
			"title" : "Day",
			"type" : "Select",
			"options" : [ "Day 1", "Day 2", "Day 3", "Day 4", "Day 5", "Day 6",
					"Day 7" ]
		},
		"sequence" : {
			"title" : "Sequence No.",
			"type" : "Text",
			"validators" : [ "required", "sequence" ]
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-lesson'),
	url : lessonBaseUrl + "/find",
	create : function(courseId) {
		this.url = lessonBaseUrl + "/create";
		this.attributes["courseId"] = courseId;
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function(courseId) {
		this.attributes["courseId"] = courseId;
		return lessonBaseUrl + "/create";
	},
	update : function(courseId) {
		this.url = lessonBaseUrl + "/update";
		this.attributes["courseId"] = courseId;
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function(courseId) {
		this.attributes["courseId"] = courseId;
		return lessonBaseUrl + "/update";
	},
	remove : function() {
		this.url = lessonBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	findByLocaleCode : function(id,localeCode) {
		this.url = lessonBaseUrl + "/find-by-locale-code";
		this.attributes["id"] = id;
		this.attributes["localeCode"] = localeCode;
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('title');
	},
	updatePosition : function(lessonId, modelId, type, position) {
		this.url = lessonBaseUrl
				+ "/update-position-of-lab-quiz-topic?lessonId="
				+ lessonId + "&modelId=" + modelId + "&position="
				+ position + "&type=" + type;
return Backbone.ajaxSync('read', this);
}
});

var LessonCollection = Backbone.Collection.extend({
	model : Lesson,
	url : lessonBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-lesson'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	},
	findByCourseId : function(courseId) {
		this.url = lessonBaseUrl + "/findlesson-by-course-id?courseId="
				+ courseId;
		return Backbone.ajaxSync('read', this);
	},
	findLessonsByCourseId : function(courseId) {

		this.url = lessonBaseUrl + "/find-lessons-by-course-id?courseId="
				+ courseId;
		return Backbone.ajaxSync('read', this);
	},
	findLessonsWithSkillSetByCourseId : function(courseId,localeCode) {

		this.url = lessonBaseUrl
				+ "/find-lessons-with-skill-set-by-course-id?courseId="
				+ courseId+"&localeCode="+localeCode;
		return Backbone.ajaxSync('read', this);
	},
	findAllLessons : function(courseId) {
		this.url = lessonBaseUrl + "/find-all-lessons?courseId=" + courseId;
		return Backbone.ajaxSync('create', this);
	}
});
var LessonByCourseCollection = Backbone.Collection.extend({
	model : Lesson,
	url : lessonBaseUrl + "/find-by-course-id",
	localStorage : new Backbone.LocalStorage('tbl-lesson'),
	download : function(courseId) {
		this.url = lessonBaseUrl + "/find-by-course-id/course-id/" + courseId;
		return Backbone.ajaxSync('read', this);
	}

});

var LessonCreateForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
			},
		"title" : {
			"title" : "Lesson Name",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Lesson Title'
			}
		},
		"summary" : {
			"title" : "Summary",
			"type" : "TextArea",
			"validators" : [ "required", "description" ],
			"editorClass" : "form-control",
			editorAttrs : {
				placeholder : 'Lesson Description'
			}
		},
		"completionTime" : {
			"title" : "Completion Time (In Hrs)",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : '',
				"maxlength" : 5
			}
		},
		"active" : {
			"title" : "Active",
			"type" : "Radio",
			"options" : [{
				"val" : "Yes",
				"label" : "Yes"
			}, {
				"val" : "No",
				"label" : "No"
			} ],
			"validators" : [ "required" ]
		},
		"day" : {
			"title" : "Day",
			"type" : "Select",
			"options" : [ {
				"val" : "",
				"label" : "Please Select"
			}, {
				"val" : "Day 1",
				"label" : "Day 1"
			}, {
				"val" : "Day 2",
				"label" : "Day 2"
			}, {
				"val" : "Day 3",
				"label" : "Day 3"
			}, {
				"val" : "Day 4",
				"label" : "Day 4"
			}, {
				"val" : "Day 5",
				"label" : "Day 5"
			}, {
				"val" : "Day 6",
				"label" : "Day 6"
			}, {
				"val" : "Day 7",
				"label" : "Day 7"
			} ],
			"validators" : [ "required" ],
			"editorClass" : "form-control"
		},
		"sequence" : {
			"title" : "Sequence No.",
			"type" : "Text",
			"validators" : [ "required", "sequence" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Sequential Number'
			}
		}
	}
});

var LessonEditForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
		"title":"Select Language",
		"type":"Select",
		"validators":["required"],
		"options" : new LocaleInfoCollection(),
		"editorClass" : "form-control"
		},
		"title" : {
			"title" : "Lesson Name",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Lesson Title'
			}
		},
		"summary" : {
			"title" : "Summary",
			"type" : "TextArea",
			"validators" : [ "required", "description" ],
			"editorClass" : "form-control",
			editorAttrs : {
				placeholder : 'Lesson Description'
			}
		},
		"completionTime" : {
			"title" : "Completion Time (In Hrs)",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : '',
				"maxlength" : 5
			}
		},
		"active" : {
			"title" : "Active",
			"type" : "Radio",
			"options" : [ {
				"val" : "Yes",
				"label" : "Yes"
			}, {
				"val" : "No",
				"label" : "No"
			} ],
			"validators" : [ "required" ]
		},
		"day" : {
			"title" : "Day",
			"type" : "Select",
			"options" : [ {
				"val" : "",
				"label" : "Please Select"
			}, {
				"val" : "Day 1",
				"label" : "Day 1"
			}, {
				"val" : "Day 2",
				"label" : "Day 2"
			}, {
				"val" : "Day 3",
				"label" : "Day 3"
			}, {
				"val" : "Day 4",
				"label" : "Day 4"
			}, {
				"val" : "Day 5",
				"label" : "Day 5"
			}, {
				"val" : "Day 6",
				"label" : "Day 6"
			}, {
				"val" : "Day 7",
				"label" : "Day 7"
			} ],
			"validators" : [ "required" ],
			"editorClass" : "form-control"
		},
		"sequence" : {
			"title" : "Sequence No.",
			"type" : "Text",
			"validators" : [ "required", "sequence" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Sequential Number'
			}
		}
	}
});
