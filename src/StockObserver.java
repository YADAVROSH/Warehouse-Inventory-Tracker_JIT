//Alert int

public interface StockObserver {

    void onLowStock(Product product);

}
// Ye ek interface hai jo alert ke liye method define karta hai.
// 🔹 Jis class me alert chahiye, wo isko implement karegi.