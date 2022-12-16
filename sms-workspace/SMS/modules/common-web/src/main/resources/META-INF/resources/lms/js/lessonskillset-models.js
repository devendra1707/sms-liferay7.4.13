		var  lessonSkillSetDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=189";
		var 	 lessonSkillSetDefId = 189;
		//var  lessonSkillSetBaseUrl = "http://portal.armantecsystems.com/api/jsonws/lms-portlet.lessonskillset";
		var  lessonSkillSetBaseUrl = "/api/jsonws/lms.lessonskillset";

		var LessonSkillSet = Backbone.Model.extend({
		label:'LessonSkillSet',
		icon:'$ModelIconUrl$',
		visible: {"lessonId":{"title":"Lesson Id","type":"Select","options":"<Lesson>"},
"skillSetId":{"title":"Skill Set Id","type":"Select","options":"<Category>"}},
	    localStorage: new Backbone.LocalStorage('tbl-lessonskillset'),
	    url: lessonSkillSetBaseUrl + "/find",
	    create:function (){
	    	this.url=lessonSkillSetBaseUrl + "/create";
	    	return Backbone.ajaxSync('create', this);
	    },
		createUrl:function (){
			return lessonSkillSetBaseUrl + "/create";
	    },
	    update:function (){
	    		this.url=lessonSkillSetBaseUrl + "/update";
	    		return Backbone.ajaxSync('create', this);
	    },
	    updateUrl:function (){
	    		return lessonSkillSetBaseUrl + "/update";
	    },
	    remove:function (){
	    	this.url=lessonSkillSetBaseUrl + "/delete";
	    	return Backbone.ajaxSync('create', this);
	    },
	    toString: function() {
        	return this.get('skillSetId');
    	}
	});
	
	var LessonSkillSetCollection = Backbone.Collection.extend({
		model: LessonSkillSet,
		url: lessonSkillSetBaseUrl + "/find-all",
	    localStorage: new Backbone.LocalStorage('tbl-lessonskillset'),
	    download: function(filter){
	    	return Backbone.ajaxSync('read', this);
	    }
	});
	
	var LessonSkillSetCreateForm = Backbone.Form.extend({
		schema: {"lessonId":{"title":"Lesson Id","type":"Select","options":new LessonCollection()},"skillSetId":{"title":"Skill Set Id","type":"Select","options":new CategoryCollection()}}
	});
	
	var LessonSkillSetEditForm = Backbone.Form.extend({
		schema: {"lessonId":{"title":"Lesson Id","type":"Select","options":new LessonCollection()},
"skillSetId":{"title":"Skill Set Id","type":"Select","options":new CategoryCollection()}}
	});
	
	
	var baseUrl = "/api/jsonws/assetcategory";
	/*var categoryBaseUrl = "/api/jsonws/LMS-portlet.category";
	var baseUrl = "/api/jsonws/assetcategory";*/

	var SkillSet = Backbone.Model.extend({
		label : 'SkillSet',
		idAttribute : 'skillSetId',
		icon : '$ModelIconUrl$',
		visible : {
			"title" : {
				"title" : "Title",
				"type" : "Text",
				"validators" : [ "required" ]
			}
		},
		localStorage : new Backbone.LocalStorage('tbl-skillset'),
		url : skillSetBaseUrl + "/assetcategory",
		create : function() {
			this.url = lessonSkillSetBaseUrl + "/create";
			var descriptionMap = "{\"" + defLocale + "\":\"" + this.get("title")
			+ "\"}";
			var titleMap = "{\"" + defLocale + "\":\"" + this.get("title") + "\"}";
			this.attributes["titleMap"] = titleMap;
			this.attributes["descriptionMap"] = descriptionMap;
			this.attributes["categoryProperties"] = "[]";
			return Backbone.ajaxSync('create', this);
		},
		updateBySiteId : function(parentCategoryId, defLocale, categoryId) {
			var descriptionMap = "{\"" + defLocale + "\":\"" + this.get("title")
					+ "\"}";
			var titleMap = "{\"" + defLocale + "\":\"" + this.get("title") + "\"}";
			this.url = lessonSkillSetBaseUrl + "/update-by-site-id";
			this.attributes["categoryId"] = categoryId;
			this.attributes["parentCategoryId"] = parentCategoryId;
			this.attributes["titleMap"] = titleMap;
			this.attributes["descriptionMap"] = descriptionMap;
			this.attributes["categoryProperties"] = "[]";
			return Backbone.ajaxSync('create', this);
		},
		remove : function() {
			this.url = baseUrl + "/delete-category";
			this.attributes["id"] = this.get("categoryId");
			return Backbone.ajaxSync('create', this);
		},
		createSubSkillSetUrl : function(vocabularyId, parentCategoryId, defLocale) {
			var currObj = this;

			var descriptionMap = "{\"" + defLocale + "\":\"" + this.get("title")
					+ "\"}";
			var titleMap = "{\"" + defLocale + "\":\"" + this.get("title") + "\"}";

			this.attributes["titleMap"] = titleMap;
			this.attributes["vocabularyId"] = vocabularyId;
			this.attributes["parentCategoryId"] = parentCategoryId;
			this.attributes["descriptionMap"] = descriptionMap;
			this.attributes["categoryProperties"] = "[]";
			this.url = baseUrl + "/add-category";
			return Backbone.ajaxSync('create', this);
		},
		toString : function() {
			return this.get('title');
		}
	});

	var SkillSetCollection = Backbone.Collection.extend({
		model : SkillSet,
		url : categoryBaseUrl + "/find-all",
		localStorage : new Backbone.LocalStorage('tbl-skillset'),
		download : function() {
			this.url = categoryBaseUrl + "/find-all";
			return Backbone.ajaxSync('read', this);
		}
	});
	
	
	var SkillSetCreateForm = Backbone.Form.extend({
		schema : {
			"title" : {
				"title" : "Title",
				"type" : "Text",
				"validators" : ["required" ]
			}
		}
	});

	var SkillSetEditForm = Backbone.Form.extend({
		schema : {
			"title" : {
				"title" : "Title",
				"type" : "Text",
				"validators" : [ "required" ]
			}
		}
	});
	var SubSkillSetCreateForm = Backbone.Form.extend({
		schema : {
			"parentCategoryName" : {
				"parentCategoryName" : "Parent Category",
				"type" : "Text",
				"editorAttrs" : {
					"disabled" : true
				}
			},
			"title" : {
				"title" : "Title",
				"type" : "Text",
				"validators" : [ "required" ]
			}
		}
	});
