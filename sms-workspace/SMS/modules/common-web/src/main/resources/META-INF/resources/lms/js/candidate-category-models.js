var candidateBaseUrl = "/api/jsonws/lms.candidate";

var CandidateCategory = Backbone.Model.extend({
		label:'CandidateCategory',
		icon:'$ModelIconUrl$',
		idAttribute : 'candidateCategoryId',
		visible: {
			"id" : {
				"title" : "ID",
				"type" : "Hidden"
			},
			"title" : { 
				"type":"Text", 
				"title":"Title", 
				"validators":["required"], 
				"options":"",
				"editorClass" : "form-control"
			}
		},
	    localStorage: new Backbone.LocalStorage('tbl-candidateCategory'),
	    url: candidateBaseUrl + "/get-candidate-categories",
	    find:function(){
	    	this.url = candidateBaseUrl + "/get-candidate-categories";
	    	return Backbone.ajaxSync('create', this);
	    },
	    toString: function() {
        	return this.get('title');
    	}
	});
	
var CandidateCategoryCollection = Backbone.Collection.extend({
	model: CandidateCategory,
	url: candidateBaseUrl + "/get-candidate-categories",
	localStorage: new Backbone.LocalStorage('tbl-candidateCategory'),
	download: function(){
	return Backbone.ajaxSync('read', this);
   },
   getCandidateCategories:function (){
  	this.url = candidateBaseUrl + "/get-candidate-categories";
  	return Backbone.ajaxSync('read', this);
   }
});
	