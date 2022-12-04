fun main() {
    fun part1(input: List<String>): Int {
        //In how many assignment pairs does one range fully contain the other?
        var count = 0

        for (line in input) {
            val pairs = line.split(",")
            val firstPair = pairs[0].split("-").map { c -> c.toInt() }
            val secondPair = pairs[1].split("-").map { c -> c.toInt() }
            if(firstPair[0] <= secondPair[0] && firstPair[1] >= secondPair[1]
                || secondPair[0] <= firstPair[0] && secondPair[1] >= firstPair[1])
                count++
        }


        return count
    }

    fun part2(input: List<String>): Int {
        //In how many assignment pairs do the ranges overlap?
        var count = 0

        for (line in input) {
            val pairs = line.split(",")
            val firstPair = pairs[0].split("-").map { c -> c.toInt() }
            val secondPair = pairs[1].split("-").map { c -> c.toInt() }
            if(firstPair[1] >= secondPair[0] && firstPair[0] <= secondPair[1]
                || secondPair[1] >= firstPair[0] && secondPair[0] <= firstPair[1])
                count++
        }


        return count
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))


}
