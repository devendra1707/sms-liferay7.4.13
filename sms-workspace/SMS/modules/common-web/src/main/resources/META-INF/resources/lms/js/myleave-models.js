		var  myLeaveDefUrl = "/api/jsonws/mobile-app-builder-portlet.module/find?id=119";
		var 	 myLeaveDefId = 119;
		var  myLeaveBaseUrl = "/api/jsonws";

		var MyLeave = Backbone.Model.extend({
		label:'MyLeave',
		icon:'$ModelIconUrl$',
		visible: {
"title":{"title":"My Leave", "type":"Text"}
},
	    localStorage: new Backbone.LocalStorage('tbl-myleave'),
	    url: myLeaveBaseUrl + "/mobile-app-builder-portlet.myleave/default",
	    create:function (){
	    	this.url=myLeaveBaseUrl + "/mobile-app-builder-portlet.myleave/create";
	    	return Backbone.ajaxSync('create', this);
	    },
	    update:function (){
	    	this.url=myLeaveBaseUrl + "/mobile-app-builder-portlet.myleave/update";
	    	return Backbone.ajaxSync('create', this);
	    },
	    remove:function (){
	    	this.url=myLeaveBaseUrl + "/mobile-app-builder-portlet.myleave/delete";
	    	return Backbone.ajaxSync('create', this);
	    },
	    toString: function() {
        	return this.get('title');
    	}
	});
	
	var MyLeaveCollection = Backbone.Collection.extend({
		model: MyLeave,
		url: myLeaveBaseUrl + "/mobile-app-builder-portlet.myleave/find-all",
	    localStorage: new Backbone.LocalStorage('tbl-myleave'),
	    download: function(filter){
	    	return Backbone.ajaxSync('read', this);
	    }
	});
	
	var MyLeaveCreateForm = Backbone.Form.extend({
		schema: {
"title":{"title":"My Leave", "type":"Text"}
}
	});
	
	var MyLeaveEditForm = Backbone.Form.extend({
		schema: {
"title":{"title":"My Leave", "type":"Text"}
}
	});
