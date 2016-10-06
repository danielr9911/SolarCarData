/*! grafana - v3.1.1 - 2016-08-01
 * Copyright (c) 2016 Torkel Ödegaard; Licensed Apache-2.0 */

System.register(["./lexer"],function(a){function b(a){this.expression=a,this.lexer=new c.Lexer(a),this.tokens=this.lexer.tokenize(),this.index=0}var c;return a("Parser",b),{setters:[function(a){c=a}],execute:function(){b.prototype={getAst:function(){return this.start()},start:function(){try{return this.functionCall()||this.metricExpression()}catch(a){return{type:"error",message:a.message,pos:a.pos}}},curlyBraceSegment:function(){if(this.match("identifier","{")||this.match("{")){for(var a="";!this.match("")&&!this.match("}");)a+=this.consumeToken().value;return this.match("}")||this.errorMark("Expected closing '}'"),a+=this.consumeToken().value,this.match("identifier")&&(a+=this.consumeToken().value),{type:"segment",value:a}}return null},metricSegment:function(){var a=this.curlyBraceSegment();if(a)return a;if(this.match("identifier")||this.match("number")){var b=this.consumeToken().value.split(".");return 2===b.length&&(this.tokens.splice(this.index,0,{type:"."}),this.tokens.splice(this.index+1,0,{type:"number",value:b[1]})),{type:"segment",value:b[0]}}this.match("templateStart")||this.errorMark("Expected metric identifier"),this.consumeToken(),this.match("identifier")||this.errorMark("Expected identifier after templateStart");var c={type:"template",value:this.consumeToken().value};return this.match("templateEnd")||this.errorMark("Expected templateEnd"),this.consumeToken(),c},metricExpression:function(){if(!(this.match("templateStart")||this.match("identifier")||this.match("number")||this.match("{")))return null;var a={type:"metric",segments:[]};for(a.segments.push(this.metricSegment());this.match(".");){this.consumeToken();var b=this.metricSegment();b||this.errorMark("Expected metric identifier"),a.segments.push(b)}return a},functionCall:function(){if(!this.match("identifier","("))return null;var a={type:"function",name:this.consumeToken().value};return this.consumeToken(),a.params=this.functionParameters(),this.match(")")||this.errorMark("Expected closing parenthesis"),this.consumeToken(),a},boolExpression:function(){return this.match("bool")?{type:"bool",value:"true"===this.consumeToken().value}:null},functionParameters:function(){if(this.match(")")||this.match(""))return[];var a=this.functionCall()||this.numericLiteral()||this.seriesRefExpression()||this.boolExpression()||this.metricExpression()||this.stringLiteral();return this.match(",")?(this.consumeToken(),[a].concat(this.functionParameters())):[a]},seriesRefExpression:function(){if(!this.match("identifier"))return null;var a=this.tokens[this.index].value;if(!a.match(/\#[A-Z]/))return null;var b=this.consumeToken();return{type:"series-ref",value:b.value}},numericLiteral:function(){return this.match("number")?{type:"number",value:parseFloat(this.consumeToken().value)}:null},stringLiteral:function(){if(!this.match("string"))return null;var a=this.consumeToken();if(a.isUnclosed)throw{message:"Unclosed string parameter",pos:a.pos};return{type:"string",value:a.value}},errorMark:function(a){var b=this.tokens[this.index],c=b?b.type:"end of string";throw{message:a+" instead found "+c,pos:b?b.pos:this.lexer["char"]}},consumeToken:function(){return this.index++,this.tokens[this.index-1]},matchToken:function(a,b){var c=this.tokens[this.index+b];return void 0===c&&""===a||c&&c.type===a},match:function(a,b){return this.matchToken(a,0)&&(!b||this.matchToken(b,1))}}}}});