import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Inisialisasi linked list mahasiswa
        MahasiswaLinkedList daftar = new MahasiswaLinkedList(); // Scanner untuk input pengguna
        int pilihan;

        // Menu utama untuk program
        do {
            System.out.println("\n=== Menu Manajemen Mahasiswa ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("3. Update Nilai Mahasiswa");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // membersihkan newline

            switch (pilihan) {
                case 1:
                    // Menambahkan mahasiswa baru
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Nilai: ");
                    int nilai = scanner.nextInt();
                    scanner.nextLine();
                    daftar.tambahMahasiswa(nim, nama, nilai);
                    break;

                case 2:
                    // Menghapus mahasiswa berdasarkan NIM
                    System.out.print("Masukkan NIM mahasiswa yang akan dihapus: ");
                    String nimHapus = scanner.nextLine();
                    daftar.hapusMahasiswa(nimHapus);
                    break;

                case 3:
                    // Mengupdate nilai mahasiswa berdasarkan NIM
                    System.out.print("Masukkan NIM mahasiswa yang akan diupdate: ");
                    String nimUpdate = scanner.nextLine();
                    System.out.print("Masukkan nilai baru: ");
                    int nilaiBaru = scanner.nextInt();
                    scanner.nextLine();
                    daftar.updateNilai(nimUpdate, nilaiBaru);
                    break;

                case 4:
                    // Menampilkan daftar mahasiswa
                    daftar.tampilkanMahasiswa();
                    break;

                case 5:
                    // Keluar dari program
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    break;

                default:
                    // Invalid option
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5); // Ulangi sampai pengguna memilih keluar

        scanner.close(); // Menutup scanner
    }
}
