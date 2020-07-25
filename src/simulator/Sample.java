//Dedicated to Goli

package simulator;

import jdk.dynalink.linker.support.SimpleLinkRequest;
import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.combinational.Memory;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.gates.sequential.Clock;
import simulator.network.Link;
import simulator.wrapper.wrappers.DFlipFlop;
import simulator.wrapper.wrappers.RealDFlipFlop;
import simulator.wrapper.wrappers.Register;

import java.security.Signature;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sample {

    public static void main(String[] args) throws InterruptedException {
        Clock c = new Clock("c", 100);
        Register pc = new Register("PC","34X32",c.getOutput(0),Simulator.trueLogic);
        for (int i = 0; i < 32; i++) {
            pc.addInput(Simulator.falseLogic);
        }


        Memory instructionMemory = new Memory("Instruction Memory ");

        Link[] address = new Link[16];
        for (int i = 0 ; i<16 ; i++){
            address[i] = Simulator.falseLogic;
        }
        Link[] data = new Link[32];
        for (int i = 0 ; i<32 ; i++){
            data[i] = Simulator.trueLogic;
        }

        instructionMemory.addInput(Simulator.trueLogic);
        instructionMemory.addInput(address);
        instructionMemory.addInput(data);



//        for (int j = 0; j < 16; j++) {
//            assert false;
//            DFlipFlop d = new DFlipFlop("d"+ j, c.getOutput(0) , Simulator.falseLogic);
//            pc.getFlipFlops().add(d);
//            //System.out.println(d.getData().getSignal());
//        }

        instructionMemory.addInput(Simulator.trueLogic);
        for (Link link:pc.getOutputs()
             ) {
            instructionMemory.addInput(link);
        }
        //instructionMemory.addInput(pc.dataToArray()); // get outputs of PC by pc.getOutPuts()


        RegisterFile registerFile = new RegisterFile("Register file" , "49X64");
        registerFile.setRf(new HashMap<Integer, Register>());
        for (int i = 0 ; i < 32 ; i++) {
            Register r = new Register("r"+i,"34X32",c.getOutput(0));
            registerFile.getRf().put(i,r);
        }

        ControlUnit controlUnit = new ControlUnit("Control Unit" , "6X9");

        controlUnit.addInput(instructionMemory.getOutput(0) , instructionMemory.getOutput(1) , instructionMemory.getOutput(2) , instructionMemory.getOutput(3) , instructionMemory.getOutput(4) , instructionMemory.getOutput(5) );

        //write register 5 mux 2X1 to choose between instruction lines going to reg#2 regfile
        MultiPlexer multiPlexer1 = new MultiPlexer("mux1" , "3X1" , instructionMemory.getOutput(11) , instructionMemory.getOutput(16) , controlUnit.getOutput(0));
        MultiPlexer multiPlexer2 = new MultiPlexer("mux2" , "3X1" , instructionMemory.getOutput(12) , instructionMemory.getOutput(17) , controlUnit.getOutput(0));
        MultiPlexer multiPlexer3 = new MultiPlexer("mux3" , "3X1" , instructionMemory.getOutput(13) , instructionMemory.getOutput(18) , controlUnit.getOutput(0));
        MultiPlexer multiPlexer4 = new MultiPlexer("mux4" , "3X1" , instructionMemory.getOutput(14) , instructionMemory.getOutput(19) , controlUnit.getOutput(0));
        MultiPlexer multiPlexer5 = new MultiPlexer("mux5" , "3X1" , instructionMemory.getOutput(15) , instructionMemory.getOutput(20) , controlUnit.getOutput(0));

        registerFile.addInput(c.getOutput(0) , controlUnit.getOutput(8) , instructionMemory.getInput(6) , instructionMemory.getOutput(7) , instructionMemory.getOutput(8) , instructionMemory.getOutput(9) , instructionMemory.getOutput(10) , instructionMemory.getOutput(11) , instructionMemory.getOutput(12) , instructionMemory.getOutput(13) , instructionMemory.getOutput(14) , instructionMemory.getOutput(15) , multiPlexer1.getOutput(0) , multiPlexer2.getOutput(0) , multiPlexer3.getOutput(0) , multiPlexer4.getOutput(0) , multiPlexer5.getOutput(0) );
        //registerFile.addInput(data); // write data

        SignExtend16X32 signExtend16X32 = new SignExtend16X32("Sign Extend" , "16X32");
        signExtend16X32.addInput(instructionMemory.getOutput(16) , instructionMemory.getOutput(17) , instructionMemory.getOutput(18) , instructionMemory.getOutput(19) , instructionMemory.getOutput(20) , instructionMemory.getOutput(21) , instructionMemory.getOutput(22) , instructionMemory.getOutput(23) , instructionMemory.getOutput(24) , instructionMemory.getOutput(25) , instructionMemory.getOutput(26) , instructionMemory.getOutput(27) , instructionMemory.getOutput(28) , instructionMemory.getOutput(29) , instructionMemory.getOutput(30) , instructionMemory.getOutput(31));

        ALUControlUnit aluControlUnit = new ALUControlUnit("aluControl" , "8X4");
        aluControlUnit.addInput(controlUnit.getOutput(7) , controlUnit.getOutput(8));
        aluControlUnit.addInput(instructionMemory.getOutput(26) ,instructionMemory.getOutput(27) , instructionMemory.getOutput(28) , instructionMemory.getOutput(29) , instructionMemory.getOutput(30) , instructionMemory.getOutput(31) );

        //System.out.println( "reg" + registerFile.getOutput(32).getSignal().toString());

        // ALU SRC muxs
        And and = new And("and" , registerFile.getOutput(0) , registerFile.getOutput(32));
        MultiPlexer m1 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(32) , signExtend16X32.getOutput(0) , controlUnit.getOutput(1) );
        MultiPlexer m2 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(33) , signExtend16X32.getOutput(1) , controlUnit.getOutput(1));
        MultiPlexer m3 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(34) , signExtend16X32.getOutput(2) , controlUnit.getOutput(1));
        MultiPlexer m4 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(35) , signExtend16X32.getOutput(3) , controlUnit.getOutput(1));
        MultiPlexer m5 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(36) , signExtend16X32.getOutput(4) , controlUnit.getOutput(1));
        MultiPlexer m6 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(37) , signExtend16X32.getOutput(5) , controlUnit.getOutput(1));
        MultiPlexer m7 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(38) , signExtend16X32.getOutput(6) , controlUnit.getOutput(1));
        MultiPlexer m8 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(39) , signExtend16X32.getOutput(7) , controlUnit.getOutput(1));
        MultiPlexer m9 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(40) , signExtend16X32.getOutput(8) , controlUnit.getOutput(1));
        MultiPlexer m10 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(41) , signExtend16X32.getOutput(9) , controlUnit.getOutput(1));
        MultiPlexer m11 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(42) , signExtend16X32.getOutput(10) , controlUnit.getOutput(1));
        MultiPlexer m12 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(43) , signExtend16X32.getOutput(11) , controlUnit.getOutput(1));
        MultiPlexer m13 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(44) , signExtend16X32.getOutput(12) , controlUnit.getOutput(1));
        MultiPlexer m14 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(45) , signExtend16X32.getOutput(13) , controlUnit.getOutput(1));
        MultiPlexer m15 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(46) , signExtend16X32.getOutput(14) , controlUnit.getOutput(1));
        MultiPlexer m16 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(47) , signExtend16X32.getOutput(15) , controlUnit.getOutput(1));
        MultiPlexer m17 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(48) , signExtend16X32.getOutput(16) , controlUnit.getOutput(1));
        MultiPlexer m18 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(49) , signExtend16X32.getOutput(17) , controlUnit.getOutput(1));
        MultiPlexer m19 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(50) , signExtend16X32.getOutput(18) , controlUnit.getOutput(1));
        MultiPlexer m20 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(51) , signExtend16X32.getOutput(19) , controlUnit.getOutput(1));
        MultiPlexer m21 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(52) , signExtend16X32.getOutput(20) , controlUnit.getOutput(1));
        MultiPlexer m22 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(53) , signExtend16X32.getOutput(21) , controlUnit.getOutput(1));
        MultiPlexer m23 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(54) , signExtend16X32.getOutput(22) , controlUnit.getOutput(1));
        MultiPlexer m24 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(55) , signExtend16X32.getOutput(23) , controlUnit.getOutput(1));
        MultiPlexer m25 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(56) , signExtend16X32.getOutput(24) , controlUnit.getOutput(1));
        MultiPlexer m26 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(57) , signExtend16X32.getOutput(25) , controlUnit.getOutput(1));
        MultiPlexer m27 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(58) , signExtend16X32.getOutput(26) , controlUnit.getOutput(1));
        MultiPlexer m28 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(59) , signExtend16X32.getOutput(27) , controlUnit.getOutput(1));
        MultiPlexer m29 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(60) , signExtend16X32.getOutput(28) , controlUnit.getOutput(1));
        MultiPlexer m30 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(61) , signExtend16X32.getOutput(29) , controlUnit.getOutput(1));
        MultiPlexer m31 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(62) , signExtend16X32.getOutput(30) , controlUnit.getOutput(1));
        MultiPlexer m32 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(63) , signExtend16X32.getOutput(31) , controlUnit.getOutput(1));


        ALU alu = new ALU("ALU" , "68X32");
        alu.addInput(registerFile.getOutput(0) , registerFile.getOutput(1) , registerFile.getOutput(2) , registerFile.getOutput(3) , registerFile.getOutput(4) , registerFile.getOutput(5) , registerFile.getOutput(6) , registerFile.getOutput(7) , registerFile.getOutput(8), registerFile.getOutput(9), registerFile.getOutput(10), registerFile.getOutput(11), registerFile.getOutput(12), registerFile.getOutput(13) ,registerFile.getOutput(14), registerFile.getOutput(15) ,registerFile.getOutput(16) , registerFile.getOutput(17) , registerFile.getOutput(18) , registerFile.getOutput(19), registerFile.getOutput(20) , registerFile.getOutput(21) , registerFile.getOutput(22), registerFile.getOutput(23) , registerFile.getOutput(24) , registerFile.getOutput(25) , registerFile.getOutput(26) , registerFile.getOutput(27) , registerFile.getOutput(28) , registerFile.getOutput(29) , registerFile.getOutput(30) ,registerFile.getOutput(31));
        alu.addInput(m1.getOutput(0) , m2.getOutput(0) , m3.getOutput(0) , m4.getOutput(0) , m5.getOutput(0), m6.getOutput(0) , m7.getOutput(0), m8.getOutput(0), m9.getOutput(0) , m10.getOutput(0) , m11.getOutput(0) , m12.getOutput(0) , m13.getOutput(0), m14.getOutput(0) , m15.getOutput(0) , m16.getOutput(0) , m17.getOutput(0) , m18.getOutput(0) , m19.getOutput(0) , m20.getOutput(0) , m21.getOutput(0) , m22.getOutput(0) , m23.getOutput(0) , m24.getOutput(0) , m25.getOutput(0) , m26.getOutput(0) , m27.getOutput(0) , m28.getOutput(0) , m29.getOutput(0) , m30.getOutput(0) , m31.getOutput(0));
        alu.addInput(aluControlUnit.getOutput(0) ,aluControlUnit.getOutput(1) , aluControlUnit.getOutput(2) , aluControlUnit.getOutput(3));

        DataMemory dataMemory = new DataMemory("Data Memory" , "50X32");
        dataMemory.addInput(alu.getOutput(16) , alu.getOutput(17) , alu.getOutput(18) , alu.getOutput(19) , alu.getOutput(20) , alu.getOutput(21) , alu.getOutput(22) , alu.getOutput(23) , alu.getOutput(24) , alu.getOutput(25) , alu.getOutput(26), alu.getOutput(27) , alu.getOutput(28) , alu.getOutput(29) , alu.getOutput(30) , alu.getOutput(31) );
        dataMemory.addInput(registerFile.getOutput(0) , registerFile.getOutput(1) , registerFile.getOutput(2) , registerFile.getOutput(3) , registerFile.getOutput(4) , registerFile.getOutput(5) , registerFile.getOutput(6) , registerFile.getOutput(7) , registerFile.getOutput(8) , registerFile.getOutput(9) , registerFile.getOutput(10) , registerFile.getOutput(11) , registerFile.getOutput(12) , registerFile.getOutput(13) , registerFile.getOutput(14) , registerFile.getOutput(15) , registerFile.getOutput(16) , registerFile.getOutput(17) , registerFile.getOutput(18) , registerFile.getOutput(19) , registerFile.getOutput(20) , registerFile.getOutput(21) , registerFile.getOutput(22) , registerFile.getOutput(23) , registerFile.getOutput(24) , registerFile.getOutput(25) , registerFile.getOutput(26) , registerFile.getOutput(27) , registerFile.getOutput(28) , registerFile.getOutput(29) , registerFile.getOutput(30) , registerFile.getOutput(31) );
        dataMemory.addInput(controlUnit.getOutput(5) , controlUnit.getOutput(4));

        // mem to Reg Muxs

        MultiPlexer mux0 = new MultiPlexer("m1" , "3X1" , alu.getOutput(0) , dataMemory.getOutput(0) , controlUnit.getOutput(2));
        MultiPlexer mux1 = new MultiPlexer("m1" , "3X1" , alu.getOutput(1) , dataMemory.getOutput(1) , controlUnit.getOutput(2));
        MultiPlexer mux2 = new MultiPlexer("m1" , "3X1" , alu.getOutput(2) , dataMemory.getOutput(2) , controlUnit.getOutput(2));
        MultiPlexer mux3 = new MultiPlexer("m1" , "3X1" , alu.getOutput(3) , dataMemory.getOutput(3) , controlUnit.getOutput(2));
        MultiPlexer mux4 = new MultiPlexer("m1" , "3X1" , alu.getOutput(4) , dataMemory.getOutput(4) , controlUnit.getOutput(2));
        MultiPlexer mux5 = new MultiPlexer("m1" , "3X1" , alu.getOutput(5) , dataMemory.getOutput(5) , controlUnit.getOutput(2));
        MultiPlexer mux6 = new MultiPlexer("m1" , "3X1" , alu.getOutput(6) , dataMemory.getOutput(6) , controlUnit.getOutput(2));
        MultiPlexer mux7 = new MultiPlexer("m1" , "3X1" , alu.getOutput(7) , dataMemory.getOutput(7) , controlUnit.getOutput(2));
        MultiPlexer mux8 = new MultiPlexer("m1" , "3X1" , alu.getOutput(8) , dataMemory.getOutput(8) , controlUnit.getOutput(2));
        MultiPlexer mux9 = new MultiPlexer("m1" , "3X1" , alu.getOutput(9) , dataMemory.getOutput(9) , controlUnit.getOutput(2));
        MultiPlexer mux10 = new MultiPlexer("m1" , "3X1" , alu.getOutput(10) , dataMemory.getOutput(10) , controlUnit.getOutput(2));
        MultiPlexer mux11 = new MultiPlexer("m1" , "3X1" , alu.getOutput(11) , dataMemory.getOutput(11) , controlUnit.getOutput(2));
        MultiPlexer mux12 = new MultiPlexer("m1" , "3X1" , alu.getOutput(12) , dataMemory.getOutput(12) , controlUnit.getOutput(2));
        MultiPlexer mux13 = new MultiPlexer("m1" , "3X1" , alu.getOutput(13) , dataMemory.getOutput(13) , controlUnit.getOutput(2));
        MultiPlexer mux14 = new MultiPlexer("m1" , "3X1" , alu.getOutput(14) , dataMemory.getOutput(14) , controlUnit.getOutput(2));
        MultiPlexer mux15 = new MultiPlexer("m1" , "3X1" , alu.getOutput(15) , dataMemory.getOutput(15) , controlUnit.getOutput(2));
        MultiPlexer mux16 = new MultiPlexer("m1" , "3X1" , alu.getOutput(16) , dataMemory.getOutput(16) , controlUnit.getOutput(2));
        MultiPlexer mux17 = new MultiPlexer("m1" , "3X1" , alu.getOutput(17) , dataMemory.getOutput(17) , controlUnit.getOutput(2));
        MultiPlexer mux18 = new MultiPlexer("m1" , "3X1" , alu.getOutput(18) , dataMemory.getOutput(18) , controlUnit.getOutput(2));
        MultiPlexer mux19 = new MultiPlexer("m1" , "3X1" , alu.getOutput(19) , dataMemory.getOutput(19) , controlUnit.getOutput(2));
        MultiPlexer mux20 = new MultiPlexer("m1" , "3X1" , alu.getOutput(20) , dataMemory.getOutput(20) , controlUnit.getOutput(2));
        MultiPlexer mux21 = new MultiPlexer("m1" , "3X1" , alu.getOutput(21) , dataMemory.getOutput(21) , controlUnit.getOutput(2));
        MultiPlexer mux22 = new MultiPlexer("m1" , "3X1" , alu.getOutput(22) , dataMemory.getOutput(22) , controlUnit.getOutput(2));
        MultiPlexer mux23 = new MultiPlexer("m1" , "3X1" , alu.getOutput(23) , dataMemory.getOutput(23) , controlUnit.getOutput(2));
        MultiPlexer mux24 = new MultiPlexer("m1" , "3X1" , alu.getOutput(24) , dataMemory.getOutput(24) , controlUnit.getOutput(2));
        MultiPlexer mux25 = new MultiPlexer("m1" , "3X1" , alu.getOutput(25) , dataMemory.getOutput(25) , controlUnit.getOutput(2));
        MultiPlexer mux26 = new MultiPlexer("m1" , "3X1" , alu.getOutput(26) , dataMemory.getOutput(26) , controlUnit.getOutput(2));
        MultiPlexer mux27 = new MultiPlexer("m1" , "3X1" , alu.getOutput(27) , dataMemory.getOutput(27) , controlUnit.getOutput(2));
        MultiPlexer mux28 = new MultiPlexer("m1" , "3X1" , alu.getOutput(28) , dataMemory.getOutput(28) , controlUnit.getOutput(2));
        MultiPlexer mux29 = new MultiPlexer("m1" , "3X1" , alu.getOutput(29) , dataMemory.getOutput(29) , controlUnit.getOutput(2));
        MultiPlexer mux30 = new MultiPlexer("m1" , "3X1" , alu.getOutput(30) , dataMemory.getOutput(30) , controlUnit.getOutput(2));
        MultiPlexer mux31 = new MultiPlexer("m1" , "3X1" , alu.getOutput(31) , dataMemory.getOutput(31) , controlUnit.getOutput(2));

        registerFile.addInput(mux0.getOutput(0) , mux1.getOutput(0) , mux2.getOutput(0) , mux3.getOutput(0) , mux4.getOutput(0) , mux5.getOutput(0) , mux6.getOutput(0) , mux7.getOutput(0) , mux8.getOutput(0) , mux9.getOutput(0) , mux10.getOutput(0) , mux11.getOutput(0) , mux12.getOutput(0) , mux13.getOutput(0) , mux14.getOutput(0) , mux15.getOutput(0) , mux16.getOutput(0) , mux17.getOutput(0) , mux18.getOutput(0) , mux19.getOutput(0) , mux20.getOutput(0) , mux21.getOutput(0) , mux22.getOutput(0) , mux23.getOutput(0) , mux24.getOutput(0) , mux25.getOutput(0) , mux26.getOutput(0) , mux27.getOutput(0) , mux28.getOutput(0) , mux29.getOutput(0) , mux30.getOutput(0) , mux31.getOutput(0));

        Shift2Times shift2Times = new Shift2Times("shift2X" , "32X32" , signExtend16X32.getOutput(0) , signExtend16X32.getOutput(1) , signExtend16X32.getOutput(2) , signExtend16X32.getOutput(3) , signExtend16X32.getOutput(4) , signExtend16X32.getOutput(5) , signExtend16X32.getOutput(6) , signExtend16X32.getOutput(7) , signExtend16X32.getOutput(8) , signExtend16X32.getOutput(9) , signExtend16X32.getOutput(10) , signExtend16X32.getOutput(11) , signExtend16X32.getOutput(12) , signExtend16X32.getOutput(13) , signExtend16X32.getOutput(14) , signExtend16X32.getOutput(15) , signExtend16X32.getOutput(16) , signExtend16X32.getOutput(17) , signExtend16X32.getOutput(18) , signExtend16X32.getOutput(19) , signExtend16X32.getOutput(20) , signExtend16X32.getOutput(21) , signExtend16X32.getOutput(22) , signExtend16X32.getOutput(23) , signExtend16X32.getOutput(24) , signExtend16X32.getOutput(25) , signExtend16X32.getOutput(26) , signExtend16X32.getOutput(27) , signExtend16X32.getOutput(28) , signExtend16X32.getOutput(29) , signExtend16X32.getOutput(30) , signExtend16X32.getOutput(31) );

        Link[] number4 = new Link[32];
        for(int i=0 ; i<32 ; i++){
            number4[i] = Simulator.falseLogic;
        }
        number4[2] = Simulator.trueLogic;

        Link[] zero16bit = new Link[16];
        for (int i=0 ; i<16 ; i++){
            zero16bit[i] = Simulator.falseLogic;
        }

        Adder adder1 = new Adder("adder1" , "64X33");
        adder1.addInput(zero16bit);
        System.out.println(pc.getOutputSize());
        for (Link link:pc.getOutputs()
             ) {
            adder1.addInput(link);
        }
        //adder1.addInput(pc.dataToArray()); // get outputs of PC by pc.getOutPuts()
        adder1.addInput(number4);

        Adder adder2 = new Adder("adder2" , "64X33");
        adder2.addInput(adder1.getOutput(0) , adder1.getOutput(1) , adder1.getOutput(2) , adder1.getOutput(3) , adder1.getOutput(4) , adder1.getOutput(5) , adder1.getOutput(6) , adder1.getOutput(7) , adder1.getOutput(8) , adder1.getOutput(9) , adder1.getOutput(10) , adder1.getOutput(11) , adder1.getOutput(12) , adder1.getOutput(13) , adder1.getOutput(14) , adder1.getOutput(15) , adder1.getOutput(16) , adder1.getOutput(17) , adder1.getOutput(18) , adder1.getOutput(19) , adder1.getOutput(20) , adder1.getOutput(21) , adder1.getOutput(22) , adder1.getOutput(23) , adder1.getOutput(24) , adder1.getOutput(25) , adder1.getOutput(26) , adder1.getOutput(27) , adder1.getOutput(28) , adder1.getOutput(29) , adder1.getOutput(30) ,adder1.getOutput(31) );
        adder2.addInput(shift2Times.getOutput(0) ,shift2Times.getOutput(1) , shift2Times.getOutput(2) , shift2Times.getOutput(3), shift2Times.getOutput(4), shift2Times.getOutput(5) , shift2Times.getOutput(6) , shift2Times.getOutput(7) , shift2Times.getOutput(8) , shift2Times.getOutput(9), shift2Times.getOutput(10) , shift2Times.getOutput(11) , shift2Times.getOutput(12) , shift2Times.getOutput(13) , shift2Times.getOutput(14), shift2Times.getOutput(15) , shift2Times.getOutput(16) , shift2Times.getOutput(17), shift2Times.getOutput(18) , shift2Times.getOutput(19), shift2Times.getOutput(20), shift2Times.getOutput(21) ,shift2Times.getOutput(22) ,shift2Times.getOutput(23), shift2Times.getOutput(24) ,shift2Times.getOutput(25) ,shift2Times.getOutput(26) , shift2Times.getOutput(27) , shift2Times.getOutput(28) , shift2Times.getOutput(29) , shift2Times.getOutput(30) , shift2Times.getOutput(31) );

        And andALU = new And("andALU" , alu.getOutput(0) ,alu.getOutput(1) , alu.getOutput(2) , alu.getOutput(3) , alu.getOutput(4) , alu.getOutput(5) , alu.getOutput(6) , alu.getOutput(7) , alu.getOutput(8) , alu.getOutput(9), alu.getOutput(10) , alu.getOutput(11) , alu.getOutput(12) , alu.getOutput(13) , alu.getOutput(14) , alu.getOutput(15) , alu.getOutput(16) , alu.getOutput(17), alu.getOutput(18), alu.getOutput(19) , alu.getOutput(20) , alu.getOutput(21) , alu.getOutput(22) , alu.getOutput(23) , alu.getOutput(24) , alu.getOutput(25) , alu.getOutput(26) , alu.getOutput(27) , alu.getOutput(28) , alu.getOutput(29) , alu.getOutput(30) , alu.getOutput(31) );
        Not zeroBit = new Not("Not" , andALU.getOutput(0));
        And ifBranch = new And("and" , zeroBit.getOutput(0) , controlUnit.getOutput(6));

        // PC SRC muxs
        MultiPlexer muxx0 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(0) , adder2.getOutput(0) , ifBranch.getOutput(0) );
        MultiPlexer muxx1 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(1) , adder2.getOutput(1) , ifBranch.getOutput(0));
        MultiPlexer muxx2 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(2) , adder2.getOutput(2) , ifBranch.getOutput(0));
        MultiPlexer muxx3 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(3) , adder2.getOutput(3) , ifBranch.getOutput(0));
        MultiPlexer muxx4 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(4) , adder2.getOutput(4) , ifBranch.getOutput(0));
        MultiPlexer muxx5 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(5) , adder2.getOutput(5) , ifBranch.getOutput(0));
        MultiPlexer muxx6 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(6) , adder2.getOutput(6) , ifBranch.getOutput(0));
        MultiPlexer muxx7 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(7) , adder2.getOutput(7) , ifBranch.getOutput(0));
        MultiPlexer muxx8 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(8) , adder2.getOutput(8) , ifBranch.getOutput(0));
        MultiPlexer muxx9 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(9) , adder2.getOutput(9) , ifBranch.getOutput(0));
        MultiPlexer muxx10 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(10) , adder2.getOutput(10) , ifBranch.getOutput(0));
        MultiPlexer muxx11 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(11) , adder2.getOutput(11) , ifBranch.getOutput(0));
        MultiPlexer muxx12 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(12) , adder2.getOutput(12) , ifBranch.getOutput(0));
        MultiPlexer muxx13 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(13) , adder2.getOutput(13) , ifBranch.getOutput(0));
        MultiPlexer muxx14 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(14) , adder2.getOutput(14) , ifBranch.getOutput(0));
        MultiPlexer muxx15 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(15) , adder2.getOutput(15) , ifBranch.getOutput(0));
        MultiPlexer muxx16 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(16) , adder2.getOutput(16) , ifBranch.getOutput(0));
        MultiPlexer muxx17 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(17) , adder2.getOutput(17) , ifBranch.getOutput(0));
        MultiPlexer muxx18 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(18) , adder2.getOutput(18) , ifBranch.getOutput(0));
        MultiPlexer muxx19 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(19) , adder2.getOutput(19) , ifBranch.getOutput(0));
        MultiPlexer muxx20 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(20) , adder2.getOutput(20) , ifBranch.getOutput(0));
        MultiPlexer muxx21 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(21) , adder2.getOutput(21) , ifBranch.getOutput(0));
        MultiPlexer muxx22 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(22) , adder2.getOutput(22) , ifBranch.getOutput(0));
        MultiPlexer muxx23 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(23) , adder2.getOutput(23) , ifBranch.getOutput(0));
        MultiPlexer muxx24 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(24) , adder2.getOutput(24) , ifBranch.getOutput(0));
        MultiPlexer muxx25 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(25) , adder2.getOutput(25) , ifBranch.getOutput(0));
        MultiPlexer muxx26 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(26) , adder2.getOutput(26) , ifBranch.getOutput(0));
        MultiPlexer muxx27 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(27) , adder2.getOutput(27) , ifBranch.getOutput(0));
        MultiPlexer muxx28 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(28) , adder2.getOutput(28) , ifBranch.getOutput(0));
        MultiPlexer muxx29 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(29) , adder2.getOutput(29) , ifBranch.getOutput(0));
        MultiPlexer muxx30 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(30) , adder2.getOutput(30) , ifBranch.getOutput(0));
        MultiPlexer muxx31 = new MultiPlexer("mux" , "3X1" , adder1.getOutput(31) , adder2.getOutput(31) , ifBranch.getOutput(0));


        // set data by adding inputs to pc
          //pc.addInput(muxx16.getOutput(0));
