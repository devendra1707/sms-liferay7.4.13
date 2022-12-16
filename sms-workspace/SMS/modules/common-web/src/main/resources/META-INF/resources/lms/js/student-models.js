		var  studentDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=167";
		var 	 studentDefId = 167;
		var  studentBaseUrl = "/api/jsonws/lms.student";

		var Student = Backbone.Model.extend({
		label:'Student',
		icon:'$ModelIconUrl$',
		visible: {
			"id":{"title":"ID","type":"Hidden"},
			"profileImage":{"title":"Profile Image","type":"ImagePicker"},
			"firstName":{"title":"First Name","type":"Text","validators":["text", "required"]},
		    "lastName":{"title":"Last Name","type":"Text","validators":["text", "required"]},
			"email":{"title":"Email","requered":"true","validators":["email", "required"]},
			"dob":{"title":"Date of Birth","type":"DatePickerBootstrap","validators":["date","required"]},
			"gender":{"title":"Gender","type":"Select","options":["Male","Female"],"validators":["text","required"]},
			"contactNumber":{"title":"Contact Number","type":"Text","validators":["phone", "required"]},
			"address":{"title":"Address","type":"TextArea","validators":["required"]},
			"referrer":{"title":"Referred By","type":"Hidden"}
			},
	    localStorage: new Backbone.LocalStorage('tbl-student'),
	    url: studentBaseUrl + "/find",
	    create:function (){
	    	this.url=studentBaseUrl + "/create";
	    	return Backbone.ajaxSync('create', this);
	    },
	    createWithoutPicture:function (){
	    	this.url=studentBaseUrl + "/create-without-picture";
	    	return Backbone.ajaxSync('create', this);
	    },
	    updatePassword:function(){
	    	this.url= studentBaseUrl+"/update-password";
	    	return Backbone.ajaxSync('create', this);
	    },
		createUrl:function (){
			return studentBaseUrl + "/create";
	    },
	    update:function (){
	    		this.url=studentBaseUrl + "/update";
	    		return Backbone.ajaxSync('create', this);
	    },
	    updateWithoutPicture:function (){
	    	this.url=studentBaseUrl + "/update-without-picture";
	    	return Backbone.ajaxSync('create', this);
	    },
	    updateUrl:function (){
	    		return studentBaseUrl + "/update";
	    },
	    remove:function (){
	    	this.url=studentBaseUrl + "/delete";
	    	return Backbone.ajaxSync('create', this);
	    },
	    toString: function() {
        	return this.get('firstName');
    	}
	});
	
	var StudentCollection = Backbone.Collection.extend({
		model: Student,
		url: studentBaseUrl + "/find-all",
	    localStorage: new Backbone.LocalStorage('tbl-student'),
	    download: function(filter){
	    	return Backbone.ajaxSync('read', this);
	    },
		studentListForEnroll : function(courseId) {
			this.url = studentBaseUrl + "/get-all-student-list-for-course-enroll?courseId="+courseId;
			return Backbone.ajaxSync('read', this);
		},
		findForRecommendCourse : function(courseIds) {
			this.url = studentBaseUrl + "/find-student-for-recommend-course?courseIds="+courseIds;
			return Backbone.ajaxSync('read', this);
		},
		findForGroup : function(groupId) {
			this.url = studentBaseUrl + "/get-student-list-for-group?studentGroupId="+groupId;
			return Backbone.ajaxSync('read', this);
		},
		findStudentNotInGroup : function(groupId) {
			this.url = studentBaseUrl + "/get-student-list-not-in-group?studentGroupId="+groupId;
			return Backbone.ajaxSync('read', this);
		}
	});

	var StudentCreateForm = Backbone.Form.extend({
		schema: {
			"profileImage":{"title":"Profile Image","type":"ImagePicker", "help":"Allowed types are .png, .jpg, .gif, .svg. Max Size - 1MB"},
			"firstName":{"title":"First Name","type":"Text","validators":["text", "required"]},
			"lastName":{"title":"Last Name","type":"Text","validators":["text", "required"]},
			"email":{"title":"Email","required":true,"pattern":"email","validators":["email", "required"]},
			"dob":{"title":"Date of Birth","type":"DatePickerBootstrap","validators":["date","required"]},
			"gender":{"title":"Gender","type":"Select","options":["Male","Female"],"validators":["text","required"]},
			"contactNumber":{"title":"Contact Number","type":"Text","validators":["phone", "required"]},
	            
			"address":{"title":"Address","type":"TextArea","validators":["required","addressRegex"]},
			"referrer":{"title":"Referred By","type":"Hidden"}
		}
	});
	////change
	var StudentEditForm = Backbone.Form.extend({
		schema: {
			"id":{"title":"ID","type":"Hidden"},
			"profileImage":{"title":"Profile Image","type":"ImagePicker", "help":"Allowed types are .png, .jpg, .gif, .svg. Max Size - 1MB"},
			"firstName":{"title":"First Name","type":"Text","validators":["text", "required"]},
			"lastName":{"title":"Last Name","type":"Text","validators":["text", "required"]},
			"email":{"title":"Email","pattern":"email","validators":["email", "required"]},
			"dob":{"title":"Date of Birth","type":"DatePickerBootstrap", "format":"dd/mm/yyyy" ,"validators":["date","required"]},
			
			
			
			"gender":{"title":"Gender","type":"Select","options":["Male","Female"],"validators":["text","required"]},
			"contactNumber":{"title":"Contact Number","type":"Text","validators":["phone", "required"]},
	            
			"address":{"title":"Address","type":"TextArea","validators":["required","addressRegex"]},
			"referrer":{"title":"Referred By","type":"Hidden"}
		}
	});
	
	/*var StudentPasswordEditForm = Backbone.Form.extend({
		schema: {
			"id":{"title":"ID","type":"Hidden"},
			"userId":{"title":"New Password","type":"Hidden"},
			"password1":{"title":"New Password","type":"Password","validators":["required"]},
			"password2":{"title":"Confirm Password","type":"Password","validators":["required"]},
			"passwordReset":{"title":"Reset Password","type":"Hidden"}
			}
	});*/
	var StudentPasswordEditForm = Backbone.Form.extend({
		schema: {
			"id":{"title":"ID","type":"Hidden"},
			"oldPassword":{"title":"Current Password","type":"Password","validators":["required"]},
			"newPassword":{"title":"New Password","type":"Password","validators":["required"]},
			"confirmPassword":{"title":"Confirm Password","type":"Password","validators":["required"]}
			}
	});
	
	