import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

class WystawFaktureWindow extends JFrame {

    private final ArrayList<String> produstslist = new ArrayList<>();
    private final ArrayList<String> Sprzedawcylist = new ArrayList<>();
    private final ArrayList<String> Kontrahencilist = new ArrayList<>();
    private final String[] tabKontrahenci = new String[8];
    private final String[] tabSprzedawcy = new String[8];
    private final Object[][] data = new Object[8][8] ;

    private double suma = 0;
    private int licznik;

    public WystawFaktureWindow() {

        int WidhtWindow = 800;
        int HigthtWindow = 650;
        int x_leabelSprzedajacy = 30;
        int x_jleabelKupujacy = 500;

        setTitle("Faktura");
        setBounds(300, 50, WidhtWindow, HigthtWindow);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        wczytajLicznik();
        wczytajProdukty();
        CreateTabeOfProducts();
        wczytajKontrahenci();
        wczytajSprzedawcy();
        FillTableOfSprzedawcy();
        FillTableOfKontrahenci();

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);

        JPanel fakturaPanel = new JPanel();
        fakturaPanel.setLayout(null);
        fakturaPanel.setBackground(new Color(255, 255, 255));
        fakturaPanel.setBounds(300, 50, WidhtWindow, HigthtWindow);
        add(fakturaPanel);

        JLabel lFaktura = new JLabel("Faktura nr 13/11/2018");
        lFaktura.setFont(new Font("Arial", Font.BOLD, 25));
        lFaktura.setBounds(280, 10, 400, 50);
        fakturaPanel.add(lFaktura);

        JLabel lDataWystawienia = new JLabel("Data wystawienia" + "             " +dateFormat.format(currentDate));
        lDataWystawienia.setFont(new Font("Arial", Font.BOLD, 11));
        lDataWystawienia.setBounds(550, 60, 250, 20);
        fakturaPanel.add(lDataWystawienia);

        JLabel lMiejscestawienia = new JLabel("Miejsce wystawienia" + "      " + "Wrocław");
        lMiejscestawienia.setFont(new Font("Arial", Font.BOLD, 11));
        lMiejscestawienia.setBounds(550, 70, 250, 30);
        fakturaPanel.add(lMiejscestawienia);

        JLabel lKrecha = new JLabel("______________________________________________________________________" +
                "_________________________________________________");
        lKrecha.setFont(new Font("Arial", Font.BOLD, 11));
        lKrecha.setBounds(30, 90, 770, 20);
        fakturaPanel.add(lKrecha);

        int widh =200;
        JLabel lSprzedajacy = new JLabel("Srzedawca");
        lSprzedajacy.setFont(new Font("Arial", Font.BOLD, 12));
        lSprzedajacy.setBounds(x_leabelSprzedajacy, 110, widh, 25);
        fakturaPanel.add(lSprzedajacy);

        JLabel lNazwa = new JLabel("" + tabSprzedawcy[0]);
        lNazwa.setFont(new Font("Arial", Font.BOLD, 12));
        lNazwa.setBounds(x_leabelSprzedajacy, 130, widh, 25);
        fakturaPanel.add(lNazwa);

        JLabel jNIP = new JLabel("NIP:                         " + tabSprzedawcy[1]);
        jNIP.setFont(new Font("Arial", Font.BOLD, 12));
        jNIP.setBounds(x_leabelSprzedajacy, 150, widh, 25);
        fakturaPanel.add(jNIP);

        JLabel jUlica = new JLabel("Ulica:                      " + tabSprzedawcy[2]);
        jUlica.setFont(new Font("Arial", Font.BOLD, 12));
        jUlica.setBounds(x_leabelSprzedajacy, 170, widh, 25);
        fakturaPanel.add(jUlica);

        JLabel jNrBudynku = new JLabel("Nr. Budynku:        " + tabSprzedawcy[3]);
        jNrBudynku.setFont(new Font("Arial", Font.BOLD, 12));
        jNrBudynku.setBounds(x_leabelSprzedajacy, 190, widh, 25);
        fakturaPanel.add(jNrBudynku);

        JLabel jNrLokalu = new JLabel("Nr.Lokalu:             " + tabSprzedawcy[4]);
        jNrLokalu.setFont(new Font("Arial", Font.BOLD, 12));
        jNrLokalu.setBounds(x_leabelSprzedajacy, 210, widh, 25);
        fakturaPanel.add(jNrLokalu);

        JLabel jMiasto = new JLabel("Miasto:                   " + tabSprzedawcy[5]);
        jMiasto.setFont(new Font("Arial", Font.BOLD, 12));
        jMiasto.setBounds(x_leabelSprzedajacy, 230, widh, 25);
        fakturaPanel.add(jMiasto);

        JLabel jKodPocztowy = new JLabel("Kod Pocztowy:     " + tabSprzedawcy[6]);
        jKodPocztowy.setFont(new Font("Arial", Font.BOLD, 12));
        jKodPocztowy.setBounds(x_leabelSprzedajacy, 250, widh, 25);
        fakturaPanel.add(jKodPocztowy);

