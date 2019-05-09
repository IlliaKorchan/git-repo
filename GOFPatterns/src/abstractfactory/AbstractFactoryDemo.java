package abstractfactory;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
//        DeviceFactory factory = getFactoryByLanguage("EN");
        DeviceFactory factory = getFactoryByLanguage("UK");
        Mouse m = factory.getMouse();
        Keyboard k = factory.getKeyboard();
        Touchpad t = factory.getTouchpad();

        m.click();
        k.push();
        t.scroll();
    }

    public static DeviceFactory getFactoryByLanguage(String language) {
        switch (language) {
            case "UK": {
                return new UKDeviceFactory();
            }
            case "EN": {
                return new ENDeviceFactory();
            }
            default: {
                throw new RuntimeException("Language " + language + " is not supported!");
            }
        }
    }
}

interface DeviceFactory {
    Mouse getMouse();
    Keyboard getKeyboard();
    Touchpad getTouchpad();
}

class UKDeviceFactory implements DeviceFactory {
    @Override
    public Mouse getMouse() {
        return new UKMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new UKKeyboard();
    }

    @Override
    public Touchpad getTouchpad() {
        return new UKTouchpad();
    }
}

class ENDeviceFactory implements DeviceFactory {
    @Override
    public Mouse getMouse() {
        return new ENMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new ENKeyboard();
    }

    @Override
    public Touchpad getTouchpad() {
        return new ENTouchpad();
    }
}

interface Mouse {
    void click();
}

class UKMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("Клік");
    }
}

class ENMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("Click");
    }
}

interface Keyboard {
    void push();
}

class UKKeyboard implements Keyboard {
    @Override
    public void push() {
        System.out.println("Натискання");
    }
}

class ENKeyboard implements Keyboard {
    @Override
    public void push() {
        System.out.println("Push");
    }
}

interface Touchpad {
    void scroll();
}

class UKTouchpad implements Touchpad {
    @Override
    public void scroll() {
        System.out.println("Прокручування");
    }
}

class ENTouchpad implements Touchpad {
    @Override
    public void scroll() {
        System.out.println("Scroll");
    }
}