/*****************************************************************************
 * Algoritmid ja andmestruktuurid. LTAT.03.005
 * 2023/2024 sügissemester
 *
 * Kodutöö. Ülesanne nr 2a
 * Teema: Rekursioon. Variantide läbivaatamine
 *
 * Autor: Taavi Raudkivi
 *
 * Mõningane eeskuju:
 *
 *****************************************************************************/
public class Kodu2A {

    /**
     * Leida, kas järjendis a on kombinatsioon, mille elementide summa on 10000
     * ja kus ükski kahest naaber elemendist pole valitud.
     *
     * @param a Antud järjend.
     * @return true, kui leidub sobiv kombinatsioon, vastasel juhul false.
     */
    public static boolean valik(int[] a) {
        if (a.length == 2) {
            // Äärejuht, kui on listis 2 elementi, siis tagastab true ainult siis kui üks element on 10000
            if (a[0] != 10000 && a[1] != 10000) {
                return false;
            }
        }
        return kasLeidubSummaKombinatsioon(a, 10000, 0);
    }

    private static boolean kasLeidubSummaKombinatsioon(int[] a, int summa, int indeks) {
        if (summa == 0) {
            return true;
        }
        if (summa < 0 || indeks >= a.length) {
            return false;
        }

        // Try skipping the current number
        boolean jataVahele = kasLeidubSummaKombinatsioon(a, summa, indeks + 1);

        // Try including the current number if it's not adjacent to the previous number
        if (indeks == 0 || (indeks > 0 && a[indeks - 1] != a[indeks] - 1)) {
            boolean lisaTulemus = kasLeidubSummaKombinatsioon(a, summa - a[indeks], indeks + 1);
            return jataVahele || lisaTulemus;
        }

        return jataVahele;
    }


    public static void main(String[] args) {
        int[] jarjendTrue = {100, 5000, 2000, 3000, 1000, 500, 2000};
        int[] jarjendTrue1 = {500, 100, 200, 3000, 300, 4000, 100, 20, 2000, 30, 1000, 20};
        int[] jarjendTrue2 = {100, 5000, 200, 5000};
        int[] jarjendFalse = {500, 100, 200, 300, 4000, 100, 20, 2000, 20};
        int[] jarjendFalse1 = {5000, 5000};


        long start = System.nanoTime();
        boolean vastus = valik(jarjendTrue2);
        long finish = System.nanoTime();
        long timeElapsed = finish - start;

        System.out.println(vastus);
        System.out.println(timeElapsed);
    }
}
