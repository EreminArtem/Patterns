package lesson3.factory;

public class UnicastMessageFactory implements MessageFactory{
    @Override
    public SimpleMessage createSimpleMessage() {
        return new UnicastSimpleMessage();
    }

    @Override
    public Assignment createAssignment() {
        return new UnicastAssignment();
    }

    @Override
    public HighPriorityMessage createHighPriorityMessage() {
        return new UnicastHighPriorityMessage();
    }
}
