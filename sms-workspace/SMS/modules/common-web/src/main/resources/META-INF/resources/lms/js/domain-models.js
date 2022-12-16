var domainDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=620";
var domainDefId = 620;
var domainBaseUrl = "/api/jsonws/lms.domain";

var Domain = Backbone.Model.extend({
	label : 'Domain',
	icon : '$ModelIconUrl$',
	visible : {
	"title": {
		"validators": [
			"required"
		],
		"type": "Text",
		"title": "Title",
		"editorClass": "red form-control",
		"editorAttrs": {
			"maxlength": "50"
		}
	},
	"description": {
		"validators": [
			"required"
		],
		"type": "TextArea",
		"title": "Description",
		"editorClass": "form-control"
	}
},
	localStorage : new Backbone.LocalStorage('tbl-domain'),
	url : domainBaseUrl + "/find",
	create : function() {
		this.url = domainBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function() {
		return domainBaseUrl + "/create";
	},
	upload : function() {
		this.url = domainBaseUrl + "/upload";
		return Backbone.ajaxSync('create', this);
	},
	update : function() {
		this.url = domainBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function() {
		return domainBaseUrl + "/update";
	},
	importUrl : function() {
		return domainBaseUrl + "/upload";
	},
	remove : function() {
		this.url = domainBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('title');
	}
});

var DomainCollection = Backbone.Collection.extend({
	model : Domain,
	url : domainBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-domain'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	},
    findAllByCourseDirectorId : function() {
			this.url = domainBaseUrl + "/find-all-by-course-director-id";
			return Backbone.ajaxSync('read', this);
		}

});

var DomainCreateForm = Backbone.Form.extend({
	schema : {
		"title" : {
			"validators" : [ "required" ],
			"type" : "Text",
			"title" : "Title",
			"editorClass" : "red form-control",
			"editorAttrs" : {
				"maxlength" : "50"
			}
		},
		"description" : {
			"validators" : [ "required" ],
			"type" : "TextArea",
			"title" : "Description",
			"editorClass" : "form-control"
		},
		"courseDirectorId" : {
			"validators" : [ "required" ],
			"type" : "Select",
			"title" : "Course Director",
			"options" : new CourseDirectorCollection(),
			"editorClass" : "form-control"
		}
	}
});

var DomainUploadForm = Backbone.Form.extend({
	schema : {
			"excelFile": {
				"type": "FilePicker",
				"title": "Select File (Excel Only)"
			}
		}
});

var DomainEditForm = Backbone.Form.extend({
	schema : {
		"id" : {
			"validators" : [ "required" ],
			"type" : "Hidden",
			"title" : "id",
			"editorClass" : "red form-control",
			"editorAttrs" : {
				"maxlength" : "50"
			}
		},
		"title" : {
			"validators" : [ "required" ],
			"type" : "Text",
			"title" : "Title",
			"editorClass" : "red form-control",
			"editorAttrs" : {
				"maxlength" : "50"
			}
		},
		"description" : {
			"validators" : [ "required" ],
			"type" : "TextArea",
			"title" : "Description",
			"editorClass" : "form-control"
		},
		"courseDirectorId" : {
			"validators" : [ "required" ],
			"type" : "Select",
			"title" : "Course Director",
			"options" : new CourseDirectorCollection(),
			"editorClass" : "form-control"
		}
	}
});
