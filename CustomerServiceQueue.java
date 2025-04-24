import java.util.LinkedList;
import java.util.Queue;

public class CustomerServiceQueue {
    public static void main(String[] args) {
        // Membuat queue menggunakan LinkedList dari Java Collections
        Queue<String> customerQueue = new LinkedList<>();
        
        // Menambahkan beberapa pelanggan awal ke dalam antrean
        customerQueue.add("Andi");
        customerQueue.add("Budi");
        customerQueue.add("Siti");
        
        // Menampilkan daftar pelanggan dalam antrean
        System.out.println("Pelanggan dalam antrean:");
        printQueue(customerQueue);
        
        // Melayani pelanggan (menghapus pelanggan pertama dari antrean)
        String servedCustomer = customerQueue.poll(); // poll() mengambil dan menghapus elemen head
        if (servedCustomer != null) {
            System.out.println("\nMelayani pelanggan: " + servedCustomer);
        } else {
            System.out.println("\nAntrean kosong, tidak ada pelanggan untuk dilayani.");
        }
        
        // Menampilkan kembali daftar pelanggan dalam antrean setelah pelayanannya
        System.out.println("\nPelanggan dalam antrean:");
        printQueue(customerQueue);
    }
    
    // Method untuk menampilkan isi antrean
    public static void printQueue(Queue<String> queue) {
        if (queue.isEmpty()) {
            System.out.println("Antrean kosong");
            return;
        }
        
        int i = 1;
        for (String customer : queue) {
            System.out.println(i + ". " + customer);
            i++;
        }
    }
}