import org.example.data_structures.CustomLinkedList
import org.example.data_structures.CustomList
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows

class CustomListTest {

    private lateinit var list: CustomList<Int>

    @BeforeEach
    fun setup() {
        list = CustomLinkedList()
    }

    @Test
    fun `addLast adds elements in correct order`() {
        list.addLast(1)
        list.addLast(2)
        list.addLast(3)

        assertEquals(1, list.get(0))
        assertEquals(2, list.get(1))
        assertEquals(3, list.get(2))
    }

    @Test
    fun `addFirst adds elements to beginning`() {
        list.addFirst(2)
        list.addFirst(1)

        assertEquals(1, list.get(0))
        assertEquals(2, list.get(1))
    }

    @Test
    fun `add at index inserts correctly in middle`() {
        list.addLast(1)
        list.addLast(3)

        list.add(2, 1)

        assertEquals(1, list.get(0))
        assertEquals(2, list.get(1))
        assertEquals(3, list.get(2)) //Тут не проходит
    }

    @Test
    fun `removeFirst removes first element`() {
        list.addLast(1)
        list.addLast(2)

        list.removeFirst()

        assertEquals(2, list.get(0))
        assertThrows<IllegalArgumentException> {
            list.get(1)
        }
    }

    @Test
    fun `removeLast removes last element`() {
        list.addLast(1)
        list.addLast(2)

        list.removeLast()

        assertEquals(1, list.get(0))
        assertThrows<IllegalArgumentException> {
            list.get(1)
        }
    }

    @Test
    fun `remove at index removes correct element`() {
        list.addLast(1)
        list.addLast(2)
        list.addLast(3)

        list.remove(1)

        assertEquals(1, list.get(0))
        assertEquals(3, list.get(1))
        assertThrows<IllegalArgumentException> {
            list.get(2)
        }
    }

    @Test
    fun `set replaces element at index`() {
        list.addLast(1)
        list.set(0, 10)

        assertEquals(10, list.get(0))
    }

    @Test
    fun `get with invalid index throws exception`() {
        list.addLast(1)
        assertThrows<IllegalArgumentException> { list.get(1) }
        assertThrows<IllegalArgumentException> { list.get(-1) }
    }

    @Test
    fun `remove with invalid index throws exception`() {
        list.addLast(1)
        assertThrows<IllegalArgumentException> { list.remove(5) }
        assertThrows<IllegalArgumentException> { list.remove(-1) }
    }

    @Test
    fun `add with invalid index throws exception`() {
        assertThrows<IllegalArgumentException> { list.add(10, 1) }
        assertThrows<IllegalArgumentException> { list.add(10, -1) }
    }

    @Test
    fun `removeFirst on empty list throws`() {
        assertThrows<IllegalStateException> { list.removeFirst() }
    }

    @Test
    fun `removeLast on empty list throws`() {
        assertThrows<IllegalStateException> { list.removeLast() }
    }
}