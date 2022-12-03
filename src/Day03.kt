fun main() {


    fun getPriority(repeated: Char): Int {
        //Priorities
        // a to z = 1 to 26
        // A to Z = 27 to 52
        val priority = if(repeated.code >= 97) {
            repeated.code - 96
        } else {
            repeated.code - 64 + 26
        }
        return priority
    }

    fun part1(input: List<String>): Int {
        var sum = 0
        for(rucksack in input) {
            val firstCompartment = rucksack.substring(0, rucksack.length / 2)
            val secondCompartment = rucksack.substring( rucksack.length / 2)
            firstCompartment
                .filter { c -> secondCompartment.contains(c) }
                .toSet()
                .map { repeated -> sum += getPriority(repeated) }
        }

        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        var index = 0
        while( index < input.size) {
            val first = input[index++]
            val second = input[index++]
            val third = input[index++]


            first
                .filter { second.contains(it)  && third.contains(it)}
                .toSet()
                .map { sum += getPriority(it) }

        }


        return sum
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
   // check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    //println(part1(input))
    println(part2(input))

}
