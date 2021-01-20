import java.util.*

fun main() {
    // put your code here
    val scanner = Scanner(System.`in`)
    val lInput = mutableListOf<Int>()
    var ascending = true
    var descending = true
    repeat(3) {
        lInput += scanner.nextInt()
    }
    for (i in lInput.indices) {
        if (i > 0) {
            if (lInput[i] < lInput[i - 1]) {
                ascending = false
            }
            if (lInput[i] > lInput[i - 1]) {
                descending = false
            }
        }
    }
    println(ascending || descending)
}