package bridge;

public class BridgeDemo {
    public static void main(String[] args) {
        Car car1 = new Sedan(new Kia());
        Car car2 = new Sedan(new Skoda());

        Car car3 = new Hatchback(new Kia());
        Car car4 = new Hatchback(new Skoda());
        Car car5 = new Hatchback(new Mercedes());

        car1.showDetails();
        car2.showDetails();
        car3.showDetails();
        car4.showDetails();
        car5.showDetails();
    }
}

abstract class Car {
    Manufacturer manufacturer;

    public Car(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    abstract void showType();

    public void showDetails() {
        showType();
        manufacturer.showManufacturer();
    }
}

class Sedan extends Car {
    public Sedan(Manufacturer manufacturer) {
        super(manufacturer);
    }

    public void showType() {
        System.out.println("Sedan");
    }
}

class Hatchback extends Car {
    public Hatchback(Manufacturer manufacturer) {
        super(manufacturer);
    }

    public void showType() {
        System.out.println("Hatchback");
    }
}

interface Manufacturer {
    void showManufacturer();
}

class Kia implements Manufacturer {
    public void showManufacturer() {
        System.out.println("Kia");
    }
}

class Skoda implements Manufacturer {
    public void showManufacturer() {
        System.out.println("Skoda");
    }
}

class Mercedes implements Manufacturer {
    public void showManufacturer() {
        System.out.println("Mercedes");
    }
}