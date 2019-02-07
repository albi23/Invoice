import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * KLASA ODPOWIEDZIALNA ZA GUI WPROWADZANIA DANYCH DO PRODUKTÓW
 *
 */

class ProduktyWindow extends JFrame implements ActionListener {


    private final JTextField Nazwa;
    private final JTextField tCena;
    private final JTextField tJM;
    private final  JTextField tilość;
    private final JButton Zapisz;
    private final JButton Wyjdź;

    private int licznik =0;


    ProduktyWindow(){
        int WidhtComponent = 200;
        int WidhtWindow = 500 ;
        int HigthtWindow = 550 ;
        int x_textfield = 200;
        int x_jleabel = 90;
        int widthjleabel = 100;
        int licznik = 0;

        setTitle("Kontrahent");
        setBounds(300,50,WidhtWindow,HigthtWindow);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel produktPanel = new JPanel();
        produktPanel.setLayout(null);
        produktPanel.setBackground(new Color(92, 9, 7));
        produktPanel.setBounds(300,50,WidhtWindow,HigthtWindow);
        add(produktPanel);

        JLabel produkt = new JLabel("Produkt");
        produkt.setFont( new Font("Arial", Font.BOLD, 25));
        produkt.setBounds(x_textfield,20,WidhtComponent,50);
        produktPanel.add(produkt);

        Nazwa = new JTextField("");
        Nazwa.setFont( new Font("Arial", Font.BOLD, 12));
        Nazwa.setBounds(x_textfield,70,WidhtComponent,30);
        Nazwa.setBackground(new Color(56, 56, 56));
        Nazwa.setForeground(new Color(14, 14, 14));
        produktPanel.add(Nazwa);

        JLabel jNazwa = new JLabel("Nazwa towaru");
        jNazwa.setFont( new Font("Arial", Font.BOLD, 13));
        jNazwa.setBounds(x_jleabel,70,widthjleabel,30);
        jNazwa.setForeground(new Color(14, 14, 14));
        produktPanel.add(jNazwa);

        tCena = new JTextField("");
        tCena.setFont( new Font("Arial", Font.BOLD, 12));
        tCena.setBounds(x_textfield,105,WidhtComponent,30);
        tCena.setBackground(new Color(56, 56, 56));
        tCena.setForeground(new Color(14, 14, 14));
        produktPanel.add(tCena);

        JLabel jCena = new JLabel("Cena(zł):");
        jCena.setFont( new Font("Arial", Font.BOLD, 14));
        jCena.setBounds(x_jleabel,105,widthjleabel,30);
        jCena.setForeground(new Color(14, 14, 14));
        produktPanel.add(jCena);

        tJM = new JTextField("");
        tJM.setFont( new Font("Arial", Font.BOLD, 12));
        tJM.setBounds(x_textfield,140,WidhtComponent,30);
        tJM.setBackground(new Color(56, 56, 56));
        tJM.setForeground(new Color(14, 14, 14));
        tJM.addActionListener(this);
        produktPanel.add(tJM);

        JLabel jJM = new JLabel("JM.");
        jJM.setFont( new Font("Arial", Font.BOLD, 14));
        jJM.setBounds(x_jleabel,140,widthjleabel,30);
        jJM.setForeground(new Color(14, 14, 14));
        produktPanel.add(jJM);

        JLabel jilość = new JLabel("Ilość.");
        jilość.setFont( new Font("Arial", Font.BOLD, 14));
        jilość.setBounds(x_jleabel,175,widthjleabel,30);
        jilość.setForeground(new Color(14, 14, 14));
        produktPanel.add(jilość);

        tilość = new JTextField("");
        tilość.setFont( new Font("Arial", Font.BOLD, 12));
        tilość.setBounds(x_textfield,175,WidhtComponent,30);
        tilość.setBackground(new Color(56, 56, 56));
        tilość.setForeground(new Color(14, 14, 14));
        tilość.addActionListener(this);
        produktPanel.add(tilość);

        Zapisz = new JButton("Zapisz");
        Zapisz.setFont( new Font("Arial", Font.BOLD, 15));
        Zapisz.setBounds(100,200+35,300,30);
        Zapisz.setBackground(new Color(80, 81, 43));
        Zapisz.setForeground(new Color(14, 14, 14));
        Zapisz.addActionListener(this);
        produktPanel.add(Zapisz);

        Wyjdź = new JButton("Wyjdź");
        Wyjdź.setFont( new Font("Arial", Font.BOLD, 15));
        Wyjdź.setBounds(100,235+35,300,30);
        Wyjdź.setBackground(new Color(80, 81, 43));
        Wyjdź.setForeground(new Color(14, 14, 14));
        Wyjdź.addActionListener(this);
        produktPanel.add(Wyjdź);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object Source = e.getSource();

        if(Source == Zapisz){
            String nazwaTowaruLubUsługi = Nazwa.getText();
            String cena = tCena.getText();
            String JM = tJM.getText();
            String ilość = tilość.getText();
            ProduktyDataChecking produktyDataChecking = new ProduktyDataChecking(nazwaTowaruLubUsługi, cena, JM, ilość, licznik);
            licznik = produktyDataChecking.getLicznik();
            if(licznik == 7){
                JOptionPane.showMessageDialog(null, "" +
                        "Dodano  mksymanlą liczbę produktów", "Informacja ", JOptionPane.INFORMATION_MESSAGE);
            }
            Nazwa.setText("");
            tCena.setText("");
            tJM.setText("");
            tilość.setText("");

        }
        if(Source == Wyjdź){
            dispose();
        }

    }
}
