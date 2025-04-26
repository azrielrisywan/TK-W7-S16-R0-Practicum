import java.util.*;
import java.util.concurrent.TimeUnit;

// Class Mahasiswa untuk menyimpan data mahasiswa
class Mahasiswa {
    private String nim;
    private String nama;

    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    @Override
    public String toString() {
        return "Mahasiswa{nim='" + nim + "', nama='" + nama + "'}";
    }
}

// Class Node untuk implementasi manual LinkedList
class Node {
    private Mahasiswa data;
    private Node next;

    public Node(Mahasiswa data) {
        this.data = data;
        this.next = null;
    }

    public Mahasiswa getData() {
        return data;
    }

    public void setData(Mahasiswa data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

// Class CustomLinkedList untuk implementasi manual, mengimplementasikan Iterable
class CustomLinkedList implements Iterable<Mahasiswa> {
    private Node head;
    private Node tail;

    public CustomLinkedList() {
        head = null;
        tail = null;
    }

    public void add(Mahasiswa mahasiswa) {
        Node newNode = new Node(mahasiswa);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    public Mahasiswa removeFirst() {
        if (head == null) {
            return null;
        }
        Mahasiswa data = head.getData();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<Mahasiswa> iterator() {
        return new Iterator<Mahasiswa>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Mahasiswa next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Mahasiswa data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }
}

// Class untuk mengukur performa Stack
class StackPerformance {
    private Stack<Mahasiswa> stack;
    private int numItems;

    public StackPerformance(int numItems) {
        this.stack = new Stack<>();
        this.numItems = numItems;
    }

    public void measureAddPerformance() {
        long startTime = System.nanoTime();
        for (int i = 0; i < numItems; i++) {
            stack.push(new Mahasiswa("S" + i, "Mahasiswa" + i));
        }
        long endTime = System.nanoTime();
        System.out.println("Add " + numItems + " items: " +
                TimeUnit.NANOSECONDS.toMicros(endTime - startTime) + " microseconds");
    }

    public void measureProcessPerformance() {
        long startTime = System.nanoTime();
        while (!stack.isEmpty()) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        System.out.println("Process " + numItems + " items: " +
                TimeUnit.NANOSECONDS.toMicros(endTime - startTime) + " microseconds");
    }

    public void measureSearchPerformance(String searchNim) {
        // Repopulate for search
        for (int i = 0; i < numItems; i++) {
            stack.push(new Mahasiswa("S" + i, "Mahasiswa" + i));
        }
        long startTime = System.nanoTime();
        for (Mahasiswa m : stack) {
            if (m.getNim().equals(searchNim)) {
                break;
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Stack search: " +
                TimeUnit.NANOSECONDS.toMicros(endTime - startTime) + " microseconds");
    }
}

// Class untuk mengukur performa Queue
class QueuePerformance {
    private Queue<Mahasiswa> queue;
    private int numItems;

    public QueuePerformance(int numItems) {
        this.queue = new LinkedList<>(); // Menggunakan LinkedList untuk Queue
        this.numItems = numItems;
    }

    public void measureAddPerformance() {
        long startTime = System.nanoTime();
        for (int i = 0; i < numItems; i++) {
            queue.offer(new Mahasiswa("Q" + i, "Mahasiswa" + i));
        }
        long endTime = System.nanoTime();
        System.out.println("Add " + numItems + " items: " +
                TimeUnit.NANOSECONDS.toMicros(endTime - startTime) + " microseconds");
    }

    public void measureProcessPerformance() {
        long startTime = System.nanoTime();
        while (!queue.isEmpty()) {
            queue.poll();
        }
        long endTime = System.nanoTime();
        System.out.println("Process " + numItems + " items: " +
                TimeUnit.NANOSECONDS.toMicros(endTime - startTime) + " microseconds");
    }

    public void measureSearchPerformance(String searchNim) {
        // Repopulate for search
        for (int i = 0; i < numItems; i++) {
            queue.offer(new Mahasiswa("Q" + i, "Mahasiswa" + i));
        }
        long startTime = System.nanoTime();
        for (Mahasiswa m : queue) {
            if (m.getNim().equals(searchNim)) {
                break;
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Queue search: " +
                TimeUnit.NANOSECONDS.toMicros(endTime - startTime) + " microseconds");
    }
}

// Class untuk mengukur performa CustomLinkedList
class CustomLinkedListPerformance {
    private CustomLinkedList linkedList;
    private int numItems;

    public CustomLinkedListPerformance(int numItems) {
        this.linkedList = new CustomLinkedList();
        this.numItems = numItems;
    }

    public void measureAddPerformance() {
        long startTime = System.nanoTime();
        for (int i = 0; i < numItems; i++) {
            linkedList.add(new Mahasiswa("L" + i, "Mahasiswa" + i));
        }
        long endTime = System.nanoTime();
        System.out.println("Add " + numItems + " items: " +
                TimeUnit.NANOSECONDS.toMicros(endTime - startTime) + " microseconds");
    }

    public void measureProcessPerformance() {
        long startTime = System.nanoTime();
        while (!linkedList.isEmpty()) {
            linkedList.removeFirst();
        }
        long endTime = System.nanoTime();
        System.out.println("Process " + numItems + " items: " +
                TimeUnit.NANOSECONDS.toMicros(endTime - startTime) + " microseconds");
    }

    public void measureSearchPerformance(String searchNim) {
        // Repopulate for search
        for (int i = 0; i < numItems; i++) {
            linkedList.add(new Mahasiswa("L" + i, "Mahasiswa" + i));
        }
        long startTime = System.nanoTime();
        for (Mahasiswa m : linkedList) {
            if (m.getNim().equals(searchNim)) {
                break;
            }
        }
        long endTime = System.nanoTime();
        System.out.println("CustomLinkedList search: " +
                TimeUnit.NANOSECONDS.toMicros(endTime - startTime) + " microseconds");
    }
}

// Main class
public class CompareEfficiency {
    public static void main(String[] args) {
        int numItems = 10000;

        // Stack Performance
        System.out.println("Stack Performance:");
        StackPerformance stackPerf = new StackPerformance(numItems);
        stackPerf.measureAddPerformance();
        stackPerf.measureProcessPerformance();

        // Queue Performance
        System.out.println("\nQueue Performance:");
        QueuePerformance queuePerf = new QueuePerformance(numItems);
        queuePerf.measureAddPerformance();
        queuePerf.measureProcessPerformance();

        // Custom LinkedList Performance
        System.out.println("\nCustomLinkedList Performance:");
        CustomLinkedListPerformance customLLPerf = new CustomLinkedListPerformance(numItems);
        customLLPerf.measureAddPerformance();
        customLLPerf.measureProcessPerformance();

        // Search Performance
        String searchNim = "S" + (numItems - 1);
        System.out.println("\nSearch Performance (searching last item):");
        stackPerf.measureSearchPerformance(searchNim);
        queuePerf.measureSearchPerformance(searchNim);
        customLLPerf.measureSearchPerformance(searchNim);
    }
}