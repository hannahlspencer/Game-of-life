class Grid(startGrid: Array<Array<Cell>>) {

    var board = startGrid
    var tempBoard = board

    fun printBoard() {

        for(row in 0..board.size-1) {
            print(" |")
            for(col in 0..board[row].size-1) {
                print(board[row][col].printCell() + " |")
            }
            println();

        }

    }

    fun runTurn() {
        for(arr in board) {
            for(cell in arr) {
                checkNeighbours(cell);
                tempBoard[cell.getRowPosition()][cell.getColumnPosition()] = cell
            }

        }
        board = tempBoard
        printBoard()

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

    }

}