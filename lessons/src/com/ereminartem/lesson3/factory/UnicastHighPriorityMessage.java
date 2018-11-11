package com.ereminartem.lesson3.factory;

public class UnicastHighPriorityMessage implements HighPriorityMessage {
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
