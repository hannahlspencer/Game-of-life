import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class CellTests {
    lateinit var testCell: Cell;
    @Before
    fun makeCell() {
        testCell = Cell(false, 0, 0)
    }
    @Test
    fun testisBorn() {
        testCell.isBorn()
        assertTrue(testCell.isPopulated)
    }

    @Test
    fun testDies() {
        testCell.isBorn()
        testCell.dies()
        assertFalse(testCell.isPopulated)
    }

    @Test
    fun testPrintOutPopulated() {
        testCell.isBorn()
        assertEquals("*",testCell.printCell())
    }

    @Test
    fun testPrintOutUnpopulated() {
        testCell.dies()
        assertEquals(" ",testCell.printCell())
    }
}