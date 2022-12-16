var labDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=173";
var labDefId = 173;
var labBaseUrl = "/api/jsonws/lms.lab";

var Lab = Backbone.Model.extend({
	label : 'Lab',
	icon : '$ModelIconUrl$',
	idAttribute : 'id',
	visible : {"localeCode" : {
		"title":"Select Language",
		"type":"Select",
		"validators":["required"],
		"options" : new LocaleInfoCollection(),
		"editorClass" : "form-control"
		},
		"lessonId" : {
			"type" : "Select",
			"title" : "Lesson",
			"validators" : [ "required" ],
			"options" : "<Lesson>",
			"fieldclass" : 0
		},
		"vmCount" : {
			"type" : "Hidden",
			"title" : "VM Count",
			"validators" : [ "required", "number" ],
			"fieldclass" : 0
		},
		"isBpsAvailable" : {
			"title" : "Bps Available",
			"type" : "Hidden",
			"validators" : [ "required" ],
			"options" : [ {
				"val" : "true",
				"label" : "Yes"
			}, {
				"val" : "false",
				"label" : "No"
			} ]
		},
		"title" : {
			"type" : "Text",
			"title" : "Title",
			"validators" : [ "required" ],
			"fieldclass" : 0
		},
		"detail" : {
			"type" : "TextArea",
			"title" : "Detail",
			"validators" : [ "required" ],
			"fieldclass" : 0
		},
		"labGuide" : {
			"type" : "FilePicker",
			"title" : "Participant Guide",
			"fieldclass" : 0
		},
		"instructorGuideUrl" : {
			"type" : "FilePicker",
			"title" : "Instructor Guide",
			"fieldclass" : 0
		},
		"yamlFileUrl" : {
			"type" : "FilePicker",
			"title" : "YAML File",
			"fieldclass" : 0
		},
		"maximumDuration" : {
			"type" : "Text",
			"title" : "Maximum Duration (in minutes)",
			"validators" : [  "number" ],
			"fieldclass" : 0,
			"editorAttrs" : {
				"maxlength" : 2
			}
		},
		"noOfAttempt" : {
			"type" : "Text",
			"title" : "No Of Attempt",
			"validators" : [  "number" ],
			"fieldclass" : 0,
			"editorAttrs" : {
				"maxlength" : 5
			}
		},
		"position" : {
			"type" : "Text",
			"title" : "Position",
			"validators" : [ "required" ],
			"fieldclass" : 0
		},
		"networkLayout" : {
			"type" : "ImagePicker",
			"title" : "Network Diagram",
			"validators" : "",
			"options" : "",
			"regexp" : 0,
			"fieldclass" : 0
		},
		"difficultyLevelId" : {
			"title" : "Select Difficulty Level",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new DifficultyLevelCollection(),
			"editorClass" : "form-control"
		},
		"containerTemplates" : {
			"type" : "Select",
			"title" : "Scenario Name",
			"options" : "<LabContainerTemplate>",
			"regexp" : 0,
			"fieldclass" : 0
		},
		"hint" : {
			"type" : "Text",
			"title" : "Hint",
			"options" : "",
			"regexp" : 0,
			"fieldclass" : 0
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-lab'),
	url : labBaseUrl + "/find",
	create : function() {
		this.url = labBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function() {
		return labBaseUrl + "/create";
	},
	update : function() {
		this.url = labBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	find : function(id,localeCode) {
		this.url = labBaseUrl + "/find?id=" + id + "&localeCode=" + localeCode;
		return Backbone.ajaxSync('create', this);
	},
	findStudentLab : function(id) {
		this.url = labBaseUrl + "/find-student-lab?labId=" + id;
		return Backbone.ajaxSync('read', this);
	},
	start : function(id) {
		this.url = labBaseUrl + "/start?id=" + id;
		return Backbone.ajaxSync('read', this);
	},
	stop : function(id) {
		this.url = labBaseUrl + "/stop?id=" + id;
		return Backbone.ajaxSync('read', this);
	},
	updateUrl : function() {
		return labBaseUrl + "/update";
	},
	remove : function() {
		this.url = labBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	terminals : function(studentLabId) {
        this.url = labBaseUrl + "/terminals?studentLabId="+studentLabId;
        return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('title');
	},
	findLab : function(id) {
		this.url = labBaseUrl + "/find-lab?id=" + id;
		return Backbone.ajaxSync('create', this);
	},
	findByLocaleCode : function(id,localeCode) {
		this.url = labBaseUrl + "/find-by-locale-code";
		this.attributes["id"] = id;
		this.attributes["localeCode"] = localeCode;
		return Backbone.ajaxSync('create', this);
	}
});

var LabCollection = Backbone.Collection.extend({
	model : Lab,
	url : labBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-lab'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	},
	downloadByLesson : function(lessonId,localeCode) {
		this.url = labBaseUrl + "/find-lab-by-lesson?lessonId=" + lessonId+"&localeCode="+localeCode;
		return Backbone.ajaxSync('read', this);
	},
	downloadAllLab : function() {
		this.url = labBaseUrl + "/find-all-lab";
		return Backbone.ajaxSync('read', this);
	}
});

var LabCreateForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
			},
		"lessonId" : {
			"type" : "Hidden",
			"title" : "Lesson"

		},
		"title" : {
			"type" : "Text",
			"title" : "Title",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Scenario Activity Title'
			}
		},
		"detail" : {
			"type" : "TextArea",
			"title" : "Instructions",
			"validators" : [ "required","description" ],
			"editorClass" : "form-control input-md"
		},
		"maximumDuration" : {
			"type" : "Text",
			"title" : "Maximum Duration (in minutes)",
			"validators" : [ "number"  ],
			"editorClass" : "form-control input-md"
		},
		"noOfAttempt" : {
			"type" : "Text",
			"title" : "No Of Attempt",
			"validators" : [  "number" ],
			"editorClass" : "form-control input-md"
		},
		"position" : {
			"type" : "Text",
			"title" : "Position",
			"validators" : [ "required","number" ],
			"editorClass" : "form-control input-md"
		},
		"isBpsAvailable" : {
			"title" : "Bps Available",
			"type" : "Hidden",
			"options" : [ {
				"val" : "",
				"label" : "Select"
			}, {
				"val" : "true",
				"label" : "Yes"
			}, {
				"val" : "false",
				"label" : "No"
			} ],
			"editorClass" : "form-control"
		},
		"networkLayout" : {
			"type" : "ImagePicker",
			"title" : "Network Diagram",
			"help" : "Allowed types are .png, .jpg, .gif, .svg. Max Size - 1MB"
		},
		"difficultyLevelId" : {
			"title" : "Select Difficulty Level",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new DifficultyLevelCollection(),
			"editorClass" : "form-control"
		},
		"containerTemplates" : {
			"type" : "Select",
			"title" : "Scenario Name",
			"options" : new LabContainerTemplateCollection(),
			"editorClass" : "form-control"
		},
		"hint" : {
			"type" : "TextArea",
			"title" : "Hint",
			"options" : "",
			"regexp" : 0,
			"fieldclass" : 0,
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Enter Hint...',
				rows : '10'
			}
		},
		"vmTemplates" : {
			"type" : "Hidden",
			"editorAttrs" : {
				"multiple" : "multiple"
			},
			"title" : "VM Templates",
			
			"options" : [ {
				"val" : "15",
				label : 'VM 1'
			}, {
				"val" : "17",
				label : 'VM 2'
			} ],
			"editorClass" : "form-control"
		},
		"labGuide" : {
			"type" : "FilePicker",
			"title" : "Participant Guide",
			"help" : "Allowed types are .pdf. Max Size - 5MB"
		},
		"instructorGuideUrl" : {
			"type" : "FilePicker",
			"title" : "Instructor Guide",
			"help" : "Allowed types are .pdf. Max Size - 5MB"
		},
		"yamlFileUrl" : {
			"type" : "FilePicker",
			"title" : "YAML File",
			"help" : "Allowed types are .pdf. Max Size - 5MB"
		},
		"vmCount" : {
			"type" : "Hidden",
			"title" : "VM Count",
			"fieldclass" : 0
		}
	}
});
var LabEditForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
			},
		"lessonId" : {
			"type" : "Hidden",
			"title" : "Lesson"

		},
		"id" : {
			"type" : "Hidden",
			"title" : "Lab Id"

		},
		"title" : {
			"type" : "Text",
			"title" : "Title",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Scenario Activity Title'
			}
		},
		"detail" : {
			"type" : "TextArea",
			"title" : "Instructions",
			"validators" : [ "required" ,"description"],
			"editorClass" : "form-control input-md"
		},
		"maximumDuration" : {
			"type" : "Text",
			"title" : "Maximum Duration (in minutes)",
			"validators" : [ "number"],
			"editorClass" : "form-control input-md"
		},
		"noOfAttempt" : {
			"type" : "Text",
			"title" : "No Of Attempt",
			"validators" : [  "number" ],
			"editorClass" : "form-control input-md"
		},
		"position" : {
			"type" : "Text",
			"title" : "Position",
			"validators" : [ "required","number" ],
			"editorClass" : "form-control input-md"
		},
		"isBpsAvailable" : {
			"title" : "Bps Available",
			"type" : "Hidden",
			"options" : [ {
				"val" : "",
				"label" : "Select"
			}, {
				"val" : "true",
				"label" : "Yes"
			}, {
				"val" : "false",
				"label" : "No"
			} ],
			"editorClass" : "form-control"
		},
		"networkLayout" : {
			"type" : "ImagePicker",
			"title" : "Network Diagram",
			"help" : "Allowed types are .png, .jpg, .gif, .svg. Max Size - 1MB"
		},
		"difficultyLevelId" : {
			"title" : "Select Difficulty Level",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new DifficultyLevelCollection(),
			"editorClass" : "form-control"
		},
		"containerTemplates" : {
			"type" : "Select",
			"title" : "Scenario Name",		
			"options" : new LabContainerTemplateCollection(),
			"editorClass" : "form-control"
		},
		"hint" : {
			"type" : "TextArea",
			"title" : "Hint",
			"options" : "",
			"regexp" : 0,
			"fieldclass" : 0,
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Enter Hint...',
				rows : '10'
			}
		},
		"vmTemplates" : {
			"type" : "Hidden",
			"editorAttrs" : {
				"multiple" : "multiple"
			},
			"title" : "VM Templates",
			"options" : [ {
				"val" : "15",
				label : 'VM 1'
			}, {
				"val" : "17",
				label : 'VM 2'
			} ],
			"editorClass" : "form-control"
		},
		"labGuide" : {
			"type" : "FilePicker",
			"title" : "Participant Guide",
			"help" : "Allowed types are .pdf. Max Size - 5MB"
		},
		"instructorGuideUrl" : {
			"type" : "FilePicker",
			"title" : "Instructor Guide",
			"help" : "Allowed types are .pdf. Max Size - 5MB"
		},
		"yamlFileUrl" : {
			"type" : "FilePicker",
			"title" : "YAML File",
			"help" : "Allowed types are .pdf. Max Size - 5MB"
		},
		"vmCount" : {
			"type" : "Hidden",
			"title" : "VM Count",
			"fieldclass" : 0
		}
	}
});