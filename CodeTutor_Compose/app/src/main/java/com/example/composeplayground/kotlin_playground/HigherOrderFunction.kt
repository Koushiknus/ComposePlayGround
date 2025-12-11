package com.example.composeplayground.kotlin_playground


fun calculate(a : Int,b:Int , operation : (Int,Int) -> Int) :Int {
    return operation(a,b)
}

fun main(){
    val result = calculate(5,6) { x, y ->
        x * y
    }
    println(result)
}