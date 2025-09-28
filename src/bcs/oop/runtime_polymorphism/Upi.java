package bcs.oop.runtime_polymorphism;

public class Upi implements PaymentMethod {
    String UpiId;

    public Upi(String id) {
        this.UpiId = id;
    }

    @Override
    public void pay() {
        System.out.println("Making a payment with UPI. UpiId: " + UpiId);
    }

    @Override
    public String getCardNumber() {
        return UpiId;
    }
}
