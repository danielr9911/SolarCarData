/*! grafana - v3.1.1 - 2016-08-01
 * Copyright (c) 2016 Torkel Ödegaard; Licensed Apache-2.0 */

define(["./helpers","app/features/dashboard/rowCtrl"],function(a){"use strict";describe("RowCtrl",function(){var b=new a.ControllerTestContext;beforeEach(module("grafana.controllers")),beforeEach(b.providePhase()),beforeEach(b.createControllerPhase("RowCtrl")),describe("delete_row",function(){describe("when row is empty (has no panels)",function(){beforeEach(function(){b.scope.dashboard.rows=[{id:1,panels:[]}],b.scope.row=b.scope.dashboard.rows[0],b.scope.appEvent=sinon.spy(),b.scope.deleteRow()}),it("should NOT ask for confirmation",function(){expect(b.scope.appEvent.called).to.be(!1)}),it("should delete row",function(){expect(b.scope.dashboard.rows).to.not.contain(b.scope.row)})})})})});