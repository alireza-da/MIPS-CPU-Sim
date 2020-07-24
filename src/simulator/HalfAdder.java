package simulator;

import simulator.gates.combinational.And;
import simulator.gates.combinational.Xor;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

import java.util.ArrayList;

public class HalfAdder extends Wrapper {
    public HalfAdder(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        And a1 = new And("AND1");
        Xor x1 = new Xor("XOR1");

        a1.addInput(getInput(0) , getInput(1));
        x1.addInput(getInput(0) , getInput(1));

        addOutput( x1.getOutput(0) , a1.getOutput(0) );
    }

}
