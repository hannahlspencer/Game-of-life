lateinit var game : Grid
lateinit var pattern1 : Grid
lateinit var pattern2 : Grid

fun main(array: Array<String>) {
    //initialising patterns
    pattern1 = Grid(arrayOf(
            arrayOf(Cell(false,0,0), Cell(false, 1,0), Cell(false,2,0)),
            arrayOf(Cell(true, 0,1), Cell(true, 1,1), Cell(true, 2,1)),
            arrayOf(Cell(false,0,2), Cell(false, 1,2), Cell(false, 2, 2)))
    )

    pattern2 = Grid(arrayOf(
            arrayOf(Cell(false,0,0), Cell(false, 1,0), Cell(false,2,0)),
            arrayOf(Cell(false, 0,1), Cell(true, 1,1), Cell(true, 2,1)),
            arrayOf(Cell(true,0,2), Cell(true, 1,2), Cell(false, 2, 2)))
    )

    //exit is true when user wants to exit game
    var exit = false

    //check pattern to use
    startUp()
    //prints initial board state
    game.printBoard()

    //while user does not want to exit, offered another turn
    while(!exit) {
        exit = nextTurn(game)
    }
}
/*
 * Asks user which pattern they'd like to see and validates choice
 */
fun startUp() {
    println("Which pattern would you like to see? Select 1 or 2")
    var select = readLine()?.toInt()
    when(select) {
        1 -> game = pattern1
        2 -> game = pattern2
        else -> { println("None of those worked, please start again"); startUp() }
    }
}

/*
 * Asks user if they want to keep going, validates choice, and runs next game turn if appropriate
 */
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

