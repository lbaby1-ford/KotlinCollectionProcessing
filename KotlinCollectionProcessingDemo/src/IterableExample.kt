import kotlin.system.measureTimeMillis

fun main() {
    val list = List(1000) { it }
    val result = measureTimeMillis {
        list.filter {
            println("filter $it")
            it % 2 == 1
        }
            .map {
                println("map $it")
                it * 2
            }
            //.takeWhile { it < 100 }
            .average()
    }
    print("$result  ms")
}