
class Grid(startGrid: Array<Array<Cell>>) {

    //stores current state of the game
    var board = startGrid

    /*
     * Prints current state of the board to the console
     */
    fun printBoard() {
        for(row in 0..board.size-1) {
            print(" |")
            for(col in 0..board[row].size-1) {
                print(board[row][col].printCell() + " |")
            }
            println();
        }
    }

    /*
     * Runs a single turn of the game
     */
    fun runTurn() {
        cellDecision()
        printBoard()
    }

    /*
     * checks each cell and determines its fate
     * adds cells that need to die or be born to a list
     * feeds those lists into killOrBirthMethods to kill or birth them
     */

    fun cellDecision() {
        var toDie = mutableListOf<Cell>()
        var toBirth = mutableListOf<Cell>()
        for(arr in board) {
            for(cell in arr) {
                val neighbourNum = checkNeighbours(cell);
                if(cell.isPopulated) {
                    if(neighbourNum < 2 || neighbourNum > 3) {
                        toDie.add(cell)
                    }
                } else {
                    if(neighbourNum == 3) {
                        toBirth.add(cell)
                    }
                }
            }
        }
        killOrBirthCells(toDie, toBirth)
    }

    /* takes two lists of cells, one to kill and one to birth
     * @params: List<Cell>, List<Cell>
     */
    fun killOrBirthCells(toDie : List<Cell>, toBirth: List<Cell>) {
        for(cell in toDie) {
            cell.dies()
        }
        for(cell in toBirth) {
            cell.isBorn()
        }
    }

    /* Takes a cell and checks which of its neighbours are populated, one by one
     * @params: Cell
     * @returns: Int - number of neighbours the cell has
     */
    fun checkNeighbours(cell : Cell) : Int{
        var numNeighbors = 0
        val column = cell.getColumnPosition()
        val row = cell.getRowPosition()


        // Up Left
        if (row - 1 >= 0 && column - 1 >= 0 && board[row-1][column-1].isPopulated)numNeighbors += 1
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

        return numNeighbors

    }

    /*
     * toString method for testing purposes
     * @return: string representation of board
     */
    override fun toString(): String {
        var str = ""
        for(row in 0..board.size-1) {
            str += (" |")
            for(col in 0..board[row].size-1) {
                str += board[row][col].printCell() + " |"
            }
        }
        return str;
    }

}