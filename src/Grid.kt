class Grid {

    var board = arrayOf(arrayOf(Cell(false,0,0), Cell(false, 1,0), Cell(false,2,0)),
                        arrayOf(Cell(true, 0,1), Cell(true, 1,1), Cell(true, 2,1)),
                        arrayOf(Cell(false,0,2), Cell(false, 1,2), Cell(false, 2, 2)))

    override fun toString(): String {
            println(" |" + board[0][0].printCell() + "|" + board[1][0].printCell() + "|" + board[2][0].printCell() + "|")
            println(" |" + board[0][1].printCell() + "|" + board[1][1].printCell() + "|" + board[2][1].printCell() + "|")
            println(" |" + board[0][2].printCell() + "|" + board[1][2].printCell() + "|" + board[2][2].printCell() + "|")
        return ""
        }
}