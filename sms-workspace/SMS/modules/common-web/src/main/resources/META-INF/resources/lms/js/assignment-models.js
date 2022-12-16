
var  assignmentBaseUrl = "/api/jsonws/lms.assignment";
var  assigAttachmentBaseUrl = "/api/jsonws/lms.assigattachment";
var  assignmentStuBaseUrl = "/api/jsonws/lms.assignmentstu";
var studentScoreBaseUrl = "/api/jsonws/lms.studentscore";

var Assignment = Backbone.Model.extend({
	
	
	label:'Assignment',
	icon:'$ModelIconUrl$',
	visible : {
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
			},
		"title" : {
			"type" : "Text",
			"title" : "Title",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs :
				{
				placeholder : 'Title'
				}
		},
		"description" : {
			"type" : "Text",
			"title" : "Description",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs :
			{
			placeholder : 'Description'
			}
		},
		"assignmentFile" : {
			"type" : "PDFDOCXFilePicker",
			"title" : "Assignment Attachment",
			"help" : ".pdf & .docx files only upto 5MB",
			"editorClass" : "form-control input-md"
			
		}
	},

 
    localStorage: new Backbone.LocalStorage('tbl-assignment'),
   url: assignmentBaseUrl + "/find",
    create:function (){
    	alert("assignment createUrl 2--------");
    	this.url=assignmentBaseUrl + "/create";
    	return Backbone.ajaxSync('create', this);
    },
	createUrl:function (){
		alert("assignment createUrl 1+++");
		return assignmentBaseUrl + "/create";
    },
  
    update:function (){
    		this.url=assignmentBaseUrl + "/update";
    		return Backbone.ajaxSync('create', this);
    },
    updateUrl:function (){
    		return assignmentBaseUrl + "/upload";
    },
    importUrl:function (){
		return assignmentBaseUrl + "/update";
    },
    
    remove:function (){
    	this.url=assignmentBaseUrl + "/delete";
    	return Backbone.ajaxSync('create', this);
    },
    assignmentFileCreateUrl:function (){
    	
		return assignmentBaseUrl + "/add-assignment-file";
     },
    assignmentCreateUrl:function (classPK){

    	return assignmentBaseUrl + "/create-assignment?classPK="+classPK;
      },
      
     downloadAssignmentsFileByStu : function() {
  		this.url = assignmentStuBaseUrl + "/download-assignment-file";
  		return Backbone.ajaxSync('create', this);
  	},
    uploadAssignmentsFileByStu : function() 
       {
    	return assignmentBaseUrl + "/upload-assignment-file-by-stu";
    	},
  	saveScoreOfStudent : function() {
  		this.url = assignmentStuBaseUrl + "/update-assig-score-of-stu";
  		return Backbone.ajaxSync('create', this);
  	},
  	updateStatus:function (){
    	this.url = assignmentBaseUrl + "/update-status";
    	return Backbone.ajaxSync('create', this);
    }
	,
  	enrolledCourseDetails : function(courseId) {
		this.url = assignmentBaseUrl + "/enrolled-course-details?courseId="+ courseId;
		return Backbone.ajaxSync('read', this);
	},
	findByLocaleCode : function(id,localeCode) {
		this.url = assignmentBaseUrl + "/find-by-locale-code";
		this.attributes["id"] = id;
		this.attributes["localeCode"] = localeCode;
		return Backbone.ajaxSync('create', this);
	}
    	
    
});




var AssignmentCollection = Backbone.Collection.extend({

	model: Assignment,
	url: assignmentBaseUrl + "/find-all",

    localStorage: new Backbone.LocalStorage('tbl-assignment'),
    download: function(filter){
    	
    	return Backbone.ajaxSync('read', this);
    },
    
    findAllAssignmentFileByAssignmentId:  function(assignmentId)
    {
    	
	this.url=assigAttachmentBaseUrl + "/list-of-assignment-file?assignmentId="+assignmentId;
    	return Backbone.ajaxSync('read', this);
    },
	findAll:  function(classPK)
    { 	
	this.url=assignmentBaseUrl + "/find-by-class-pk?classPK="+classPK;
    	return Backbone.ajaxSync('read', this);
    },
    
    findAllStudentsByAssigIdClassPK:  function(assignmentId,classPK)
    {
    	
	this.url=assignmentStuBaseUrl + "/find-by-assignment-id_-class-pk?assignmentId="+assignmentId+"&classPK="+classPK+"";
	
    	return Backbone.ajaxSync('read', this);
    },
    
    findActiveAssignmentListByclassPK:  function(classPK)
    {
	this.url=assignmentBaseUrl + "/find-active-assignment-list-byclass-pk?classPK="+classPK;
    	return Backbone.ajaxSync('read', this);
    },
    findStatusMap:function(){
    	this.url = assignmentBaseUrl + "/find-status-map";
    	return Backbone.ajaxSync('read', this);
    },
	downloadZipFile:function(assignmentId,fileType,studentId){
    	this.url = assignmentBaseUrl + "/download-zip-file?assignmentId="+assignmentId+"&fileType="+fileType+"&studentId="+studentId;
    	return Backbone.ajaxSync('read', this);
    }
    

});

var AssignmentCreateForm = Backbone.Form.extend({

	schema : {
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
			},
		"title" : {
			"type" : "Text",
			"title" : "Title",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs :
			{
			placeholder : 'Title'
			}
		},
		"description" : {
			"type" : "Text",
			"title" : "Description",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs :
			{
			placeholder : 'Description'
			}
		},
		
		"startDate" : {
			"title" : "Start Date",
			"type" : "DatePicker",
			"editorClass" : "form-control input-md",
			"validators" : [ "required" ]
		},
		
		"endDate" : {
			"title" : "End Date",
			"type" : "DatePicker",
			"editorClass" : "form-control input-md",
			"validators" : [ "required" ]
		},
		"assignmentFile" : {
			"type" : "PDFDOCXFilePicker",
			"title" : "Assignment Attachment",
			"help" : ".pdf & .docx files only upto 5MB",
			"editorClass" : "form-control input-md"
			
		}
	}

});


var AssignmentFileCreateForm = Backbone.Form.extend({

	schema : {
		"assignmentAttachment" : {
			"type" : "PDFDOCXFilePicker",
			"title" : "Assignment Attachment",
			"help" : ".pdf & .docx files only upto 5MB",
			"editorClass" : "form-control input-md"
			
		}
	}

});





var AssignmentEditForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
			},
		"title" : {
			"type" : "Text",
			"title" : "Title",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs :
			{
			placeholder : 'Title'
			}
		},
		"description" : {
			"type" : "Text",
			"title" : "Description",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs :
			{
			placeholder : 'Description'
			}
		},
		"startDate" : {
			"title" : "Start Date",
			"type" : "DatePicker",
			"editorClass" : "form-control input-md",
			"validators" : [ "required" ]
		},
		
		"endDate" : {
			"title" : "End Date",
			"type" : "DatePicker",
			"editorClass" : "form-control input-md",
			"validators" : [ "required" ]
		},
		
		"classPK" : {
			"type" : "Hidden",
			"title" : "classPK",
			
			"validators" : [ "required" ]
		}
	}
});


