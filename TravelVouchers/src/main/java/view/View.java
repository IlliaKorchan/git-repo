package view;

/**
 * Class, that contains methods for displaying messages
 * @author Illia Korchan
 * @version 1.0
 */
public class View {
    public void printMessages(String ... messages) {
        for (String message : messages) {
            System.out.println(message);
        }
    }

    public String createMessage(String ... messages) {
        StringBuilder createdMessage = new StringBuilder();
        for (String message : messages) {
            createdMessage.append(message + " ");
        }
        return createdMessage.toString();
    }
}
