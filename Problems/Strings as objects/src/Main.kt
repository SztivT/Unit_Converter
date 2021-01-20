fun main() {
    val input = readLine()!!
    // write code here
    if (input == "") {
        print(input)
    } else {
        when {
            input.first() == 'i' -> {
                val num = input.drop(1).toInt() + 1
                println(num)
            }
            input.first() == 's' -> {
                println(input.drop(1).reversed())
            }
            else -> {
                println(input)
            }
        }
    }
}