var announcementDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=181";
var announcementDefId = 181;
var announcementBaseUrl = "/api/jsonws/lms.announcement";

var Announcement = Backbone.Model.extend({
	label : 'Announcement',
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
			"title" : "Announcement Name",
			"type" : "Text",
			"validators" : [ "required" ]
		},
		"content" : {
			"title" : "Content",
			"type" : "TextArea",
			"validators" : [ "required" ]
		},
		"displayDate" : {
			"type" : "DateTimePickerBootstrap",
			"title" : "Display Date",
			"validators" : [ "required" ],
			"fieldClass" : ""
		},
		"expiryDate" : {
			"type" : "DateTimePickerBootstrap",
			"title" : "Expiry Date",
			"validators" : [ "required" ],
			"fieldClass" : ""
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-announcement'),
	url : announcementBaseUrl + "/find",
	create : function() {
		this.url = announcementBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function() {
		return announcementBaseUrl + "/create";
	},
	update : function() {
		this.url = announcementBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function() {
		return announcementBaseUrl + "/update";
	},
	remove : function() {
		this.url = announcementBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	findByLocaleCode : function(id, localeCode) {
		this.url = announcementBaseUrl + "/find-by-locale-code";
		this.attributes["id"] = id;
		this.attributes["localeCode"] = localeCode;
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('title');
	}
});

var AnnouncementCollection = Backbone.Collection.extend({
	model : Announcement,
	url : announcementBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-announcement'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	}
});

var AnnouncementCreateForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
			"title" : "Select Language",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"title" : {
			"title" : "Announcement Name",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Announcement Name'}
		},
		"content" : {
			"title" : "Content",
			"type" : "TextArea",
			"validators" : [ "required" ]			
		},
		"displayDate" : {
			"type" : "DateTimePickerBootstrap",
			"title" : "Display Date",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md"
		},
		"expiryDate" : {
			"type" : "DateTimePickerBootstrap",
			"title" : "Expiry Date",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md"
		}
	}
});

var AnnouncementEditForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
			"title" : "Select Language",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"title" : {
			"title" : "Announcement Name",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Announcement Name'}
		},
		"content" : {
			"title" : "Content",
			"type" : "TextArea",
			"validators" : [ "required" ]
		},
		"displayDate" : {
			"type" : "DateTimePickerBootstrap",
			"title" : "Display Date",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md"
		},
		"expiryDate" : {
			"type" : "DateTimePickerBootstrap",
			"title" : "Expiry Date",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md"
		}
	}
});
