fun parseRange(rangeString: String): IntRange {
    val (start,  end) = rangeString.split("-")
    return start.toInt()..end.toInt()
}

fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf{ plots ->
            val (plot1, plot2) = plots.split(",").map { parseRange(it).toSet()}
            val result = if (plot1.containsAll(plot2) || plot2.containsAll(plot1)) 1 else 0
            result
        }
    }

    fun part2(input: List<String>): Int {
        return input.sumOf {plots ->
            val (plot1, plot2) = plots.split(",").map { parseRange(it).toSet() }
            val result = if(plot1.intersect(plot2).isNotEmpty()) 1 else 0
            result
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}