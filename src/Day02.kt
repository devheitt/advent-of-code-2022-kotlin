enum class Options(val score: Int) {
    ROCK(1), PAPER(2), SCISSORS(3);

    companion object {
        private val winConditions = mapOf(
            Pair(ROCK, PAPER),
            Pair(SCISSORS, ROCK),
            Pair(PAPER, SCISSORS)
        )
        private val loseConditions = mapOf(
            Pair(PAPER, ROCK),
            Pair(ROCK, SCISSORS),
            Pair(SCISSORS, PAPER)
        )

        fun getOption(input: String): Options {
            return when (input) {
                in listOf("A", "X") -> ROCK
                in listOf("B", "Y") -> PAPER
                else -> SCISSORS
            }
        }

        fun getOptionWithCondition(opponent: Options, condition: String): Options {
            //X = lose, Y = draw, and Z = win
            return when (condition) {
                "Y" -> opponent
                "Z" -> winConditions[opponent]!!
                else -> loseConditions[opponent]!!
            }
        }
    }
}

fun main() {

    fun calculateRoundResult(myOption: Options, opponent: Options): Int {
        val score = myOption.score
        return if (myOption == opponent) {
            score + 3
        } else if (myOption == Options.PAPER && opponent == Options.ROCK
            || myOption == Options.ROCK && opponent == Options.SCISSORS
            || myOption == Options.SCISSORS && opponent == Options.PAPER
        ) {
            score + 6
        } else {
            score
        }
    }

    fun part1(input: List<String>): Int {
        var totalScore = 0
        for (round in input) {
            val (opponentOption, myOption) = round.split(" ").map { Options.getOption(it) }
            totalScore += calculateRoundResult(myOption, opponentOption)
        }
        return totalScore
    }

    fun part2(input: List<String>): Int {
        var totalScore = 0
        for (round in input) {
            val (opponentInput, condition) = round.split(" ").take(2)
            val opponentOption = Options.getOption(opponentInput)
            val myOption = Options.getOptionWithCondition(opponentOption, condition)
            totalScore += calculateRoundResult(myOption, opponentOption)

        }
        return totalScore
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
