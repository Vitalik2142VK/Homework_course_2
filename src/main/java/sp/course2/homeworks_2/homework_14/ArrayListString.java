package sp.course2.homeworks_2.homework_14;

import sp.course2.homeworks_2.homework_14.exceptions.GoingOutsideArrayException;
import sp.course2.homeworks_2.homework_14.exceptions.NotFindElementException;

public class ArrayListString implements ListString{
    private String[] array;
    private int size = 0;

    public ArrayListString() {
        array = new String[5];
    }

    public ArrayListString(int length) {
        //if (length <= 0) исключение если length <= 0
        array = new String[length];
    }

    public ArrayListString(String item) {
        this();

        if (item == null) throw new NullPointerException();

        array[0] = item;
        size++;
    }

    public ArrayListString(String item, int length) {
        this(length);

        if (item == null) throw new NullPointerException();

        array[0] = item;
        size++;
    }

    public ArrayListString(String[] items) {
        for (String item : items) {
            if (item == null) throw new NullPointerException();
        }

        array = new String[items.length + 5];
        System.arraycopy(items, 0 , array, 0, items.length);
        this.size = items.length;
    }

    public ArrayListString(String[] items, int length) {
        for (String item : items) {
            if (item == null) throw new NullPointerException();
        }
        //if (length <= 0) исключение если length <= 0

        array = new String[items.length + length];
        System.arraycopy(items, 0 , array, 0, items.length);
        this.size = items.length;
    }

    @Override
    public String add(String item) {
        if (item == null) throw new NullPointerException();

        if (size == array.length)
            addAdditionalCells(5);

        array[size++] = item;
        return array[size - 1];
    }

    @Override
    public String add(int index, String item) {
        if (item == null) throw new NullPointerException();
        if (index > size || index < 0) throw new GoingOutsideArrayException("Попытка выхода за пределы массива!");

        if (size == array.length)
            addAdditionalCells(5);

        for (int i = size; i >= index; i--) {
            if (i == index) {
                array[i] = item;
                break;
            }
            array[i] = array[i - 1];
        }
        size++;
        return array[index];
    }

    @Override
    public String set(int index, String item) {
        if (item == null) throw new NullPointerException();
        if (index > size || index < 0) throw new GoingOutsideArrayException("Попытка выхода за пределы массива!");
        array[index] = item;
        return array[index];
    }

    @Override
    public String remove(String item) {
        if (item == null) throw new NullPointerException();

        String remove = null;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                remove = array[i];
                size--;

                for (int j = i; j < size; j++) {
                    array[j] = array[j+1];
                    array[j+1] = null;
                }

                return remove;
            }
        }
        throw new NotFindElementException("Элемент не найден!");
    }

    @Override
    public String remove(int index) {
        if (index > size || index < 0) throw new GoingOutsideArrayException("Попытка выхода за пределы массива!");

        String remove = array[index];
        size--;
        for (int i = index; i < size; i++) {
            array[i] = array[i+1];
        }
        array[size] = null;

        return remove;
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size-1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index > size || index < 0) throw new GoingOutsideArrayException("Попытка выхода за пределы массива!");

        return array[index];
    }

    @Override
    public boolean equals(final ListString otherList) {
        if (otherList == null) throw new NullPointerException();
        if (this == otherList) return true;
        if (this.size != otherList.size()) return false;
        String[] otherArray = otherList.toArray();
        for (int i = 0; i < size; i++) {
            if (!array[i].equals(otherArray[i])) return false;
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size > 0;
    }

    @Override
    public void clear() {
        array = new String[5];
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] result = new String[size];
        System.arraycopy(array, 0, result, 0, size);
        return result;
    }

    //Доп. методы
    public void addAdditionalCells(int addCells) {
        if (addCells <= 0) return;
        String[] newList = new String[array.length + addCells];
        System.arraycopy(array, 0, newList, 0, array.length);
        array = newList;
    }

    public void removeAdditionalCells() {
        String[] newList = new String[size];
        System.arraycopy(array, 0, newList, 0, size);
        array = newList;
    }
}
