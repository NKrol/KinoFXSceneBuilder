public class Seans {
    private String tytul;
    private Gatunek gatunek;
    private int iloscMiejsc;
    private int iloscZarezerwowanychBiletow;
    private int iloscKupionychBiletow;


    public Seans(String tytul, String gatunek, int iloscMiejsc) {
        this.tytul = tytul;
        this.gatunek = Gatunek.fromDesc(gatunek);
        this.iloscMiejsc = iloscMiejsc;
    }


    public int getIloscMiejsc() {
        return iloscMiejsc;
    }


    public String getTytul() {
        return tytul;
    }

    public Gatunek getGatunek() {
        return gatunek;
    }

    public void setIloscMiejsc(int iloscMiejsc) {
        this.iloscMiejsc = iloscMiejsc;
    }

    public void setIloscZarezerwowanychBiletow(int iloscZarezerwowanychBiletow) {
        this.iloscZarezerwowanychBiletow = iloscZarezerwowanychBiletow;
    }

    public void setIloscKupionychBiletow(int iloscKupionychBiletow) {
        this.iloscKupionychBiletow = iloscKupionychBiletow;
    }

    public int getIloscZarezerwowanychBiletow() {
        return iloscZarezerwowanychBiletow;
    }

    public int getIloscKupionychBiletow() {
        return iloscKupionychBiletow;
    }

    public int rezerwuj(int iloscRezerwowanychBiletow) {
        if (iloscMiejsc >= iloscRezerwowanychBiletow) {
            iloscMiejsc = iloscMiejsc - iloscRezerwowanychBiletow;
            iloscZarezerwowanychBiletow = iloscZarezerwowanychBiletow +iloscRezerwowanychBiletow;
            return 0;
        } else {
            return -1;
        }
    }

    public int kupBilet(int iloscKupowanychBiletow) {
        if (iloscMiejsc >= iloscKupowanychBiletow) {
            iloscMiejsc = iloscMiejsc - iloscKupowanychBiletow;
            iloscKupionychBiletow = iloscKupionychBiletow + iloscKupowanychBiletow;
            return 0;
        } else {
            return -1;
        }
    }

    public int anulujRezerwacje(int iloscZwrotow) {
        if (iloscZarezerwowanychBiletow >= iloscZwrotow) {
            iloscMiejsc = iloscMiejsc + iloscZwrotow;
            iloscZarezerwowanychBiletow = iloscZarezerwowanychBiletow - iloscZwrotow;
            return 0;
        } else {
            return -5;
        }
    }

    public int zwrocBilety(int iloscZwrotow) {
        if (iloscKupionychBiletow >= iloscZwrotow) {
            iloscMiejsc = iloscMiejsc + iloscZwrotow;
            iloscKupionychBiletow = iloscKupionychBiletow - iloscZwrotow;
            return 0;
        }else {
            return -5;
        }
    }

    public String toString() {
        String string = "Seans filmu: " + getTytul() + ", Gatunek: " + getGatunek() + ". "
                + getIloscMiejsc() + " ; " + getIloscZarezerwowanychBiletow() + " ; " + getIloscKupionychBiletow() + "   " ;
        if (iloscMiejsc > 0) string += "Nadal są dostępne miesjca";
        if (iloscMiejsc == 0) string += "Miejsca na aktualny seans skończyły się.";

        return string;
    }


    public static void main(String[] args) {
        Seans test = new Seans("asdad", "Dramat", 200);
        System.out.println(test.getIloscMiejsc());
        test.rezerwuj(4);
        System.out.println(test);
        test.anulujRezerwacje(6);
        System.out.println(test.getIloscZarezerwowanychBiletow());
    }
}
