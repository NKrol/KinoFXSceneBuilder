public class Kierownik {
    static final String login = "Kierownik";
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

    public int dodajSeans(SeanseList a, String tytul, String gatunek, int bilety) {
        if (zalogowany) {
            a.dodajSeans(tytul, gatunek, bilety);
            return 0;
        } else {
            return -4;
        }
    }

    public int usunSeans(SeanseList a, String tytul) {
        if (zalogowany) {
            int wynik = a.usunSeans(tytul);
            return wynik;
        } else {
            return -4;
        }

    }

    public int wyszukaj(SeanseList a, String tytul) {
        if (zalogowany) {
            int wynik = a.wyszukajTytul(tytul);
            return wynik;
        } else {
            return -4;
        }
    }

}
