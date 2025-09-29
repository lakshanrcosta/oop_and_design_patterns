package bcs.oop.solid_principles.open_close_principle;

public class UpiProcessor implements PaymentProcessor {

    @Override
    public String processPayment(double amount) {
        return "Processed $" + amount + " via UPI";
    }

    @Override
    public String getPaymentType() {
        return "UPI";
    }
}
