package delegate;

public class DelegateDemo {
    public static void main(String[] args) {
        Painter painter = new Painter(new Circle());
        painter.draw();
    }
}

interface Graphics {
    void draw();
}

class Triangle implements Graphics {
    @Override
    public void draw() {
        System.out.println("Drawing triangle");
    }
}

class Circle implements Graphics {
    @Override
    public void draw() {
        System.out.println("Drawing circle");
    }
}

class Painter {
    Graphics component;

    public Painter(Graphics component) {
        this.component = component;
    }

    public void draw(){
        component.draw();
    }
}
