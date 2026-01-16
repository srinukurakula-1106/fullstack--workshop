package collections_streams.inventory;

import java.util.*;

public class InventoryTest {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addProduct(new Product("P001","Laptop","Electronics",999.99,50));
        inventory.addProduct(new Product("P002","Mouse","Electronics",29.99,5));
        inventory.addProduct(new Product("P003","Desk","Furniture",299.99,15));

        Queue<Product> low = inventory.getLowStockAlerts();
        while(!low.isEmpty()) {
            System.out.println("Low stock: " + low.poll().getName());
        }
    }
}
