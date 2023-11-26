fun charactersUntilPacketDetected(input: String, packetSize: Int): Int {
    var iterations = packetSize
    var found = false
    input.windowed(packetSize,1,true){ seq ->
        if (seq.toSet().size == packetSize) found = true
        if (!found) iterations += 1
        else return@windowed
    }
    return iterations
}

fun main() {
    fun part1(input: String): Int  = charactersUntilPacketDetected(input, 4)

    fun part2(input: String): Int = charactersUntilPacketDetected(input, 14)

    // test if implementation meets criteria from the description, like:
//    val testInput = readInput("Day06_test")
//    check(part1(testInput[0]) == 5)
//    check(part1(testInput[1]) == 6)
//    check(part1(testInput[2]) == 10)
//    check(part1(testInput[3]) == 11)
    val input = readRawInput("Day06")

//    check(part2(testInput[0]) == 19)
//    check(part2(testInput[1]) == 23)
//    check(part2(testInput[2]) == 23)
//    check(part2(testInput[3]) == 29)
//    check(part2(testInput[4]) == 26)

    println(part1(input))

    println(part2(input))
}