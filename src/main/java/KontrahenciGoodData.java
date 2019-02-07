import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class KontrahenciGoodData {

    private String NazwaKontrahenta;
    private String NIP;
    private String Ulica;
    private String NrBudynku;
    private String NrLokalu;
    private String Miasto;
    private String KodPocztowy;
    private String NumerTelefonu;
    private final ArrayList<String> Kontrahencilist = new ArrayList<>();

    public void CreateKontrahenci(){
        String sprzedawcy = NazwaKontrahenta+"$"+NIP+"$"+Ulica+"$"+NrBudynku+"$"+NrLokalu+"$"+Miasto+"$"+KodPocztowy+"$"+NumerTelefonu+"$";
        Kontrahencilist.add(sprzedawcy);
    }

    public String getNazwaKontrahenta() {
        return NazwaKontrahenta;
    }

    public void setNazwaKontrahenta(String NazwaKontrahenta) {
        this.NazwaKontrahenta = NazwaKontrahenta;
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

    public void SaveObjectOfKontrahenci(){
        try {
            String save = "src/zapis/ListofKontrahenci.ser";
            FileOutputStream fs = new FileOutputStream(save);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(Kontrahencilist);
            os.close();
        } catch (Exception ex1) {

            ex1.printStackTrace();

        }
    }


}