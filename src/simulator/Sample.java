//Dedicated to Goli

package simulator;

import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.combinational.Memory;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.gates.sequential.Clock;
import simulator.gates.sequential.flipflops.DFlipFlop;
import simulator.network.Link;
import simulator.wrapper.wrappers.RealDFlipFlop;

import java.security.Signature;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sample {

    public static void toBinary(List<Link> data){
        int len = data.size();
        int i=0;
        for(i=0 ; i<len ; i++){
            if (data.get(i).getSignal().booleanValue() == true){
                System.out.printf("1");
            }
            if (data.get(i).getSignal().booleanValue() == false){
                System.out.printf("0");
            }
        }
        System.out.println("\n");
    }



    public static void main(String[] args) throws InterruptedException {

        Register pc = new Register();

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

        Clock c = new Clock("c", 100);

        for (int j = 0; j < 16; j++) {
            assert false;
            DFlipFlop d = new DFlipFlop("d"+ j, c.getOutput(0) , Simulator.falseLogic);
            pc.getFlipFlops().add(d);
        }

        instructionMemory.addInput(Simulator.falseLogic);
        instructionMemory.addInput(pc.dataToArray());

        RegisterFile registerFile = new RegisterFile("Register file" , "49X64");

        for (int i = 0 ; i < 32 ; i++) {
            registerFile.setRf(new HashMap<Integer, Register>());
            Register r = new Register();
            for (int j = 0; j < 32; j++) {
                DFlipFlop d = new DFlipFlop("d" + j, c.getOutput(0), Simulator.falseLogic);
                r.getFlipFlops().add(d);
            }
            r.setClockValue(c.getOutput(0));
            registerFile.getRf().put(i, r);
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
        registerFile.addInput(data); // write data

        SignExtend16X32 signExtend16X32 = new SignExtend16X32("Sign Extend" , "16X32");
        signExtend16X32.addInput(instructionMemory.getOutput(16) , instructionMemory.getOutput(17) , instructionMemory.getOutput(18) , instructionMemory.getOutput(19) , instructionMemory.getOutput(20) , instructionMemory.getOutput(21) , instructionMemory.getOutput(22) , instructionMemory.getOutput(23) , instructionMemory.getOutput(24) , instructionMemory.getOutput(25) , instructionMemory.getOutput(26) , instructionMemory.getOutput(27) , instructionMemory.getOutput(28) , instructionMemory.getOutput(29) , instructionMemory.getOutput(30) , instructionMemory.getOutput(31));

        ALUControlUnit aluControlUnit = new ALUControlUnit("aluControl" , "8X4");
        aluControlUnit.addInput(controlUnit.getOutput(7) , controlUnit.getOutput(8));
        aluControlUnit.addInput(instructionMemory.getOutput(26) ,instructionMemory.getOutput(27) , instructionMemory.getOutput(28) , instructionMemory.getOutput(29) , instructionMemory.getOutput(30) , instructionMemory.getOutput(31) );

        //System.out.println( "reg" + registerFile.getOutput(32).getSignal().toString());

        // ALU SRC muxs
        And and = new And("and" , registerFile.getOutput(0) , registerFile.getOutput(32));
        //MultiPlexer m1 = new MultiPlexer("M1" , "3X1" , registerFile.getOutput(32) , signExtend16X32.getOutput(0) , controlUnit.getOutput(1) );

        /*
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

        //toBinary(dataMemory.getOutputs());
*/
        Simulator.debugger.addTrackItem(instructionMemory , registerFile , signExtend16X32 , controlUnit , aluControlUnit );
        Simulator.debugger.setDelay(500);
        Simulator.circuit.startCircuit();


    }
}