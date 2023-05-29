package sp.course2.homeworks_2.homework_15_16;

public interface ListInteger {
    Integer add(Integer item);

    Integer add(int index, Integer item);

    Integer set(int index, Integer item);

    Integer remove(Integer item);

    Integer remove(int index);

    boolean contains(Integer item);

    int indexOf(Integer item);

    int lastIndexOf(Integer item);

    Integer get(int index);

    boolean equals(ListInteger otherList);

    int size();

    boolean isEmpty();

    void clear();

    Integer[] toArray();
}
