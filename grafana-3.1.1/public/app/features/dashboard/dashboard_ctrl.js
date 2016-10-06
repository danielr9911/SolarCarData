/*! grafana - v3.1.1 - 2016-08-01
 * Copyright (c) 2016 Torkel Ödegaard; Licensed Apache-2.0 */

System.register(["app/core/config","angular","app/core/core_module"],function(a){var b,c,d,e;return{setters:[function(a){b=a},function(a){c=a},function(a){d=a}],execute:function(){e=function(){function a(a,d,e,f,g,h,i,j,k,l,m){this.$scope=a,this.$rootScope=d,a.editor={index:0},a.panels=b["default"].panels;var n;a.setupDashboard=function(b){var c=h.create(b.dashboard,b.meta);h.setCurrent(c),f.init(c),g.init(c)["finally"](function(){j.init(c),i.init(c,a),a.dashboard=c,a.dashboardMeta=c.meta,a.dashboardViewState=k.create(a),e.shortcuts(a),a.updateSubmenuVisibility(),a.setWindowTitleAndTheme(),a.appEvent("dashboard-initialized",a.dashboard)})["catch"](function(b){b.data&&b.data.message&&(b.message=b.data.message),a.appEvent("alert-error",["Dashboard init failed","Template variables could not be initialized: "+b.message])})},a.templateVariableUpdated=function(){j.update(a.dashboard)},a.updateSubmenuVisibility=function(){a.submenuEnabled=a.dashboard.isSubmenuFeaturesEnabled()},a.setWindowTitleAndTheme=function(){window.document.title=b["default"].window_title_prefix+a.dashboard.title},a.broadcastRefresh=function(){d.$broadcast("refresh")},a.addRow=function(a,b){a.rows.push(b)},a.addRowDefault=function(){a.resetRow(),a.row.title="New row",a.addRow(a.dashboard,a.row)},a.resetRow=function(){a.row={title:"",height:"250px",editable:!0}},a.showJsonEditor=function(b,c){var e=d.$new();e.object=c.object,e.updateHandler=c.updateHandler,a.appEvent("show-dash-editor",{src:"public/app/partials/edit_json.html",scope:e})},a.onDrop=function(b,c,e){var f=a.dashboard.getPanelInfoById(b);if(e){var g=a.dashboard.getPanelInfoById(e.id);g.row.panels[g.index]=f.panel,f.row.panels[f.index]=e;var h=f.panel.span;f.panel.span=e.span,e.span=h}else f.row.panels.splice(f.index,1),f.panel.span=12-a.dashboard.rowSpan(c),c.panels.push(f.panel);d.$broadcast("render")},a.registerWindowResizeEvent=function(){c["default"].element(window).bind("resize",function(){m.cancel(n),n=m(function(){a.$broadcast("render")},200)}),a.$on("$destroy",function(){c["default"].element(window).unbind("resize")})},a.timezoneChanged=function(){d.$broadcast("refresh")}}return a.$inject=["$scope","$rootScope","dashboardKeybindings","timeSrv","templateValuesSrv","dashboardSrv","unsavedChangesSrv","dynamicDashboardSrv","dashboardViewStateSrv","contextSrv","$timeout"],a.prototype.init=function(a){this.$scope.resetRow(),this.$scope.registerWindowResizeEvent(),this.$scope.onAppEvent("show-json-editor",this.$scope.showJsonEditor),this.$scope.onAppEvent("template-variable-value-updated",this.$scope.templateVariableUpdated),this.$scope.setupDashboard(a)},a}(),a("DashboardCtrl",e),d["default"].controller("DashboardCtrl",e)}}});