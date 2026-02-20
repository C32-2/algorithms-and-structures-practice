package org.example.data_structures

interface CustomList<T> {
    fun addLast(data: T)
    fun addFirst(data: T)
    fun add(data: T, index: Int)
    fun removeLast()
    fun removeFirst()
    fun remove(index: Int)
    fun get(index: Int): T
    fun set(index: Int, data: T)
}

class CustomLinkedList<T> : CustomList<T> {

    private class Node<T>(var data: T, var next: Node<T>? = null)

    private var head: Node<T>? = null
    private var _size = 0

    val size: Int
        get() = _size

    override fun addLast(data: T) {
        val newNode = Node(data)
        if (head == null) {
            head = newNode
        } else {
            var current = head
            while (current!!.next != null) {
                current = current.next
            }
            current.next = newNode
        }
        _size++
    }

    override fun addFirst(data: T) {
        head = Node(data, head)
        _size++
    }

    override fun add(data: T, index: Int) {
        require(index in 0.._size) { "Invalid index: $index" }

        when (index) {
            0 -> addFirst(data)
            _size -> addLast(data)
            else -> {
                var prev = head!!
                for (i in 0 until index - 1) {
                    prev = prev.next!!
                }
                prev.next = Node(data, prev.next)
                _size++
            }
        }
    }

    override fun removeFirst() {
        if (head == null) throw IllegalStateException("Cannot remove from empty list")
        head = head!!.next
        _size--
    }

    override fun removeLast() {
        if (head == null) throw IllegalStateException("Cannot remove from empty list")
        if (head!!.next == null) {
            head = null
        } else {
            var prev = head
            var current = head!!.next
            while (current!!.next != null) {
                prev = current
                current = current.next
            }
            prev!!.next = null
        }
        _size--
    }

    override fun remove(index: Int) {
        require(index in 0 until _size) { "Invalid index: $index" }

        if (index == 0) {
            removeFirst()
        } else {
            var prev = head!!
            for (i in 0 until index - 1) {
                prev = prev.next!!
            }
            prev.next = prev.next!!.next
            _size--
        }
    }

    override fun get(index: Int): T {
        require(index in 0 until _size) { "Invalid index: $index" }

        var current = head!!
        for (i in 0 until index) {
            current = current.next!!
        }
        return current.data
    }

    override fun set(index: Int, data: T) {
        require(index in 0 until _size) { "Invalid index: $index" }

        var current = head!!
        for (i in 0 until index) {
            current = current.next!!
        }
        current.data = data
    }

    override fun toString(): String {
        val sb = StringBuilder("[")
        var current = head
        while (current != null) {
            sb.append(current.data)
            current = current.next
            if (current != null) sb.append(", ")
        }
        sb.append("]")
        return sb.toString()
    }
}