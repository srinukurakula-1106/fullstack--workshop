package collections_streams.inventory;

import java.util.*;
import java.util.stream.Collectors;

public class Inventory {
    private List<Product> products = new ArrayList<>();
    private Set<String> categories = new HashSet<>();
    private Map<String, Product> byId = new HashMap<>();

    public void addProduct(Product p) {
        products.add(p);
        categories.add(p.getCategory());
        byId.put(p.getId(), p);
    }

    public List<Product> getByCategory(String category) {
        return products.stream()
                .filter(p -> p.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public List<Product> getAllSortedByPrice() {
        return products.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
    }

    public Queue<Product> getLowStockAlerts() {
        return products.stream()
                .filter(p -> p.getQuantity() < 10)
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
