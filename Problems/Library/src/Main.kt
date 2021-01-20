object Math {
    fun abs(inp: Int): Int {
        return if (inp < 0) {
            -1 * inp
        } else {
            inp
        }
    }
    fun abs(inp: Double): Double {
        return if (inp < 0) {
            -1 * inp
        } else {
            inp
        }
    }

}