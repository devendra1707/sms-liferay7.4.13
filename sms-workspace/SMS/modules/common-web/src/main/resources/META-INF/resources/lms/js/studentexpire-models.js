var StudentLicenceBaseUrl = "/api/jsonws/lms.studentlicence";


var StudentLicence = Backbone.Model.extend({
	label : 'StudentLicence',
	icon : '$ModelIconUrl$',
	idAttribute : 'id',
	visible : {
		"studentId" : {
			"title" : "Student Title",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : "<Student>",
		},
		"expiryDate" : {
			"title" : "Expiry Date",
			"type" : "DateTimePickerBootstrap",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Expiry Date'
			}
		}

	},
	localStorage : new Backbone.LocalStorage('StudentLicence'),
	url : StudentLicenceBaseUrl + "/find",
	create : function() {
		this.url = StudentLicenceBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	update : function() {
		this.url = StudentLicenceBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	deleteStudentLicence : function(id) {
		this.url = StudentLicenceBaseUrl + "/delete?id="+id;
		return Backbone.ajaxSync('create', this);
	}
});


var StudentLicenceCollection = Backbone.Collection.extend({
	model : StudentLicence,
	url : StudentLicenceBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-StudentLicence'),
	download : function() {
		return Backbone.ajaxSync('read', this);
	},
	findAllStudentLicence : function() {
		this.url = StudentLicenceBaseUrl + "/find-all-student-for-expiry";
		return Backbone.ajaxSync('read', this);
	}
});


var StudentLicenceCreateForm = Backbone.Form.extend({
	schema : {

		"studentId" : {
			"title" : "Student Title",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new StudentCollection(),
			"editorClass" : "form-control"
		},
		"expiryDate" : {
			"title" : "Expiry Date",
			"type" : "DateTimePickerBootstrap",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Expiry Date'
			}
		}

	}
});

var StudentLicenceEditForm = Backbone.Form.extend({
	schema : {
		"id" : {
			"id" : "ID",
			"type" : "Hidden"
		},
		"studentId" : {
			"title" : "Student Id",
			"type" : "Hidden",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {"disabled" : true}
		},
		"studentName" : {
			"title" : "Student Title",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {"disabled" : true}
		},
		"expiryDate" : {
			"title" : "Expiry Date",
			"type" : "DateTimePickerBootstrap",
			"validators" : [  "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Expiry Date'
			}
		}

	}
});

