		var  studentLabTerminalDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=187";
		var 	 studentLabTerminalDefId = 187;
		//var  studentLabTerminalBaseUrl = "http://portal.armantecsystems.com/api/jsonws/LMS-portlet.studentlabterminal";
		var  studentLabTerminalBaseUrl = "/api/jsonws/lms.studentlabterminal";

		var StudentLabTerminal = Backbone.Model.extend({
		label:'Student Lab Terminal',
		icon:'$ModelIconUrl$',
		visible: {
  "studentLabId": { "type":"Select", "title":"Lab Attempt", "validators":"required", "options":"<StudentLab>", "regexp":0, "fieldclass":0},
  "terminalId": { "type":"Select", "title":"Student", "validators":"required", "options":"<Student>", "regexp":0, "fieldclass":0},
  "terminalType": { "type":"Text", "title":"Terminal Type", "validators":"required", "options":"", "regexp":0, "fieldclass":0},
  "timeSpent": { "type":"Text", "title":"Time Spent", "validators":"required", "options":"", "regexp":0, "fieldclass":0},
  "status": { "type":"Select", "title":"Status", "validators":"required", "options":"", "regexp":0, "fieldclass":0},
  "score": { "type":"Text", "title":"Score", "validators":"required", "options":"", "regexp":0, "fieldclass":0}
},
	    localStorage: new Backbone.LocalStorage('tbl-studentlabterminal'),
	    url: studentLabTerminalBaseUrl + "/find",
	    create:function (){
	    	this.url=studentLabTerminalBaseUrl + "/create";
	    	return Backbone.ajaxSync('create', this);
	    },
		createUrl:function (){
			return studentLabTerminalBaseUrl + "/create";
	    },
	    update:function (){
	    		this.url=studentLabTerminalBaseUrl + "/update";
	    		return Backbone.ajaxSync('create', this);
	    },
	    updateUrl:function (){
	    		return studentLabTerminalBaseUrl + "/update";
	    },
	    remove:function (){
	    	this.url=studentLabTerminalBaseUrl + "/delete";
	    	return Backbone.ajaxSync('create', this);
	    },
	    toString: function() {
        	return this.get('terminalType');
    	}
	});
	
	var StudentLabTerminalCollection = Backbone.Collection.extend({
		model: StudentLabTerminal,
		url: studentLabTerminalBaseUrl + "/find-all",
	    localStorage: new Backbone.LocalStorage('tbl-studentlabterminal'),
	    download: function(filter){
	    	return Backbone.ajaxSync('read', this);
	    }
	});
	
	var StudentLabTerminalCreateForm = Backbone.Form.extend({
		schema: {"studentLabId":{"type":"Select","title":"Lab Attempt","validators":["required"],"options":new StudentLabCollection(),"fieldclass":0},"terminalId":{"type":"Select","title":"Student","validators":["required"],"options":new StudentCollection(),"fieldclass":0},"terminalType":{"type":"Text","title":"Terminal Type","validators":["required"],"fieldclass":0},"timeSpent":{"type":"Text","title":"Time Spent","validators":["required"],"fieldclass":0},"status":{"type":"Select","title":"Status","validators":["required"],"fieldclass":0},"score":{"type":"Text","title":"Score","validators":["required"],"fieldclass":0}}
	});
	
	var StudentLabTerminalEditForm = Backbone.Form.extend({
		schema: {
  "studentLabId": { "type":"Select", "title":"Lab Attempt", "validators":"required", "options":new StudentLabCollection(), "regexp":0, "fieldclass":0},
  "terminalId": { "type":"Select", "title":"Student", "validators":"required", "options":new StudentCollection(), "regexp":0, "fieldclass":0},
  "terminalType": { "type":"Text", "title":"Terminal Type", "validators":"required", "options":"", "regexp":0, "fieldclass":0},
  "timeSpent": { "type":"Text", "title":"Time Spent", "validators":"required", "options":"", "regexp":0, "fieldclass":0},
  "status": { "type":"Select", "title":"Status", "validators":"required", "options":"", "regexp":0, "fieldclass":0},
  "score": { "type":"Text", "title":"Score", "validators":"required", "options":"", "regexp":0, "fieldclass":0}
}
	});
