package service;

import model.Customer;
import model.Order;

public class OrderService {
    public void placeOrder(Customer customer, Order order) {
        System.out.println("Order placed by " + customer.getName() +
                " | Total Amount: ₹" + order.getTotalAmount());
    }
}
