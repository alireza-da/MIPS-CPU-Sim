package simulator;

import simulator.Dec5X32;
import simulator.control.Simulator;

import simulator.gates.combinational.And;

import simulator.gates.sequential.Clock;


import simulator.network.Link;

import simulator.wrapper.Wrapper;
import simulator.wrapper.wrappers.MultiplexerDynamic;
import simulator.wrapper.wrappers.Register;


import java.util.ArrayList;

import java.util.HashMap;



public class RegisterFile extends Wrapper {

    private ArrayList<Register> rf = new ArrayList<>();

    //clock cycle 0 , regWrite signal 1 , register read 1(2:6) , 2(7:11) ; register write(12:16) , write data ( 17:48 )

    public RegisterFile(String label, String stream, Link... links){
        super(label,stream,links);
    }



    @Override
    public void initialize() {
        rf = new ArrayList<>();

        //System.out.println(getInput(1).getSignal());
        // adding clock cycle to registers

//        for (Link link: getOutputs()
//             ) {
//            System.out.println(link.getSignal());
//
//        }

        for (int i = 0 ; i < 32 ; i++) {
            Register r = new Register("r"+i,"34X32",getInput(0));
            rf.add(r);
        }

        // write

        Dec5X32 dec = new Dec5X32("registerFileReadDec","5X32",getInput(12), getInput(13), getInput(14), getInput(15), getInput(16)); // 10000


        And a0 = new And("and0",getInput(1),dec.getOutput(0));

        And a1 = new And("and1",getInput(1),dec.getOutput(1));

        And a2 = new And("and2",getInput(1),dec.getOutput(2));

        And a3 = new And("and3",getInput(1),dec.getOutput(3));

        And a4 = new And("and4",getInput(1),dec.getOutput(4));

        And a5 = new And("and5",getInput(1),dec.getOutput(5));

        And a6 = new And("and6",getInput(1),dec.getOutput(6));

        And a7 = new And("and7",getInput(1),dec.getOutput(7));

        And a8 = new And("and8",getInput(1),dec.getOutput(8));

        And a9 = new And("and9",getInput(1),dec.getOutput(9));

        And a10 = new And("and10",getInput(1),dec.getOutput(10));

        And a11 = new And("and11",getInput(1),dec.getOutput(11));

        And a12 = new And("and12",getInput(1),dec.getOutput(12));

        And a13 = new And("and13",getInput(1),dec.getOutput(13));

        And a14 = new And("and14",getInput(1),dec.getOutput(14));

        And a15 = new And("and15",getInput(1),dec.getOutput(15));

        And a16 = new And("and16",getInput(1),dec.getOutput(16));

        And a17 = new And("and17",getInput(1),dec.getOutput(17));

        And a18 = new And("and18",getInput(1),dec.getOutput(18));

        And a19 = new And("and19",getInput(1),dec.getOutput(19));

        And a20 = new And("and20",getInput(1),dec.getOutput(20));

        And a21 = new And("and21",getInput(1),dec.getOutput(21));

        And a22 = new And("and22",getInput(1),dec.getOutput(22));

        And a23 = new And("and23",getInput(1),dec.getOutput(23));

        And a24 = new And("and24",getInput(1),dec.getOutput(24));

        And a25 = new And("and25",getInput(1),dec.getOutput(25));

        And a26 = new And("and26",getInput(1),dec.getOutput(26));

        And a27 = new And("and27",getInput(1),dec.getOutput(27));

        And a28 = new And("and28",getInput(1),dec.getOutput(28));

        And a29 = new And("and29",getInput(1),dec.getOutput(29));

        And a30 = new And("and30",getInput(1),dec.getOutput(30));

        And a31 = new And("and31",getInput(1),dec.getOutput(31));
//        System.out.println("inputs");
//        for (Link link:getInputs()
//             ) {
//            System.out.println(link.getSignal());
//        }
//        System.out.println("outputs");
//        for (Link link:getOutputs()
//        ) {
//            System.out.println(link.getSignal());
//        }

        //set write signal of register



        rf.get(0).addInput(a0.getOutput(0));

        rf.get(1).addInput(a1.getOutput(0));

        rf.get(2).addInput(a2.getOutput(0));

        rf.get(3).addInput(a3.getOutput(0));

        rf.get(4).addInput(a4.getOutput(0));

        rf.get(5).addInput(a5.getOutput(0));

        rf.get(6).addInput(a6.getOutput(0));

        rf.get(7).addInput(a7.getOutput(0));

        rf.get(8).addInput(a8.getOutput(0));

        rf.get(9).addInput(a9.getOutput(0));

        rf.get(10).addInput(a10.getOutput(0));

        rf.get(11).addInput(a11.getOutput(0));

        rf.get(12).addInput(a12.getOutput(0));

        rf.get(13).addInput(a13.getOutput(0));

        rf.get(14).addInput(a14.getOutput(0));

        rf.get(15).addInput(a15.getOutput(0));

        rf.get(16).addInput(a16.getOutput(0));

        rf.get(17).addInput(a17.getOutput(0));

        rf.get(18).addInput(a18.getOutput(0));

        rf.get(19).addInput(a19.getOutput(0));

        rf.get(20).addInput(a20.getOutput(0));

        rf.get(21).addInput(a21.getOutput(0));

        rf.get(22).addInput(a22.getOutput(0));

        rf.get(23).addInput(a23.getOutput(0));

        rf.get(24).addInput(a24.getOutput(0));

        rf.get(25).addInput(a25.getOutput(0));

        rf.get(26).addInput(a26.getOutput(0));

        rf.get(27).addInput(a27.getOutput(0));

        rf.get(28).addInput(a28.getOutput(0));

        rf.get(29).addInput(a29.getOutput(0));

        rf.get(30).addInput(a30.getOutput(0));

        rf.get(31).addInput(a31.getOutput(0));

        for (int i = 0; i < 32; i++) {

            for (int k = 17; k < 49; k++) {
                rf.get(i).addInput(getInput(k));
            }

        }

        // read data 1

        //32 mux (32X1) with register addresses control lines

        MultiplexerDynamic m1 = new MultiplexerDynamic("mux1","37X1");

        m1.addInput(getInput(2));

        m1.addInput(getInput(3));

        m1.addInput(getInput(4));

        m1.addInput(getInput(5));

        m1.addInput(getInput(6));

        for (int i = 0; i < 32 ; i++) {

            m1.addInput(rf.get(i).getOutput(0));

        }

        addOutput(m1.getOutput(0)); //read data 1 bit 0

        MultiplexerDynamic m2 = new MultiplexerDynamic("mux2","37X1");

        m2.addInput(getInput(2));

        m2.addInput(getInput(3));

        m2.addInput(getInput(4));

        m2.addInput(getInput(5));

        m2.addInput(getInput(6));

        for (int i = 0; i < 32 ; i++) {

            m2.addInput(rf.get(i).getOutputs().get(1));

        }



        addOutput(m2.getOutput(0)); //read data 1 bit 1



        MultiplexerDynamic m3 = new MultiplexerDynamic("mux3","37X1");

        m3.addInput(getInput(2));

        m3.addInput(getInput(3));

        m3.addInput(getInput(4));

        m3.addInput(getInput(5));

        m3.addInput(getInput(6));

        for (int i = 0; i < 32 ; i++) {

            m3.addInput(rf.get(i).getOutputs().get(2));

        }

        addOutput(m3.getOutput(0)); //read data 1 bit 2



        MultiplexerDynamic m4 = new MultiplexerDynamic("mux4","37X1");

        m4.addInput(getInput(2));

        m4.addInput(getInput(3));

        m4.addInput(getInput(4));

        m4.addInput(getInput(5));

        m4.addInput(getInput(6));

        for (int i = 0; i < 32 ; i++) {

            m4.addInput(rf.get(i).getOutputs().get(3));

        }

        addOutput(m4.getOutput(0)); //read data 1 bit 3



        MultiplexerDynamic m5 = new MultiplexerDynamic("mux5","37X1");

        m5.addInput(getInput(2));

        m5.addInput(getInput(3));

        m5.addInput(getInput(4));

        m5.addInput(getInput(5));

        m5.addInput(getInput(6));


        for (int i = 0; i < 32 ; i++) {

            m5.addInput(rf.get(i).getOutputs().get(4));

        }



        addOutput(m5.getOutput(0)); //read data 1 bit 4



        MultiplexerDynamic m6 = new MultiplexerDynamic("mux6","37X1");

        m6.addInput(getInput(2));

        m6.addInput(getInput(3));

        m6.addInput(getInput(4));

        m6.addInput(getInput(5));

        m6.addInput(getInput(6));


        for (int i = 0; i < 32 ; i++) {

            m6.addInput(rf.get(i).getOutputs().get(5));

        }


        addOutput(m6.getOutput(0)); //read data 1 bit 5


        MultiplexerDynamic m7 = new MultiplexerDynamic("mux7","37X1");

        m7.addInput(getInput(2));

        m7.addInput(getInput(3));

        m7.addInput(getInput(4));

        m7.addInput(getInput(5));

        m7.addInput(getInput(6));

        for (int i = 0; i < 32 ; i++) {

            m7.addInput(rf.get(i).getOutputs().get(6)); // change

        }

        addOutput(m7.getOutput(0)); //read data 1 bit 6



        MultiplexerDynamic m8 = new MultiplexerDynamic("mux8","37X1");

        m8.addInput(getInput(2));

        m8.addInput(getInput(3));

        m8.addInput(getInput(4));

        m8.addInput(getInput(5));

        m8.addInput(getInput(6));

        for (int i = 0; i < 32 ; i++) {

            m8.addInput(rf.get(i).getOutputs().get(7));

        }

        addOutput(m8.getOutput(0)); //read data 1 bit 7

        MultiplexerDynamic m9 = new MultiplexerDynamic("mux9","37X1");


        m9.addInput(getInput(2));

        m9.addInput(getInput(3));

        m9.addInput(getInput(4));

        m9.addInput(getInput(5));

        m9.addInput(getInput(6));
        for (int i = 0; i < 32 ; i++) {

            m9.addInput(rf.get(i).getOutputs().get(8));

        }

        addOutput(m9.getOutput(0)); //read data 1 bit 8



        MultiplexerDynamic m10 = new MultiplexerDynamic("mux10","37X1");


        m10.addInput(getInput(2));

        m10.addInput(getInput(3));

        m10.addInput(getInput(4));

        m10.addInput(getInput(5));

        m10.addInput(getInput(6));

        for (int i = 0; i < 32 ; i++) {

            m10.addInput(rf.get(i).getOutputs().get(9));

        }

        addOutput(m10.getOutput(0)); //read data 1 bit 9



        MultiplexerDynamic m11 = new MultiplexerDynamic("mux11","37X1");

        m11.addInput(getInput(2));

        m11.addInput(getInput(3));

        m11.addInput(getInput(4));

        m11.addInput(getInput(5));

        m11.addInput(getInput(6));

        for (int i = 0; i < 32 ; i++) {

            m11.addInput(rf.get(i).getOutputs().get(10));

        }



        addOutput(m11.getOutput(0)); //read data 1 bit 10



        MultiplexerDynamic m12 = new MultiplexerDynamic("mux12","37X1");


        m12.addInput(getInput(2));

        m12.addInput(getInput(3));

        m12.addInput(getInput(4));

        m12.addInput(getInput(5));

        m12.addInput(getInput(6));



        for (int i = 0; i < 32 ; i++) {

            m12.addInput(rf.get(i).getOutputs().get(11));

        }
        addOutput(m12.getOutput(0)); //read data 1 bit 11



        MultiplexerDynamic m13 = new MultiplexerDynamic("mux13","37X1");



        m13.addInput(getInput(2));

        m13.addInput(getInput(3));

        m13.addInput(getInput(4));

        m13.addInput(getInput(5));

        m13.addInput(getInput(6));

        for (int i = 0; i < 32 ; i++) {

            m13.addInput(rf.get(i).getOutputs().get(12));

        }

        addOutput(m13.getOutput(0)); //read data 1 bit 12



        MultiplexerDynamic m14 = new MultiplexerDynamic("mux14","37X1");


        m14.addInput(getInput(2));

        m14.addInput(getInput(3));

        m14.addInput(getInput(4));

        m14.addInput(getInput(5));

        m14.addInput(getInput(6));


        for (int i = 0; i < 32 ; i++) {

            m14.addInput(rf.get(i).getOutputs().get(13));

        }

        addOutput(m14.getOutput(0)); //read data 1 bit 13



        MultiplexerDynamic m15 = new MultiplexerDynamic("mux15","37X1");



        m15.addInput(getInput(2));

        m15.addInput(getInput(3));

        m15.addInput(getInput(4));

        m15.addInput(getInput(5));

        m15.addInput(getInput(6));


        for (int i = 0; i < 32 ; i++) {

            m15.addInput(rf.get(i).getOutputs().get(14));

        }
        addOutput(m15.getOutput(0)); //read data 1 bit 14



        MultiplexerDynamic m16 = new MultiplexerDynamic("mux16","37X1");



        m16.addInput(getInput(2));

        m16.addInput(getInput(3));

        m16.addInput(getInput(4));

        m16.addInput(getInput(5));

        m16.addInput(getInput(6));

        for (int i = 0; i < 32 ; i++) {

            m16.addInput(rf.get(i).getOutputs().get(15));

        }

        addOutput(m16.getOutput(0)); //read data 1 bit 15



        MultiplexerDynamic m17 = new MultiplexerDynamic("mux17","37X1");

        m17.addInput(getInput(2));

        m17.addInput(getInput(3));

        m17.addInput(getInput(4));

        m17.addInput(getInput(5));

        m17.addInput(getInput(6));

        for (int i = 0; i < 32 ; i++) {

            m17.addInput(rf.get(i).getOutputs().get(16));

        }


        addOutput(m17.getOutput(0)); //read data 1 bit 16



        MultiplexerDynamic m18 = new MultiplexerDynamic("mux18","37X1");

        m18.addInput(getInput(2));

        m18.addInput(getInput(3));

        m18.addInput(getInput(4));

        m18.addInput(getInput(5));

        m18.addInput(getInput(6));

        for (int i = 0; i < 32 ; i++) {

            m18.addInput(rf.get(i).getOutputs().get(17));

        }



        addOutput(m18.getOutput(0)); //read data 1 bit 17



        MultiplexerDynamic m19 = new MultiplexerDynamic("mux19","37X1");

        m19.addInput(getInput(2));

        m19.addInput(getInput(3));

        m19.addInput(getInput(4));

        m19.addInput(getInput(5));

        m19.addInput(getInput(6));

        for (int i = 0; i < 32 ; i++) {

            m19.addInput(rf.get(i).getOutputs().get(18));

        }

        addOutput(m19.getOutput(0)); //read data 1 bit 18





        MultiplexerDynamic m20 = new MultiplexerDynamic("mux20","37X1");

        m20.addInput(getInput(2));

        m20.addInput(getInput(3));

        m20.addInput(getInput(4));

        m20.addInput(getInput(5));

        m20.addInput(getInput(6));

        for (int i = 0; i < 32 ; i++) {

            m20.addInput(rf.get(i).getOutputs().get(19));

        }


        addOutput(m20.getOutput(0)); //read data 1 bit 19



        MultiplexerDynamic m21 = new MultiplexerDynamic("mux21","37X1");



        m21.addInput(getInput(2));

        m21.addInput(getInput(3));

        m21.addInput(getInput(4));

        m21.addInput(getInput(5));

        m21.addInput(getInput(6));

        for (int i = 0; i < 32 ; i++) {

            m21.addInput(rf.get(i).getOutputs().get(20));

        }

        addOutput(m21.getOutput(0)); //read data 1 bit 20



        MultiplexerDynamic m22 = new MultiplexerDynamic("mux22","37X1");



        m22.addInput(getInput(2));

        m22.addInput(getInput(3));

        m22.addInput(getInput(4));

        m22.addInput(getInput(5));

        m22.addInput(getInput(6));

        for (int i = 0; i < 32 ; i++) {

            m22.addInput(rf.get(i).getOutputs().get(21));

        }

        addOutput(m22.getOutput(0)); //read data 1 bit 21



        MultiplexerDynamic m23 = new MultiplexerDynamic("mux23","37X1");



        m23.addInput(getInput(2));

        m23.addInput(getInput(3));

        m23.addInput(getInput(4));

        m23.addInput(getInput(5));

        m23.addInput(getInput(6));

        for (int i = 0; i < 32 ; i++) {

            m23.addInput(rf.get(i).getOutputs().get(22));

        }

        addOutput(m23.getOutput(0)); //read data 1 bit 22



        MultiplexerDynamic m24 = new MultiplexerDynamic("mux24","37X1");



        m24.addInput(getInput(2));

        m24.addInput(getInput(3));

        m24.addInput(getInput(4));

        m24.addInput(getInput(5));

        m24.addInput(getInput(6));

        for (int i = 0; i < 32 ; i++) {

            m24.addInput(rf.get(i).getOutputs().get(23));

        }

        addOutput(m24.getOutput(0)); //read data 1 bit 23

        MultiplexerDynamic m25 = new MultiplexerDynamic("mux25","37X1");

        m25.addInput(getInput(2));

        m25.addInput(getInput(3));

        m25.addInput(getInput(4));

        m25.addInput(getInput(5));

        m25.addInput(getInput(6));

        for (int i = 0; i < 32 ; i++) {

            m25.addInput(rf.get(i).getOutputs().get(24));

        }


        addOutput(m25.getOutput(0)); //read data 1 bit 24



        MultiplexerDynamic m26 = new MultiplexerDynamic("mux2","37X1");

        m26.addInput(getInput(2));

        m26.addInput(getInput(3));

        m26.addInput(getInput(4));

        m26.addInput(getInput(5));

        m26.addInput(getInput(6));

        for (int i = 0; i < 32 ; i++) {

            m26.addInput(rf.get(i).getOutputs().get(25));

        }

        addOutput(m26.getOutput(0)); //read data 1 bit 25



        MultiplexerDynamic m27 = new MultiplexerDynamic("mux27","37X1");

        m27.addInput(getInput(2));

        m27.addInput(getInput(3));

        m27.addInput(getInput(4));

        m27.addInput(getInput(5));

        m27.addInput(getInput(6));

        for (int i = 0; i < 32 ; i++) {

            m27.addInput(rf.get(i).getOutputs().get(26));

        }


        addOutput(m27.getOutput(0)); //read data 1 bit 26



        MultiplexerDynamic m28 = new MultiplexerDynamic("mux28","37X1");



        m28.addInput(getInput(2));

        m28.addInput(getInput(3));

        m28.addInput(getInput(4));

        m28.addInput(getInput(5));

        m28.addInput(getInput(6));
        for (int i = 0; i < 32 ; i++) {

            m28.addInput(rf.get(i).getOutputs().get(27));

        }


        addOutput(m28.getOutput(0)); //read data 1 bit 27



        MultiplexerDynamic m29 = new MultiplexerDynamic("mux29","37X1");



        m29.addInput(getInput(2));

        m29.addInput(getInput(3));

        m29.addInput(getInput(4));

        m29.addInput(getInput(5));

        m29.addInput(getInput(6));

        for (int i = 0; i < 32 ; i++) {

            m29.addInput(rf.get(i).getOutputs().get(28));

        }

        addOutput(m29.getOutput(0)); //read data 1 bit 28



        MultiplexerDynamic m30 = new MultiplexerDynamic("mux30","37X1");

        m30.addInput(getInput(2));

        m30.addInput(getInput(3));

        m30.addInput(getInput(4));

        m30.addInput(getInput(5));

        m30.addInput(getInput(6));

        for (int i = 0; i < 32 ; i++) {

            m30.addInput(rf.get(i).getOutputs().get(29));

        }


        addOutput(m30.getOutput(0)); //read data 1 bit 29



        MultiplexerDynamic m31 = new MultiplexerDynamic("mux31","37X1");

        m31.addInput(getInput(2));

        m31.addInput(getInput(3));

        m31.addInput(getInput(4));

        m31.addInput(getInput(5));

        m31.addInput(getInput(6));

        for (int i = 0; i < 32 ; i++) {

            m31.addInput(rf.get(i).getOutputs().get(30));

        }

        addOutput(m31.getOutput(0)); //read data 1 bit 30



        MultiplexerDynamic m32 = new MultiplexerDynamic("mux32","37X1");

        m32.addInput(getInput(2));

        m32.addInput(getInput(3));

        m32.addInput(getInput(4));

        m32.addInput(getInput(5));

        m32.addInput(getInput(6));

        for (int i = 0; i < 32 ; i++) {

            m32.addInput(rf.get(i).getOutputs().get(31));

        }

        addOutput(m32.getOutput(0)); //read data 1 bit 31



        //--------------------------------------------------------

        // Read data 2



        MultiplexerDynamic m33 = new MultiplexerDynamic("mux33","37X1"); // read data 2

        //Simulator.debugger.addTrackItem(rf.get(16),m33);

        m33.addInput(getInput(7));

        m33.addInput(getInput(8));

        m33.addInput(getInput(9));

        m33.addInput(getInput(10));

        m33.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m33.addInput(rf.get(i).getOutputs().get(0));

        }


