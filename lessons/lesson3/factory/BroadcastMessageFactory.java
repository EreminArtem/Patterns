package com.ereminartem.lesson3.factory;

public class BroadcastMessageFactory implements MessageFactory {
    @Override
    public SimpleMessage createSimpleMessage() {
        return new BroadcastSimpleMessage();
    }

    @Override
    public Assignment createAssignment() {
        return new BroadcastAssignment();
    }

    @Override
    public HighPriorityMessage createHighPriorityMessage() {
        return new BroadcastHighPriorityMessage();
    }
}
