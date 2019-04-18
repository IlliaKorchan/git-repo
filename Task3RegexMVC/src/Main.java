import controller.Controller;
import view.View;

/**
 * Main class, that contains entry point
 * @author Illia Korchan
 * @version 2.1.1
 */
public class Main {
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);

        controller.processUser();
    }
}
