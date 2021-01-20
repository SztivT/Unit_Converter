import java.util.*

fun main(args: Array<String>) {
    // write your code here
    val scanner = Scanner(System.`in`)
    val speed = scanner.nextLine()
    val limit = scanner.nextLine()
    if (limit == "no limit"){
        speedLimit(speed.toInt())
    }else{
        speedLimit(speed.toInt(), limit.toInt())
    }
}

fun speedLimit(speed: Int, limit: Int = 60) {
    if (speed > limit) {
        println("Exceeds the limit by ${speed - limit} kilometers per hour")
    }
    else {
        println("Within the limit")
    }
}