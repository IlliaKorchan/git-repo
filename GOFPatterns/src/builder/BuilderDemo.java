package builder;

public class BuilderDemo {
    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new FerrariBuilder());
        Car car = director.buildCar();

        System.out.println(car);
    }
}

enum Transmission {
    MANUAL, AUTO
}

class Car {
    String mark;
    Transmission transmission;
    int maxSpeed;

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "mark='" + mark + '\'' +
                ", transmission=" + transmission +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

abstract class CarBuilder {
    Car car;

    public void createCar() {
        car = new Car();
    }

    abstract void buildMark();
    abstract void buildTransmission();
    abstract void buildMaxSpeed();

    public Car getCar() {
        return car;
    }
}

class MercedesBuilder extends CarBuilder {
    @Override
    void buildMark() {
        car.setMark("Mercedes");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.AUTO);
    }

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeed(250);
    }
}

class AudiBuilder extends CarBuilder {
    @Override
    void buildMark() {
        car.setMark("Audi");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.AUTO);
    }

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeed(250);
    }
}

class FerrariBuilder extends CarBuilder {
    @Override
    void buildMark() {
        car.setMark("Ferrari");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.MANUAL);
    }

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeed(315);
    }
}

class Director {
    CarBuilder builder;

    public void setBuilder(CarBuilder builder) {
        this.builder = builder;
    }

    Car buildCar() {
        builder.createCar();
        builder.buildMark();
        builder.buildTransmission();
        builder.buildMaxSpeed();
        return builder.getCar();
    }
}



