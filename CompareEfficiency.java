import java.util.*;
import java.util.concurrent.TimeUnit;

class Order {
    private String orderId;
    private String item;
    private double price;

    public Order(String orderId, String item, double price) {
        this.orderId = orderId;
        this.item = item;
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId='" + orderId + "', item='" + item + "', price=" + price + "}";
    }
}

public class CompareEfficiency {
    public static void main(String[] args) {
        int numOrders = 10000;
        long startTime, endTime;

        // Stack Implementation
        Stack<Order> stack = new Stack<>();
        System.out.println("\nStack Performance:");

        // Adding orders
        startTime = System.nanoTime();
        for (int i = 0; i < numOrders; i++) {
            stack.push(new Order("S" + i, "Item" + i, 10.0 + i));
        }
        endTime = System.nanoTime();
        System.out.println("Add " + numOrders + " orders: " +
                TimeUnit.NANOSECONDS.toMicros(endTime - startTime) + " microseconds");

        // Processing orders
        startTime = System.nanoTime();
        while (!stack.isEmpty()) {
            stack.pop();
        }
        endTime = System.nanoTime();
        System.out.println("Process " + numOrders + " orders: " +
                TimeUnit.NANOSECONDS.toMicros(endTime - startTime) + " microseconds");

        // Queue Implementation
        Queue<Order> queue = new ArrayDeque<>();
        System.out.println("\nQueue Performance:");

        // Adding orders
        startTime = System.nanoTime();
        for (int i = 0; i < numOrders; i++) {
            queue.offer(new Order("Q" + i, "Item" + i, 10.0 + i));
        }
        endTime = System.nanoTime();
        System.out.println("Add " + numOrders + " orders: " +
                TimeUnit.NANOSECONDS.toMicros(endTime - startTime) + " microseconds");

        // Processing orders
        startTime = System.nanoTime();
        while (!queue.isEmpty()) {
            queue.poll();
        }
        endTime = System.nanoTime();
        System.out.println("Process " + numOrders + " orders: " +
                TimeUnit.NANOSECONDS.toMicros(endTime - startTime) + " microseconds");

        // LinkedList Implementation
        LinkedList<Order> linkedList = new LinkedList<>();
        System.out.println("\nLinkedList Performance:");

        // Adding orders
        startTime = System.nanoTime();
        for (int i = 0; i < numOrders; i++) {
            linkedList.add(new Order("L" + i, "Item" + i, 10.0 + i));
        }
        endTime = System.nanoTime();
        System.out.println("Add " + numOrders + " orders: " +
                TimeUnit.NANOSECONDS.toMicros(endTime - startTime) + " microseconds");

        // Processing orders
        startTime = System.nanoTime();
        while (!linkedList.isEmpty()) {
            linkedList.removeFirst();
        }
        endTime = System.nanoTime();
        System.out.println("Process " + numOrders + " orders: " +
                TimeUnit.NANOSECONDS.toMicros(endTime - startTime) + " microseconds");

        // Search performance comparison
        // Re-populate for search test
        for (int i = 0; i < numOrders; i++) {
            stack.push(new Order("S" + i, "Item" + i, 10.0 + i));
            queue.offer(new Order("Q" + i, "Item" + i, 10.0 + i));
            linkedList.add(new Order("L" + i, "Item" + i, 10.0 + i));
        }

        String searchId = "S" + (numOrders - 1);
        System.out.println("\nSearch Performance (searching last order):");

        // Stack search
        startTime = System.nanoTime();
        for (Order order : stack) {
            if (order.getOrderId().equals(searchId)) {
                break;
            }
        }
        endTime = System.nanoTime();
        System.out.println("Stack search: " +
                TimeUnit.NANOSECONDS.toMicros(endTime - startTime) + " microseconds");

        // Queue search
        startTime = System.nanoTime();
        for (Order order : queue) {
            if (order.getOrderId().equals(searchId)) {
                break;
            }
        }
        endTime = System.nanoTime();
        System.out.println("Queue search: " +
                TimeUnit.NANOSECONDS.toMicros(endTime - startTime) + " microseconds");

        // LinkedList search
        startTime = System.nanoTime();
        for (Order order : linkedList) {
            if (order.getOrderId().equals(searchId)) {
                break;
            }
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList search: " +
                TimeUnit.NANOSECONDS.toMicros(endTime - startTime) + " microseconds");
    }
}