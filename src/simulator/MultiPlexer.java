package simulator;

import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.gates.combinational.Xor;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class MultiPlexer extends Wrapper {
    public MultiPlexer(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        And a1 = new And("AND1");
        And a2 = new And("AND2");
        Not n1 = new Not("Not1");
        Or o1 = new Or("Or1");

        n1.addInput(getInput(2)); // select line
        a1.addInput(getInput(0) , n1.getOutput(0));

        a2.addInput(getInput(1) , getInput(2));
        o1.addInput(a1.getOutput(0) , a2.getOutput(0) );

        addOutput(o1.getOutput(0));

    }

}
