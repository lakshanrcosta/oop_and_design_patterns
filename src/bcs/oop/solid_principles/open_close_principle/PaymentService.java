package bcs.oop.solid_principles.open_close_principle;

import java.util.ArrayList;
import java.util.List;

public class PaymentService {
    private final List<PaymentProcessor> processors;

    public PaymentService() {
        this.processors = new ArrayList<>();
    }

    public void addProcessor(PaymentProcessor processor) {
        processors.add(processor);
    }

    // Process payment using the first available method
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + "...");

        if (processors.isEmpty()) {
            System.out.println("No payment methods available!");
            return;
        }

        // Use the first available payment method
        PaymentProcessor selectedProcessor = processors.getFirst();
        String result = selectedProcessor.processPayment(amount);
        System.out.println(result);
    }

    // Process payment with a specific method
    public void processPaymentWith(String paymentType, double amount) {
        System.out.println("Processing payment of $" + amount + " with " + paymentType + "...");

        for (PaymentProcessor processor : processors) {
            if (processor.getPaymentType().equalsIgnoreCase(paymentType)) {
                String result = processor.processPayment(amount);
                System.out.println(result);
                return;
            }
        }

        System.out.println("Payment method '" + paymentType + "' not found!");
    }

    // Show all available payment methods (for user to choose from)
    public void showAvailablePaymentMethods() {
        System.out.println("Available payment methods:");
        for (PaymentProcessor processor : processors) {
            System.out.println("- " + processor.getPaymentType());
        }
    }
}
