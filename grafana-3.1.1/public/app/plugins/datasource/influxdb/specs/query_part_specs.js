/*! grafana - v3.1.1 - 2016-08-01
 * Copyright (c) 2016 Torkel Ödegaard; Licensed Apache-2.0 */

System.register(["test/lib/common","../query_part"],function(a){var b,c;return{setters:[function(a){b=a},function(a){c=a}],execute:function(){b.describe("InfluxQueryPart",function(){b.describe("series with mesurement only",function(){b.it("should handle nested function parts",function(){var a=c["default"].create({type:"derivative",params:["10s"]});b.expect(a.text).to.be("derivative(10s)"),b.expect(a.render("mean(value)")).to.be("derivative(mean(value), 10s)")}),b.it("should nest spread function",function(){var a=c["default"].create({type:"spread"});b.expect(a.text).to.be("spread()"),b.expect(a.render("value")).to.be("spread(value)")}),b.it("should handle suffirx parts",function(){var a=c["default"].create({type:"math",params:["/ 100"]});b.expect(a.text).to.be("math(/ 100)"),b.expect(a.render("mean(value)")).to.be("mean(value) / 100")}),b.it("should handle alias parts",function(){var a=c["default"].create({type:"alias",params:["test"]});b.expect(a.text).to.be("alias(test)"),b.expect(a.render("mean(value)")).to.be('mean(value) AS "test"')})})})}}});