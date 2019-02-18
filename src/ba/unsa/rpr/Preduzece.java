package ba.unsa.rpr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Preduzece {
    private int osnovica;
    private ArrayList<RadnoMjesto> radnaMjesta = new ArrayList<RadnoMjesto>();

    public Preduzece(int osnovica) throws NeispravnaOsnovica {
        if (osnovica <= 0)
            throw new NeispravnaOsnovica("Neispravna osnovica " + osnovica);
        this.osnovica = osnovica;
    }

    public int dajOsnovicu() {
        return osnovica;
    }

    public void postaviOsnovicu(int osnovica) throws NeispravnaOsnovica {
        if (osnovica <= 0)
            throw new NeispravnaOsnovica("Neispravna osnovica " + osnovica);
        this.osnovica = osnovica;
    }

    public void novoRadnoMjesto(RadnoMjesto rm) {
        this.radnaMjesta.add(rm);
    }

    public void zaposli(Radnik r, String rmnaziv) {
        for (RadnoMjesto rm : this.radnaMjesta)
            if (rm.getNaziv().equals(rmnaziv) && rm.getRadnik().equals(null)) {
                rm.setRadnik(r);
                return;
            }
        throw new IllegalStateException("Nijedno radno mjesto tog tipa nije slobodno");
    }

    public void obracunajPlatu() {
        for (RadnoMjesto rm : this.radnaMjesta) {
            if (!rm.getRadnik().equals(null))
                rm.getRadnik().dodajPlatu(rm.getKoeficijent()*this.dajOsnovicu());
        }
    }

    public double iznosPlate() {
        double suma = 0;
        for (RadnoMjesto rm : this.radnaMjesta) {
            if (!rm.getRadnik().equals(null))
                suma += rm.getKoeficijent()*this.osnovica;
        }
        return suma;
    }

    public Set<Radnik> radnici() {
        TreeSet<Radnik> rvalue = new TreeSet<>();
        for (RadnoMjesto rm : this.radnaMjesta) {
            if (!rm.getRadnik().equals(null))
                rvalue.add(rm.getRadnik());
        }
        return rvalue;
    }

    public void sistematizacija() {
        HashMap<RadnoMjesto, Integer> rvalue = new HashMap<>();
        for (RadnoMjesto rm : radnaMjesta) {
            Integer broj = rvalue.get(rm);
            if (broj == null)
                rvalue.put(rm, 1);
            else
                rvalue.put(rm, broj + 1);
        }
    }

}
