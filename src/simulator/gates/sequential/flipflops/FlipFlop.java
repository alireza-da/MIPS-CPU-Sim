
package simulator.gates.sequential.flipflops;

import simulator.network.Link;

public interface FlipFlop {
    void setOutput();
    void loadMemory();
    Link getData();
}