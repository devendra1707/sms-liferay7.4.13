var labContainerTemplateDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=184";
var labContainerTemplateDefId = 184;
var labContainerTemplateBaseUrl = "/api/jsonws/lms.labcontainertemplate";

var LabContainerTemplate = Backbone.Model.extend({
	label : 'Lab Container Template',
	icon : '$ModelIconUrl$',
	visible : {
		"title" : {
			"type" : "Text",
			"title" : "Template",
			"validators" : "required",
			"options" : 0,
			"regexp" : 0,
			"fieldclass" : 0
		},
		"description" : {
			"type" : "Text",
			"title" : "Description",
			"validators" : "required",
			"options" : 0,
			"regexp" : 0,
			"fieldclass" : 0
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-labcontainertemplate'),
	url : labContainerTemplateBaseUrl + "/default",
	create : function() {
		this.url = labContainerTemplateBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function() {
		return labContainerTemplateBaseUrl + "/create";
	},
	update : function() {
		this.url = labContainerTemplateBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function() {
		return labContainerTemplateBaseUrl + "/update";
	},
	remove : function() {
		this.url = labContainerTemplateBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('Lab Container Template');
	}
});

var LabContainerTemplateCollection = Backbone.Collection.extend({
	model : LabContainerTemplate,
	url : labContainerTemplateBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-labcontainertemplate'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	}
});

var LabContainerTemplateCreateForm = Backbone.Form.extend({
	schema : {
		"title" : {
			"type" : "Text",
			"title" : "Template",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
		},
		"description" : {
			"type" : "Text",
			"title" : "Description",
			"validators" : [ "required" ],
			"editorClass" : "form-control",
		}
	}
});

var LabContainerTemplateEditForm = Backbone.Form.extend({
	schema : {
		"title" : {
			"type" : "Text",
			"title" : "Template",
			"validators" : "required",
			"options" : 0,
			"regexp" : 0,
			"editorClass" : "form-control input-md",
		},
		"description" : {
			"type" : "Text",
			"title" : "Description",
			"validators" : "required",
			"options" : 0,
			"regexp" : 0,
			"editorClass" : "form-control",
		}
	}
});
