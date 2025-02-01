package ru.kazan.arrays.enums

enum class Person(val fullName: String) {
    JOHN("John"),
    JANE("Jane"),
    MIKE("Mike"),
    EMILY("Emily"),
    DAVID("David"),
    SARAH("Sarah"),
    PETER("Peter"),
    LUCY("Lucy");

    fun get(): String {
        return fullName
    }
}
