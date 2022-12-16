	var  AnsibleJobTemplateDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=168";
		var 	 AnsibleJobTemplateDefId = 168;
		var  ansibleJobTemplateBaseUrl = "/api/jsonws/lms.ansiblejobtemplate";

		var AnsibleJobTemplate = Backbone.Model.extend({
		label:'AnsibleJobTemplate',
		icon:'$ModelIconUrl$',
		visible: {
			"jobTemplateId":{"type":"Text","value":"","title":"Job Template Id","validators":["required"],"fieldclass":0},
			"name":{"type":"Text","value":"","title":"Name","validators":["required"],"fieldclass":0}
		},
	    localStorage: new Backbone.LocalStorage('tbl-ansiblejobtemplate'),
	    url: ansibleJobTemplateBaseUrl + "/find",
	    create:function (){
	    	this.url=ansibleJobTemplateBaseUrl + "/create";
	    	return Backbone.ajaxSync('create', this);
	    },
		createUrl:function (){
			return ansibleJobTemplateBaseUrl + "/create";
	    },
	    update:function (){
	    		this.url=ansibleJobTemplateBaseUrl + "/update";
	    		return Backbone.ajaxSync('create', this);
	    },
	    updateUrl:function (){
	    		return ansibleJobTemplateBaseUrl + "/update";
	    },
	    updateJobTemplateRelatedUrl:function (){
	    	this.url=ansibleJobTemplateBaseUrl + "/update-job-template-related-url";
			return Backbone.ajaxSync('create', this);
	    },
	    remove:function (){
	    	this.url=ansibleJobTemplateBaseUrl + "/delete";
	    	return Backbone.ajaxSync('create', this);
	    },
	    toString: function() {
        	return this.get('title');
    	}
	});
		
	var AnsibleJobTemplateCollection = Backbone.Collection.extend({
		model: AnsibleJobTemplate,
		url: ansibleJobTemplateBaseUrl + "/find-all",
	    localStorage: new Backbone.LocalStorage('tbl-ansiblejobtemplate'),
	    download: function(filter){
	    	return Backbone.ajaxSync('read', this);
	    }
	
	});