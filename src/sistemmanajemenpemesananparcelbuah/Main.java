package sistemmanajemenpemesananparcelbuah;

// ==========================
// IO SEDERHANA
// ==========================
import java.util.Scanner;
import java.util.InputMismatchException;

// ==========================
// CLASS
// ==========================
public class Main {
    
    // ==========================
    // ARRAY
    // ==========================
    private static Parcel[] daftarParcel = new Parcel[50];
    private static int jumlahParcel = 0;
    
    private static Transaksi[] daftarTransaksi = new Transaksi[100];
    private static int jumlahTransaksi = 0;
    
    private static Scanner input = new Scanner(System.in);
    private static String adminAktif = "";

    public static void main(String[] args) {
        // ==========================
        // OBJECT
        // ==========================
        daftarParcel[jumlahParcel++] = new Parcel("P001", "Parcel Standar A", "Reguler", 150000, 20);
        daftarParcel[jumlahParcel++] = new Parcel("P002", "Parcel Standar B", "Reguler", 250000, 15);
        daftarParcel[jumlahParcel++] = new ParcelPremium("P003", "Parcel Exclusive", 500000, 8, "Kartu Ucapan + Keranjang Rotan");
        
        System.out.println("=================================================");
        System.out.println("  SISTEM MANAGEMENT ORDER PARCEL FRUIT V.2026   ");
        System.out.println("=================================================");
        
        loginAdmin();

        int pilihan = 0;
        
        // ==========================
        // PERULANGAN
        // ==========================
        while (pilihan != 8) {
            System.out.println("\n=================================================");
            System.out.println("     SISTEM MANAJEMEN PEMESANAN PARCEL BUAH     ");
            System.out.println("=================================================");
            System.out.println("1. Tambah Parcel");
            System.out.println("2. Lihat Data Parcel");
            System.out.println("3. Edit Parcel");
            System.out.println("4. Hapus Parcel");
            System.out.println("5. Cari Parcel");
            System.out.println("6. Pemesanan Parcel");
            System.out.println("7. Cetak Nota");
            System.out.println("8. Keluar");
            System.out.println("=================================================");
            
            // ==========================
            // ERROR HANDLING
            // ==========================
            try {
                System.out.print("Pilih Menu (1-8): ");
                pilihan = input.nextInt();
                input.nextLine(); // Clear buffer
                
                // ==========================
                // SELEKSI
                // ==========================
                switch (pilihan) {
                    case 1:
                        tambahParcel();
                        break;
                    case 2:
                        lihatDataParcel();
                        break;
                    case 3:
                        editParcel();
                        break;
                    case 4:
                        hapusParcel();
                        break;
                    case 5:
                        cariParcel();
                        break;
                    case 6:
                        prosesPemesanan();
                        break;
                    case 7:
                        cetakNotaTransaksi();
                        break;
                    case 8:
                        System.out.println("\n[!] Keluar dari sistem.");
                        break;
                    default:
                        System.out.println("[X] Pilihan tidak valid!");
                }
            } catch (InputMismatchException e) {
                System.out.println("[X] ERROR: Input harus berupa angka valid!");
                input.nextLine(); // Reset scanner
                pilihan = 0; 
            }
        }
    }

    // ==========================
    // SELEKSI
    // ==========================
    private static void loginAdmin() {
        boolean loginSukses = false;
        System.out.println("\n>>> SILAKAN LOGIN TERLEVIH DAHULU <<<");
        
        while (!loginSukses) {
            System.out.print("Username Admin : ");
            String username = input.nextLine();
            System.out.print("Password Admin : ");
            String password = input.nextLine();

            if (username.equals("admin") && password.equals("pbo1")) {
                adminAktif = "Novi Cahyani Lukman";
                loginSukses = true;
                System.out.println("[+] Login Berhasil! Selamat bekerja, " + adminAktif + ".");
            } else {
                System.out.println("[X] Login Gagal! Coba lagi.\n");
            }
        }
    }

