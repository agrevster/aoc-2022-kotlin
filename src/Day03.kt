fun Char.points(): Int{
    if (!this.isLetter()) error("The charactor must be a letter!")
    return if (this.isLowerCase()) (this.code - 122) + 26
    else (this.code - 90) + (26*2)
}

fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf { sack ->
            val (compartment1, compartment2) = sack.chunked(sack.length / 2)
                .map { it.toCharArray().toSet() }
            compartment1.intersect(compartment2).sumOf { it.points() }
        }
    }

    fun part2(input: List<String>): Int {
        return input.windowed(3,3).sumOf { elves ->
            val (elf1, elf2, elf3) = elves
                .map { it.toCharArray().toSet() }

            elf1.intersect(elf2.intersect(elf3))
                .sumOf { it.points() }
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}