        JLabel jNumerTelefonu = new JLabel("Nr.Tel:                     " + tabSprzedawcy[7]);
        jNumerTelefonu.setFont(new Font("Arial", Font.BOLD, 12));
        jNumerTelefonu.setBounds(x_leabelSprzedajacy, 270, widh, 25);
        fakturaPanel.add(jNumerTelefonu);

        JLabel lKupujacy = new JLabel("Nabywca");
        lKupujacy.setFont(new Font("Arial", Font.BOLD, 12));
        lKupujacy.setBounds(x_jleabelKupujacy, 110, widh, 25);
        fakturaPanel.add(lKupujacy);

        JLabel lNazwa1 = new JLabel("" + tabKontrahenci[0]);
        lNazwa1.setFont(new Font("Arial", Font.BOLD, 12));
        lNazwa1.setBounds(x_jleabelKupujacy, 130, widh, 25);
        fakturaPanel.add(lNazwa1);

        JLabel jNIP1 = new JLabel("NIP:                         " + tabKontrahenci[1]);
        jNIP1.setFont(new Font("Arial", Font.BOLD, 12));
        jNIP1.setBounds(x_jleabelKupujacy, 150, widh, 25);
        fakturaPanel.add(jNIP1);

        JLabel jUlica1 = new JLabel("Ulica:                      " + tabKontrahenci[2]);
        jUlica1.setFont(new Font("Arial", Font.BOLD, 12));
        jUlica1.setBounds(x_jleabelKupujacy, 170, widh, 25);
        fakturaPanel.add(jUlica1);

        JLabel jNrBudynku1 = new JLabel("Nr. Budynku:        " + tabKontrahenci[3]);
        jNrBudynku1.setFont(new Font("Arial", Font.BOLD, 12));
        jNrBudynku1.setBounds(x_jleabelKupujacy, 190, widh, 25);
        fakturaPanel.add(jNrBudynku1);

        JLabel jNrLokalu1 = new JLabel("Nr.Lokalu:             " + tabKontrahenci[4]);
        jNrLokalu1.setFont(new Font("Arial", Font.BOLD, 12));
        jNrLokalu1.setBounds(x_jleabelKupujacy, 210, widh, 25);
        fakturaPanel.add(jNrLokalu1);

        JLabel jMiasto1 = new JLabel("Miasto:                   " + tabKontrahenci[5]);
        jMiasto1.setFont(new Font("Arial", Font.BOLD, 12));
        jMiasto1.setBounds(x_jleabelKupujacy, 230, widh, 25);
        fakturaPanel.add(jMiasto1);

        JLabel jKodPocztowy1 = new JLabel("Kod Pocztowy:     " + tabKontrahenci[6]);
        jKodPocztowy1.setFont(new Font("Arial", Font.BOLD, 12));
        jKodPocztowy1.setBounds(x_jleabelKupujacy, 250, widh, 25);
        fakturaPanel.add(jKodPocztowy1);

        JLabel jNumerTelefonu1 = new JLabel("Nr.Tel:                     " + tabKontrahenci[7]);
        jNumerTelefonu1.setFont(new Font("Arial", Font.BOLD, 12));
        jNumerTelefonu1.setBounds(x_jleabelKupujacy, 270, widh, 25);
        fakturaPanel.add(jNumerTelefonu1);

