import kotlin.system.measureNanoTime

fun List<Int>.filterNonInline(destination: ArrayList<Int>, predicate: (Int) -> Boolean) {
    for (element in this) if (predicate(element)) destination.add(element)
}

inline fun <T> Iterable<T>.filterInline(destination: ArrayList<T>, predicate: (T) -> Boolean) {
    for (element in this) if (predicate(element)) destination.add(element)
}

fun main() {
    val list = List(50) { it }
    val oddList = arrayListOf<Int>()
    val timeTaken = measureNanoTime {
        // Classic way of doing filtering
//        for (element in list) {
//            if (element % 2 == 1) {
//                oddList.add(element)
//            }
//        }
        //non inline higher order function
        //list.filterNonInline(oddList) { it % 2 == 1 }

        //inline function
        list.filterInline(oddList) { it % 2 == 1 }
    }
    print("$timeTaken ns")
    print(oddList)
}