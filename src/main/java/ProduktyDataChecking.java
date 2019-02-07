import javax.swing.*;

/**
 * Klasa odpowiedzialna za sprawdzanie danych w polach wprowadzanych do okienka Produkty
 */

class ProduktyDataChecking {

    private final String NazwaTowaruLubUslugi;
    private final String Cena;
    private final String JM;
    private final String ilosc;
    private boolean isCorrectData = true;
    private int licznik;

    ProduktyDataChecking(String NazwaTowaruLubUslugi, String Cena, String JM, String ilosc, int licznik) {
        this.Cena = Cena;
        this.NazwaTowaruLubUslugi = NazwaTowaruLubUslugi;
        this.JM = JM;
        this.ilosc = ilosc;
        this.licznik = licznik;

        isEmptyFiles();
        if (isCorrectData ) {
            isCheckJM();
        }
        if(isCorrectData && isCheckJM() && isCheckCena() && licznik < 8 && isCheckIlość()){
            ProduktyGoodData pgd = new ProduktyGoodData();
            pgd.setNazwaTowaruLubUslugi(NazwaTowaruLubUslugi);
            pgd.setCena(Cena);
            pgd.setJM(JM);
            pgd.setIlość(ilosc);
            int indexofarray = 0;
            pgd.setindexofarray(indexofarray);
            pgd.setlicznik(licznik);
            pgd.addProduct();
            indexofarray++;
            this.licznik = licznik +1;
            JOptionPane.showMessageDialog(null, "" +
                    "Dodano  produkt", "Informacja ", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public int getLicznik(){
        return licznik;
    }

    void isEmptyFiles() {
        if (NazwaTowaruLubUslugi.length() < 1 || Cena.length() < 1 || JM.length() < 1) {
            JOptionPane.showMessageDialog(null, "" +
                    "Nie wypełniono wszystkich pól", "Informacja ", JOptionPane.INFORMATION_MESSAGE);
            isCorrectData = false;
        }
    }

    public boolean isCheckJM() {
        String goodJM[] = {"op", "szt", "karton", "paleta"};
        String tempJm = JM;
        boolean isgood = false;
        for (String s : goodJM) {
            if (tempJm.equals(s)) {
                return  true;
            }
        }
        if (isgood == false) {
            JOptionPane.showMessageDialog(null, "" +
                    "Jednostki miary to \"op\",\"szt\",\"karton \",\"paleta\"", "Informacja ", JOptionPane.INFORMATION_MESSAGE);
        }
        return  false;
    }

    public boolean isCheckCena() {
        try {
            double tempCena = Double.parseDouble(Cena);
            return  true;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "" +
                    "Wprowadzono niepoprawną cenę", "Informacja ", JOptionPane.INFORMATION_MESSAGE);
            return  false;
        }

    }

    public boolean isCheckIlość() {
        try {
            int tempCena = Integer.parseInt(ilosc);
            return   true;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "" +
                    "Wprowadzono niepoprawną ilość", "Informacja ", JOptionPane.INFORMATION_MESSAGE);
            return  false;
        }

    }
}
