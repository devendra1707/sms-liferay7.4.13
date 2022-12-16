//var candidateDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=167";
//var studentDefId = 167;
var candidateBaseUrl = "/api/jsonws/lms.candidate";

var Candidate = Backbone.Model.extend({
	label : 'Candidate',
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
		"timeInCurrentRole" : {
			"title" : "Time in Current Role(In Months)",
			"type" : "Text",
			"validators" : [ "number", "required" ]
		},
		"gender" : {
			"title" : "Gender",
			"type" : "Select",
			"options" : [ "Male", "Female" ],
			"validators" : [ "text", "required" ]
		},
		"convertToStudent" : {
			"title" : "Convert To Student",
			"type" : "Select",
			"options" : [ {
				"val" : "True",
				"label" : "True"
			}, {
				"val" : "False",
				"label" : "False"
			} ],
			"editorClass" : "form-control input-md"
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
		"trainingApprovalLetter" : {
			"title" : "Training Approval Letter",
			"type" : "ImagePicker"
		},
		"dateOfJoining" : {
			"title" : "Date Of Joining",
			"type" : "DatePicker",
			"editorClass" : "form-control input-md"
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-candidate'),
	url : candidateBaseUrl + "/find",
	create : function() {
		this.url = candidateBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createv2 : function() {
		return candidateBaseUrl + "/create";
	},
	
	remove : function() {
		this.url = candidateBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('firstName');
	}
});

var CandidateCollection = Backbone.Collection.extend({
	model : Candidate,
	url : candidateBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-candidate'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	},
	getStudentList:function(){
		this.url=candidateBaseUrl + "/get-student-list";
    	return Backbone.ajaxSync('read', this);
	}
});

var CandidateCreateForm = Backbone.Form.extend({
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

		"convertToStudent" : {
			"title" : "Convert To Student",
			"type" : "Select",
			"options" : [ {
				"val" : "True",
				"label" : "True"
			}, {
				"val" : "False",
				"label" : "False"
			} ],
			"editorClass" : "form-control input-md"
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
			"type" : "ImagePicker"
		},
		"trainingApprovalLetter" : {
			"title" : "Training Approval Letter",
			"type" : "ImagePicker"
		},
		"dateOfJoining" : {
			"title" : "Date Of Joining",
			"type" : "DatePicker",
			"editorClass" : "form-control input-md"
		}
	}
});
// //change
var CandidateEditForm = Backbone.Form.extend({

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
		"convertToStudent" : {
			"title" : "Convert To Student",
			"type" : "Select",
			"options" : [ {
				"val" : "True",
				"label" : "True"
			}, {
				"val" : "False",
				"label" : "False"
			} ],
			"editorClass" : "form-control input-md"
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
			"type" : "ImagePicker"
		},
		"trainingApprovalLetter" : {
			"title" : "Training Approval Letter",
			"type" : "ImagePicker"
		},
		"dateOfJoining" : {
			"title" : "Date Of Joining",
			"type" : "DatePicker",
			"editorClass" : "form-control input-md"
		}
	}
});
