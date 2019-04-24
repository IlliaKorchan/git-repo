package model.list;

public interface SimpleList<E> extends Iterable<E> {
    boolean add(E element);
    E get(int index);
    int size();
    boolean set(int index, E element);
}
