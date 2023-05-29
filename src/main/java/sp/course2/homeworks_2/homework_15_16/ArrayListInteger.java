package sp.course2.homeworks_2.homework_15_16;

import sp.course2.homeworks_2.homework_14.exceptions.GoingOutsideArrayException;
import sp.course2.homeworks_2.homework_14.exceptions.NotFindElementException;

public class ArrayListInteger implements ListInteger{
    private Integer[] array;
    private int size = 0;

    public ArrayListInteger() {
        array = new Integer[5];
    }

    public ArrayListInteger(int length) {
        if (length <= 0) throw new GoingOutsideArrayException("length - должен быть больше 0");
        array = new Integer[length];
    }

    public ArrayListInteger(Integer item) {
        this();

        if (item == null) throw new NullPointerException();

        array[0] = item;
        size++;
    }

    public ArrayListInteger(Integer item, int length) {
        this(length);

        if (item == null) throw new NullPointerException();

        array[0] = item;
        size++;
    }

    public ArrayListInteger(Integer[] items) {
        for (Integer item : items) {
            if (item == null) throw new NullPointerException();
        }

        array = new Integer[items.length + 5];
        System.arraycopy(items, 0 , array, 0, items.length);
        this.size = items.length;
    }

    public ArrayListInteger(Integer[] items, int length) {
        for (Integer item : items) {
            if (item == null) throw new NullPointerException();
        }
        if (length <= 0) throw new GoingOutsideArrayException("length - должен быть больше 0");

        array = new Integer[items.length + length];
        System.arraycopy(items, 0 , array, 0, items.length);
        this.size = items.length;
    }

    @Override
    public Integer add(Integer item) {
        if (item == null) throw new NullPointerException();

        if (size == array.length)
            grow();

        array[size++] = item;
        return array[size - 1];
    }

    @Override
    public Integer add(int index, Integer item) {
        if (item == null) throw new NullPointerException();
        if (index > size || index < 0) throw new GoingOutsideArrayException("Попытка выхода за пределы массива!");

        if (size == array.length)
            grow();

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
    public Integer set(int index, Integer item) {
        if (item == null) throw new NullPointerException();
        if (index > size || index < 0) throw new GoingOutsideArrayException("Попытка выхода за пределы массива!");
        array[index] = item;
        return array[index];
    }

    @Override
    public Integer remove(Integer item) {
        if (item == null) throw new NullPointerException();

        Integer remove = null;
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
    public Integer remove(int index) {
        if (index > size || index < 0) throw new GoingOutsideArrayException("Попытка выхода за пределы массива!");

        Integer remove = array[index];
        size--;
        for (int i = index; i < size; i++) {
            array[i] = array[i+1];
        }
        array[size] = null;

        return remove;
    }

    @Override
    public boolean contains(Integer item) {
        sort();
        int min = 0, max = size - 1, mid;

        while (min <= max && min >= 0) {
            mid = (min + max) / 2;

            if (array[mid].equals(item))
                return true;

            if (item < array[mid])
                min--;
            else
                min++;
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size-1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index > size || index < 0) throw new GoingOutsideArrayException("Попытка выхода за пределы массива!");

        return array[index];
    }

    @Override
    public boolean equals(final ListInteger otherList) {
        if (otherList == null) throw new NullPointerException();
        if (this == otherList) return true;
        if (this.size != otherList.size()) return false;
        Integer[] otherArray = otherList.toArray();
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
        array = new Integer[5];
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        Integer[] result = new Integer[size];
        System.arraycopy(array, 0, result, 0, size);
        return result;
    }

    //Доп. методы
    private void grow() {
        Integer[] newList = new Integer[array.length + (int)(array.length * 1.5)];
        System.arraycopy(array, 0, newList, 0, array.length);
        array = newList;
    }

    private void removeAdditionalCells() {
        Integer[] newList = new Integer[size];
        System.arraycopy(array, 0, newList, 0, size);
        array = newList;
    }

    //Метод сортировки
    private void sort() {
//        int minInx;
//        for (int i = 0; i < size - 1; i++) {
//            minInx = i;
//            for (int j = i + 1; j < size; j++) {
//                if (array[j] < array[minInx])
//                    minInx = j;
//            }
//            swapElements(array, i, minInx);
//        }

        quickSort(array, 0, size - 1);
    }

    private void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }


    private void swapElements(Integer[] arr, int num1, int num2) {
        int temp = array[num2];
        array[num2] = array[num1];
        array[num1] = temp;
    }
}
