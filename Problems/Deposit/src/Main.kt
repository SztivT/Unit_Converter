import java.util.*
import kotlin.math.pow

fun main() {
    // write your code here
    val scanner = Scanner(System.`in`)
    val arg = scanner.next()
    val value = scanner.nextInt()
    val total = when (arg) {
        "amount" -> compoundInterest(amount = value)
        "percent" -> compoundInterest(percent = value)
        "years" -> compoundInterest(years = value)
        else -> 0
    }
    print(total)
}

fun compoundInterest(amount: Int = 1000, percent: Int = 5, years: Int = 10): Int {
    return (amount * (1 + percent.toDouble() / 100).pow(years)).toInt()
}