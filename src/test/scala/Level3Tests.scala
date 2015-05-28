
object Level3Tests {
  
  @Rank(1)
  def monkeysAndCoconutsTest() = {
    val sailors = 5
    val actualCoconuts = Level3Code.monkeysAndCoconuts(sailors)
    val expectedCoconuts = 3121
    Assert.areEqual(expectedCoconuts, actualCoconuts)
  }
  
  @Rank(2)
  def solveSudokuTest() = {
    def sudokuToString(board: Array[Int]): String = {
      var length = Stream.from(2).filter(x => x * x >= board.length).head
      val hline = "+" + Seq.range(0, 6 + length * 2)
        .map(x => if (x % 8 == 7) "+" else "-")
        .foldLeft(StringBuilder.newBuilder)((sb, s) => {
          sb.append(s)
        }).toString() + "\n"
      val sb = board.foldLeft((StringBuilder.newBuilder, 0))((bi, item) => {
        val b = bi._1
        var i = bi._2
        b.append(if (i % length == 0 && i % (length * 3) == 0) hline else "")
        b.append(if (i % length == 0 && item == 0) f"|  "
        else if (i % 3 != 2 && i % length != length - 1 && item == 0) f"  "
        else if (i % 3 == 2 && i % length != length - 1 && item == 0) f"   |"
        else if (item == 0) f"   |%n"
        else if (i % length == 0) f"| $item%1d"
        else if (i % 3 != 2 && i % length != length - 1) f" $item%1d"
        else if (i % 3 == 2 && i % length != length - 1) f" $item%1d |"
        else f" $item%1d |%n")
        (b, i + 1)
      })
      "\n" + sb._1.append(hline).toString() + "\n"
    }
    def assertSudokuSolves(inputBoard: Array[Int], checkBoard: (Array[Int] => Boolean)) = {
      val boardCopy = inputBoard.clone()
      val actual = Level3Code.solveSudoku(boardCopy)
      val solved = checkBoard(actual)
      lazy val errorOutput = StringBuilder.newBuilder.append("Failed to solve the board:\n")
        .append("input:")
        .append(sudokuToString(inputBoard))
        .append("result:")
        .append(sudokuToString(actual)).toString()
      Assert.isTrue(solved, errorOutput)
    }
    def boardBadColsAndRows(board: Array[Int]): (Stream[Int], Stream[Int]) = {
      def inRow(board: Array[Int], idx: Int): Set[Int] = {
        val rowIdx = (0 to 8).filter(x => x * 9 <= idx).max
        board.splitAt(rowIdx * 9)._2.take(9).toSet
      }
      def inCol(board: Array[Int], idx: Int): Set[Int] = {
        val colIdx = idx % 9
        board.scanLeft((-1, 0))((idxitem, item) => (idxitem._1 + 1, item))
          .filter((idxitem) => idxitem._1 % 9 == colIdx)
          .map(idxitem => idxitem._2).toSet
      }
      def badColumns(board: Array[Int]): Stream[Int] = {
        def sumCheckColumn(board: Array[Int], col: Int): Boolean = {
          inCol(board, col * 9).toList.length == 9
        }
        Stream.from(0).takeWhile(x => x < 10).filter(col => !sumCheckColumn(board, col))
      }
      def badRows(board: Array[Int]): Stream[Int] = {
        def sumCheckRow(board: Array[Int], row: Int): Boolean = {
          inRow(board, row * 9).toList.length == 9
        }
        Stream.from(0).takeWhile(x => x < 10).filter(row => !sumCheckRow(board, row))
      }
      (badColumns(board), badRows(board))
    }
    def doesBoardSolve(board: Array[Int]): Boolean = {
      val badColsBadRows = boardBadColsAndRows(board)
      badColsBadRows._1.length + badColsBadRows._2.length == 0
    }

    //        assertSudokuSolves(
    //            Array(  0,2,1,0,0,0,0,0,4,
    //                    4,0,0,8,0,0,0,0,0,
    //                    0,0,0,7,0,4,5,0,0,
    //                    0,0,6,0,1,0,0,9,0,
    //                    0,9,0,0,0,0,0,7,0,
    //                    0,4,0,0,9,0,6,0,0,
    //                    0,0,3,9,0,2,0,0,0,
    //                    0,0,0,0,0,3,0,0,1,
    //                    9,0,0,0,0,0,8,5,0), doesBoardSolve)

    assertSudokuSolves(Array(0, 2, 0, 1, 7, 8, 0, 3, 0,
      0, 4, 0, 3, 0, 2, 0, 9, 0,
      1, 0, 0, 0, 0, 0, 0, 0, 6,
      0, 0, 8, 6, 0, 3, 5, 0, 0,
      3, 0, 0, 0, 0, 0, 0, 0, 4,
      0, 0, 6, 7, 0, 9, 2, 0, 0,
      9, 0, 0, 0, 0, 0, 0, 0, 2,
      0, 8, 0, 9, 0, 1, 0, 6, 0,
      0, 1, 0, 4, 3, 6, 0, 5, 0), doesBoardSolve)
  }

}