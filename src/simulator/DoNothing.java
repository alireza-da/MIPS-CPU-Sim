package simulator;

import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class DoNothing extends Wrapper {
    public DoNothing(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {

        HalfAdder h1 = new HalfAdder("h1" , "2X2" , getInput(0) , getInput(4));

        addOutput(getInput(0) , getInput(1) , getInput(2) , getInput(3) , getInput(4) , getInput(5) , getInput(6) , getInput(7) , h1.getOutput(0) , h1.getOutput(1));
    }
}
