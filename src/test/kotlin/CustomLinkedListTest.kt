import org.example.data_structures.CustomLinkedList
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

class CustomLinkedListTest {
    @Test
    fun testAddAndGet() {
        val list = CustomLinkedList<Int>()
        list.add(10)
        list.add(20)
        list.add(30)

        assertEquals(3, list.size, "Размер списка после добавления элементов")
        assertEquals(10, list.get(0), "Первый элемент должен быть 10")
        assertEquals(20, list.get(1), "Второй элемент должен быть 20")
        assertEquals(30, list.get(2), "Третий элемент должен быть 30")
    }
    @Test
    fun testGetInvalidIndex() {
        val list = CustomLinkedList<Int>()
        list.add(1)
        assertThrows<IllegalArgumentException> { list.get(-1) }
        assertThrows<IllegalArgumentException> { list.get(1) }
    }

    @Test
    fun testDelete() {
        val list = CustomLinkedList<Int>()
        list.add(10)
        list.add(20)
        list.add(30)

        list.delete(1)
        assertEquals(2, list.size)
        assertEquals(10, list.get(0))
        assertEquals(30, list.get(1))

        list.delete(0)
        assertEquals(1, list.size)
        assertEquals(30, list.get(0))

        list.delete(0)
        assertEquals(0, list.size)
        assertThrows<IllegalArgumentException> { list.get(0) }
    }

    @Test
    fun testDeleteInvalidIndex() {
        val list = CustomLinkedList<Int>()
        assertThrows<IllegalArgumentException> { list.delete(0) }
        list.add(1)
        assertThrows<IllegalArgumentException> { list.delete(1) }
        assertThrows<IllegalArgumentException> { list.delete(-1) }
    }
}