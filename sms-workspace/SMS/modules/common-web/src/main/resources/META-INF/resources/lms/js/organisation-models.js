
//For Organisation
var lmsUserBaseUrl = "/api/jsonws/lms.lmsuser";

var Organisation = Backbone.Model.extend({
	label : 'Organisation',
	icon : '$ModelIconUrl$',
	idAttribute : 'id',
	visible : {
		"title" : {
			"title" : "Organization Title",
			"type" : "Text",
			"validators" : [ "required" ]
		}

	},
	localStorage : new Backbone.LocalStorage('organisation'),
	url : lmsUserBaseUrl + "/find",
	create : function() {
		this.url = lmsUserBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	update : function() {
		this.url = lmsUserBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	deleteOrganization : function(id) {
		this.url = lmsUserBaseUrl + "/delete?id="+id;
		return Backbone.ajaxSync('create', this);
	}
});

var OrganisationCollection = Backbone.Collection.extend({
	model : Organisation,
	url : lmsUserBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-organisation'),
	download : function() {
		return Backbone.ajaxSync('read', this);
	},
	findAllOrganisation : function() {
		this.url = lmsUserBaseUrl + "/find-all-organization";
		return Backbone.ajaxSync('read', this);
	}
});	
