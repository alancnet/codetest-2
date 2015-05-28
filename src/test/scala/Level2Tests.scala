import scala.Stream
import scala.collection.immutable.Stream.consWrapper

object Level2Tests {

  @Rank(1)
  def allFibTest() = {
    Assert.areEqual(
      "0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181",
      Level2Code.allFib(0, 1).take(20).mkString(","))
  }

  @Rank(2)
  def firstNFibonacciNumbersTest() = {
    def assertFirstNFib(n: Int, expected: Stream[Int]) = {
      val actual = Level2Code.firstNFibonacciNumbers(n).toList;
      Assert.isTrue(actual == expected, f"The first $n fib are $expected; But you had $actual")
    }
    assertFirstNFib(3, Stream(0, 1, 1))
    assertFirstNFib(6, Stream(0, 1, 1, 2, 3, 5))
    assertFirstNFib(9, Stream(0, 1, 1, 2, 3, 5, 8, 13, 21))
  }

  @Rank(3)
  def isFibTest() = {
    def assertNisFib(n: Int, is: Boolean) = Assert.isTrue(Level2Code.isFibNumber(n) == is, f"Is $n a fib? $is; But you had ${!is}")
    assertNisFib(0, true)
    assertNisFib(1, true)
    assertNisFib(2, true)
    assertNisFib(3, true)
    assertNisFib(4, false)
    assertNisFib(5, true)
    assertNisFib(6, false)
    assertNisFib(7, false)
    assertNisFib(8, true)
    assertNisFib(9, false)
  }

  @Rank(4)
  def sumSomeFibTest() = {
    def assertSumSomeFib(lower: Int, upper: Int, expected: Int) = {
      val actual = Level2Code.sumSomeFib(lower, upper);
      Assert.isTrue(actual == expected, f"The sum of all fib from $lower to $upper is $expected but you had $actual")
    }
    assertSumSomeFib(0, 10, 20)
    assertSumSomeFib(10, 20, 13)
    assertSumSomeFib(30, 100, 178)
    assertSumSomeFib(100, 1000, 2351)
    assertSumSomeFib(0, 500, 986)
  }

  @Rank(5)
  def parallelSumTest() = {
    val source1 = List.range(10, 10000).par
    val actual = Level2Code.parallelSum(source1)
    val expected = 49994955
    Assert.isTrue(actual == expected, f"expected $expected but got $actual")
  }

  @Rank(6)
  def isTextInStreamTest() = {
    def stringToStream(text: String, chunkSize: Int): Stream[String] = {
      if (text == null || text.length() == 0)
        Stream.empty
      else
        text.substring(0, Math.min(text.length(), chunkSize)) #::
          stringToStream(text.substring(Math.min(text.length(), chunkSize)), chunkSize)
    }
    val phrase1 = "The acts of the mind, wherein it exerts its power over simple ideas, are chiefly these three: 1. Combining several simple ideas into one compound one, and thus all complex ideas are made. 2. The second is bringing two ideas, whether simple or complex, together, and setting them by one another so as to take a view of them at once, without uniting them into one, by which it gets all its ideas of relations. 3. The third is separating them from all other ideas that accompany them in their real existence: this is called abstraction, and thus all its general ideas are made."
    val phrase2 = "We now come to the decisive step of mathematical abstraction: we forget about what the symbols stand for. ...[The mathematician] need not be idle; there are many operations which he may carry out with these symbols, without ever having to look at the things they stand for."
    Assert.isTrue(Level2Code.isTextInStream(stringToStream(phrase1, 10), phrase1.substring(37, 53)))
    Assert.isTrue(Level2Code.isTextInStream(stringToStream(phrase2, 10), phrase2.substring(30, 45)))
    Assert.isTrue(Level2Code.isTextInStream(stringToStream(phrase1, 7), phrase1.substring(37, 53)))
    Assert.isTrue(Level2Code.isTextInStream(stringToStream(phrase2, 15), phrase2.substring(30, 45)))
    Assert.isFalse(Level2Code.isTextInStream(stringToStream(phrase1, 10), phrase2.substring(37, 53)))
    Assert.isFalse(Level2Code.isTextInStream(stringToStream(phrase2, 10), phrase1.substring(30, 45)))
    Assert.isFalse(Level2Code.isTextInStream(stringToStream(phrase1, 20), phrase2.substring(37, 53)))
    Assert.isFalse(Level2Code.isTextInStream(stringToStream(phrase2, 30), phrase1.substring(30, 45)))
  }

}
