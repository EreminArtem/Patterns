package com.ereminartem;

import com.ereminartem.lesson3.factory.Assignment;
import com.ereminartem.lesson3.factory.Fabric;
import com.ereminartem.lesson3.factory.MessageFactory;

public class Main {

    public static void main(String[] args) {
        MessageFactory factory = Fabric.getInstance().createFactory("unicast");
        Assignment assignment = factory.createAssignment();
        assignment.getDeadline();
    }
}
