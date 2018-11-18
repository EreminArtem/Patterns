
public class MessagePrinter implements EventListener {
    @Override
    public void update(Message message) {
        System.out.println(message.getText());
    }
}
