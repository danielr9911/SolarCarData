/*! grafana - v3.1.1 - 2016-08-01
 * Copyright (c) 2016 Torkel Ödegaard; Licensed Apache-2.0 */

define(["app/core/directives/value_select_dropdown"],function(){"use strict";describe("SelectDropdownCtrl",function(){var a,b,c,d={};beforeEach(module("grafana.core")),beforeEach(inject(function(e,f,g,h){c=f,a=f.$new(),b=e("ValueSelectDropdownCtrl",{$scope:a}),b.getValuesForTag=function(a){return g.when(d[a.tagKey])},b.onUpdated=sinon.spy(),h.when("GET",/\.html$/).respond("")})),describe("Given simple variable",function(){beforeEach(function(){b.variable={current:{text:"hej",value:"hej"}},b.init()}),it("Should init labelText and linkText",function(){expect(b.linkText).to.be("hej")})}),describe("Given variable with tags and dropdown is opened",function(){beforeEach(function(){b.variable={current:{text:"server-1",value:"server-1"},options:[{text:"server-1",value:"server-1",selected:!0},{text:"server-2",value:"server-2"},{text:"server-3",value:"server-3"}],tags:["key1","key2","key3"],multi:!0},d.key1=["server-1","server-3"],d.key2=["server-2","server-3"],d.key3=["server-1","server-2","server-3"],b.init(),b.show()}),it("should init tags model",function(){expect(b.tags.length).to.be(3),expect(b.tags[0].text).to.be("key1")}),it("should init options model",function(){expect(b.options.length).to.be(3)}),it("should init selected values array",function(){expect(b.selectedValues.length).to.be(1)}),it("should set linkText",function(){expect(b.linkText).to.be("server-1")}),describe("after adititional value is selected",function(){beforeEach(function(){b.selectValue(b.options[2],{}),b.commitChanges()}),it("should update link text",function(){expect(b.linkText).to.be("server-1 + server-3")})}),describe("When tag is selected",function(){beforeEach(function(){b.selectTag(b.tags[0]),c.$digest(),b.commitChanges()}),it("should select tag",function(){expect(b.selectedTags.length).to.be(1)}),it("should select values",function(){expect(b.options[0].selected).to.be(!0),expect(b.options[2].selected).to.be(!0)}),it("link text should not include tag values",function(){expect(b.linkText).to.be("")}),describe("and then dropdown is opened and closed without changes",function(){beforeEach(function(){b.show(),b.commitChanges(),c.$digest()}),it("should still have selected tag",function(){expect(b.selectedTags.length).to.be(1)})}),describe("and then unselected",function(){beforeEach(function(){b.selectTag(b.tags[0]),c.$digest()}),it("should deselect tag",function(){expect(b.selectedTags.length).to.be(0)})}),describe("and then value is unselected",function(){beforeEach(function(){b.selectValue(b.options[0],{})}),it("should deselect tag",function(){expect(b.selectedTags.length).to.be(0)})})})}),describe("Given variable with selected tags",function(){beforeEach(function(){b.variable={current:{text:"server-1",value:"server-1",tags:[{text:"key1",selected:!0}]},options:[{text:"server-1",value:"server-1"},{text:"server-2",value:"server-2"},{text:"server-3",value:"server-3"}],tags:["key1","key2","key3"],multi:!0},b.init(),b.show()}),it("should set tag as selected",function(){expect(b.tags[0].selected).to.be(!0)})})})});