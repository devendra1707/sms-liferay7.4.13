var recommendGroupCourseBaseUrl = "/api/jsonws/lms.recommendgroupcourse";

var RecommendGroupCourse = Backbone.Model.extend({
	label : 'Recommend Group Course',
	icon : '$ModelIconUrl$',
	visible : {
		"groupId" : {
			"type" : "Text",
			"title" : "Group Id",
			"validators" : "required"
		},
		"courseId" : {
			"type" : "Text",
			"title" : "Course Id",
			"validators" : "required"
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-groupRecommendCourse'),
	url : recommendGroupCourseBaseUrl + "/find",
	create : function() {
		this.url = recommendGroupCourseBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},

	remove : function() {
		this.url = recommendGroupCourseBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('id');
	}
});
