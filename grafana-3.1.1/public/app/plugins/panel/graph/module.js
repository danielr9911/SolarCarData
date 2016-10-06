/*! grafana - v3.1.1 - 2016-08-01
 * Copyright (c) 2016 Torkel Ödegaard; Licensed Apache-2.0 */

System.register(["./graph","./legend","./series_overrides_ctrl","./template","moment","app/core/utils/kbn","lodash","app/core/time_series2","app/core/utils/file_export","app/plugins/sdk"],function(a){var b,c,d,e,f,g,h,i,j=this&&this.__extends||function(a,b){function c(){this.constructor=a}for(var d in b)b.hasOwnProperty(d)&&(a[d]=b[d]);a.prototype=null===b?Object.create(b):(c.prototype=b.prototype,new c)};return{setters:[function(a){},function(a){},function(a){},function(a){b=a},function(a){c=a},function(a){d=a},function(a){e=a},function(a){f=a},function(a){g=a},function(a){h=a}],execute:function(){i=function(a){function h(b,c,d){a.call(this,b,c),this.annotationsSrv=d,this.hiddenSeries={},this.seriesList=[],this.colors=[],this.panelDefaults={datasource:null,renderer:"flot",yaxes:[{label:null,show:!0,logBase:1,min:null,max:null,format:"short"},{label:null,show:!0,logBase:1,min:null,max:null,format:"short"}],xaxis:{show:!0},grid:{threshold1:null,threshold2:null,threshold1Color:"rgba(216, 200, 27, 0.27)",threshold2Color:"rgba(234, 112, 112, 0.22)"},lines:!0,fill:1,linewidth:2,points:!1,pointradius:5,bars:!1,stack:!1,percentage:!1,legend:{show:!0,values:!1,min:!1,max:!1,current:!1,total:!1,avg:!1},nullPointMode:"connected",steppedLine:!1,tooltip:{value_type:"cumulative",shared:!0,sort:0,msResolution:!1},timeFrom:null,timeShift:null,targets:[{}],aliasColors:{},seriesOverrides:[]},e["default"].defaults(this.panel,this.panelDefaults),e["default"].defaults(this.panel.tooltip,this.panelDefaults.tooltip),e["default"].defaults(this.panel.grid,this.panelDefaults.grid),e["default"].defaults(this.panel.legend,this.panelDefaults.legend),this.colors=b.$root.colors,this.events.on("render",this.onRender.bind(this)),this.events.on("data-received",this.onDataReceived.bind(this)),this.events.on("data-error",this.onDataError.bind(this)),this.events.on("data-snapshot-load",this.onDataSnapshotLoad.bind(this)),this.events.on("init-edit-mode",this.onInitEditMode.bind(this)),this.events.on("init-panel-actions",this.onInitPanelActions.bind(this))}return j(h,a),h.$inject=["$scope","$injector","annotationsSrv"],h.prototype.onInitEditMode=function(){this.addEditorTab("Axes","public/app/plugins/panel/graph/tab_axes.html",2),this.addEditorTab("Legend","public/app/plugins/panel/graph/tab_legend.html",3),this.addEditorTab("Display","public/app/plugins/panel/graph/tab_display.html",4),this.logScales={linear:1,"log (base 2)":2,"log (base 10)":10,"log (base 32)":32,"log (base 1024)":1024},this.unitFormats=d["default"].getUnitFormats()},h.prototype.onInitPanelActions=function(a){a.push({text:"Export CSV (series as rows)",click:"ctrl.exportCsv()"}),a.push({text:"Export CSV (series as columns)",click:"ctrl.exportCsvColumns()"}),a.push({text:"Toggle legend",click:"ctrl.toggleLegend()"})},h.prototype.setUnitFormat=function(a,b){a.format=b.value,this.render()},h.prototype.issueQueries=function(b){return this.annotationsPromise=this.annotationsSrv.getAnnotations(this.dashboard),a.prototype.issueQueries.call(this,b)},h.prototype.zoomOut=function(a){this.publishAppEvent("zoom-out",2)},h.prototype.onDataSnapshotLoad=function(a){this.annotationsPromise=this.annotationsSrv.getAnnotations(this.dashboard),this.onDataReceived(a)},h.prototype.onDataError=function(a){this.seriesList=[],this.render([])},h.prototype.onDataReceived=function(a){var b=this;this.datapointsWarning=!1,this.datapointsCount=0,this.datapointsOutside=!1,this.seriesList=a.map(this.seriesHandler.bind(this)),this.datapointsWarning=0===this.datapointsCount||this.datapointsOutside,this.annotationsPromise.then(function(a){b.loading=!1,b.seriesList.annotations=a,b.render(b.seriesList)},function(){b.loading=!1,b.render(b.seriesList)})},h.prototype.seriesHandler=function(a,b){var d=a.datapoints,e=a.target,g=b%this.colors.length,h=this.panel.aliasColors[e]||this.colors[g],i=new f["default"]({datapoints:d,alias:e,color:h,unit:a.unit});if(d&&d.length>0){var j=c["default"].utc(d[d.length-1][1]),k=c["default"].utc(this.range.from);j-k<-1e4&&(this.datapointsOutside=!0),this.datapointsCount+=d.length,this.panel.tooltip.msResolution=this.panel.tooltip.msResolution||i.isMsResolutionNeeded()}return i},h.prototype.onRender=function(){if(this.seriesList)for(var a=0,b=this.seriesList;a<b.length;a++){var c=b[a];c.applySeriesOverrides(this.panel.seriesOverrides),c.unit&&(this.panel.yaxes[c.yaxis-1].format=c.unit)}},h.prototype.changeSeriesColor=function(a,b){a.color=b,this.panel.aliasColors[a.alias]=a.color,this.render()},h.prototype.toggleSeries=function(a,b){b.ctrlKey||b.metaKey||b.shiftKey?this.hiddenSeries[a.alias]?delete this.hiddenSeries[a.alias]:this.hiddenSeries[a.alias]=!0:this.toggleSeriesExclusiveMode(a),this.render()},h.prototype.toggleSeriesExclusiveMode=function(a){var b=this,c=this.hiddenSeries;c[a.alias]&&delete c[a.alias];var d=e["default"].every(this.seriesList,function(b){return b.alias===a.alias||c[b.alias]});d?e["default"].each(this.seriesList,function(a){delete b.hiddenSeries[a.alias]}):e["default"].each(this.seriesList,function(c){c.alias!==a.alias&&(b.hiddenSeries[c.alias]=!0)})},h.prototype.toggleAxis=function(a){var b=e["default"].findWhere(this.panel.seriesOverrides,{alias:a.alias});b||(b={alias:a.alias},this.panel.seriesOverrides.push(b)),a.yaxis=b.yaxis=2===a.yaxis?1:2,this.render()},h.prototype.addSeriesOverride=function(a){this.panel.seriesOverrides.push(a||{})},h.prototype.removeSeriesOverride=function(a){this.panel.seriesOverrides=e["default"].without(this.panel.seriesOverrides,a),this.render()},h.prototype.toggleLegend=function(){this.panel.legend.show=!this.panel.legend.show,this.refresh()},h.prototype.legendValuesOptionChanged=function(){var a=this.panel.legend;a.values=a.min||a.max||a.avg||a.current||a.total,this.render()},h.prototype.exportCsv=function(){g.exportSeriesListToCsv(this.seriesList)},h.prototype.exportCsvColumns=function(){g.exportSeriesListToCsvColumns(this.seriesList)},h.template=b["default"],h}(h.MetricsPanelCtrl),a("GraphCtrl",i),a("PanelCtrl",i)}}});