package collections_streams.inventory;

import java.util.Objects;

public class Product implements Comparable<Product> {
    private String id, name, category;
    private double price;
    private int quantity;

    public Product(String id, String name, String category, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public int compareTo(Product p) {
        return this.name.compareTo(p.name);
    }

    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Product p)) return false;
        return Objects.equals(id, p.id);
    }

    public int hashCode() {
        return Objects.hash(id);
    }
}
