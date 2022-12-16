var courseCoordinatorDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=237";
var courseCoordinatorDefId = 237;
//var courseCoordinatorBaseUrl = "/api/jsonws/lms.courseCoordinator";
var courseCoordinatorSectorUrl = "/api/jsonws/lms.coursecoordinatorsector";
var classroomScheduleUrl = "/api/jsonws/lms.classschedule";
var courseCoordinatorBaseUrl = "/api/jsonws/lms.coursecoordinator";






var CourseCoordinator = Backbone.Model.extend({
	label : 'CourseCoordinator',
	icon : '$ModelIconUrl$',
	visible : {
		"id" : {
			"title" : "ID",
			"type" : "Hidden"
		},
		"profileImage" : {
			"title" : "Profile Image",
			"type" : "ImagePicker"
		},
		"firstName" : {
			"title" : "First Name",
			"type" : "Text",
			"validators" : [ "text", "required" ]
		},
		"lastName" : {
			"title" : "Last Name",
			"type" : "Text",
			"validators" : [ "text", "required" ]
		},
		"email" : {
			"title" : "Email",
			"requered" : "true",
			"validators" : [ "email", "required" ]
		},
		"dob" : {
			"title" : "Date of Birth",
			"type" : "DatePickerBootstrap",
			"validators" : [ "date", "required" ]
		},
		"gender" : {
			"title" : "Gender",
			"type" : "Select",
			"options" : [ "Male", "Female" ,"Transgender"],
			"validators" : [ "text", "required" ]
		},
		"contactNumber" : {
			"title" : "Contact Number",
			"type" : "Text",
			"validators" : [ "phone", "required" ]
		},
		"address" : {
			"title" : "Address",
			"type" : "TextArea",
			"validators" : [ "required" ]
		},
		"referrer" : {
			"title" : "Referred By",
			"type" : "Hidden"
		},
		"qualification" : {
			"type" : "TextArea",
			"title" : "Qualification",
			"editorClass" : "form-control input-md"
		},
		"sectorIds" : {
			"type" : "Select",
			"title" : "Select Sector",
			"validators" : [ "required" ],
			"options" : [],
			"editorClass" : "form-control input-md"
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-coursecoordinator'),
	url : courseCoordinatorBaseUrl + "/find",
	create : function() {
		this.url = courseCoordinatorBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function(sectorIds) {
		return courseCoordinatorBaseUrl + "/create?sectorIds="+sectorIds;
	},
	createWithoutPicture : function() {
		this.url = courseCoordinatorBaseUrl + "/create-without-picture";
		return Backbone.ajaxSync('create', this);
	},
	update : function() {
		this.url = courseCoordinatorBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function(sectorIds) {
		return courseCoordinatorBaseUrl + "/update?sectorIds="+sectorIds;
	},
	updateWithoutPicture : function() {
		this.url = courseCoordinatorBaseUrl + "/update-without-picture-v2";
		return Backbone.ajaxSync('create', this);
	},
	remove : function() {
		this.url = courseCoordinatorBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	changePassword : function() {
		this.url = courseCoordinatorBaseUrl + "/update-password";
		return Backbone.ajaxSync('create', this);
	},
	importCourseCoordinatorList : function() {
		return courseCoordinatorBaseUrl + "/import-course-coordinator-list";
	},
	findSectorsByCourseCoordinatorId : function() {
		this.url = courseCoordinatorSectorUrl+"/find-sectors-by-course-coordinator-id";
		return Backbone.ajaxSync('create', this);
	},
	findTrainingDetails : function(userId){
		this.url = classroomScheduleUrl+"/count-by-user?userId="+userId;
		return Backbone.ajaxSync('create', this);
	},
	syncCourseCoordinator : function(){
		this.url = courseCoordinatorBaseUrl+"/sync-course-coordinator";
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('firstName');
	}
});

var CourseCoordinatorCollection = Backbone.Collection.extend({
	model : CourseCoordinator,
	url : courseCoordinatorBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-coursecoordinator'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	},
	findCourseCoordinator : function(linkedUserId) {
		this.url = courseCoordinatorBaseUrl + "/find-by-linked-user-id?linkedUserId="+linkedUserId;
		return Backbone.ajaxSync('create', this);
	}
});

var CourseCoordinatorCreateForm = Backbone.Form.extend({
	schema : {
		"id" : {
			"title" : "ID",
			"type" : "Hidden"
		},
		"firstName" : {
			"title" : "First Name",
			"type" : "Text",
			"validators" : [ "text", "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'First Name'
			}
		},
		"lastName" : {
			"title" : "Last Name",
			"type" : "Text",
			"validators" : [ "text", "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Last Name'
			}
		},
		"email" : {
			"title" : "Email",
			"required" : true,
			"pattern" : "email",
			"validators" : [ "email", "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'abc@example.com'
			}
		},
		"dob" : {
			"title" : "Date of Birth",
			"type" : "DatePickerBootstrap",
			"validators" : [ "date", "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'yyyy-mm-dd'
			}
		},
		"gender" : {
			"title" : "Gender",
			"type" : "Select",
			"options" : [ {
				"val" : "Male",
				"label" : "Male"
			},
			{
				"val" : "Female",
				"label" : "Female"
			}, 
			{
				"val" : "Transgender",
				"label" : "Transgender"
			}],
			"validators" : [ "text", "required" ],
			"editorClass" : "form-control input-md"
		},
		"contactNumber" : {
			"title" : "Contact Number",
			"type" : "Text",
			"validators" : [ "phone", "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : '1234567890'
			}
		},
		"address" : {
			"title" : "Address",
			"type" : "TextArea",
			"validators" : [ "required", "addressRegex" ],
			"editorClass" : "form-control input-md"
		},
		"profileImage" : {
			"title" : "Profile Image",
			"type" : "ImagePicker",
			"help" : "Allowed types are .png, .jpg, .gif, .svg. Max Size - 1MB"
		},
		"referrer" : {
			"title" : "Referred By",
			"type" : "Hidden"
		},
		"qualification" : {
			"type" : "TextArea",
			"title" : "Qualification",
			"editorClass" : "form-control input-md"
		},
		"sectorIds" : {
			"type" : "Select",
			"title" : "Select Sector",
			"validators" : [ "required" ],
			"options" : [],
			"editorClass" : "form-control input-md"
		}
	}
});

var CourseCoordinatorEditForm = Backbone.Form.extend({
	schema : {
		"id" : {
			"title" : "ID",
			"type" : "Hidden"
		},
		"firstName" : {
			"title" : "First Name",
			"type" : "Text",
			"validators" : [ "text", "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'First Name'
			}
		},
		"lastName" : {
			"title" : "Last Name",
			"type" : "Text",
			"validators" : [ "text", "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Last Name'
			}
		},
		"email" : {
			"title" : "Email",
			"required" : true,
			"pattern" : "email",
			"validators" : [ "email", "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'abc@example.com'
			}
		},
		"dob" : {
			"title" : "Date of Birth",
			"type" : "DatePickerBootstrap",
			"validators" : [ "date", "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'yyyy-mm-dd'
			}
		},
		"gender" : {
			"title" : "Gender",
			"type" : "Select",
			"options" : [ {
				"val" : "Male",
				"label" : "Male"
			},
			{
				"val" : "Female",
				"label" : "Female"
			}, 
			{
				"val" : "Transgender",
				"label" : "Transgender"
			}],
			"validators" : [ "text", "required" ],
			"editorClass" : "form-control input-md"
		},
		"contactNumber" : {
			"title" : "Contact Number",
			"type" : "Text",
			"validators" : [ "phone", "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : '1234567890'
			}
		},
		"address" : {
			"title" : "Address",
			"type" : "TextArea",
			"validators" : [ "required", "addressRegex" ],
			"editorClass" : "form-control input-md"
		},
		"profileImage" : {
			"title" : "Profile Image",
			"type" : "ImagePicker",
			"help" : "Allowed types are .png, .jpg, .gif, .svg. Max Size - 1MB"
		},
		"referrer" : {
			"title" : "Referred By",
			"type" : "Hidden"
		},
		"qualification" : {
			"type" : "TextArea",
			"title" : "Qualification",
			"editorClass" : "form-control input-md"
		},
		"sectorIds" : {
			"type" : "Select",
			"title" : "Select Sector",
			"validators" : [ "required" ],
			"options" : [],
			"editorClass" : "form-control input-md"
		}
	}
});

var CourseCoordinatorImportForm = Backbone.Form.extend({
	schema : {
		"courseCoordinatorData" : {
			"title" : "Import File",
			"type" : "excelFilePicker",
			"editorClass" : "form-control input-md"
		}
	}
});
