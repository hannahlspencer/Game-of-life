import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class GridTests {
    lateinit var game:Grid
    lateinit var cell:Cell

    @Before
    fun makeGrid() {
        game = Grid()
        cell = Cell(false, 0, 0)
    }

    @Test
    fun elementAddedToTemp() {
        game.checkNeighbours(cell)
        assertTrue(game.tempBoard.isNotEmpty())
    }



}