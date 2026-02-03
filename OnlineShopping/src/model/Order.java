package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<OrderItem> items = new ArrayList<>();

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double getTotalAmount() {
        return items.stream()
                .mapToDouble(OrderItem::getPrice)
                .sum();
    }
}
