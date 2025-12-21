import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking


val data = listOf(
    listOf(1, 2),
    null,
    listOf(3),
    null,
    listOf(3,4,2,7)
)

fun main() {
    runBlocking {
        println("ReturnSquareIS ${returnSquare(flowOf(listOf(1,2,3))).collect {
            println(it)
        }}")
    }
   val accounts =listOf(
       Accounts(listOf("acc1","acc2"))
   )

    println("FlatMap example ${accounts.flatMap { it.accounts }}")
    println("Map example ${accounts.map { it.accounts.contains("acc1") }}")

    println("Cleaned Version ${data.filterNotNull().flatMap { it }}")

    val csv = listOf("1,2,3", "4,5", "6")

    val updatedList = csv.flatMap {
        it.split(",").map { it.toIntOrNull() }
    }
    println("UpdatedList ${updatedList}")

    val flowOfNames  = flowOf("Abc","Kba")
    runBlocking {
        println(flowOfNames.map { it.uppercase() }.collect {
            println(it)
        })
    }


}


fun returnSquare(input : Flow<List<Int>>) : Flow<List<Int>> {
    return input.map {
        it.map{it*it}
    }
}

data class Accounts(
        val accounts : List<String>
        )


