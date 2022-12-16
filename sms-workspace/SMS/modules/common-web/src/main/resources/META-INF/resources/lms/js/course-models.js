
var courseDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=152";
var courseDefId = 152;
var courseBaseUrl = "/api/jsonws/lms.course";
var cloneinfoBaseUrl = "/api/jsonws/lms.cloneinfo";
var courseSectorUrl = "/api/jsonws/lms.coursesector";
var domainUrl = "/api/jsonws/lms.domain";
var studentCourseBaseUrl = "/api/jsonws/lms.studentcourse";
var Course = Backbone.Model.extend({
	label : 'Course',
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
			"title" : "Course Title",
			"type" : "Text",
			"validators" : [ "required" ]
		},
		"description" : {
			"title" : "Description",
			"type" : "TextArea",
			"validators" : [ "required" ]
		},
		"thumbnailImage" : {
			"title" : "Thumbnail Image",
			"type" : "ImagePicker",
			"validators" : [ "required" ]
		},
		"startDate" : {
			"title" : "Start Date",
			"type" : "Hidden"
		},
		"siteType" : {
			"title" : "Course Membership",
			"type" : "Select",
			"options" : [ {
				"val" : "1",
				"label" : "Open"
			}, {
				"val" : "2",
				"label" : "Restricted"
			}, {
				"val" : "3",
				"label" : "Private"
			} ]
		},
		"siteUrl" : {
			"title" : "Course URL",
			"type" : "Text",
			"validators" : [ "required" ]
		},
		"endDate" : {
			"title" : "End Date",
			"type" : "DatePicker",
			"validators" : [ "required" ]
		},
		"active" : {
			"title" : "Active",
			"type" : "Select",
			"options" : [ "Yes", "No" ]
		},
		"level":{
			"type":"Select",
			"title":"Level",
			"validators":["required"],
			"options":[ "Beginner", "Intermediate", "Advanced" ],
			"fieldclass":0
		},"role" : {
			"title" : "Role",
			"type" : "Text",
			"validators" : [ "required" ]
		},
		"cpeCredit" : {
			"title" : "CPE Credit",
			"type" : "Text",
			"validators" : [ "required" ]
		},
		"passingMarks" : {
			"title" : "Passing Marks",
			"type" : "Text",
			editorAttrs: {placeholder: '10'},
			"editorClass" : "form-control input-md",
			"validators" : [ "number", "required" ]
		},
		"domainId" : {
			"title" : "Domain",
			"type" : "Select",
			"options" : [ ],
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
		},
		"sectorIds" : {
			"title" : "Sectors",
			"type" : "Select",
			"options" : [ ],
			"editorClass" : "form-control input-md",
		}
		
		
	},
	localStorage : new Backbone.LocalStorage('tbl-course'),
	url : courseBaseUrl + "/find",
	create : function() {
		this.url = courseBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	createWithoutPicture : function() {
		this.url = courseBaseUrl + "/create-without-logo";
		return Backbone.ajaxSync('create', this);
	},
	createUrl : function(domainId,sectorIds) {
		return this.url = courseBaseUrl + "/create?domainIdOpt="+domainId+"&sectorIdsOpt="+sectorIds ;
	},
	update : function() {
		this.url = courseBaseUrl + "/update";
		return Backbone.ajaxSync('create', this, {
			iframe : true
		});
	},
	updateWithoutPicture : function() {
		this.url = courseBaseUrl + "/update-without-logo";
		return Backbone.ajaxSync('create', this, {
			iframe : true
		});
	},
	updateUrl : function(domainId,sectorIds) {
		return this.url = courseBaseUrl + "/update?domainIdOpt="+domainId+"&sectorIdsOpt="+sectorIds ;
	},
	remove : function() {
		this.url = courseBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	joinCourse : function() {
		this.url = studentCourseBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	
	findById : function(courseId) {
		this.url = courseBaseUrl + "/find?id="
				+ courseId;
		return Backbone.ajaxSync('read', this);
	},
	findByIdV2 : function(courseId) {
		this.url = courseBaseUrl + "/find-course-by-id?id="
				+ courseId;
		return Backbone.ajaxSync('read', this);
	},
	findCourseById : function(courseId) {
		this.url = courseBaseUrl + "/find-by-id?id="
				+ courseId;
		return Backbone.ajaxSync('read', this);
	},
	findInsightView : function(courseId) {
		this.url = courseBaseUrl + "/student-insight-view?courseId="
				+ courseId;
		return Backbone.ajaxSync('read', this);
	},
	publishCourse : function(courseId) {
		this.url = courseBaseUrl + "/publish-course?courseId="
				+ courseId;
		return Backbone.ajaxSync('read', this);
	},
	toString : function() {
		return this.get('title');
	},
	availableCourseDetails : function(courseId) {
		this.url = courseBaseUrl + "/available-course-details?courseId="+ courseId;
		return Backbone.ajaxSync('read', this);
	},
	enrolledCourseDetails : function(courseId) {
		this.url = courseBaseUrl + "/enrolled-course-details?courseId="+ courseId;
		return Backbone.ajaxSync('read', this);
	},
	completedCourseDetails : function(courseId,studentId) {
		this.url = courseBaseUrl + "/get-completed-course-details?courseId="+ courseId+'&studentId='+studentId;
		return Backbone.ajaxSync('read', this);
	},
	courseStudentDetails : function(courseId) {
		this.url = courseBaseUrl + "/course-student-details?courseId="+ courseId;
		return Backbone.ajaxSync('read', this);
	},
	studentDashbordDetails : function(studentId) {
		this.url = courseBaseUrl + "/get-student-dashbord-details-admin?studentId="+ studentId;
		return Backbone.ajaxSync('read', this);
	},
	getQuestionAttemptDetailArray : function(courseId, studentId) {
		this.url = courseBaseUrl + "/get-question-attempt-detail-array?studentId="+studentId+"&courseId="+courseId;
		return Backbone.ajaxSync('read', this);
	},
	findByLocaleCode : function(id,localeCode) {
		this.url = courseBaseUrl + "/find-by-locale-code";
		this.attributes["id"] = id;
		this.attributes["localeCode"] = localeCode;
		return Backbone.ajaxSync('create', this);
	},
	createCloneRow : function(courseId) {
		this.url = cloneinfoBaseUrl + "/create-clone-row?courseId="+courseId;
		return Backbone.ajaxSync('read', this);
	},
	cloneCourse : function(cloneId) {
		this.url = cloneinfoBaseUrl + "/clone-course?cloneId="+cloneId;
		return Backbone.ajaxSync('read', this);
	},
	findCloneStatus : function(cloneId) {
		this.url = cloneinfoBaseUrl + "/find?id="+cloneId;
		return Backbone.ajaxSync('read', this);
	},
	checkCourseAlreadyCreated : function(title,siteUrl) {
		this.url = courseBaseUrl + "/check-course-already-created?title="+title+"&siteUrl="+siteUrl;
		return Backbone.ajaxSync('read', this);
	},
	checkCourseForEnroll : function(id) {
		this.url = courseBaseUrl + "/check-course-for-enroll?courseId="+id;
		return Backbone.ajaxSync('read', this);
	},
	resetPublishStatus : function(id) {
		this.url = courseBaseUrl + "/reset-publish-status?courseId="+id;
		return Backbone.ajaxSync('read', this);
	},
	findSectorsByCourseId : function() {
		this.url = courseSectorUrl+"/find-sectors-by-course-id";
		return Backbone.ajaxSync('create', this);
	},
	findDomain : function() {
		this.url = domainUrl+"/find";
		return Backbone.ajaxSync('create', this);
	},
	updateStatus:function (){
    	this.url = courseBaseUrl + "/update-status";
    	return Backbone.ajaxSync('create', this);
    }
});

var CourseCollection = Backbone.Collection.extend({
			model : Course,
			url : courseBaseUrl + "/find-all",
			localStorage : new Backbone.LocalStorage('tbl-course'),
			download : function() {
				return Backbone.ajaxSync('read', this);
			},
			allAvailabaleCourse : function() {
				this.url = courseBaseUrl + "/find-all-available-course";
				return Backbone.ajaxSync('read', this);
			},
			allAvailabaleCourseForStudent : function(position,size) {
				this.url = courseBaseUrl + "/find-all-available-course-for-student?position="+position+"&size="+size;
				return Backbone.ajaxSync('read', this);
			},
			downloadByCategory : function(categoryId) {
				this.url = courseBaseUrl + "/find-by-category?categoryId="
						+ categoryId;
				return Backbone.ajaxSync('read', this);
			},
			allApprovedCourse : function() {
				this.url = courseBaseUrl + "/get-all-approved-course";
				return Backbone.ajaxSync('read', this);
			},
			getAllCompletedCourse : function() {
				this.url = courseBaseUrl + "/get-all-completed-course-for-student";
				return Backbone.ajaxSync('read', this);
			},
			getAllCompletedCourseByStudentId: function(linkedUserId) {
				this.url = courseBaseUrl + "/get-all-completed-course-by-student-id?linkedUserId="+linkedUserId;
				return Backbone.ajaxSync('read', this);
			},
			findAllLabStudent : function() {
				this.url = courseBaseUrl + "/find-all-lab-list-student";
				return Backbone.ajaxSync('read', this);
			},
			findAllEnrolledCourseDetails : function(studentId) {
				this.url = courseBaseUrl + "/get-all-enrolled-course-details?studentId="
						+ studentId;
				return Backbone.ajaxSync('read', this);
			},
			findAllCourseData : function() {
				this.url = courseBaseUrl + "/find-all-course-data";
				return Backbone.ajaxSync('read', this);
			},
			findAllAvailableCourseLimit : function(position,size) {
			
				this.url = courseBaseUrl + "/find-all-available-course-in-limits?position="+position+"&size="+size;
				return Backbone.ajaxSync('read', this);
			}
		});

var CourseCreateForm = Backbone.Form.extend({
	schema : {"localeCode" : {
		"title":"Select Language",
		"type":"Select",
		"validators":["required"],
		"options" : new LocaleInfoCollection(),
		"editorClass" : "form-control"
		},
		"title" : {
			"title": "Title",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Course Title'}
		},
		"description" : {
			"title" : "Description",
			"type" : "TextArea",
			"editorClass" : "form-control",
			"validators" : [ "required","description" ],
			editorAttrs: {placeholder: 'Course Description'}
		},
		"thumbnailImage" : {
			"title" : "Thumbnail Image",
			"type" : "ImagePicker",
			"help" : ".png, .jpg, .gif, .svg files only upto 1MB",
		},
		"startDate" : {
			"title" : "Start Date",
			"type" : "Hidden",
			"editorClass" : "form-control input-md"
		},
		"endDate" : {
			"title" : "End Date",
			"type" : "DatePicker",
			"editorClass" : "form-control input-md",
			"validators" : [ "required" ]
		},
		"siteUrl" : {
			"title" : "Course URL",
			"type" : "Hidden",
			"editorClass" : "form-control input-md",
			"validators" : [ "required","courseUrl" ],
			editorAttrs: {placeholder: '/firewall'}
		},
		
		"siteType" : {
			"title": "Membership Type",
			"type" : "Hidden",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Membership Type'}
		},
		/*
		"siteType" : {
			"title" : "Membership Type",
			"type" : "Radio",
			"options" : [  {
				"val" : "1",
				"label" : "Open"
			}, {
				"val" : "2",
				"label" : "Closed"
			} ],
			"validators" : [ "required" ]
		},*/
		"active" : {
			"title" : "Status",
			"type" : "Radio",
			"options" : [  {
				"val" : "Yes",
				"label" : "Enabled"
			}, {
				"val" : "No",
				"label" : "Disabled"
			} ],
			fieldAttrs: {
                "data-bind": "radio",
                    "data-condition": "yes"
            },
			"validators" : [ "required" ]
		},	
		"level":{
			"type":"Select",
			"title":"Level",
			"editorClass" : "form-control",
			"validators":["required"],
			"options" : [ {
				"val" : "",
				"label" : "Please Select"
			}, {
				"val" : "Beginner",
				"label" : "Beginner"
			}, {
				"val" : "Intermediate",
				"label" : "Intermediate"
			}, {
				"val" : "Advanced",
				"label" : "Advanced"
			} ],
			"fieldclass":0
		},"role" : {
			"title" : "Role",
			"type" : "Text",
			editorAttrs: {placeholder: 'Fire Administrator'},
			"editorClass" : "form-control input-md",
			"validators" : [ "required" ]
		},"cpeCredit" : {
			"title" : "CPE Credit",
			"type" : "Text",
			editorAttrs: {placeholder: '10'},
			"editorClass" : "form-control input-md",
			"validators" : [ "number", "required" ]
		},
		"passingMarks" : {
			"title" : "Passing Marks",
			"type" : "Text",
			editorAttrs: {placeholder: '10'},
			"editorClass" : "form-control input-md",
			"validators" : [ "number", "required" ]
		},
		"domainId" : {
			"title" : "Domain",
			"type" : "Select",
			"options" : [ ],
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md"
		},
		"sectorIds" : {
			"title" : "Sectors",
			"type" : "Select",
			"options" : [ ],
			"editorClass" : "form-control input-md"
		}
		
		
	}
});

var CourseEditForm = Backbone.Form.extend({
	schema : {"localeCode" : {
		"title":"Select Language",
		"type":"Select",
		"validators":["required"],
		"options" : new LocaleInfoCollection(),
		"editorClass" : "form-control"
		},
		"id" : {
			"id" : "ID",
			"type" : "Hidden"
		},
		"title" : {
			"title": "Title",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Course Title'}
		},
		"description" : {
			"title" : "Description",
			"type" : "TextArea",
			"editorClass" : "form-control",
			"validators" : [ "required","description" ],
			editorAttrs: {placeholder: 'Course Description'}
		},
		"thumbnailImage" : {
			"title" : "Thumbnail Image",
			"type" : "ImagePicker",
			"help" : ".png, .jpg, .gif, .svg files only upto 1MB",
		},
		"startDate" : {
			"title" : "Start Date",
			"type" : "Hidden",
			"editorClass" : "form-control input-md"
		},
		"endDate" : {
			"title" : "End Date",
			"type" : "DatePicker",
			"editorClass" : "form-control input-md",
			"validators" : [ "required" ]
		},
		"siteUrl" : {
			"title" : "Course URL",
			"type" : "Hidden",
			"editorClass" : "form-control input-md",
			"validators" : [ "required","courseUrl" ],
			editorAttrs: {placeholder: '/firewall'}
		},
		"siteType" : {
			"title": "Membership Type",
			"type" : "Hidden",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Membership Type'}
		},
		/*
		"siteType" : {
			"title" : "Membership Type",
			"type" : "Radio",
			"options" : [  {
				"val" : "1",
				"label" : "Open"
			}, {
				"val" : "2",
				"label" : "Closed"
			} ],
			"validators" : [ "required" ]
		},*/
		"active" : {
			"title" : "Status",
			"type" : "Radio",
			"options" : [  {
				"val" : "Yes",
				"label" : "Enabled"
			}, {
				"val" : "No",
				"label" : "Disabled"
			} ],
			"validators" : [ "required" ]
		},	
		"level":{
			"type":"Select",
			"title":"Level",
			"editorClass" : "form-control",
			"validators":["required"],
			"options" : [ {
				"val" : "",
				"label" : "Please Select"
			}, {
				"val" : "Beginner",
				"label" : "Beginner"
			}, {
				"val" : "Intermediate",
				"label" : "Intermediate"
			}, {
				"val" : "Advanced",
				"label" : "Advanced"
			} ],
			"fieldclass":0
		},"role" : {
			"title" : "Role",
			"type" : "Text",
			editorAttrs: {placeholder: 'Fire Administrator'},
			"editorClass" : "form-control input-md",
			"validators" : [ "required" ]
		},"cpeCredit" : {
			"title" : "CPE Credit",
			"type" : "Text",
			editorAttrs: {placeholder: '10'},
			"editorClass" : "form-control input-md",
			"validators" : [ "number", "required" ]
		},
		"passingMarks" : {
			"title" : "Passing Marks",
			"type" : "Text",
			editorAttrs: {placeholder: '10'},
			"editorClass" : "form-control input-md",
			"validators" : [ "number", "required" ]
		},
		"domainId" : {
			"title" : "Domain",
			"type" : "Select",
			"options" : [ ],
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md"
		},
		"sectorIds" : {
			"title" : "Sectors",
			"type" : "Select",
			"options" : [ ],
			"editorClass" : "form-control input-md"
		}
		
		
	}
});

// My Course Collection Object

var MyCourseCollection = Backbone.Collection.extend({
	model : Course,
	url : studentCourseBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-course'),
	download : function() {
		return Backbone.ajaxSync('read', this);
	}
});

var CourseCloneCreateForm = Backbone.Form.extend({
	schema : {
		"title" : {
			"title": "Title",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs: {placeholder: 'Course Title'}
		},
		"siteUrl" : {
			"title" : "Course URL",
			"type" : "Text",
			"editorClass" : "form-control input-md",
			"validators" : [ "required","courseUrl" ],
			editorAttrs: {placeholder: '/firewall'}
		}
		
		
	}
});