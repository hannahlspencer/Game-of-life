import org.junit.Before
import org.junit.Test
import kotlin.math.exp
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
    fun testCheckNeighboursMethod() {
        var result = game.checkNeighbours(cell)
        var expected = 2
        assertEquals(expected, result)
        result = game.checkNeighbours(secondCell)
        expected = 0
        assertEquals(expected, result)
        result = game.checkNeighbours(thirdCell)
        expected = 3
        assertEquals(expected, result)
    }

    @Test
    fun testKillOrBirthCells() {
        var toDie = listOf(Cell(true, 1,2), Cell(true, 3, 5), Cell(true, 4, 6))
        var toBirth = listOf(Cell(false, 1, 4), Cell(false, 5, 7), Cell(false, 6, 3))

        game.killOrBirthCells(toDie, toBirth)

        assertFalse(toDie[0].isPopulated)
        assertFalse(toDie[1].isPopulated)
        assertFalse(toDie[2].isPopulated)

        assertTrue(toBirth[0].isPopulated)
        assertTrue(toBirth[1].isPopulated)
        assertTrue(toBirth[2].isPopulated)
    }

    @Test
    fun testCellDecision() {
        game.cellDecision()
        var result = game.toString()
        var expectedBoard = arrayOf(
                arrayOf(Cell(false,0,0), Cell(true, 1,0), Cell(false,2,0)),
                arrayOf(Cell(false, 0,1), Cell(true, 1,1), Cell(false, 2,1)),
                arrayOf(Cell(true,0,2), Cell(false, 1,2), Cell(false, 2, 2)),
                arrayOf(Cell(false, 0,3), Cell(false, 1, 3), Cell(false, 2, 3)))
        var testGame = Grid(expectedBoard)
        var expected = (testGame.toString())
        assertEquals(expected, result)
    }


}