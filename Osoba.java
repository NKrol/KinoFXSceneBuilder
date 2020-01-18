abstract class Osoba {
    String nazwisko;
    int pozycjaObslugiwania;

    public abstract int wyszukaj(SeanseList a, String tytul);
    public abstract int rezerwuj(SeanseList a, String tytul, int iloscRezerwowanych);
    public abstract int anulujRezerwacje(SeanseList a, String tytul, int iloscZwrotow);
    public abstract int kupBilet(SeanseList a, String tytul, int iloscKupowanych);
}
