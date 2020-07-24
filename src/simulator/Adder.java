package simulator;

import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.combinational.Xor;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Adder extends Wrapper {
    public Adder(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {

        HalfAdder h1 = new HalfAdder("h1" , "2X2" , getInput(0) , getInput(32));
        FullAdder f1 = new FullAdder("f1" , "3X2" , getInput(1) , getInput(33) , h1.getOutput(1));
        FullAdder f2 = new FullAdder("f2" , "3X2" , getInput(2) , getInput(34) , f1.getOutput(1));
        FullAdder f3 = new FullAdder("f3" , "3X2" , getInput(3) , getInput(35) , f2.getOutput(1));
        FullAdder f4 = new FullAdder("f3" , "3X2" , getInput(4) , getInput(36) , f3.getOutput(1));
        FullAdder f5 = new FullAdder("f3" , "3X2" , getInput(5) , getInput(37) , f4.getOutput(1));
        FullAdder f6 = new FullAdder("f3" , "3X2" , getInput(6) , getInput(38) , f5.getOutput(1));
        FullAdder f7 = new FullAdder("f3" , "3X2" , getInput(7) , getInput(39) , f6.getOutput(1));
        FullAdder f8 = new FullAdder("f3" , "3X2" , getInput(8) , getInput(40) , f7.getOutput(1));
        FullAdder f9 = new FullAdder("f3" , "3X2" , getInput(9) , getInput(41) , f8.getOutput(1));
        FullAdder f10 = new FullAdder("f3" , "3X2" , getInput(10) , getInput(42) , f9.getOutput(1));

        FullAdder f11 = new FullAdder("f3" , "3X2" , getInput(11) , getInput(43) , f10.getOutput(1));
        FullAdder f12 = new FullAdder("f3" , "3X2" , getInput(12) , getInput(44) , f11.getOutput(1));
        FullAdder f13 = new FullAdder("f3" , "3X2" , getInput(13) , getInput(45) , f12.getOutput(1));
        FullAdder f14 = new FullAdder("f3" , "3X2" , getInput(14) , getInput(46) , f13.getOutput(1));
        FullAdder f15 = new FullAdder("f3" , "3X2" , getInput(15) , getInput(47) , f14.getOutput(1));
        FullAdder f16 = new FullAdder("f3" , "3X2" , getInput(16) , getInput(48) , f15.getOutput(1));
        FullAdder f17 = new FullAdder("f3" , "3X2" , getInput(17) , getInput(49) , f16.getOutput(1));
        FullAdder f18 = new FullAdder("f3" , "3X2" , getInput(18) , getInput(50) , f17.getOutput(1));
        FullAdder f19 = new FullAdder("f3" , "3X2" , getInput(19) , getInput(51) , f18.getOutput(1));
        FullAdder f20 = new FullAdder("f3" , "3X2" , getInput(20) , getInput(52) , f19.getOutput(1));

        FullAdder f21 = new FullAdder("f3" , "3X2" , getInput(21) , getInput(53) , f20.getOutput(1));
        FullAdder f22 = new FullAdder("f3" , "3X2" , getInput(22) , getInput(54) , f21.getOutput(1));
        FullAdder f23 = new FullAdder("f3" , "3X2" , getInput(23) , getInput(55) , f22.getOutput(1));
        FullAdder f24 = new FullAdder("f3" , "3X2" , getInput(24) , getInput(56) , f23.getOutput(1));
        FullAdder f25 = new FullAdder("f3" , "3X2" , getInput(25) , getInput(57) , f24.getOutput(1));
        FullAdder f26 = new FullAdder("f3" , "3X2" , getInput(26) , getInput(58) , f25.getOutput(1));
        FullAdder f27 = new FullAdder("f3" , "3X2" , getInput(27) , getInput(59) , f26.getOutput(1));
        FullAdder f28 = new FullAdder("f3" , "3X2" , getInput(28) , getInput(60) , f27.getOutput(1));
        FullAdder f29 = new FullAdder("f3" , "3X2" , getInput(29) , getInput(61) , f28.getOutput(1));
        FullAdder f30 = new FullAdder("f3" , "3X2" , getInput(30) , getInput(62) , f29.getOutput(1));
        FullAdder f31 = new FullAdder("f3" , "3X2" , getInput(31) , getInput(63) , f30.getOutput(1));

        addOutput( f31.getOutput(1),f31.getOutput(0),f30.getOutput(0),f29.getOutput(0),f28.getOutput(0),f27.getOutput(0),f26.getOutput(0),f25.getOutput(0),f24.getOutput(0),f23.getOutput(0),f22.getOutput(0),f21.getOutput(0) ,f20.getOutput(0),f19.getOutput(0),f18.getOutput(0) ,f17.getOutput(0) ,f16.getOutput(0) , f15.getOutput(0) , f14.getOutput(0) , f13.getOutput(0) , f12.getOutput(0) ,f11.getOutput(0) , f10.getOutput(0),f9.getOutput(0) , f8.getOutput(0) , f7.getOutput(0) , f6.getOutput(0) , f5.getOutput(0) , f4.getOutput(0), f3.getOutput(0) , f2.getOutput(0) , f1.getOutput(0) , h1.getOutput(0));

    }
}
