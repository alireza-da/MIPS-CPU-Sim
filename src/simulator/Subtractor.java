package simulator;

import simulator.control.Simulator;
import simulator.gates.combinational.Not;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Subtractor extends Wrapper {
    public Subtractor(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {

        Not n1 = new Not("N");
        Not n2 = new Not("N");
        Not n3 = new Not("N");
        Not n4 = new Not("N");
        Not n5 = new Not("N");
        Not n6 = new Not("N");
        Not n7 = new Not("N");
        Not n8 = new Not("N");
        Not n9 = new Not("N");

        Not n10 = new Not("N");
        Not n11 = new Not("N");
        Not n12 = new Not("N");
        Not n13 = new Not("N");
        Not n14 = new Not("N");
        Not n15 = new Not("N");
        Not n16 = new Not("N");
        Not n17 = new Not("N");
        Not n18 = new Not("N");
        Not n19 = new Not("N");

        Not n20 = new Not("N");
        Not n21 = new Not("N");
        Not n22 = new Not("N");
        Not n23 = new Not("N");
        Not n24 = new Not("N");
        Not n25 = new Not("N");
        Not n26 = new Not("N");
        Not n27 = new Not("N");
        Not n28 = new Not("N");
        Not n29 = new Not("N");

        Not n30 = new Not("N");
        Not n31 = new Not("N");
        Not n32 = new Not("N");

        n1.addInput(getInput(32));
        n2.addInput(getInput(33));
        n3.addInput(getInput(34));
        n4.addInput(getInput(35));
        n5.addInput(getInput(36));
        n6.addInput(getInput(37));
        n7.addInput(getInput(38));
        n8.addInput(getInput(39));
        n9.addInput(getInput(40));

        n10.addInput(getInput(41));
        n11.addInput(getInput(42));
        n12.addInput(getInput(43));
        n13.addInput(getInput(44));
        n14.addInput(getInput(45));
        n15.addInput(getInput(46));
        n16.addInput(getInput(47));
        n17.addInput(getInput(48));
        n18.addInput(getInput(49));
        n19.addInput(getInput(50));

        n20.addInput(getInput(51));
        n21.addInput(getInput(52));
        n22.addInput(getInput(53));
        n23.addInput(getInput(54));
        n24.addInput(getInput(55));
        n25.addInput(getInput(56));
        n26.addInput(getInput(57));
        n27.addInput(getInput(58));
        n28.addInput(getInput(59));
        n29.addInput(getInput(60));

        n30.addInput(getInput(61));
        n31.addInput(getInput(62));
        n32.addInput(getInput(63));


        FullAdder h1 = new FullAdder("h1", "3X2", getInput(0), n1.getOutput(0) , Simulator.trueLogic);
        FullAdder f1 = new FullAdder("f1", "3X2", getInput(1), n2.getOutput(0), h1.getOutput(1));
        FullAdder f2 = new FullAdder("f2", "3X2", getInput(2), n3.getOutput(0), f1.getOutput(1));
        FullAdder f3 = new FullAdder("f3", "3X2", getInput(3), n4.getOutput(0), f2.getOutput(1));
        FullAdder f4 = new FullAdder("f3", "3X2", getInput(4), n5.getOutput(0), f3.getOutput(1));
        FullAdder f5 = new FullAdder("f3", "3X2", getInput(5), n6.getOutput(0), f4.getOutput(1));
        FullAdder f6 = new FullAdder("f3", "3X2", getInput(6), n7.getOutput(0), f5.getOutput(1));
        FullAdder f7 = new FullAdder("f3", "3X2", getInput(7), n8.getOutput(0), f6.getOutput(1));
        FullAdder f8 = new FullAdder("f3", "3X2", getInput(8), n9.getOutput(0), f7.getOutput(1));
        FullAdder f9 = new FullAdder("f3", "3X2", getInput(9), n10.getOutput(0), f8.getOutput(1));
        FullAdder f10 = new FullAdder("f3", "3X2", getInput(10), n11.getOutput(0), f9.getOutput(1));

        FullAdder f11 = new FullAdder("f3", "3X2", getInput(11), n12.getOutput(0), f10.getOutput(1));
        FullAdder f12 = new FullAdder("f3", "3X2", getInput(12), n13.getOutput(0), f11.getOutput(1));
        FullAdder f13 = new FullAdder("f3", "3X2", getInput(13), n14.getOutput(0), f12.getOutput(1));
        FullAdder f14 = new FullAdder("f3", "3X2", getInput(14), n15.getOutput(0), f13.getOutput(1));
        FullAdder f15 = new FullAdder("f3", "3X2", getInput(15), n16.getOutput(0), f14.getOutput(1));
        FullAdder f16 = new FullAdder("f3", "3X2", getInput(16), n17.getOutput(0), f15.getOutput(1));
        FullAdder f17 = new FullAdder("f3", "3X2", getInput(17), n18.getOutput(0), f16.getOutput(1));
        FullAdder f18 = new FullAdder("f3", "3X2", getInput(18), n19.getOutput(0), f17.getOutput(1));
        FullAdder f19 = new FullAdder("f3", "3X2", getInput(19), n20.getOutput(0), f18.getOutput(1));
        FullAdder f20 = new FullAdder("f3", "3X2", getInput(20), n21.getOutput(0), f19.getOutput(1));

        FullAdder f21 = new FullAdder("f3", "3X2", getInput(21), n22.getOutput(0), f20.getOutput(1));
        FullAdder f22 = new FullAdder("f3", "3X2", getInput(22), n23.getOutput(0), f21.getOutput(1));
        FullAdder f23 = new FullAdder("f3", "3X2", getInput(23), n24.getOutput(0), f22.getOutput(1));
        FullAdder f24 = new FullAdder("f3", "3X2", getInput(24), n25.getOutput(0), f23.getOutput(1));
        FullAdder f25 = new FullAdder("f3", "3X2", getInput(25), n26.getOutput(0), f24.getOutput(1));
        FullAdder f26 = new FullAdder("f3", "3X2", getInput(26), n27.getOutput(0), f25.getOutput(1));
        FullAdder f27 = new FullAdder("f3", "3X2", getInput(27), n28.getOutput(0), f26.getOutput(1));
        FullAdder f28 = new FullAdder("f3", "3X2", getInput(28), n29.getOutput(0), f27.getOutput(1));
        FullAdder f29 = new FullAdder("f3", "3X2", getInput(29), n30.getOutput(0), f28.getOutput(1));
        FullAdder f30 = new FullAdder("f3", "3X2", getInput(30), n31.getOutput(0), f29.getOutput(1));
        FullAdder f31 = new FullAdder("f3", "3X2", getInput(31), n32.getOutput(0), f30.getOutput(1));

        addOutput(f31.getOutput(1), f31.getOutput(0), f30.getOutput(0), f29.getOutput(0), f28.getOutput(0), f27.getOutput(0), f26.getOutput(0), f25.getOutput(0), f24.getOutput(0), f23.getOutput(0), f22.getOutput(0), f21.getOutput(0), f20.getOutput(0), f19.getOutput(0), f18.getOutput(0), f17.getOutput(0), f16.getOutput(0), f15.getOutput(0), f14.getOutput(0), f13.getOutput(0), f12.getOutput(0), f11.getOutput(0), f10.getOutput(0), f9.getOutput(0), f8.getOutput(0), f7.getOutput(0), f6.getOutput(0), f5.getOutput(0), f4.getOutput(0), f3.getOutput(0), f2.getOutput(0), f1.getOutput(0), h1.getOutput(0));

    }
}
