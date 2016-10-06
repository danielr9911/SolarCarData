/*! grafana - v3.1.1 - 2016-08-01
 * Copyright (c) 2016 Torkel Ödegaard; Licensed Apache-2.0 */

define(["angular","lodash"],function(a,b){"use strict";var c=a.module("grafana.controllers");c.controller("TemplateEditorCtrl",["$scope","datasourceSrv","templateSrv","templateValuesSrv",function(c,d,e,f){var g={type:"query",datasource:null,refresh:0,name:"",hide:0,options:[],includeAll:!1,multi:!1};c.variableTypes=[{value:"query",text:"Query"},{value:"interval",text:"Interval"},{value:"datasource",text:"Data source"},{value:"custom",text:"Custom"},{value:"constant",text:"Constant"}],c.refreshOptions=[{value:0,text:"Never"},{value:1,text:"On Dashboard Load"},{value:2,text:"On Time Range Change"}],c.hideOptions=[{value:0,text:""},{value:1,text:"Label"},{value:2,text:"Variable"}],c.init=function(){c.mode="list",c.datasourceTypes={},c.datasources=b.filter(d.getMetricSources(),function(a){return c.datasourceTypes[a.meta.id]={text:a.meta.name,value:a.meta.id},!a.meta.builtIn}),c.datasourceTypes=b.map(c.datasourceTypes,function(a){return a}),c.variables=e.variables,c.reset(),c.$watch("mode",function(a){"new"===a&&c.reset()}),c.$watch("current.datasource",function(a){"new"===c.mode&&d.get(a).then(function(a){a.meta.defaultMatchFormat&&(c.current.allFormat=a.meta.defaultMatchFormat,c.current.multiFormat=a.meta.defaultMatchFormat)})})},c.add=function(){c.isValid()&&(c.variables.push(c.current),c.update(),c.updateSubmenuVisibility())},c.isValid=function(){if(!c.current.name)return c.appEvent("alert-warning",["Validation","Template variable requires a name"]),!1;if(!c.current.name.match(/^\w+$/))return c.appEvent("alert-warning",["Validation","Only word and digit characters are allowed in variable names"]),!1;var a=b.findWhere(c.variables,{name:c.current.name});return!a||a===c.current||(c.appEvent("alert-warning",["Validation","Variable with the same name already exists"]),!1)},c.runQuery=function(){return f.updateOptions(c.current).then(null,function(a){a.data&&a.data.message&&(a.message=a.data.message),c.appEvent("alert-error",["Templating","Template variables could not be initialized: "+a.message])})},c.edit=function(a){c.current=a,c.currentIsNew=!1,c.mode="edit",void 0===c.current.datasource&&(c.current.datasource=null,c.current.type="query",c.current.allFormat="glob")},c.duplicate=function(b){c.current=a.copy(b),c.variables.push(c.current),c.current.name="copy_of_"+b.name,c.updateSubmenuVisibility()},c.update=function(){c.isValid()&&c.runQuery().then(function(){c.reset(),c.mode="list"})},c.reset=function(){c.currentIsNew=!0,c.current=a.copy(g)},c.showSelectionOptions=function(){if(c.current){if("query"===c.current.type)return!0;if("custom"===c.current.type)return!0}return!1},c.typeChanged=function(){"interval"===c.current.type&&(c.current.query="1m,10m,30m,1h,6h,12h,1d,7d,14d,30d",c.current.refresh=0),"query"===c.current.type&&(c.current.query=""),"constant"===c.current.type&&(c.current.query="",c.current.refresh=0,c.current.hide=2),"datasource"===c.current.type&&(c.current.query=c.datasourceTypes[0].value,c.current.regex="",c.current.refresh=1)},c.removeVariable=function(a){var d=b.indexOf(c.variables,a);c.variables.splice(d,1),c.updateSubmenuVisibility()}}])});