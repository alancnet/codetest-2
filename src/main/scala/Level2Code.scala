
object Level2Code {

  // ** Do not use a built in function **
  // Demonstrate an algorithm for finding the Golden Ratio
  // Given two numbers a and b with a > b > 0, the ratio is b / a
  // let c = a + b, then the ratio c / b is closer to the golden ratio
  // let d = b + c, then the ratio d / c is closer to the golden ratio
  // let e = c + d, then the ratio e / d is closer to the golden ratio
  // if you continue this process, the result will trend towards the golden ratio
  def goldenRatio(a:Double, b:Double) : Double = ???


  // An endless stream of Fibonacci numbers. Hint: current #:: ???
  def allFib(current: Int, next: Int): Stream[Int] = ???

  // Return a stream of N fibonacci numbers starting at the beginning
  def firstNFibonacciNumbers(n: Int): Stream[Int] = ???

  // Determine if n is a Fibonacci number
  def isFibNumber(n: Int): Boolean = ???

  // Sum all of the Fibonacci numbers between lower and upper inclusive.
  // Note that these are NOT the indexes of the numbers, but the numbers themselves.
  def sumSomeFib(lower: Int, upper: Int): Int = ???

  // This function should sum all of the values in the input sequence in parallel way to
  // take advantage of multiple cores
  // This function is broken. Fix it so it always returns the correct result.
  def parallelSum(list: scala.collection.parallel.ParSeq[Int]): Int = {
    var accumulator = 0
    list.map(x => {
      accumulator += x;
      x
    })
    return accumulator
  }

  // Determine if the text occurs somewhere in the stream.
  // Code as if the stream was accessing a very large file that would not fit in memory.
  // 'text' is larger then a single stream, and is not aligned with
  // a string in the stream. You will have to handle the text being spread
  // across multiple strings in the stream
  def isTextInStream(stream: Stream[String], text: String): Boolean = ???

}
