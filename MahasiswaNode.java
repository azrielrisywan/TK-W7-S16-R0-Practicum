public class MahasiswaNode {

    // Atribut untuk menyimpan data mahasiswa
    private String nim;
    private String nama;
    private int nilai;

    // Referensi ke node selanjutnya dalam linked list
    MahasiswaNode next;

    // Konstruktor untuk inisialisasi data mahasiswa dan node selanjutnya
    public MahasiswaNode(String nim, String nama, int nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
        this.next = null; // Node selanjutnya diatur ke null pada awalnya
    }

    // Getter dan setter untuk atribut nim
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    // public void setNim(String nim) {
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter dan setter untuk nilai
    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }
}
