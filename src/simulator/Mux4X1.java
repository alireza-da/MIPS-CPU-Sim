package simulator;

import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Mux4X1 extends Wrapper {
    public Mux4X1(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        MultiPlexer m1 = new MultiPlexer( "m1" , "3X1");
        MultiPlexer m2 = new MultiPlexer( "m1" , "3X1");
        MultiPlexer m3 = new MultiPlexer( "m1" , "3X1");

        m1.addInput(getInput(0) , getInput(1) , getInput(4));
        m2.addInput(getInput(2) , getInput(3) , getInput(4));
        m3.addInput( m1.getOutput(0), m2.getOutput(0) , getInput(5));

        addOutput(m3.getOutput(0));

    }
}
