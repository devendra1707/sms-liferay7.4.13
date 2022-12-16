		var  vocabularyDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=150";
		var 	 vocabularyDefId = 150;
		var  vocabularyBaseUrl = "/api/jsonws";
		//var  vocabularyBaseUrl = "/api/jsonws";
		var Vocabulary = Backbone.Model.extend({
		label:'Vocabulary',
		idAttribute:'vocabularyId',
		icon:'$ModelIconUrl$',
		visible: {
"titleCurrentValue":{"title":"Title","type":"Text"}
},
	    localStorage: new Backbone.LocalStorage('tbl-vocabulary'),
	    url: vocabularyBaseUrl + "/assetvocabulary",
	    create:function (){
	    	this.url=vocabularyBaseUrl + "/assetvocabulary/add-vocabulary";
	    	return Backbone.ajaxSync('create', this);
	    },
		createUrl:function (){
			return vocabularyBaseUrl + "/assetvocabulary/add-vocabulary";
	    },
	    update:function (){
	    		this.url=vocabularyBaseUrl + "/assetvocabulary/update-vocabulary";
	    		return Backbone.ajaxSync('create', this);
	    },
	    updateUrl:function (){
	    		return vocabularyBaseUrl + "/assetvocabulary/update-vocabulary";
	    },
	    remove:function (){
	    	this.url=vocabularyBaseUrl + "/assetvocabulary/delete-vocabulary";
	    	return Backbone.ajaxSync('create', this);
	    },
	    toString: function() {
        	return this.get('titleCurrentValue');
    	}
	});
	
	var VocabularyCollection = Backbone.Collection.extend({
		model: Vocabulary,
		url: vocabularyBaseUrl + "/assetvocabulary/get-group-vocabularies/group-id/1736105",
	    localStorage: new Backbone.LocalStorage('tbl-vocabulary'),
	    download: function(filter){
	    	//20181
	    	//this.url= vocabularyBaseUrl + "/assetvocabulary/get-group-vocabularies/group-id/29001";
	    	this.url= vocabularyBaseUrl + "/assetvocabulary/get-group-vocabularies/group-id/"+scopeGroupId;
	    	return Backbone.ajaxSync('read', this);
	    }
	});
	
	var VocabularyCreateForm = Backbone.Form.extend({
		schema: {
"titleCurrentValue":{"title":"Title","type":"Text"}
}
	});
	
	var VocabularyEditForm = Backbone.Form.extend({
		schema: {
"titleCurrentValue":{"title":"Title","type":"Text"}
}
	});
