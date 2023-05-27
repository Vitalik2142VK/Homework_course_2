package sp.course2.homeworks_2.homework_14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sp.course2.homeworks_2.homework_14.exceptions.GoingOutsideArrayException;
import sp.course2.homeworks_2.homework_14.exceptions.NotFindElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListStringTest {
    private ArrayListString arrayListString;
    private String[] strArr;

    @BeforeEach
    public void setUp() {
        strArr = new String[]{"String_1", "String_2", "String_3"};

        arrayListString = new ArrayListString(strArr);
    }

    @Test
    public void add() {
        String str = "String";
        assertEquals(str, arrayListString.add(str));
        assertThrows(NullPointerException.class, () -> {
            arrayListString.add(null);
        });
    }

    @Test
    public void addWithIndex() {
        String str = "String";
        assertEquals(str, arrayListString.add(str));

        str = "Попытка выхода за пределы массива!";
        try {
            arrayListString.add(-1, "String");
        } catch (GoingOutsideArrayException ex) {
            assertEquals(str, ex.getMessage());
        }

        assertThrows(NullPointerException.class, () -> {
            arrayListString.add(1, null);
        });
    }

    @Test
    public void set() {
        String str = "Попытка выхода за пределы массива!";
        try {
            arrayListString.set(-1, "String");
        } catch (GoingOutsideArrayException ex) {
            assertEquals(str, ex.getMessage());
        }

        assertThrows(NullPointerException.class, () -> {
            arrayListString.set(1, null);
        });

        str = "newString";
        assertEquals(str, arrayListString.set(1, str));
    }

    @Test
    public void remove() {
        String str = "Элемент не найден!";
        try {
            arrayListString.remove("String");
        } catch (NotFindElementException ex) {
            assertEquals(str, ex.getMessage());
        }

        assertThrows(NullPointerException.class, () -> {
            arrayListString.remove(null);
        });

        str = "String_2";
        assertEquals(str, arrayListString.remove(str));
        assertEquals(2, arrayListString.size());
    }

    @Test
    public void removeForIndex() {
        String str = "Попытка выхода за пределы массива!";
        try {
            arrayListString.set(-1, "String");
        } catch (GoingOutsideArrayException ex) {
            assertEquals(str, ex.getMessage());
        }

        str = "String_2";
        assertEquals(str, arrayListString.remove(1));
        assertEquals(2, arrayListString.size());
    }

    @Test
    public void contains() {
        assertTrue(arrayListString.contains("String_2"));
    }

    @Test
    public void indexOf() {
        assertEquals(2, arrayListString.indexOf("String_3"));
    }

    @Test
    public void lastIndexOf () {
        assertEquals(0, arrayListString.lastIndexOf("String_1"));
    }

    @Test
    public void get() {
        assertThrows(GoingOutsideArrayException.class, () -> {
            arrayListString.get(10);
        });
        assertEquals("String_1", arrayListString.get(0));
    }

    @Test
    public void equals() {
        assertThrows(NullPointerException.class, () -> {
            arrayListString.equals(null);
        });

        ListString newListString = new ArrayListString(strArr);

        assertTrue(arrayListString.equals(newListString));
    }

    @Test
    public void size() {
        assertEquals(3, arrayListString.size());
    }

    @Test
    public void isEmpty() {
        ListString listString = new ArrayListString();
        assertFalse(listString.isEmpty());
        assertTrue(arrayListString.isEmpty());
    }

    @Test
    public void clear() {
        arrayListString.clear();
        assertFalse(arrayListString.isEmpty());
    }

    @Test
    public void toArray() {
        String[] as = arrayListString.toArray();
        assertArrayEquals(as, arrayListString.toArray());
        assertNotSame(as, arrayListString.toArray());
    }
}
