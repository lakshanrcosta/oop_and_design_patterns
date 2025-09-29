package bcs.oop.solid_principles.open_close_principle;

public class DebitCardProcessor implements PaymentProcessor {

    @Override
    public String processPayment(double amount) {
        return "Processed $" + amount + " via Debit Card";
    }

    @Override
    public String getPaymentType() {
        return "Debit Card";
    }
}
