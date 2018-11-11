package com.ereminartem.lesson3.factory;

public interface MessageFactory {
    SimpleMessage createSimpleMessage();
    Assignment createAssignment();
    HighPriorityMessage createHighPriorityMessage();
}