    private static void tambahParcel() {
        System.out.println("\n--- MENU TAMBAH DATA PARCEL ---");
        try {
            System.out.print("Masukkan Kode Parcel (ex: P004) : ");
            String kode = input.nextLine();
            
            for (int i = 0; i < jumlahParcel; i++) {
                if (daftarParcel[i].getKodeParcel().equalsIgnoreCase(kode)) {
                    System.out.println("[X] Gagal! Kode Parcel sudah terpakai.");
                    return;
                }
            }

            System.out.print("Masukkan Nama Parcel            : ");
            String nama = input.nextLine();
            System.out.print("Jenis Parcel (1. Reguler / 2. Premium): ");
            int jenis = input.nextInt();
            input.nextLine(); 

            System.out.print("Masukkan Harga Parcel (Rp)      : ");
            double harga = input.nextDouble();
            System.out.print("Masukkan Stok Awal              : ");
            int stok = input.nextInt();
            input.nextLine(); 

            if (jenis == 2) {
                System.out.print("Fasilitas Tambahan Premium       : ");
                String bonus = input.nextLine();
                daftarParcel[jumlahParcel++] = new ParcelPremium(kode, nama, harga, stok, bonus);
            } else {
                daftarParcel[jumlahParcel++] = new Parcel(kode, nama, "Reguler", harga, stok);
            }
            System.out.println("[+] Sukses! Data parcel baru berhasil ditambahkan.");
        } catch (InputMismatchException e) {
            System.out.println("[X] Gagal menambahkan data. Input tidak valid.");
            input.nextLine();
        }
    }

    private static void lihatDataParcel() {
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("                         DAFTAR DATA PARCEL BUAH                             ");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("| %-11s | %-20s | %-12s | %-12s | %-5s |\n", "KODE PARCEL", "NAMA PARCEL", "JENIS", "HARGA", "STOK");
        System.out.println("-----------------------------------------------------------------------------");
        for (int i = 0; i < jumlahParcel; i++) {
            daftarParcel[i].tampilInfo(); 
        }
        System.out.println("-----------------------------------------------------------------------------");
    }

    private static void editParcel() {
        System.out.println("\n--- MENU EDIT DATA PARCEL ---");
        System.out.print("Masukkan Kode Parcel yang akan diubah: ");
        String kode = input.nextLine();
        
        int indeksKetemu = -1;
        for (int i = 0; i < jumlahParcel; i++) {
            if (daftarParcel[i].getKodeParcel().equalsIgnoreCase(kode)) {
                indeksKetemu = i;
                break;
            }
        }

        if (indeksKetemu == -1) {
            System.out.println("[X] Data tidak ditemukan!");
            return;
        }

        try {
            System.out.print("Nama Baru (Isi jika ingin merubah) : ");
            String namaBaru = input.nextLine();
            if (!namaBaru.trim().isEmpty()) {
                daftarParcel[indeksKetemu].setNamaParcel(namaBaru);
            }

            System.out.print("Harga Baru (0 jika tidak diubah)   : ");
            double hargaBaru = input.nextDouble();
            if (hargaBaru > 0) {
                daftarParcel[indeksKetemu].setHarga(hargaBaru);
            }

            System.out.print("Stok Baru : ");
            int stokBaru = input.nextInt();
            daftarParcel[indeksKetemu].setStok(stokBaru);
            input.nextLine();

            System.out.println("[+] Berhasil! Data parcel telah diperbarui.");
        } catch (InputMismatchException e) {
            System.out.println("[X] Gagal edit data.");
            input.nextLine();
        }
    }

    private static void hapusParcel() {
        System.out.println("\n--- MENU HAPUS DATA PARCEL ---");
        System.out.print("Masukkan Kode Parcel yang akan dihapus: ");
        String kode = input.nextLine();

        int indeksHapus = -1;
        for (int i = 0; i < jumlahParcel; i++) {
            if (daftarParcel[i].getKodeParcel().equalsIgnoreCase(kode)) {
                indeksHapus = i;
                break;
            }
        }

        if (indeksHapus == -1) {
            System.out.println("[X] Data parcel tidak ditemukan!");
            return;
        }

        for (int i = indeksHapus; i < jumlahParcel - 1; i++) {
            daftarParcel[i] = daftarParcel[i + 1];
        }
        daftarParcel[jumlahParcel - 1] = null;
        jumlahParcel--;
        System.out.println("[+] Sukses! Data parcel telah dihapus.");
    }

