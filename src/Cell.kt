class Cell(populated: Boolean = false, col: Int, row: Int) {
    var isPopulated = populated
    //var neighbourNum = 0;
    private final val columnPosition = col
    private final val rowPosition = row

    //val neighbours: List<Cell>

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

    fun checkNeighbourNum(neighbourNum: Int) {
        println("Number of neighbours is: $neighbourNum")
        if(isPopulated) {
            if(neighbourNum < 2 || neighbourNum > 3) {
                println("Cell dies")
                dies()
            }
        } else {
            if(neighbourNum === 3) {
                println("A cell is born *")
                isBorn()
            }
        }
    }
}