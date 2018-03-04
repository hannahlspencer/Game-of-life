import java.util.*

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
                //finds the number of neighbours for each cell
                var neighbourNum = checkNeighbours(cell);

                //makes decision based on number of neighbours and whether cell is populated
                if(cell.isPopulated) {
                    if(neighbourNum < 2 || neighbourNum > 3) {
                        toDie.add(cell)
                    }
                } else {
                    if(neighbourNum === 3) {
                        toBirth.add(cell)
                    }
                }
            }
        }
        //feeds cells to kill or birth into killOrBirth method
        killOrBirthCells(toDie, toBirth)
    }

    /*
     * Takes two lists that are assigned whether they are cells to kill or to birth
     * Kills or births cells accordingly
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

    /*
     * Checks each of the cell's neighbours on the board one by one
     * @param: Cell being checked
     * @returns: number of neighbours that cell has
     */
    fun checkNeighbours(cell : Cell) : Int{
        var numNeighbors = 0
        var column = cell.getColumnPosition()
        var row = cell.getRowPosition()


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
     * overrides toString method to allow for testing
     * @returns: String representation of the board
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