package visitor;

public class VisitorDemo {
    public static void main(String[] args) {
        Element car = new CarElement();
        Visitor mechanic = new MechanicVisitor();
        Visitor hooligan = new HooliganVisitor();

        car.accept(mechanic);
        System.out.println();
        car.accept(hooligan);
    }
}

interface Visitor {
    void visit(EngineElement element);
    void visit(BodyElement element);
    void visit(WheelElement element);
    void visit(CarElement element);
}

interface Element {
    void accept(Visitor visitor);
}

class EngineElement implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class BodyElement implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class WheelElement implements Element {
    private String name;

    public WheelElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class CarElement implements Element {
    Element[] elements;

    public CarElement() {
        this.elements = new Element[]{new WheelElement("переднее левое"), new WheelElement("заднее левое"),
                new WheelElement("переднее правое"), new WheelElement("заднее правое"), new BodyElement(),
        new EngineElement()};
    }

    @Override
    public void accept(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
        visitor.visit(this);
    }
}

class HooliganVisitor implements Visitor {
    @Override
    public void visit(EngineElement element) {
        System.out.println("Завёл двигатель");
    }

    @Override
    public void visit(BodyElement element) {
        System.out.println("Постучал по кузову");
    }

    @Override
    public void visit(WheelElement element) {
        System.out.println("Пнул " + element.getName() + " колесо");
    }

    @Override
    public void visit(CarElement element) {
        System.out.println("Покурил внутри машины");
    }
}

class MechanicVisitor implements Visitor {
    @Override
    public void visit(EngineElement element) {
        System.out.println("Проверил двигатель");
    }

    @Override
    public void visit(BodyElement element) {
        System.out.println("Отполировал кузов");
    }

    @Override
    public void visit(WheelElement element) {
        System.out.println("Подкачал " + element.getName() + " колесо");
    }

    @Override
    public void visit(CarElement element) {
        System.out.println("Проверил внешний вид автомобиля");
    }
}
