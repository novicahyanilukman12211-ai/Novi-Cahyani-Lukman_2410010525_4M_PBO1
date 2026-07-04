package sistemmanajemenpemesananparcelbuah;

import java.util.Date;

// ==========================
// CLASS
// ==========================
public class Transaksi {
    
    // ==========================
    // ENCAPSULATION & ATTRIBUTE
    // ==========================
    private String idTransaksi;
    private Parcel parcelTerpilih;
    private int jumlahBeli;
    private double totalBayar;
    private Date tanggal;
    private String namaAdmin;

    // ==========================
    // CONSTRUCTOR
    // ==========================
    public Transaksi(String idTransaksi, Parcel parcelTerpilih, int jumlahBeli, String namaAdmin) {
        this.idTransaksi = idTransaksi;
        this.parcelTerpilih = parcelTerpilih;
        this.jumlahBeli = jumlahBeli;
        this.namaAdmin = namaAdmin;
        this.tanggal = new Date();
        this.totalBayar = hitungTotal();
    }

    private double hitungTotal() {
        return parcelTerpilih.getHarga() * jumlahBeli;
    }

    // ==========================
    // ACCESSOR (GETTER)
    // ==========================
    public String getIdTransaksi() {
        return idTransaksi;
    }

    public Parcel getParcelTerpilih() {
        return parcelTerpilih;
    }

    public int getJumlahBeli() {
        return jumlahBeli;
    }

    public double getTotalBayar() {
        return totalBayar;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public String getNamaAdmin() {
        return namaAdmin;
    }
} 