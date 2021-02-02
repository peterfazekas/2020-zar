package hu.lock.model.service;

public class LockUtil {

    /**
     * 7. feladat: Állítsa elő a siker.txt fáljt, amelynek soraiban a nyitási próbálkozás
     * kódszáma után  – attól egy szóközzel elválasztva – annak értékelése olvasható.
     * • „hibás hossz”, ha a felhasználótól a 2. feladatban bekért kódszám és a sorbeli kódszám hossza eltér;
     * • „hibás kódszám”, ha a felhasználótól a 2. feladatban bekért kódszám és a sorbeli kódszám hossza egyezik, de nem összetartozók;
     * • „sikeres”, ha a két kódszám egyenértékű.
     */
    public static String openResult(String pattern, String key) {
        String result;
        if (!isSameLength(pattern, key)) {
            result = "hibás hossz";
        } else {
            result = open(pattern, key) ? "sikeres" : "hibás kódszám";
        }
        return result;
    }

    public static boolean open(String pattern, String key) {
        return nyit(pattern, key);
    }

    public static boolean isSameLength(String pattern, String key) {
        return pattern.length() == key.length();
    }

    /**
     * 6. feladat: Készítsen függvényt nyit néven az alábbi algoritmus alapján, amely a neki átadott két
     * kódszámról megállapítja, hogy ugyanazt a zárat nyitják-e!
     */
    private static boolean nyit(String jo, String proba) {
        boolean egyezik = isSameLength(jo, proba);
        int elteres = 0;
        if (egyezik) {
            elteres = (int) jo.charAt(0) - (int) proba.charAt(0);
        }
        for (int i = 1; i < jo.length(); i++) {
            if ((elteres - ((int) jo.charAt(i) - (int) proba.charAt(i))) % 10 != 0) {
                egyezik = false;
                break;
            }
        }
        return egyezik;
    }
}
