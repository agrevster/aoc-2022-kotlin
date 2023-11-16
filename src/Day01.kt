fun main() {
    data class Elf(val foodItems: List<Int>){
        val totalCalories = foodItems.sum()
    }

   fun getElves(input: String): List<Elf> {
       val elves = mutableListOf<Elf>()

       input.split("\n\n").forEach {elf ->
           elves += Elf(elf.lines().map { it.toInt() })
       }
       return elves
   }

    fun part1(input: String): Int {
        return getElves(input).maxOf { it.totalCalories }
    }

    fun part2(input: String): Int {
        return getElves(input).map { it.totalCalories }.sortedDescending().take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readRawInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readRawInput("Day01")
    part1(input).println()
    part2(input).println()
}