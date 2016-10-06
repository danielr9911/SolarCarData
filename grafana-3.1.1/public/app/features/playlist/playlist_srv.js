/*! grafana - v3.1.1 - 2016-08-01
 * Copyright (c) 2016 Torkel Ödegaard; Licensed Apache-2.0 */

System.register(["app/core/config","../../core/core_module","app/core/utils/kbn"],function(a){var b,c,d,e;return{setters:[function(a){b=a},function(a){c=a},function(a){d=a}],execute:function(){e=function(){function a(a,b,c,d){this.$rootScope=a,this.$location=b,this.$timeout=c,this.backendSrv=d}return a.$inject=["$rootScope","$location","$timeout","backendSrv"],a.prototype.next=function(){var a=this;this.$timeout.cancel(this.cancelPromise);var c=this.index>this.dashboards.length-1;if(c)window.location.href=b["default"].appSubUrl+"/playlists/play/"+this.playlistId;else{var d=this.dashboards[this.index];this.$location.url("dashboard/"+d.uri),this.index++,this.cancelPromise=this.$timeout(function(){return a.next()},this.interval)}},a.prototype.prev=function(){this.index=Math.max(this.index-2,0),this.next()},a.prototype.start=function(a){var b=this;this.stop(),this.index=0,this.playlistId=a,this.$rootScope.playlistSrv=this,this.backendSrv.get("/api/playlists/"+a).then(function(c){b.backendSrv.get("/api/playlists/"+a+"/dashboards").then(function(a){b.dashboards=a,b.interval=d["default"].interval_to_ms(c.interval),b.next()})})},a.prototype.stop=function(){this.index=0,this.playlistId=0,this.cancelPromise&&this.$timeout.cancel(this.cancelPromise),this.$rootScope.playlistSrv=null},a}(),c["default"].service("playlistSrv",e)}}});