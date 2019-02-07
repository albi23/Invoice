import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Klasa odpowiedzialna na wygląd okienka startowego
 * Pozwala wybrać opcję dodania: Kontrahenta,sprzedawcę,produkty oraz generowania  Faktury.
 */
class WindowApperance extends JFrame implements ActionListener {

    private final JButton DodajSprzedawcę;
    private final JButton DodajKontrahent;
    private final JButton DodajProdukt;
    private final JButton WystawFakture;

    public WindowApperance() {
        setTitle("Faktura");
        setBounds(300, 100, 400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(34, 29, 21));
        panel.setBounds(300, 100, 400, 400);
        add(panel);

        int YPositionButtons = 100;
        DodajSprzedawcę = new JButton("Dodaj Sprzedawcę");
        DodajSprzedawcę.setBounds(75, YPositionButtons, 250, 40);
        DodajSprzedawcę.addActionListener(this);
        panel.add(DodajSprzedawcę);

        DodajKontrahent = new JButton("Dodaj Kontrahenta");
        DodajKontrahent.setBounds(75, YPositionButtons + 40, 250, 40);
        DodajKontrahent.addActionListener(this);
        panel.add(DodajKontrahent);

        DodajProdukt = new JButton("Dodaj Produkt");
        DodajProdukt.setBounds(75, YPositionButtons + 80, 250, 40);
        DodajProdukt.addActionListener(this);
        panel.add(DodajProdukt);

        WystawFakture = new JButton("Wystaw Fakture");
        WystawFakture.setBounds(75, YPositionButtons + 120, 250, 40);
        WystawFakture.addActionListener(this);
        panel.add(WystawFakture);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object Source = e.getSource();
        if (Source == DodajKontrahent) { KontrahenciWindow kontrahenciWindow = new KontrahenciWindow(); }
        if(Source == DodajSprzedawcę){ SprzedawcaWindow sprzedawcaWindow = new SprzedawcaWindow(); }
        if(Source == DodajProdukt){ ProduktyWindow produktyWindow = new ProduktyWindow(); }
        if(Source == WystawFakture){ WystawFaktureWindow wf = new WystawFaktureWindow(); }

    }
}