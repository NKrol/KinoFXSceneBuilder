public class Widz extends Osoba {

    public int wyszukaj(SeanseList a, String tytul) {
        int wynik = a.wyszukajTytul(tytul);
        return wynik;
    }

    @Override
    public int rezerwuj(SeanseList a, String tytul, int iloscRezerwowanych) {
        int wynik = a.rezerwuj(tytul, iloscRezerwowanych);
        return wynik;
    }

    @Override
    public int anulujRezerwacje(SeanseList a, String tytul, int iloscZwrotow) {
        int wynik = a.anulujRezerwacje(tytul, iloscZwrotow);
        if (wynik == -5){
            return -5;
        }else {
            return wynik;
        }
    }

    @Override
    public int kupBilet(SeanseList a, String tytul, int iloscKupowanych) {
        int wynik = a.kupBilet(tytul, iloscKupowanych);
        return wynik;
    }
}
