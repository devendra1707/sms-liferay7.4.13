var ImportInfoBaseUrl = "/api/jsonws/lms.importinfo";


var ImportInfo = Backbone.Model.extend({
	label : 'ImportInfo',
	icon : '$ModelIconUrl$',
	idAttribute : 'id',
	visible : {
		"zipFile" : {
			"title" : "Select Bundle",
			"type" : "File"
		},
		"priority" : {
			"type" : "Hidden",
			"title" : "Priority",
			"editorClass" : "form-control input-md"
		}

	},
	localStorage : new Backbone.LocalStorage('ImportInfo'),
	url : ImportInfoBaseUrl + "/find",
	create : function() {
		this.url = ImportInfoBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createImportRowUrl : function() {
		return ImportInfoBaseUrl + "/create-import-row";
	},
	update : function() {
		this.url = ImportInfoBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	deleteImport : function(id) {
		this.url = ImportInfoBaseUrl + "/delete?id="+id;
		return Backbone.ajaxSync('create', this);
	},
	createImportRow: function() {
		this.url = ImportInfoBaseUrl + "/create-import-row";
		return Backbone.ajaxSync('create', this);
	},
	startImport: function(id) {
		this.url = ImportInfoBaseUrl + "/start-import";
		this.attributes["importId"] = id;
		return Backbone.ajaxSync('create', this);
	},
	findImportStatus: function(id) {
		this.url = ImportInfoBaseUrl + "/find-import-status";
		this.attributes["importId"] = id;
		return Backbone.ajaxSync('create', this);
	}
});


var ImportCollection = Backbone.Collection.extend({
	model : ImportInfo,
	url : ImportInfoBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-ImportInfo'),
	download : function() {
		return Backbone.ajaxSync('read', this);
	},
	findAllImports : function() {
		this.url = ImportInfoBaseUrl + "/find-all-imports";
		return Backbone.ajaxSync('read', this);
	}
});


var ImportCreateForm = Backbone.Form.extend({
	schema : {

		"zipFile" : {
			"title" : "Select Bundle",
			"type" : "ZipFilePicker",
			"help" : ".zip files only",
			"editorClass" : "input-file"
		},
		"priority" : {
			"type" : "Hidden",
			"title" : "Priority",
			"editorClass" : "form-control input-md"
		}

	}
});

var ImportEditForm = Backbone.Form.extend({
	schema : {
		"id" : {
			"id" : "ID",
			"type" : "Hidden"
		},
		"zipFile" : {
			"title" : "Select Bundle",
			"type" : "ZipFilePicker",
			"help" : ".zip files only",
			"editorClass" : "input-file",
			"validators" : [ "required" ]
		},
		"priority" : {
			"type" : "Hidden",
			"title" : "Priority",
			"editorClass" : "form-control input-md"
		}

	}
});
