var lmsUserBaseUrl = "/api/jsonws/lms.lmsuser";

var LMSUser = Backbone.Model.extend({
	label : 'LMSUser',
	icon : '$ModelIconUrl$',
	visible : {
		"id" : {
			"title" : "ID",
			"type" : "Hidden"
		},
		"organisationId" : {
			"title" : "Organization Title",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new OrganisationCollection(),
			"editorClass" : "form-control"
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
			"options" : [ "Male", "Female" ],
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
		"roleId" : {
			"title" : "Role",
			"type" : "Select",
			"validators" : "required",
			"options" : "<UserRole>",
			"editorClass" : "form-control"
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-lmsUser'),
	url : lmsUserBaseUrl + "/find",
	create : function() {
		this.url = lmsUserBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function() {
		return lmsUserBaseUrl + "/create";
	},
	createWithoutPicture : function() {
		this.url = lmsUserBaseUrl + "/create-without-picture";
		return Backbone.ajaxSync('create', this);
	},
	createByAdmin : function() {
		this.url = lmsUserBaseUrl + "/create-by-sys-admin";
		return Backbone.ajaxSync('create', this);
	},
	createByAdminUrl : function() {
		return lmsUserBaseUrl + "/create-by-sys-admin";
	},
	createWithoutPictureByAdmin : function() {
		this.url = lmsUserBaseUrl + "/create-without-picture-by-sys-admin";
		return Backbone.ajaxSync('create', this);
	},
	update : function() {
		this.url = lmsUserBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function() {
		return lmsUserBaseUrl + "/update";
	},
	updateWithoutPicture : function() {
		this.url = lmsUserBaseUrl + "/update-without-picture";
		return Backbone.ajaxSync('create', this);
	},
	remove : function() {
		this.url = lmsUserBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('firstName');
	}
});

var LMSUserCollection = Backbone.Collection.extend({
	model : LMSUser,
	url : lmsUserBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-lmsUser'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	},
	getAllRoles : function() {
		this.url = lmsUserBaseUrl + "/find-all-roles";
		return Backbone.ajaxSync('create', this);
	}
});

var LMSUserCreateForm = Backbone.Form.extend({
	schema : {
		"id" : {
			"title" : "ID",
			"type" : "Hidden"
		},
		"organisationId" : {
			"title" : "Organization Title",
			"type" : "Select",
			"options" : new OrganisationCollection(),
			"editorClass" : "form-control"
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
		"roleId" : {
			"title" : "Role",
			"type" : "Select",
			"validators" : ["required"],
			"options" : "<LMSUser>",
			"editorClass" : "form-control"
		}
	}
});

var LMSUserEditForm = Backbone.Form.extend({
	schema : {
		"id" : {
			"title" : "ID",
			"type" : "Hidden"
		},
		"organisationId" : {
			"title" : "Organization Title",
			"type" : "Select",
			"options" : new OrganisationCollection(),
			"editorClass" : "form-control"
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
		"roleId" : {
			"title" : "Role",
			"type" : "Select",
			"validators" : ["required"],
			"options" : "<LMSUser>",
			"editorClass" : "form-control"
		}
	}
});

