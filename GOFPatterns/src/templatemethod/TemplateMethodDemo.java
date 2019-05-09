package templatemethod;

public class TemplateMethodDemo {
    public static void main(String[] args) {
        C a = new A();
        a.method();

        System.out.println();

        C b = new B();
        b.method();
    }
}

abstract class C {
    void method() {
        System.out.print("1");
        differ();
        System.out.print("3");
        differ2();
    }

    abstract void differ();
    abstract void differ2();
}

class A extends C {

    @Override
    void differ() {
        System.out.print("2");
    }

    @Override
    void differ2() {
        System.out.print("4");
    }
}

class B extends C {
    @Override
    void differ() {
        System.out.print("4");
    }

    @Override
    void differ2() {

    }
}