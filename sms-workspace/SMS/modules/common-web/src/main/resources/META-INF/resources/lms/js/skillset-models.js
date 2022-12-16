var  lessonSkillSetDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=189";
var 	 lessonSkillSetDefId = 189;
//var  lessonSkillSetBaseUrl = "http://portal.armantecsystems.com/api/jsonws/lms-portlet.lessonskillset";
var  lessonSkillSetBaseUrl = "/api/jsonws/lms.lessonskillset";

var baseUrl = "/api/jsonws/assetcategory";
var SkillSet = Backbone.Model.extend({
	label : 'SkillSet',
	idAttribute : 'categoryId',
	icon : '$ModelIconUrl$',
	visible : {
		
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"title" : {
			"title" : "Skill Title",
			"type" : "Text",
			"validators" : [ "required" ]
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-skillset'),
	url : lessonSkillSetBaseUrl + "/assetcategory",
	createSkillSet : function() {
		this.url = lessonSkillSetBaseUrl + "/create-skill-set";
		this.attributes["title"] = this.get("title");
		this.attributes["description"] = this.get("title");
		this.attributes["categoryProperties"] = "[]";
		return Backbone.ajaxSync('create', this);
	},
	updateSkillSet : function(parentCategoryId,categoryId) {
		this.url = lessonSkillSetBaseUrl + "/update-skill-set";
		this.attributes["categoryId"] = categoryId;
		this.attributes["parentCategoryId"] = parentCategoryId;
		this.attributes["title"] = this.get("title");
		this.attributes["description"] = this.get("title");
		this.attributes["categoryProperties"] = "[]";
		return Backbone.ajaxSync('create', this);
	},
	removeSkillSet : function() {
		this.url = lessonSkillSetBaseUrl + "/delete-skill-set";
		this.attributes["id"] = this.get("categoryId");
		return Backbone.ajaxSync('create', this);
	},
	remove : function() {
		this.url = baseUrl + "/delete-category";
		this.attributes["id"] = this.get("categoryId");
		return Backbone.ajaxSync('create', this);
	},
	createSubSkillSetUrl : function(vocabularyId, parentCategoryId) {
		var currObj = this;
		this.attributes["vocabularyId"] = vocabularyId;
		this.attributes["parentCategoryId"] = parentCategoryId;
		this.attributes["title"] = this.get("title");
		this.attributes["description"] = this.get("title");
		this.attributes["categoryProperties"] = "[]";
		this.url = lessonSkillSetBaseUrl + "/create-sub-skill-set";
		return Backbone.ajaxSync('create', this);
	},
	findByLocaleCode : function(id,localeCode) {
		this.url = lessonSkillSetBaseUrl + "/find-by-locale-code";
		this.attributes["id"] = id;
		this.attributes["localeCode"] = localeCode;
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('title');
	}
});

var SkillSetCollection = Backbone.Collection.extend({
	model : SkillSet,
	url : lessonSkillSetBaseUrl + "/find-all-skill-set",
	localStorage : new Backbone.LocalStorage('tbl-skillset'),
	download : function() {
		this.url = lessonSkillSetBaseUrl + "/find-all-skill-set";
		return Backbone.ajaxSync('read', this);
	}
});


var SkillSetCreateForm = Backbone.Form.extend({
	schema : {
		
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"title" : {
			"title" : "Skill Title",
			"type" : "Text",
			"validators" : ["required" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Skill Title'}
		}
	}
});

var SkillSetEditForm = Backbone.Form.extend({
	schema : {
		
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"title" : {
			"title" : "Skill Title",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Skill Title'}
		}
	}
});
var SubSkillSetCreateForm = Backbone.Form.extend({
	schema : {
		
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"parentSkillSetName" : {
			"title" : "Parent Skill Set",
			"type" : "Text",
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Parent Skill',"disabled" : true}
		},
		"title" : {
			"title" : "Skill Title",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Skill Title'}
		}
	}
});
