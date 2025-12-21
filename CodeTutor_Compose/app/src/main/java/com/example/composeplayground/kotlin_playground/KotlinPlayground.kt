package com.example.composeplayground.kotlin_playground

import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.sample
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

fun main() {
    println("Reverse String  ${reverseString("Kotlin")}")
    println("IsPalindrome ${isPalindrome("madam")}")
    println("Maximum of Array is ${findMax(arrayOf(1,3,5,7,99))}")
    println("Missing number is ${ findMissingNumber(arrayOf(1,2,3,5),5) }")
    println("Majority Element is ${ findTheMajorityElement(listOf(1,2,3,4,5,1,1))}")
    println("Reverse String is ${ reverseWithoutBuiltIn("Bad")}")
    println("Second largest ...${listOf<Int>(1,2,3,4,5,6).findSecondLargest()}")
    println("Filter transactions... ${filterTransactions(listOf(Transactions("1",3000.00),Transactions("2",2000.00)),
        )}")
    println("Remove duplicates... ${removeDuplicates(arrayOf(1,1,2,2,3,4,5))}")
    runBlocking {
        combineExample()
    }

    println("SortedSquare....${sortedSquares(intArrayOf(-4, -1, 0, 3, 10)).joinToString()}")
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

fun reverseWithoutBuiltIn(word : String) : String {
  val result = StringBuilder()
  for (i in word.length -1 downTo 0)  {
      result.append(word[i])
  }
    return result.toString()
}

fun List<Int>.findSecondLargest() : Int? {
    if(this.size < 2) return null
    var max = Int.MIN_VALUE
    var secondMax  = Int.MIN_VALUE

    for(num in this) {
            when {
                num > max -> {
                    secondMax = max
                    max = num
                }
                num > secondMax && num != max -> {
                    secondMax = num
                }
            }
    }
    return  if(secondMax == Int.MIN_VALUE) null else secondMax
}

fun filterTransactions(list : List<Transactions>): List<Transactions> {
    return list.sortedBy { it.amount }
}

fun removeDuplicates(list : Array<Int>) : Set<Int> {
    return list.toSet()
}

data class Transactions(
    val id : String,
    val amount: Double
)

val flowA = flowOf(1,2,3)
val flowB = flowOf(5,6,7)

suspend fun combineExample() {
    combine(flowA,flowB) { a, b ->
        a+b
    }.collect{
        println(it)
    }

    flowA.zip(flowB) { a,b ->
        a to b
    }.collect {
        print("ZiP Example $it")
    }

    merge(flowA, flowB).collect {
        println("MergeExample $it")
    }


}
//Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {

    for(i in  0 until n) {
        nums1[m+i] = nums2[i]
    }
    nums1.sort()
}

fun sortedSquares(nums: IntArray): IntArray {
    val squareInt = nums.map { it*it }.toIntArray()
    return squareInt.sortedArray()
}




