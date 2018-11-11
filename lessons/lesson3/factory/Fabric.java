package lesson3.factory;

public class Fabric {

    public static final String UNICAST = "unicast";
    public static final String BROADCAST = "broadcast";

    public static volatile Fabric instance;

    private Fabric() {
    }

    public static synchronized Fabric getInstance() {
        if (instance == null) {
            synchronized (Fabric.class) {
                if (instance == null) {
                    instance = new Fabric();
                }
            }
        }
        return instance;
    }

    public MessageFactory createFactory(final String type) {
        switch (type) {
            case UNICAST:
                return new UnicastMessageFactory();
            case BROADCAST:
                return new BroadcastMessageFactory();
        }
        return null;
    }
}
