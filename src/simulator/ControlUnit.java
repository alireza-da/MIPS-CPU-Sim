package simulator;

import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class ControlUnit extends Wrapper {
    public ControlUnit(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        Not n1 = new Not("n");
        Not n2 = new Not("n");
        Not n3 = new Not("n");
        Not n4 = new Not("n");
        Not n5 = new Not("n");
        Not n6 = new Not("n");
        n1.addInput(getInput(0));
        n2.addInput(getInput(1));
        n3.addInput(getInput(2));
        n4.addInput(getInput(3));
        n5.addInput(getInput(4));
        n6.addInput(getInput(5));

        And a1 = new And("a"); //output[7]
        a1.addInput(n1.getOutput(0) , n2.getOutput(0) , n3.getOutput(0) , n4.getOutput(0) , n5.getOutput(0) , n6.getOutput(0) );
        And a2 = new And("a");
        a2.addInput(getInput(0) , n3.getOutput(0) );
        And a3 = new And("a");
        a3.addInput(getInput(0) , getInput(2));
        Or o1 = new Or("o");
        And a4 = new And("a");
        a4.addInput(getInput(0) , getInput(2));
        o1.addInput(a1.getOutput(0) , a2.getOutput(0));

        addOutput(a1.getOutput(0) , getInput(0) , a2.getOutput(0) , o1.getOutput(0) , a2.getOutput(0) , a4.getOutput(0) , getInput(3) , a1.getOutput(0) , getInput(3) );
    }
}
