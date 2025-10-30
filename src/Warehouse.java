
import java.util.*;

public class Warehouse {
    private Map<String, Product> inventory = new HashMap<>();
    private List<StockObserver> observers = new ArrayList<>();

    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    // add product
    public void addProduct(String id, String name, int quantity, int threshold) {
        if (inventory.containsKey(id)) {
            System.out.println("Product ID already exists!");
            return;
        }
        inventory.put(id, new Product(id, name, quantity, threshold));
        System.out.println("Added product: " + name);
    }

    // receiveShipment
    public void receiveShipment(String id, int amount) {
        Product p = inventory.get(id);
        if (p == null) {
            System.out.println("Invalid product ID!");
            return;
        }
        p.increaseStock(amount);
        System.out.println("Shipment received: " + amount + " units of " + p.getName());
    }

    // fulfillOrder
    public void fulfillOrder(String id, int amount) {
        Product p = inventory.get(id);
        if (p == null) {
            System.out.println("Invalid product ID!");
            return;
        }
        try {
            p.decreaseStock(amount);
            System.out.println("Order fulfilled: " + amount + " units of " + p.getName());
            if (p.getQuantity() < p.getReorderThreshold())
                notifyObservers(p);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // Jab stock threshold se kam hota hai → observers ko notify karti hai.
    private void notifyObservers(Product p) {
        for (StockObserver observer : observers)
            observer.onLowStock(p);
    }

}

// Ye class inventory manage karti hai (addProduct, receiveShipment,
// fulfillOrder).
// Jab stock threshold se kam hota hai → observers ko notify karti hai.
