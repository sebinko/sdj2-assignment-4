package utility.collection;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {
    private ArrayList<Integer> list;

    @Before
    public void setUp() {
        list = new ArrayList<>();
    }

    @Test
    public void testAddAndGet() {
        list.add(0, 1);
        assertEquals(Integer.valueOf(1), list.get(0));
    }

    @Test
    public void testSet() {
        list.add(0, 1);
        list.set(0, 2);
        assertEquals(Integer.valueOf(2), list.get(0));
    }

    @Test
    public void testRemoveByIndex() {
        list.add(0, 1);
        assertEquals(Integer.valueOf(1), list.remove(0));
        assertTrue(list.isEmpty());
    }

    @Test
    public void testRemoveByElement() {
        list.add(0, 1);
        assertEquals(Integer.valueOf(1), list.remove(Integer.valueOf(1)));
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIndexOf() {
        list.add(0, 1);
        assertEquals(0, list.indexOf(1));
    }

    @Test
    public void testContains() {
        list.add(0, 1);
        assertTrue(list.contains(1));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(0, 1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testIsFull() {
        assertTrue(list.isFull());
    }

    @Test
    public void testSize() {
        assertEquals(0, list.size());
        list.add(0, 1);
        assertEquals(1, list.size());
    }
}