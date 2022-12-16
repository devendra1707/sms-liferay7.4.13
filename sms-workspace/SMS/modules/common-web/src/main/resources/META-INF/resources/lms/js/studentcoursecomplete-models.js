var studentCourseCompleteBaseUrl = "/api/jsonws/lms.stucoursecomplete";

var StudentCourseComplete = Backbone.Model.extend({
	label : 'Student Course Complete',
	icon : '$ModelIconUrl$',
	visible : {
		"studentId" : {
			"type" : "Text",
			"title" : "Student Id"
		},
		"courseId" : {
			"type" : "Text",
			"title" : "Course Id"
		},
		"lessonId" : {
			"type" : "Text",
			"title" : "Lesson Id"
		},
		"topicId" : {
			"type" : "Text",
			"title" : "Topic Id"
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-studentcoursecomplete'),
	url : studentCourseCompleteBaseUrl + "/find",
	create : function() {
		this.url = studentCourseCompleteBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	update : function() {
		this.url = studentCourseCompleteBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	remove : function() {
		this.url = studentCourseCompleteBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	}
});


