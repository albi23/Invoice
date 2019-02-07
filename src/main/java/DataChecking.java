import javax.swing.*;

/**
 * KLASA ODPOWIEDZIALNA ZA SPRAWDZANIE POPRAWNOŚCI WROWADZANYCH DANYCH WPROWADZANYCH DO OKIENEK KONTRAHENCI I SPRZEDAWCY
 */


class DataChecking {
   // int ID;
    private final String NazwaKontrahenta;
    private String NIP;
    private final String Ulica;
    private final String NrBudynku;
    private final String NrLokalu;
    private final String Miasto;
    private final String KodPocztowy;
    private final String NumerTelefonu;
    private boolean CorrectData = true;
    public KontrahenciGoodData kontrahencigooddata;
    public SprzedawcyGoodData sprzedawcyGoodData;

    DataChecking(String NazwaKontrahenta, String NIP, String Ulica,
                            String NrBudynku, String NrLokalu, String Miasto,
                            String KodPocztowy, String NumerTelefonu, int ID) {
        this.NazwaKontrahenta = NazwaKontrahenta;
        this.NIP = NIP;
        this.Ulica = Ulica;
        this.NrBudynku = NrBudynku;
        this.NrLokalu = NrLokalu;
        this.Miasto = Miasto;
        this.KodPocztowy = KodPocztowy;
        this.NumerTelefonu = NumerTelefonu;
        int ID1 = ID;

        isEmptyFiles();
        if (CorrectData && ChcekNIP() && CheckNrTelefonu()) {
            CheckKodPocztowy();
            CheckNrLokalu();
        }
        if(ID == 0  && CorrectData){
            CreateGoodDataKontrahenci();
        }
        else if (ID == 1 && CorrectData) {
            CreateGoodDataSprzedawcy();
        }
    }

    private void CreateGoodDataKontrahenci(){
        kontrahencigooddata = new KontrahenciGoodData();
        kontrahencigooddata.setKodPocztowy(KodPocztowy);
        kontrahencigooddata.setMiasto(Miasto);
        kontrahencigooddata.setNazwaKontrahenta(NazwaKontrahenta);
        kontrahencigooddata.setNIP(NIP);
        kontrahencigooddata.setNrBudynku(NrBudynku);
        kontrahencigooddata.setNrLokalu(NrLokalu);
        kontrahencigooddata.setNumerTelefonu(NumerTelefonu);
        kontrahencigooddata.setUlica(Ulica);
        kontrahencigooddata.CreateKontrahenci();
        kontrahencigooddata.SaveObjectOfKontrahenci();
        JOptionPane.showMessageDialog(null, "" +
                "Dodano  kontrahenta", "Informacja ", JOptionPane.INFORMATION_MESSAGE);
    }

    private void CreateGoodDataSprzedawcy(){
        sprzedawcyGoodData = new SprzedawcyGoodData();
        sprzedawcyGoodData.setKodPocztowy(KodPocztowy);
        sprzedawcyGoodData.setMiasto(Miasto);
        sprzedawcyGoodData.setNazwaSprzedawcy(NazwaKontrahenta);
        sprzedawcyGoodData.setNIP(NIP);
        sprzedawcyGoodData.setNrBudynku(NrBudynku);
        sprzedawcyGoodData.setNrLokalu(NrLokalu);
        sprzedawcyGoodData.setNumerTelefonu(NumerTelefonu);
        sprzedawcyGoodData.setUlica(Ulica);
        sprzedawcyGoodData.CreateSprzedawcy();
        sprzedawcyGoodData.SaveObjectOfSprzedawcy();
        JOptionPane.showMessageDialog(null, "" +
                "Dodano  Sprzedawcę", "Informacja ", JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean ChcekNIP() {
        if (NIP.length() < 10) {
            JOptionPane.showMessageDialog(null, "" +
                    "Wprowadziłeś zbyt krótki NIP ", "Informacja ", JOptionPane.INFORMATION_MESSAGE);
            return  false;
        } else  {
            int c = 0;
            StringBuilder nip = new StringBuilder();
            String tempNIP = NIP;
            while (c <= tempNIP.length() - 1) {
                if (tempNIP.charAt(c) != ' ') {
                    nip.append(Character.toString(tempNIP.charAt(c)));
                }
                c++;
            }
            tempNIP = nip.toString();
            if(!isCorrectInt(tempNIP)) {
                JOptionPane.showMessageDialog(null, "" +
                        "Twój numer NIP zawiera nieprawidłowe znaki ", "Informacja ", JOptionPane.INFORMATION_MESSAGE);
                return  false;
            }else {
                NIP = tempNIP;
            }

        }
        return true;


    }

    private boolean CheckNrTelefonu() {
        String tempNr = NumerTelefonu;
        if (tempNr.charAt(0) == '+') {
            tempNr = tempNr.substring(1);
        }
        int c = 0;
        StringBuilder nr = new StringBuilder();
        while (c <= tempNr.length() - 1) {
            if (tempNr.charAt(c) != ' ') {
                nr.append(Character.toString(tempNr.charAt(c)));
            }
            c++;
        }
        tempNr = nr.toString();
        if (!isCorrectInt(tempNr) || (tempNr.length() != 11 && tempNr.length() != 9)) {
            JOptionPane.showMessageDialog(null, "" +
                    "Twój numer telefonu jest nieprawidłowy", "Informacja ", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;

    }

    private void CheckKodPocztowy() {
        String tempKod = KodPocztowy;
        if (tempKod.length() == 5) {
            if (tempKod.charAt(2) == ' ' || tempKod.charAt(2) == '-') {
                tempKod = tempKod.substring(0, 1) + tempKod.substring(3, tempKod.length() - 1);
            }
            if (!isCorrectInt(tempKod) || tempKod.length() != 5) {
                JOptionPane.showMessageDialog(null, "" +
                        "Twój kod pocztowy zawiera nieprawidłowe znaki ", "Informacja ", JOptionPane.INFORMATION_MESSAGE);
                CorrectData = false;
            }
        }
    }

    private void isEmptyFiles() {
        if (NazwaKontrahenta.length() < 1 || NIP.length() < 1 || Ulica.length() < 1 ||
                NrBudynku.length() < 1 || NrLokalu.length() < 1 || Miasto.length() < 1 ||
                KodPocztowy.length() < 1 || NumerTelefonu.length() < 1) {
            JOptionPane.showMessageDialog(null, "" +
                    "Nie wypełniono wszystkich pól", "Informacja ", JOptionPane.INFORMATION_MESSAGE);
            CorrectData = false;
        }
    }

    private boolean isCorrectInt(String incomingData) {
        try {
            long result = Long.parseLong(incomingData);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private void CheckNrLokalu() {
        String tempBud = NrLokalu;
        if (tempBud.length() >= 1) {
            if (isCorrectInt(Character.toString(tempBud.charAt(0)))) {
                int c = 0;
                while (c <= tempBud.length() - 2) {
                    if (!isCorrectInt(Character.toString(tempBud.charAt(c)))) {
                        JOptionPane.showMessageDialog(null, "" +
                                "Twój numer lokalu jest nieprawidłowy1", "Informacja ", JOptionPane.INFORMATION_MESSAGE);
                        CorrectData = false;
                        break;
                    }
                    c++;
                }
            } else {
                JOptionPane.showMessageDialog(null, "" +
                        "Twój numer lokalu jest nieprawidłowy2", "Informacja ", JOptionPane.INFORMATION_MESSAGE);
                CorrectData = false;
            }
        }
    }
}

