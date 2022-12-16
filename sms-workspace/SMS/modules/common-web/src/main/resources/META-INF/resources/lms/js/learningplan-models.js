
var learningPlanBaseUrl = "/api/jsonws/lms.learningplan";
var courseLearningPlanBaseUrl = "/api/jsonws/lms.courselearningplan";
var learningPlanAssignmentBaseUrl = "/api/jsonws/lms.learningplanassignment";

var LearningPlan = Backbone.Model.extend({
	label : 'LearningPlan',
	icon : '$ModelIconUrl$',
	visible : {
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
			},
		"id" : {
			"title" : "ID",
			"type" : "Hidden"
		},
		
		"title" : {
			"title" : "Title",
			"type" : "Text"
		},
		"description" : {
			"title" : "Description",
			"type" : "Text"
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-LearningPlan'),
	url : learningPlanBaseUrl + "/find",
	create : function() {
		this.url = learningPlanBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},update : function() {
		this.url = learningPlanBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	getStudentsList : function() {
		this.url = learningPlanBaseUrl + "/get-students-list";
		return Backbone.ajaxSync('read', this);
	},
	getCourseList : function() {
		this.url = learningPlanBaseUrl + "/get-course-list";
		return Backbone.ajaxSync('read', this);
	},
	remove : function() {
		this.url = learningPlanBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
    assignStudentList:function(){
    	this.url=learningPlanAssignmentBaseUrl + "/assign-student-list";
    	return Backbone.ajaxSync('create', this);
    },
	assignStudentGroupList:function(){
    	this.url=learningPlanAssignmentBaseUrl + "/assign-student-group-list";
    	return Backbone.ajaxSync('create', this);
    },
    updateStatus:function(){
    	this.url=learningPlanBaseUrl + "/update-status";
    	return Backbone.ajaxSync('create', this);
    },
    attachCourseList:function(){
    	this.url=courseLearningPlanBaseUrl + "/attach-course-list";
    	return Backbone.ajaxSync('create', this);
    },
    removeCourse:function(){
    	this.url=courseLearningPlanBaseUrl + "/remove-course";
    	return Backbone.ajaxSync('create', this);
    },
    updateSequence:function(){
    	this.url=courseLearningPlanBaseUrl + "/update-sequence";
    	return Backbone.ajaxSync('create', this);
    },
    enrollAllCourses:function(){
    	this.url=courseLearningPlanBaseUrl + "/enroll-all-courses";
    	return Backbone.ajaxSync('create', this);
    },
	findByLocaleCode : function(id,localeCode) {
		this.url = learningPlanBaseUrl + "/find-by-locale-code";
		this.attributes["id"] = id;
		this.attributes["localeCode"] = localeCode;
		return Backbone.ajaxSync('create', this);
	},
	removeLearningPlanAssignedStudent : function() {
		this.url = learningPlanAssignmentBaseUrl + "/remove-learning-plan-assigned-student";
		return Backbone.ajaxSync('create', this);
	},
	removeLearningPlanAssignedStudentGroup: function() {
		this.url = learningPlanAssignmentBaseUrl + "/remove-learning-plan-assigned-student-group";
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('title');
	}
});

var LearningPlanCollection = Backbone.Collection.extend({
	model : LearningPlan,
	sortKey: 'title',
	sortDir: '',
	comparator: function(a, b) {
	  var dataA = a.get(this.sortKey),
	      dataB = b.get(this.sortKey);
      var ret = 0;
	  if(dataA < dataB)
	    ret = -1;
	  else if(dataA > dataB)
	    ret = 1;
	  else
	    ret = 0;

	  if(this.sortDir === 'desc')
	    ret = -ret
	  else if( this.sortDir === '')
		ret = 0;
	  return ret;
	},
	url : learningPlanBaseUrl + "/find-all-learning-plans",
	localStorage : new Backbone.LocalStorage('tbl-LearningPlan'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	},
	saveCourseLearningPlan : function(courseId,learningPlanId) {
		this.url = courseLearningPlanBaseUrl + "/add-course?courseId="+courseId+"&learningPlanId="+learningPlanId;
		return Backbone.ajaxSync('create', this);
	},
	saveStudentLearningPlan : function(type,classPk,learningPlanId){
		this.url = learningPlanAssignmentBaseUrl + "/save-student-learning-plan?type="+type+"&classPk="+classPk+"&learningPlanId="+learningPlanId;
		return Backbone.ajaxSync('create', this);
	},
	findAllUnassignedStudentByLearningPlanId : function(learningPlanId){
		this.url = learningPlanAssignmentBaseUrl + "/find-all-unassigned-student?learningPlanId="+learningPlanId;
		return Backbone.ajaxSync('read', this);
	},
	findAllUnassignedStudentGroupByLearningPlanId : function(learningPlanId){
		this.url = learningPlanAssignmentBaseUrl + "/find-all-unassigned-student-group?learningPlanId="+learningPlanId;
		return Backbone.ajaxSync('read', this);
	},
	findAllUnattachedCourseByLearningPlanId : function(learningPlanId){
		this.url = courseLearningPlanBaseUrl + "/find-all-unattached-course?learningPlanId="+learningPlanId;
		return Backbone.ajaxSync('read', this);
	},
	findAllAssignedStudentByLearningPlanId : function(learningPlanId){
		this.url = learningPlanAssignmentBaseUrl + "/find-all-assigned-student?learningPlanId="+learningPlanId;
		return Backbone.ajaxSync('read', this);
	},
	findAllAssignedStudentGroupByLearningPlanId : function(learningPlanId){
		this.url = learningPlanAssignmentBaseUrl + "/find-all-assigned-student-group?learningPlanId="+learningPlanId;
		return Backbone.ajaxSync('read', this);
	},
	findCoursesByLearningPlanId : function(learningPlanId){
		this.url = courseLearningPlanBaseUrl + "/find-courses-by-learning-plan-id?learningPlanId="+learningPlanId;
		return Backbone.ajaxSync('read', this);
	}
});

var LearningPlanCreateForm = Backbone.Form.extend({
	schema : {
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
			},
		"title" : {
			"title" : "Title",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Title'
			}
		},
		"description" : {
			"title" : "Description",
			"type" : "Text",
			"validators" : [ "required" ],
			"editorClass" : "form-control input-md",
			editorAttrs : {
				placeholder : 'Description'
			}
		}	}
});
// //change
var LearningPlanEditForm = Backbone.Form.extend({

	schema : {
		"localeCode" : {
			"title":"Select Language",
			"type":"Select",
			"validators":["required"],
			"options" : new LocaleInfoCollection(),
			"editorClass" : "form-control"
			},
		"title" : {
		"title" : "Title",
		"type" : "Text",
		"validators" : [ "required" ],
		"editorClass" : "form-control input-md",
		editorAttrs : {
			placeholder : 'Title'
		}
	},
	"description" : {
		"title" : "Description",
		"type" : "Text",
		"validators" : [ "required" ],
		"editorClass" : "form-control input-md",
		editorAttrs : {
			placeholder : 'Description'
		}
	}		}
});
