package simulator;

import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class OR32Bit extends Wrapper {
    public OR32Bit(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        Or or1 = new Or("OR1");
        Or or2 = new Or("OR1");
        Or or3 = new Or("OR1");
        Or or4 = new Or("OR1");
        Or or5 = new Or("OR1");
        Or or6 = new Or("OR1");
        Or or7 = new Or("OR1");
        Or or8 = new Or("OR1");
        Or or9 = new Or("OR1");

        Or or10 = new Or("OR1");
        Or or11 = new Or("OR1");
        Or or12 = new Or("OR1");
        Or or13 = new Or("OR1");
        Or or14 = new Or("OR1");
        Or or15 = new Or("OR1");
        Or or16 = new Or("OR1");
        Or or17 = new Or("OR1");
        Or or18 = new Or("OR1");
        Or or19 = new Or("OR1");

        Or or20 = new Or("OR1");
        Or or21 = new Or("OR1");
        Or or22 = new Or("OR1");
        Or or23 = new Or("OR1");
        Or or24 = new Or("OR1");
        Or or25 = new Or("OR1");
        Or or26 = new Or("OR1");
        Or or27 = new Or("OR1");
        Or or28 = new Or("OR1");
        Or or29 = new Or("OR1");

        Or or30 = new Or("OR1");
        Or or31 = new Or("OR1");
        Or or32 = new Or("OR1");

        or1.addInput(getInput(0), getInput(32));
        or2.addInput(getInput(1), getInput(33));
        or3.addInput(getInput(2), getInput(34));
        or4.addInput(getInput(3), getInput(35));
        or5.addInput(getInput(4), getInput(36));
        or6.addInput(getInput(5), getInput(37));
        or7.addInput(getInput(6), getInput(38));
        or8.addInput(getInput(7), getInput(39));
        or9.addInput(getInput(8), getInput(40));
        or10.addInput(getInput(9), getInput(41));

        or11.addInput(getInput(10), getInput(42));
        or12.addInput(getInput(11), getInput(43));
        or13.addInput(getInput(12), getInput(44));
        or14.addInput(getInput(13), getInput(45));
        or15.addInput(getInput(14), getInput(46));
        or16.addInput(getInput(15), getInput(47));
        or17.addInput(getInput(16), getInput(48));
        or18.addInput(getInput(17), getInput(49));
        or19.addInput(getInput(18), getInput(50));
        or20.addInput(getInput(19), getInput(51));

        or21.addInput(getInput(20), getInput(52));
        or22.addInput(getInput(21), getInput(53));
        or23.addInput(getInput(22), getInput(54));
        or24.addInput(getInput(23), getInput(55));
        or25.addInput(getInput(24), getInput(56));
        or26.addInput(getInput(25), getInput(57));
        or27.addInput(getInput(26), getInput(58));
        or28.addInput(getInput(27), getInput(59));
        or29.addInput(getInput(28), getInput(60));
        or30.addInput(getInput(29), getInput(61));

        or31.addInput(getInput(30), getInput(62));
        or32.addInput(getInput(31), getInput(63));


        addOutput(or1.getOutput(0) , or2.getOutput(0) , or3.getOutput(0) , or4.getOutput(0) , or5.getOutput(0) , or6.getOutput(0) , or7.getOutput(0) ,or8.getOutput(0) , or9.getOutput(0) , or10.getOutput(0) , or11.getOutput(0) , or12.getOutput(0) , or13.getOutput(0) , or14.getOutput(0) , or15.getOutput(0) , or16.getOutput(0) , or17.getOutput(0) , or18.getOutput(0) , or19.getOutput(0) , or20.getOutput(0) , or21.getOutput(0) , or22.getOutput(0) , or23.getOutput(0) , or24.getOutput(0) , or25.getOutput(0) , or26.getOutput(0) , or27.getOutput(0) , or28.getOutput(0) , or29.getOutput(0) , or30.getOutput(0) , or31.getOutput(0) , or32.getOutput(0));

    }
}
