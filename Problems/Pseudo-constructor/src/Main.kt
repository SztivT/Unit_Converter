class Point3D {
    var x: Int = 0
    var y: Int = 0
    var z: Int = 0
}

fun createPoint(x: Int, y: Int, z: Int): Point3D {
    // provide implementation here
    val obj = Point3D()
    obj.x = x
    obj.y = y
    obj.z = z
    return obj
}