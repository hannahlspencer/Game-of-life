import java.util.*

fun main(array: Array<String>) {
    var game = Grid()

    game.toString()
    nextTurn()
}


fun nextTurn() {
    println("Do you want to see the next turn? Y/N")
    var answer = readLine()

    when(answer) {
        "N", "n" -> println("Thanks for playing the Game of Life!")
        "Y", "y" -> { println("OK"); runTurn() }
        else -> { println("Please type a Y or an N"); nextTurn() }
    }

}

fun runTurn() {

}