        String[] columnNames = {"Lp", "Nazwa", "JM", "Cena brutto", "Ilość", "Stawka VAT", "Wartość VAT", "Cena netto"};
        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        table.setPreferredScrollableViewportSize(new Dimension(700, 150));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 320, WidhtWindow, 150);
        table.setBounds(0, 450, WidhtWindow, 150);
        fakturaPanel.add(scrollPane);

        JLabel jRazem     = new JLabel("Razem:           "+suma);
        jRazem.setFont(new Font("Arial", Font.BOLD, 14));
        jRazem.setBounds(x_jleabelKupujacy, 500, widh, 30);
        fakturaPanel.add(jRazem);

        JLabel jDoZaplaty = new JLabel("Do zapłaty:     "+suma);
        jDoZaplaty.setFont(new Font("Arial", Font.BOLD, 14));
        jDoZaplaty.setBounds(x_jleabelKupujacy, 520, widh, 30);
        fakturaPanel.add(jDoZaplaty);

        JLabel FormaZaplaty     = new JLabel("Forma zapłaty:           przelew");
        FormaZaplaty.setFont(new Font("Arial", Font.BOLD, 14));
        FormaZaplaty.setBounds(x_leabelSprzedajacy, 500, 250, 30);
        fakturaPanel.add(FormaZaplaty);


        c.add(Calendar.DATE, 14);
        Date currentDatePlusOne = c.getTime();

        JLabel TerminZaplaty = new JLabel("Termin zapłaty:           "+dateFormat.format(currentDatePlusOne));
        TerminZaplaty.setFont(new Font("Arial", Font.BOLD, 14));
        TerminZaplaty.setBounds(x_leabelSprzedajacy, 520, 270, 30);
        fakturaPanel.add(TerminZaplaty);

        setVisible(true);
    }


    @SuppressWarnings("unchecked")
    private void wczytajProdukty() {
        try {
            for (int i = 0; i <= licznik; i++) {
                String in = "src/zapis/ListofProdukty" + i + ".ser";
                ObjectInputStream os = new ObjectInputStream((new FileInputStream(in)));
                ArrayList<String> a = (ArrayList<String>) os.readObject();
                produstslist.add(a.get(0));
                os.close();
            }

        } catch (Exception e2x) {
            e2x.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void wczytajSprzedawcy() {
        try {
            ObjectInputStream os = new ObjectInputStream((new FileInputStream("src/zapis/ListofSprzedawcy.ser")));
            ArrayList<String> a = (ArrayList<String>) os.readObject();
            Sprzedawcylist.add(a.get(0));
            os.close();

        } catch (Exception e2x) {
            e2x.printStackTrace();
        }
    }

    private void wczytajKontrahenci() {
        try {
            ObjectInputStream os = new ObjectInputStream((new FileInputStream("src/zapis/ListofKontrahenci.ser")));
            @SuppressWarnings("unchecked") ArrayList<String> a = (ArrayList<String>) os.readObject();
            Kontrahencilist.add(a.get(0));
            os.close();

        } catch (Exception e2x) {
            e2x.printStackTrace();
        }
    }

    private void wczytajLicznik() {
        try {
            ObjectInputStream os = new ObjectInputStream((new FileInputStream("src/zapis/Licznik.ser")));
            licznik = (int)os.readObject();
            os.close();
        } catch (Exception e2x) {
            e2x.printStackTrace();
        }
    }

    private void FillTableOfKontrahenci(){
        String kod = Kontrahencilist.get(0);
        tabKontrahenci[0] = cutting(kod);
        kod = cutting2(kod);
        tabKontrahenci[1] = cutting(kod);
        kod = cutting2(kod);
        tabKontrahenci[2] = cutting(kod);
        kod = cutting2(kod);
        tabKontrahenci[3] = cutting(kod);
        kod = cutting2(kod);
        tabKontrahenci[4] = cutting(kod);
        kod = cutting2(kod);
        tabKontrahenci[5] = cutting(kod);
        kod = cutting2(kod);
        tabKontrahenci[6] = cutting(kod);
        kod = cutting2(kod);
        tabKontrahenci[7] = cutting(kod);
    }

    private void FillTableOfSprzedawcy(){
        String kod = Sprzedawcylist.get(0);
        tabSprzedawcy[0] = cutting(kod);
        kod = cutting2(kod);
        tabSprzedawcy[1] = cutting(kod);
        kod = cutting2(kod);
        tabSprzedawcy[2] = cutting(kod);
        kod = cutting2(kod);
        tabSprzedawcy[3] = cutting(kod);
        kod = cutting2(kod);
        tabSprzedawcy[4] = cutting(kod);
        kod = cutting2(kod);
        tabSprzedawcy[5] = cutting(kod);
        kod = cutting2(kod);
        tabSprzedawcy[6] = cutting(kod);
        kod = cutting2(kod);
        tabSprzedawcy[7] = cutting(kod);

    }

    private void CreateTabeOfProducts() {
        String nazwa,cena,jm,ilosc;
        for (int i = 0; i < produstslist.size(); i++) {
            String kod = produstslist.get(i);
            nazwa = cutting(kod);
            kod = cutting2(kod);
            cena = cutting(kod);
            kod = cutting2(kod);
            jm = cutting(kod);
            kod = cutting2(kod);
            ilosc = cutting(kod);

            java.text.DecimalFormat df=new java.text.DecimalFormat();
            df.setMaximumFractionDigits(2);

            data[i][0] = i + 1;
            data[i][1] = nazwa;
            data[i][2] = jm;
            data[i][3] = Double.parseDouble(cena) * Integer.parseInt(ilosc);
            data[i][4] = ilosc;
            data[i][5] = "23%";
            data[i][6] = df.format(Double.parseDouble(cena)* Integer.parseInt(ilosc) * (0.23));
            data[i][7] = df.format(Double.parseDouble(cena) * Integer.parseInt(ilosc) - Double.parseDouble(cena) * Integer.parseInt(ilosc) * (0.23));
            suma = suma +Double.parseDouble(cena)*Integer.parseInt(ilosc);
        }

    }

    private String cutting(String nazwa) {
        int i = 0;
        while (nazwa.charAt(i) != '$') {
            i++;
        }
        return nazwa.substring(0, i);
    }

    private String cutting2(String nazwa) {
        int i = 0;
        while (nazwa.charAt(i) != '$') {
            i++;
        }
        return nazwa.substring(i + 1);
    }
}
