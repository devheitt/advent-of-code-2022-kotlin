fun main() {

    fun part1(input: List<String>): Int {
        var maxAccumulated = 0
        var accumulated = 0

        for (calories in input) {
            if (calories.isEmpty()) {
                accumulated = 0
                continue
            }
            val value = calories.toInt()
            accumulated += value

            if (accumulated > maxAccumulated)
                maxAccumulated = accumulated
        }

        return maxAccumulated
    }

    fun part2(input: List<String>): Int {
        var accumulated = 0
        var listOfTotals = mutableListOf<Int>()

        for (calories in input) {
            if (calories.isEmpty()) {
                listOfTotals.add(accumulated)
                accumulated = 0
                continue
            }
            val value = calories.toInt()
            accumulated += value
        }
        listOfTotals.add(accumulated)
        return listOfTotals.sortedDescending().subList(0,3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))

}
