package ba.unsa.rpr;

import java.io.Serializable;

public class RadnoMjesto implements Serializable {
    private String naziv;
    private double koeficijent;
    private Radnik radnik;

    public RadnoMjesto() {
        this.naziv = null;
        this.koeficijent = 0;
        this.radnik = null;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getKoeficijent() {
        return koeficijent;
    }

    public void setKoeficijent(double koeficijent) {
        this.koeficijent = koeficijent;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof RadnoMjesto) {
            RadnoMjesto rm = (RadnoMjesto) o;
            return (this.naziv.equals(rm.getNaziv()) && this.koeficijent == rm.getKoeficijent());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int)(this.naziv.hashCode()*koeficijent);
    }

}
