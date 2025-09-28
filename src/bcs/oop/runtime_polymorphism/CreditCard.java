package bcs.oop.runtime_polymorphism;

public class CreditCard extends PaymentCard {

    public CreditCard(String cardNumber, String cardHolderName) {
        super(cardNumber, cardHolderName);
    }

    @Override
    public void pay() {
        System.out.println("Making a payment with a credit card");
    }
}
