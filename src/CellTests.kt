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
    fun testNeighbourNum0and1() {
        testCell.checkNeighbourNum(0)
        assertFalse(testCell.isPopulated)
        testCell.checkNeighbourNum(1)
        assertFalse(testCell.isPopulated)
    }

    @Test
    fun testNeighbourNum3() {
        //making cell populated
        testCell.checkNeighbourNum(3)
        assertTrue(testCell.isPopulated)
        //checking cell stays populated
        testCell.checkNeighbourNum(3)
        assertTrue(testCell.isPopulated)
    }

    @Test
    fun testNeighbourNum2() {
        testCell.checkNeighbourNum(2)
        assertFalse(testCell.isPopulated)
        testCell.isBorn()
        testCell.checkNeighbourNum(2)
        assertTrue(testCell.isPopulated)
    }
}