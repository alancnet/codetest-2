var assert = require('../../main/js/assert.js');
var code = require('../../main/js/level1code.js');
var level1tests = {
    helloWorldTest: function () {
        assert.areEqual("Hello World!", code.helloWorld());
    },
    linkedListMinTest: function () {

        var list = Object.create(code.linkedList);
        for (var i = 5; i <= 10; i++) {
          list.add(i);
        };
        assert.areEqual(5, list.min());
    },
    linkedListMaxTest: function () {

        var list = Object.create(code.linkedList);
        for (var i = 10; i <= 15; i++) {
          list.add(i);
        };
        assert.areEqual(14, list.max());
    },
    linkedListLengthTest: function () {
        
        var list = Object.create(code.linkedList);
        for (var i = 3; i <= 8; i++) {
          list.add(i);
        };
        assert.areEqual(5, list.length());
    },
    countFromToTest: function () {
        var actual1 = code.countFromTo(0, 10000);

        assert.areEqual(0, actual1.min());
        assert.areEqual(9999, actual1.max());
        assert.areEqual(10000, actual1.length());
    }
};
module.exports = level1tests;