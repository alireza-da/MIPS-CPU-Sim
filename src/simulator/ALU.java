package simulator;

import simulator.control.Simulator;
import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class ALU extends Wrapper {
    public ALU(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        Subtractor subtractor = new Subtractor("Sub" , "64X33");
        Adder adder = new Adder("Add" , "64X33");
        OR32Bit or32Bit = new OR32Bit("OR" , "64X32");
        AND32Bit and32Bit = new AND32Bit("AND" , "64X32");

        subtractor.addInput(getInput(0) , getInput(1) , getInput(2) , getInput(3) , getInput(4) , getInput(5) , getInput(6) , getInput(7) , getInput(8) , getInput(9) , getInput(10) , getInput(11) , getInput(12) , getInput(13)  , getInput(14) , getInput(15) , getInput(16) , getInput(17) , getInput(18) , getInput(19) , getInput(20) , getInput(21) , getInput(22) , getInput(23) , getInput(24) , getInput(25) , getInput(26) , getInput(27) , getInput(28) , getInput(29) , getInput(30) , getInput(31) , getInput(32) , getInput(33) , getInput(34) , getInput(35) , getInput(36) , getInput(37) , getInput(38) , getInput(39) , getInput(40) , getInput(41) , getInput(42) , getInput(43) , getInput(44) , getInput(45) , getInput(46) , getInput(47) , getInput(48) , getInput(49) , getInput(50) , getInput(51) , getInput(52) , getInput(53) , getInput(54) , getInput(55) , getInput(56) , getInput(57) , getInput(58) , getInput(59) , getInput(60) , getInput(61) , getInput(62) , getInput(63));

        adder.addInput(getInput(0) , getInput(1) , getInput(2) , getInput(3) , getInput(4) , getInput(5) , getInput(6) , getInput(7) , getInput(8) , getInput(9) , getInput(10) , getInput(11) , getInput(12) , getInput(13)  , getInput(14) , getInput(15) , getInput(16) , getInput(17) , getInput(18) , getInput(19) , getInput(20) , getInput(21) , getInput(22) , getInput(23) , getInput(24) , getInput(25) , getInput(26) , getInput(27) , getInput(28) , getInput(29) , getInput(30) , getInput(31) , getInput(32) , getInput(33) , getInput(34) , getInput(35) , getInput(36) , getInput(37) , getInput(38) , getInput(39) , getInput(40) , getInput(41) , getInput(42) , getInput(43) , getInput(44) , getInput(45) , getInput(46) , getInput(47) , getInput(48) , getInput(49) , getInput(50) , getInput(51) , getInput(52) , getInput(53) , getInput(54) , getInput(55) , getInput(56) , getInput(57) , getInput(58) , getInput(59) , getInput(60) , getInput(61) , getInput(62) , getInput(63));

        or32Bit.addInput(getInput(0) , getInput(1) , getInput(2) , getInput(3) , getInput(4) , getInput(5) , getInput(6) , getInput(7) , getInput(8) , getInput(9) , getInput(10) , getInput(11) , getInput(12) , getInput(13)  , getInput(14) , getInput(15) , getInput(16) , getInput(17) , getInput(18) , getInput(19) , getInput(20) , getInput(21) , getInput(22) , getInput(23) , getInput(24) , getInput(25) , getInput(26) , getInput(27) , getInput(28) , getInput(29) , getInput(30) , getInput(31) , getInput(32) , getInput(33) , getInput(34) , getInput(35) , getInput(36) , getInput(37) , getInput(38) , getInput(39) , getInput(40) , getInput(41) , getInput(42) , getInput(43) , getInput(44) , getInput(45) , getInput(46) , getInput(47) , getInput(48) , getInput(49) , getInput(50) , getInput(51) , getInput(52) , getInput(53) , getInput(54) , getInput(55) , getInput(56) , getInput(57) , getInput(58) , getInput(59) , getInput(60) , getInput(61) , getInput(62) , getInput(63));

        and32Bit.addInput(getInput(0) , getInput(1) , getInput(2) , getInput(3) , getInput(4) , getInput(5) , getInput(6) , getInput(7) , getInput(8) , getInput(9) , getInput(10) , getInput(11) , getInput(12) , getInput(13)  , getInput(14) , getInput(15) , getInput(16) , getInput(17) , getInput(18) , getInput(19) , getInput(20) , getInput(21) , getInput(22) , getInput(23) , getInput(24) , getInput(25) , getInput(26) , getInput(27) , getInput(28) , getInput(29) , getInput(30) , getInput(31) , getInput(32) , getInput(33) , getInput(34) , getInput(35) , getInput(36) , getInput(37) , getInput(38) , getInput(39) , getInput(40) , getInput(41) , getInput(42) , getInput(43) , getInput(44) , getInput(45) , getInput(46) , getInput(47) , getInput(48) , getInput(49) , getInput(50) , getInput(51) , getInput(52) , getInput(53) , getInput(54) , getInput(55) , getInput(56) , getInput(57) , getInput(58) , getInput(59) , getInput(60) , getInput(61) , getInput(62) , getInput(63));

        if(getInput(64)== Simulator.falseLogic && getInput(65)==Simulator.falseLogic && getInput(66)==Simulator.trueLogic && getInput(67)==Simulator.falseLogic){
            addOutput(adder.getOutput(0) , adder.getOutput(1) , adder.getOutput(2) , adder.getOutput(3) , adder.getOutput(4) , adder.getOutput(5) , adder.getOutput(6) , adder.getOutput(7) , adder.getOutput(8) , adder.getOutput(9) , adder.getOutput(10) , adder.getOutput(11) , adder.getOutput(12), adder.getOutput(13) , adder.getOutput(14) , adder.getOutput(15) , adder.getOutput(16) , adder.getOutput(17) , adder.getOutput(18) , adder.getOutput(19) , adder.getOutput(20) , adder.getOutput(21) , adder.getOutput(22) , adder.getOutput(23) , adder.getOutput(24) , adder.getOutput(25) , adder.getOutput(26) , adder.getOutput(27) , adder.getOutput(28) , adder.getOutput(29) , adder.getOutput(30) , adder.getOutput(31));
        }

        if(getInput(64)== Simulator.falseLogic && getInput(65)==Simulator.trueLogic && getInput(66)==Simulator.trueLogic && getInput(67)==Simulator.falseLogic){
            addOutput(subtractor.getOutput(0) , subtractor.getOutput(1) , subtractor.getOutput(2) , subtractor.getOutput(3) , subtractor.getOutput(4) , subtractor.getOutput(5) , subtractor.getOutput(6) , subtractor.getOutput(7) , subtractor.getOutput(8) , subtractor.getOutput(9) , subtractor.getOutput(10) , subtractor.getOutput(11) , subtractor.getOutput(12), subtractor.getOutput(13) , subtractor.getOutput(14) , subtractor.getOutput(15) , subtractor.getOutput(16) , subtractor.getOutput(17) , subtractor.getOutput(18) , subtractor.getOutput(19) , subtractor.getOutput(20) , subtractor.getOutput(21) , subtractor.getOutput(22) , subtractor.getOutput(23) , subtractor.getOutput(24) , subtractor.getOutput(25) , subtractor.getOutput(26) , subtractor.getOutput(27) , subtractor.getOutput(28) , subtractor.getOutput(29) , subtractor.getOutput(30) , subtractor.getOutput(31));
        }

        if(getInput(64)== Simulator.falseLogic && getInput(65)==Simulator.falseLogic && getInput(66)==Simulator.falseLogic && getInput(67)==Simulator.falseLogic){
            addOutput(and32Bit.getOutput(0) , and32Bit.getOutput(1) , and32Bit.getOutput(2) , and32Bit.getOutput(3) , and32Bit.getOutput(4) , and32Bit.getOutput(5) , and32Bit.getOutput(6) , and32Bit.getOutput(7) , and32Bit.getOutput(8) , and32Bit.getOutput(9) , and32Bit.getOutput(10) , and32Bit.getOutput(11) , and32Bit.getOutput(12), and32Bit.getOutput(13) , and32Bit.getOutput(14) , and32Bit.getOutput(15) , and32Bit.getOutput(16) , and32Bit.getOutput(17) , and32Bit.getOutput(18) , and32Bit.getOutput(19) , and32Bit.getOutput(20) , and32Bit.getOutput(21) , and32Bit.getOutput(22) , and32Bit.getOutput(23) , and32Bit.getOutput(24) , and32Bit.getOutput(25) , and32Bit.getOutput(26) , and32Bit.getOutput(27) , and32Bit.getOutput(28) , and32Bit.getOutput(29) , and32Bit.getOutput(30) , and32Bit.getOutput(31));
        }

        if(getInput(64)== Simulator.falseLogic && getInput(65)==Simulator.falseLogic && getInput(66)==Simulator.trueLogic && getInput(67)==Simulator.trueLogic){
            addOutput(or32Bit.getOutput(0) , or32Bit.getOutput(1) , or32Bit.getOutput(2) , or32Bit.getOutput(3) , or32Bit.getOutput(4) , or32Bit.getOutput(5) , or32Bit.getOutput(6) , or32Bit.getOutput(7) , or32Bit.getOutput(8) , or32Bit.getOutput(9) , or32Bit.getOutput(10) , or32Bit.getOutput(11) , or32Bit.getOutput(12), or32Bit.getOutput(13) , or32Bit.getOutput(14) , or32Bit.getOutput(15) , or32Bit.getOutput(16) , or32Bit.getOutput(17) , or32Bit.getOutput(18) , or32Bit.getOutput(19) , or32Bit.getOutput(20) , or32Bit.getOutput(21) , or32Bit.getOutput(22) , or32Bit.getOutput(23) , or32Bit.getOutput(24) , or32Bit.getOutput(25) , or32Bit.getOutput(26) , or32Bit.getOutput(27) , or32Bit.getOutput(28) , or32Bit.getOutput(29) , or32Bit.getOutput(30) , or32Bit.getOutput(31));
        }

    }
}
