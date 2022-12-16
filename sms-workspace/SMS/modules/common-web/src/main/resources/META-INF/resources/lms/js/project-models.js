		var  projectDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=110";
		var 	 projectDefId = 110;
		var  projectBaseUrl = "/api/jsonws";

		var Project = Backbone.Model.extend({
		label:'Project',
		icon:'$ModelIconUrl$',
		visible: {
	"clientId": {
		"title": "Client",
		"type": "Select",
		"options": "<Client>"
	},
	"title": {
		"title": "Title",
		"type": "Text",
		"validators": ["required"]
	},
	"startDate": {
		"title": "Start Date",
		"type": "DatePicker",
		"validators": ["required"]
	},
	"endDate": {
		"title": "End Date",
		"type": "DatePicker",
		"validators": ["required"]
	},
	"description": {
		"title": "Description",
		"type": "TextArea",
		"validators": ["required"]
	},
	"active": {
		"title": "Active",
		"type": "Select",
		"options": ["Yes", "No"]
	},
	"requirmentDocFilename": {
		"title": "Requirement Document",
		"type": "ImagePicker"
	},
	"techDesignDocFilename": {
		"title": "Design Doc",
		"type": "ImagePicker"
	}
},
	    localStorage: new Backbone.LocalStorage('tbl-project'),
	    url: projectBaseUrl + "/project-manager-portlet.project/default",
	    create:function (){
	    	this.url=projectBaseUrl + "/project-manager-portlet.project/add";
	    	return Backbone.ajaxSync('create', this);
	    },
	    update:function (){
	    	this.url=projectBaseUrl + "/project-manager-portlet.project/update";
	    	return Backbone.ajaxSync('create', this);
	    },
	    delete:function (){
	    	this.url=projectBaseUrl + "/project-manager-portlet.project/delete";
	    	return Backbone.ajaxSync('create', this);
	    },
	    toString: function() {
        	return this.get('title');
    	}
	});
	
	var ProjectCollection = Backbone.Collection.extend({
		model: Project,
		url: projectBaseUrl + "/project-manager-portlet.project/find-all",
	    localStorage: new Backbone.LocalStorage('tbl-project'),
	    download: function(filter){
	    	return Backbone.ajaxSync('read', this);
	    }
	});
	
	var ProjectCreateForm = Backbone.Form.extend({
		schema: {
	"clientId": {
		"title": "Client",
		"type": "Select",
		"options": new ClientCollection()
	},
	"title": {
		"title": "Title",
		"type": "Text",
		"validators": ["required"]
	},
	"startDate": {
		"title": "Start Date",
		"type": "DatePicker",
		"validators": ["required"]
	},
	"endDate": {
		"title": "End Date",
		"type": "DatePicker",
		"validators": ["required"]
	},
	"description": {
		"title": "Description",
		"type": "TextArea",
		"validators": ["required"]
	},
	"active": {
		"title": "Active",
		"type": "Select",
		"options": ["Yes", "No"]
	},
	"requirmentDocFilename": {
		"title": "Requirement Document",
		"type": "ImagePicker"
	},
	"techDesignDocFilename": {
		"title": "Design Doc",
		"type": "ImagePicker"
	}
}
	});
	
	var ProjectEditForm = Backbone.Form.extend({
		schema: {
	"clientId": {
		"title": "Client",
		"type": "Select",
		"options": new ClientCollection()
	},
	"title": {
		"title": "Title",
		"type": "Text",
		"validators": ["required"]
	},
	"startDate": {
		"title": "Start Date",
		"type": "DatePicker",
		"validators": ["required"]
	},
	"endDate": {
		"title": "End Date",
		"type": "DatePicker",
		"validators": ["required"]
	},
	"description": {
		"title": "Description",
		"type": "TextArea",
		"validators": ["required"]
	},
	"active": {
		"title": "Active",
		"type": "Select",
		"options": ["Yes", "No"]
	},
	"requirmentDocFilename": {
		"title": "Requirement Document",
		"type": "ImagePicker"
	},
	"techDesignDocFilename": {
		"title": "Design Doc",
		"type": "ImagePicker"
	}
}
	});
