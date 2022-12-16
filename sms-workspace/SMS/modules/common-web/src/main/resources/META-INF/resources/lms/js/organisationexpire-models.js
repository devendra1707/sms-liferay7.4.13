var OrganisationExpiryBaseUrl = "/api/jsonws/lms.organisationlicence";


var OrganisationExpiry = Backbone.Model.extend({
	label : 'OrganisationExpiry',
	icon : '$ModelIconUrl$',
	idAttribute : 'id',
	visible : {
		"groupId" : {
			"title" : "Organization Title",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : "<OrganisationExpiry>",
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
	localStorage : new Backbone.LocalStorage('OrganisationExpiry'),
	url : OrganisationExpiryBaseUrl + "/find",
	create : function() {
		this.url = OrganisationExpiryBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	update : function() {
		this.url = OrganisationExpiryBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	deleteOrganization : function(id) {
		this.url = OrganisationExpiryBaseUrl + "/delete?id="+id;
		return Backbone.ajaxSync('create', this);
	}
});


var OrganisationExpiryCollection = Backbone.Collection.extend({
	model : OrganisationExpiry,
	url : OrganisationExpiryBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-OrganisationExpiry'),
	download : function() {
		return Backbone.ajaxSync('read', this);
	},
	findAllOrganisation : function() {
		this.url = OrganisationExpiryBaseUrl + "/find-all-organisation";
		return Backbone.ajaxSync('read', this);
	}
});


var OrganisationExpiryCreateForm = Backbone.Form.extend({
	schema : {

		"groupId" : {
			"title" : "Organization Title",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new OrganisationExpiryCollection(),
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

var OrganisationExpiryEditForm = Backbone.Form.extend({
	schema : {
		"id" : {
			"id" : "ID",
			"type" : "Hidden"
		},
		"groupId" : {
			"title" : "Organization Id",
			"type" : "Hidden",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {"disabled" : true}
		},
		"name" : {
			"title" : "Organization Title",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {"disabled" : true}
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

