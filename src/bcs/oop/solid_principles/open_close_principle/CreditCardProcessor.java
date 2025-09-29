package bcs.oop.solid_principles.open_close_principle;

public class CreditCardProcessor implements PaymentProcessor {

    @Override
    public String processPayment(double amount) {
        return "Processed $" + amount + " via Credit Card";
    }

    @Override
    public String getPaymentType() {
        return "Credit Card";
    }
}
