package iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        Tasks concreteAggregate = new Tasks();
        Iterator iterator = concreteAggregate.getIterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }
}

interface Iterator {
    boolean hasNext();
    Object next();
}

interface Container {
    Iterator getIterator();
}

class Tasks implements Container {
    String[] tasks = {"Построить дом", "Вырастить сына", "Посадить дерево"};
    public Iterator getIterator() {
        return new TaskIterator();
    }

    private class TaskIterator implements Iterator {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < tasks.length;
        }

        @Override
        public Object next() {
            return tasks[index++];
        }
    }
}
