import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MahasiswaLinkedList daftar = new MahasiswaLinkedList();
        int pilihan;

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
                    System.out.print("Masukkan NIM mahasiswa yang akan dihapus: ");
                    String nimHapus = scanner.nextLine();
                    daftar.hapusMahasiswa(nimHapus);
                    break;

                case 3:
                    System.out.print("Masukkan NIM mahasiswa yang akan diupdate: ");
                    String nimUpdate = scanner.nextLine();
                    System.out.print("Masukkan nilai baru: ");
                    int nilaiBaru = scanner.nextInt();
                    scanner.nextLine();
                    daftar.updateNilai(nimUpdate, nilaiBaru);
                    break;

                case 4:
                    daftar.tampilkanMahasiswa();
                    break;

                case 5:
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);

        scanner.close();
    }
}
