var recommendStudentCourseBaseUrl = "/api/jsonws/lms.recommendstucourse";

var RecommendStudentCourse = Backbone.Model.extend({
	label : 'Recommend Student Course',
	icon : '$ModelIconUrl$',
	visible : {
		"studentId" : {
			"type" : "Text",
			"title" : "First Name",
			"validators" : "required"
		},
		"courseId" : {
			"type" : "Text",
			"title" : "Last name",
			"validators" : "required"
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-studentcourse'),
	url : recommendStudentCourseBaseUrl + "/find",
	create : function() {
		this.url = recommendStudentCourseBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},

	remove : function() {
		this.url = recommendStudentCourseBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('studentId');
	}
});
