/**
 *
 * @author Bhatito
 */
import java.util.Scanner;
import java.util.ArrayList;

class Tiket {
    private String username;
    private String password;
    private boolean isLoggedIn;
    
    public Tiket(String username, String password) {
        this.username = username;
        this.password = password;
        this.isLoggedIn = false;
    }
    
    public boolean login(String inputUsername, String inputPassword) {
        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            isLoggedIn = true;
            return true;
        }
        return false;
    }
     
    public boolean isLoggedIn() {
        return isLoggedIn;
    }
}

public class tugas3 {
    private static ArrayList<String> namaHotelList = new ArrayList<>();
    private static ArrayList<Integer> jmlKamarList = new ArrayList<>();
    private static ArrayList<Integer> hrgperKamarList = new ArrayList<>();
    private static ArrayList<String> pesawatList = new ArrayList<>();
    private static ArrayList<Integer> penumpangList = new ArrayList<>();
    private static ArrayList<Integer> tiketPesawatList = new ArrayList<>();
    private static ArrayList<String> tujuanList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tiket tiket = new Tiket("username", "password"); // Ganti username dan password sesuai kebutuhan

        System.out.println("Selamat datang di program transaksi tiket pesawat dan hotel.");
        System.out.print("Masukkan username: ");
        String inputUsername = scanner.next();
        System.out.print("Masukkan password: ");
        String inputPassword = scanner.next();
        
        if (tiket.login(inputUsername, inputPassword)) {
            System.out.println("Login berhasil!");
            int choice = 0;
            while (choice != 3) {
                System.out.println("-----MENU TIKET-----");
                System.out.println("1. Input Data Transaksi");
                System.out.println("2. Lihat Data Tiket");
                System.out.println("3. Keluar");
                System.out.print("Pilih menu (1-3): ");
                choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        inputTransaksi();
                        break;
                    case 2:
                        lihatDataTiket();
                        break;
                    case 3:
                        System.out.println("Terima kasih telah menggunakan program ini. Sampai jumpa!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih menu yang benar.");
                }
            }
        } else {
            System.out.println("Login gagal. Coba lagi.");
        }
    }
    
    private static void inputTransaksi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Data Transaksi");
        System.out.print("Nama Hotel: ");
        String namaHotel = scanner.next();
        System.out.print("Jumlah Kamar: ");
        int jmlKamar = scanner.nextInt();
        System.out.print("Harga Per Kamar: ");
        int hrgperKamar = scanner.nextInt();
        System.out.print("Nama Pesawat: ");
        String pesawat = scanner.next();
        System.out.print("Jumlah Penumpang: ");
        int penumpang = scanner.nextInt();
        System.out.print("Harga Tiket Pesawat: ");
        int tiketPesawat = scanner.nextInt();
        System.out.print("Tujuan: ");
        String tujuan = scanner.next();
        
        // Simpan data transaksi ke dalam ArrayList
        namaHotelList.add(namaHotel);
        jmlKamarList.add(jmlKamar);
        hrgperKamarList.add(hrgperKamar);
        pesawatList.add(pesawat);
        penumpangList.add(penumpang);
        tiketPesawatList.add(tiketPesawat);
        tujuanList.add(tujuan);
    }
    
    private static void lihatDataTiket() {
       System.out.println("Data Transaksi Tiket Pesawat Dan Hotel");
    System.out.println("------------------------------------------------");
    System.out.println("No  | Nama Hotel   | Jumlah Kamar | Harga Per Kamar | Nama Pesawat | Jumlah Penumpang | Harga Tiket Pesawat | Tujuan");
    System.out.println("------------------------------------------------");

    for (int i = 0; i < namaHotelList.size(); i++) {
        String namaHotel = namaHotelList.get(i);
        int jmlKamar = jmlKamarList.get(i);
        int hrgperKamar = hrgperKamarList.get(i);
        String pesawat = pesawatList.get(i);
        int penumpang = penumpangList.get(i);
        int tiketPesawat = tiketPesawatList.get(i);
        String tujuan = tujuanList.get(i);
        int diskon;
           diskon = (int) (0.45* hrgperKamar);
           int hargatiket;
           hargatiket = (int) (tiketPesawat * penumpang );
           int total;
           total = (int) (hargatiket+(penumpang*29000));

        System.out.printf("%-3d | %-12s | %-13d | %-16d | %-12s | %-16d | %-19d | %-12s%n", i + 1, namaHotel, jmlKamar, hrgperKamar, pesawat, penumpang, tiketPesawat, tujuan);
        System.out.println("------------------------------------------------");
        System.out.println("Transaksi Tiket Pesawat Dan Hotel");
        System.out.println("Tujuan :" + tujuan);
        System.out.println("Nama Hotel" +" "+ namaHotel +" "+ "-Jumlah Kamar"+" "+ jmlKamar + " "+"-Harga Per Kamar" +" "+hrgperKamar);
        System.out.println("Total Biaya Kamar Hotel Dengan Diskon 45%:" + " "+(hrgperKamar- diskon)*jmlKamar );
        System.out.println("Nama Pesawat"+" "+pesawat +" "+ "-Jumlah Penumpang"+ " "+penumpang + " "+ "-Harga Tiket Pesawat" +" "+tiketPesawat);
        System.out.println("Total Harga Tiket Pesawat:" +" "+ total +" "+ "Dengan Biaya Asuransi" +" "+ "29000/penumpang");
    }
}
}



