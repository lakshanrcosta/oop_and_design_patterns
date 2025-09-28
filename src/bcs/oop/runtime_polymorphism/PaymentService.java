package bcs.oop.runtime_polymorphism;

import java.util.HashMap;

public class PaymentService {

    HashMap<String, PaymentMethod> paymentMethods;

    public PaymentService() {
        paymentMethods = new HashMap<>();
    }

    public void addPaymentMethod(String name, PaymentMethod paymentMethod) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Payment method name cannot be null or empty");
        }
        if (paymentMethod == null) {
            throw new IllegalArgumentException("Payment method cannot be null");
        }
        paymentMethods.put(name, paymentMethod);
        System.out.println("Adding payment method: " + name);
    }

    public void makePayment(String name, double amount) {
        PaymentMethod paymentMethod = paymentMethods.get(name);
        if (paymentMethod == null) {
            throw new IllegalArgumentException("Payment method not found: " + name);
        }

        System.out.println("Processing payment of $" + amount + " using " + name + " with card number: " + paymentMethod.getCardNumber());
        paymentMethod.pay();
    }
}
