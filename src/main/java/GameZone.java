import java.util.Scanner;

public class GameZone {

    static Scanner input = new Scanner(System.in);

    // Method untuk membaca input angka bulat
    static int inputAngka(String pesan) {
        int angka;

        while (true) {
            System.out.print(pesan);
            String teks = input.nextLine();

            try {
                angka = Integer.parseInt(teks);

                if (angka > 0) {
                    return angka;
                } else {
                    System.out.println(
                        "Input harus berupa bilangan positif!"
                    );
                }

            } catch (NumberFormatException e) {
                System.out.println(
                    "Input tidak valid. Masukkan angka bulat!"
                );
            }
        }
    }

    // Method untuk menampilkan struk transaksi
    static void tampilkanStruk(
            String nama,
            String konsol,
            int durasi,
            int hargaPerJam,
            int biayaSewa,
            int diskon,
            int biayaMinuman,
            int totalBayar) {

        System.out.println("\n====================================");
        System.out.println("           STRUK GAMEZONE");
        System.out.println("====================================");
        System.out.println("Pelanggan       : " + nama);
        System.out.println("Konsol          : " + konsol);
        System.out.println("Durasi          : " + durasi + " jam");
        System.out.println("Harga per Jam   : Rp" + hargaPerJam);
        System.out.println("------------------------------------");
        System.out.println("Biaya Sewa      : Rp" + biayaSewa);
        System.out.println("Diskon (10%)    : Rp" + diskon);
        System.out.println("Minuman         : Rp" + biayaMinuman);
        System.out.println("------------------------------------");
        System.out.println("TOTAL BAYAR     : Rp" + totalBayar);
        System.out.println("====================================");
    }

    public static void main(String[] args) {

        String transaksi;

        do {
            System.out.println("\n====================================");
            System.out.println("          GAMEZONE RENTAL PS");
            System.out.println("====================================");

            // Input nama pelanggan
            System.out.print("Nama Pelanggan : ");
            String nama = input.nextLine().trim();

            while (nama.isEmpty()) {
                System.out.println("Nama tidak boleh kosong!");
                System.out.print("Nama Pelanggan : ");
                nama = input.nextLine().trim();
            }

            // Pilihan konsol
            System.out.println("\nPilihan Konsol:");
            System.out.println("1. PlayStation 4 - Rp8000/jam");
            System.out.println("2. PlayStation 5 - Rp12000/jam");

            int pilihanKonsol;

            while (true) {
                pilihanKonsol = inputAngka("Pilih konsol (1/2): ");

                if (pilihanKonsol == 1 || pilihanKonsol == 2) {
                    break;
                }

                System.out.println(
                    "Pilihan tidak tersedia. Pilih 1 atau 2."
                );
            }

            String konsol;
            int hargaPerJam;

            if (pilihanKonsol == 1) {
                konsol = "PlayStation 4";
                hargaPerJam = 8000;
            } else {
                konsol = "PlayStation 5";
                hargaPerJam = 12000;
            }

            // Input durasi bermain
            int durasi = inputAngka("Lama Bermain (jam): ");

            // Menghitung biaya sewa
            int biayaSewa = hargaPerJam * durasi;

            // Menghitung diskon
            int diskon = 0;

            if (durasi >= 3) {
                diskon = (int) (biayaSewa * 0.10);
            }

            // Menanyakan tambahan minuman
            System.out.print("Tambah Minuman (Y/T): ");
            String pilihanMinuman = input.nextLine().trim();

            while (!pilihanMinuman.equalsIgnoreCase("Y")
                    && !pilihanMinuman.equalsIgnoreCase("T")) {

                System.out.println("Masukkan Y atau T!");
                System.out.print("Tambah Minuman (Y/T): ");
                pilihanMinuman = input.nextLine().trim();
            }

            int biayaMinuman = 0;

            if (pilihanMinuman.equalsIgnoreCase("Y")) {
                biayaMinuman = 5000;
            }

            // Menghitung total pembayaran
            int totalBayar = biayaSewa - diskon + biayaMinuman;

            // Menampilkan struk
            tampilkanStruk(
                nama,
                konsol,
                durasi,
                hargaPerJam,
                biayaSewa,
                diskon,
                biayaMinuman,
                totalBayar
            );

            // Menanyakan transaksi baru
            System.out.print("\nTransaksi Baru (Y/T): ");
            transaksi = input.nextLine().trim();

            while (!transaksi.equalsIgnoreCase("Y")
                    && !transaksi.equalsIgnoreCase("T")) {

                System.out.println("Masukkan Y atau T!");
                System.out.print("Transaksi Baru (Y/T): ");
                transaksi = input.nextLine().trim();
            }

        } while (transaksi.equalsIgnoreCase("Y"));

        System.out.println("\nTerima kasih telah menggunakan GameZone!");

        input.close();
    }
}