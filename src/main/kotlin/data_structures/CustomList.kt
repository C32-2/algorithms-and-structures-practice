package org.example.data_structures

interface CustomList<T> {
    fun add(data: T)
    fun get(index: Int): T?
    fun delete(index: Int)
}

class CustomLinkedList<T> : CustomList<T> {
    private class Node<T>(
        val data: T,
        var next: Node<T>? = null
    )

    private var head: Node<T>? = null
    var size = 0

    override fun add(data: T) {
        if (head == null) {
            head = Node(data, null)
            size++
            return
        }
        var node: Node<T>? = head
        while (node?.next != null) {
            node = node.next
        }
        node?.next = Node(data, null)
        size++
    }

    override fun get(index: Int): T? {
        require(index in 0 until size) { "Invalid index: $index" }
        var node = head
        var counter = 0
        while(counter < index) {
            node = node?.next
            counter++
        }
        return node?.data
    }

    override fun delete(index: Int) {
        require(index in 0 until size) { "Invalid index: $index" }
        if (index == 0) {
            head = head?.next
        } else {
            var node = head
            var counter = 0
            while(counter < index - 1) {
                node = node?.next
                counter++
            }
            node!!.next = node.next?.next
        }
        size--
    }

    override fun toString(): String {
        val sb = StringBuilder()
        var node = head
        sb.append("[")
        while(node != null) {
            sb.append(node.data.toString() + ", ")
            node = node.next
        }
        sb.append("]")
        return sb.toString()
    }
}