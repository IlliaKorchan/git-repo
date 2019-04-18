package view;

/**
 * Class that contains methods for printing messages
 * @author Illia Korchan
 * @version 2.1.1
 */
public class View {
    /**
     * Prints variable amount of String params
     * @param messages
     */
    public void printMessages(String ... messages) {
        for (String message : messages) {
            System.out.println(message);
        }
    }

    /**
     * Appends variable amount of String params into one String
     * @param messages
     * @return created message
     */
    public String createMessage(String ... messages) {
        StringBuilder message = new StringBuilder();
        for (String toAppend: messages) {
            message.append(toAppend).append(" ");
        }
        return message.toString();
    }
}
