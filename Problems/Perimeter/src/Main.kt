import kotlin.math.hypot

fun perimeter(
    x1: Double,
    y1: Double,
    x2: Double,
    y2: Double,
    x3: Double,
    y3: Double,
    x4: Double = x3,
    y4: Double = y3
): Double {
    val d12 = hypot(x2 - x1, y2 - y1)
    val d23 = hypot(x3 - x2, y3 - y2)
    val d34 = hypot(x4 - x3, y4 - y3)
    val d41 = hypot(x1 - x4, y1 - y4)
    return d12 + d23 + d34 + d41
}