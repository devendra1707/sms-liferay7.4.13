		var  recentActivityUrl = "/api/jsonws/lms.recentactivity";

		var RecentActivity = Backbone.Model.extend({
		label:'Recent Activity',
		icon:'$ModelIconUrl$',
		visible: {
			  "studentId": { "type":"Text", "title":"Student Id", "validators":"required",},
			  "courseId": { "type":"Text", "title":"Course Id", "validators":"required",},
			  "lessonId": { "type":"Text", "title":"Lesson Id", "validators":"required",},
			  "topicId": { "type":"Text", "title":"Topic Id", "validators":"required",}
			 
			},
	    localStorage: new Backbone.LocalStorage('tbl-recentactivity'),
	    url: recentActivityUrl + "/find",
	    create:function (){
	    	this.url=recentActivityUrl + "/create";
	    	return Backbone.ajaxSync('create', this);
	    },
	    update:function (){
	    		this.url=recentActivityUrl + "/update";
	    		return Backbone.ajaxSync('create', this);
	    },
	    remove:function (){
	    	this.url=recentActivityUrl + "/delete";
	    	return Backbone.ajaxSync('create', this);
	    },
	    
	    updateRecentActivity:function (recordId,type){
    		this.url=recentActivityUrl + "/update-recent-activity";
    		this.attributes["recordId"] = recordId; 
    		this.attributes["type"] = type; 
    		return Backbone.ajaxSync('create', this);
	    },	
	    toString: function() {
        	return this.get('id');
    	},
        checkEnrolledCourseDetail:function (){
        	this.url=recentActivityUrl + "/check-enrolled-course-info";
        	return Backbone.ajaxSync('create', this);
        }
		});
			
	