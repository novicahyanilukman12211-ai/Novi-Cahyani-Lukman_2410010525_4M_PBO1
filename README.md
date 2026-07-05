# Proyek Akhir Pemrograman Berbasis Objek 1

Proyek ini adalah contoh sederhana aplikasi pengolahan data pemesanan parcel buah menggunakan Java sebagai tugas akhir dari mata kuliah pemrograman berbasis objek 1.

## Deskripsi

Aplikasi ini menerima input berupa data parcel dan transaksi dari admin, dan memberikan output berupa informasi detail dari pemesanan tersebut seperti kode, nama, jenis reguler/premium, harga, stok, dan riwayat nota transaksi.
Aplikasi ini mengimplementasikan beberapa konsep penting dalam pemrograman berorientasi objek (OOP) seperti Class, Object, Atribut, Method Constructor, Method Mutator, Method Accessor, Encapsulation, Inheritance, Overloading, Overriding, Seleksi, Perulangan, IO Sederhana, Array, dan Error Handling.

## Penjelasan Kode

Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:

1. **Class** adalah template atau blueprint dari object. Pada kode ini, `Parcel`, `ParcelPremium`, `Transaksi`, dan `Main` adalah contoh dari class.

```bash
public class Parcel {
    private String kodeParcel;
    private String namaParcel;
    private String jenisParcel;
    private double harga;
    private int stok;
}

public class ParcelPremium extends Parcel {
    private String bonusFasilitas;
}

public class Transaksi {
    private String idTransaksi;
    private Parcel parcelTerpilih;
    private int jumlahBeli;
    private double totalBayar;
    private Date tanggal;
    private String namaAdmin;
}

public class Main {
    private static Parcel[] daftarParcel = new Parcel[50];
    private static int jumlahParcel = 0;
    private static Transaksi[] daftarTransaksi = new Transaksi[100];
    private static int jumlahTransaksi = 0;
}
```
2. **Object** adalah instance dari class. Pada kode ini, daftarParcel[jumlahParcel++] = new ParcelPremium(kode, nama, harga, stok, bonus); adalah contoh pembuatan object.

```Bash
daftarParcel[jumlahParcel++] = new ParcelPremium(kode, nama, harga, stok, bonus);
```
3. **Atribut** adalah variabel yang ada dalam class. Pada kode ini, nama dan npm adalah contoh atribut.

```Bash
String kodeParcel;
String namaParcel;
```
4. **Constructor** adalah method yang pertama kali dijalankan pada saat pembuatan object. Pada kode ini, constructor ada di dalam class Parcel and ParcelPremium.

```Bash
public Parcel(String kodeParcel, String namaParcel, String jenisParcel, double harga, int stok) {
    this.kodeParcel = kodeParcel;
    this.namaParcel = namaParcel;
    this.jenisParcel = jenisParcel;
    this.harga = harga;
    this.stok = stok;
}

public ParcelPremium(String kodeParcel, String namaParcel, double harga, int stok, String bonusFasilitas) {
    super(kodeParcel, namaParcel, "Premium", harga, stok);
    this.bonusFasilitas = bonusFasilitas;
}
```
5. **Mutator** atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini, setNamaParcel dan setHarga adalah contoh method mutator.

```Bash
public void setNamaParcel(String namaParcel) {
    this.namaParcel = namaParcel;
}

public void setHarga(double harga) {
    this.harga = harga;
}
```
6. **Accessor** atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, getKodeParcel, getNamaParcel, getJenisParcel, getHarga, dan getStok adalah contoh method accessor.

```Bash
public String getKodeParcel() {
    return kodeParcel;
}

public String getNamaParcel() {
    return namaParcel;
}
```
7. **Encapsulation** adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses melalui method. Pada kode ini, atribut kodeParcel dan namaParcel dienkapsulasi dan hanya bisa diakses melalui method getter dan setter.

```Bash
private String kodeParcel;
private String namaParcel;
```
8. **Inheritance** adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, ParcelPremium mewarisi Parcel dengan sintaks extends.

