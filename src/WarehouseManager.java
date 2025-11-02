
import java.util.*;

public class WarehouseManager {
    private List<Warehouse> warehouses = new ArrayList<>();

    public void addWarehouse(Warehouse w) {
        warehouses.add(w);
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }
}
