var assert = require('../../main/js/assert.js');
var code = require('../../main/js/level3code.js');
var level3tests = {
    monkeysAndCoconutsTest: function () {
        var actual = code.monkeysAndCoconuts(5);
        assert.areEqual(3121, actual);
    },
    checkSudokuSolution: function (arr) {

        for (var i = 0; i < 9; i += 3)
            for (var j = 0; j < 9; j += 3) {
                var filled = [];
                for (var k = 0; k < 3; k++)
                    for (var l = 0; l < 3; l++)
                        filled.push(arr[i + k][j + l] - 1);
                if (filled.length !== 9)
                    return false;
            }

        return true;
    },
    solveSudokuTest: function () {
        var board = [
            0, 2, 0, 1, 7, 8, 0, 3, 0,
            0, 4, 0, 3, 0, 2, 0, 9, 0,
            1, 0, 0, 0, 0, 0, 0, 0, 6,
            0, 0, 8, 6, 0, 3, 5, 0, 0,
            3, 0, 0, 0, 0, 0, 0, 0, 4,
            0, 0, 6, 7, 0, 9, 2, 0, 0,
            9, 0, 0, 0, 0, 0, 0, 0, 2,
            0, 8, 0, 9, 0, 1, 0, 6, 0,
            0, 1, 0, 4, 3, 6, 0, 5, 0
        ];
        var actual = code.solveSudoku(board);
        assert.areEqual(true, this.checkSudokuSolution(actual));
    }
};
module.exports = level3tests;