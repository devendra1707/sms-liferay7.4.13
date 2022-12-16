var knowledgeBaseDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=208";
var knowledgeBaseDefId = 208;
var knowledgeBaseBaseUrl = "/api/jsonws/lms.knowledgebase";

var KnowledgeBase = Backbone.Model.extend({
	label : 'KnowledgeBase',
	icon : '$ModelIconUrl$',
	visible : {
		"localeCode" : {
			"title" : "Select Language",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"title" : {
			"type" : "Text",
			"title" : "Title",
			"validators" : [ "required" ]
		},
		"link" : {
			"type" : "Text",
			"title" : "Link",
			"validators" : [ "required", "knowledgeBaseLink" ]
		},
		"content" : {
			"type" : "Text",
			"title" : "Content",
			"validators" : [ "required" ]
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-knowledgebase'),
	url : knowledgeBaseBaseUrl + "/find",
	create : function() {
		this.url = knowledgeBaseBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function() {
		return knowledgeBaseBaseUrl + "/create";
	},
	update : function() {
		this.url = knowledgeBaseBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function() {
		return knowledgeBaseBaseUrl + "/update";
	},
	remove : function() {
		this.url = knowledgeBaseBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	findByLocaleCode : function(id,localeCode) {
		this.url = knowledgeBaseBaseUrl + "/find-by-locale-code";
		this.attributes["id"] = id;
		this.attributes["localeCode"] = localeCode;
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('title');
	}
});

var KnowledgeBaseCollection = Backbone.Collection.extend({
	model : KnowledgeBase,
	url : knowledgeBaseBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-knowledgebase'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	}
});

var KnowledgeBaseCreateForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
			"title" : "Select Language",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"title" : {
			"type" : "Text",
			"title" : "Title",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Title'}
		},
		"link" : {
			"type" : "Text",
			"title" : "Link",
			"validators" : [ "required", "knowledgeBaseLink" ],
			"editorClass" : "form-control input-md"
		},
		"content" : {
			"type" : "Text",
			"title" : "Content",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md"
		}
	}
});

var KnowledgeBaseEditForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
			"title" : "Select Language",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"title" : {
			"type" : "Text",
			"title" : "Title",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Title'}
		},
		"link" : {
			"type" : "Text",
			"title" : "Link",
			"validators" : [ "required", "knowledgeBaseLink" ],
			"editorClass" : "form-control input-md"
		},
		"content" : {
			"type" : "Text",
			"title" : "Content",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md"
		}
	}
});
