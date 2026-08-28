/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author firma
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class KoneksiDB {
    private static Connection koneksi;

    public static Connection getKoneksi() {
        if (koneksi == null) {
            try {
                // Pastikan port 3306 sesuai dengan Laragon lu
                String url = "jdbc:mysql://127.0.0.1:3308/db_thrift";
                String user = "root"; // Default Laragon
                String password = ""; // Default Laragon biasanya kosong
                
                koneksi = DriverManager.getConnection(url, user, password);
                System.out.println("Berhasil Terhubung ke Database db_thrift!");
                
            } catch (SQLException e) {
                System.out.println("Error Koneksi: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Gagal konek ke Database! Pastikan Laragon nyala.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return koneksi;
    }
    public static void main(String[] args) {
        getKoneksi();
    }
}