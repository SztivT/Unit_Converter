class Task(val name: String)

// create the Manager singleton here
object Manager {
    var solvedTask = 0
    fun solveTask(t: Task) {
        println("Task ${t.name} solved!")
        solvedTask++
    }
}