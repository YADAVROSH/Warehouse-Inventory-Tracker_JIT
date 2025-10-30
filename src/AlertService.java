
//Ye Observer class hai — jab stock kam hota hai to ye alert print karti hai.
public class AlertService implements StockObserver {
    public void onLowStock(Product product) {
        System.out.println(
                " Restock Alert: Low stock for " + product.getName() + " - only " + product.getQuantity() + " left!");

    }
}
