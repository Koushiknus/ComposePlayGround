package com.example.composeplayground.kotlin_playground.superreducedstring1


fun superReducedString(s: String): String {

    val stack = StringBuilder()

    for(currentCharacter in  s) {
        if(stack.isNotEmpty() && stack.last() == currentCharacter) {
            stack.deleteCharAt(stack.length -1)
        }else {
            stack.append(currentCharacter)
        }
    }

    return if(stack.length == 0) "Empty String" else stack.toString()


}

fun main(args: Array<String>) {
    val s = readLine()!!

    val result = superReducedString(s)

    println(result)
}