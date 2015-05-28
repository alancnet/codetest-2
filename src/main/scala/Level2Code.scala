
object Level2Code {

  // An endless stream of Fibonacci numbers. Hint: current #:: ???
  def allFib(current: Int, next: Int): Stream[Int] =
    current #:: allFib(next, current + next)

  // Return a stream of N fibonacci numbers starting at the beginning
  def firstNFibonacciNumbers(n: Int): Stream[Int] = allFib(0, 1).take(n)

  // Determine if n is a Fibonacci number
  def isFibNumber(n: Int): Boolean = allFib(0, 1).takeWhile(x => x <= n).contains(n)

  // Sum all of the Fibonacci numbers between lower and upper inclusive.
  // Note that these are NOT the indexes of the numbers, but the numbers themselves.
  def sumSomeFib(lower: Int, upper: Int): Int = allFib(0, 1).filter(x => x >= lower).takeWhile(x => x <= upper).sum

  // This function should sum all of the values in the input sequence in parallel way to
  // take advantage of multiple cores
  // This function is broken. Fix it so it always returns the correct result.
  def parallelSum(list: scala.collection.parallel.ParSeq[Int]): Int = list.sum

  // Determine if the text occurs somewhere in the stream.
  // Code as if the stream was accessing a very large file that would not fit in memory.
  // 'text' is larger then a single stream, and is not aligned with
  // a string in the stream. You will have to handle the text being spread
  // across multiple strings in the stream
  def isTextInStream(stream: Stream[String], text: String): Boolean =
    text.length() == stream.flatten(chunk => chunk)
      .foldLeft(0)(
        (len, ch) => if (len == text.length() - 1) len
        else if (text(len) == ch) len + 1
        else 0) + 1
}