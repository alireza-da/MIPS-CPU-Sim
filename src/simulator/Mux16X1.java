package simulator;

import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Mux16X1 extends Wrapper {
    public Mux16X1(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        Mux4X1 m1 = new Mux4X1("m" , "6X1");
        Mux4X1 m2 = new Mux4X1("m" , "6X1");
        Mux4X1 m3 = new Mux4X1("m" , "6X1");
        Mux4X1 m4 = new Mux4X1("m" , "6X1");
        Mux4X1 m5 = new Mux4X1("m" , "6X1");

        m1.addInput(getInput(0) , getInput(1) , getInput(2) , getInput(3) , getInput(16) , getInput(17) );
        m2.addInput(getInput(4) , getInput(5) , getInput(6) , getInput(7) , getInput(16) , getInput(17) );
        m3.addInput(getInput(8) , getInput(9) , getInput(10) , getInput(11) , getInput(16) , getInput(17) );
        m4.addInput(getInput(12) , getInput(13) , getInput(14) , getInput(15) , getInput(16) , getInput(17) );
        m5.addInput(m1.getOutput(0) , m2.getOutput(0) , m3.getOutput(0) , m4.getOutput(0) , getInput(18) , getInput(19) );

        addOutput(m5.getOutput(0));
    }
}
