		var  newsCategoryDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=112";
		var 	 newsCategoryDefId = 112;
		var  newsCategoryBaseUrl = "/api/jsonws";

		var NewsCategory = Backbone.Model.extend({
		label:'News Category',
		icon:'$ModelIconUrl$',
		visible: {
	"title": {
		"title": "News Category",
		"type": "Text",
		"validators": ["required"]  
	},
	"news": {
		"title": "View News",
		"type":"Link",
		"link": "client-list-page",
		"class": "button block fa fa-users green icon-left",
		"onclick":""
	}
},
	    localStorage: new Backbone.LocalStorage('tbl-newscategory'),
	    url: newsCategoryBaseUrl + "/default",
	    create:function (){
	    	this.url=newsCategoryBaseUrl + "/create";
	    	return Backbone.ajaxSync('create', this);
	    },
	    update:function (){
	    	this.url=newsCategoryBaseUrl + "/update";
	    	return Backbone.ajaxSync('create', this);
	    },
	    delete:function (){
	    	this.url=newsCategoryBaseUrl + "/delete";
	    	return Backbone.ajaxSync('create', this);
	    },
	    toString: function() {
        	return this.get('title');
    	}
	});
	
	var NewsCategoryCollection = Backbone.Collection.extend({
		model: NewsCategory,
		url: newsCategoryBaseUrl + "/list",
	    localStorage: new Backbone.LocalStorage('tbl-newscategory'),
	    download: function(filter){
	    	return Backbone.ajaxSync('read', this);
	    }
	});
	
	var NewsCategoryCreateForm = Backbone.Form.extend({
		schema: {
	"title": {
		"title": "News Category",
		"type": "Text",
		"validators": ["required"]  
	}
}
	});
	
	var NewsCategoryEditForm = Backbone.Form.extend({
		schema: {
	"title": {
		"title": "News Category",
		"type": "Text",
		"validators": ["required"]  
	}
}
	});
