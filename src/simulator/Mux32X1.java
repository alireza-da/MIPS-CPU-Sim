package simulator;

import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Mux32X1 extends Wrapper {
    public Mux32X1(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        Mux16X1 m1 = new Mux16X1("m" , "20X1");
        Mux16X1 m2 = new Mux16X1("m" , "20X1");
        MultiPlexer m3 = new MultiPlexer("m" , "3X1");

        m1.addInput(getInput(0) , getInput(1) , getInput(2) , getInput(3) , getInput(4) , getInput(5) , getInput(6) , getInput(7) , getInput(8) , getInput(9) , getInput(10) , getInput(11) , getInput(12) , getInput(13) , getInput(14) , getInput(15) , getInput(32) , getInput(33) , getInput(34) , getInput(35));
        m2.addInput(getInput(16) , getInput(17) , getInput(18) , getInput(19) , getInput(20) , getInput(21) , getInput(22) , getInput(23) , getInput(24) , getInput(25) , getInput(26) , getInput(27) , getInput(28) , getInput(29) , getInput(30) , getInput(31) , getInput(32) , getInput(33) , getInput(34) , getInput(35));
        m3.addInput(m1.getInput(0) , m2.getOutput(1) , getInput(36));

        addOutput(m3.getOutput(0));
    }
}
