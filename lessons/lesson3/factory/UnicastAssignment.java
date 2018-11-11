package lesson3.factory;

public class UnicastAssignment implements Assignment {
    @Override
    public long getDeadline() {
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
