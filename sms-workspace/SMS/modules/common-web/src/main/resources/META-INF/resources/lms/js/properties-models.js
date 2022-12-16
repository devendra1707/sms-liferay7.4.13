var propertiesDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=203";
var propertiesDefId = 203;
var propertiesBaseUrl = "/api/jsonws/lms.properties/";

var Properties = Backbone.Model.extend({
	label : 'Properties',
	icon : '$ModelIconUrl$',
	visible : {		
		"title" : {
			"type" : "Text",
			"title" : "Title",
			"validators" : [ "required" ],
			"fieldclass" : 0
		},
		"key" : {
			"type" : "Text",
			"title" : "Key",
			"validators" : [ "required" ],
			"fieldclass" : 0
		},
		"value" : {
			"type" : "Text",
			"title" : "Value",
			"validators" : [ "required" ],
			"fieldclass" : 0
		},
		"description" : {
			"type" : "Text",
			"title" : "Description",
			"validators" : [ "required" ],
			"fieldclass" : 0
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-properties'),
	url : propertiesBaseUrl + "/default",
	create : function() {
		this.url = propertiesBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function() {
		return propertiesBaseUrl + "/create";
	},
	update : function() {
		this.url = propertiesBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function() {
		return propertiesBaseUrl + "/update";
	},
	remove : function() {
		this.url = propertiesBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	findByLocaleCode : function(id, localeCode) {
		this.url = propertiesBaseUrl + "/find-by-locale-code";
		this.attributes["id"] = id;
		this.attributes["localeCode"] = localeCode;
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('Properties');
	}
});

var PropertiesCollection = Backbone.Collection.extend({
	model : Properties,
	url : propertiesBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-properties'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	}
});

var PropertiesCreateForm = Backbone.Form.extend({
	schema : {		
		"title" : {
			"type" : "Text",
			"title" : "Title",
			"validators" : [ "required" ],
			"fieldclass" : 0,
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Title'}
		},
		"key" : {
			"type" : "Text",
			"title" : "Key",
			"validators" : [ "required" ],
			"fieldclass" : 0,
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Key'}
		},
		"value" : {
			"type" : "Text",
			"title" : "Value",
			"validators" : [ "required" ],
			"fieldclass" : 0,
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Value'}
		},
		"description" : {
			"type" : "Text",
			"title" : "Description",
			"validators" : [ "required" ],
			"fieldclass" : 0,
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Description'}
		}
	}
});

var PropertiesEditForm = Backbone.Form.extend({
	schema : {		
		"title" : {
			"type" : "Text",
			"title" : "Title",
			"validators" : [ "required" ],
			"fieldclass" : 0,
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Title'}
		},
		"key" : {
			"type" : "Text",
			"title" : "Key",
			"validators" : [ "required" ],
			"fieldclass" : 0,
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Key'}
		},
		"value" : {
			"type" : "Text",
			"title" : "Value",
			"validators" : [ "required" ],
			"fieldclass" : 0,
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Value'}
		},
		"description" : {
			"type" : "Text",
			"title" : "Description",
			"validators" : [ "required" ],
			"fieldclass" : 0,
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Description'}
		}
	}
});
