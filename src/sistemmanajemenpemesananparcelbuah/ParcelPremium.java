package sistemmanajemenpemesananparcelbuah;

// ==========================
// INHERITANCE
// ==========================
public class ParcelPremium extends Parcel {
    
    // ==========================
    // ENCAPSULATION & ATTRIBUTE
    // ==========================
    private String bonusFasilitas;

    // ==========================
    // CONSTRUCTOR
    // ==========================
    public ParcelPremium(String kodeParcel, String namaParcel, double harga, int stok, String bonusFasilitas) {
        super(kodeParcel, namaParcel, "Premium", harga, stok);
        this.bonusFasilitas = bonusFasilitas;
    }

    // ==========================
    // ACCESSOR (GETTER)
    // ==========================
    public String getBonusFasilitas() {
        return bonusFasilitas;
    }

    // ==========================
    // MUTATOR (SETTER)
    // ==========================
    public void setBonusFasilitas(String bonusFasilitas) {
        this.bonusFasilitas = bonusFasilitas;
    }

    // ==========================
    // POLYMORPHISM
    // ==========================
    @Override
    public void tampilInfo() {
        System.out.printf("| %-11s | %-20s | %-12s | Rp%-10.0f | %-5d |\n", 
                getKodeParcel(), getNamaParcel(), getJenisParcel(), getHarga(), getStok());
        System.out.println("> [*] Catatan Premium: Termasuk " + bonusFasilitas);
    }
}