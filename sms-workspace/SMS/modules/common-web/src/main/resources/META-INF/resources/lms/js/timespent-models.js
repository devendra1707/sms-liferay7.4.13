//var  studentCourseBaseUrl = "http://portal.armantecsystems.com/api/jsonws/LMS-portlet.student-course";
var timeSpentBaseUrl = "/api/jsonws/lms.topictimespent";

var TopicTimeSpent = Backbone.Model.extend({
	label : 'Time Spent',
	icon : '$ModelIconUrl$',
	visible : {
		"studentId" : {
			"type" : "Text",
			"title" : "Student Id",
			"validators" : "required",
		},
		"courseId" : {
			"type" : "Text",
			"title" : "Course Id",
			"validators" : "required",
		},
		"lessonId" : {
			"type" : "Text",
			"title" : "Lesson Id",
			"validators" : "required",
		},
		"topicId" : {
			"type" : "Text",
			"title" : "Topic Id",
			"validators" : "required",
		},
		"timeSpend" : {
			"type" : "Text",
			"title" : "Time spend",
			"validators" : "required",
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-studentcourse'),
	url : timeSpentBaseUrl + "/find",
	create : function() {
		this.url = timeSpentBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	update : function() {
		this.url = timeSpentBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	remove : function() {
		this.url = timeSpentBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	updateTimeSpent : function(topicId, type) {
		this.url = timeSpentBaseUrl + "/update-time-spent?topicId=" + topicId + "&type="+type;
		return Backbone.ajaxSync('create', this);
	},
	updateLabTimeSpent : function(labId, type) {
		this.url = timeSpentBaseUrl + "/update-lab-time-spent?labId=" + labId + "&type="+type;
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('id');
	}
});

var TopicSpentCollection = Backbone.Collection.extend({
	model : TopicTimeSpent,
	url : timeSpentBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-timespent'),
	download : function() {
		return Backbone.ajaxSync('read', this);
	}
});
