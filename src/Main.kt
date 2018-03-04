import java.util.*

fun main(array: Array<String>) {
    var game = Grid(arrayOf(
            arrayOf(Cell(false,0,0), Cell(false, 1,0), Cell(false,2,0)),
            arrayOf(Cell(true, 0,1), Cell(true, 1,1), Cell(true, 2,1)),
            arrayOf(Cell(false,0,2), Cell(false, 1,2), Cell(false, 2, 2)))
    )

    var exit = false
    game.printBoard()
    while(!exit) {
        exit = nextTurn(game)
    }
}


fun nextTurn(game: Grid) : Boolean {
    println("Do you want to see the next turn? Y/N")
    var answer = readLine()
    var exit = false;
    when(answer) {
        "N", "n" -> { println("Thanks for playing the Game of Life!"); exit = true }
        "Y", "y" -> { println("OK"); game.runTurn() }
        else -> { println("Please type a Y or an N"); nextTurn(game) }
    }

    return exit

}

