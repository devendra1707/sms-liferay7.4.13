var studentGroupDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=166";
var studentGroupDefId = 166;
var studentGroupBaseUrl = "/api/jsonws/lms.studentgroup";
var studentGroupSectorBaseUrl = "/api/jsonws/lms.studentgroupsector";
var groupBaseUrl = "/api/jsonws/lms.groupcourse";

var StudentGroup = Backbone.Model.extend({
	label : 'Participant Group',
	icon : '$ModelIconUrl$',
	visible : {
		"localeCode" : {
			"title" : "Select Language","subtitle":"Select Language",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"name" : {
			"title" : "Name","subtitle":"Name",
			"type" : "Text",
			"validators" : [ "required" ]
		},
		"description" : {
			"title" : "Description","subtitle":"Description",
			"type" : "TextArea",
			"validators" : [ "required" ]
		},
		"active" : {
			"title" : "Active","subtitle":"Active",
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
		"image" : {
			"title" : "Logo","subtitle":"Logo",
			"type" : "ImagePicker"
		},
		"maxLimit" : {
			"title" : "Max Participants","subtitle":"Max Students",
			"type" : "Text",
			"validators" : [ "number", "required" ]
		},
		"studentCount" : {
			"title" : "Participant Count","subtitle":"Student Count",
			"type" : "Hidden"
		},
		"sectorIds" : {
			"title" : "Sectors","subtitle":"Sectors",
			"type" : "Select",
			"options" : [ ],
			"editorClass" : "form-control input-md",
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-studentgroup'),
	url : studentGroupBaseUrl + "/find",
	create : function() {
		this.url = studentGroupBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createWithoutPicture : function() {
		this.url = studentGroupBaseUrl + "/create-without-logo-v2";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function(sectorIds) {
		return studentGroupBaseUrl + "/create-v2?sectorIds="+sectorIds;
	},
	update : function() {
		this.url = studentGroupBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	addStudents : function() {
		this.url = studentGroupBaseUrl + "/add-students";
		return Backbone.ajaxSync('create', this);
	},
	removeStudents : function() {
		this.url = studentGroupBaseUrl + "/remove-students";
		return Backbone.ajaxSync('create', this);
	},
	findStudentsInUserGroup : function() {
		this.url = studentGroupBaseUrl + "/find-students-in-user-group";
		return Backbone.ajaxSync('create', this);
	},
	findStudentsNotInUserGroup : function() {
		this.url = studentGroupBaseUrl + "/find-students-not-in-user-group";
		return Backbone.ajaxSync('create', this);
	},
	updateWithoutPicture : function() {
		this.url = studentGroupBaseUrl + "/update-without-logo-v2";
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function(sectorIds) {
		return studentGroupBaseUrl + "/update-v2?sectorIds="+sectorIds;
	},
	remove : function() {
		this.url = studentGroupBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('name');
	},
	findByLocaleCode : function(id,localeCode) {
		this.url = studentGroupBaseUrl + "/find-by-locale-code";
		this.attributes["id"] = id;
		this.attributes["localeCode"] = localeCode;
		return Backbone.ajaxSync('create', this);
	},
	findSectorsByStudentGroupId : function() {
		this.url = studentGroupSectorBaseUrl+"/find-sectors-by-student-group-id";
		return Backbone.ajaxSync('create', this);
	},
});

var StudentGroupCollection = Backbone.Collection.extend({
	model : StudentGroup,
	url : studentGroupBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-studentgroup'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	},
	findAllActiveGroup : function(courseId) {
		this.url = studentGroupBaseUrl + "/find-all-active-group?courseIds="+courseId;
				+ courseId;
		return Backbone.ajaxSync('read', this);
	},
	groupListForCourse : function(courseId) {
		this.url = groupBaseUrl + "/find-group-list-by-course?courseId="
				+ courseId;
		return Backbone.ajaxSync('create', this);
	},
	findStudentGroupCourse : function(courseId) {
		this.url = groupCourseBaseUrl
				+ "/get-all-student-group-for-course?courseId=" + courseId;
		return Backbone.ajaxSync('read', this);
	},
	findEnrolledGroupCourse : function(courseId) {
		this.url = studentGroupBaseUrl
				+ "/get-all-enrolled-groups-course?courseId=" + courseId;
		return Backbone.ajaxSync('read', this);
	}
});

var StudentGroupActiveCollection = Backbone.Collection.extend({
	model : StudentGroup,
	url : studentGroupBaseUrl + "/find-all-active-group",
	localStorage : new Backbone.LocalStorage('tbl-studentgroup'),
	download : function() {
		return Backbone.ajaxSync('read', this);
	},
	findAllActiveGroup : function(courseId) {
		this.url = studentGroupBaseUrl + "/find-all-active-group?courseIds="+courseId;
				+ courseId;
		return Backbone.ajaxSync('read', this);
	},
	groupListForCourse : function(courseId) {
		this.url = groupBaseUrl + "/find-group-list-by-course?courseId="
				+ courseId;
		return Backbone.ajaxSync('create', this);
	},
	findStudentGroupCourse : function(courseId) {
		this.url = groupCourseBaseUrl
				+ "/get-all-student-group-for-course?courseId=" + courseId;
		return Backbone.ajaxSync('read', this);
	}
});

var StudentGroupCreateForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
			"title" : "Select Language","subtitle":"Select Language",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"name" : {
			"title" : "Name","subtitle":"Name",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Group Title'
			}
		},
		"description" : {
			"title" : "Description","subtitle":"Description",
			"type" : "TextArea",
			"validators" : [ "required", "description" ],
			"editorClass" : "form-control",
			editorAttrs : {
				placeholder : 'Some group information here'
			}
		},
		"maxLimit" : {
			"title" : "Max Participants Allowed","subtitle":"Max Students Allowed",
			"type" : "Text",
			"validators" : [ "number", "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : '10'
			}
		},
		"active" : {
			"title" : "Active","subtitle":"Active",
			"type" : "Radio",
			"options" : [ {
				"val" : "Yes",
				"label" : "Yes"
			}, {
				"val" : "No",
				"label" : "No"
			} ],
			"validators" : [ "text", "required" ]
		},
		"image" : {
			"title" : "Group Logo","subtitle":"Group Logo",
			"type" : "ImagePicker",
			"help" : ".png, .jpg, .gif, .svg files only upto 1MB"
		},

		"studentCount" : {
			"title" : "Participant Count","subtitle":"Student Count",
			"type" : "Hidden"
		},
		"sectorIds" : {
			"title" : "Sectors","subtitle":"Sectors",
			"type" : "Select",
			"options" : [ ],
			"editorClass" : "form-control input-md",
		}
	}
});

var StudentGroupEditForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
			"title" : "Select Language","subtitle":"Select Language",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"id" : {
			"id" : "ID",
			"type" : "Hidden"
		},
		"name" : {
			"title" : "Name","subtitle":"Name",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Group Title'
			}
		},
		"description" : {
			"title" : "Description","subtitle":"Description",
			"type" : "TextArea",
			"validators" : [ "required", "description" ],
			"editorClass" : "form-control",
			editorAttrs : {
				placeholder : 'Some group information here'
			}
		},
		"maxLimit" : {
			"title" : "Max Participants Allowed","subtitle":"Max Students Allowed",
			"type" : "Text",
			"validators" : [ "number", "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : '10'
			}
		},
		"active" : {
			"title" : "Active","subtitle":"Active",
			"type" : "Radio",
			"options" : [ {
				"val" : "Yes",
				"label" : "Yes"
			}, {
				"val" : "No",
				"label" : "No"
			} ],
			"validators" : [ "text", "required" ]
		},
		"image" : {
			"title" : "Group Logo","subtitle":"Group Logo",
			"type" : "ImagePicker",
			"help" : ".png, .jpg, .gif, .svg files only upto 1MB"
		},
		"studentCount" : {
			"title" : "Participant Count","subtitle":"Student Count",
			"type" : "Hidden"
		},
		"sectorIds" : {
			"title" : "Sectors","subtitle":"Sectors",
			"type" : "Select",
			"options" : [ ],
			"editorClass" : "form-control input-md",
		}
	}
});

var StudentCourseCreateForm = Backbone.Form.extend({
	schema : {
		"parentCategoryId" : {
			"title" : "Group Name","subtitle":"Group Name",
			"type" : "Select",
			"options" : new StudentGroupCollection(),
			"validators" : [ "required" ]
		}
	}
});
