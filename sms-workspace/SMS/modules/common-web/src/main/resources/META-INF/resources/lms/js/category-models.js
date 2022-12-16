var categoryDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=151";
var categoryDefId = 151;
var categoryBaseUrl = "/api/jsonws/lms.category";
var baseUrl = "/api/jsonws/assetcategory";

/*var categoryBaseUrl = "/api/jsonws/LMS-portlet.category";
var baseUrl = "/api/jsonws/assetcategory";*/

var Category = Backbone.Model.extend({
	label : 'Category',
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
			"title" : "Category Name",
			"type" : "Text",
			"validators" : [ "required" ]
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-category'),
	url : categoryBaseUrl + "/assetcategory",
	create : function() {
		this.url = categoryBaseUrl + "/create";
		this.attributes["title"] = this.get("title");
		this.attributes["description"] = this.get("title");
		this.attributes["categoryProperties"] = "[]";
		return Backbone.ajaxSync('create', this);
	},
    findNameListById:function (idList){
    	this.url=categoryBaseUrl + "/find-name-list-by-id";
    	this.attributes["idList"] =idList;
    	return Backbone.ajaxSync('create', this);
    },
	update : function(parentCategoryId, categoryId) {
		this.url = categoryBaseUrl + "/update";
		this.attributes["categoryId"] = categoryId;
		this.attributes["parentCategoryId"] = parentCategoryId;
		this.attributes["title"] = this.get("title");
		this.attributes["description"] = this.get("title");
		this.attributes["categoryProperties"] = "[]";
		return Backbone.ajaxSync('create', this);
	},
	remove : function() {
		this.url = categoryBaseUrl + "/delete";
		this.attributes["id"] = this.get("categoryId");
		return Backbone.ajaxSync('create', this);
	},removeCategory : function() {
		this.url = baseUrl + "/delete-category";
		this.attributes["id"] = this.get("categoryId");
		return Backbone.ajaxSync('create', this);
	},
	createSubCategory : function(vocabularyId, parentCategoryId) {
		var currObj = this;
		this.attributes["vocabularyId"] = vocabularyId;
		this.attributes["parentCategoryId"] = parentCategoryId;
		this.attributes["title"] = this.get("title");
		this.attributes["description"] = this.get("title");
		this.attributes["categoryProperties"] = "[]";
		this.url = categoryBaseUrl + "/create-sub-category";
		return Backbone.ajaxSync('create', this);
	},
	createSubCatUrl : function(vocabularyId, parentCategoryId) {
		var currObj = this;

		var descriptionMap = "{\"" + this.get("localeCode") + "\":\"" + this.get("title")
				+ "\"}";
		var titleMap = "{\"" + this.get("localeCode")  + "\":\"" + this.get("title") + "\"}";

		this.attributes["titleMap"] = titleMap;
		this.attributes["vocabularyId"] = vocabularyId;
		this.attributes["parentCategoryId"] = parentCategoryId;
		this.attributes["descriptionMap"] = descriptionMap;
		this.attributes["categoryProperties"] = "[]";
		this.url = baseUrl + "/add-category";
		return Backbone.ajaxSync('create', this);
	},
	findByLocaleCode : function(id,localeCode) {
		this.url = categoryBaseUrl + "/find-by-locale-code";
		this.attributes["id"] = id;
		this.attributes["localeCode"] = localeCode;
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('title');
	}
});

var CategoryCollection = Backbone.Collection.extend({
	model : Category,
	url : categoryBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-category'),
	download : function() {
		this.url = categoryBaseUrl + "/find-all";
		return Backbone.ajaxSync('read', this);
	}
});

var CategoryCreateForm = Backbone.Form.extend({
	schema : {
		
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"title" : {
			"title" : "Category Name",
			"type" : "Text",
			"validators" : ["required","aplhaNumeric" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Category Title'}
		}
	}
});

var CategoryEditForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
	
		"title" : {
			"title" : "Category Name",
			"type" : "Text",
			"validators" : ["required","aplhaNumeric" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Category Title'}
		}
	
		
		
	}
});
var SubCategoryCreateForm = Backbone.Form.extend({
	schema : {
		
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"parentCategoryName" : {
			"title" : "Parent Category",
			"type" : "Text",
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Parent Category',"disabled" : true}
		},
		"title" : {
			"title" : "Category Name",
			"type" : "Text",
			"validators" : [ "required","aplhaNumeric"  ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Category Title'}
		}
	}
});