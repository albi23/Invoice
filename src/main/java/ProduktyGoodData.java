import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/**
 * KLASA PRZECHOWUJĄCA POPRAWNE/SPRAWDZONE DANE Z OKIENKA PRODUKTY
 */
class ProduktyGoodData {

    private String NazwaTowaruLubUslugi;
    private String Cena;
    private String JM;
    private String ilość;
    private int indexofarray;
    private final ArrayList<String> ListofProdukty = new ArrayList<>();
    private int licznik;

    public void addProduct(){
        String products = getNazwaTowaruLubUslugi()+"$"+Cena+"$"+JM+"$"+ilość+"$";
        ListofProdukty.add(getindexofarray(),products);
        SaveObjectOfProduct();
        SaveLicznik();
    }
    public ArrayList getListOfrodukty(){
        return ListofProdukty;
        }
    private String getNazwaTowaruLubUslugi() {
        return NazwaTowaruLubUslugi;
    }

    public void setNazwaTowaruLubUslugi(String setNazwaTowaruLubUsługi) {
        this.NazwaTowaruLubUslugi = setNazwaTowaruLubUsługi;
    }

    public String getCena() {
        return Cena;
    }

    public void setCena(String Cena) {
        this.Cena = Cena;
    }

    public String getIlość() {
        return ilość;
    }

    public void setIlość(String ilość) {
        this.ilość = ilość;
    }

    public String getJM() {
        return JM;
    }

    public void setJM(String JM) {
        this.JM = JM;
    }

    public void setindexofarray(int indexofarray){
        this.indexofarray = indexofarray;
    }

    private int getindexofarray(){
        return indexofarray;
    }

    public void setlicznik(int licznik){
        this.licznik = licznik;
    }

    private int getLicznik(){
        return licznik;
    }

    private void SaveObjectOfProduct(){
        try {
            String save = "src/zapis/ListofProdukty"+getLicznik()+".ser";
            FileOutputStream fs = new FileOutputStream(save);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(ListofProdukty);
            os.close();
        } catch (Exception ex1) {
                    ex1.printStackTrace();

        }
    }

    private void SaveLicznik(){
        try {
            String save = "src/zapis/Licznik.ser";
            FileOutputStream fs = new FileOutputStream(save);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(licznik);
            os.close();
        } catch (Exception ex1) {
            ex1.printStackTrace();

        }
    }


}

