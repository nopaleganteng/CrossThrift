/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author firma
 */
public class Aksesoris extends ProdukThrift implements LayananToko {
    private String jenisMaterial; 

    public Aksesoris(String idBarang, String namaBarang, double harga, int stok, String jenisMaterial) {
        super(idBarang, namaBarang, harga, stok);
        this.jenisMaterial = jenisMaterial;
    }

    // Syarat Overriding dari Superclass
    @Override
    public void tampilkanDetail() {
        System.out.println("Kategori: Aksesoris | Nama: " + getNamaBarang() + " | Material: " + this.jenisMaterial);
    }

    // Syarat Overriding dari Interface
    @Override
    public double hitungDiskon() {
        // Logika: Aksesoris diskon 5% jika harga di atas 50 ribu
        if (getHarga() > 50000) {
            return getHarga() * 0.05;
        }
        return 0;
    }
}