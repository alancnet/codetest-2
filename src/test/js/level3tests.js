var assert = require('./assert.js');
var code = require('../src/js/level3code.js');
var level3tests = {
    helloWorldTest: function() {
        assert.areEqual("Hello World!", code.helloWorld());
    }
};
module.exports = level3tests;