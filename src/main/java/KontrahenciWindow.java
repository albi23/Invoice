import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * KLASA ODPOWIEDZIALNA ZA GUI WPROWADZANIA DANYCH DO KONTRAHENTÓW
 *
 */

class KontrahenciWindow extends JFrame implements ActionListener {

    private final JTextField Nazwa;
    private final JTextField tNIP;
    private final JTextField tUlica;
    private final JTextField tNrBudynku;
    private final JTextField tNrLokalu;
    private final JTextField tMiasto;
    private final JTextField tKodPocztowy;
    private final JTextField tNumerTelefonu;
    private final JButton Zapisz;
    private final JButton Wyjdź;

    KontrahenciWindow(){
        int WidhtComponent = 200;
        int WidhtWindow = 500 ;
        int HigthtWindow = 550 ;
        int x_textfield = 200;
        int x_jleabel = 95;
        int widthjleabel = 100;

        setTitle("Kontrahent");
        setBounds(300,50,WidhtWindow,HigthtWindow);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel kontrahentPanel = new JPanel();
        kontrahentPanel.setLayout(null);
        kontrahentPanel.setBackground(new Color(92, 9, 7));
        kontrahentPanel.setBounds(300,50,WidhtWindow,HigthtWindow);
        add(kontrahentPanel);

        JLabel kontrahent = new JLabel("Kontrahent");
        kontrahent.setFont( new Font("Arial", Font.BOLD, 25));
        kontrahent.setBounds(x_textfield,20,WidhtComponent,50);
        kontrahentPanel.add(kontrahent);

        Nazwa = new JTextField("");
        Nazwa.setFont( new Font("Arial", Font.BOLD, 12));
        Nazwa.setBounds(x_textfield,70,WidhtComponent,30);
        Nazwa.setBackground(new Color(56, 56, 56));
        Nazwa.setForeground(new Color(14, 14, 14));
        kontrahentPanel.add(Nazwa);

        JLabel jNazwa = new JLabel("Nazwa");
        jNazwa.setFont( new Font("Arial", Font.BOLD, 14));
        jNazwa.setBounds(x_jleabel,70,widthjleabel,30);
        jNazwa.setForeground(new Color(14, 14, 14));
        kontrahentPanel.add(jNazwa);

        tNIP = new JTextField("");
        tNIP.setFont( new Font("Arial", Font.BOLD, 12));
        tNIP.setBounds(x_textfield,105,WidhtComponent,30);
        tNIP.setBackground(new Color(56, 56, 56));
        tNIP.setForeground(new Color(14, 14, 14));
        kontrahentPanel.add(tNIP);

        JLabel jNIP = new JLabel("NIP");
        jNIP.setFont( new Font("Arial", Font.BOLD, 14));
        jNIP.setBounds(x_jleabel,105,widthjleabel,30);
        jNIP.setForeground(new Color(14, 14, 14));
        kontrahentPanel.add(jNIP);

        tUlica = new JTextField("");
        tUlica.setFont( new Font("Arial", Font.BOLD, 12));
        tUlica.setBounds(x_textfield,140,WidhtComponent,30);
        tUlica.setBackground(new Color(56, 56, 56));
        tUlica.setForeground(new Color(14, 14, 14));
        tUlica.addActionListener(this);
        kontrahentPanel.add(tUlica);

        JLabel jUlica = new JLabel("Ulica");
        jUlica.setFont( new Font("Arial", Font.BOLD, 14));
        jUlica.setBounds(x_jleabel,140,widthjleabel,30);
        jUlica.setForeground(new Color(14, 14, 14));
        kontrahentPanel.add(jUlica);

        tNrBudynku = new JTextField("");
        tNrBudynku.setFont( new Font("Arial", Font.BOLD, 12));
        tNrBudynku.setBounds(x_textfield,175,WidhtComponent,30);
        tNrBudynku.setBackground(new Color(56, 56, 56));
        tNrBudynku.setForeground(new Color(14, 14, 14));
        kontrahentPanel.add(tNrBudynku);

        JLabel jNrBudynku = new JLabel("Nr. Budynku");
        jNrBudynku.setFont( new Font("Arial", Font.BOLD, 14));
        jNrBudynku.setBounds(x_jleabel,175,widthjleabel,30);
        jNrBudynku.setForeground(new Color(14, 14, 14));
        kontrahentPanel.add(jNrBudynku);

        tNrLokalu = new JTextField("");
        tNrLokalu.setFont( new Font("Arial", Font.BOLD, 12));
        tNrLokalu.setBounds(x_textfield,210,WidhtComponent,30);
        tNrLokalu.setBackground(new Color(56, 56, 56));
        tNrLokalu.setForeground(new Color(14, 14, 14));
        kontrahentPanel.add(tNrLokalu);

        JLabel jNrLokalu = new JLabel("Nr. Lokalu");
        jNrLokalu.setFont( new Font("Arial", Font.BOLD, 14));
        jNrLokalu.setBounds(x_jleabel,210,widthjleabel,30);
        jNrLokalu.setForeground(new Color(14, 14, 14));
        kontrahentPanel.add(jNrLokalu);

        tMiasto = new JTextField("");
        tMiasto.setFont( new Font("Arial", Font.BOLD, 12));
        tMiasto.setBounds(x_textfield,245,WidhtComponent,30);
        tMiasto.setBackground(new Color(56, 56, 56));
        tMiasto.setForeground(new Color(14, 14, 14));
        kontrahentPanel.add(tMiasto);

        JLabel jMiasto = new JLabel("Miasto");
        jMiasto.setFont( new Font("Arial", Font.BOLD, 14));
        jMiasto.setBounds(x_jleabel,245,widthjleabel,30);
        jMiasto.setForeground(new Color(14, 14, 14));
        kontrahentPanel.add(jMiasto);

        tKodPocztowy = new JTextField("");
        tKodPocztowy.setFont( new Font("Arial", Font.BOLD, 12));
        tKodPocztowy.setBounds(x_textfield,280,WidhtComponent,30);
        tKodPocztowy.setBackground(new Color(56, 56, 56));
        tKodPocztowy.setForeground(new Color(14, 14, 14));
        kontrahentPanel.add(tKodPocztowy);

        JLabel jKodPocztowy = new JLabel("Kod Pocztowy");
        jKodPocztowy.setFont( new Font("Arial", Font.BOLD, 14));
        jKodPocztowy.setBounds(x_jleabel,280,widthjleabel,30);
        jKodPocztowy.setForeground(new Color(14, 14, 14));
        kontrahentPanel.add(jKodPocztowy);

        tNumerTelefonu = new JTextField("");
        tNumerTelefonu.setFont( new Font("Arial", Font.BOLD, 12));
        tNumerTelefonu.setBounds(x_textfield,315,WidhtComponent,30);
        tNumerTelefonu.setBackground(new Color(56, 56, 56));
        tNumerTelefonu.setForeground(new Color(14, 14, 14));
        kontrahentPanel.add(tNumerTelefonu);

        JLabel jNumerTelefonu = new JLabel("Nr. Telefonu");
        jNumerTelefonu.setFont( new Font("Arial", Font.BOLD, 14));
        jNumerTelefonu.setBounds(x_jleabel,315,widthjleabel,30);
        jNumerTelefonu.setForeground(new Color(14, 14, 14));
        kontrahentPanel.add(jNumerTelefonu);

        Zapisz = new JButton("Zapisz");
        Zapisz.setFont( new Font("Arial", Font.BOLD, 15));
        Zapisz.setBounds(100,370,300,30);
        Zapisz.setBackground(new Color(80, 81, 43));
        Zapisz.setForeground(new Color(14, 14, 14));
        Zapisz.addActionListener(this);
        kontrahentPanel.add(Zapisz);

        Wyjdź = new JButton("Wyjdź");
        Wyjdź.setFont( new Font("Arial", Font.BOLD, 15));
        Wyjdź.setBounds(100,405,300,30);
        Wyjdź.setBackground(new Color(80, 81, 43));
        Wyjdź.setForeground(new Color(14, 14, 14));
        Wyjdź.addActionListener(this);
        kontrahentPanel.add(Wyjdź);

        setVisible(true);
    }

  //  @Override
    public void actionPerformed(ActionEvent e) {
        Object Source = e.getSource();

        if(Source == Zapisz){
            System.out.print("Zapisz");
            String nazwaKontrahenta = Nazwa.getText();
            String NIP = tNIP.getText();
            String ulica = tUlica.getText();
            String nrBudynku = tNrBudynku.getText();
            String nrLokalu = tNrLokalu.getText();
            String miasto = tMiasto.getText();
            String kodPocztowy = tKodPocztowy.getText();
            String numerTelefonu = tNumerTelefonu.getText();
            DataChecking kd = new DataChecking(nazwaKontrahenta, NIP, ulica, nrBudynku, nrLokalu, miasto, kodPocztowy, numerTelefonu,0);
            Nazwa.setText("");
            tNIP.setText("");
            tUlica.setText("");
            tNrBudynku.setText("");
            tNrLokalu.setText("");
            tMiasto.setText("");
            tKodPocztowy.setText("");
            tNumerTelefonu.setText("");
        }
        if(Source == Wyjdź){
            dispose();
        }

    }
}
