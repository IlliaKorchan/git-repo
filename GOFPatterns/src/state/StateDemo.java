package state;

public class StateDemo {
    public static void main(String[] args) {
        Human human = new Human();
        human.setState(new Work());
        for (int i = 0; i < 10; i++) {
            human.doSomething();
        }
    }
}

interface Activity {
    void doSomething(Human context);
}

class Human {
    private Activity state;

    public void setState(Activity state) {
        this.state = state;
    }

    public void doSomething() {
        state.doSomething(this);
    }
}

class Work implements Activity {
    @Override
    public void doSomething(Human context) {
        System.out.println("Работаем...");
        context.setState(new Weekend());
    }
}

class Weekend implements Activity {
    private int counter = 0;

    @Override
    public void doSomething(Human context) {
        if (counter < 3) {
            System.out.println("Отдыхаем!!!");
            counter++;
        } else {
            context.setState(new Work());
        }
    }
}

