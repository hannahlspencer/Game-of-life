import java.util.*
import java.util.Arrays.copyOf

class Grid(startGrid: Array<Array<Cell>>) {

    var board = startGrid
    var tempBoard = Arrays.copyOf(board, board.size)

    fun printBoard() {

        for(row in 0..tempBoard.size-1) {
            print(" |")
            for(col in 0..tempBoard[row].size-1) {
                print(tempBoard[row][col].printCell() + " |")
            }
            println();

        }

    }

    fun runTurn() {
        cellDecision()
       // board = tempBoard
        printBoard()

    }

    fun cellDecision() {
        for(arr in board) {
            for(cell in arr) {
                var neighbourNum = checkNeighbours(cell);
                var currentRow = cell.getRowPosition();
                var currentCol = cell.getColumnPosition()
                var tempCell = tempBoard[currentRow][currentCol]

                if(cell.isPopulated) {
                    if(neighbourNum < 2 || neighbourNum > 3) {
                        println("Cell dies")
                        tempCell.dies()
                    }
                } else {
                    if(neighbourNum === 3) {
                        println("A cell is born *")
                        tempCell.isBorn()
                    }
                }
            }

        }
    }
    fun checkNeighbours(cell : Cell) : Int{
        var numNeighbors = 0
        var column = cell.getColumnPosition()
        var row = cell.getRowPosition()


        // Up Left
        if (row - 1 >= 0 && column - 1 >= 0 && board[row-1][column-1].isPopulated)  numNeighbors += 1
        // Left
        if (row >= 0 && column - 1 >= 0 && board[row][column - 1].isPopulated) numNeighbors += 1
        // Down Left
        if (row + 1 < board.size && column - 1 >= 0 && board[row + 1][column - 1].isPopulated) numNeighbors += 1
        // Down
        if (row + 1 < board.size && column < board[0].size && board[row + 1][column].isPopulated) numNeighbors += 1
        // Down Right
        if (row + 1 < board.size && column + 1 < board[0].size && board[row + 1][column + 1].isPopulated) numNeighbors += 1
        // Right
        if (row < board.size && column + 1 < board[0].size && board[row][column + 1].isPopulated) numNeighbors += 1
        // Up Right
        if (row - 1 >= 0 && column + 1 < board[0].size && board[row - 1][column + 1].isPopulated) numNeighbors += 1
        // Up
        if (row - 1 >= 0 && column < board[0].size && board[row - 1][column].isPopulated) numNeighbors += 1

        println("Row =  ${cell.getRowPosition()}")
        println("Column = ${cell.getColumnPosition()}")
        println("Neighbours = $numNeighbors")
        return numNeighbors

    }

}