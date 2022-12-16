var difficultyLevelBaseUrl = "/api/jsonws/lms.difficultylevel";

var DifficultyLevel = Backbone.Model.extend({
	label : 'DifficultyLevel',
	icon : '$ModelIconUrl$',
	visible : {
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
			},
			"difficultyLevelTitle" : {
			"type" : "Text",
			"title" : "Difficulty Level",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Intermediate'}
		},
		"points" : {
			"type" : "Text",
			"title" : "Points",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: '9'}
		},
		"description" : {
			"type" : "TextArea",
			"title" : "Description",
			"editorClass" : "form-control",
			"validators" : [ "required","description" ]
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-difficultylevel'),
	url : difficultyLevelBaseUrl + "/default",
	create : function() {
		this.url = difficultyLevelBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function() {
		return difficultyLevelBaseUrl + "/create";
	},
	update : function() {
		this.url = difficultyLevelBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function() {
		return difficultyLevelBaseUrl + "/update";
	},
	remove : function() {
		this.url = difficultyLevelBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('title');
	},
	findByLocaleCode : function(id,localeCode) {
		this.url = difficultyLevelBaseUrl + "/find-by-locale-code";
		this.attributes["id"] = id;
		this.attributes["localeCode"] = localeCode;
		return Backbone.ajaxSync('create', this);
	}
});

var DifficultyLevelCollection = Backbone.Collection.extend({
	model : DifficultyLevel,
	url : difficultyLevelBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-difficultylevel'),
	download : function(filter) {
		console.log("inside difficultylevel-models.js !!!");
		return Backbone.ajaxSync('read', this);
	}
});

var DifficultyLevelCreateForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
			},
			"difficultyLevelTitle" : {
			"type" : "Text",
			"title" : "Difficulty Level",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md"
		},
		"points" : {
			"type" : "Text",
			"title" : "Points",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: '9'}
		},
		"description" : {
			"type" : "TextArea",
			"title" : "Description",
			"editorClass" : "form-control",
			"validators" : [ "required","description" ],
		}
	}
});

var DifficultyLevelEditForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
			},
			"difficultyLevelTitle" : {
			"type" : "Text",
			"title" : "Difficulty Level",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md"
		},
		"points" : {
			"type" : "Text",
			"title" : "Points",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: '9'}
		},
		"description" : {
			"type" : "TextArea",
			"title" : "Description",
			"editorClass" : "form-control",
			"validators" : [ "required","description" ],
		}
	}
});
