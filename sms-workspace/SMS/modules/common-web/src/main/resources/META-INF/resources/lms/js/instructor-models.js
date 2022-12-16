var instructorDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=237";
var instructorDefId = 237;
var instructorBaseUrl = "/api/jsonws/lms.instructor";
var instructorSectorUrl = "/api/jsonws/lms.instructorsector";
var classroomScheduleUrl = "/api/jsonws/lms.classschedule";



var Instructor = Backbone.Model.extend({
	label : 'Instructor',
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
			"options" : [ "Male", "Female"],
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
	localStorage : new Backbone.LocalStorage('tbl-instructor'),
	url : instructorBaseUrl + "/find",
	create : function() {
		this.url = instructorBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function(sectorIds) {
		return instructorBaseUrl + "/create?sectorIds="+sectorIds;
	},
	createWithoutPicture : function() {
		this.url = instructorBaseUrl + "/create-without-picture";
		return Backbone.ajaxSync('create', this);
	},
	update : function() {
		this.url = instructorBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function(sectorIds) {
		return instructorBaseUrl + "/update?sectorIds="+sectorIds;
	},
	updateWithoutPicture : function() {
		this.url = instructorBaseUrl + "/update-without-picture-v2";
		return Backbone.ajaxSync('create', this);
	},
	remove : function() {
		this.url = instructorBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	changePassword : function() {
		this.url = instructorBaseUrl + "/update-password";
		return Backbone.ajaxSync('create', this);
	},
	importInstructorList : function() {
		return instructorBaseUrl + "/import-instructor-list";
	},
	findSectorsByInstructorId : function() {
		this.url = instructorSectorUrl+"/find-sectors-by-instructor-id";
		return Backbone.ajaxSync('create', this);
	},
	findTrainingDetails : function(userId){
		this.url = classroomScheduleUrl+"/count-by-user?userId="+userId;
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('firstName');
	}
});

var InstructorCollection = Backbone.Collection.extend({
	model : Instructor,
	url : instructorBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-instructor'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	},
	findInstructor : function(linkedUserId) {
		this.url = instructorBaseUrl + "/find-by-linked-user-id?linkedUserId="+linkedUserId;
		return Backbone.ajaxSync('create', this);
	}
});

var InstructorCreateForm = Backbone.Form.extend({
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

var InstructorEditForm = Backbone.Form.extend({
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

var InstructorImportForm = Backbone.Form.extend({
	schema : {
		"instructorData" : {
			"title" : "Import File",
			"type" : "excelFilePicker",
			"editorClass" : "form-control input-md"
		}
	}
});
