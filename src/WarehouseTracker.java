
//Ye main class project run karti hai.
// Ye warehouse aur alert service ko connect karti hai

public class WarehouseTracker {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        AlertService alertService = new AlertService();
        warehouse.addObserver(alertService);

        warehouse.addProduct("P101", "Laptop", 0, 5);
        warehouse.receiveShipment("P101", 10);
        warehouse.fulfillOrder("P101", 6);
    }
}
