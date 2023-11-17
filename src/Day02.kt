enum class RoundOutcome(val pointValue: Int, val resultChar: Char) {
    WIN(6, 'Z'), LOSS(0, 'X'), TIE(3, 'Y');

    companion object {
        fun decodeFromChar(char: Char): RoundOutcome {
            return entries.find { it.resultChar == char }!!
        }
    }
}

enum class RockPaperScissors(val opponentChar: Char, val meChar: Char, val pointValue: Int) {
    ROCK('A', 'X', 1), PAPER('B', 'Y', 2), SCISSORS('C', 'Z', 3);

    companion object {
        fun decodeFromChar(char: Char): RockPaperScissors {
            return entries.find { it.meChar == char || it.opponentChar == char }!!
        }
    }
}

fun calculateRoundOutcome(meChoice: RockPaperScissors, opponentChoice: RockPaperScissors): RoundOutcome {
    return if (meChoice == RockPaperScissors.ROCK && opponentChoice == RockPaperScissors.SCISSORS) RoundOutcome.WIN
    else if (meChoice == RockPaperScissors.PAPER && opponentChoice == RockPaperScissors.ROCK) RoundOutcome.WIN
    else if (meChoice == RockPaperScissors.SCISSORS && opponentChoice == RockPaperScissors.PAPER) RoundOutcome.WIN
    else if (meChoice == opponentChoice) RoundOutcome.TIE
    else RoundOutcome.LOSS
}

fun calculateScore(meChoice: RockPaperScissors, opponentChoice: RockPaperScissors): Int {
    val outcome = calculateRoundOutcome(meChoice, opponentChoice)
    return outcome.pointValue + meChoice.pointValue
}

fun main() {

    fun part1(input: List<String>): Int {
        var totalScore = 0
        for (line in input) {
            val meMove = RockPaperScissors.decodeFromChar(line[2])
            val opponentMove = RockPaperScissors.decodeFromChar(line[0])
            totalScore += calculateScore(meMove, opponentMove)
        }
        return totalScore
    }

    fun determineMove(opponentMove: RockPaperScissors, desiredOutcome: RoundOutcome): RockPaperScissors {
        for (choice in RockPaperScissors.entries) {
            if (calculateRoundOutcome(choice, opponentMove) == desiredOutcome) {
                return choice
            }
        }
        throw Exception()
    }

    fun part2(input: List<String>): Int {
        var totalScore = 0

        for (line in input) {
            val opponentMove = RockPaperScissors.decodeFromChar(line[0])
            val desiredOutcome = RoundOutcome.decodeFromChar(line[2])
            val meMove = determineMove(opponentMove, desiredOutcome)
            totalScore += calculateScore(meMove, opponentMove)
        }

        return totalScore
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}