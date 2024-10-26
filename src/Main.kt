fun main() {
    println("Введите элементы первого массива (через пробел):")
    val firstArray = readLine()?.split(" ")?.map { it.toInt() } ?: return

    println("Введите элементы второго массива (через пробел):")
    val secondArray = readLine()?.split(" ")?.map { it.toInt() } ?: return

    val intersection = findIntersection(firstArray, secondArray)
    println("Пересечение массивов: $intersection")
}
fun findIntersection(arr1: List<Int>, arr2: List<Int>): List<Int> {
    val countMap1 = mutableMapOf<Int, Int>()
    val countMap2 = mutableMapOf<Int, Int>()

    for (num in arr1) {
        countMap1[num] = countMap1.getOrDefault(num, 0) + 1
    }
    for (num in arr2) {
        countMap2[num] = countMap2.getOrDefault(num, 0) + 1
    }

    val result = mutableListOf<Int>()
    for (key in countMap1.keys) {
        if (countMap2.containsKey(key)) {
            val minCount = minOf(countMap1[key]!!, countMap2[key]!!)
            result.addAll(List(minCount) { key })
        }
    }
    return result
}