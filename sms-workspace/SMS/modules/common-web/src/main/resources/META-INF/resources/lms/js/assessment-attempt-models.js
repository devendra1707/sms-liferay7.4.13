
		var  assessmentAttemptBaseUrl = "/api/jsonws/lms.assessmentattempt";

		var AssessmentAttempt = Backbone.Model.extend({
		label:'Assessment Attempt',
		icon:'$ModelIconUrl$',
		visible: {
			"assessmentAttemptResultJSON":{"title":"Result JSON", "type":"Text","validators":["required"]},
			"assessmentAttemptReviewJSON":{"title":"Review JSON", "type":"Text","validators":["required"]},
			"assessmentDuration":{"title":"Assessment Duration", "type":"Text","validators":["required","number"]},
			"assessmentLevelId":{"title":"Assessment Level Id", "type":"Text","validators":["required","number"]},
			"attemptDuration":{"title":"Attempt Duration", "type":"Text","validators":["required","number"]},
			"courseId":{"title":"Course", "type":"Select","options":"<Course>"},
			"courseTitle":{"title":"Course Name", "type":"Text","validators":["required"]},
			"score":{"title":"Score", "type":"Text","validators":["required","number"]},
			"testType":{"title":"Test Type", "type":"Text","validators":["required"]},
			"startAt":{"title":"Start At", "type":"Text","validators":["required","number"]},
			"endAt":{"title":"End At", "type":"Text","validators":["required","number"]},
			"isAbort":{"title":"Abort", "type":"Text","validators":["required"]},
			"questionSetId":{"title":"Question Set Id", "type":"Text","validators":["required","number"]},
			"questionSetJSON":{"title":"Question Set JSON", "type":"Text","validators":["required"]}
		},
	    localStorage: new Backbone.LocalStorage('tbl-assessmentattempt'),
	    url: assessmentAttemptBaseUrl + "/find",
	    create:function (){
	    	//this.attributes["assessmentLevelName"] = assessmentLevelName;
	    	this.url = assessmentAttemptBaseUrl + "/create";
	    	return Backbone.ajaxSync('create', this);
	    },
		createUrl:function (){
			return assessmentAttemptBaseUrl + "/create";
	    },
	    update:function (){
	    	//this.attributes["assessmentLevelName"] = assessmentLevelName;
	    	
	    		this.url=assessmentAttemptBaseUrl + "/update";
	    		return Backbone.ajaxSync('create', this);
	    },
	    updateUrl:function (){
	    		return assessmentAttemptBaseUrl + "/update";
	    },
	    remove:function (){
	    	this.url=assessmentAttemptBaseUrl + "/delete";
	    	return Backbone.ajaxSync('create', this);
	    },
	    toString: function() {
        	return this.get('assessmentLevel');
    	}
	});
	
	var AssessmentAttemptCollection = Backbone.Collection.extend({
		model: AssessmentAttempt,
		url: assessmentAttemptBaseUrl + "/find-all",
	    localStorage: new Backbone.LocalStorage('tbl-assessmentattempt'),
	    download: function(filter){
	    	return Backbone.ajaxSync('read', this);
	    }
	});

	var AssessmentAdminAttemptCollection = Backbone.Collection.extend({
		model: AssessmentAttempt,
		url: assessmentAttemptBaseUrl + "/find-all-assessment-admin",
	    localStorage: new Backbone.LocalStorage('tbl-assessmentattempt'),
	    download: function(filter){
	    	return Backbone.ajaxSync('read', this);
	    }
	});
	
	