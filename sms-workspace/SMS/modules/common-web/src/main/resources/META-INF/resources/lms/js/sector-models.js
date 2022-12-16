var sectorDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=617";
var sectorDefId = 617;
var sectorBaseUrl = "/api/jsonws/lms.sector";

var Sector = Backbone.Model.extend({
	label : 'Sector',
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
			"maxlength": "75"
		}
	},
	"description": {
		"validators": [
			"required"
		],
		"type": "TextArea",
		"title": "Description",
		"editorClass": "form-control",
		"editorAttrs": {
			"maxlength": "250"
		}
	},
	"domainId": {
		"validators": [
			"required"
		],
		"type": "Select",
		"title": "Domain",
		"options": "<Domain>",
		"editorClass": "form-control"
	}
},
	localStorage : new Backbone.LocalStorage('tbl-sector'),
	url : sectorBaseUrl + "/find",
	create : function() {
		this.url = sectorBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function() {
		return sectorBaseUrl + "/create";
	},
	upload : function() {
		this.url = sectorBaseUrl + "/upload";
		return Backbone.ajaxSync('create', this);
	},
	update : function() {
		this.url = sectorBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function() {
		return sectorBaseUrl + "/update";
	},
	importUrl : function() {
		return sectorBaseUrl + "/upload";
	},
	remove : function() {
		this.url = sectorBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('title');
	},
	sectorCreateUrl : function() {

		return sectorBaseUrl + "/create-sector";
	}
});

var SectorCollection = Backbone.Collection.extend({
	model : Sector,
	url : sectorBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-sector'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	},
	findAllByUserId : function() {
			this.url = sectorBaseUrl + "/find-all-by-user-id";
			return Backbone.ajaxSync('read', this);
		}
});




var SectorCreateForm = Backbone.Form.extend({
	schema : {
		"title" : {
			"validators" : [ "required" ],
			"type" : "Text",
			"title" : "Title",
			"editorClass" : "red form-control",
			"editorAttrs" : {
				"maxlength" : "75"
			}
		},
		"description" : {
			"validators" : [ "required" ],
			"type" : "TextArea",
			"title" : "Description",
			"editorClass" : "form-control",
			"editorAttrs" : {
				"maxlength" : "250"
			}
		},
		"domainId" : {
			"validators" : [ "required" ],
			"type" : "Select",
			"title" : "Domain",
			"options" : new DomainCollection(),
			"editorClass" : "form-control"
		}
	}
});

var SectorUploadForm = Backbone.Form.extend({
	schema : {
			"excelFile": {
				"type": "FilePicker",
				"title": "Select File (Excel Only)"
			}
		}
});






var SectorEditForm = Backbone.Form.extend({
	schema : {
		
		"id" : {
			"validators" : [ "required" ],
			"type" : "Hidden",
			"title" : "title",
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
				"maxlength" : "75"
			}
		},
		"description" : {
			"validators" : [ "required" ],
			"type" : "TextArea",
			"title" : "Description",
			"editorClass" : "form-control",
			"editorAttrs" : {
				"maxlength" : "250"
			}
		},
		"domainId" : {
			"validators" : [ "required" ],
			"type" : "Select",
			"title" : "Domain",
			"options" : new DomainCollection(),
			"editorClass" : "form-control"
		}
	}
});





/*
var SectorEditForm = Backbone.Form.extend({
	schema : {
		
		"id" : {
			"validators" : [ "required" ],
			"type" : "Hidden",
			"title" : "title",
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
				"maxlength" : "75"
			}
		},
		"description" : {
			"validators" : [ "required" ],
			"type" : "TextArea",
			"title" : "Description",
			"editorClass" : "form-control",
			"editorAttrs" : {
				"maxlength" : "250"
			}
		},
		"domainId" : {
			"validators" : [ "required" ],
			"type" : "Select",
			"title" : "Domain",
			"options" : new DomainCollection(),
			"editorClass" : "form-control"
		}
	}
});
*/