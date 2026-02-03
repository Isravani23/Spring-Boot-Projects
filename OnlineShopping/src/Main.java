import model.Customer;
import model.Order;
import model.OrderItem;
import model.Product;
import payment.PaymentMethod;
import payment.UPIPayment;
import service.OrderService;
import service.PaymentService;

public class Main {
    public static void main(String[] args) {
        // Customer (Inheritance)
        Customer customer = new Customer(
                101,
                "Sonia",
                "sonia@gmail.com"
        );

        // Products (Aggregation)
        Product phone = new Product("Mobile Phone", 15000);
        Product charger = new Product("Charger", 1000);

        // Order + OrderItems (Composition)
        Order order = new Order();
        order.addItem(new OrderItem(phone, 1));
        order.addItem(new OrderItem(charger, 2));

        // Services (Association)
        OrderService orderService = new OrderService();
        orderService.placeOrder(customer, order);

        PaymentService paymentService = new PaymentService();

        // Choose payment method (OCP)
        PaymentMethod paymentMethod = new UPIPayment();
        paymentService.processPayment(paymentMethod, order.getTotalAmount());
    }
}