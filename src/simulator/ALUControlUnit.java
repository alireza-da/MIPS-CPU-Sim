package simulator;

import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class ALUControlUnit extends Wrapper {

    public ALUControlUnit(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        // inputs : 2 bit ALU OP , Funct Field
        Not n1 = new Not("n");
        Not n2 = new Not("n");
        Not n3 = new Not("n");
        Not n4 = new Not("n");
        Not n5 = new Not("n");
        Not n6 = new Not("n");
        Not n7 = new Not("n");
        Not n8 = new Not("n");

        n1.addInput(getInput(0));
        n2.addInput(getInput(1));
        n3.addInput(getInput(2));
        n4.addInput(getInput(3));
        n5.addInput(getInput(4));
        n6.addInput(getInput(5));
        n7.addInput(getInput(6));
        n8.addInput(getInput(7));

        And a1 = new And("a");
        And a2 = new And("a");
        And a3 = new And("a");
        And a4 = new And("a");
        And a5 = new And("a");
        And a6 = new And("a");

        Or o1 = new Or("o");
        Or o2 = new Or("o");
        Or o3 = new Or("o");
        Or o4 = new Or("o");
        Or o5 = new Or("o");
        Or o7 = new Or("o");

        a1.addInput(getInput(0) , n2.getOutput(0) , getInput(2) , getInput(6) , n4.getOutput(0) , n5.getOutput(0) , n6.getOutput(0) , n8.getOutput(0));
        a2.addInput(getInput(0) , n2.getOutput(0) , getInput(2) , getInput(6) , n4.getOutput(0) , getInput(4) , n6.getOutput(0) , n8.getOutput(0));
        a3.addInput(getInput(1) , n1.getOutput(0));
        o1.addInput(a1.getOutput(0) , a2.getOutput(0) , a3.getOutput(0));

        a4.addInput(getInput(2) , getInput(5) , n4.getOutput(0) , n5.getOutput(0) , n7.getOutput(0) , n8.getOutput(0));
        a5.addInput(getInput(2) , getInput(5) , n4.getOutput(0) , n5.getOutput(0) , n7.getOutput(0) , getInput(7));
        o2.addInput(a4.getOutput(0) , a5.getOutput(0));

        Not n10 = new Not("n");
        n10.addInput(o2.getOutput(0));

        a6.addInput(getInput(2) , getInput(4) , getInput(6) , n4.getOutput(0) , n6.getOutput(0) , n8.getOutput(0));
        o3.addInput(a5.getOutput(0) , a6.getOutput(0) );

        addOutput(Simulator.falseLogic , o1.getOutput(0) , n10.getOutput(0) , o3.getOutput(0) );

    }
}
