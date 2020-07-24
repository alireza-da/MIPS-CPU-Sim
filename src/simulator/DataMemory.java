package simulator;

import simulator.control.Simulator;
import simulator.gates.combinational.Memory;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class DataMemory extends Wrapper {
    public DataMemory(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        // inputs : 16 bit address 32 bit data 1 bit memWrite 1 bit memRead
        // output 32 bit data read
        Link readORWrite;
        if (getInput(32) == Simulator.trueLogic){
            readORWrite = Simulator.trueLogic;
        }
        else {
            readORWrite = Simulator.falseLogic;
        }
        Memory dataMemory = new Memory("datMemory" , readORWrite , getInput(0) , getInput(1) , getInput(2) , getInput(3) , getInput(4) , getInput(5) , getInput(6) , getInput(7) , getInput(8) , getInput(9) , getInput(10) , getInput(11)  , getInput(12) , getInput(13) , getInput(14) , getInput(15) , getInput(16) , getInput(17) , getInput(18) , getInput(19) , getInput(20) , getInput(21) , getInput(22) , getInput(23) , getInput(24) , getInput(25) , getInput(26) , getInput(27) , getInput(28) , getInput(29) , getInput(30) , getInput(31) , getInput(32) , getInput(33) , getInput(34) , getInput(35) , getInput(36) , getInput(37) , getInput(38) ,getInput(39) , getInput(40) , getInput(41) , getInput(42) , getInput(43) , getInput(44) , getInput(45) , getInput(46) , getInput(47));

        addOutput(dataMemory.getOutput(0) , dataMemory.getOutput(1) , dataMemory.getOutput(2) , dataMemory.getOutput(3) , dataMemory.getOutput(4) , dataMemory.getOutput(5) , dataMemory.getOutput(6) , dataMemory.getOutput(7) , dataMemory.getOutput(8) , dataMemory.getOutput(9) , dataMemory.getOutput(10) , dataMemory.getOutput(11) , dataMemory.getOutput(12) , dataMemory.getOutput(13) , dataMemory.getOutput(14) , dataMemory.getOutput(15) , dataMemory.getOutput(16) , dataMemory.getOutput(17) , dataMemory.getOutput(18) , dataMemory.getOutput(19) , dataMemory.getOutput(20) , dataMemory.getOutput(21) , dataMemory.getOutput(22) , dataMemory.getOutput(23) , dataMemory.getOutput(24) , dataMemory.getOutput(25) , dataMemory.getOutput(26) , dataMemory.getOutput(27) , dataMemory.getOutput(28) , dataMemory.getOutput(29) , dataMemory.getOutput(30) ,dataMemory.getOutput(31));
    }
}
