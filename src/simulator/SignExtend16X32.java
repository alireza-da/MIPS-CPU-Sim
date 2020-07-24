package simulator;

import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class SignExtend16X32 extends Wrapper {
    public SignExtend16X32(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        addOutput(getInput(0) , getInput(0) , getInput(0) , getInput(0) , getInput(0) , getInput(0) , getInput(0) , getInput(0) , getInput(0) , getInput(0) , getInput(0) , getInput(0), getInput(0) , getInput(0) , getInput(0) , getInput(0) , getInput(0) , getInput(1) , getInput(2) , getInput(3) , getInput(4) , getInput(5) , getInput(6) , getInput(7) , getInput(8) , getInput(9) , getInput(10) , getInput(11) , getInput(12) , getInput(13) , getInput(14) , getInput(15));

    }
}
