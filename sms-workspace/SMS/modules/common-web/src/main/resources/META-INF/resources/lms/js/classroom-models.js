var classRoomDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=643";
var classRoomDefId = 643;
var classRoomBaseUrl = "/api/jsonws/lms.classroom";
var classEnrollmentReqBaseUrl = "/api/jsonws/lms.classenrollmentreq";
var classResourceBaseUrl = "/api/jsonws/lms.classresource";

var ClassRoom = Backbone.Model.extend({
	label : 'Class Room',
	icon : '$ModelIconUrl$',
	visible : {
	"className": {
		"validators": [
			"required"
		],
		"type": "Text",
		"title": "Class Name",
		"editorClass": "red form-control",
		"editorAttrs": {
			"maxlength": "75"
		}
	},
	"description": {
		"validators": [
			"required"
		],
		"type": "Text",
		"title": "Description",
		"editorClass": "red form-control",
		"editorAttrs": {
			"maxlength": "75"
		}
	},
	"maxStudents": {
		"validators": [
			"required"
		],
		"type": "Text",
		"title": "Max Participants",
		"editorClass": "red form-control",
		"editorAttrs": {
			"maxlength": "3"
		}
	}
},
	localStorage : new Backbone.LocalStorage('tbl-classroom'),
	url : classRoomBaseUrl + "/find",
	create : function() {
		this.url = classRoomBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function() {
		return classRoomBaseUrl + "/create";
	},
	upload : function() {
		this.url = classRoomBaseUrl + "/upload";
		return Backbone.ajaxSync('create', this);
	},
	update : function() {
		this.url = classRoomBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function() {
		return classRoomBaseUrl + "/update";
	},
	importUrl : function() {
		return classRoomBaseUrl + "/upload";
	},
	join : function() {
		this.url = classResourceBaseUrl + "/join";
		return Backbone.ajaxSync('create', this);
	},
	remove : function() {
		this.url = classRoomBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	approve : function() {
		this.url = classRoomBaseUrl + "/approve";
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('className');
	},
	enrollmentReqCreateUrl : function() {
		return classEnrollmentReqBaseUrl + "/create";
	}
	
});

var ClassRoomCollection = Backbone.Collection.extend({
	model : ClassRoom,
	classEnrollDesignationKey:"classEnrollDesignationKey-v4",
	url : classRoomBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-classroom'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	},
	findEnrollmentReqDetail : function(classRoomId,resourceId) {
		//resourceId=106008;
	  this.url = classEnrollmentReqBaseUrl + "/find-enrollment-req?classRoomId="+classRoomId+"&participantId="+resourceId+"";
	 return Backbone.ajaxSync('create', this);
    },	
    getDesignationTypes : function() {
		this.url = classEnrollmentReqBaseUrl + "/get-designation-types";
		return Backbone.ajaxSync('read', this);
	},
	findDesignationTypesMap : function() {
		this.url = classEnrollmentReqBaseUrl + "/find-designation-types-map";
		return Backbone.ajaxSync('read', this);
	},
	findCourseByClass : function(type, classRoomId) {
		this.url = classResourceBaseUrl + "/find-by-class?associationType=" + type + "&classRoomId=" + classRoomId;
		return Backbone.ajaxSync('read', this);
	}

});

var ClassRoomCreateForm = Backbone.Form.extend({
	schema : {
		"className" : {
			"validators" : [ "required" ],
			"type" : "Text",
			"title" : "Class Name",
			"editorClass" : "red form-control",
			"editorAttrs" : {
				"maxlength" : "75"
			}
		},
		"description" : {
			"validators" : [ "required" ],
			"type" : "TextArea",
			"title" : "Description",
			"editorClass" : "red form-control",
			"editorAttrs" : {
				"maxlength" : "75"
			}
		},
		"maxStudents" : {
			"validators" : [ "required", "number" ],
			"type" : "Text",
			"title" : "Max Participants",
			"editorClass" : "red form-control",
			"editorAttrs" : {
				"maxlength" : "3"
			}
		},
		"courseCoordinatorId" : {
			"validators" : [ "required" ],
			"type" : "Select",
			"title" : "Internal Course Coordinator",
			"options" : new CourseCoordinatorCollection(),
			"editorClass" : "form-control"
		},
		"externalCourseCoordinatorId" : {
			
			"type" : "Select",
			"title" : "External Course Coordinator",
			"options" : new CourseCoordinatorCollection(),
			"editorClass" : "form-control"
		}
		
		
		
	}
});

var ClassRoomUploadForm = Backbone.Form.extend({
	schema : {
			"excelFile": {
				"type": "FilePicker",
				"title": "Select File (Excel Only)"
			}
		}
});

var ClassRoomEditForm = Backbone.Form.extend({
	schema : {
		"id" : {
			"type" : "Hidden",
			"title" : "ID"
		},
		"className" : {
			"validators" : [ "required" ],
			"type" : "Text",
			"title" : "Class Name",
			"editorClass" : "red form-control",
			"editorAttrs" : {
				"maxlength" : "75"
			}
		},
		"description" : {
			"validators" : [ "required" ],
			"type" : "TextArea",
			"title" : "Description",
			"editorClass" : "red form-control",
			"editorAttrs" : {
				"maxlength" : "75"
			}
		},
		"maxStudents" : {
			"validators" : [ "required", "number" ],
			"type" : "Text",
			"title" : "Max Participants",
			"editorClass" : "red form-control",
			"editorAttrs" : {
				"maxlength" : "3"
			}
		},
		"courseCoordinatorId" : {
			"validators" : [ "required" ],
			"type" : "Select",
			"title" : "Internal Course Coordinator",
			"options" : new CourseCoordinatorCollection(),
			"editorClass" : "form-control"
		},
		"externalCourseCoordinatorId" : {
			
			"type" : "Select",
			"title" : "External Course Coordinator",
			"options" : new CourseCoordinatorCollection(),
			"editorClass" : "form-control"
		}
	}
});




var ClassRoomEnrollmentCreateForm = Backbone.Form.extend({
	schema : {
		"classRoomId" : {
			"type" : "Hidden",
			"title" : "classRoomId",
			
			"validators" : [ "required" ]
		},
		"designation" : {
			type : 'Select',
			"title" : "Designation",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			"options" : new ClassRoomCollection()
			
		},
		"gradePay" : {
			"type" : "Text",
			"title" : "Grade Pay",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs :
			{
			placeholder : 'Grade Pay'
			}
		},
		"payLevel" : {
			"type" : "Text",
			"title" : "Pay Level",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs :
			{
			placeholder : 'Pay Level'
			}
		},
		"dateJoiningInService" : {
			"title" : "Date of Joining In Service",
			"type" : "DatePicker",
			"editorClass" : "form-control input-md",
			"validators" : [ "required" ]
		},
		"dateOfRetirement" : {
			"title" : "Date of Retirement",
			"type" : "DatePicker",
			"editorClass" : "form-control input-md",
			"validators" : [ "required" ]
		},
		"officeAddress" : {
			"type" : "TextArea",
			"title" : "Office Address",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs :
			{
			placeholder : 'Office Address'
			}
		}
		
		/*,
		"courseName" : {
			type : 'Select',
			"title" : "Course Name",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			"options" : new ClassRoomCollection()
			
		},
		"courseCode" : {
			"type" : "Text",
			"title" : "Course Code",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs :
			{
			placeholder : 'Course Code'
			}
		}
		
		,
		"courseName" : {
			"type" : "Text",
			"title" : "Course Name",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs :
			{
			placeholder : 'Course Name'
			}
		}*/
	
	}
});










