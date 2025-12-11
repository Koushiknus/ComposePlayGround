package com.example.composeplayground.kotlin_playground

fun main() {
    println("Reverse String  ${reverseString("Kotlin")}")
    println("IsPalindrome ${isPalindrome("madam")}")
    println("Maximum of Array is ${findMax(arrayOf(1,3,5,7,99))}")
    println("Missing number is ${ findMissingNumber(arrayOf(1,2,3,5),5) }")
    println("Majority Element is ${ findTheMajorityElement(listOf(1,2,3,4,5,1,1))}")

}

//Reverse a String
fun reverseString(word : String): String {
    return word.reversed()
}

//Check for Palindrome String
fun isPalindrome(word : String) : Boolean {
    val reversedWord  = word.reversed()
    return word == reversedWord
}
//Find the Maximum Element in an Array
fun findMax(array :Array<Int>) :Int? {
    return array.maxOrNull()
}

fun findMissingNumber(arr : Array<Int>,n : Int) : Int {
    val arraySum = arr.sum()
    val wholeNumberSum = n * ((n+1)/2)
    return wholeNumberSum - arraySum
}

fun findTheMajorityElement (numbers : List<Int>) : Int {
    var candidate = 0
    var count = 0

    for ( i in numbers) {
        if(count == 0) {
            candidate = i
        }
        count  += if(candidate == i) 1 else -1
    }
    return candidate
}