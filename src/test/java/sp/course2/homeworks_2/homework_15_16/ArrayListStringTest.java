package sp.course2.homeworks_2.homework_15_16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sp.course2.homeworks_2.homework_14.exceptions.GoingOutsideArrayException;
import sp.course2.homeworks_2.homework_14.exceptions.NotFindElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class ArrayListStringTest {
    private ArrayListInteger arrayListInteger;
    private Integer[] integersArr;

    @BeforeEach
    public void setUp() {
        integersArr = new Integer[]{1, 5, 10};

        arrayListInteger = new ArrayListInteger(integersArr);
    }

    @Test
    public void add() {
        Integer integer = 15;
        assertEquals(integer, arrayListInteger.add(integer));
        assertThrows(NullPointerException.class, () -> {
            arrayListInteger.add(null);
        });
    }

    @Test
    public void addWithIndex() {
        Integer integer = 50;
        assertEquals(integer, arrayListInteger.add(integer));

        String str = "Попытка выхода за пределы массива!";
        try {
            arrayListInteger.add(-1, 100);
        } catch (GoingOutsideArrayException ex) {
            assertEquals(str, ex.getMessage());
        }

        assertThrows(NullPointerException.class, () -> {
            arrayListInteger.add(1, null);
        });
    }

    @Test
    public void set() {
        String str = "Попытка выхода за пределы массива!";
        try {
            arrayListInteger.set(-1, 50);
        } catch (GoingOutsideArrayException ex) {
            assertEquals(str, ex.getMessage());
        }

        assertThrows(NullPointerException.class, () -> {
            arrayListInteger.set(1, null);
        });

        Integer integer = 20;
        assertEquals(integer, arrayListInteger.set(1, integer));
    }

    @Test
    public void remove() {
        String str = "Элемент не найден!";
        try {
            arrayListInteger.remove((Integer) 20);
        } catch (NotFindElementException ex) {
            assertEquals(str, ex.getMessage());
        }

        assertThrows(NullPointerException.class, () -> {
            arrayListInteger.remove(null);
        });

        Integer integer = 10;
        assertEquals(integer, arrayListInteger.remove(integer));
        assertEquals(2, arrayListInteger.size());
    }

    @Test
    public void removeForIndex() {
        String str = "Попытка выхода за пределы массива!";
        try {
            arrayListInteger.set(-1, 20);
        } catch (GoingOutsideArrayException ex) {
            assertEquals(str, ex.getMessage());
        }

        Integer integer = 5;
        assertEquals(integer, arrayListInteger.remove(1));
        assertEquals(2, arrayListInteger.size());
    }

    @Test
    public void contains() {
        assertTrue(arrayListInteger.contains(5));
        assertFalse(arrayListInteger.contains(20));
    }

    @Test
    public void indexOf() {
        assertEquals(2, arrayListInteger.indexOf(10));
        assertEquals(-1, arrayListInteger.indexOf(20));
    }

    @Test
    public void lastIndexOf () {
        assertEquals(0, arrayListInteger.lastIndexOf(1));
        assertEquals(-1, arrayListInteger.lastIndexOf(20));
    }

    @Test
    public void get() {
        assertThrows(GoingOutsideArrayException.class, () -> {
            arrayListInteger.get(10);
        });
        assertEquals(1, arrayListInteger.get(0));
    }

    @Test
    public void equals() {
        assertThrows(NullPointerException.class, () -> {
            arrayListInteger.equals(null);
        });

        ListInteger newListInteger = new ArrayListInteger(integersArr);

        assertTrue(arrayListInteger.equals(newListInteger));
    }

    @Test
    public void size() {
        assertEquals(3, arrayListInteger.size());
    }

    @Test
    public void isEmpty() {
        ListInteger listInteger = new ArrayListInteger();
        assertFalse(listInteger.isEmpty());
        assertTrue(arrayListInteger.isEmpty());
    }

    @Test
    public void clear() {
        arrayListInteger.clear();
        assertFalse(arrayListInteger.isEmpty());
    }

    @Test
    public void toArray() {
        Integer[] ai = arrayListInteger.toArray();
        assertArrayEquals(ai, arrayListInteger.toArray());
        assertNotSame(ai, arrayListInteger.toArray());
    }
}
