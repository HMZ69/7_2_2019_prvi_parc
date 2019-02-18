package ba.unsa.rpr;

public class Radnik implements Comparable<Radnik> {
    private String imePrezime;
    private String jmbg;
    private double[] plate = new double[1000];

    public Radnik(String imePrezime, String jmbg) {
        this.imePrezime = imePrezime;
        this.jmbg = jmbg;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public double[] getPlate() {
        return plate;
    }

    public void dodajPlatu(double plata) {
        boolean nestoUradjeno = false;
        for (int i = 0; i < 1000; i++) {
            if (this.getPlate()[i] != 0) {
                this.getPlate()[i] = plata;
                nestoUradjeno = true;
                break;
            }
        }
        if (!nestoUradjeno)
            throw new IllegalArgumentException("Ne mozete registrovati vise od 1000 plata za radnika " + this.getImePrezime());
    }

    public double prosjecnaPlata() {
        double rvalue = 0;
        double suma = 0;
        if(this.getPlate().length == 0)
            return rvalue;
        else {
            for (int i = 0; i < this.getPlate().length; i++) {
                suma = suma + this.getPlate()[i];
                rvalue = suma / (i+1);
            }
        }
        return rvalue;
    }

    @Override
    public int compareTo(Radnik r) {
        if (this.prosjecnaPlata() > r.prosjecnaPlata())
            return -1;
        else
            return 1;
    }
}
