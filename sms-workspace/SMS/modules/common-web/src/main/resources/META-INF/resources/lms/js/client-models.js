		var  clientDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=40";
		var 	 clientDefId = 40;
		var  clientBaseUrl = "/api/jsonws";

		var Client = Backbone.Model.extend({
		label:'Client',
		icon:'$ModelIconUrl$',
		visible: {
	"name": {
		"title": "Name",
		"type": "Text"
	},
	"spocName": {
		"title": "SPOC Name",
		"type": "Text",
		"validators": ["required"]
	},
	"contactNumber": {
		"title": "Contact Number",
		"type": "Text",
		"validators": ["required", "number"]
	},
	"address": {
		"title": "Address",
		"type": "TextArea"
	},
	"contractDate":{
		"title": "Date of Contract",
		"type": "DatePicker"
	},
	"building":{
		"title": "Building",
		"type": "ImagePicker"
	}
},
	    localStorage: new Backbone.LocalStorage('tbl-client'),
	    url: clientBaseUrl + "/project-manager-portlet.client/default",
	    create:function (){
	    	this.url=clientBaseUrl + "/project-manager-portlet.client/add";
	    	return Backbone.ajaxSync('create', this);
	    },
	    update:function (){
	    	this.url=clientBaseUrl + "/project-manager-portlet.client/update";
	    	return Backbone.ajaxSync('create', this);
	    },
	    delete:function (){
	    	this.url=clientBaseUrl + "/project-manager-portlet.client/delete";
	    	return Backbone.ajaxSync('create', this);
	    },
	    toString: function() {
        	return this.get('name');
    	}
	});
	
	var ClientCollection = Backbone.Collection.extend({
		model: Client,
		url: clientBaseUrl + "/project-manager-portlet.client/find-all",
	    localStorage: new Backbone.LocalStorage('tbl-client'),
	    download: function(filter){
	    	return Backbone.ajaxSync('read', this);
	    }
	});
	
	var ClientCreateForm = Backbone.Form.extend({
		schema: {
	"name": {
		"title": "Name",
		"type": "Text"
	},
	"spocName": {
		"title": "SPOC Name",
		"type": "Text",
		"validators": ["required"]
	},
	"contactNumber": {
		"title": "Contact Number",
		"type": "Text",
		"validators": ["required", "number"]
	},
	"address": {
		"title": "Address",
		"type": "TextArea"
	},
	"contractDate":{
		"title": "Date of Contract",
		"type": "DatePicker"
	},
	"building":{
		"title": "Building",
		"type": "ImagePicker"
	}
}
	});
	
	var ClientEditForm = Backbone.Form.extend({
		schema: {
	"name": {
		"title": "Name",
		"type": "Text"
	},
	"spocName": {
		"title": "SPOC Name",
		"type": "Text",
		"validators": ["required"]
	},
	"contactNumber": {
		"title": "Contact Number",
		"type": "Text",
		"validators": ["required", "number"]
	},
	"address": {
		"title": "Address",
		"type": "TextArea"
	},
	"contractDate":{
		"title": "Date of Contract",
		"type": "DatePicker"
	},
	"building":{
		"title": "Building",
		"type": "ImagePicker"
	}
}
	});
