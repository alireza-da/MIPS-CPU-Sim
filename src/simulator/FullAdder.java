package simulator;

import simulator.gates.combinational.And;
import simulator.gates.combinational.Or;
import simulator.gates.combinational.Xor;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class FullAdder extends Wrapper {

    public FullAdder(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        And a1 = new And("AND1");
        And a2 = new And("AND2");

        Xor x1 = new Xor("XOR1");
        Xor x2 = new Xor("XOR2");

        Or o1 = new Or("OR1");

        x1.addInput(getInput(0), getInput(1));
        a1.addInput(getInput(0), getInput(1));

        x2.addInput(getInput(2), x1.getOutput(0));
        a2.addInput(getInput(2), x1.getOutput(0));

        o1.addInput(a1.getOutput(0), a2.getOutput(0));

        addOutput(x2.getOutput(0), o1.getOutput(0));
    }
}
