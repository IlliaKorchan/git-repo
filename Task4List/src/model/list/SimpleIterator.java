package model.list;

import java.util.Iterator;

public class SimpleIterator<E> implements Iterator<E> {
    private int index = 0;
    private SimpleList<E> list;

    public SimpleIterator(SimpleList<E> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public E next() {
        return list.get(index++);
    }
}
