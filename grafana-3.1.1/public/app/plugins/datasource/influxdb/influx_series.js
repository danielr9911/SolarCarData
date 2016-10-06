/*! grafana - v3.1.1 - 2016-08-01
 * Copyright (c) 2016 Torkel Ödegaard; Licensed Apache-2.0 */

define(["lodash","app/core/table_model"],function(a,b){"use strict";function c(a){this.series=a.series,this.alias=a.alias,this.annotation=a.annotation}var d=c.prototype;return d.getTimeSeries=function(){var b,c,d=[],e=this;return 0===e.series.length?d:(a.each(e.series,function(f){var g=f.columns.length,h=a.map(f.tags,function(a,b){return b+": "+a});for(c=1;c<g;c++){var i=f.name,j=f.columns[c];"value"!==j&&(i=i+"."+j),e.alias?i=e._getSeriesName(f,c):f.tags&&(i=i+" {"+h.join(", ")+"}");var k=[];if(f.values)for(b=0;b<f.values.length;b++)k[b]=[f.values[b][c],f.values[b][0]];d.push({target:i,datapoints:k})}}),d)},d._getSeriesName=function(a,b){var c=/\$(\w+)|\[\[([\s\S]+?)\]\]/g,d=a.name.split(".");return this.alias.replace(c,function(c,e,f){var g=e||f,h=parseInt(g,10);if("m"===g||"measurement"===g)return a.name;if("col"===g)return a.columns[b];if(!isNaN(h))return d[h];if(0!==g.indexOf("tag_"))return c;var i=g.replace("tag_","");return a.tags?a.tags[i]:c})},d.getAnnotations=function(){var b=[],c=this;return a.each(this.series,function(d){var e=null,f=null,g=null,h=null;a.each(d.columns,function(a,b){if("time"===a)return void(f=b);if("sequence_number"!==a)return e||(e=b),a===c.annotation.titleColumn?void(e=b):a===c.annotation.tagsColumn?void(g=b):a===c.annotation.textColumn?void(h=b):void 0}),a.each(d.values,function(a){var d={annotation:c.annotation,time:+new Date(a[f]),title:a[e],tags:a[g],text:a[h]};b.push(d)})}),b},d.getTable=function(){var c,d,e=new b["default"],f=this;return 0===f.series.length?e:(a.each(f.series,function(b,f){if(0===f)for(e.columns.push({text:"Time",type:"time"}),a.each(a.keys(b.tags),function(a){e.columns.push({text:a})}),d=1;d<b.columns.length;d++)e.columns.push({text:b.columns[d]});if(b.values)for(c=0;c<b.values.length;c++){var g=b.values[c],h=[g[0]];if(b.tags)for(var i in b.tags)b.tags.hasOwnProperty(i)&&h.push(b.tags[i]);for(d=1;d<g.length;d++)h.push(g[d]);e.rows.push(h)}}),e)},c});