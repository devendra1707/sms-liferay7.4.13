var OrgDefaultLocaleBaseUrl = "/api/jsonws/lms.orgdefaultlocale";


var OrgDefaultLocale = Backbone.Model.extend({
	label : 'OrganisationExpiry',
	icon : '$ModelIconUrl$',
	idAttribute : 'id',
	visible : {
		
		"localeCode" : {
			"title" : "Default Flag",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : "<OrganisationExpiry1>",
		},

	},
	localStorage : new Backbone.LocalStorage('OrganisationExpiry'),
	url : OrgDefaultLocaleBaseUrl + "/find",
	create : function() {
		this.url = OrgDefaultLocaleBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	update : function() {
		this.url = OrgDefaultLocaleBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	deleteOrganization : function(id) {
		this.url = OrgDefaultLocaleBaseUrl + "/delete?id="+id;
		return Backbone.ajaxSync('create', this);
	},
	findByGroupdefault : function(id) {
		this.url = OrgDefaultLocaleBaseUrl + "/find-by-groupdefault";
		return Backbone.ajaxSync('read', this);
	}
});

var OrgDefaultLocaleCollection = Backbone.Collection.extend({
	model : OrganisationExpiry,
	url : OrgDefaultLocaleBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-OrgDefaultLocale'),
	download : function() {
		return Backbone.ajaxSync('read', this);
	},
	findAllOrganisation : function() {
		this.url = OrgDefaultLocaleBaseUrl + "/find-all-organisation";
		return Backbone.ajaxSync('read', this);
	},
	findAllFlag : function() {
		this.url = OrgDefaultLocaleBaseUrl + "/find-all-flag";
		return Backbone.ajaxSync('read', this);
	}
});

var OrgDefaultLocaleCreateForm = Backbone.Form.extend({
	schema : {
		
		"localeCode" : {
			"title" : "Default Flag",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new LocaleInfoCollection()
		},
	}
});

var OrgDefaultLocaleEditForm = Backbone.Form.extend({
	schema : {
		
		"localeCode" : {
			"title" : "Default Flag",
			"type" : "Select",
			"validators" : [ "required" ],
		//	"options" : new LocaleInfoCollection()
		},

	}
});

