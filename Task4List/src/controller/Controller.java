package controller;

import model.list.SimpleArrayList;
import model.list.SimpleIterator;
import model.list.SimpleList;
import view.View;

public class Controller {
    View view;

    public Controller(View view) {
        this.view = view;
    }

    public void showLists() {
        SimpleList<Integer> intList = new SimpleArrayList<>();
        SimpleList<String> stringList = new SimpleArrayList<>();

        for (int i = 0; i < 17; i++) {
            intList.add(i);
            stringList.add(i + " value");
        }

        SimpleIterator intIterator = (SimpleIterator) intList.iterator();
        SimpleIterator stringIterator = (SimpleIterator) stringList.iterator();

        view.print("Integer list values:\n");

        while(intIterator.hasNext()) {
            view.print(intIterator.next() + " ");
        }

        view.print("\nString list values:\n");

        while(stringIterator.hasNext()) {
            view.print(stringIterator.next() + " ");
        }
    }
}
