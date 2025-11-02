
//Ye Observer class hai — jab stock kam hota hai to ye alert print karti hai.
public class AlertService implements StockObserver {
    @Override
    public void onLowStock(String warehouseName, Product product) {
        System.out.println("⚠️ Low stock alert from " + warehouseName + ": "
                + product.getName() + " only " + product.getQuantity() + " left!");
    }
}
