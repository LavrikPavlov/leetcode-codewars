package ru.kazan.arrays

import ru.kazan.arrays.enums.Person
import java.util.stream.Collectors
import kotlin.random.Random

fun main() {
    secondMethod()
    println("------------------------")
    firstMethod(20)
    println("------------------------")
    thirdMethod()
}

private fun firstMethod(max: Int) {
    var i = 1
    var sum = 0
    val set = HashSet<Int>()

    for (i in 1..max)
        set.add(Random.nextInt(1, max))

    while (i <= max) {
        print("Попытка номер: $i")

        if (set.contains(i)) {
            print(".... неудача \n")
            set.remove(i)
            i--
        } else
            print("\n")

        i++
        sum++
        Thread.sleep(100)
    }
    println("Общее количество попыток $sum")
}

private fun secondMethod() {
    val list = ArrayList<Int>()
    for (i in 1..20) {
        list.add(Random.nextInt(1, 20))
    }
    println(list.joinToString(","))
    println("Уникальные значения")
    println(list.stream().collect(Collectors.toSet()).joinToString(", "))
}

private fun thirdMethod() {
    val map = HashMap<String, Int>();
    for (name in Person.values())
        map.put(name.get(), Random.nextInt(1, 80))

    println("Список:")
    printMap(map)
    println("\nОтсортированый по имени:")
    printMap(map.toSortedMap())
    println("\nОтсортированный по возсравсту:")
    printMap(map.toList().sortedBy {
        it.second
    }.toMap())

}

private fun printMap(map: Map<String, Int>) {
    println(map.entries.joinToString("\n"));
}

