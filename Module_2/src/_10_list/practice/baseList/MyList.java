package _10_list.practice.baseList;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add( E element) {
        if( size == elements.length) {
            ensureCapa();
        }
        elements[size] = element;
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public Object get(int index) {
        //if (index>= size || index <0) throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        return elements[index];
    }
}
