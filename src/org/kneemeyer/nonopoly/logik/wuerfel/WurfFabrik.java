package org.kneemeyer.nonopoly.logik.wuerfel;

/**
 * Created by Nils on 24.09.2016.
 */
public class WurfFabrik {

    private int wurf1;
    private int wurf2;

    public WurfFabrik(int wurf1, int wurf2 ){
        this.setWurf1(wurf1);
        this.setWurf2(wurf2);
    }

    public int getWurf1() {
        return wurf1;
    }

    public void setWurf1(int wurf1) {
        this.wurf1 = wurf1;
    }

    public int getWurf2() {
        return wurf2;
    }

    public void setWurf2(int wurf2) {
        this.wurf2 = wurf2;
    }
}
