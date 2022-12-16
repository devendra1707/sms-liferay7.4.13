var topicDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=175";
var topicDefId = 175;
var topicBaseUrl = "/api/jsonws/lms.topic";
var lessonBaseUrl = "/api/jsonws/lms.lesson";
var Topic = Backbone.Model.extend({
	label : 'Topic',
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
			"title" : "Topic Name",
			"type" : "Text",
			"validators" : [ "required" ]
		},
		"summary" : {
			"title" : "Summary",
			"type" : "TextArea",
			"validators" : [ "required" ]
		},
		"completionTime" : {
			"title" : "Completion Time (In Hrs)",
			"type" : "Text",
			"validators" : [ "required", "number" ]
		},
		"active" : {
			"title" : "Active",
			"type" : "Select",
			"options" : [ "Yes", "No" ]
		},
		"lessonId" : {
			"title" : "Lesson",
			"type" : "Select",
			"options" : new LessonCollection()
		},
		"sequence" : {
			"title" : "Sequence No.",
			"type" : "Text",
			"validators" : [ "required", "sequence" ]
		},
		"topicBody" : {
			"title" : "Text Content",
			"type" : "TextArea",
			"validators" : [ "required" ]
		},
		"imageUrl" : {
			"title" : "Image Content",
			"type" : "ImagePicker"
		},
		"videoUrl" : {
			"title" : "Video Content",
			"type" : "Video"
		},
		"attachmentUrl" : {
			"title" : "Document",
			"type" : "File"
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-topic'),
	url : topicBaseUrl + "/find",
	create : function() {
		this.url = topicBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function() {
		return topicBaseUrl + "/create";
	},
	update : function() {
		this.url = topicBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function() {
		return topicBaseUrl + "/update";
	},
	remove : function() {
		this.url = topicBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('tiltle');
	},
	nextTopic : function(topicId) {
		this.url = topicBaseUrl + "/get-next-topic?topicId=" + topicId;
		return Backbone.ajaxSync('read', this);
	},
	findById : function(topicId) {
		this.url = topicBaseUrl + "/find?id=" + topicId;
		return Backbone.ajaxSync('read', this);
	},
	findNext : function(id,type) {
		this.url = topicBaseUrl + "/get-next-lab-topic-in-seqeunce?id="+id+"&type="+type;
		return Backbone.ajaxSync('read', this);
	},
	findByLocaleCode : function(id,localeCode) {
		this.url = topicBaseUrl + "/find-by-locale-code";
		this.attributes["id"] = id;
		this.attributes["localeCode"] = localeCode;
		return Backbone.ajaxSync('create', this);
	}
});

var TopicCollection = Backbone.Collection.extend({
	model : Topic,
	url : topicBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-topic'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	},
	findAllTopic : function() {
		this.url = topicBaseUrl + "/find-all-topic";
		return Backbone.ajaxSync('read', this);
	},
	getAllLabTopicListOfLesson : function() {
		this.url = lessonBaseUrl + "/get-all-lab-topic-list-of-lesson";
		return Backbone.ajaxSync('read', this);
	}
});

var TopicCreateForm = Backbone.Form.extend({
	schema : {
		 
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
		"title" : {
			"title" : "Topic Name",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Topic Title'}
		},
		"summary" : {
			"title" : "Summary",
			"type" : "TextArea",
			"validators" : [ "required", "description" ],
			"editorClass" : "form-control",
			editorAttrs: {placeholder: 'Topic Description'}
		},
		"completionTime" : {
			"title" : "Completion Time (In Hrs)",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {"maxlength" : 5}
		},
		"active" : {
			"title" : "Active",
			"type" : "Radio",
			"options" : [{
				"val" : "Yes",
				"label" : "Yes"
			}, {
				"val" : "No",
				"label" : "No"
			}  ],
			"validators" : [ "required" ]
		},
		"lessonId" : {
			"title" : "Lesson",
			"type" : "Hidden",
			"validators" : [ "number" ]
		},
		"sequence" : {
			"title" : "Sequence No.",
			"type" : "Text",
			"validators" : [ "required", "sequence" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Sequential Number'}
		},
		"topicBody" : {
			"title" : "Text Content",
			"type" : "TextArea",
			"validators" : [ "required"],
			"editorClass" : "form-control",
			editorAttrs: {placeholder: 'Enter message...'}
		}, 
		"imageUrl" : {
			"title" : "Image Content",
			"type" : "ImagePicker",
			"help" : ".png, .jpg, .gif, .svg files only upto 1MB",
			"editorClass" : "input-file"
		},
		"videoUrl" : {
			"title" : "Video Content",
			"type" : "VideoPicker",
			"help" : ".mp4 files only upto 100MB",
			"editorClass" : "input-file"
		},
		"attachmentUrl" : {
			"title" : "Document",
			"type" : "FilePicker",
			"help" : ".pdf or .ppt files only upto 5MB",
			"editorClass" : "input-file"
		}
	}
});

var TopicEditForm = Backbone.Form.extend({
	schema : {
		"id" : {
			"title" : "ID",
			"type" : "Hidden",
			"validators" : [ "required" ]
		},"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
		},
	"title" : {
			"title" : "Topic Name",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Topic Title'}
		},
		"summary" : {
			"title" : "Summary",
			"type" : "TextArea",
			"validators" : [ "required", "description" ],
			"editorClass" : "form-control",
			editorAttrs: {placeholder: 'Topic Description'}
		},
		"completionTime" : {
			"title" : "Completion Time (In Hrs)",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: '',"maxlength" : 5}
		},
		"active" : {
			"title" : "Active",
			"type" : "Radio",
			"options" : [{
				"val" : "Yes",
				"label" : "Yes"
			}, {
				"val" : "No",
				"label" : "No"
			}  ],
			"validators" : [ "required" ]
		},
		"lessonId" : {
			"title" : "Lesson",
			"type" : "Hidden",
			"validators" : [ "required","number" ]
		},
		"sequence" : {
			"title" : "Sequence No.",
			"type" : "Text",
			"validators" : [ "required", "sequence" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Sequential Number'}
		},
		"topicBody" : {
			"title" : "Text Content",
			"type" : "TextArea",
			"validators" : [ "required" ],
			"editorClass" : "form-control",
			editorAttrs: {placeholder: 'Enter message...'}
		}, 
		"imageUrl" : {
			"title" : "Image Content",
			"type" : "ImagePicker",
			"help" : ".png, .jpg, .gif, .svg files only upto 1MB",
			"editorClass" : "input-file"
		},
		"videoUrl" : {
			"title" : "Video Content",
			"type" : "VideoPicker",
			"help" :  ".mp4 files only upto 100MB",
			"editorClass" : "input-file"
		},
		"attachmentUrl" : {
			"title" : "Document",
			"type" : "FilePicker",
			"help" : ".pdf or .ppt files only upto 5MB",
			"editorClass" : "input-file"
		}
	}
});

