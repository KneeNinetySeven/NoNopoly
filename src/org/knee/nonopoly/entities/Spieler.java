package org.knee.nonopoly.entities;

import org.knee.nonopoly.entities.spielerStrategien.Strategie;
import org.knee.nonopoly.karten.gemeinschaftskarten.GefaengnisKarte;

import javax.swing.*;

/**
 * Created by Nils on 09.09.2016.
 *
 *
 */
public class Spieler extends Entity {

    private boolean istAusgeschieden;
    private int imGefaengnis;
    private GefaengnisKarte gefaengnisFreiKarte;
    private int pascheInFolge;
    private int position;
    private Strategie strategie;

    /**
     * Erstellt einen vollständigen Spieler
     * @param name
     * @param strategie
     * @return
     */
    public static Spieler spielerErzeugen(String name, Strategie strategie){
        Spieler spieler = new Spieler();
        spieler.setName(name);
        spieler.setStrategie(strategie);
        return spieler;
    }

    /**
     * Konstruktor
     */
    private Spieler() {
        super();
        this.setGuthaben(0);
        this.setPosition(0);
        this.setName("");
        this.setImSpiel(true);
        this.setIstAusgeschieden(false);
        this.pascheInFolge = 0;
    }

    /**
     * Zählt den Pasch-Counter dieser Folge hoch.
     * @return Gibt zurück, ob es sich schon um das dritte Pasch handelt
     */
    public boolean registrierePasch(){
        this.pascheInFolge++;
        return pascheInFolge == 3;
    }

    /**
     * Nullt die Paschserie wieder
     */
    public void pascheZuruecksetzen(){
        this.pascheInFolge = 0;
    }

    /**
     * Spieler wird ins Gefängnis gebracht
     */
    public void geheInsGefaengnis(){
        setPosition(10);
        setImGefaengnis(3);
    }

    /**
     * Spielt die Gefängniskarte aus und gibt sie ab
     */
    public void gefaengniskarteSpielen(){
        this.getGefaengnisFreiKarte().abgeben();
        JOptionPane.showMessageDialog(null, this.getName().toUpperCase() + "spielt die Gefängniskarte und kommt frei.");

    }

    /**
     * Spieler wird wieder freigelassen
     */
    public void verlasseDasGefängnis(){
        setImGefaengnis(0);
    }

    @Override
    public String toString(){
        return "Spieler[" + this.getGuthaben() + "," + this.getName() + "," +"imSpiel:" + getImSpiel() +
                " Strategie: " + this.strategie.getName() + "]";
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Strategie getStrategie() {
        return strategie;
    }

    public void setStrategie(Strategie strategie) {
        this.strategie = strategie;
    }

    public boolean istImSpiel() {
        return this.getImSpiel();
    }

    public int getImGefaengnis() {
        return imGefaengnis;
    }

    public void setImGefaengnis(int imGefaengnis) {
        this.imGefaengnis = imGefaengnis;
    }

    public GefaengnisKarte getGefaengnisFreiKarte() {
        return gefaengnisFreiKarte;
    }

    public void setGefaengnisFreiKarte(GefaengnisKarte gefaengnisFreiKarte) {
        this.gefaengnisFreiKarte = gefaengnisFreiKarte;
    }

    public boolean istAusgeschieden() {
        return istAusgeschieden;
    }

    public void setIstAusgeschieden(boolean istAusgeschieden) {
        this.istAusgeschieden = istAusgeschieden;
    }
}
