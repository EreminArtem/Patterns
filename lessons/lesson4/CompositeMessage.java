package lesson4;

import lesson3.factory.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeMessage implements Message {
    private List<Message> messageList = new ArrayList<>();
    @Override
    public void send() {
        for(Message m:messageList){
            m.send();
        }
    }

    @Override
    public String getMessage() {
        return null;
    }

    public void addMessage(Message ... messages){
        this.messageList.addAll(Arrays.asList(messages));
    }
}
