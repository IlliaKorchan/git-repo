package model.list;

import java.util.Iterator;

public class SimpleArrayList<E> implements SimpleList<E> {
    private E[] arrayList;
    private int lastIndex = 0;
    private int capacity = 10;

    public SimpleArrayList() {
        arrayList = (E[]) new Object[capacity];
    }

    public SimpleArrayList(int initialCapacity) {
        this.capacity = initialCapacity;
    }

    @Override
    public boolean add(E element) {
        if (lastIndex == capacity) {
            capacity = (capacity * 3) / 2 + 1;
            E[] temp = arrayList;
            try {
                arrayList = (E[]) new Object[capacity];
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            System.arraycopy(temp, 0, arrayList, 0, temp.length);
        }
        arrayList[lastIndex++] = element;
        return true;
    }

    @Override
    public E get(int index) {
        return arrayList[index];
    }

    @Override
    public int size() {
        return lastIndex;
    }

    @Override
    public boolean set(int index, Object element) {
        try {
            arrayList[index] = (E) element;
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }

    @Override
    public Iterator iterator() {
        return new SimpleIterator(this);
    }
}
