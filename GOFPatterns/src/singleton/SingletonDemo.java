package singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        final int SIZE = 1000;
        Thread[] threads = new Thread[SIZE];

        for (int i = 0; i < SIZE; i++) {
            threads[i] = new Thread(new R());
            threads[i].start();
        }
        for (int i = 0; i < SIZE; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Singleton.counter);
    }
}

class R implements Runnable {
    @Override
    public void run() {
        Singleton.getInstance();
    }
}

class Singleton {
    private static final Object sync = new Object();
    public static int counter = 0;
    private static volatile Singleton instance = null;

    private Singleton() {
        counter++;
    }

    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (sync) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}