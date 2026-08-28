/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author firma
 */
public abstract class ProdukThrift {
    // Syarat Enkapsulasi: Atribut disembunyikan (private)
    private String idBarang;
    private String namaBarang;
    private double harga;
    private int stok;

    // Syarat Constructor Superclass
    public ProdukThrift(String idBarang, String namaBarang, double harga, int stok) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter dan Setter untuk mengakses atribut private
    public String getIdBarang() { return idBarang; }
    public String getNamaBarang() { return namaBarang; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }
    
    public void kurangiStok(int jumlah) {
        this.stok -= jumlah;
    }

    // Syarat Polimorfisme: Method yang akan di-Override oleh subclass
    public abstract void tampilkanDetail();
}