var assert = require('../../main/js/assert.js');
var code = require('../../main/js/level2code.js');
var level2tests = {
    fibonacciNumbers: [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181],
    firstNFibonacciNumbersTest: function () {
        var expected = this.fibonacciNumbers;
        var actual = code.firstNFibonacciNumbers(expected.length);
        for (var i = 0; i < expected.length; i++) {
            assert.areEqual(expected[i], actual[i]);
        }
    },
    isFibonacciNumberTest: function () {
        var assertIsFib = function (expected, n) {
            var actual = code.isFibonacciNumber(n);
            assert.areEqual(expected, actual);
        };
        assertIsFib(true, 0);
        assertIsFib(true, 1);
        assertIsFib(true, 2);
        assertIsFib(true, 3);
        assertIsFib(false, 4);
        assertIsFib(true, 5);
        assertIsFib(false, 6);
        assertIsFib(false, 7);
        assertIsFib(true, 8);
        assertIsFib(false, 9);
    },
    sumSomeFibonacciNumbersTest: function () {
        var assertSumSome = function (lower, upper, expected) { 
            var actual = code.sumSomeFibonacciNumbers(lower, upper);
            assert.areEqual(expected, actual);
        };
        assertSumSome(0, 10, 20);
        assertSumSome(9, 20, 13);
        assertSumSome(8, 34, 76);
        assertSumSome(13, 34, 68);
        assertSumSome(20, 34, 55);
        assertSumSome(21, 33, 21);
        assertSumSome(22, 34, 34);
    }
};
module.exports = level2tests;