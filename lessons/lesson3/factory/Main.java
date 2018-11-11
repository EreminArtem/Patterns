package lesson3.factory;


public class Main {

    public static void main(String[] args) {
        MessageFactory factory = Fabric.getInstance().createFactory("unicast");
        Assignment assignment = factory.createAssignment();
        assignment.getDeadline();
    }
}
