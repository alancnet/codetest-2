
object Level1Code {

  // Returns "Hello World!"
  def helloWorld(): String = ???

  // Return the sum of two numbers
  def sum(a:Int, b:Int): Int = ???

  // Return the product of two numbers
  def product(a:Int, b:Int): Int = ???

  // Return the square of a number
  def square(a:Int): Int = ???

  // return the cube of a number
  def cube(a:Int):Int = ???

  // return the square root of a perfect square
  def sqrt(a:Int):Int = ???

  // return the Int quotient of a fraction
  def quotient(numerator:Int, denominator:Int):Int = ???

  // return the Int remainder of a fraction
  def remainder(numerator:Int, denominator:Int):Int = ???

  // return an array containing the square of each number
  // in the source array in the same order
  def squareAll(as:Array[Int]): Array[Int] = ???

  // return an array containing the cube of each number
  // in the source array in the same order
  def cubeAll(as:Array[Int]): Array[Int] = ???

  // return an array containing the product of an 'a' in array 'as' with
  // its respective 'b' in array 'bs'
  def productAll(as:Array[Int], bs:Array[Int]) : Array[Int] = ???

  // sum all of the elements in the array and return the result
  def sumAll(as:Array[Int]): Int = ???

  // reverse the array
  def reverse(as:Array[Int]): Array[Int] = ???

  // return a stream that contains every integer starting at 'start'
  def countFrom(start: Int): Stream[Int] = ???

  // return a stream that contains the square of every integer starting at 'start'
  def squaresFrom(start: Int): Stream[Int] = ???

  // return a stream that contains the product of factors from two streams
  def productOfStreams(aFactors: Stream[Int], bFactors: Stream[Int]): Stream[Int] = ???

}