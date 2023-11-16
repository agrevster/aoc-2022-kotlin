import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file and returns them as a list of strings with each entry as a new line.
 */
fun readInput(name: String) = File("src", "$name.txt")
    .readLines()

/**
 * Reads lines from the given input txt file and returns them as a single string.
 */
fun readRawInput(name: String) = File("src", "$name.txt")
    .readLines().joinToString(separator = "\n")

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)