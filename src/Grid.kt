class Grid(startGrid: Array<Array<Cell>>) {

    var board = startGrid
    var tempBoard = board

    override fun toString(): String {
            println(" |" + board[0][0].printCell() + "|" + board[1][0].printCell() + "|" + board[2][0].printCell() + "|" + board[3][0].printCell())
            println(" |" + board[0][1].printCell() + "|" + board[1][1].printCell() + "|" + board[2][1].printCell() + "|" + board[3][1].printCell())
            println(" |" + board[0][2].printCell() + "|" + board[1][2].printCell() + "|" + board[2][2].printCell() + "|" + board[3][2].printCell())
        return ""
        }

    fun runTurn() {

    }
    fun checkNeighbours(cell : Cell) {
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

        cell.checkNeighbourNum(numNeighbors)
        println("Row =  ${cell.getRowPosition()}")
        println("Column = ${cell.getColumnPosition()}")
        tempBoard[cell.getRowPosition()][cell.getColumnPosition()] = cell
    }

}