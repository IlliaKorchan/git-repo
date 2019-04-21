package testcontroller;

import controller.Controller;
import org.junit.Before;
import org.junit.Test;
import view.View;

/**
 * Class for testing methods of Controller class
 * @author Illia Korchan
 * @version 1.0
 */
public class TestController {
    private Controller controller;

    @Before
    public void run() {
        controller = new Controller(new View());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void selectTest() {
        controller.select(-1);
    }
}
