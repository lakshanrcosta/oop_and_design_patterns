package bcs.oop.solid_principles.open_close_principle;

/**
 * Simple payment processor interface
 * This interface is closed for modification but open for extension
 */
public interface PaymentProcessor {
    /**
     * Process a payment transaction
     * @param amount The amount to be processed
     * @return PaymentResult containing transaction details
     */
    String processPayment(double amount);

    /**
     * Get the payment method name
     * @return String representing the payment method
     */
    String getPaymentType();
}
