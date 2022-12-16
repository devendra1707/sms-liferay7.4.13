var ExportBaseUrl = "/api/jsonws/lms.export";


var Export = Backbone.Model.extend({
	label : 'Export',
	icon : '$ModelIconUrl$',
	idAttribute : 'id',
	visible : {
		
		"bundleName" : {
			"title" : "Bundle Name",
			"type" : "Text",
			"validators" : [ "required" ]
		},
		"courseId" : {
			"type" : "Select",
			"editorAttrs" : {
				"multiple" : "multiple"
			},
			"title" : "Course",
			 "validators" : [ "required" ],
			"options" : new CourseCollection(),
			"editorClass" : "form-control"
		},
		"priority" : {
			"type" : "Hidden",
			"title" : "Priority",
			"editorClass" : "form-control input-md"
		}

	},
	localStorage : new Backbone.LocalStorage('Export'),
	url : ExportBaseUrl + "/find",
	create : function() {
		this.url = ExportBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	update : function() {
		this.url = ExportBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	deleteExport : function(id) {
		this.url = ExportBaseUrl + "/delete?id="+id;
		return Backbone.ajaxSync('create', this);
	},
	exportMultipleCourse: function() {
		this.url = ExportBaseUrl + "/export-multiple-course";
		return Backbone.ajaxSync('create', this);
	},
	createExportRow: function() {
		this.url = ExportBaseUrl + "/create-export-row";
		return Backbone.ajaxSync('create', this);
	},
	startExportRow: function(id) {
		this.url = ExportBaseUrl + "/start-export-row";
		this.attributes["exportId"] = id;
		return Backbone.ajaxSync('create', this);
	},
	findExportStatus: function(id) {
		this.url = ExportBaseUrl + "/find-export-status";
		this.attributes["exportId"] = id;
		return Backbone.ajaxSync('create', this);
	}
});


var ExportCollection = Backbone.Collection.extend({
	model : Export,
	url : ExportBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-Export'),
	download : function() {
		return Backbone.ajaxSync('read', this);
	},
	findAllExports : function() {
		this.url = ExportBaseUrl + "/find-all-exports";
		return Backbone.ajaxSync('read', this);
	}
});


var ExportCreateForm = Backbone.Form.extend({
	schema : {
		"bundleName" : {
			"title" : "Bundle Name",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
            editorAttrs: {placeholder: 'Bundle Name'}
		},
		"courseId" : {
			"type" : "Select",
			"editorAttrs" : {
				"multiple" : "multiple"
			},
			"title" : "Course",
			 "validators" : [ "required" ],
			"options" : new CourseCollection(),
			"editorClass" : "form-control"
		},
		"priority" : {
			"type" : "Hidden",
			"title" : "Priority",
			"editorClass" : "form-control input-md"
		}

	}
});

var ExportEditForm = Backbone.Form.extend({
	schema : {
		"id" : {
			"id" : "ID",
			"type" : "Hidden"
		},
		"bundleName" : {
			"title" : "Bundle Name",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
            editorAttrs: {placeholder: 'Bundle Name'}
		},
		"courseId" : {
			"type" : "Select",
			"editorAttrs" : {
				"multiple" : "multiple"
			},
			"title" : "Course",
			 "validators" : [ "required" ],
			"options" : new CourseCollection(),
			"editorClass" : "form-control"
		},
		"priority" : {
			"type" : "Hidden",
			"title" : "Priority",
			"editorClass" : "form-control input-md"
		}

	}
});
