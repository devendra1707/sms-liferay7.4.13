//var candidateDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=167";
//var studentDefId = 167;
var candidateBaseUrl = "/api/jsonws/lms.candidate";
var issBaseUrl = "/api/jsonws/lms.iss";
var lMSUniversityBaseUrl = "/api/jsonws/lms.lmsuniversity";


var Candidate = Backbone.Model.extend({
	label : 'Candidate',
	icon : '$ModelIconUrl$',
	visible : {
		"id" : {
			"title" : "ID",
			"type" : "Hidden"
		},
		"organizationName" : {
			"title" : "Select Organization",
			"type" : "Select",
			"options" : [ ],
			"validators" : [ "text", "required" ],
			"editorClass" : "form-control input-md"
		},
		"firstName" : {
			"title" : "First Name",
			"type" : "Text",
			"validators" : [ "text", "required" ],
		    "editorClass" : "form-control input-md"
		},
		"lastName" : {
			"title" : "Last Name",
			"type" : "Text",
			"validators" : [ "text"],
		    "editorClass" : "form-control input-md"
		},
		"email" : {
			"title" : "Email",
			"requered" : "true",
			"validators" : [ "email", "required" ],
		    "editorClass" : "form-control input-md"
		},
		"gender" : {
			"title" : "Gender",
			"type" : "Select",
			"options" : [ "Male", "Female" ,"Transgender"],
			"validators" : [ "text", "required" ],
			"editorClass" : "form-control input-md"
		},
		"contactNumber" : {
			"title" : "Contact Number",
			"type" : "Text",
			"validators" : [ "phone", "required" ],
		    "editorClass" : "form-control input-md"
		},
		"address" : {
			"title" : "Address",
			"type" : "TextArea",
			"validators" : [ "required" ],
		    "editorClass" : "form-control input-md"
		},
		"candidateCategoryId" : {
			"type" : "Select",
			"title" : "Select Category",
			"validators" : [ "required" ],
			"options" : new CandidateCategoryCollection(),
		    "editorClass" : "form-control input-md",
			"fieldclass" : 0
		},
		"candidateId" : {
			"title" : "ID",
			"type" : "Text"
		},
		"attachment" : {
			"title" : "Attachment",
			"type" : "PDFFilePicker",
			"help" : ".pdf files only upto 5MB",
			"validators" : [ "required" ]
		},
		"dateOfJoining" : {
			"title" : "Date Of Joining",
			"type" : "StartCurrentDatePicker",
			"editorClass" : "form-control input-md",
			"validators" : [ "required" ]
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-candidate'),
	url : candidateBaseUrl + "/find",
	create : function() {
		this.url = candidateBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createWithNoFile : function() {
		this.url = candidateBaseUrl + "/create-with-no-file";
		return Backbone.ajaxSync('create', this);
	},
	createv2 : function() {
		
		return candidateBaseUrl + "/create";
	},
	remove : function() {
		this.url = candidateBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	activate : function(candidateId) {
		this.url = "/web/lms/user-activation?id="+candidateId;
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('firstName');
	}
});

var CandidateCollection = Backbone.Collection.extend({
	model : Candidate,
	candidateEmployerTypesKey:'candidateEmployerTypesKey-v4',
	candidateApplicantCategoryKey:'candidateApplicantCategoryKey-v4',
	url : candidateBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-candidate'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	},
	findAllCandidate:function(){
		this.url=candidateBaseUrl + "/find-all-candidate";
    	return Backbone.ajaxSync('read', this);
	},
	findByStatus:function(status){
		this.url=candidateBaseUrl + "/find-by-status?status="+status;
    	return Backbone.ajaxSync('read', this);
	},
	find:function(id){
		this.url=candidateBaseUrl + "/find?id="+id;
    	return Backbone.ajaxSync('read', this);
	},
	setStatus:function(id,status){
		this.url=candidateBaseUrl + "/set-status?id="+id+"&status="+status;
    	//this.attributes["id"]=id;
    	//this.attributes["status"]=status;
    	return Backbone.ajaxSync('create', this);
	},
	deleteCandidate:function(id){
		this.url=candidateBaseUrl + "/delete?id="+id;
    	return Backbone.ajaxSync('read', this);
	},
	findOrganizations : function() {
		this.url = candidateBaseUrl + "/find-organizations";
		return Backbone.ajaxSync('create', this);
	},
	findISSbyOID:function(oid){
		this.url=issBaseUrl + "/find-by-oid?oid="+oid;
    	return Backbone.ajaxSync('read', this);
	},
	getApplicantCategory : function() {
			this.url = candidateBaseUrl + "/get-applicant-category";
			return Backbone.ajaxSync('read', this);
		},
	findApplicantCategoryMap : function() {
			this.url = candidateBaseUrl + "/find-applicant-category-map";
			return Backbone.ajaxSync('read', this);
		},
	getEmployerTypes : function() {
			this.url = candidateBaseUrl + "/get-employer-types";
			return Backbone.ajaxSync('read', this);
		},
	findEmployerTypesMap : function() {
			this.url = candidateBaseUrl + "/find-employer-types-map";
			return Backbone.ajaxSync('read', this);
		},
	findAllUniversityCollege : function() {
			this.url = lMSUniversityBaseUrl + "/find-all";
			return Backbone.ajaxSync('read', this);
		}	
	
});
/*
var CandidateCreateForm = Backbone.Form.extend({
	schema : {
		"organizationName" : {
			"title" : "Select Organization",
			"type" : "Select",
			"options" : [ ],
			"validators" : [ "text", "required" ],
			"editorClass" : "form-control input-md"
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
		"candidateCategoryId" : {
			"type" : "Select",
			"title" : "Select Category",
			"validators" : [ "required" ],
			"options" : new CandidateCategoryCollection(),
			"fieldclass" : 0,
		    "editorClass" : "form-control input-md"
		},
		"candidateId" : {
			"title" : "ID",
			"type" : "Text",
		    "editorClass" : "form-control input-md"
		},
		"attachment" : {
			"title" : "Attachment",
			"type" : "PDFFilePicker",
			"help" : ".pdf files only upto 5MB",
			"editorClass" : "form-control input-md"
		},
		"dateOfJoining" : {
			"title" : "Date Of Joining",
			"type" : "StartCurrentDatePicker",
			"editorClass" : "form-control input-md"
		}
	}
}); */
// //change
var CandidateEditForm = Backbone.Form.extend({

	schema : {
		"id" : {
			"title" : "ID",
			"type" : "Hidden"
		},
		"organizationName" : {
			"title" : "Select Organization",
			"type" : "Select",
			"options" : [ ],
			"validators" : [ "text", "required" ],
			"editorClass" : "form-control input-md"
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
		"candidateCategoryId" : {
			"type" : "Select",
			"title" : "Select Category",
			"validators" : [ "required" ],
			"options" : new CandidateCategoryCollection(),
			"fieldclass" : 0
		},
		"candidateId" : {
			"title" : "ID",
			"type" : "Text"
		},
		"attachment" : {
			"title" : "Attachment",
			"type" : "PDFFilePicker",
			"help" : ".pdf files only upto 5MB"
		},
		"dateOfJoining" : {
			"title" : "Date Of Joining",
			"type" : "StartCurrentDatePicker",
			"editorClass" : "form-control input-md"
		}
	}
});




var CandidateCreateForm = Backbone.Form.extend({
	schema : {
		"organizationName" : {
			"title" : "Select Organization",
			"type" : "Select",
			"options" : [ ],
			"validators" : [ "text", "required" ],
			"editorClass" : "form-control input-md"
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
		"fatherName" : {
			"title" : "Father's name",
			"type" : "Text",
			"validators" : [ "text", "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Father name'
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
		}
		,
		"email" : {
			"title" : "Email-ID(NIC email id for ISS/SSS officials and private email id for others)",
			"required" : true,
			"pattern" : "email",
			"validators" : [ "email", "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'abc@example.com'
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
			"title" : "Mobile Number with country code",
			"type" : "Text",
			"validators" : [ "phone", "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : '1234567890'
			}
		},
		"typeOfEmployerId" : {
			"type" : "Select",
			"title" : "Type of Employer",
			"validators" : [ "required" ],
			"options" : new CandidateCollection(),
			"fieldclass" : 0,
		    "editorClass" : "form-control input-md"
		},
		"idIssuedByEmpUniv" : {
			"title" : "ID Issued by Employer/University",
			"type" : "Text",
			"validators" : ["required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'ID Issued by Employer/University'
			}
		},
		"nationality" : {
		"title" : "Nationality",
		"type" : "Select",
		"options" : [ {
			"val" : "Indian",
			"label" : "Indian"
		}, {
			"val" : "International",
			"label" : "International"
		} ],
		"validators" : [ "text", "required" ],
		"editorClass" : "form-control input-md"
		},
		"universityCollegeId" : {
		/*	"type" : "Select",
			"title" : "University/College(If Student)",
			//"validators" : [ "required" ],
			"options" : new CandidateCategoryCollection(),
			"fieldclass" : 0,
		    "editorClass" : "form-control input-md"
		   	
		    "title" : "University/College(If Student)",
			"type" : "Text",
			"validators" : [ "required"],
			"editorClass" : "form-control input-md",
			 editorAttrs : {
				placeholder : 'University/College(If Student)'
			} 	 */
			
			"type" : "Select",
			"title" : "University/College(If Student)",
			"validators" : [ "required" ],
			"options" : new CandidateCollection(),
			"fieldclass" : 0,
		    "editorClass" : "form-control input-md"
		},		
		"address" : {
			"title" : "Address-Country",
			"type" : "Text",
			"validators" : [  "required", "addressRegex" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Address-Country'
			}
		},
		"state" : {
			"title" : "State",
			"type" : "Text",
			"validators" : [ "required" , "addressRegex" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'State'
			}
		},
		"district" : {
			"title" : "District",
			"type" : "Text",
			"validators" : [  "required" ,"addressRegex" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'District'
			}
		},
		"city" : {
			"title" : "City",
			"type" : "Text",
			"validators" : [ "required" ,"addressRegex" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'City'
			}
		}, 
		"village" : {
			"title" : "Village/Colony/Street/Apartment",
			"type" : "Text",
			"validators" : [  "required", "addressRegex" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Village/Colony/Street/Apartment'
			}
		},
		
		"applicantCategory" : {
			"type" : "Select",
			"title" : "Applicant Category",
			"validators" : [ "required" ],
			"options" : new CandidateCollection(),
			"fieldclass" : 0,
		    "editorClass" : "form-control input-md"
		},
		/*
		"candidateCategoryId" : {
			"type" : "Select",
			"title" : "Select Category",
			"validators" : [ "required" ],
			"options" : new CandidateCollection(),
			"fieldclass" : 0,
		    "editorClass" : "form-control input-md"
		},*/
		"candidateId" : {
			"title" : "ID",
			"type" : "Text",
		    "editorClass" : "form-control input-md"
		},
		"attachment" : {
			"title" : "Attachment",
			"type" : "PDFFilePicker",
			"help" : ".pdf files only upto 5MB",
			"editorClass" : "form-control input-md"
		},
		"dateOfJoining" : {
			"title" : "Date Of Joining",
			"type" : "StartCurrentDatePicker",
			"editorClass" : "form-control input-md"
		}
	}
});

