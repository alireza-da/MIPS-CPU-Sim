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
        Clock c = new Clock("c", 500);
        RegisterFile registerFile = new RegisterFile("registerFile", "49X64",c.getOutput(0),Simulator.trueLogic);

        for (int i = 0; i < 47; i++) {
            registerFile.addInput(Simulator.falseLogic);
        }

        Simulator.debugger.addTrackItem(registerFile);
        Simulator.debugger.setDelay(500);
        Simulator.circuit.startCircuit();


    }
}