package bcs.oop.solid_principles.open_close_principle;

/**
 * Simple demonstration of Open-Close Principle
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("=== Open-Close Principle Demo ===\n");

        // Create payment service
        PaymentService paymentService = new PaymentService();

        // Add initial payment methods (without modifying existing code)
        paymentService.addProcessor(new CreditCardProcessor());
        paymentService.addProcessor(new DebitCardProcessor());
        paymentService.addProcessor(new UpiProcessor());

        // Show available methods
        paymentService.showAvailablePaymentMethods();
        System.out.println();

        // Process payment using first available method
        paymentService.processPayment(100.0);
        System.out.println();

        // Process payment with specific method
        paymentService.processPaymentWith("UPI", 50.0);
        System.out.println();

        // DEMONSTRATE OPEN-CLOSE PRINCIPLE:
        // Adding new payment method without modifying existing code
        System.out.println("=== Adding PayPal (Open-Close Principle) ===");
        paymentService.addProcessor(new PayPalProcessor());

        // Show updated methods
        paymentService.showAvailablePaymentMethods();
        System.out.println();

        // Process payment with the new PayPal method
        paymentService.processPaymentWith("PayPal", 75.0);
        System.out.println();

        // Process payment using default (first) method
        paymentService.processPayment(25.0);
    }
}
