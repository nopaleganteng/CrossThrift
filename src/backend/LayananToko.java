/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author firma
 */
public interface LayananToko {
    // 1. Method Abstract (Wajib diisi logikanya oleh subclass)
    double hitungDiskon();

    // 2. Method Default (Sudah ada isinya, bisa langsung dipakai)
    default void cetakStruk() {
        System.out.println("Mencetak struk dari sistem CrossThrift...");
    }

    // 3. Method Static (Bisa dipanggil langsung tanpa bikin objek)
    static String infoToko() {
        return "=== CrossThrift: Kasir & Manajemen Stok ===";
    }
}