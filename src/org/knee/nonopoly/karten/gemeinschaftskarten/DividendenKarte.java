package org.knee.nonopoly.karten.gemeinschaftskarten;

import org.knee.nonopoly.karten.Karte;
import org.knee.nonopoly.logik.Schiedsrichter;

/**
 * @author Adrian
 * Gemeinschaftskarte 9
 */
public class DividendenKarte implements Karte {
    /**
     * Der Spieler erhält eine Dividendenzahlung von der Bank.
     * @param schiedsrichter
     */
    @Override
    public void fuehreKartenAktionAus(Schiedsrichter schiedsrichter) {
        schiedsrichter.getBank().ueberweiseAn(900, schiedsrichter.getAktiverSpieler());
    }

}
