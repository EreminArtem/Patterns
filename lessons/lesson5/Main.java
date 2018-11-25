

public class Main {
    public static void main(String[] args) {
        EventManager eventManager = new EventManager("print");
        MessagePrinter messagePrinter = new MessagePrinter();
        eventManager.addListner("print", messagePrinter);
        eventManager.update("print", new Message("text of Message"));
    }
}
