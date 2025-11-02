
//create  a class to stored product details id,name , quantity, reorder le

public class Product {
    private String id;
    private String name;
    private int quantity;
    private int reorderThreshold;

    // create a constructor
    public Product(String id, String name, int quantity, int reorderThreshold) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.reorderThreshold = reorderThreshold;
    }

    // Getters → fields ko access karne ke liye or data ko read krta h
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getReorderThreshold() {
        return reorderThreshold;
    }

    // stock badhane k liye jb shipment aaye
    public void increaseStock(int amount) {
        if (amount > 0)
            quantity += amount;
    }

    // stock kam karne k liye jb order fulfill ho
    public void decreaseStock(int amount) {
        if (amount > quantity)
            throw new IllegalArgumentException("Not enough stock available!");
        quantity -= amount;
    }
}
