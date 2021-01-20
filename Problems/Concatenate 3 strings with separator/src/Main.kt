import java.util.*

fun main() {
    // write your code here
    val scanner = Scanner(System.`in`)
    val words = mutableListOf<String>()
    repeat(3) {
        words += scanner.next()
    }
    val separator = scanner.next()
    con(words, separator)
}

fun con(input: List<String>, sep: String) {
    for (i in input.indices) {
        print(input[i])
        if (i != input.lastIndex) {
            if (sep != "NO") {
                print(sep)
            } else {
                print(" ")
            }
        }
    }
}