
object Level3Code {

  // A standard Sudoku puzzle contains 81 cells, in a 9 by 9 grid, and has 9 zones, each zone being the
  // intersection of 3 rows and 3 columns. Each cell may contain a number from one to nine; each number
  // can only occur once in each zone, row, and column of the grid. At the beginning of the game, many
  // cells begin with numbers in them, and the goal is to fill in the remaining cells. -- wikipedia

  // Solve any 9x9 Sudoku board that is input as an array.
  // Array values of 0 represent cells that must be solved for.
  // Array values > 0 must not be modified.
  // To solve: each number 1-9 must exist exactly 9 times, and never in the same row or same column as its self
  // The only valid values are 1-9
  // The more elegant the approach the better
  def solveSudoku(sudokuBoard: Array[Int]): Array[Int] = {

    val n = 9
    val s = Math.sqrt(n).toInt
    type Board = IndexedSeq[Array[Int]]

    def solve(board: Board, cell: Int = 0): Option[Board] = (cell % n, cell / n) match {
      case (r, `n`)                  => Some(board)
      case (r, c) if board(r)(c) > 0 => solve(board, cell + 1)
      case (r, c) =>
        def cells(i: Int) = Seq(board(r)(i), board(i)(c), board(s * (r / s) + i / s)(s * (c / s) + i % s))

        def guess(x: Int) = solve(board.updated(r, board(r).updated(c, x)), cell + 1)

        1 to n diff (board.indices flatMap cells) collectFirst Function.unlift(guess)
    }

    def getBoard() = {
      for (i <- 1 to 9) yield {
        val upper = i * 9
        sudokuBoard.slice(upper - 9, upper)
      }
    }
    val board = getBoard()

    solve(board).get.flatten.toArray
  }

  //Monkeys and Coconuts https://youtu.be/U9qU20VmvaU?t=43s
  //
  //<n> sailors are stranded on a desert island with one monkey.
  //The sailors gather coconuts into a pile and go to sleep.
  //
  //That night (without the knowledge of the others) each sailor in turn
  //separates out equal shares of coconuts with one left over (which they throw to the monkey)
  //then they hide their own share and throw the rest back on the pile.
  //
  //The next morning, they all separate the remaining pile and there are no coconuts left for the monkey.
  //How many coconuts did they have in the pile the night before?
  def monkeysAndCoconuts(sailors: Int): Int = {

    def calcShare(pile: Int) = pile / sailors

    def getRemaining(pile: Int, sailors: Int) = {
      val share = calcShare(pile)
      pile - share - 1 // take mine and give one to monkey
    }

    def playTheGame(pile: Int, turn: Int): Int = {

      if (turn > sailors) //turns are up
        pile
      else if (pile % sailors != 1) //!= 1 for the monkey
        0
      else {
        val remaining = getRemaining(pile, sailors)

        playTheGame(remaining, turn + 1)
      }
    }

    def testCase(pile: Int): Int = {

      val remaining = playTheGame(pile, 1)

      if (remaining > 0 && remaining % sailors == 0)
        pile
      else
        testCase(pile + 1)
    }

    testCase(0)
  }
}