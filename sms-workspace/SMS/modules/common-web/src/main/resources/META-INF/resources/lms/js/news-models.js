		var  newsDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=111";
		var 	 newsDefId = 111;
		var  newsBaseUrl = "/api/jsonws";

		var News = Backbone.Model.extend({
		label:'News',
		icon:'$ModelIconUrl$',
		visible: {
	"heading": {
		"title": "News Heading",
		"type": "Text",
		"validators": ["required"]  
	},
	"description": {
		"title": "Description Text",
		"type": "TextArea",
		"validators": ["required"]
	},
	"image": {
		"title": "Image",
		"type": "ImagePicker"
	}
},
	    localStorage: new Backbone.LocalStorage('tbl-news'),
	    url: newsBaseUrl + "/default",
	    create:function (){
	    	this.url=newsBaseUrl + "/create";
	    	return Backbone.ajaxSync('create', this);
	    },
	    update:function (){
	    	this.url=newsBaseUrl + "/update";
	    	return Backbone.ajaxSync('create', this);
	    },
	    delete:function (){
	    	this.url=newsBaseUrl + "/delete";
	    	return Backbone.ajaxSync('create', this);
	    },
	    toString: function() {
        	return this.get('heading');
    	}
	});
	
	var NewsCollection = Backbone.Collection.extend({
		model: News,
		url: newsBaseUrl + "/getnewalist",
	    localStorage: new Backbone.LocalStorage('tbl-news'),
	    download: function(filter){
	    	return Backbone.ajaxSync('read', this);
	    }
	});
	
	var NewsCreateForm = Backbone.Form.extend({
		schema: {
	"heading": {
		"title": "News Heading",
		"type": "Text",
		"validators": ["required"]  
	},
	"description": {
		"title": "Description Text",
		"type": "TextArea",
		"validators": ["required"]
	},
	"image": {
		"title": "Image",
		"type": "ImagePicker"
	}
}
	});
	
	var NewsEditForm = Backbone.Form.extend({
		schema: {
	"heading": {
		"title": "News Heading",
		"type": "Text",
		"validators": ["required"]  
	},
	"description": {
		"title": "Description Text",
		"type": "TextArea",
		"validators": ["required"]
	},
	"image": {
		"title": "Image",
		"type": "ImagePicker"
	}
}
	});
