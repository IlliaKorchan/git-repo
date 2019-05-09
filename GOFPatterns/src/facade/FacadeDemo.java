package facade;

public class FacadeDemo {
    public static void main(String[] args) {
        Computer computer = new Computer();

        computer.copy();
    }
}

class Computer {
    Power power = new Power();
    DVDRom dvd = new DVDRom();
    HDD hdd = new HDD();

    void copy() {
        power.on();
        dvd.load();
        hdd.copyFromDisk(dvd);
    }
}

class Power {
    void on() {
        System.out.println("Включение питания");
    }

    void off() {
        System.out.println("Отключение питания");
    }
}

class DVDRom {
    private boolean hasData = false;

    public boolean hasData() {
        return hasData;
    }

    public void load() {
        hasData = true;
    }

    public void unload() {
        hasData = false;
    }
}

class HDD {
    public void copyFromDisk(DVDRom dvd) {
        if(dvd.hasData()) {
            System.out.println("Копирование данных");
        } else {
            System.out.println("Вставьте диск с данными");
        }
    }
}


