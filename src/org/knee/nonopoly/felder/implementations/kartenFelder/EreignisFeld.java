package org.knee.nonopoly.felder.implementations.kartenFelder;

import org.knee.nonopoly.felder.abstracts.KartenFeld;

/**
 * Created by Nils on 24.09.2016.
 */
public class EreignisFeld extends KartenFeld {
    public EreignisFeld(int index, String name) {
        super(index, name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ereignisfeld{");
        sb.append("index='").append(this.getIndex()).append('\'');
        sb.append('}');
        sb.append("name='").append(this.getName()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}