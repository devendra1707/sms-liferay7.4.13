		var  reattemptControlDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=179";
		var 	 reattemptControlDefId = 179;
		//var  reattemptControlBaseUrl = "http://portal.armantecsystems.com/api/jsonws/LMS-portlet.reattempt-control";
		var  reattemptControlBaseUrl = "/api/jsonws/lms.reattemptcontrol";

		var ReattemptControl = Backbone.Model.extend({
		label:'Reattempt Control',
		icon:'$ModelIconUrl$',
		visible: {
"studentId":{"type":"Select","title":"Student","validators":["required"],"options":"<Student>","fieldclass":0}
,"courseId":{"type":"Select","title":"Course","validators":["required"],"options":"<Course>","fieldclass":0}
,"testType":{"type":"Select","title":"Test Type","validators":["required"],"options":["PRETEST","POSTTEST"],"fieldclass":0}
,"assessmentLevel":{"type":"Select","title":"Assessment Level","validators":["required"],"options":"<AssessmentLevel>","fieldclass":0}
,"state":{"title":"State","type":"Select","options":["true","false"]}
},
	    localStorage: new Backbone.LocalStorage('tbl-reattemptcontrol'),
	    url: reattemptControlBaseUrl + "/find",
	    create:function (){
	    	this.url=reattemptControlBaseUrl + "/create";
	    	return Backbone.ajaxSync('create', this);
	    },
		createUrl:function (){
			return reattemptControlBaseUrl + "/create";
	    },
	    update:function (){
	    		this.url=reattemptControlBaseUrl + "/update";
	    		return Backbone.ajaxSync('create', this);
	    },
	    updateUrl:function (){
	    		return reattemptControlBaseUrl + "/update";
	    },
	    remove:function (){
	    	this.url=reattemptControlBaseUrl + "/delete";
	    	return Backbone.ajaxSync('create', this);
	    },
	    toString: function() {
        	return this.get('studentId');
    	},
    	addAndUpdateRow: function(assessmentAttemptId,status) {
    		this.url=reattemptControlBaseUrl + "/change-state-of-approval-for-next-attempt";
    		this.attributes["assessmentAttemptId"] = assessmentAttemptId;
    		this.attributes["status"] = status;   
    		return Backbone.ajaxSync('create', this);
    	}	    
	});
	
	var ReattemptControlCollection = Backbone.Collection.extend({
		model: ReattemptControl,
		url: reattemptControlBaseUrl + "/find-all",
	    localStorage: new Backbone.LocalStorage('tbl-reattemptcontrol'),
	    download: function(filter){
	    	return Backbone.ajaxSync('read', this);
	    }
	});
	
	var ReattemptAdminControlCollection = Backbone.Collection.extend({
		model: ReattemptControl,
		url: reattemptControlBaseUrl + "/find-all-recent-assessment-attempt",
	    localStorage: new Backbone.LocalStorage('tbl-reattemptcontrol'),
	    download: function(filter){
	    	return Backbone.ajaxSync('read', this);
	    }
	});
	
	var ReattemptControlCreateForm = Backbone.Form.extend({
		schema: {"studentId":{"type":"Select","title":"Student","validators":["required"],"options":new StudentCollection(),"fieldclass":0},"courseId":{"type":"Select","title":"Course","validators":["required"],"options":new CourseCollection(),"fieldclass":0},"testType":{"type":"Select","title":"Test Type","validators":["required"],"options":["PRETEST","POSTTEST"],"fieldclass":0},"assessmentLevel":{"type":"Select","title":"Assessment Level","validators":["required"],"options":new AssessmentLevelCollection(),"fieldclass":0},"state":{"title":"State","type":"Select","options":["true","false"]}}
	});
	
	var ReattemptControlEditForm = Backbone.Form.extend({
		schema: {
			"studentId":{"type":"Select","title":"Student","validators":["required"],"options":new StudentCollection(),"fieldclass":0}
,"courseId":{"type":"Select","title":"Course","validators":["required"],"options":new CourseCollection(),"fieldclass":0}
,"testType":{"type":"Select","title":"Test Type","validators":["required"],"options":["PRETEST","POSTTEST"],"fieldclass":0}
,"assessmentLevel":{"type":"Select","title":"Assessment Level","validators":["required"],"options":new AssessmentLevelCollection(),"fieldclass":0}
,"state":{"title":"State","type":"Select","options":["true","false"]}
}
	});