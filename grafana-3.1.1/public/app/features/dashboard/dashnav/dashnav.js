/*! grafana - v3.1.1 - 2016-08-01
 * Copyright (c) 2016 Torkel Ödegaard; Licensed Apache-2.0 */

System.register(["lodash","moment","angular"],function(a){function b(){return{restrict:"E",templateUrl:"public/app/features/dashboard/dashnav/dashnav.html",controller:f,transclude:!0}}var c,d,e,f;return a("dashNavDirective",b),{setters:[function(a){c=a},function(a){d=a},function(a){e=a}],execute:function(){f=function(){function a(a,b,f,g,h,i,j,k){a.init=function(){if(a.onAppEvent("save-dashboard",a.saveDashboard),a.onAppEvent("delete-dashboard",a.deleteDashboard),a.onAppEvent("quick-snapshot",a.quickSnapshot),a.showSettingsMenu=a.dashboardMeta.canEdit||a.contextSrv.isEditor,a.dashboardMeta.isSnapshot){a.showSettingsMenu=!1;var b=a.dashboardMeta;a.titleTooltip="Created: &nbsp;"+d["default"](b.created).calendar(),b.expires&&(a.titleTooltip+="<br>Expires: &nbsp;"+d["default"](b.expires).fromNow()+"<br>")}},a.openEditView=function(a){var b=c["default"].extend(g.search(),{editview:a});g.search(b)},a.starDashboard=function(){a.dashboardMeta.isStarred?i["delete"]("/api/user/stars/dashboard/"+a.dashboard.id).then(function(){a.dashboardMeta.isStarred=!1}):i.post("/api/user/stars/dashboard/"+a.dashboard.id).then(function(){a.dashboardMeta.isStarred=!0})},a.shareDashboard=function(b){var c=a.$new();c.tabIndex=b,a.appEvent("show-modal",{src:"public/app/features/dashboard/partials/shareModal.html",scope:c})},a.quickSnapshot=function(){a.shareDashboard(1)},a.openSearch=function(){a.appEvent("show-dash-search")},a.hideTooltip=function(b){e["default"].element(b.currentTarget).tooltip("hide"),a.appEvent("hide-dash-search")},a.makeEditable=function(){a.dashboard.editable=!0;var b=a.dashboard.getSaveModelClone();i.saveDashboard(b,{overwrite:!1}).then(function(c){a.dashboard.version=c.version,a.appEvent("dashboard-saved",a.dashboard),a.appEvent("alert-success",["Dashboard saved","Saved as "+b.title]),window.location.href=window.location.href},a.handleSaveDashError)},a.saveDashboard=function(b){if(a.dashboardMeta.canSave!==!1){var c=a.dashboard.getSaveModelClone();i.saveDashboard(c,b).then(function(b){a.dashboard.version=b.version,a.appEvent("dashboard-saved",a.dashboard);var d="/dashboard/db/"+b.slug;d!==g.path()&&g.url(d),a.appEvent("alert-success",["Dashboard saved","Saved as "+c.title])},a.handleSaveDashError)}},a.handleSaveDashError=function(b){b.data&&"version-mismatch"===b.data.status&&(b.isHandled=!0,a.appEvent("confirm-modal",{title:"Conflict",text:"Someone else has updated this dashboard.",text2:"Would you still like to save this dashboard?",yesText:"Save & Overwrite",icon:"fa-warning",onConfirm:function(){a.saveDashboard({overwrite:!0})}})),b.data&&"name-exists"===b.data.status&&(b.isHandled=!0,a.appEvent("confirm-modal",{title:"Conflict",text:"Dashboard with the same name exists.",text2:"Would you still like to save this dashboard?",yesText:"Save & Overwrite",icon:"fa-warning",onConfirm:function(){a.saveDashboard({overwrite:!0})}})),b.data&&"plugin-dashboard"===b.data.status&&(b.isHandled=!0,a.appEvent("confirm-modal",{title:"Plugin Dashboard",text:b.data.message,text2:"Your changes will be lost when you update the plugin. Use Save As to create custom version.",yesText:"Overwrite",icon:"fa-warning",altActionText:"Save As",onAltAction:function(){a.saveDashboardAs()},onConfirm:function(){a.saveDashboard({overwrite:!0})}}))},a.deleteDashboard=function(){a.appEvent("confirm-modal",{title:"Delete",text:"Do you want to delete this dashboard?",text2:a.dashboard.title,icon:"fa-trash",yesText:"Delete",onConfirm:function(){a.deleteDashboardConfirmed()}})},a.deleteDashboardConfirmed=function(){i["delete"]("/api/dashboards/db/"+a.dashboardMeta.slug).then(function(){a.appEvent("alert-success",["Dashboard Deleted",a.dashboard.title+" has been deleted"]),g.url("/")})},a.saveDashboardAs=function(){var c=b.$new();c.clone=a.dashboard.getSaveModelClone(),c.clone.editable=!0,c.clone.hideControls=!1,a.appEvent("show-modal",{src:"public/app/features/dashboard/partials/saveDashboardAs.html",scope:c,modalClass:"modal--narrow"})},a.viewJson=function(){var b=a.dashboard.getSaveModelClone(),c=e["default"].toJson(b,!0),d="data:application/json,"+encodeURIComponent(c);window.open(d)},a.snapshot=function(){a.dashboard.snapshot=!0,b.$broadcast("refresh"),j(function(){a.dashboard.snapshot=!1,a.appEvent("dashboard-snapshot-cleanup")},1e3)},a.editJson=function(){var b=a.dashboard.getSaveModelClone();a.appEvent("show-json-editor",{object:b})},a.stopPlaylist=function(){h.stop(1)},a.init()}return a.$inject=["$scope","$rootScope","alertSrv","$location","playlistSrv","backendSrv","$timeout","datasourceSrv"],a}(),a("DashNavCtrl",f),e["default"].module("grafana.directives").directive("dashnav",b)}}});