package org.knee.nonopoly.logik;

import org.jdom2.JDOMException;
import org.knee.nonopoly.entities.Bank;
import org.knee.nonopoly.entities.Spieler;
import org.knee.nonopoly.entities.spielerStrategien.Strategie;
import org.knee.nonopoly.felder.Feld;
import org.knee.nonopoly.logik.logging.Protokollant;
import org.knee.nonopoly.logik.util.XML.JDOMParsing;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Nils on 11.09.2016.
 */
public class Schiedsrichter {

    private Feld[] spielbrett;
    private ArrayList<Spieler> teilnehmer;
    private Bank bank;
    private Protokollant protokollant;
    //    private DOMParsingUtil domParser;
    private JDOMParsing jdomParser;

    public Schiedsrichter() {
        this.setProtokollant(new Protokollant());
        this.bank = new Bank();
        this.teilnehmer = new ArrayList<Spieler>();

        try {
            this.jdomParser = new JDOMParsing("nichtStrassen.xml");
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.spielbrett = new Feld[48];
        this.spielbrettAnlegen();
    }

    private void spielbrettAnlegen() {
        // TODO: domParser einrichten
        this.jdomParser.dateiVerarbeiten();
    }

    public Protokollant getProtokollant() {
        return protokollant;
    }

    private void setProtokollant(Protokollant protokollant) {
        this.protokollant = protokollant;
    }

    public ArrayList<Spieler> getTeilnehmer() {
        return teilnehmer;
    }

    public void registriereTeilnehmer(String name, Strategie strategie) {
        this.teilnehmer.add(Spieler.spielerErzeugen(name, strategie));
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
