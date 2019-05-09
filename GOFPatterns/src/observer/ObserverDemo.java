package observer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ObserverDemo {
    public static void main(String[] args) {
        MeteoStation meteoStation = new MeteoStation();
        meteoStation.addObserver(new ConsoleObserver());
        meteoStation.addObserver(new FileObserver());

        meteoStation.setMeasurements(25, 760);
    }
}

interface Observer {
    void handleEvent(int temperature, int pressure);
}

interface Observable {
    void addObserver(Observer observer);
    void RemoveObserver(Observer observer);
    void notifyObservers();
}

class MeteoStation implements Observable {
    private int temperature;
    private int pressure;
    private List<Observer> observers = new ArrayList<>();

    public void setMeasurements(int temperature, int pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void RemoveObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.handleEvent(temperature, pressure);
        }
    }
}

class ConsoleObserver implements Observer {
    @Override
    public void handleEvent(int temperature, int pressure) {
        System.out.println("Погода изменилась. Температура " + temperature + " Давление " + pressure);
    }
}

class FileObserver implements Observer {
    @Override
    public void handleEvent(int temperature, int pressure) {
        File file = new File("FileObserver.txt");
        try {
            PrintWriter pw = new PrintWriter(file);
            pw.print("Погода изменилась. Температура " + temperature + ", Давление " + pressure + ".");
            pw.println();
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}