public class MahasiswaLinkedList {
    private MahasiswaNode head;

    public void tambahMahasiswa(String nim, String nama, int nilai) {
        long startTime = System.nanoTime();

        MahasiswaNode baru = new MahasiswaNode(nim, nama, nilai);
        if (head == null) {
            head = baru;
        } else {
            MahasiswaNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = baru;
        }

        long endTime = System.nanoTime();
        System.out.println("Waktu tambah: " + (endTime - startTime) + " ns");
    }

    public void hapusMahasiswa(String nim) {
        long startTime = System.nanoTime();

        if (head == null) {
            System.out.println("Daftar kosong.");
            return;
        }

        if (head.getNim().equals(nim)) {
            head = head.next;
        } else {
            MahasiswaNode current = head;
            while (current.next != null && !current.next.getNim().equals(nim)) {
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next;
            } else {
                System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
            }
        }

        long endTime = System.nanoTime();
        System.out.println("Waktu hapus: " + (endTime - startTime) + " ns");
    }

    public void updateNilai(String nim, int nilaiBaru) {
        long startTime = System.nanoTime();

        MahasiswaNode current = head;
        while (current != null) {
            if (current.getNim().equals(nim)) {
                current.setNilai(nilaiBaru);
                System.out.println("Nilai berhasil diupdate.");
                break;
            }
            current = current.next;
        }

        if (current == null) {
            System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
        }

        long endTime = System.nanoTime();
        System.out.println("Waktu update: " + (endTime - startTime) + " ns");
    }

    public void tampilkanMahasiswa() {
        System.out.println("Daftar Mahasiswa:");
        MahasiswaNode current = head;
        int i = 1;
        while (current != null) {
            System.out.println(i++ + ". NIM: " + current.getNim() + ", Nama: " + current.getNama() + ", Nilai: "
                    + current.getNilai());
            current = current.next;
        }

        if (head == null) {
            System.out.println("(Kosong)");
        }
    }
}
