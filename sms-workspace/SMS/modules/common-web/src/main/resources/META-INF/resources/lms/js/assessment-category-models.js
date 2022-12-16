var assessmentCategoryDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=151";
var assessmentCategoryDefId = 151;
var assessmentCategoryBaseUrl = "/api/jsonws/lms.assessmentcategory";
var baseUrl = "/api/jsonws/assetcategory";

/*var assessmentCategoryBaseUrl = "/api/jsonws/LMS-portlet.category";
var baseUrl = "/api/jsonws/assetcategory";*/

var AssessmentCategory = Backbone.Model.extend({
	label : 'AssessmentCategory',
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
			"title" : "Assessment Category Name",
			"type" : "Text",
			"validators" : [ "required" ]
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-assessmentcategory'),
	url : assessmentCategoryBaseUrl + "/assetcategory",
	create : function() {
		this.url = assessmentCategoryBaseUrl + "/create";
		this.attributes["title"] = this.get("title");
		this.attributes["description"] = this.get("title");
		this.attributes["categoryProperties"] = "[]";
		return Backbone.ajaxSync('create', this);
	},
    findNameListById:function (idList){
    	this.url=assessmentCategoryBaseUrl + "/find-name-list-by-id";
    	this.attributes["idList"] =idList;
    	return Backbone.ajaxSync('create', this);
    },
	update : function(parentCategoryId, categoryId) {
		this.url = assessmentCategoryBaseUrl + "/update";
		this.attributes["categoryId"] = categoryId;
		this.attributes["parentCategoryId"] = parentCategoryId;
		this.attributes["title"] = this.get("title");
		this.attributes["description"] = this.get("title");
		this.attributes["categoryProperties"] = "[]";
		return Backbone.ajaxSync('create', this);
	},
	remove : function() {
		this.url = assessmentCategoryBaseUrl + "/delete";
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
		this.url = assessmentCategoryBaseUrl + "/create-sub-category";
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
		this.url = assessmentCategoryBaseUrl + "/find-by-locale-code";
		this.attributes["id"] = id;
		this.attributes["localeCode"] = localeCode;
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('title');
	}
});

var AssessmentCategoryCollection = Backbone.Collection.extend({
	model : AssessmentCategory,
	url : assessmentCategoryBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-assessmentcategory'),
	download : function() {
		this.url = assessmentCategoryBaseUrl + "/find-all";
		return Backbone.ajaxSync('read', this);
	}
});

var AssessmentCategoryCreateForm = Backbone.Form.extend({
	schema : {
		
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"title" : {
			"title" : "Assessment Category Name",
			"type" : "Text",
			"validators" : ["required","aplhaNumeric" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Assessment Category Title'}
		}
	}
});

var AssessmentCategoryEditForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
	
		"title" : {
			"title" : "Assessment Category Name",
			"type" : "Text",
			"validators" : [ "required","aplhaNumeric"  ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Assessment Category Title'}
		}
	}
});
var SubAssessmentCategoryCreateForm = Backbone.Form.extend({
	schema : {
		
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"parentCategoryName" : {
			"title" : "Parent Assessment Category",
			"type" : "Text",
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Parent Assessment Category',"disabled" : true}
		},
		"title" : {
			"title" : "Assessment Category Name",
			"type" : "Text",
			"validators" : [ "required","aplhaNumeric"  ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Assessment Category Title'}
		}
	}
});