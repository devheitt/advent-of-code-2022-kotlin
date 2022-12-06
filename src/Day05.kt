fun main() {
    fun part1(input: List<String>): String {
        val stacks = HashMap<Int, ArrayDeque<String>>()
        var linesIndex = 0
        var line = input[linesIndex]
        while (!line.contains("1")) {
            val split = line.split("")
            var lineIndex = 2
            var stackIndex = 0
            while (lineIndex < split.size) {
                val container = split[lineIndex]
                if(!container.trim().isEmpty()) {
                    if(stacks[stackIndex] == null) {
                        stacks[stackIndex] = ArrayDeque()
                    }
                    stacks[stackIndex]?.addFirst(container)
                }
                lineIndex += 4
                stackIndex++
            }
            linesIndex++
            line = input[linesIndex]
        }
        linesIndex += 2;
        while (linesIndex < input.size) {
            line = input[linesIndex]
            val split = line.split(" ")
            val count = split[1].toInt()
            val from = split[3].toInt() - 1
            val to = split[5].toInt() - 1

            for (i in 0 until count){
                stacks[from]?.removeLast()?.let { stacks[to]?.addLast(it) }
            }

            linesIndex++
        }

        var result = ""
        for (cont in stacks.values) {
            result += cont.last()
        }

        return result
    }

    fun part2(input: List<String>): String {
        val stacks = HashMap<Int, ArrayDeque<String>>()
        var linesIndex = 0
        var line = input[linesIndex]
        while (!line.contains("1")) {
            val split = line.split("")
            var lineIndex = 2
            var stackIndex = 0
            while (lineIndex < split.size) {
                val container = split[lineIndex]
                if(!container.trim().isEmpty()) {
                    if(stacks[stackIndex] == null) {
                        stacks[stackIndex] = ArrayDeque()
                    }
                    stacks[stackIndex]?.addFirst(container)
                }
                lineIndex += 4
                stackIndex++
            }
            linesIndex++
            line = input[linesIndex]
        }
        linesIndex += 2;
        while (linesIndex < input.size) {
            line = input[linesIndex]
            val split = line.split(" ")
            val count = split[1].toInt()
            val from = split[3].toInt() - 1
            val to = split[5].toInt() - 1

            val tmpQueue = ArrayDeque<String>()
            for (i in 0 until count){
                stacks[from]?.removeLast()?.let { tmpQueue.addLast(it) }
            }

            for (container in tmpQueue.reversed()) {
                stacks[to]?.addLast(container)
            }

            linesIndex++
        }

        var result = ""
        for (cont in stacks.values) {
            result += cont.last()
        }

        return result
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == "CMZ")
    check(part2(testInput) == "MCD")

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))

}
