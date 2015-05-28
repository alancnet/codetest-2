var level1code = require('./level1code.js');
var level1tests = require('../../test/js/level1tests.js');
var level2code = require('./level2code.js');
var level2tests = require('../../test/js/level2tests.js');
function Program() {

    function test(t, name) {
        try {
            t();
            console.log("PASS:" + name);
        } catch (ex) {
            console.log("FAIL:" + name + ": " + (ex.message || ex));
        }
    }

    function run(tests) {
        var names = Object.getOwnPropertyNames(tests);
        names.forEach(function (name, i) {
            if (/Test$/.test(name)) {
                test(tests[name].bind(tests), name);
            }
        });
    }

    function main() {
        console.log("\nJavaScript Tests:");

        run(level1tests);
        run(level2tests);

        console.log("Done!");
    }
    main();
}

Program();