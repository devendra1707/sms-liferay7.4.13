var classScheduleDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=644";
var classScheduleDefId = 644;
var classScheduleBaseUrl = "/api/jsonws/lms.classschedule";

Backbone.Form.editors.Time = Backbone.Form.editors.Text.extend({
	tagName:"div",
	events:{
        'change .picker__input': 'setTime',
        'change .hourInput': 'setTime',
        'change .minuteInput': 'setTime',
        'click .remove': 'removeFile'
    },
    setTime:function(){
    		this.$input.val(this.$hourInput.val() + ":" + this.$minuteInput.val());
    },
    initialize: function(options) {
		Backbone.Form.editors.Hidden.prototype.initialize.call(this, options);
		this.$input = $('<input style="display:none;float:left" type="hidden" name="'+this.key + '"/>');
		//this.$dateInput = $('<input type="text" style="width:56%;float:left;padding-left:9px;padding-right: 0px;" name="'+this.key+'-date-input" />');
		var hourOptions;
		for(var i=0;i<24;i++){
			var hh = (i<10)?"0"+i:i;
			hourOptions = hourOptions + '<option value="' + hh + '">' + hh + '</option>';
		}
		this.$hourInput = $('<select pattern="[0-9]*" style="width:54px;height:25px;background:none;padding:0;padding-left:11px;"  class="hourInput" name="'+this.key+'-hour-input">' + hourOptions + '</select>');
		var minuteOptions;
		
		for(var i=0;i<60;i++){
			var mm = (i<10)?"0"+i:i;
			minuteOptions = minuteOptions + '<option value="' + mm + '">' + mm + '</option>';
		}
		
		this.$minuteInput = $('<select pattern="[0-9]*" style="margin-left:3px;width:54px;height:25px;background:none;padding:0;padding-left:11px;" class="minuteInput" name="'+this.key+'-minute-input">' + minuteOptions + '</select>');
        this.$error = $('<div class="error">Error</div>');
    },
    render: function() {
        // Call the parent's render method
    		Backbone.Form.editors.Hidden.prototype.render.apply(this, arguments);
    		this.$el.append(this.$hourInput);
    		this.$el.append(this.$minuteInput);
    		this.$el.append(this.$input);
    		this.$el.attr("style", "float:left;width:100%");
    		//this.$el.addClass('hasDateTimePicker');
    		//this.$el.append(this.$list);
    		return this;
    },
    getValue: function() {
        var val = this.$input.val();
        return val;
    },
    // The set value must correctl
    setValue: function(value) {
    	if(value==""){
    		value = "00:00";
    	}
    	
    	//this.$dateInput.val(moment(value).format('DD-MMM-YYYY'));
    	this.$hourInput.val(value.split(":")[0]);
    	this.$minuteInput.val(value.split(":")[1]);
    	this.$input.val(value);
    	}
});


