package bcs.oop.solid_principles.open_close_principle;

public class PayPalProcessor implements PaymentProcessor {

    @Override
    public String processPayment(double amount) {
        return "Processed $" + amount + " via PayPal";
    }

    @Override
    public String getPaymentType() {
        return "PayPal";
    }
}
