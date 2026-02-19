package org.example

import org.example.data_structures.CustomLinkedList

fun main() {
    val list = CustomLinkedList<String>()
    list.add("1")
    list.add("2")
    list.add("3")
    println(list.toString())
}