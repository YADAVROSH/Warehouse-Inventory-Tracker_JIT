//Ye main class project run karti hai.
// Ye warehouse aur alert service ko connect karti hai

//import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AlertService alert = new AlertService();
        WarehouseManager manager = new WarehouseManager();

        // Multiple Warehouses
        Warehouse indore = new Warehouse("Indore");
        Warehouse bhopal = new Warehouse("Bhopal");
        Warehouse delhi = new Warehouse("Delhi");

        // Observer ko har warehouse me add kiya:
        indore.addObserver(alert);
        bhopal.addObserver(alert);
        delhi.addObserver(alert);

        manager.addWarehouse(indore);
        manager.addWarehouse(bhopal);
        manager.addWarehouse(delhi);

        // Indore warehouse
        indore.addProduct("P001", "Laptop", 5, 3);
        indore.receiveShipment("P001", 10);
        indore.fulfillOrder("P001", 12);
        System.out.println();

        // Bhopal warehouse
        bhopal.addProduct("P002", "Smartphone", 8, 4);
        bhopal.fulfillOrder("P002", 6);
        bhopal.fulfillOrder("P002", 2);
        System.out.println();

        // Delhi warehouse
        delhi.addProduct("P003", "Headphones", 6, 2);
        delhi.receiveShipment("P003", 4);
        delhi.fulfillOrder("P003", 8);
        System.out.println();
    }
}