    private static void cariParcel() {
        System.out.println("\n--- MENU CARI DATA PARCEL ---");
        System.out.print("Masukkan Kata Kunci Nama / Kode Parcel: ");
        String keyword = input.nextLine();

        boolean ditemukan = false;
        for (int i = 0; i < jumlahParcel; i++) {
            if (daftarParcel[i].getNamaParcel().toLowerCase().contains(keyword.toLowerCase()) || 
                daftarParcel[i].getKodeParcel().equalsIgnoreCase(keyword)) {
                daftarParcel[i].tampilInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("[-] Data tidak ditemukan.");
        }
    }

    private static void prosesPemesanan() {
        System.out.println("\n--- MENU PEMESANAN PARCEL (KASIR) ---");
        System.out.print("Masukkan Kode Parcel yang dipesan: ");
        String kode = input.nextLine();

        Parcel parcelDitemukan = null;
        for (int i = 0; i < jumlahParcel; i++) {
            if (daftarParcel[i].getKodeParcel().equalsIgnoreCase(kode)) {
                parcelDitemukan = daftarParcel[i];
                break;
            }
        }

        if (parcelDitemukan == null) {
            System.out.println("[X] Kode Parcel salah!");
            return;
        }

        try {
            System.out.print("Jumlah yang ingin dibeli: ");
            int qty = input.nextInt();
            input.nextLine();

            if (qty <= 0) {
                System.out.println("[X] Pembelian minimal 1!");
                return;
            }

            if (qty > parcelDitemukan.getStok()) {
                System.out.println("[X] Stok tersisa tidak mencukupi (" + parcelDitemukan.getStok() + ").");
            } else {
                parcelDitemukan.setStok(parcelDitemukan.getStok() - qty);
                String trxId = "TRX-" + (jumlahTransaksi + 1001);
                daftarTransaksi[jumlahTransaksi++] = new Transaksi(trxId, parcelDitemukan, qty, adminAktif);
                System.out.println("[+] Sukses! ID Nota Anda: " + trxId);
            }
        } catch (InputMismatchException e) {
            System.out.println("[X] Gagal memproses pemesanan. Input kuantitas salah.");
            input.nextLine();
        }
    }

    private static void cetakNotaTransaksi() {
        System.out.println("\n--- MENU CETAK HISTORI NOTA ---");
        if (jumlahTransaksi == 0) {
            System.out.println("[-] Belum ada transaksi penjualan.");
            return;
        }

        System.out.print("Masukkan ID Transaksi / Nota (ex: TRX-1001): ");
        String idNota = input.nextLine();

        Transaksi trxTerpilih = null;
        for (int i = 0; i < jumlahTransaksi; i++) {
            if (daftarTransaksi[i].getIdTransaksi().equalsIgnoreCase(idNota)) {
                trxTerpilih = daftarTransaksi[i];
                break;
            }
        }

        if (trxTerpilih == null) {
            System.out.println("[X] Nota Transaksi tidak ditemukan.");
            return;
        }

        System.out.println("\n=================================================");
        System.out.println("               NOTA RESMI PENJUALAN              ");
        System.out.println("=================================================");
        System.out.println("ID Transaksi   : " + trxTerpilih.getIdTransaksi());
        System.out.println("Tanggal/Waktu  : " + trxTerpilih.getTanggal());
        System.out.println("Kasir / Admin  : " + trxTerpilih.getNamaAdmin());
        System.out.println("-------------------------------------------------");
        System.out.println("Nama Barang    : " + trxTerpilih.getParcelTerpilih().getNamaParcel());
        System.out.println("Jenis Parcel   : " + trxTerpilih.getParcelTerpilih().getJenisParcel());
        System.out.println("Harga Satuan   : Rp" + trxTerpilih.getParcelTerpilih().getHarga());
        System.out.println("Jumlah Beli    : " + trxTerpilih.getJumlahBeli() + " Pcs");
        System.out.println("-------------------------------------------------");
        System.out.println("TOTAL BAYAR    : Rp" + trxTerpilih.getTotalBayar());
        System.out.println("=================================================");
    }
}