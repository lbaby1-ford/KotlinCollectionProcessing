import kotlin.system.measureTimeMillis

fun main() {
    val seq = generateSequence(0) { it + 1 }
        .take(1000)
    val result = measureTimeMillis {
        seq.filter {
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
    print("$result ms")
}