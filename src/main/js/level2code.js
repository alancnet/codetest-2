var code = {
	// Returns an Array of n Fibonacci numbers
	firstNFibonacciNumbers: function (n) {

		var fibs = function (x) {
			if (x === 0)
				return 0;
			if (x === 1)
				return 1;
			return fibs(x - 1) + fibs(x - 2);
		};

		var arr = new Array();
		var cnt = 0;
		while (cnt <= n) {
			arr.push(fibs(cnt));
			cnt++;
		}

		return arr;
      //throw new Error("Not Implemented");
	},
	// Determines whether n is a Fibonacci number
	isFibonacciNumber: function (n) {
		var fibs = this.firstNFibonacciNumbers(n + 1);
		for (var i = 0; i <= fibs.length; i++) {
			if (fibs[i] === n)
				return true;
		}
		return false;
      //throw new Error("Not Implemented");
	},
	// Sums all Fibonacci numbers between lower and upper inclusive
	sumSomeFibonacciNumbers: function (lower, upper) {
		var fibs = this.firstNFibonacciNumbers(upper);
		var value = 0;
		for (var i = 0; i <= fibs.length; i++) {			
			if (fibs[i] >= lower && fibs[i] <= upper)
				value += fibs[i];
		}
		return value;
      //throw new Error("Not Implemented");
	}
};
module.exports = code;