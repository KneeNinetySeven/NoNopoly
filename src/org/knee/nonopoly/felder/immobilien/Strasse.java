package org.knee.nonopoly.felder.immobilien;

import org.knee.nonopoly.entities.Bank;
import org.knee.nonopoly.entities.Spieler;
import org.knee.nonopoly.logik.Schiedsrichter;

import java.util.List;

/**
 * Created by Nils on 24.09.2016.
 */
public class Strasse extends ImmobilienFeld {

    private int hausanzahl;
    private List<Integer> mietStaffel;
    int hauspreis;

    public Strasse(int index, String name, int kaufpreis, List<Integer> mietStaffel, int hauspreis) {
        super(index, name, kaufpreis);
        this.immobilienTyp = ImmobilienTypen.STRASSE;
        this.mietStaffel = mietStaffel;
        this.hauspreis = hauspreis;
    }

    @Override
    public void fuehrePflichtAktionAus(Schiedsrichter schiedsrichter) {
        Spieler aktiverSpieler = schiedsrichter.getAktiverSpieler();
        if (this.besitzer == schiedsrichter.getBank()){
            if(aktiverSpieler.getStrategie().erlaubtFeldKauf(aktiverSpieler, this)){
                schiedsrichter.getProtokollant().printAs(aktiverSpieler.getName() + " kauft " + getName());
                wirdGekauftDurchSpieler(aktiverSpieler, schiedsrichter.getBank());
            }
        } else if(this.besitzer == aktiverSpieler){
            if(aktiverSpieler.getStrategie().erlaubtHausbau(aktiverSpieler, this) & getHausanzahl() < 6){
                schiedsrichter.getProtokollant().printAs(aktiverSpieler + " baut ein neues Haus");
                wirdNeuBebaut(aktiverSpieler, schiedsrichter.getBank());
            }
        } else {
            zahleMiete(aktiverSpieler);
        }
    }

    public void wirdNeuBebaut(Spieler spieler, Bank bank){
        spieler.ueberweiseAn(hauspreis, bank);
        baueHaus();
    }

    public void baueHaus(){
        this.setHausanzahl(getHausanzahl() + 1);
    }

    public void zahleMiete(Spieler spieler){
        spieler.ueberweiseAn(mietStaffel.get(getHausanzahl()), besitzer);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Strasse{");
        sb.append("index=").append(this.getIndex());
        sb.append(", name=").append(this.getName());
        sb.append(", kaufpreis=").append(this.getKaufpreis());
        sb.append(", mietStaffel=").append(this.mietStaffel);
        sb.append(", hauspreis=").append(this.hauspreis);
        sb.append('}');
        return sb.toString();
    }

    public int getHausanzahl() {
        return hausanzahl;
    }

    public void setHausanzahl(int hausanzahl) {
        this.hausanzahl = hausanzahl;
    }

    public int getHauspreis() {
        return hauspreis;
    }

    public void setHauspreis(int hauspreis) {
        this.hauspreis = hauspreis;
    }
}
