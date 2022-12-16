var groupCourseDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=21227";
var groupCourseDefId = 21227;
// var groupCourseBaseUrl =
// "http://portal.armantecsystems.com/api/jsonws/LMS-portlet.groupcourse";
var groupCourseBaseUrl = "/api/jsonws/lms.groupcourse";

var GroupCourse = Backbone.Model.extend({
	label : 'Group Course',
	icon : '$ModelIconUrl$',
	visible : {
		"studentGroupId" : {
			"type" : "Select",
			"title" : "Group Name",
			"validators" : "required",
			"options" : "<StudentGroup>",
			"regexp" : 0,
			"fieldClass" : "pullleft col49"
		},
		"courseId" : {
			"type" : "Select",
			"title" : "Course name",
			"validators" : "required",
			"options" : "<Course>",
			"regexp" : 0,
			"fieldClass" : "pullright col49"
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-groupcourse'),
	url : groupCourseBaseUrl + "/find",
	create : function() {
		this.url = groupCourseBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function() {
		this.url = groupCourseBaseUrl + "/create";
		var yy = this;
		return Backbone.ajaxSync('create', this);
	},
	update : function() {
		this.url = groupCourseBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function() {
		return groupCourseBaseUrl + "/update";
	},
	remove : function() {
		this.url = groupCourseBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	removeCourse : function() {
		this.url = groupCourseBaseUrl + "/remove-course";
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('studentId');
	}
});

var GroupCourseCollection = Backbone.Collection.extend({
	model : GroupCourse,
	url : groupCourseBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-category'),
	download : function(filter) {
		this.url = groupCourseBaseUrl + "/find-all";
		return Backbone.ajaxSync('read', this);
	}
});
