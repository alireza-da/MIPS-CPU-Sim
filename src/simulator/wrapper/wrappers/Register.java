package simulator.wrapper.wrappers;


import simulator.network.Link;
import simulator.wrapper.Wrapper;

/* in:
* 0 : clock  signal
* 1 : write signal
* 2 -> 33 : data in */
public class Register extends Wrapper {
    public Register(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        DFlipFlop[] reg = new DFlipFlop[32];
        MultiplexerDynamic[] sel = new MultiplexerDynamic[32];

        for (int i = 0; i < 32; ++i) {
            reg[i] = new DFlipFlop("D" + i, "2X2", getInput(0));
        }

        for (int i = 0; i < 32; i++) {

            sel[i] = new MultiplexerDynamic("SEL" + i, "3X1", getInput(1), reg[i].getOutput(0), getInput(i + 2));
        }

        for (int i = 0; i < 32; ++i) {
            reg[i].addInput(sel[i].getOutput(0));
        }

        for (int i = 0; i < 32; ++i) {
            addOutput(reg[i].getOutput(0));
        }
    }
}