```Bash
public class ParcelPremium extends Parcel {
    ...
}
```
9. **Polymorphism** adalah konsep di mana sebuah nama dapat digunakan untuk merujuk ke beberapa tipe atau bentuk objek berbeda. Ini memungkinkan metode-metode dengan nama yang sama untuk berperilaku berbeda tergantung pada tipe objek yang mereka manipulasi, polymorphism bisa berbentuk Overloading ataupun Overriding. Pada kode ini, method tampilInfo(String) di Parcel merupakan overloading method tampilInfo dan tampilInfo di ParcelPremium merupakan override dari method tampilInfo di Parcel.  

```Bash
public void tampilInfo(String header) {
    System.out.println(header);
    tampilInfo();
}

@Override
public void tampilInfo() {
    System.out.printf("| %-11s | %-20s | %-12s | Rp%-10.0f | %-5d |\n", 
            getKodeParcel(), getNamaParcel(), getJenisParcel(), getHarga(), getStok());
    System.out.println("> [*] Catatan Premium: Termasuk " + bonusFasilitas);
}
```
10. **Seleksi** adalah statement kontrol yang digunakan untuk membuat keputusan berdasarkan kondisi. Pada kode ini, digunakan seleksi if else dalam method loginAdmin dan seleksi switch dalam method main untuk menu utama.

```Bash
if (username.equals("admin") && password.equals("pbo1")) {
    adminAktif = "Novi Cahyani Lukman";
    loginSukses = true;
    System.out.println("[+] Login Berhasil! Selamat bekerja, " + adminAktif + ".");
} else {
    System.out.println("[X] Login Gagal! Coba lagi.\n");
}

switch (pilihan) {
    case 1:
        tambahParcel();
        break;
    case 2:
        lihatDataParcel();
        break;
    default:
        System.out.println("[X] Pilihan tidak valid!");
}
```
11. **Perulangan** adalah statement kontrol yang digunakan untuk menjalankan blok kode berulang kali. Pada kode ini, digunakan loop for untuk memeriksa duplikasi kode dan menampilkan data, serta loop while untuk proses login dan perulangan menu utama.

```Bash
for (int i = 0; i < jumlahParcel; i++) {
    if (daftarParcel[i].getKodeParcel().equalsIgnoreCase(kode)) {
        System.out.println("[X] Gagal! Kode Parcel sudah terpakai.");
        return;
    }
}
```
12. **Input Output** Sederhana digunakan untuk menerima input dari user dan menampilkan output ke user. Pada kode ini, digunakan class Scanner untuk menerima input dan method System.out.println atau System.out.printf untuk menampilkan output nota dan daftar parcel.

```Bash
Scanner input = new Scanner(System.in);
System.out.print("Masukkan Kode Parcel yang dipesan: ");
String kode = input.nextLine();

System.out.println("\n-----------------------------------------------------------------------------");
System.out.println("                         DAFTAR DATA PARCEL BUAH                             ");
```
13. **Array** adalah struktur data yang digunakan untuk menyimpan beberapa nilai dalam satu variabel. Pada kode ini, private static Parcel[] daftarParcel = new Parcel[50]; dan private static Transaksi[] daftarTransaksi = new Transaksi[100]; adalah contoh penggunaan array.

```Bash
private static Parcel[] daftarParcel = new Parcel[50];
```
14. **Error Handling** digunakan untuk menangani error yang mungkin terjadi saat runtime. Pada kode ini, digunakan try catch untuk menangani InputMismatchException saat terjadi kesalahan input tipe data data angka pada menu, pengisian harga, stok, maupun kuantitas order.

```Bash
try {
    System.out.print("Pilih Menu (1-8): ");
    pilihan = input.nextInt();
    input.nextLine();
} catch (InputMismatchException e) {
    System.out.println("[X] ERROR: Input harus berupa angka valid!");
    input.nextLine();
    pilihan = 0; 
}
```
## Usulan nilai

| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |

## Pembuat

Nama: Novi Cahyani Lukman
NPM: 2410010525
