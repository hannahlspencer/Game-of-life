class Cell(populated: Boolean = false, col: Int, row: Int) {

    var isPopulated = populated
    private val columnPosition = col
    private val rowPosition = row


    fun isBorn() = {isPopulated = true}
    fun dies() { isPopulated = false }

    fun getColumnPosition() = columnPosition;
    fun getRowPosition() = rowPosition

    /*
     * return: String of symbol to print based on whether it is populated
     */
    fun printCell(): String {
        var toPrint = " ";
        if (isPopulated) toPrint = "*" else toPrint = " "
        return toPrint
    }
}