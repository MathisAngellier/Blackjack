public class Kaart {
    private int waarde;
    private Symbool symbool;

    public Kaart(int waarde, Symbool symbool) {
        this.waarde = waarde;
        this.symbool = symbool;
    }

    public Kaart() {

    }

    @Override
    public String toString() {
        return "Kaart{" +
                "waarde=" + waarde +
                ", symbool=" + symbool +
                '}';
    }//do u know da wae

    public int getWaarde() {
        return waarde;
    }

    public void setWaarde(int waarde) {
        this.waarde = waarde;
    }

    public Symbool getSymbool() {
        return symbool;
    }

    public void setSymbool(Symbool symbool) {
        this.symbool = symbool;
    }
}
