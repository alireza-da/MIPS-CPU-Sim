package simulator;

import simulator.control.Simulator;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Shift2Times extends Wrapper {
    public Shift2Times(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        addOutput(getInput(2) , getInput(3) , getInput(4) , getInput(5) , getInput(6) , getInput(7) , getInput(8) , getInput(9) , getInput(10) , getInput(11) , getInput(12) , getInput(13) , getInput(14) , getInput(15) , getInput(16) , getInput(17) , getInput(18) , getInput(19) , getInput(20) , getInput(21) , getInput(22) , getInput(23) , getInput(24) , getInput(25) , getInput(26) , getInput(27) , getInput(28) , getInput(29) , getInput(30) , getInput(31) , Simulator.falseLogic , Simulator.falseLogic);
    }
}
