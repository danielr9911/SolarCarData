/*! grafana - v3.1.1 - 2016-08-01
 * Copyright (c) 2016 Torkel Ödegaard; Licensed Apache-2.0 */

System.register(["lodash","app/plugins/sdk","app/features/dashboard/impression_store"],function(a){var b,c,d,e,f=this&&this.__extends||function(a,b){function c(){this.constructor=a}for(var d in b)b.hasOwnProperty(d)&&(a[d]=b[d]);a.prototype=null===b?Object.create(b):(c.prototype=b.prototype,new c)};return{setters:[function(a){b=a},function(a){c=a},function(a){d=a}],execute:function(){e=function(a){function c(c,d,e){a.call(this,c,d),this.backendSrv=e,this.panelDefaults={query:"",limit:10,tags:[],recent:!1,search:!1,starred:!0,headings:!0},b["default"].defaults(this.panel,this.panelDefaults),this.panel.tag&&(this.panel.tags=[this.panel.tag],delete this.panel.tag),this.events.on("refresh",this.onRefresh.bind(this)),this.events.on("init-edit-mode",this.onInitEditMode.bind(this)),this.groups=[{list:[],show:!1,header:"Starred dashboards"},{list:[],show:!1,header:"Recently viewed dashboards"},{list:[],show:!1,header:"Search"}],this.panel.mode&&("starred"===this.panel.mode&&(this.panel.starred=!0,this.panel.headings=!1),"recently viewed"===this.panel.mode&&(this.panel.recent=!0,this.panel.starred=!1,this.panel.headings=!1),"search"===this.panel.mode&&(this.panel.search=!0,this.panel.starred=!1,this.panel.headings=!1),delete this.panel.mode)}return f(c,a),c.$inject=["$scope","$injector","backendSrv"],c.prototype.onInitEditMode=function(){this.editorTabIndex=1,this.modes=["starred","search","recently viewed"],this.addEditorTab("Options","public/app/plugins/panel/dashlist/editor.html")},c.prototype.onRefresh=function(){var a=[];return a.push(this.getRecentDashboards()),a.push(this.getStarred()),a.push(this.getSearch()),Promise.all(a).then(this.renderingCompleted.bind(this))},c.prototype.getSearch=function(){var a=this;if(this.groups[2].show=this.panel.search,!this.panel.search)return Promise.resolve();var b={limit:this.panel.limit,query:this.panel.query,tag:this.panel.tags};return this.backendSrv.search(b).then(function(b){a.groups[2].list=b})},c.prototype.getStarred=function(){var a=this;if(this.groups[0].show=this.panel.starred,!this.panel.starred)return Promise.resolve();var b={limit:this.panel.limit,starred:"true"};return this.backendSrv.search(b).then(function(b){a.groups[0].list=b})},c.prototype.getRecentDashboards=function(){var a=this;if(this.groups[1].show=this.panel.recent,!this.panel.recent)return Promise.resolve();var c=b["default"].first(d.impressions.getDashboardOpened(),this.panel.limit);return this.backendSrv.search({dashboardIds:c,limit:this.panel.limit}).then(function(d){a.groups[1].list=c.map(function(a){return b["default"].find(d,function(b){return b.id===a})}).filter(function(a){return void 0!==a})})},c.templateUrl="module.html",c}(c.PanelCtrl),a("DashListCtrl",e),a("PanelCtrl",e)}}});