var studentDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=167";
var studentDefId = 167;
var studentBaseUrl = "/api/jsonws/lms.student";
var studentSectorBaseUrl = "/api/jsonws/lms.studentsector";
var issBaseUrl = "/api/jsonws/lms.iss";


var Student = Backbone.Model.extend({
	label : 'Student',
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
			"validators" : [ "text"]
		},
		"motherTongueName" : {
			"title" : "Mother Tongue Name",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Mother Tongue Name'
			}
		},
		"email" : {
			"title" : "Email",
			"requered" : "true",
			"validators" : [ "ldapEmail", "required" ]
		},
		"timeInCurrentRole" : {
			"title" : "Time in Current Role(In Months)",
			"type" : "Text",
			"validators" : [ "number", "required" ]
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
		"sectorIds" : {
			"title" : "Sectors",
			"type" : "Select",
			"options" : [ ],
			"editorClass" : "form-control input-md",
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-student'),
	url : studentBaseUrl + "/find",
	create : function() {
		this.url = studentBaseUrl + "/create-v3";
		return Backbone.ajaxSync('create', this);
	},
	createWithoutPicture : function() {
		this.url = studentBaseUrl + "/create-without-picture-v3";
		return Backbone.ajaxSync('create', this);
	},
	updatePassword : function() {
		this.url = studentBaseUrl + "/update-password";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function(sectorIds) {
		return studentBaseUrl + "/create-v3?sectorIds="+sectorIds;
	},
	updateWithoutPicture : function() {
		this.url = studentBaseUrl + "/update-without-picture-v3";
		return Backbone.ajaxSync('create', this);
	},
	updatev3Url : function(sectorIds) {
		
		return studentBaseUrl + "/update-v3?sectorIds="+sectorIds;
	},
	remove : function() {
		this.url = studentBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	importStudentList : function() {
		return studentBaseUrl + "/import-student-list";
	},
	findSectorsByStudentId : function() {
		this.url = studentSectorBaseUrl+"/find-sectors-by-student-id";
		return Backbone.ajaxSync('create', this);
	},
	changePassword : function() {
		this.url = studentBaseUrl + "/update-password";
		return Backbone.ajaxSync('create', this);
	},
	syncStudent : function(){
		this.url = studentBaseUrl+"/sync-student";
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('firstName');
	}
});

var StudentCollection = Backbone.Collection.extend({
	model : Student,
	url : studentBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-student'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	},
	studentListForEnroll : function(courseId) {
		this.url = studentBaseUrl
				+ "/get-all-student-list-for-course-enroll?courseId="
				+ courseId;
		return Backbone.ajaxSync('read', this);
	},
	findForRecommendCourse : function(courseIds) {
		this.url = studentBaseUrl
				+ "/find-student-for-recommend-course?courseIds=" + courseIds;
		return Backbone.ajaxSync('read', this);
	},
	findStudent : function(id) {
		this.url = studentBaseUrl + "/find?id="+id;
		return Backbone.ajaxSync('create', this);
	},
	findStudentBylinkUserId : function(linkedUserId) {
		this.url = studentBaseUrl + "/find-by-linked-user-id?linkedUserId="+linkedUserId;
		return Backbone.ajaxSync('create', this);
	},
	findISSbyOID:function(oid){
		this.url=issBaseUrl + "/find-by-oid?oid="+oid;
    	return Backbone.ajaxSync('read', this);
	},
	findStuDetails : function(id) {
		this.url = studentBaseUrl + "/find-stu-details?id="+id;
		return Backbone.ajaxSync('create', this);
	}
});

var StudentCreateForm = Backbone.Form.extend({
	schema : {
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
			"validators" : [ "text" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Last Name'
			}
		},
		"motherTongueName" : {
			"title" : "Mother Tongue Name",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Mother Tongue Name'
			}
		},
		"email" : {
			"title" : "Email",
			"required" : true,
			"pattern" : "ldapEmail",
			"validators" : [ "ldapEmail", "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'abc@example.com'
			}
		},
		"timeInCurrentRole" : {
			"title" : "Time in Current Role(In Months)",
			"type" : "Text",
			"validators" : [ "number", "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : '5'
			}
		},
		"gender" : {
			"title" : "Gender",
			"type" : "Select",
			"options" : [ {
				"val" : "Male",
				"label" : "Male"
			}, {
				"val" : "Female",
				"label" : "Female"
			} , 
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
		"sectorIds" : {
			"title" : "Sectors",
			"type" : "Select",
			"options" : [ ],
			"editorClass" : "form-control input-md",
		},
		"participantOID" : {
			"title" : "ISS/SSS OID",
			"type" : "Hidden",
			
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'ISS/SSS OID'
			}
		}
	}
});
// //change
var StudentEditForm = Backbone.Form.extend({

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
			"validators" : [ "text"],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Last Name'
			}
		},
		"motherTongueName" : {
			"title" : "Mother Tongue Name",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Mother Tongue Name'
			}
		},
		"email" : {
			"title" : "Email",
			"required" : true,
			"pattern" : "ldapEmail",
			"validators" : [ "ldapEmail", "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'abc@example.com'
			}
		},
		"timeInCurrentRole" : {
			"title" : "Time in Current Role(In Months)",
			"type" : "Text",
			"validators" : [ "number", "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : '5'
			}
		},
		"gender" : {
			"title" : "Gender",
			"type" : "Select",
			"options" : [ {
				"val" : "Male",
				"label" : "Male"
			}, {
				"val" : "Female",
				"label" : "Female"
			}, 
			{
				"val" : "Transgender",
				"label" : "Transgender"
			} ],
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
		"sectorIds" : {
			"title" : "Sectors",
			"type" : "Select",
			"options" : [ ],
			"editorClass" : "form-control input-md",
		}
	}
});

/*
 * var StudentPasswordEditForm = Backbone.Form.extend({ schema: {
 * "id":{"title":"ID","type":"Hidden"}, "userId":{"title":"New
 * Password","type":"Hidden"}, "password1":{"title":"New
 * Password","type":"Password","validators":["required"]},
 * "password2":{"title":"Confirm
 * Password","type":"Password","validators":["required"]},
 * "passwordReset":{"title":"Reset Password","type":"Hidden"} } });
 */
var StudentPasswordEditForm = Backbone.Form.extend({
	schema : {
		"id" : {
			"title" : "ID",
			"type" : "Hidden"
		},
		"oldPassword" : {
			"title" : "Current Password",
			"type" : "Password",
			"validators" : [ "required" ]
		},
		"newPassword" : {
			"title" : "New Password",
			"type" : "Password",
			"validators" : [ "required" ]
		},
		"confirmPassword" : {
			"title" : "Confirm Password",
			"type" : "Password",
			"validators" : [ "required" ]
		}
	}
});

var StudentImportForm = Backbone.Form.extend({
	schema : {
		"studentData" : {
			"title" : "Import File",
			"type" : "excelFilePicker"
		}
	}
});
