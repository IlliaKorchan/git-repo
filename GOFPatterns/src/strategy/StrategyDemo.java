package strategy;

import java.util.Arrays;

public class StrategyDemo {
    public static void main(String[] args) {
        StrategyClient client = new StrategyClient();

        int[] arr1 = {1,623,893,83};
        client.setStrategy(new BubbleSorting());
        client.executeStrategy(arr1);

        int[] arr2 = {1,623,893,83};
        client.setStrategy(new SelectionSorting());
        client.executeStrategy(arr2);

        int[] arr3 = {1,623,893,83};
        client.setStrategy(new InsertingSorting());
        client.executeStrategy(arr3);
    }
}

class StrategyClient {
    Sorting strategy;

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int[] array) {
        strategy.sort(array);
    }
}

interface Sorting {
    void sort(int[] array);
}

class BubbleSorting implements Sorting {
    @Override
    public void sort(int[] array) {
        System.out.println("Сортировка пузырьком");
        System.out.println("До: " + Arrays.toString(array));
        for(int barier = array.length - 1; barier >= 0; barier--) {
            for (int i = 0; i < barier; i++) {
                if (array[i] > array[i+1]) {
                   int tmp = array[i];
                   array[i] = array[i + 1];
                   array[i + 1] = tmp;
                }
            }
        }
        System.out.println("После: " + Arrays.toString(array));
    }
}

class SelectionSorting implements Sorting {
    @Override
    public void sort(int[] array) {
        System.out.println("Сортировка выборками");
        System.out.println("До: " + Arrays.toString(array));
        for(int barier = 0; barier < array.length - 1; barier++) {
            for (int i = barier + 1; i < array.length; i++) {
                if (array[i] < array[barier]) {
                   int tmp = array[i];
                   array[i] = array[barier];
                   array[barier] = tmp;
                }
            }
        }
        System.out.println("После: " + Arrays.toString(array));
    }
}

class InsertingSorting implements Sorting {
    @Override
    public void sort(int[] array) {
        System.out.println("Сортировка вставками");
        System.out.println("До: " + Arrays.toString(array));
        for(int barier = 1; barier < array.length; barier++) {
            int index = barier;
            while(index - 1 >= 0 && array[index] < array[index - 1]) {
                int tmp = array[index];
                array[index] = array[index - 1];
                array[index - 1] = tmp;
                index--;
            }
        }
        System.out.println("После: " + Arrays.toString(array));
    }
}

