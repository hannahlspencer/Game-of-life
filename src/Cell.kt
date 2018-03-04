class Cell(populated: Boolean = false, col: Int, row: Int) {
    var isPopulated = populated
    private final val columnPosition = col
    private final val rowPosition = row

    fun isBorn() {
        isPopulated = true
    }

    fun dies() {
        isPopulated = false
    }

    fun getColumnPosition() = columnPosition;
    fun getRowPosition() = rowPosition

    fun printCell(): String {
        var toPrint = " ";
        if (isPopulated) toPrint = "*" else toPrint = " "
        return toPrint
    }


}