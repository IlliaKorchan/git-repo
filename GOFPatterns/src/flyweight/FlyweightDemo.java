package flyweight;

import java.util.*;

public class FlyweightDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        List<Shape> shapes = new ArrayList<>();

        shapes.add(shapeFactory.getShape("квадрат"));
        shapes.add(shapeFactory.getShape("круг"));
        shapes.add(shapeFactory.getShape("треугольник"));
        shapes.add(shapeFactory.getShape("треугольник"));
        shapes.add(shapeFactory.getShape("квадрат"));
        shapes.add(shapeFactory.getShape("круг"));
        shapes.add(shapeFactory.getShape("квадрат"));

        Random random = new Random();
        for (Shape shape : shapes) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            shape.draw(x, y);
        }
    }
}

interface Shape {
    void draw(int x, int y);
}

class Circle implements Shape {
    int radius = 5;
    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + ", " + y + ") Рисуем круг с радиусом " + radius);
    }
}

class Square implements Shape {
    int length = 10;
    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + ", " + y + ") Рисуем квадрат со стороной " + 10);
    }
}

class Triangle implements Shape {
    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + ", " + y + ") Рисуем треугольник");
    }
}

class ShapeFactory {
    private Map<String, Shape> shapes = new HashMap<>();

    public Shape getShape(String shapeName) {
        Shape shape = shapes.get(shapeName);
        if(shape == null) {
            switch(shapeName) {
                case "круг": {
                    shape = new Circle();
                    break;
                }
                case "квадрат": {
                    shape = new Square();
                    break;
                }
                case "треугольник": {
                    shape = new Triangle();
                    break;
                }
            }
            shapes.put(shapeName, shape);
        }
        return shape;
    }
}
