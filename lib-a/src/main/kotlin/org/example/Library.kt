/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example

class Library {
    fun someLibraryMethod(): Boolean {
        return true
    }
}

fun main() {
    val commitPattern = Regex("(\\w+)\\(([^)]+)\\): (.+)")
    val commit = "build(lib-s): build s"
    val matchResult = commitPattern.find(commit) ?: throw IllegalStateException("Invalid commit message")

    println(matchResult.groupValues[1])
    println(matchResult.groupValues[2])
    println(matchResult.groupValues[3])


}