//        pc.addInput(muxx17.getOutput(0));
//        pc.addInput(muxx18.getOutput(0));
//        pc.getFlipFlops().get(3).setData(muxx19.getOutput(0));
//        pc.getFlipFlops().get(4).setData(muxx20.getOutput(0));
//        pc.getFlipFlops().get(5).setData(muxx21.getOutput(0));
//        pc.getFlipFlops().get(6).setData(muxx22.getOutput(0));
//        pc.getFlipFlops().get(7).setData(muxx23.getOutput(0));
//        pc.getFlipFlops().get(8).setData(muxx24.getOutput(0));
//        pc.getFlipFlops().get(9).setData(muxx25.getOutput(0));
//        pc.getFlipFlops().get(10).setData(muxx26.getOutput(0));
//        pc.getFlipFlops().get(11).setData(muxx27.getOutput(0));
//        pc.getFlipFlops().get(12).setData(muxx28.getOutput(0));
//        pc.getFlipFlops().get(13).setData(muxx29.getOutput(0));
//        pc.getFlipFlops().get(14).setData(muxx30.getOutput(0));
//        pc.getFlipFlops().get(15).setData(muxx31.getOutput(0));





        Simulator.debugger.addTrackItem(adder1);
        Simulator.debugger.setDelay(1000);
        Simulator.circuit.startCircuit();


    }
}