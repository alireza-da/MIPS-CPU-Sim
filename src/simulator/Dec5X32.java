package simulator;

import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Dec5X32 extends Wrapper {
    public Dec5X32(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {

        Not n1 = new Not("N");
        Not n2 = new Not("N");
        Not n3 = new Not("N");
        Not n4 = new Not("N");
        Not n5 = new Not("N");


        And a1 = new And("A");
        And a2 = new And("A");
        And a3 = new And("A");
        And a4 = new And("A");
        And a5 = new And("A");
        And a6 = new And("A");
        And a7 = new And("A");
        And a8 = new And("A");
        And a9 = new And("A");
        And a10 = new And("A");
        And a11 = new And("A");
        And a12 = new And("A");
        And a13 = new And("A");
        And a14 = new And("A");
        And a15 = new And("A");
        And a16 = new And("A");
        And a17 = new And("A");
        And a18 = new And("A");
        And a19 = new And("A");
        And a20 = new And("A");
        And a21 = new And("A");
        And a22 = new And("A");
        And a23 = new And("A");
        And a24 = new And("A");
        And a25 = new And("A");
        And a26 = new And("A");
        And a27 = new And("A");
        And a28 = new And("A");
        And a29 = new And("A");
        And a30 = new And("A");
        And a31 = new And("A");
        And a32 = new And("A");

        n1.addInput(getInput(4));
        n2.addInput(getInput(3));
        n3.addInput(getInput(2));
        n4.addInput(getInput(1));
        n5.addInput(getInput(0));

        a1.addInput(n5.getOutput(0) ,  n4.getOutput(0), n3.getOutput(0) , n2.getOutput(0), n1.getOutput(0) );
        a2.addInput(n5.getOutput(0) ,  n4.getOutput(0), n3.getOutput(0) , n2.getOutput(0), getInput(4) );
        a3.addInput(n5.getOutput(0) ,  n4.getOutput(0), n3.getOutput(0) , getInput(3), n1.getOutput(0) );
        a4.addInput(n5.getOutput(0) ,  n4.getOutput(0), n3.getOutput(0) , getInput(3), getInput(4) );
        a5.addInput(n5.getOutput(0) ,  n4.getOutput(0), getInput(2) , n2.getOutput(0), n1.getOutput(0) );
        a6.addInput(n5.getOutput(0) ,  n4.getOutput(0), getInput(2) , n2.getOutput(0), getInput(4) );
        a7.addInput(n5.getOutput(0) ,  n4.getOutput(0), getInput(2) , getInput(3), n1.getOutput(0) );
        a8.addInput(n5.getOutput(0) ,  n4.getOutput(0), getInput(2) , getInput(3) , getInput(4) );
        a9.addInput(n5.getOutput(0) ,  getInput(1), n3.getOutput(0) , n2.getOutput(0), n1.getOutput(0) );

        a10.addInput(n5.getOutput(0) ,  getInput(1), n3.getOutput(0) , n2.getOutput(0), getInput(4) );
        a11.addInput(n5.getOutput(0) ,  getInput(1), n3.getOutput(0) , getInput(3), n1.getOutput(0) );
        a12.addInput(n5.getOutput(0) ,  getInput(1), n3.getOutput(0) , getInput(3), getInput(4) );
        a13.addInput(n5.getOutput(0) ,  getInput(1), getInput(2) , n2.getOutput(0), n1.getOutput(0) );
        a14.addInput(n5.getOutput(0) ,  getInput(1), getInput(2) , n2.getOutput(0), getInput(4) ); //13
        a15.addInput(n5.getOutput(0) ,  getInput(1), getInput(2) , getInput(3), n1.getOutput(0) );
        a16.addInput(n5.getOutput(0) ,  getInput(1), getInput(2) , getInput(3), getInput(4) );
        a17.addInput(getInput(0) ,  n4.getOutput(0), n3.getOutput(0) , n2.getOutput(0), n1.getOutput(0) ); //16
        a18.addInput(getInput(0) ,  n4.getOutput(0), n3.getOutput(0) , n2.getOutput(0), getInput(4) ); //17
        a19.addInput(getInput(0) ,  n4.getOutput(0), n3.getOutput(0) , getInput(3), n1.getOutput(0) );
        a20.addInput(getInput(0) ,  n4.getOutput(0), n3.getOutput(0) , getInput(3), getInput(4) );

        a21.addInput(getInput(0) ,  n4.getOutput(0), getInput(2) , n2.getOutput(0), n1.getOutput(0) ); //20
        a22.addInput(getInput(0) ,  n4.getOutput(0), getInput(2) , n2.getOutput(0), getInput(4) ); //21
        a23.addInput(getInput(0) ,  n4.getOutput(0), getInput(2) , getInput(3), n1.getOutput(0) ); // 22
        a24.addInput(getInput(0) ,  n4.getOutput(0), getInput(2) , getInput(3), getInput(4) ); //23
        a25.addInput(getInput(0) ,  getInput(1), n3.getOutput(0) , n2.getOutput(0), n1.getOutput(0) ); //24
        a26.addInput(getInput(0) ,  getInput(1), n3.getOutput(0) , n2.getOutput(0), getInput(4) ); //25
        a27.addInput(getInput(0) ,  getInput(1), n3.getOutput(0) , getInput(3), n1.getOutput(0) ); //26
        a28.addInput(getInput(0) ,  getInput(1), n3.getOutput(0) , getInput(3), getInput(4) ); //27
        a29.addInput(getInput(0) ,  getInput(1), getInput(2) , n2.getOutput(0), n1.getOutput(0) ); //28
        a30.addInput(getInput(0) ,  getInput(1), getInput(2) , n2.getOutput(0), getInput(4) ); //29
        a31.addInput(getInput(0) ,  getInput(1), getInput(2) , getInput(3), n1.getOutput(0) ); //30
        a32.addInput(getInput(0) ,  getInput(1), getInput(2) , getInput(3), getInput(4) ); //31


        addOutput(a1.getOutput(0) , a2.getOutput(0) , a3.getOutput(0) , a4.getOutput(0), a5.getOutput(0) , a6.getOutput(0) , a7.getOutput(0) , a8.getOutput(0) , a9.getOutput(0) , a10.getOutput(0) , a11.getOutput(0) , a12.getOutput(0) , a13.getOutput(0) , a14.getOutput(0) , a15.getOutput(0) , a16.getOutput(0) , a17.getOutput(0) , a18.getOutput(0) , a19.getOutput(0) , a20.getOutput(0), a21.getOutput(0) , a22.getOutput(0), a23.getOutput(0), a24.getOutput(0), a25.getOutput(0), a26.getOutput(0), a27.getOutput(0), a28.getOutput(0), a29.getOutput(0), a30.getOutput(0) , a31.getOutput(0) , a32.getOutput(0));

    }
}
