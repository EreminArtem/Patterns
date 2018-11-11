package lesson3.factory;

public class BroadcastHighPriorityMessage implements HighPriorityMessage {
    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public void send() {

    }

    @Override
    public String getMessage() {
        return null;
    }
}
