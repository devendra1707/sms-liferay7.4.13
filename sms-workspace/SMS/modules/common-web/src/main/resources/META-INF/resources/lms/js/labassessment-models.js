var labAssessmentDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=178";
var labAssessmentDefId = 178;
var labAssessmentBaseUrl = "/api/jsonws/lms.labassessment";

var LabAssessment = Backbone.Model.extend({
	label : 'Lab Assessment',
	icon : '$ModelIconUrl$',
	visible : {
		"courseId" : {
			"type" : "Select",
			"title" : "Course",
			"validators" : [ "required" ],
			"options" : "<Course>",
			"fieldclass" : 0
		},
		"assessmentLevel" : {
			"type" : "Select",
			"title" : "Assessment Level",
			"validators" : [ "required" ],
			"options" : "<AssessmentLevel>",
			"fieldclass" : 0
		},
		"passingScore" : {
			"title" : "Passing Score",
			"type" : "Text",
			"validators" : [ "required", "number" ]
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-labassessment'),
	url : labAssessmentBaseUrl + "/find",
	create : function() {
		this.url = labAssessmentBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function() {
		return labAssessmentBaseUrl + "/create";
	},
	update : function() {
		this.url = labAssessmentBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function() {
		return labAssessmentBaseUrl + "/update";
	},
	remove : function() {
		this.url = labAssessmentBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	publishLabAssessment : function(labAssessmentId) {
		this.url = labAssessmentBaseUrl + "/publish-lab-assessment";
		this.attributes['labAssessmentId'] = labAssessmentId;
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('assessmentLevel');
	}
});

var LabAssessmentCollection = Backbone.Collection.extend({
	model : LabAssessment,
	url : labAssessmentBaseUrl + "/find-all-lab-assessment-tab",
	localStorage : new Backbone.LocalStorage('tbl-labassessment'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	}
});
var LabAssessmentCreateForm = Backbone.Form.extend({
	schema : {
		"courseId" : {
			"type" : "Select",
			"title" : "Course",
			"validators" : [ "required" ],
			"options" : new CourseCollection(),
			"editorClass" : "form-control"
		},
		"assessmentLevel" : {
			"type" : "Select",
			"title" : "Assessment Level",
			"validators" : [ "required" ],
			"options" : new AssessmentLevelCollection(),
			"editorClass" : "form-control"
		},
		"passingScore" : {
			"title" : "Passing Score",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: '33',"maxlength" : 5}
		}
	}
});

var LabAssessmentEditForm = Backbone.Form.extend({
	schema : {
		"courseId" : {
			"type" : "Select",
			"title" : "Course",
			"validators" : [ "required" ],
			"options" : new CourseCollection(),
			"editorClass" : "form-control"
		},
		"assessmentLevel" : {
			"type" : "Select",
			"title" : "Assessment Level",
			"validators" : [ "required" ],
			"options" : new AssessmentLevelCollection(),
			"editorClass" : "form-control"
		},
		"passingScore" : {
			"title" : "Passing Score",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: '33',"maxlength" : 5}
		}
	}
});

