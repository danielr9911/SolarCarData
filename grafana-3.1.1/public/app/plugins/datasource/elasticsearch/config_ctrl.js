/*! grafana - v3.1.1 - 2016-08-01
 * Copyright (c) 2016 Torkel Ödegaard; Licensed Apache-2.0 */

System.register(["lodash"],function(a){var b,c;return{setters:[function(a){b=a}],execute:function(){c=function(){function a(a){this.indexPatternTypes=[{name:"No pattern",value:void 0},{name:"Hourly",value:"Hourly",example:"[logstash-]YYYY.MM.DD.HH"},{name:"Daily",value:"Daily",example:"[logstash-]YYYY.MM.DD"},{name:"Weekly",value:"Weekly",example:"[logstash-]GGGG.WW"},{name:"Monthly",value:"Monthly",example:"[logstash-]YYYY.MM"},{name:"Yearly",value:"Yearly",example:"[logstash-]YYYY"}],this.esVersions=[{name:"1.x",value:1},{name:"2.x",value:2}],this.current.jsonData.timeField=this.current.jsonData.timeField||"@timestamp"}return a.$inject=["$scope"],a.prototype.indexPatternTypeChanged=function(){var a=b["default"].findWhere(this.indexPatternTypes,{value:this.current.jsonData.interval});this.current.database=a.example||"es-index-name"},a.templateUrl="public/app/plugins/datasource/elasticsearch/partials/config.html",a}(),a("ElasticConfigCtrl",c)}}});