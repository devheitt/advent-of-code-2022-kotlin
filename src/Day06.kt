import java.lang.RuntimeException

fun main() {
    // first approach
    fun part1(input: List<String>): Int {
        val data = input[0]
        var i = 3
        while (i < data.length) {
            val first = data[i - 3]
            val second = data[i - 2]
            val third = data[i - 1]
            val forth = data[i]
            i++

            if(setOf(first, second, third, forth).size == 4)
                return i
        }

        return 0
    }

    fun solve(data: String, size: Int): Int {
        val windowed = data.windowed(size)
        for((index, window) in windowed.withIndex()) {
            if(window.toSet().size == size)
                return index + size
        }
        throw RuntimeException()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    check(part1(testInput) == 7)

    val input = readInput("Day06")
    println(solve(input[0], 4))
    println(solve(input[0], 14))

}
