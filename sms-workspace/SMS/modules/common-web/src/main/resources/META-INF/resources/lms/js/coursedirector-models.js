var courseDirectorDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=769";
var courseDirectorDefId = 769;
//var courseDirectorBaseUrl = "/api/jsonws/lms.courseDirector";
var courseDirectorSectorUrl = "/api/jsonws/lms.coursedirectorsector";
var classroomScheduleUrl = "/api/jsonws/lms.classschedule";
var courseDirectorBaseUrl = "/api/jsonws/lms.coursedirector";






var CourseDirector = Backbone.Model.extend({
	label : 'CourseDirector',
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
	localStorage : new Backbone.LocalStorage('tbl-coursedirector'),
	url : courseDirectorBaseUrl + "/find",
	create : function() {
		this.url = courseDirectorBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function() {
		return courseDirectorBaseUrl + "/create";
	},
	createWithoutPicture : function() {
		this.url = courseDirectorBaseUrl + "/create-without-picture";
		return Backbone.ajaxSync('create', this);
	},
	update : function() {
		this.url = courseDirectorBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function() {
		return courseDirectorBaseUrl + "/update";
	},
	updateWithoutPicture : function() {
		this.url = courseDirectorBaseUrl + "/update-without-picture-v2";
		return Backbone.ajaxSync('create', this);
	},
	remove : function() {
		this.url = courseDirectorBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	changePassword : function() {
		this.url = courseDirectorBaseUrl + "/update-password";
		return Backbone.ajaxSync('create', this);
	},
	importCourseDirectorList : function() {
		return courseDirectorBaseUrl + "/import-course-director-list";
	},
	findSectorsByCourseDirectorId : function() {
		this.url = courseDirectorSectorUrl+"/find-sectors-by-course-director-id";
		return Backbone.ajaxSync('create', this);
	},
	findTrainingDetails : function(userId){
		this.url = classroomScheduleUrl+"/count-by-user?userId="+userId;
		return Backbone.ajaxSync('create', this);
	},
	syncCourseDirector : function(){
		this.url = courseDirectorBaseUrl+"/sync-course-director";
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('firstName');
	}
});

var CourseDirectorCollection = Backbone.Collection.extend({
	model : CourseDirector,
	url : courseDirectorBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-coursedirector'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	},
	findCourseDirector : function(linkedUserId) {
		this.url = courseDirectorBaseUrl + "/find-by-linked-user-id?linkedUserId="+linkedUserId;
		return Backbone.ajaxSync('create', this);
	}
});

var CourseDirectorCreateForm = Backbone.Form.extend({
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
		}
		
		/*,
		"sectorIds" : {
			"type" : "Select",
			"title" : "Select Sector",
			
			"options" : [],
			"editorClass" : "form-control input-md"
		}*/
	}
});

var CourseDirectorEditForm = Backbone.Form.extend({
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
		}
		/*,
		"sectorIds" : {
			"type" : "Select",
			"title" : "Select Sector",
			"validators" : [ "required" ],
			"options" : [],
			"editorClass" : "form-control input-md"
		}*/
	}
});

var CourseDirectorImportForm = Backbone.Form.extend({
	schema : {
		"courseDirectorData" : {
			"title" : "Import File",
			"type" : "excelFilePicker",
			"editorClass" : "form-control input-md"
		}
	}
});
