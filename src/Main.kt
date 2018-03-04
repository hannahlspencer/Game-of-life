import java.util.*

fun main(array: Array<String>) {
    var game = Grid(arrayOf(arrayOf(Cell(false,0,0), Cell(false, 1,0), Cell(false,2,0)),
            arrayOf(Cell(true, 0,1), Cell(true, 1,1), Cell(true, 2,1)),
            arrayOf(Cell(false,0,2), Cell(false, 1,2), Cell(false, 2, 2)),
            arrayOf(Cell(true, 0,3), Cell(false, 1, 3), Cell(false, 2, 3)))
    )

    game.toString()
    nextTurn(game)

    game.checkNeighbours(game.board[0][0])
}


fun nextTurn(game: Grid) {
    println("Do you want to see the next turn? Y/N")
    var answer = readLine()

    when(answer) {
        "N", "n" -> println("Thanks for playing the Game of Life!")
        "Y", "y" -> { println("OK"); game.runTurn() }
        else -> { println("Please type a Y or an N"); nextTurn(game) }
    }

}

