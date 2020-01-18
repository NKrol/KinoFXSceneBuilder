import java.util.Comparator;

public class TitleComparate implements Comparator<Seans> {

    @Override
    public int compare(Seans s1, Seans s2) {
        if (s1.getTytul().compareToIgnoreCase(s2.getTytul()) > 0) return 1;
        if (s1.getTytul().compareToIgnoreCase(s2.getTytul()) < 0) return -1;
        return 0;
    }
}
