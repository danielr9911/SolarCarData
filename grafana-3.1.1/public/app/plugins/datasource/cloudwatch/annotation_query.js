/*! grafana - v3.1.1 - 2016-08-01
 * Copyright (c) 2016 Torkel Ödegaard; Licensed Apache-2.0 */

define(["lodash"],function(a){"use strict";function b(a,b,c,d){this.datasource=a,this.annotation=b,this.$q=c,this.templateSrv=d}return b.prototype.process=function(b,c){var d=this,e=this.annotation.prefixMatching,f=this.templateSrv.replace(this.annotation.region),g=this.templateSrv.replace(this.annotation.namespace),h=this.templateSrv.replace(this.annotation.metricName),i=this.datasource.convertDimensionFormat(this.annotation.dimensions),j=a.map(this.annotation.statistics,function(a){return d.templateSrv.replace(a)}),k=e?"":"300",l=this.annotation.period||k;l=parseInt(l,10);var m,n=this.annotation.actionPrefix||"",o=this.annotation.alarmNamePrefix||"",p=this.$q.defer();if(e)m=[this.datasource.performDescribeAlarms(f,n,o,[],"").then(function(a){return a.MetricAlarms=d.filterAlarms(a,g,h,i,j,l),a})];else{if(!f||!g||!h||a.isEmpty(j))return this.$q.when([]);m=a.map(j,function(a){return d.datasource.performDescribeAlarmsForMetric(f,g,h,i,a,l)})}return this.$q.all(m).then(function(e){var g=[],h=d.datasource.convertToCloudWatchTime(b,!1),i=d.datasource.convertToCloudWatchTime(c,!0);a.chain(e).pluck("MetricAlarms").flatten().each(function(b){return b?void d.datasource.performDescribeAlarmHistory(f,b.AlarmName,h,i).then(function(b){a.each(b.AlarmHistoryItems,function(a){var b={annotation:d.annotation,time:Date.parse(a.Timestamp),title:a.AlarmName,tags:[a.HistoryItemType],text:a.HistorySummary};g.push(b)}),p.resolve(g)}):void p.resolve(g)})}),p.promise},b.prototype.filterAlarms=function(b,c,d,e,f,g){return a.filter(b.MetricAlarms,function(b){if(!a.isEmpty(c)&&b.Namespace!==c)return!1;if(!a.isEmpty(d)&&b.MetricName!==d)return!1;var h=function(a){return a.Name},i=JSON.stringify(a.sortBy(b.Dimensions,h))===JSON.stringify(a.sortBy(e,h));return!(!a.isEmpty(e)&&!i)&&(!(!a.isEmpty(f)&&!a.contains(f,b.Statistic))&&!(!a.isNaN(g)&&b.Period!==g))})},b});