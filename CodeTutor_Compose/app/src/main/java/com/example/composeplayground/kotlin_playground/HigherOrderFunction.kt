package com.example.composeplayground.kotlin_playground


fun calculate(a : Int,b:Int , operation : (Int,Int) -> Int) :Int {
    return operation(a,b)
}

fun main(){
    /*val result = calculate(5,6) { x, y ->
        x * y
    }
    println(result)*/

    println(lengthOfLastWord("Hello world"))
    println(containsDuplicate(intArrayOf(1,2,3,4)))

}

fun lengthOfLastWord(s: String) : Int {
    val wordArray = s.split(" ")
    var wordList = mutableSetOf<String>()
     wordArray.forEach {
         if(it.isNotEmpty()){
             wordList.add(it)
         }
     }
    return wordList.last().length
}

fun containsDuplicate(nums: IntArray): Boolean {
    val duplicatesSet = HashSet<Int>(
    )
    nums.forEach {
        if(duplicatesSet.contains(it)){
            return true
        }else {
            duplicatesSet.add(it)
        }   
    }
    return false
}