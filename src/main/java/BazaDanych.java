
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BazaDanych implements Database {
    public static String DRIVER = "org.sqlite.JDBC";
    public static String DB_URL = "jdbc:sqlite:biblioteka.db";
    private Connection conn;
    private Statement stat;

    public BazaDanych() {

        try {
            Class.forName(BazaDanych.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }
        createTablesOfKontrahenci();
        createTablesOfProdukty();
        createTablesOfSprzedawcy();
    }


    @Override
    public boolean createTablesOfProdukty() {
        String createKontrahenci = "CREATE TABLE IF NOT EXISTS kontrahenci (kontrahenta INTEGER PRIMARY KEY AUTOINCREMENT,nazwa varchar(30),NIP INTEAGER, ulica varchar(30), " +
                "NrBudynku varchar(30),NrLokalu varchar(30),Miasto varchar(30), KodPocztowy varchar(30),NrTelefonuvarchar(30) ";
        try {
            stat.execute(createKontrahenci);
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean createTablesOfKontrahenci() {
        String createSprzedawcy = "CREATE TABLE IF NOT EXISTS sprzedawcy (sprzedawca INTEGER PRIMARY KEY AUTOINCREMENT,nazwa varchar(30),NIP INTEAGER, ulica varchar(30), " +
                "NrBudynku varchar(30),NrLokalu varchar(30),Miasto varchar(30), KodPocztowy varchar(30),NrTelefonu varchar(30) ";
        String createProdukty = "CREATE TABLE IF NOT EXISTS produkty (id_produktu INTEGER PRIMARY KEY AUTOINCREMENT,nazwa varchar(30), cena varchar(30), jm varchar(5), ilość varchar(5) ";
        try {
            stat.execute(createSprzedawcy);
            stat.execute(createProdukty);
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean createTablesOfSprzedawcy() {
        String createSprzedawcy = "CREATE TABLE IF NOT EXISTS sprzedawcy (sprzedawca INTEGER PRIMARY KEY AUTOINCREMENT,nazwa varchar(30),NIP INTEAGER, ulica varchar(30), " +
                "NrBudynku varchar(30),NrLokalu varchar(30),Miasto varchar(30), KodPocztowy varchar(30),NrTelefonu varchar(30) ";
        try {
            stat.execute(createSprzedawcy);
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    @Override
    public void getKontrahent() {
    }

    @Override
    public void getSprzedawca() {

    }

    @Override
    public void getProdukt() {

    }
}