var ClassSchedule = Backbone.Model.extend({
	label : 'Class Schedule',
	icon : '$ModelIconUrl$',
	visible : {
	"classId": {
		"validators": [
			"required"
		],
		"type": "Select",
		"title": "Class",
                "options":"<ClassRoom>",
		"editorClass": "red form-control",
		"editorAttrs": {
			"maxlength": "75"
		}
	},
    "classDate": {
		"validators": [
			"required"
		],
		"type": "Date",
		"title": "Class Date",
		"editorClass": "red form-control",
		"editorAttrs": {
			"maxlength": "75"
		}
	},
	"startTime": {
		"validators": [
			"required"
		],
		"type": "Text",
		"title": "Start Time",
		"editorClass": "red form-control"
	},
	"endTime": {
		"validators": [
			"required"
		],
		"type": "Text",
		"title": "End Time",
		"editorClass": "red form-control"
	},
	"type": {
		"validators": [
			"required"
		],
		"type": "Select",
		"title": "Type",
		"options": [
			{
				"label": "Offline",
				"val": "Offline"
			},
			{
				"label": "Online",
				"val": "Online"
			}
		],
		"editorClass": "form-control"
	},
	"venue": {
		"validators": [],
		"type": "Text",
		"title": "Venue",
		"editorClass": "red form-control",
		"editorAttrs": {
			"maxlength": "75"
		}
	},
	"url": {
		"validators": [],
		"type": "Text",
		"title": "Url",
		"editorClass": "red form-control",
		"editorAttrs": {
			"maxlength": "75"
		}
	},
	"description": {
		"validators": [
			"required"
		],
		"type": "TextArea",
		"title": "Description",
		"editorClass": "form-control",
		"editorAttrs": {
			"maxlength": "1000"
		}
	},
	"codeRequired": {
		"type": "Hidden",
		"title": "Code Required",
		"options": [
			{
				"label": "Yes",
				"val": "yes"
			},
			{
				"label": "No",
				"val": "no"
			}
		],
		"editorClass": "form-control"
	},
	"joiningCode": {
		"type": "Hidden",
		"title": "Joining Code",
		"editorClass": "red form-control",
		"editorAttrs": {
			"maxlength": "8"
		}
	},
	"certificateNo": {
		"type": "Hidden",
		"title": "Certificate Number",
		"editorClass": "red form-control",
		"editorAttrs": {
			"maxlength": "20"
		}
	}
},
	localStorage : new Backbone.LocalStorage('tbl-classschedule'),
	url : classScheduleBaseUrl + "/find",
	create : function() {
		this.url = classScheduleBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function() {
		return classScheduleBaseUrl + "/create";
	},
	upload : function() {
		this.url = classScheduleBaseUrl + "/upload";
		return Backbone.ajaxSync('create', this);
	},
	update : function() {
		this.url = classScheduleBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	updateUrl : function() {
		return classScheduleBaseUrl + "/update";
	},
	importUrl : function() {
		return classScheduleBaseUrl + "/upload";
	},
	remove : function() {
		this.url = classScheduleBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	approve : function() {
		this.url = classScheduleBaseUrl + "/approve";
		return Backbone.ajaxSync('create', this);
	},
	getCertificateText : function() {
		this.url = classScheduleBaseUrl + "/get-certificate-text";
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('classDate');
	}
});

var ClassScheduleCollection = Backbone.Collection.extend({
	model : ClassSchedule,
	url : classScheduleBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-classschedule'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	},
	downloadByClass : function(classId) {
		this.url = classScheduleBaseUrl + "/find-by-class?classId=" + classId;
		return Backbone.ajaxSync('read', this);
	},
});

var ClassScheduleCreateForm = Backbone.Form.extend({
	schema : {"description":{"validators":["required"],"type":"Text","title":"Subject","editorClass":"form-control","editorAttrs":{"maxlength":"1000"}},"classId":{"validators":["required"],"type":"Select","title":"Class","options":new ClassRoomCollection(),"editorClass":"red form-control","editorAttrs":{"maxlength":"75"}},"classDate":{"validators":["required"],"type":"Date","title":"Class Date","editorClass":"red form-control","editorAttrs":{"maxlength":"75"}},"startTime":{"validators":["required"],"type":"Time","title":"Start Time","editorClass":"red form-control"},"endTime":{"validators":["required"],"type":"Time","title":"End Time","editorClass":"red form-control"},"type":{"validators":["required"],"type":"Select","title":"Type","options":[{"label":"Offline","val":"Offline"},{"label":"Online","val":"Online"}],"editorClass":"form-control"},"venue":{"editorAttrs":{'class':'form-control'},"type":"Text","title":"Location","editorClass":"red form-control","editorAttrs":{"maxlength":"75"}},"url":{"editorAttrs":{'class':'form-control'},"type":"Text","validators":["url"],"title":"Url","editorClass":"red form-control","editorAttrs":{"maxlength":"75"}},"codeRequired":{"validators":["required"],"type":"Select","title":"Code Required","options":[{"label":"Yes","val":"yes"},{"label":"No","val":"no"}],"editorClass":"form-control"},"joiningCode":{"validators":["required","number"],"type":"Text","title":"Joining Code","editorClass":"red form-control","editorAttrs":{"maxlength":"8"}}}
});

var InClassClassScheduleCreateForm = Backbone.Form.extend({
	schema : {
		"description": {
			"validators": ["required"],
			"type": "TextArea",
			"title": "Description of Training Schedule",
			"editorClass": "form-control",
			"editorAttrs": {
				"maxlength": "512",
				"placeholder":"This description will appear printed in certificate"
			}
		},
		"regionalDescription": {
			"validators": ["required"],
			"type": "TextArea",
			"title": "Regional Description of Training Schedule",
			"editorClass": "form-control",
			"editorAttrs": {
				"maxlength": "512",
				"placeholder":"This description will appear in certificate in regional language"
			}
		},
		"classId": {
			"validators": ["required"],
			"type": "Hidden",
			"title": "Class",
			"editorClass": "red form-control",
			"editorAttrs": {
				"maxlength": "75"
			}
		},
		"classDate": {
			"validators": ["required"],
			"type": "DatePicker",
			"title": "Class Date",
			"editorClass": "red form-control",
			"editorAttrs": {
				"maxlength": "75"
			}
		},
		"days": {
			"validators": ["required", "number"],
			"type": "Text",
			"title": "Number of Days",
			"editorClass": "form-control",
			"editorAttrs": {
				"maxlength": "2"
			}
		},
		"startTime": {
			"validators": ["required"],
			"type": "Time",
			"title": "Start Time",
			"editorClass": "red form-control"
		},
		"endTime": {
			"validators": ["required"],
			"type": "Time",
			"title": "End Time",
			"editorClass": "red form-control"
		},
		"type": {
			"validators": ["required"],
			"type": "Select",
			"title": "Type",
			"options": [{
				"label": "Offline",
				"val": "Offline"
			}, {
				"label": "Online",
				"val": "Online"
			}],
			"editorClass": "form-control"
		},
		"venue": {
			"editorAttrs": {
				'class': 'form-control'
			},
			"type": "Text",
			"title": "Location",
			"editorClass": "red form-control",
			"editorAttrs": {
				"maxlength": "75"
			}
		},
		"url": {
			"editorAttrs": {
				'class': 'form-control'
			},
			"type": "Text",
			"title": "Url",
			"validators": ["url"],
			"editorClass": "red form-control",
			"editorAttrs": {
				"maxlength": "75"
			}
		},
		"codeRequired": {
			"validators": [],
			"type": "Hidden",
			"title": "Code Required",
			"options": [{
				"label": "Yes",
				"val": "yes"
			}, {
				"label": "No",
				"val": "no"
			}],
			"editorClass": "form-control"
		},
		"joiningCode": {
			"validators": ["number"],
			"type": "Hidden",
			"title": "Joining Code",
			"editorClass": "red form-control",
			"editorAttrs": {
				"maxlength": "8"
			}
		},
		"authorityRoleOne": {
			"type": "Text",
			"title": "First Certifying Authority Role",
			"editorClass": "form-control",
			"editorAttrs": {
				"maxlength": "75",
				"placeholder":"Regional Name / English Name"
			}
		},
		"authorityNameOne": {
			"type": "Text",
			"title": "First Certifying Authority Name One",
			"editorClass": "form-control",
			"editorAttrs": {
				"maxlength": "75",
				"placeholder":"Regional Name / English Name"
			}
		},
		"authorityRoleTwo": {
			"type": "Text",
			"title": "Second Certifying Authority Role",
			"editorClass": "form-control",
			"editorAttrs": {
				"maxlength": "75",
				"placeholder":"Regional Name / English Name"	
			}
		},
		"authorityNameTwo": {
			"type": "Text",
			"title": "Second Certifying Authority Name",
			"editorClass": "form-control",
			"editorAttrs": {
				"maxlength": "75",
				"placeholder":"Regional Name / English Name"
			}
		},
		"certificateNo": {
			"validators": ["required"],
			"type": "Text",
			"title": "Certificate Number",
			"editorClass": "red form-control",
			"editorAttrs": {
				"maxlength": "20"
			}
		}
	}
});

var ClassScheduleUploadForm = Backbone.Form.extend({
	schema : {
			"excelFile": {
				"type": "FilePicker",
				"title": "Select File (Excel Only)"
			}
		}
});

var ClassScheduleEditForm = Backbone.Form.extend({
	schema : {"id":{"type":"Hidden","title":"ID"},"description":{"validators":["required"],"type":"Text","title":"Subject","editorClass":"form-control","editorAttrs":{"maxlength":"1000"}},"classId":{"validators":["required"],"type":"Select","title":"Class","options":new ClassRoomCollection(),"editorClass":"red form-control","editorAttrs":{"maxlength":"75"}},"classDate":{"validators":["required"],"type":"Date","title":"Class Date","editorClass":"red form-control","editorAttrs":{"maxlength":"75"}},"startTime":{"validators":["required"],"type":"Time","title":"Start Time","editorClass":"red form-control"},"endTime":{"validators":["required"],"type":"Time","title":"End Time","editorClass":"red form-control"},"type":{"validators":["required"],"type":"Select","title":"Type","options":[{"label":"Offline","val":"Offline"},{"label":"Online","val":"Online"}],"editorClass":"form-control"},"venue":{"editorAttrs":{'class':'form-control'},"type":"Text","title":"Location","editorClass":"red form-control","editorAttrs":{"maxlength":"75"}},"url":{"editorAttrs":{'class':'form-control'},"validators":["url"],"type":"Text","title":"Url","editorClass":"red form-control","editorAttrs":{"maxlength":"75"}},"codeRequired":{"validators":["required"],"type":"Select","title":"Code Required","options":[{"label":"Yes","val":"yes"},{"label":"No","val":"no"}],"editorClass":"form-control"},"joiningCode":{"validators":["required","number"],"type":"Text","title":"Joining Code","editorClass":"red form-control","editorAttrs":{"maxlength":"8"}}}
});
var InClassClassScheduleEditForm = Backbone.Form.extend({
	schema : {
		"id": {
			"type": "Hidden",
			"title": "ID"
		},
		"description": {
			"validators": ["required"],
			"type": "TextArea",
			"title": "Description of Training Schedule",
			"editorClass": "form-control",
			"editorAttrs": {
				"maxlength": "512",
				"placeholder":"This description will appear printed in certificate"
			}
		},
		"regionalDescription": {
			"validators": ["required"],
			"type": "TextArea",
			"title": "Regional Description of Training Schedule",
			"editorClass": "form-control",
			"editorAttrs": {
				"maxlength": "512",
				"placeholder":"This description will appear in certificate in regional language"
			}
		},
		"classId": {
			"validators": ["required"],
			"type": "Hidden",
			"title": "Class",
			"editorClass": "red form-control",
			"editorAttrs": {
				"maxlength": "75"
			}
		},
		"classDate": {
			"validators": ["required"],
			"type": "DatePicker",
			"title": "Class Date",
			"editorClass": "red form-control",
			"editorAttrs": {
				"maxlength": "75"
			}
		},
		"days": {
			"validators": ["required","number"],
			"type": "Text",
			"title": "No. of Days",
			"editorClass": "form-control",
			"editorAttrs": {
				"maxlength": "2"
			}
		},  
		"startTime": {
			"validators": ["required"],
			"type": "Time",
			"title": "Start Time",
			"editorClass": "red form-control"
		},
		"endTime": {
			"validators": ["required"],
			"type": "Time",
			"title": "End Time",
			"editorClass": "red form-control"
		},
		"type": {
			"validators": ["required"],
			"type": "Select",
			"title": "Type",
			"options": [{
				"label": "Offline",
				"val": "Offline"
			}, {
				"label": "Online",
				"val": "Online"
			}],
			"editorClass": "form-control"
		},
		"venue": {
			"editorAttrs": {
				'class': 'form-control'
			},
			"type": "Text",
			"title": "Location",
			"editorClass": "red form-control",
			"editorAttrs": {
				"maxlength": "75"
			}
		},
		"url": {
			"editorAttrs": {
				'class': 'form-control'
			},
			"type": "Text",
			"title": "Url",
			"validators": ["url"],
			"editorClass": "red form-control",
			"editorAttrs": {
				"maxlength": "75"
			}
		},
		"codeRequired": {
			"validators": [],
			"type": "Hidden",
			"title": "Code Required",
			"options": [{
				"label": "Yes",
				"val": "yes"
			}, {
				"label": "No",
				"val": "no"
			}],
			"editorClass": "form-control"
		},
		"joiningCode": {
			"validators": ["number"],
			"type": "Hidden",
			"title": "Joining Code",
			"editorClass": "red form-control",
			"editorAttrs": {
				"maxlength": "8"
			}
		},
		"authorityRoleOne": {
			"type": "Text",
			"title": "First Certifying Authority Role",
			"editorClass": "form-control",
			"editorAttrs": {
				"maxlength": "75",
				"placeholder":"Regional Name / English Name"
			}
		},
		"authorityNameOne": {
			"type": "Text",
			"title": "First Certifying Authority Name One",
			"editorClass": "form-control",
			"editorAttrs": {
				"maxlength": "75",
				"placeholder":"Regional Name / English Name"
			}
		},
		"authorityRoleTwo": {
			"type": "Text",
			"title": "Second Certifying Authority Role",
			"editorClass": "form-control",
			"editorAttrs": {
				"maxlength": "75",
				"placeholder":"Regional Name / English Name"	
			}
		},
		"authorityNameTwo": {
			"type": "Text",
			"title": "Second Certifying Authority Name",
			"editorClass": "form-control",
			"editorAttrs": {
				"maxlength": "75",
				"placeholder":"Regional Name / English Name"
			}
		},
		"certificateNo": {
			"validators": ["required"],
			"type": "Text",
			"title": "Certificate Number",
			"editorClass": "red form-control",
			"editorAttrs": {
				"maxlength": "20"
			}
		}
	}
});
