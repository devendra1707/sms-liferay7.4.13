		var  studentCourseDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=21227";
		var 	 studentCourseDefId = 21227;
		//var  studentCourseBaseUrl = "http://portal.armantecsystems.com/api/jsonws/LMS-portlet.student-course";
		var  studentCourseBaseUrl = "/api/jsonws/lms.studentcourse";

		var StudentCourse = Backbone.Model.extend({
		label:'Student Course',
		icon:'$ModelIconUrl$',
		visible: {
  "studentId": { "type":"Select", "title":"First Name", "validators":"required", "options":"<Student>", "regexp":0, "fieldClass":"pullleft col49"},
  "courseId": { "type":"Select", "title":"Last name", "validators":"required", "options":"<Course>", "regexp":0, "fieldClass":"pullright col49"}
},
	    localStorage: new Backbone.LocalStorage('tbl-studentcourse'),
	    url: studentCourseBaseUrl + "/find",
	    create:function (){
	    	this.url=studentCourseBaseUrl + "/create";
	    	return Backbone.ajaxSync('create', this);
	    },
		createUrl:function (){
			return studentCourseBaseUrl + "/create";
	    },
	    update:function (){
	    		this.url=studentCourseBaseUrl + "/update";
	    		return Backbone.ajaxSync('create', this);
	    },
	    updateUrl:function (){
	    		return studentCourseBaseUrl + "/update";
	    },
	    remove:function (){
	    	this.url=studentCourseBaseUrl + "/delete";
	    	return Backbone.ajaxSync('create', this);
	    },
	    leftCourse:function (){
	    	this.url=studentCourseBaseUrl + "/remove-course";
	    	return Backbone.ajaxSync('create', this);
	    },
	    checkEnrollForStudent:function (){
	    	this.url=studentCourseBaseUrl + "/check-enroll-for-student";
	    	return Backbone.ajaxSync('create', this);
	    },
	    enrollStudentList:function (){
	    	this.url=studentCourseBaseUrl + "/enroll-student-list";
	    	return Backbone.ajaxSync('create', this);
	    },
	    removeStudentByAdmin:function (){
	    	this.url=studentCourseBaseUrl + "/remove-student-from-course";
	    	return Backbone.ajaxSync('create', this);
	    },
	    toString: function() {
        	return this.get('studentId');
    	}
	});
	
	var StudentCourseCollection = Backbone.Collection.extend({
		model: StudentCourse,
		
	    localStorage: new Backbone.LocalStorage('tbl-studentcourse'),
	    download: function(position,size){
	    	this.url =  studentCourseBaseUrl + "/find-all?position="+position+"&size="+size;
	    	return Backbone.ajaxSync('read', this);
	    }
	});
	
//testing...