package lesson7;

public class Network {

    private static volatile Network instance;

    private Network() {
    }

    public static synchronized Network getInstance() {
        if (instance == null) {
            synchronized (Network.class) {
                if (instance == null) {
                    instance = new Network();
                }
            }
        }
        return instance;
    }

    public void sendMessage(final String adress, final String message) {
        if (!adress.isEmpty() && !message.isEmpty()) {
            System.out.println("Message send to " + adress);
            System.out.println(message);
        }
    }
}