        addOutput(m33.getOutput(0)); //read data 2 bit 0



        MultiplexerDynamic m34 = new MultiplexerDynamic("mux34","37X1");

        m34.addInput(getInput(7));

        m34.addInput(getInput(8));

        m34.addInput(getInput(9));

        m34.addInput(getInput(10));

        m34.addInput(getInput(11));


        for (int i = 0; i < 32 ; i++) {

            m34.addInput(rf.get(i).getOutputs().get(1));

        }

        addOutput(m34.getOutput(0)); //read data 2 bit 1



        MultiplexerDynamic m35 = new MultiplexerDynamic("mux35","37X1");


        m35.addInput(getInput(7));

        m35.addInput(getInput(8));

        m35.addInput(getInput(9));

        m35.addInput(getInput(10));

        m35.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m35.addInput(rf.get(i).getOutputs().get(2));

        }

        addOutput(m35.getOutput(0)); //read data 2 bit 2



        MultiplexerDynamic m36 = new MultiplexerDynamic("mux36","37X1");

        m36.addInput(getInput(7));

        m36.addInput(getInput(8));

        m36.addInput(getInput(9));

        m36.addInput(getInput(10));

        m36.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m36.addInput(rf.get(i).getOutputs().get(3));

        }

        addOutput(m36.getOutput(0)); //read data 2 bit 3

        MultiplexerDynamic m37 = new MultiplexerDynamic("mux37","37X1");

        m37.addInput(getInput(7));

        m37.addInput(getInput(8));

        m37.addInput(getInput(9));

        m37.addInput(getInput(10));

        m37.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m37.addInput(rf.get(i).getOutputs().get(4));

        }

        addOutput(m37.getOutput(0)); //read data 2 bit 4



        MultiplexerDynamic m38 = new MultiplexerDynamic("mux38","37X1");

        m38.addInput(getInput(7));

        m38.addInput(getInput(8));

        m38.addInput(getInput(9));

        m38.addInput(getInput(10));

        m38.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m38.addInput(rf.get(i).getOutputs().get(5));

        }

        addOutput(m38.getOutput(0)); //read data 2 bit 5



        MultiplexerDynamic m39 = new MultiplexerDynamic("mux39","37X1");

        m39.addInput(getInput(7));

        m39.addInput(getInput(8));

        m39.addInput(getInput(9));

        m39.addInput(getInput(10));

        m39.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m39.addInput(rf.get(i).getOutputs().get(6));

        }

        addOutput(m39.getOutput(0)); //read data 2 bit 6



        MultiplexerDynamic m40 = new MultiplexerDynamic("mux40","37X1");


        m40.addInput(getInput(7));

        m40.addInput(getInput(8));

        m40.addInput(getInput(9));

        m40.addInput(getInput(10));

        m40.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m40.addInput(rf.get(i).getOutputs().get(7));

        }

        addOutput(m40.getOutput(0)); //read data 2 bit 7



        MultiplexerDynamic m41 = new MultiplexerDynamic("mux41","37X1");

        m41.addInput(getInput(7));

        m41.addInput(getInput(8));

        m41.addInput(getInput(9));

        m41.addInput(getInput(10));

        m41.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m41.addInput(rf.get(i).getOutputs().get(8));

        }

        addOutput(m41.getOutput(0)); //read data 2 bit 8

        MultiplexerDynamic m42 = new MultiplexerDynamic("mux42","37X1");

        m42.addInput(getInput(7));

        m42.addInput(getInput(8));

        m42.addInput(getInput(9));

        m42.addInput(getInput(10));

        m42.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m42.addInput(rf.get(i).getOutputs().get(9));

        }

        addOutput(m42.getOutput(0)); //read data 2 bit 9



        MultiplexerDynamic m43 = new MultiplexerDynamic("mux43","37X1");

        m43.addInput(getInput(7));

        m43.addInput(getInput(8));

        m43.addInput(getInput(9));

        m43.addInput(getInput(10));

        m43.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m43.addInput(rf.get(i).getOutputs().get(10));

        }

        addOutput(m43.getOutput(0)); //read data 2 bit 10



        MultiplexerDynamic m44 = new MultiplexerDynamic("mux44","37X1");

        m44.addInput(getInput(7));

        m44.addInput(getInput(8));

        m44.addInput(getInput(9));

        m44.addInput(getInput(10));

        m44.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m44.addInput(rf.get(i).getOutputs().get(11));

        }

        addOutput(m44.getOutput(0)); //read data 2 bit 11



        MultiplexerDynamic m45 = new MultiplexerDynamic("mux45","37X1");

        m45.addInput(getInput(7));

        m45.addInput(getInput(8));

        m45.addInput(getInput(9));

        m45.addInput(getInput(10));

        m45.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m45.addInput(rf.get(i).getOutputs().get(12));

        }

        addOutput(m45.getOutput(0)); //read data 2 bit 12



        MultiplexerDynamic m46 = new MultiplexerDynamic("mux46","37X1");

        m46.addInput(getInput(7));

        m46.addInput(getInput(8));

        m46.addInput(getInput(9));

        m46.addInput(getInput(10));

        m46.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m46.addInput(rf.get(i).getOutputs().get(13));

        }

        addOutput(m46.getOutput(0)); //read data 2 bit 13

        MultiplexerDynamic m47 = new MultiplexerDynamic("mux47","37X1");

        m47.addInput(getInput(7));

        m47.addInput(getInput(8));

        m47.addInput(getInput(9));

        m47.addInput(getInput(10));

        m47.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m47.addInput(rf.get(i).getOutputs().get(14));

        }

        addOutput(m47.getOutput(0)); //read data 2 bit 14



        MultiplexerDynamic m48 = new MultiplexerDynamic("mux48","37X1");

        m48.addInput(getInput(7));

        m48.addInput(getInput(8));

        m48.addInput(getInput(9));

        m48.addInput(getInput(10));

        m48.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m48.addInput(rf.get(i).getOutputs().get(15));

        }


        addOutput(m48.getOutput(0)); //read data 2 bit 15



        MultiplexerDynamic m49 = new MultiplexerDynamic("mux49","37X1");

        m49.addInput(getInput(7));

        m49.addInput(getInput(8));

        m49.addInput(getInput(9));

        m49.addInput(getInput(10));

        m49.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m49.addInput(rf.get(i).getOutputs().get(16));

        }


        addOutput(m49.getOutput(0)); //read data 2 bit 16



        MultiplexerDynamic m50 = new MultiplexerDynamic("mux50","37X1");

        m50.addInput(getInput(7));

        m50.addInput(getInput(8));

        m50.addInput(getInput(9));

        m50.addInput(getInput(10));

        m50.addInput(getInput(11));


        for (int i = 0; i < 32 ; i++) {

            m50.addInput(rf.get(i).getOutputs().get(17));

        }

        addOutput(m50.getOutput(0)); //read data 2 bit 17



        MultiplexerDynamic m51 = new MultiplexerDynamic("mux51","37X1");

        m51.addInput(getInput(7));

        m51.addInput(getInput(8));

        m51.addInput(getInput(9));

        m51.addInput(getInput(10));

        m51.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m51.addInput(rf.get(i).getOutputs().get(18));

        }

        addOutput(m51.getOutput(0)); //read data 2 bit 18



        MultiplexerDynamic m52 = new MultiplexerDynamic("mux52","37X1");

        m52.addInput(getInput(7));

        m52.addInput(getInput(8));

        m52.addInput(getInput(9));

        m52.addInput(getInput(10));

        m52.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m52.addInput(rf.get(i).getOutputs().get(19));

        }

        addOutput(m52.getOutput(0)); //read data 2 bit 19



        MultiplexerDynamic m53 = new MultiplexerDynamic("mux53","37X1");

        m53.addInput(getInput(7));

        m53.addInput(getInput(8));

        m53.addInput(getInput(9));

        m53.addInput(getInput(10));

        m53.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m53.addInput(rf.get(i).getOutputs().get(20));

        }

        addOutput(m53.getOutput(0)); //read data 2 bit 20

        MultiplexerDynamic m54 = new MultiplexerDynamic("mux54","37X1");

        m54.addInput(getInput(7));

        m54.addInput(getInput(8));

        m54.addInput(getInput(9));

        m54.addInput(getInput(10));

        m54.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m54.addInput(rf.get(i).getOutputs().get(21));

        }

        addOutput(m54.getOutput(0)); //read data 2 bit 21





        MultiplexerDynamic m55 = new MultiplexerDynamic("mux55","37X1");

        m55.addInput(getInput(7));

        m55.addInput(getInput(8));

        m55.addInput(getInput(9));

        m55.addInput(getInput(10));

        m55.addInput(getInput(11));


        for (int i = 0; i < 32 ; i++) {

            m55.addInput(rf.get(i).getOutputs().get(22));

        }


        addOutput(m55.getOutput(0)); //read data 2 bit 22



        MultiplexerDynamic m56 = new MultiplexerDynamic("mux56","37X1");

        m56.addInput(getInput(7));

        m56.addInput(getInput(8));

        m56.addInput(getInput(9));

        m56.addInput(getInput(10));

        m56.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m56.addInput(rf.get(i).getOutputs().get(23));

        }

        addOutput(m56.getOutput(0)); //read data 2 bit 23

        MultiplexerDynamic m57 = new MultiplexerDynamic("mux57","37X1");

        m57.addInput(getInput(7));

        m57.addInput(getInput(8));

        m57.addInput(getInput(9));

        m57.addInput(getInput(10));

        m57.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m57.addInput(rf.get(i).getOutputs().get(24));

        }


        addOutput(m57.getOutput(0)); //read data 2 bit 24



        MultiplexerDynamic m58 = new MultiplexerDynamic("mux58","37X1");

        m58.addInput(getInput(7));

        m58.addInput(getInput(8));

        m58.addInput(getInput(9));

        m58.addInput(getInput(10));

        m58.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m58.addInput(rf.get(i).getOutputs().get(25));

        }

        addOutput(m58.getOutput(0)); //read data 2 bit 25



        MultiplexerDynamic m59 = new MultiplexerDynamic("mux59","37X1");

        m59.addInput(getInput(7));

        m59.addInput(getInput(8));

        m59.addInput(getInput(9));

        m59.addInput(getInput(10));

        m59.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m59.addInput(rf.get(i).getOutputs().get(26));

        }

        addOutput(m59.getOutput(0)); //read data 2 bit 26



        MultiplexerDynamic m60 = new MultiplexerDynamic("mux60","37X1");

        m60.addInput(getInput(7));

        m60.addInput(getInput(8));

        m60.addInput(getInput(9));

        m60.addInput(getInput(10));

        m60.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m60.addInput(rf.get(i).getOutputs().get(27));

        }

        addOutput(m60.getOutput(0)); //read data 2 bit 27



        MultiplexerDynamic m61 = new MultiplexerDynamic("mux61","37X1");

        m61.addInput(getInput(7));

        m61.addInput(getInput(8));

        m61.addInput(getInput(9));

        m61.addInput(getInput(10));

        m61.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m61.addInput(rf.get(i).getOutputs().get(28));

        }

        addOutput(m61.getOutput(0)); //read data 2 bit 28



        MultiplexerDynamic m62 = new MultiplexerDynamic("mux62","37X1");

        m62.addInput(getInput(7));

        m62.addInput(getInput(8));

        m62.addInput(getInput(9));

        m62.addInput(getInput(10));

        m62.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m62.addInput(rf.get(i).getOutputs().get(29));

        }

        addOutput(m62.getOutput(0)); //read data 2 bit 29



        MultiplexerDynamic m63 = new MultiplexerDynamic("mux63","37X1");



        m63.addInput(getInput(7));

        m63.addInput(getInput(8));

        m63.addInput(getInput(9));

        m63.addInput(getInput(10));

        m63.addInput(getInput(11));

        for (int i = 0; i < 32 ; i++) {

            m63.addInput(rf.get(i).getOutputs().get(30));

        }

        addOutput(m63.getOutput(0)); //read data 2 bit 30



        MultiplexerDynamic m64 = new MultiplexerDynamic("mux64","37X1");


        m64.addInput(getInput(7));

        m64.addInput(getInput(8));

        m64.addInput(getInput(9));

        m64.addInput(getInput(10));

        m64.addInput(getInput(11));


        for (int i = 0; i < 32 ; i++) {

            m64.addInput(rf.get(i).getOutputs().get(31));

        }

        addOutput(m64.getOutput(0)); //read data 2 bit 31

    }

}