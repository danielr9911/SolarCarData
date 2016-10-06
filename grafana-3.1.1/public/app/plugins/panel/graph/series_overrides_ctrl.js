/*! grafana - v3.1.1 - 2016-08-01
 * Copyright (c) 2016 Torkel Ödegaard; Licensed Apache-2.0 */

define(["angular","jquery","lodash"],function(a,b,c){"use strict";var d=a.module("grafana.controllers");d.controller("SeriesOverridesCtrl",["$scope","$element","popoverSrv",function(a,b,d){a.overrideMenu=[],a.currentOverrides=[],a.override=a.override||{},a.addOverrideOption=function(b,d,e){var f={};f.text=b,f.propertyName=d,f.index=a.overrideMenu.length,f.values=e,f.submenu=c.map(e,function(a){return{text:String(a),value:a}}),a.overrideMenu.push(f)},a.setOverride=function(b,c){return"color"===b.propertyName?void a.openColorSelector():(a.override[b.propertyName]=c.value,"fillBelowTo"===b.propertyName&&(a.override.lines=!1,a.addSeriesOverride({alias:c.value,lines:!1})),a.updateCurrentOverrides(),void a.ctrl.render())},a.colorSelected=function(b){a.override.color=b,a.updateCurrentOverrides(),a.ctrl.render()},a.openColorSelector=function(){d.show({element:b.find(".dropdown")[0],position:"top center",openOn:"click",template:"<gf-color-picker></gf-color-picker>",model:{autoClose:!0,colorSelected:a.colorSelected},onClose:function(){a.ctrl.render()}})},a.removeOverride=function(b){delete a.override[b.propertyName],a.updateCurrentOverrides(),a.ctrl.refresh()},a.getSeriesNames=function(){return c.map(a.ctrl.seriesList,function(a){return a.alias})},a.updateCurrentOverrides=function(){a.currentOverrides=[],c.each(a.overrideMenu,function(b){var d=a.override[b.propertyName];c.isUndefined(d)||a.currentOverrides.push({name:b.text,propertyName:b.propertyName,value:String(d)})})},a.addOverrideOption("Bars","bars",[!0,!1]),a.addOverrideOption("Lines","lines",[!0,!1]),a.addOverrideOption("Line fill","fill",[0,1,2,3,4,5,6,7,8,9,10]),a.addOverrideOption("Line width","linewidth",[0,1,2,3,4,5,6,7,8,9,10]),a.addOverrideOption("Null point mode","nullPointMode",["connected","null","null as zero"]),a.addOverrideOption("Fill below to","fillBelowTo",a.getSeriesNames()),a.addOverrideOption("Staircase line","steppedLine",[!0,!1]),a.addOverrideOption("Points","points",[!0,!1]),a.addOverrideOption("Points Radius","pointradius",[1,2,3,4,5]),a.addOverrideOption("Stack","stack",[!0,!1,"A","B","C","D"]),a.addOverrideOption("Color","color",["change"]),a.addOverrideOption("Y-axis","yaxis",[1,2]),a.addOverrideOption("Z-index","zindex",[-1,-2,-3,0,1,2,3]),a.addOverrideOption("Transform","transform",["negative-Y"]),a.addOverrideOption("Legend","legend",[!0,!1]),a.updateCurrentOverrides()}])});