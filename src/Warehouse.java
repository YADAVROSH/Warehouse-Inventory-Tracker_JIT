
import java.util.*;

public class Warehouse {
    private String name;
    private Map<String, Product> inventory = new HashMap<>();
    private List<StockObserver> observers = new ArrayList<>();

    public Warehouse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void addProduct(String id, String name, int quantity, int threshold) {
        if (inventory.containsKey(id)) {
            System.out.println("[" + this.name + "] Product ID already exists!");
            return;
        }
        inventory.put(id, new Product(id, name, quantity, threshold));
        System.out.println("[" + this.name + "] Added product: " + name);
    }

    public void receiveShipment(String id, int amount) {
        Product p = inventory.get(id);
        if (p == null) {
            System.out.println("[" + this.name + "] Invalid product ID!");
            return;
        }
        p.increaseStock(amount);
        System.out.println("[" + this.name + "] Shipment received: +" + amount + " units of " + p.getName());
    }

    public void fulfillOrder(String id, int amount) {
        Product p = inventory.get(id);
        if (p == null) {
            System.out.println("[" + this.name + "] Invalid product ID!");
            return;
        }
        try {
            p.decreaseStock(amount);
            System.out.println("[" + this.name + "] Order fulfilled: -" + amount + " units of " + p.getName());
            if (p.getQuantity() <= p.getReorderThreshold())
                notifyObservers(p);
        } catch (IllegalArgumentException e) {
            System.out.println("[" + this.name + "] " + e.getMessage());
        }
    }

    private void notifyObservers(Product p) {
        for (StockObserver observer : observers)
            observer.onLowStock(this.name, p);
    }
}
