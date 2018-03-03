class Cell(populated: Boolean = false, x: Int, y: Int) {
    var isPopulated = populated
    val positionX = x
    val positionY = y
    //val neighbours: List<Cell>

    fun isBorn() {
        isPopulated = true
    }

    fun dies() {
        isPopulated = false
    }

    fun printCell(): String {
        var toPrint = " ";
        if (isPopulated) toPrint = "*" else toPrint = " "
        return toPrint
    }

    fun checkNeighbours() {
        //if < 2 neighbours dies()
        //if > 3 neighbours dies()
        //if (while isPopulated) 2/3 neighbours - no change
        //if(while !isPopulated) 3 neighbours isBorn()
    }
}