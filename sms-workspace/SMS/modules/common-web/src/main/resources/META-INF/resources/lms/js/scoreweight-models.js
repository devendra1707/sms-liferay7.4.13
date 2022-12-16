var scoreWeightBaseUrl = "/api/jsonws/lms.scoreweight";

/*changed "type" : "Text" into "type" : "Hidden" with field name labScore,securityChallengeScore and dynamicExerciseScore */
var ScoreWeight = Backbone.Model.extend({
	label : 'Score Weight',
	icon : '$ModelIconUrl$',
	visible : {
		"courseId" : {
			"title" : "Select Course",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new CourseCollection(),
			"editorClass" : "form-control"
		},
		"labScore" : {
			"title" : "Lab",
			"type" : "Hidden"
		},
		"securityChallengeScore" : {
			"title" : "Security Challenge",
			"type" : "Hidden"
		},
		"dynamicExerciseScore" : {
			"title" : "Dynamic Exercise",
			"type" : "Hidden"
		},
		"quizScore" : {
			"title" : "Quiz_",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md"
		},
		"postTestScore" : {
			"title" : "Post Test",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md"
		},
		"total" : {
			"title" : "Total Weight",
			"type" : "Text",
			"editorClass" : "form-control input-md"
		}
	},
	localStorage : new Backbone.LocalStorage('tbl-scoreweight'),
	url : scoreWeightBaseUrl + "/find",
	create : function() {
		this.url = scoreWeightBaseUrl + "/create";
		return Backbone.ajaxSync('create', this);
	},
	update : function() {
		this.url = scoreWeightBaseUrl + "/update";
		return Backbone.ajaxSync('create', this);
	},
	remove : function() {
		this.url = scoreWeightBaseUrl + "/delete";
		return Backbone.ajaxSync('create', this);
	},
	toString : function() {
		return this.get('name');
	}
});

var ScoreWeightCollection = Backbone.Collection.extend({
	model : ScoreWeight,
	url : scoreWeightBaseUrl + "/find-all",
	localStorage : new Backbone.LocalStorage('tbl-studentgroup'),
	download : function(filter) {
		return Backbone.ajaxSync('read', this);
	}
});


var ScoreWeightCreateForm = Backbone.Form.extend({
	schema : {
		"courseId" : {
			"title" : "Select Course",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new CourseCollection(),
			"editorClass" : "form-control"
		},
		"labScore" : {
			"title" : "Lab",
			"type" : "Hidden"
		},
		"securityChallengeScore" : {
			"title" : "Security Challenge",
			"type" : "Hidden"
		},
		"dynamicExerciseScore" : {
			"title" : "Dynamic Exercise",
			"type" : "Hidden"
		},
		"quizScore" : {
			"title" : "Quiz_",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md"
		},
		"postTestScore" : {
			"title" : "Post Test",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md"
		},
		"total" : {
			"title" : "Total Weight",
			"type" : "Text",
			"editorClass" : "form-control input-md"
		}
	}
});

var ScoreWeightEditForm = Backbone.Form.extend({
	schema : {
		"courseId" : {
			"title" : "Select Course",
			"type" : "Select",
			"validators" : [ "required" ],
			"options" : new CourseCollection(),
			"editorClass" : "form-control"
		},
		"labScore" : {
			"title" : "Lab",
			"type" : "Hidden"
		},
		"securityChallengeScore" : {
			"title" : "Security Challenge",
			"type" : "Hidden"
		},
		"dynamicExerciseScore" : {
			"title" : "Dynamic Exercise",
			"type" : "Hidden"
		},
		"quizScore" : {
			"title" : "Quiz_",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md"
		},
		"postTestScore" : {
			"title" : "Post Test",
			"type" : "Text",
			"validators" : [ "required", "number" ],
			"editorClass" : "form-control input-md"
		},
		"total" : {
			"title" : "Total Weight",
			"type" : "Text",
			"editorClass" : "form-control input-md"
		}
	}
});

