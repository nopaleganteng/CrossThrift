/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author firma
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class BarangDAO {
    private Connection conn;

    public BarangDAO() {
        // Manggil koneksi yang udah lu bikin di file KoneksiDB
        conn = KoneksiDB.getKoneksi();
    }

    // 1. CREATE (Menyimpan Data ke Database)
    public void tambahBarang(ProdukThrift barang) {
        String sql = "INSERT INTO produk_thrift (id_barang, nama_barang, kategori_utama, sub_kategori, harga, stok) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, barang.getIdBarang());
            pst.setString(2, barang.getNamaBarang());
            pst.setDouble(5, barang.getHarga());
            pst.setInt(6, barang.getStok());

            // Nah, ini poin bonus lu! Menggunakan instanceof untuk nentuin kategori_utama
            if (barang instanceof Pakaian) {
                pst.setString(3, "Pakaian");
                pst.setString(4, "Pakaian/Baju"); // Bisa dibikin dinamis nanti
            } else if (barang instanceof Aksesoris) {
                pst.setString(3, "Aksesoris");
                pst.setString(4, "Tas/Perhiasan");
            } else {
                pst.setString(3, "Lainnya");
                pst.setString(4, "Lainnya");
            }

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Barang Berhasil Disimpan!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // 2. READ (Mengambil Data untuk ditampilin ke Tabel Nopal)
    // Return berupa ResultSet biar gampang di-convert Ilham ke JTable
    public ResultSet ambilSemuaBarang() {
        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM produk_thrift");
        } catch (SQLException e) {
            System.out.println("Gagal ambil data: " + e.getMessage());
        }
        return rs;
    }

    // 3. UPDATE (Mengubah Data)
    public void updateBarang(ProdukThrift barang) {
        String sql = "UPDATE produk_thrift SET nama_barang=?, harga=?, stok=? WHERE id_barang=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, barang.getNamaBarang());
            pst.setDouble(2, barang.getHarga());
            pst.setInt(3, barang.getStok());
            pst.setString(4, barang.getIdBarang());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Barang Berhasil Diupdate!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal update data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // 4. DELETE (Menghapus Data)
    public void hapusBarang(String idBarang) {
        String sql = "DELETE FROM produk_thrift WHERE id_barang=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, idBarang);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Barang Berhasil Dihapus!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal hapus data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}