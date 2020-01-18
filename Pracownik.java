import java.util.Arrays;

public class Pracownik extends Osoba {

    static final String login = "Pracownik";
    private boolean zalogowany = false;

    public int loguj(String login) {
        if (this.login.equals(login)) {
            zalogowany = true;
            return 0;
        } else {
            return -4;
        }
    }

    public int wyloguj() {
        zalogowany = false;
        return -4;
    }

    public void pokazSeanse(SeanseList a){
    }

    @Override
    public int wyszukaj(SeanseList a, String tytul) {
        if (zalogowany) {
            int wynik = a.wyszukajTytul(tytul);
            return wynik;
        } else {
            return -4;
        }
    }


    @Override
    public int rezerwuj(SeanseList a, String tytul, int iloscRezerwowanych) {
        if (zalogowany) {
            int wynik = a.rezerwuj(tytul, iloscRezerwowanych);
            return wynik;
        } else {
            return -4;
        }
    }

    @Override
    public int anulujRezerwacje(SeanseList a,String tytul, int iloscZwrotow) {
        if (zalogowany) {
            int wynik = a.anulujRezerwacje(tytul, iloscZwrotow);
            if (wynik == -5){
                return -5;
            }
            return wynik;
        }else {
            return -4;
        }
    }

    @Override
    public int kupBilet(SeanseList a,String tytul, int iloscKupowanych) {
        if (zalogowany) {
            int wynik = a.kupBilet(tytul, iloscKupowanych);
            return wynik;
        } else {
            return -4;
        }
    }

    public int sprzedajBilet(SeanseList a,String tytul, int iloscSprzedawanych) {
        if (zalogowany) {
            int wynik = a.sprzedajBilet(tytul, iloscSprzedawanych);
            return wynik;
        } else {
            return -4;
        }
    }


}
