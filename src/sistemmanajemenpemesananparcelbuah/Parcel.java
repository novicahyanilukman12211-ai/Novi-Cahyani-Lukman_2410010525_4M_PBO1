package sistemmanajemenpemesananparcelbuah;

// ==========================
// CLASS
// ==========================
public class Parcel {
    
    // ==========================
    // ENCAPSULATION & ATTRIBUTE
    // ==========================
    private String kodeParcel;
    private String namaParcel;
    private String jenisParcel;
    private double harga;
    private int stok;

    // ==========================
    // CONSTRUCTOR
    // ==========================
    public Parcel() {
    }

    public Parcel(String kodeParcel, String namaParcel, String jenisParcel, double harga, int stok) {
        this.kodeParcel = kodeParcel;
        this.namaParcel = namaParcel;
        this.jenisParcel = jenisParcel;
        this.harga = harga;
        this.stok = stok;
    }

    // ==========================
    // ACCESSOR (GETTER)
    // ==========================
    public String getKodeParcel() {
        return kodeParcel;
    }

    public String getNamaParcel() {
        return namaParcel;
    }

    public String getJenisParcel() {
        return jenisParcel;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    // ==========================
    // MUTATOR (SETTER)
    // ==========================
    public void setKodeParcel(String kodeParcel) {
        this.kodeParcel = kodeParcel;
    }

    public void setNamaParcel(String namaParcel) {
        this.namaParcel = namaParcel;
    }

    public void setJenisParcel(String jenisParcel) {
        this.jenisParcel = jenisParcel;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    // ==========================
    // POLYMORPHISM
    // ==========================
    public void tampilInfo() {
        System.out.printf("| %-11s | %-20s | %-12s | Rp%-10.0f | %-5d |\n", 
                kodeParcel, namaParcel, jenisParcel, harga, stok);
    }
}