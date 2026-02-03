package service;

import payment.PaymentMethod;

public class PaymentService {
    public void processPayment(PaymentMethod paymentMethod, double amount) {
        paymentMethod.pay(amount);
    }
}
