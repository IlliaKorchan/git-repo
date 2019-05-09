package composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeDemo {
    public static void main(String[] args) {
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.addComponent(new Circle());
        composite1.addComponent(new Square());
        composite1.addComponent(new Triangle());

        composite2.addComponent(new Triangle());
        composite2.addComponent(new Circle());
        composite2.addComponent(new Triangle());
        composite2.addComponent(new Square());

        Composite composite3 = new Composite();
        composite3.addComponent(composite1);
        composite3.addComponent(composite2);
        composite3.addComponent(composite3);

        composite3.draw();
    }
}

interface Shape {
    void draw();
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Draw square!");
    }
}

class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Draw triangle!");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Draw circle!");
    }
}

class Composite implements Shape {
    List<Shape> components = new ArrayList<>();

    public void addComponent(Shape component) {
        components.add(component);
    }

    public void removeComponent(Shape component) {
        components.remove(component);
    }

    @Override
    public void draw() {
        for (Shape component : components) {
            component.draw();
        }
    }
}