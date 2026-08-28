/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author firma
 */
public class Pakaian extends ProdukThrift implements LayananToko {
    private String ukuran; 

    // Syarat Overloading: Constructor 1 (Bila ukuran diketahui)
    public Pakaian(String idBarang, String namaBarang, double harga, int stok, String ukuran) {
        super(idBarang, namaBarang, harga, stok); // Syarat keyword super()
        this.ukuran = ukuran;
    }

    // Syarat Overloading: Constructor 2 (Bila ukuran tidak diketahui)
    public Pakaian(String idBarang, String namaBarang, double harga, int stok) {
        super(idBarang, namaBarang, harga, stok);
        this.ukuran = "All Size";
    }

    // Syarat Overriding dari Superclass ProdukThrift
    @Override
    public void tampilkanDetail() {
        System.out.println("Kategori: Pakaian | Nama: " + getNamaBarang() + " | Ukuran: " + this.ukuran);
    }

    // Syarat Overriding dari Interface LayananToko
    @Override
    public double hitungDiskon() {
        // Logika: Pakaian diskon 10% jika harga di atas 100 ribu
        if (getHarga() > 100000) {
            return getHarga() * 0.10;
        }
        return 0;
    }
}