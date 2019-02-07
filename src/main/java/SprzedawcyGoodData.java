import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * KLASA PRZECHOWUJĄCA POPRAWNE/SPRAWDZONE DANE Z OKIENKA SPRZEDAWCA
 */

public class SprzedawcyGoodData {

    private String NazwaSprzedawcy;
    private String NIP;
    private String Ulica;
    private String NrBudynku;
    private String NrLokalu;
    private String Miasto;
    private String KodPocztowy;
    private String NumerTelefonu;
    private ArrayList<String> SprzedawcaList = new ArrayList<>();

    public void CreateSprzedawcy(){
        String sprzedawcy = NazwaSprzedawcy+"$"+NIP+"$"+Ulica+"$"+NrBudynku+"$"+NrLokalu+"$"+Miasto+"$"+KodPocztowy+"$"+NumerTelefonu+"$";
        SprzedawcaList.add(sprzedawcy);
    }

    private String getNazwaSprzedawcy() {
        return NazwaSprzedawcy;
    }

    public void setNazwaSprzedawcy(String NazwaSprzedawcy) {
        this.NazwaSprzedawcy = NazwaSprzedawcy;
    }

    public String getUlica() {
        return Ulica;
    }

    public void setUlica(String Ulica) {
        this.Ulica = Ulica;
    }

    public String getNrBudynku() {
        return NrBudynku;
    }

    public void setNrBudynku(String NrBudynku) {
        this.NrBudynku = NrBudynku;
    }

    public String getNrLokalu() {
        return NrLokalu;
    }

    public void setNrLokalu(String NrLokalu) {
        this.NrLokalu = NrLokalu;
    }

    public String getMiasto() {
        return Miasto;
    }

    public void setMiasto(String Miasto) {
        this.Miasto = Miasto;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        System.out.print("Nazwa sprzedawcy w klasie GoodData" +getNazwaSprzedawcy());
        this.NIP = NIP;
    }

    public String getKodPocztowy() {
        return KodPocztowy;
    }

    public void setKodPocztowy(String KodPocztowy) {
        this.KodPocztowy = KodPocztowy;
    }

    public String getNumerTelefonu() {
        return NumerTelefonu;
    }

    public void setNumerTelefonu(String NumerTelefonu) {
        this.NumerTelefonu = NumerTelefonu;
    }

    public void SaveObjectOfSprzedawcy(){
        try {
            String save = "src/zapis/ListofSprzedawcy.ser";
            FileOutputStream fs = new FileOutputStream(save);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(SprzedawcaList);
            os.close();
        } catch (Exception ex1) {

            ex1.printStackTrace();

        }
    }


}