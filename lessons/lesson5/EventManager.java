import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    private Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String... events) {
        for (String event : events) {
            listeners.put(event, new ArrayList<>());
        }
    }

    public void addListner(String eventType, EventListener listener) {
        List<EventListener> list = listeners.get(eventType);
        list.add(listener);
    }

    public void deleteListner(String eventType, EventListener listener) {
        List<EventListener> list = listeners.get(eventType);
        list.remove(listener);
    }

    public void update(String eventType, Message message) {
        List<EventListener> list = listeners.get(eventType);
        for (EventListener listener : list) {
            listener.update(message);
        }
    }
}
