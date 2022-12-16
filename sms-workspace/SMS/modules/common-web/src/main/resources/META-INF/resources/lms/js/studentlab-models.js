var studentLabDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=186";
var studentLabDefId = 186;
// var studentLabBaseUrl =
// "http://portal.armantecsystems.com/api/jsonws/LMS-portlet.studentlab";
var studentLabBaseUrl = "/api/jsonws/lms.studentlab";

var StudentLab = Backbone.Model.extend({
	label : 'Student Lab',
	icon : '$ModelIconUrl$',
	visible : {
		"labId" : {
			"type" : "Select",
			"title" : "Lab",
			"validators" : "required",
			"options" : "<Lab>",
			"regexp" : 0,
			"fieldclass" : 0
		},
		"studentId" : {
			"type" : "Select",
			"title" : "Student",
			"validators" : "required",
			"options" : "<Student>",
			"regexp" : 0,
			"fieldclass" : 0
		},
		"score" : {
			"type" : "Text",
			"title" : "Score",
			"validators" : "required",
			"options" : "",
			"regexp" : 0,
			"fieldclass" : 0
		},
		"status" : {
			"type" : "Text",
			"title" : "Status",
			"validators" : "required",
			"options" : "",
			"regexp" : 0,
			"fieldclass" : 0
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-studentlab'),
	url : studentLabBaseUrl + "/find",
	create : function() {
		this.url = studentLabBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function() {
		return studentLabBaseUrl + "/create";
	},
	update : function() {
		this.url = studentLabBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function() {
		return studentLabBaseUrl + "/update";
	},
	remove : function() {
		this.url = studentLabBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	stopLab : function() {
		this.url = studentLabBaseUrl + "/stop-lab";
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('labId');
	}
});

var StudentLabCollection = Backbone.Collection.extend({
	model : StudentLab,
	url : studentLabBaseUrl + "/find-all-detail",
	localStorage : new Backbone.LocalStorage('tbl-studentlab'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	},
	findAllUniqueDetail : function(filter) {
		this.url = studentLabBaseUrl + "/find-all-unique-detail";
		return Backbone.ajaxSync('read', this);
	}
});

var StudentLabCreateForm = Backbone.Form.extend({
	schema : {
		"labId" : {
			"type" : "Select",
			"title" : "Lab",
			"validators" : [ "required" ],
			"options" : new LabCollection(),
			"fieldclass" : 0
		},
		"studentId" : {
			"type" : "Select",
			"title" : "Student",
			"validators" : [ "required" ],
			"options" : new StudentCollection(),
			"fieldclass" : 0
		},
		"score" : {
			"type" : "Text",
			"title" : "Score",
			"validators" : [ "required" ],
			"fieldclass" : 0
		}
	}
});

var StudentLabEditForm = Backbone.Form.extend({
	schema : {
		"labId" : {
			"type" : "Select",
			"title" : "Lab",
			"validators" : "required",
			"options" : new LabCollection(),
			"regexp" : 0,
			"fieldclass" : 0
		},
		"studentId" : {
			"type" : "Select",
			"title" : "Student",
			"validators" : "required",
			"options" : new StudentCollection(),
			"regexp" : 0,
			"fieldclass" : 0
		},
		"score" : {
			"type" : "Text",
			"title" : "Score",
			"validators" : "required",
			"options" : "",
			"regexp" : 0,
			"fieldclass" : 0
		}
	}
});
