var notificationDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=182";
var notificationDefId = 182;
var notificationBaseUrl = "/api/jsonws/lms.notification";
// var notificationBaseUrl =
// "http://portal.armantecsystems.com/api/jsonws/LMS-portlet.notification";

var Notification = Backbone.Model.extend({
	label : 'Notification',
	icon : '$ModelIconUrl$',
	visible : {
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
			},
			"userNotificationEventId" : {
			"title" : "User Notification Event Id",
			"type" : "Text",
			"validators" : [ "required", "number" ]
		},
		"payload" : {
			"title" : "Payload",
			"type" : "Text",
			"validators" : [ "required" ]
		},
		"liferayDelivered" : {
			"title" : "Liferay Delivered Notification",
			"type" : "Text",
			"validators" : [ "required" ]
		},
		"mobileDelivered" : {
			"title" : "Mobile Delivered Notification",
			"type" : "Text",
			"validators" : [ "required" ]
		},
		"notificationType" : {
			"title" : "Notification Type",
			"type" : "Text",
			"validators" : [ "required" ]
		},
		"liferayDeliveredTimestamp" : {
			"title" : "Liferay Delivered Timestamp",
			"type" : "Text",
			"validators" : [ "required", "number" ]
		},
		"mobileDeliveredTimestamp" : {
			"title" : "Mobile Delivered Timestamp",
			"type" : "Text",
			"validators" : [ "required", "number" ]
		},
		"liferayDeliverBy" : {
			"title" : "Liferay Deliver By",
			"type" : "Text",
			"validators" : [ "required" ]
		},
		"mobileDeliverBy" : {
			"title" : "Mobile Deliver By",
			"type" : "Text",
			"validators" : [ "required" ]
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-notification'),
	url : notificationBaseUrl + "/find",
	create : function() {
		this.url = notificationBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function() {
		return notificationBaseUrl + "/create";
	},
	update : function() {
		this.url = notificationBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function() {
		return notificationBaseUrl + "/update";
	},
	remove : function() {
		this.url = notificationBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('title');
	}
});

var NotificationCollection = Backbone.Collection.extend({
	model : Notification,
	url : notificationBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-notification'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	},
	downloadDelivered : function(filter) {
		this.url = notificationBaseUrl + "/find-all-delivered-notification";
		return Backbone.ajaxSync('read', this);
	},
	downloadDeliveredByLocale : function(filter) {
		this.url = notificationBaseUrl + "/find-all-delivered-notification-by-locale";
		return Backbone.ajaxSync('read', this);
	}
});
var NotificationCreateForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
			},
			"email" : {
			"type" : "Select",
			"title" : "Email",
			"validators" : [ "required" ],
			"options" : "<Student>",
			"editorClass" : "form-control",
			"editorAttrs" : {
				"multiple" : "multiple"
			}
		},
		"title" : {
			"title" : "Title",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Notification Title'}
		},
		"message" : {
			"title" : "Message",
			"type" : "TextArea",
			"validators" : [ "required" ],
			"editorClass" : "form-control",
			editorAttrs: {placeholder: 'Message...'}
		}
	}
});
var GroupNotificationCreateForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
			},
			"groupId" : {
			"type" : "Select",
			"title" : "Group",
			"validators" : [ "required" ],
			"options" : "<StudentGroup>",
			"editorClass" : "form-control",
			"editorAttrs" : {
				"multiple" : "multiple"
			}
		},
		"title" : {
			"title" : "Title",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Notification Title'}
		},
		"message" : {
			"title" : "Message",
			"type" : "TextArea",
			"validators" : [ "required" ],
			"editorClass" : "form-control",
			editorAttrs: {placeholder: 'Message...'}
		}
	}
});

var DefaultNotificationCreateForm = Backbone.Form.extend({
	schema : {
		"userNotificationEventId" : {
			"title" : "User Notification Event Id",
			"type" : "Text",
			"validators" : [ "required", "number" ]
		},
		"payload" : {
			"title" : "Payload",
			"type" : "Text",
			"validators" : [ "required" ]
		},
		"liferayDelivered" : {
			"title" : "Liferay Delivered Notification",
			"type" : "Text",
			"validators" : [ "required" ]
		},
		"mobileDelivered" : {
			"title" : "Mobile Delivered Notification",
			"type" : "Text",
			"validators" : [ "required" ]
		},
		"notificationType" : {
			"title" : "Notification Type",
			"type" : "Text",
			"validators" : [ "required" ]
		},
		"liferayDeliveredTimestamp" : {
			"title" : "Liferay Delivered Timestamp",
			"type" : "Text",
			"validators" : [ "required", "number" ]
		},
		"mobileDeliveredTimestamp" : {
			"title" : "Mobile Delivered Timestamp",
			"type" : "Text",
			"validators" : [ "required", "number" ]
		},
		"liferayDeliverBy" : {
			"title" : "Liferay Deliver By",
			"type" : "Text",
			"validators" : [ "required" ]
		},
		"mobileDeliverBy" : {
			"title" : "Mobile Deliver By",
			"type" : "Text",
			"validators" : [ "required" ]
		}
	}
});

var NotificationEditForm = Backbone.Form.extend({
	schema : {
		"userNotificationEventId" : {
			"title" : "User Notification Event Id",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md"
		},
		"payload" : {
			"title" : "Payload",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md"
		},
		"liferayDelivered" : {
			"title" : "Liferay Delivered Notification",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md"
		},
		"mobileDelivered" : {
			"title" : "Mobile Delivered Notification",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md"
		},
		"notificationType" : {
			"title" : "Notification Type",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md"
		},
		"liferayDeliveredTimestamp" : {
			"title" : "Liferay Delivered Timestamp",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md"
		},
		"mobileDeliveredTimestamp" : {
			"title" : "Mobile Delivered Timestamp",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md"
		},
		"liferayDeliverBy" : {
			"title" : "Liferay Deliver By",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md"
		},
		"mobileDeliverBy" : {
			"title" : "Mobile Deliver By",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md"
		}
	}
});
