package simulator;

import simulator.Dec5X32;
import simulator.control.Simulator;

import simulator.gates.combinational.And;

import simulator.gates.sequential.Clock;

import simulator.gates.sequential.flipflops.DFlipFlop;

import simulator.network.Link;

import simulator.wrapper.Wrapper;



import java.util.ArrayList;

import java.util.HashMap;



public class RegisterFile extends Wrapper {

    private HashMap<Integer,Register> rf = new HashMap<>();

    //clock cycle 0 , regWrite signal 1 , register read 1(2:6) , 2(7:11) ; register write(12:16) , write data ( 17:48 )

    public RegisterFile(String label, String stream, Link... links){

        super(label,stream,links);



        // paste these after instantiation



        /*for (int i = 0 ; i < 32 ; i++){

            rf = new HashMap<>();

            Register r = new Register();



            for (int j = 0; j < 32; j++) {



                DFlipFlop d = new DFlipFlop("d"+ j, getInput(0), Simulator.falseLogic);

                //System.out.println(d);

                r.getFlipFlops().add(d);

            }

            rf.put(i,r);

            //System.out.println(rf);

        }*/



    }



    @Override

    public void initialize() {

        // write

        Dec5X32 dec = new Dec5X32("registerFileReadDec","5X32",getInput(16), getInput(15), getInput(14), getInput(13), getInput(12));



        And a1 = new And("and1",getInput(1),dec.getOutput(0));

        And a2 = new And("and2",getInput(1),dec.getOutput(1));

        And a3 = new And("and3",getInput(1),dec.getOutput(2));

        And a4 = new And("and4",getInput(1),dec.getOutput(3));

        And a5 = new And("and5",getInput(1),dec.getOutput(4));

        And a6 = new And("and6",getInput(1),dec.getOutput(5));

        And a7 = new And("and7",getInput(1),dec.getOutput(6));

        And a8 = new And("and8",getInput(1),dec.getOutput(7));

        And a9 = new And("and9",getInput(1),dec.getOutput(8));

        And a10 = new And("and10",getInput(1),dec.getOutput(9));

        And a11 = new And("and11",getInput(1),dec.getOutput(10));

        And a12 = new And("and12",getInput(1),dec.getOutput(11));

        And a13 = new And("and13",getInput(1),dec.getOutput(12));

        And a14 = new And("and14",getInput(1),dec.getOutput(13));

        And a15 = new And("and15",getInput(1),dec.getOutput(14));

        And a16 = new And("and16",getInput(1),dec.getOutput(15));

        And a17 = new And("and17",getInput(1),dec.getOutput(16));

        And a18 = new And("and18",getInput(1),dec.getOutput(17));

        And a19 = new And("and19",getInput(1),dec.getOutput(18));

        And a20 = new And("and20",getInput(1),dec.getOutput(19));

        And a21 = new And("and21",getInput(1),dec.getOutput(20));

        And a22 = new And("and22",getInput(1),dec.getOutput(21));

        And a23 = new And("and23",getInput(1),dec.getOutput(22));

        And a24 = new And("and24",getInput(1),dec.getOutput(23));

        And a25 = new And("and25",getInput(1),dec.getOutput(24));

        And a26 = new And("and26",getInput(1),dec.getOutput(25));

        And a27 = new And("and27",getInput(1),dec.getOutput(26));

        And a28 = new And("and28",getInput(1),dec.getOutput(27));

        And a29 = new And("and29",getInput(1),dec.getOutput(28));

        And a30 = new And("and30",getInput(1),dec.getOutput(29));

        And a31 = new And("and31",getInput(1),dec.getOutput(30));

        And a32 = new And("and32",getInput(1),dec.getOutput(31));



        //set write signal of register



        if (rf == null){

            return;

        }

        rf.get(0).setWrite(a1.getOutput(0));

        rf.get(1).setWrite(a2.getOutput(0));

        rf.get(2).setWrite(a3.getOutput(0));

        rf.get(3).setWrite(a4.getOutput(0));

        rf.get(4).setWrite(a5.getOutput(0));

        rf.get(5).setWrite(a6.getOutput(0));

        rf.get(6).setWrite(a7.getOutput(0));

        rf.get(7).setWrite(a8.getOutput(0));

        rf.get(8).setWrite(a9.getOutput(0));

        rf.get(9).setWrite(a10.getOutput(0));

        rf.get(10).setWrite(a11.getOutput(0));

        rf.get(11).setWrite(a12.getOutput(0));

        rf.get(12).setWrite(a13.getOutput(0));

        rf.get(13).setWrite(a14.getOutput(0));

        rf.get(14).setWrite(a15.getOutput(0));

        rf.get(15).setWrite(a16.getOutput(0));

        rf.get(16).setWrite(a17.getOutput(0));

        rf.get(17).setWrite(a18.getOutput(0));

        rf.get(18).setWrite(a19.getOutput(0));

        rf.get(19).setWrite(a20.getOutput(0));

        rf.get(20).setWrite(a21.getOutput(0));

        rf.get(21).setWrite(a22.getOutput(0));

        rf.get(22).setWrite(a23.getOutput(0));

        rf.get(23).setWrite(a24.getOutput(0));

        rf.get(24).setWrite(a25.getOutput(0));

        rf.get(25).setWrite(a26.getOutput(0));

        rf.get(26).setWrite(a27.getOutput(0));

        rf.get(27).setWrite(a28.getOutput(0));

        rf.get(28).setWrite(a29.getOutput(0));

        rf.get(29).setWrite(a30.getOutput(0));

        rf.get(30).setWrite(a31.getOutput(0));

        rf.get(31).setWrite(a32.getOutput(0));

        ArrayList<Link> writeData = new ArrayList<>();

        int j = 17;

        for (int i = 0; i < 32; i++) {



            writeData.add(getInput(j));

            j++;



        }



        for (int i = 0; i < 32; i++) {

            rf.get(i).write(writeData);

        }



        // read data 1



        //32 mux (32X1) with register addresses control lines

        Mux32X1 m1 = new Mux32X1("mux1","32X1");

        for (int i = 0; i < 32 ; i++) {

            m1.addInput(rf.get(i).dataToLogic().get(0));

        }



        m1.addInput(getInput(2));

        m1.addInput(getInput(3));

        m1.addInput(getInput(4));

        m1.addInput(getInput(5));

        m1.addInput(getInput(6));





        addOutput(m1.getOutput(0)); //read data 1 bit 0



        Mux32X1 m2 = new Mux32X1("mux2","32X1");

        for (int i = 0; i < 32 ; i++) {

            m2.addInput(rf.get(i).dataToLogic().get(1));

        }

        m2.addInput(getInput(2));

        m2.addInput(getInput(3));

        m2.addInput(getInput(4));

        m2.addInput(getInput(5));

        m2.addInput(getInput(6));



        addOutput(m2.getOutput(0)); //read data 1 bit 1



        Mux32X1 m3 = new Mux32X1("mux3","32X1");

        for (int i = 0; i < 32 ; i++) {

            m3.addInput(rf.get(i).dataToLogic().get(2));

        }

        m3.addInput(getInput(2));

        m3.addInput(getInput(3));

        m3.addInput(getInput(4));

        m3.addInput(getInput(5));

        m3.addInput(getInput(6));



        addOutput(m3.getOutput(0)); //read data 1 bit 2



        Mux32X1 m4 = new Mux32X1("mux4","32X1");

        for (int i = 0; i < 32 ; i++) {

            m4.addInput(rf.get(i).dataToLogic().get(3));

        }

        m4.addInput(getInput(2));

        m4.addInput(getInput(3));

        m4.addInput(getInput(4));

        m4.addInput(getInput(5));

        m4.addInput(getInput(6));



        addOutput(m4.getOutput(0)); //read data 1 bit 3



        Mux32X1 m5 = new Mux32X1("mux5","32X1");

        for (int i = 0; i < 32 ; i++) {

            m5.addInput(rf.get(i).dataToLogic().get(4));

        }

        m5.addInput(getInput(2));

        m5.addInput(getInput(3));

        m5.addInput(getInput(4));

        m5.addInput(getInput(5));

        m5.addInput(getInput(6));



        addOutput(m5.getOutput(0)); //read data 1 bit 4



        Mux32X1 m6 = new Mux32X1("mux6","32X1");

        for (int i = 0; i < 32 ; i++) {

            m6.addInput(rf.get(i).dataToLogic().get(5));

        }

        m6.addInput(getInput(2));

        m6.addInput(getInput(3));

        m6.addInput(getInput(4));

        m6.addInput(getInput(5));

        m6.addInput(getInput(6));



        addOutput(m6.getOutput(0)); //read data 1 bit 5



        Mux32X1 m7 = new Mux32X1("mux7","32X1");

        for (int i = 0; i < 32 ; i++) {

            m7.addInput(rf.get(i).dataToLogic().get(6)); // change

        }

        m7.addInput(getInput(2));

        m7.addInput(getInput(3));

        m7.addInput(getInput(4));

        m7.addInput(getInput(5));

        m7.addInput(getInput(6));



        addOutput(m7.getOutput(0)); //read data 1 bit 6



        Mux32X1 m8 = new Mux32X1("mux8","32X1");

        for (int i = 0; i < 32 ; i++) {

            m2.addInput(rf.get(i).dataToLogic().get(7));

        }

        m8.addInput(getInput(2));

        m8.addInput(getInput(3));

        m8.addInput(getInput(4));

        m8.addInput(getInput(5));

        m8.addInput(getInput(6));



        addOutput(m8.getOutput(0)); //read data 1 bit 7



        Mux32X1 m9 = new Mux32X1("mux9","32X1");

        for (int i = 0; i < 32 ; i++) {

            m9.addInput(rf.get(i).dataToLogic().get(8));

        }

        m9.addInput(getInput(2));

        m9.addInput(getInput(3));

        m9.addInput(getInput(4));

        m9.addInput(getInput(5));

        m9.addInput(getInput(6));



        addOutput(m9.getOutput(0)); //read data 1 bit 8



        Mux32X1 m10 = new Mux32X1("mux10","32X1");

        for (int i = 0; i < 32 ; i++) {

            m10.addInput(rf.get(i).dataToLogic().get(9));

        }

        m10.addInput(getInput(2));

        m10.addInput(getInput(3));

        m10.addInput(getInput(4));

        m10.addInput(getInput(5));

        m10.addInput(getInput(6));



        addOutput(m10.getOutput(0)); //read data 1 bit 9



        Mux32X1 m11 = new Mux32X1("mux11","32X1");

        for (int i = 0; i < 32 ; i++) {

            m11.addInput(rf.get(i).dataToLogic().get(10));

        }

        m11.addInput(getInput(2));

        m11.addInput(getInput(3));

        m11.addInput(getInput(4));

        m11.addInput(getInput(5));

        m11.addInput(getInput(6));



        addOutput(m11.getOutput(0)); //read data 1 bit 10



        Mux32X1 m12 = new Mux32X1("mux12","32X1");

        for (int i = 0; i < 32 ; i++) {

            m12.addInput(rf.get(i).dataToLogic().get(11));

        }

        m12.addInput(getInput(2));

        m12.addInput(getInput(3));

        m12.addInput(getInput(4));

        m12.addInput(getInput(5));

        m12.addInput(getInput(6));



        addOutput(m12.getOutput(0)); //read data 1 bit 11



        Mux32X1 m13 = new Mux32X1("mux13","32X1");

        for (int i = 0; i < 32 ; i++) {

            m13.addInput(rf.get(i).dataToLogic().get(12));

        }

        m13.addInput(getInput(2));

        m13.addInput(getInput(3));

        m13.addInput(getInput(4));

        m13.addInput(getInput(5));

        m13.addInput(getInput(6));



        addOutput(m13.getOutput(0)); //read data 1 bit 12



        Mux32X1 m14 = new Mux32X1("mux14","32X1");

        for (int i = 0; i < 32 ; i++) {

            m14.addInput(rf.get(i).dataToLogic().get(13));

        }

        m14.addInput(getInput(2));

        m14.addInput(getInput(3));

        m14.addInput(getInput(4));

        m14.addInput(getInput(5));

        m14.addInput(getInput(6));



        addOutput(m14.getOutput(0)); //read data 1 bit 13



        Mux32X1 m15 = new Mux32X1("mux15","32X1");

        for (int i = 0; i < 32 ; i++) {

            m15.addInput(rf.get(i).dataToLogic().get(14));

        }

        m15.addInput(getInput(2));

        m15.addInput(getInput(3));

        m15.addInput(getInput(4));

        m15.addInput(getInput(5));

        m15.addInput(getInput(6));



        addOutput(m15.getOutput(0)); //read data 1 bit 14



        Mux32X1 m16 = new Mux32X1("mux16","32X1");

        for (int i = 0; i < 32 ; i++) {

            m16.addInput(rf.get(i).dataToLogic().get(15));

        }

        m16.addInput(getInput(2));

        m16.addInput(getInput(3));

        m16.addInput(getInput(4));

        m16.addInput(getInput(5));

        m16.addInput(getInput(6));



        addOutput(m16.getOutput(0)); //read data 1 bit 15



        Mux32X1 m17 = new Mux32X1("mux17","32X1");

        for (int i = 0; i < 32 ; i++) {

            m17.addInput(rf.get(i).dataToLogic().get(16));

        }

        m17.addInput(getInput(2));

        m17.addInput(getInput(3));

        m17.addInput(getInput(4));

        m17.addInput(getInput(5));

        m17.addInput(getInput(6));



        addOutput(m17.getOutput(0)); //read data 1 bit 16



        Mux32X1 m18 = new Mux32X1("mux18","32X1");

        for (int i = 0; i < 32 ; i++) {

            m18.addInput(rf.get(i).dataToLogic().get(17));

        }

        m18.addInput(getInput(2));

        m18.addInput(getInput(3));

        m18.addInput(getInput(4));

        m18.addInput(getInput(5));

        m18.addInput(getInput(6));



        addOutput(m18.getOutput(0)); //read data 1 bit 17



        Mux32X1 m19 = new Mux32X1("mux19","32X1");

        for (int i = 0; i < 32 ; i++) {

            m19.addInput(rf.get(i).dataToLogic().get(18));

        }

        m19.addInput(getInput(2));

        m19.addInput(getInput(3));

        m19.addInput(getInput(4));

        m19.addInput(getInput(5));

        m19.addInput(getInput(6));



        addOutput(m19.getOutput(0)); //read data 1 bit 18





        Mux32X1 m20 = new Mux32X1("mux20","32X1");

        for (int i = 0; i < 32 ; i++) {

            m20.addInput(rf.get(i).dataToLogic().get(19));

        }

        m20.addInput(getInput(2));

        m20.addInput(getInput(3));

        m20.addInput(getInput(4));

        m20.addInput(getInput(5));

        m20.addInput(getInput(6));



        addOutput(m20.getOutput(0)); //read data 1 bit 19



        Mux32X1 m21 = new Mux32X1("mux21","32X1");

        for (int i = 0; i < 32 ; i++) {

            m21.addInput(rf.get(i).dataToLogic().get(20));

        }

        m21.addInput(getInput(2));

        m21.addInput(getInput(3));

        m21.addInput(getInput(4));

        m21.addInput(getInput(5));

        m21.addInput(getInput(6));



        addOutput(m21.getOutput(0)); //read data 1 bit 20



        Mux32X1 m22 = new Mux32X1("mux22","32X1");

        for (int i = 0; i < 32 ; i++) {

            m22.addInput(rf.get(i).dataToLogic().get(21));

        }

        m22.addInput(getInput(2));

        m22.addInput(getInput(3));

        m22.addInput(getInput(4));

        m22.addInput(getInput(5));

        m22.addInput(getInput(6));



        addOutput(m22.getOutput(0)); //read data 1 bit 21



        Mux32X1 m23 = new Mux32X1("mux23","32X1");

        for (int i = 0; i < 32 ; i++) {

            m23.addInput(rf.get(i).dataToLogic().get(22));

        }

        m23.addInput(getInput(2));

        m23.addInput(getInput(3));

        m23.addInput(getInput(4));

        m23.addInput(getInput(5));

        m23.addInput(getInput(6));



        addOutput(m23.getOutput(0)); //read data 1 bit 22



        Mux32X1 m24 = new Mux32X1("mux24","32X1");

        for (int i = 0; i < 32 ; i++) {

            m24.addInput(rf.get(i).dataToLogic().get(23));

        }

        m24.addInput(getInput(2));

        m24.addInput(getInput(3));

        m24.addInput(getInput(4));

        m24.addInput(getInput(5));

        m24.addInput(getInput(6));



        addOutput(m24.getOutput(0)); //read data 1 bit 23



        Mux32X1 m25 = new Mux32X1("mux25","32X1");

        for (int i = 0; i < 32 ; i++) {

            m25.addInput(rf.get(i).dataToLogic().get(24));

        }

        m25.addInput(getInput(2));

        m25.addInput(getInput(3));

        m25.addInput(getInput(4));

        m25.addInput(getInput(5));

        m25.addInput(getInput(6));



        addOutput(m25.getOutput(0)); //read data 1 bit 24



        Mux32X1 m26 = new Mux32X1("mux2","32X1");

        for (int i = 0; i < 32 ; i++) {

            m26.addInput(rf.get(i).dataToLogic().get(25));

        }

        m26.addInput(getInput(2));

        m26.addInput(getInput(3));

        m26.addInput(getInput(4));

        m26.addInput(getInput(5));

        m26.addInput(getInput(6));



        addOutput(m26.getOutput(0)); //read data 1 bit 25



        Mux32X1 m27 = new Mux32X1("mux27","32X1");

        for (int i = 0; i < 32 ; i++) {

            m27.addInput(rf.get(i).dataToLogic().get(26));

        }

        m27.addInput(getInput(2));

        m27.addInput(getInput(3));

        m27.addInput(getInput(4));

        m27.addInput(getInput(5));

        m27.addInput(getInput(6));



        addOutput(m27.getOutput(0)); //read data 1 bit 26



        Mux32X1 m28 = new Mux32X1("mux28","32X1");

        for (int i = 0; i < 32 ; i++) {

            m28.addInput(rf.get(i).dataToLogic().get(27));

        }

        m28.addInput(getInput(2));

        m28.addInput(getInput(3));

        m28.addInput(getInput(4));

        m28.addInput(getInput(5));

        m28.addInput(getInput(6));



        addOutput(m28.getOutput(0)); //read data 1 bit 27



        Mux32X1 m29 = new Mux32X1("mux29","32X1");

        for (int i = 0; i < 32 ; i++) {

            m29.addInput(rf.get(i).dataToLogic().get(28));

        }

        m29.addInput(getInput(2));

        m29.addInput(getInput(3));

        m29.addInput(getInput(4));

        m29.addInput(getInput(5));

        m29.addInput(getInput(6));



        addOutput(m29.getOutput(0)); //read data 1 bit 28



        Mux32X1 m30 = new Mux32X1("mux30","32X1");

        for (int i = 0; i < 32 ; i++) {

            m30.addInput(rf.get(i).dataToLogic().get(29));

        }

        m30.addInput(getInput(2));

        m30.addInput(getInput(3));

        m30.addInput(getInput(4));

        m30.addInput(getInput(5));

        m30.addInput(getInput(6));



        addOutput(m30.getOutput(0)); //read data 1 bit 29



        Mux32X1 m31 = new Mux32X1("mux31","32X1");

        for (int i = 0; i < 32 ; i++) {

            m31.addInput(rf.get(i).dataToLogic().get(30));

        }

        m31.addInput(getInput(2));

        m31.addInput(getInput(3));

        m31.addInput(getInput(4));

        m31.addInput(getInput(5));

        m31.addInput(getInput(6));



        addOutput(m31.getOutput(0)); //read data 1 bit 30



        Mux32X1 m32 = new Mux32X1("mux32","32X1");

        for (int i = 0; i < 32 ; i++) {

            m32.addInput(rf.get(i).dataToLogic().get(31));

        }

        m32.addInput(getInput(2));

        m32.addInput(getInput(3));

        m32.addInput(getInput(4));

        m32.addInput(getInput(5));

        m32.addInput(getInput(6));



        addOutput(m32.getOutput(0)); //read data 1 bit 31



        //--------------------------------------------------------

        // Read data 2



        Mux32X1 m33 = new Mux32X1("mux33","32X1"); // read data 2

        for (int i = 0; i < 32 ; i++) {

            m33.addInput(rf.get(i).dataToLogic().get(0));

        }

        m33.addInput(getInput(7));

        m33.addInput(getInput(8));

        m33.addInput(getInput(9));

        m33.addInput(getInput(10));

        m33.addInput(getInput(11));



        addOutput(m33.getOutput(0)); //read data 2 bit 0



        Mux32X1 m34 = new Mux32X1("mux34","32X1");

        for (int i = 0; i < 32 ; i++) {

            m34.addInput(rf.get(i).dataToLogic().get(1));

        }

        m34.addInput(getInput(7));

        m34.addInput(getInput(8));

        m34.addInput(getInput(9));

        m34.addInput(getInput(10));

        m34.addInput(getInput(11));



        addOutput(m34.getOutput(0)); //read data 2 bit 1



        Mux32X1 m35 = new Mux32X1("mux35","32X1");

        for (int i = 0; i < 32 ; i++) {

            m35.addInput(rf.get(i).dataToLogic().get(2));

        }

        m35.addInput(getInput(7));

        m35.addInput(getInput(8));

        m35.addInput(getInput(9));

        m35.addInput(getInput(10));

        m35.addInput(getInput(11));



        addOutput(m35.getOutput(0)); //read data 2 bit 2



        Mux32X1 m36 = new Mux32X1("mux36","32X1");

        for (int i = 0; i < 32 ; i++) {

            m36.addInput(rf.get(i).dataToLogic().get(3));

        }

        m36.addInput(getInput(7));

        m36.addInput(getInput(8));

        m36.addInput(getInput(9));

        m36.addInput(getInput(10));

        m36.addInput(getInput(11));



        addOutput(m36.getOutput(0)); //read data 2 bit 3





        Mux32X1 m37 = new Mux32X1("mux37","32X1");

        for (int i = 0; i < 32 ; i++) {

            m37.addInput(rf.get(i).dataToLogic().get(4));

        }

        m37.addInput(getInput(7));

        m37.addInput(getInput(8));

        m37.addInput(getInput(9));

        m37.addInput(getInput(10));

        m37.addInput(getInput(11));



        addOutput(m37.getOutput(0)); //read data 2 bit 4



        Mux32X1 m38 = new Mux32X1("mux38","32X1");

        for (int i = 0; i < 32 ; i++) {

            m38.addInput(rf.get(i).dataToLogic().get(5));

        }

        m38.addInput(getInput(7));

        m38.addInput(getInput(8));

        m38.addInput(getInput(9));

        m38.addInput(getInput(10));

        m38.addInput(getInput(11));



        addOutput(m38.getOutput(0)); //read data 2 bit 5



        Mux32X1 m39 = new Mux32X1("mux39","32X1");

        for (int i = 0; i < 32 ; i++) {

            m39.addInput(rf.get(i).dataToLogic().get(6));

        }

        m39.addInput(getInput(7));

        m39.addInput(getInput(8));

        m39.addInput(getInput(9));

        m39.addInput(getInput(10));

        m39.addInput(getInput(11));



        addOutput(m39.getOutput(0)); //read data 2 bit 6



        Mux32X1 m40 = new Mux32X1("mux40","32X1");

        for (int i = 0; i < 32 ; i++) {

            m40.addInput(rf.get(i).dataToLogic().get(7));

        }

        m40.addInput(getInput(7));

        m40.addInput(getInput(8));

        m40.addInput(getInput(9));

        m40.addInput(getInput(10));

        m40.addInput(getInput(11));



        addOutput(m40.getOutput(0)); //read data 2 bit 7



        Mux32X1 m41 = new Mux32X1("mux41","32X1");

        for (int i = 0; i < 32 ; i++) {

            m41.addInput(rf.get(i).dataToLogic().get(8));

        }

        m41.addInput(getInput(7));

        m41.addInput(getInput(8));

        m41.addInput(getInput(9));

        m41.addInput(getInput(10));

        m41.addInput(getInput(11));



        addOutput(m41.getOutput(0)); //read data 2 bit 8





        Mux32X1 m42 = new Mux32X1("mux42","32X1");

        for (int i = 0; i < 32 ; i++) {

            m42.addInput(rf.get(i).dataToLogic().get(9));

        }

        m42.addInput(getInput(7));

        m42.addInput(getInput(8));

        m42.addInput(getInput(9));

        m42.addInput(getInput(10));

        m42.addInput(getInput(11));



        addOutput(m42.getOutput(0)); //read data 2 bit 9



        Mux32X1 m43 = new Mux32X1("mux43","32X1");

        for (int i = 0; i < 32 ; i++) {

            m43.addInput(rf.get(i).dataToLogic().get(10));

        }

        m43.addInput(getInput(7));

        m43.addInput(getInput(8));

        m43.addInput(getInput(9));

        m43.addInput(getInput(10));

        m43.addInput(getInput(11));



        addOutput(m43.getOutput(0)); //read data 2 bit 10



        Mux32X1 m44 = new Mux32X1("mux44","32X1");

        for (int i = 0; i < 32 ; i++) {

            m44.addInput(rf.get(i).dataToLogic().get(11));

        }

        m44.addInput(getInput(7));

        m44.addInput(getInput(8));

        m44.addInput(getInput(9));

        m44.addInput(getInput(10));

        m44.addInput(getInput(11));



        addOutput(m44.getOutput(0)); //read data 2 bit 11



        Mux32X1 m45 = new Mux32X1("mux45","32X1");

        for (int i = 0; i < 32 ; i++) {

            m45.addInput(rf.get(i).dataToLogic().get(12));

        }

        m45.addInput(getInput(7));

        m45.addInput(getInput(8));

        m45.addInput(getInput(9));

        m45.addInput(getInput(10));

        m45.addInput(getInput(11));



        addOutput(m45.getOutput(0)); //read data 2 bit 12



        Mux32X1 m46 = new Mux32X1("mux46","32X1");

        for (int i = 0; i < 32 ; i++) {

            m46.addInput(rf.get(i).dataToLogic().get(13));

        }

        m46.addInput(getInput(7));

        m46.addInput(getInput(8));

        m46.addInput(getInput(9));

        m46.addInput(getInput(10));

        m46.addInput(getInput(11));



        addOutput(m46.getOutput(0)); //read data 2 bit 13



        Mux32X1 m47 = new Mux32X1("mux47","32X1");

        for (int i = 0; i < 32 ; i++) {

            m47.addInput(rf.get(i).dataToLogic().get(14));

        }

        m47.addInput(getInput(7));

        m47.addInput(getInput(8));

        m47.addInput(getInput(9));

        m47.addInput(getInput(10));

        m47.addInput(getInput(11));



        addOutput(m47.getOutput(0)); //read data 2 bit 14



        Mux32X1 m48 = new Mux32X1("mux48","32X1");

        for (int i = 0; i < 32 ; i++) {

            m48.addInput(rf.get(i).dataToLogic().get(15));

        }

        m48.addInput(getInput(7));

        m48.addInput(getInput(8));

        m48.addInput(getInput(9));

        m48.addInput(getInput(10));

        m48.addInput(getInput(11));



        addOutput(m48.getOutput(0)); //read data 2 bit 15



        Mux32X1 m49 = new Mux32X1("mux49","32X1");

        for (int i = 0; i < 32 ; i++) {

            m49.addInput(rf.get(i).dataToLogic().get(16));

        }

        m49.addInput(getInput(7));

        m49.addInput(getInput(8));

        m49.addInput(getInput(9));

        m49.addInput(getInput(10));

        m49.addInput(getInput(11));



        addOutput(m49.getOutput(0)); //read data 2 bit 16



        Mux32X1 m50 = new Mux32X1("mux50","32X1");

        for (int i = 0; i < 32 ; i++) {

            m50.addInput(rf.get(i).dataToLogic().get(17));

        }

        m50.addInput(getInput(7));

        m50.addInput(getInput(8));

        m50.addInput(getInput(9));

        m50.addInput(getInput(10));

        m50.addInput(getInput(11));



        addOutput(m50.getOutput(0)); //read data 2 bit 17



        Mux32X1 m51 = new Mux32X1("mux51","32X1");

        for (int i = 0; i < 32 ; i++) {

            m51.addInput(rf.get(i).dataToLogic().get(18));

        }

        m51.addInput(getInput(7));

        m51.addInput(getInput(8));

        m51.addInput(getInput(9));

        m51.addInput(getInput(10));

        m51.addInput(getInput(11));



        addOutput(m51.getOutput(0)); //read data 2 bit 18



        Mux32X1 m52 = new Mux32X1("mux52","32X1");

        for (int i = 0; i < 32 ; i++) {

            m52.addInput(rf.get(i).dataToLogic().get(19));

        }

        m52.addInput(getInput(7));

        m52.addInput(getInput(8));

        m52.addInput(getInput(9));

        m52.addInput(getInput(10));

        m52.addInput(getInput(11));



        addOutput(m52.getOutput(0)); //read data 2 bit 19



        Mux32X1 m53 = new Mux32X1("mux53","32X1");

        for (int i = 0; i < 32 ; i++) {

            m53.addInput(rf.get(i).dataToLogic().get(20));

        }

        m53.addInput(getInput(7));

        m53.addInput(getInput(8));

        m53.addInput(getInput(9));

        m53.addInput(getInput(10));

        m53.addInput(getInput(11));



        addOutput(m53.getOutput(0)); //read data 2 bit 20



        Mux32X1 m54 = new Mux32X1("mux54","32X1");

        for (int i = 0; i < 32 ; i++) {

            m54.addInput(rf.get(i).dataToLogic().get(21));

        }

        m54.addInput(getInput(7));

        m54.addInput(getInput(8));

        m54.addInput(getInput(9));

        m54.addInput(getInput(10));

        m54.addInput(getInput(11));



        addOutput(m54.getOutput(0)); //read data 2 bit 21





        Mux32X1 m55 = new Mux32X1("mux55","32X1");

        for (int i = 0; i < 32 ; i++) {

            m55.addInput(rf.get(i).dataToLogic().get(22));

        }

        m55.addInput(getInput(7));

        m55.addInput(getInput(8));

        m55.addInput(getInput(9));

        m55.addInput(getInput(10));

        m55.addInput(getInput(11));



        addOutput(m55.getOutput(0)); //read data 2 bit 22



        Mux32X1 m56 = new Mux32X1("mux56","32X1");

        for (int i = 0; i < 32 ; i++) {

            m56.addInput(rf.get(i).dataToLogic().get(23));

        }

        m56.addInput(getInput(7));

        m56.addInput(getInput(8));

        m56.addInput(getInput(9));

        m56.addInput(getInput(10));

        m56.addInput(getInput(11));



        addOutput(m56.getOutput(0)); //read data 2 bit 23



        Mux32X1 m57 = new Mux32X1("mux57","32X1");

        for (int i = 0; i < 32 ; i++) {

            m57.addInput(rf.get(i).dataToLogic().get(24));

        }

        m57.addInput(getInput(7));

        m57.addInput(getInput(8));

        m57.addInput(getInput(9));

        m57.addInput(getInput(10));

        m57.addInput(getInput(11));



        addOutput(m57.getOutput(0)); //read data 2 bit 24



        Mux32X1 m58 = new Mux32X1("mux58","32X1");

        for (int i = 0; i < 32 ; i++) {

            m58.addInput(rf.get(i).dataToLogic().get(25));

        }

        m58.addInput(getInput(7));

        m58.addInput(getInput(8));

        m58.addInput(getInput(9));

        m58.addInput(getInput(10));

        m58.addInput(getInput(11));



        addOutput(m58.getOutput(0)); //read data 2 bit 25



        Mux32X1 m59 = new Mux32X1("mux59","32X1");

        for (int i = 0; i < 32 ; i++) {

            m59.addInput(rf.get(i).dataToLogic().get(26));

        }

        m59.addInput(getInput(7));

        m59.addInput(getInput(8));

        m59.addInput(getInput(9));

        m59.addInput(getInput(10));

        m59.addInput(getInput(11));



        addOutput(m59.getOutput(0)); //read data 2 bit 26



        Mux32X1 m60 = new Mux32X1("mux60","32X1");

        for (int i = 0; i < 32 ; i++) {

            m60.addInput(rf.get(i).dataToLogic().get(27));

        }

        m60.addInput(getInput(7));

        m60.addInput(getInput(8));

        m60.addInput(getInput(9));

        m60.addInput(getInput(10));

        m60.addInput(getInput(11));



        addOutput(m60.getOutput(0)); //read data 2 bit 27



        Mux32X1 m61 = new Mux32X1("mux61","32X1");

        for (int i = 0; i < 32 ; i++) {

            m61.addInput(rf.get(i).dataToLogic().get(28));

        }

        m61.addInput(getInput(7));

        m61.addInput(getInput(8));

        m61.addInput(getInput(9));

        m61.addInput(getInput(10));

        m61.addInput(getInput(11));



        addOutput(m61.getOutput(0)); //read data 2 bit 28



        Mux32X1 m62 = new Mux32X1("mux62","32X1");

        for (int i = 0; i < 32 ; i++) {

            m62.addInput(rf.get(i).dataToLogic().get(29));

        }

        m62.addInput(getInput(7));

        m62.addInput(getInput(8));

        m62.addInput(getInput(9));

        m62.addInput(getInput(10));

        m62.addInput(getInput(11));



        addOutput(m62.getOutput(0)); //read data 2 bit 29



        Mux32X1 m63 = new Mux32X1("mux63","32X1");

        for (int i = 0; i < 32 ; i++) {

            m63.addInput(rf.get(i).dataToLogic().get(30));

        }

        m63.addInput(getInput(7));

        m63.addInput(getInput(8));

        m63.addInput(getInput(9));

        m63.addInput(getInput(10));

        m63.addInput(getInput(11));



        addOutput(m63.getOutput(0)); //read data 2 bit 30



        Mux32X1 m64 = new Mux32X1("mux64","32X1");

        for (int i = 0; i < 32 ; i++) {

            m64.addInput(rf.get(i).dataToLogic().get(31));

        }

        m64.addInput(getInput(7));

        m64.addInput(getInput(8));

        m64.addInput(getInput(9));

        m64.addInput(getInput(10));

        m64.addInput(getInput(11));



        addOutput(m64.getOutput(0)); //read data 2 bit 31



    }



    public void setRf(HashMap<Integer, Register> rf) {

        this.rf = rf;

    }



    public HashMap<Integer, Register> getRf() {

        return rf;

    }



    public static void main(String[] args) {

        Clock clock = new Clock("clock",100);//clock cycle 0 , regWrite signal 1 , register read 1(2:6) , 2(7:11) ; register write(12:16) , write data ( 17:48 )

        RegisterFile registerFile = new RegisterFile("Register File", "49X64", clock.getOutput(0), Simulator.falseLogic

                , Simulator.falseLogic , Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic,

                Simulator.trueLogic , Simulator.falseLogic, Simulator.falseLogic , Simulator.falseLogic, Simulator.falseLogic );



        for (int i = 0; i < 37; i++) {

            registerFile.addInput(Simulator.falseLogic);

        }



        for (Link link: registerFile.getOutputs()

        ) {

            System.out.println(link.getSignal());

        }



    }

}