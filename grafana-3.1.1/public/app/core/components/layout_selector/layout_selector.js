/*! grafana - v3.1.1 - 2016-08-01
 * Copyright (c) 2016 Torkel Ödegaard; Licensed Apache-2.0 */

System.register(["app/core/store","app/core/core_module"],function(a){function b(){return{restrict:"E",controller:g,bindToController:!0,controllerAs:"ctrl",scope:{},template:f}}function c(a){return{restrict:"A",scope:{},link:function(b,c){var e=d["default"].get("grafana.list.layout.mode")||"grid",f="card-list-layout-"+e;c.addClass(f),a.onAppEvent("layout-mode-changed",function(a,b){c.removeClass(f),f="card-list-layout-"+b,c.addClass(f)},b)}}}c.$inject=["$rootScope"];var d,e,f,g;return a("layoutSelector",b),a("layoutMode",c),{setters:[function(a){d=a},function(a){e=a}],execute:function(){f='\n<div class="layout-selector">\n  <button ng-click="ctrl.listView()" ng-class="{active: ctrl.mode === \'list\'}">\n    <i class="fa fa-list"></i>\n  </button>\n  <button ng-click="ctrl.gridView()" ng-class="{active: ctrl.mode === \'grid\'}">\n    <i class="fa fa-th"></i>\n  </button>\n</div>\n',g=function(){function a(a){this.$rootScope=a,this.mode=d["default"].get("grafana.list.layout.mode")||"grid"}return a.$inject=["$rootScope"],a.prototype.listView=function(){this.mode="list",d["default"].set("grafana.list.layout.mode","list"),this.$rootScope.appEvent("layout-mode-changed","list")},a.prototype.gridView=function(){this.mode="grid",d["default"].set("grafana.list.layout.mode","grid"),this.$rootScope.appEvent("layout-mode-changed","grid")},a}(),a("LayoutSelectorCtrl",g),e["default"].directive("layoutSelector",b),e["default"].directive("layoutMode",c)}}});