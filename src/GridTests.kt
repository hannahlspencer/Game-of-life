import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class GridTests {
    lateinit var game:Grid
    lateinit var cell:Cell
    lateinit var secondCell: Cell
    lateinit var thirdCell: Cell

    @Before
    fun makeGrid() {
        game = Grid(arrayOf(arrayOf(Cell(false,0,0), Cell(false, 1,0), Cell(false,2,0)),
                arrayOf(Cell(true, 0,1), Cell(true, 1,1), Cell(true, 2,1)),
                arrayOf(Cell(false,0,2), Cell(false, 1,2), Cell(false, 2, 2)),
                arrayOf(Cell(true, 0,3), Cell(false, 1, 3), Cell(false, 2, 3)))
        )
        cell = Cell(false, 0, 0)
        secondCell = Cell(true, 0, 3)
        thirdCell = Cell(false, 0, 2)
    }

    @Test
    fun elementAddedToTemp() {
        game.checkNeighbours(cell)
        assertTrue(game.tempBoard.isNotEmpty())
        assertFalse(cell.isPopulated)
    }

    @Test
    fun checkingNeighboursKillCell() {
        game.checkNeighbours(secondCell)
        assertFalse(secondCell.isPopulated)
    }

    @Test
    fun checkingNeighboursBirthCell() {
        println("Before: ${thirdCell.isPopulated}")

        game.checkNeighbours(thirdCell)
        println("After: ${thirdCell.isPopulated}")
        assertTrue(thirdCell.isPopulated)
    }


}