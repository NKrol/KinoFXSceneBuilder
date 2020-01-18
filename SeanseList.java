import java.util.ArrayList;

public class SeanseList {
    private ArrayList<Seans> seans = new ArrayList<Seans>();

    private int iloscSeansow;

    public int getIloscSeansow() {
        return iloscSeansow;
    }

    public Seans getSeans(int pozycja) {
        return seans.get(pozycja);
    }

    public void dodajSeans(String tytul, String gatunek, int iloscMiejsc) {
        seans.add(new Seans(tytul, gatunek, iloscMiejsc));
        iloscSeansow++;
    }

    public void pokazSeanse(String[] info){
        info = new String[seans.size()];
        for (int i = 0; i < seans.size(); i++) {
            info[i] = seans.get(i).toString();
        }
        for (int i = 0; i < seans.size(); i++) {
            System.out.println(info[i]);
        }
    }

    public int rezerwuj(String tytul, int iloscRezerwowanychBiletow) {
        int pozycja = wyszukajTytul(tytul);
        if (pozycja == -2) {
            return -2;
        } else {
            if (seans.get(pozycja).getIloscMiejsc() >= iloscRezerwowanychBiletow) {
                getSeans(pozycja).rezerwuj(iloscRezerwowanychBiletow);
                return 0;
            } else {
                return -1;
            }
        }
    }

    public int kupBilet(String tytul, int iloscKupowanychBiletow) {
        int pozycja = wyszukajTytul(tytul);
        if (pozycja == -2) {
            return -2;
        } else {
            if (seans.get(pozycja).getIloscMiejsc() >= iloscKupowanychBiletow) {
                getSeans(pozycja).kupBilet(iloscKupowanychBiletow);
                return 0;
            } else {
                return -1;
            }
        }
    }

    public int wyszukajTytul(String tytul) {
        for (int i = 0; i < seans.size(); i++) {
            if ((seans.get(i).getTytul().equals(tytul)))
                return i;
        }
        return -2;
    }


    public int sprzedajBilet(String tytul, int iloscKupowanychBiletow) {
        int pozycja = wyszukajTytul(tytul);
        if (pozycja == -2) {
            return -2;
        } else {
            if (seans.get(pozycja).getIloscMiejsc() >= iloscKupowanychBiletow) {
                getSeans(pozycja).kupBilet(iloscKupowanychBiletow);
                return 0;
            }else {
                return -1;
            }
        }
    }


    public int anulujRezerwacje(String tytul, int iloscZwrotow) {
        int pozycja = wyszukajTytul(tytul);
        if (pozycja == -2) {
            return -2;
        } else {
            if (seans.get(pozycja).getIloscZarezerwowanychBiletow() >= iloscZwrotow) {
                seans.get(pozycja).anulujRezerwacje(iloscZwrotow);
                return 0;
            } else {
                return -5;
            }
        }
    }

    public int usunSeans(String tytul) {
        int pozycja = wyszukajTytul(tytul);
        if (pozycja == -2) {
            return -2;
        } else {
            seans.remove(pozycja);
            return 0;
        }
    }

    public String toString(int pozycja) {
        String string = "Film: " +
                seans.get(pozycja).getTytul() + ", Gatunek: " +
                seans.get(pozycja).getGatunek();
        if (seans.get(pozycja).getIloscMiejsc() > 0) string += " Nadal są dostępne miesjca";
        if (seans.get(pozycja).getIloscMiejsc() == 0) string += " Miejsca na aktualny seans skończyły się.";

        return string;
    }

    public static void main(String[] args){
        SeanseList seanseList = new SeanseList();
        seanseList.dodajSeans("Tak", "Akcja", 100);
        seanseList.dodajSeans("Nie", "Akcja", 100);
        seanseList.dodajSeans("Ale", "Akcja", 100);
        seanseList.dodajSeans("Iasd", "Akcja", 100);
        seanseList.dodajSeans("Chuj z tym", "Akcja", 100);

    }

}