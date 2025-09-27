package bcs.oop;

public class DebitCard extends PaymentCard {

    public DebitCard(String cardNumber, String cardHolderName) {
        super(cardNumber, cardHolderName);
    }

    @Override
    void pay() {
        System.out.println("Making a payment with a debit card");
    }
}
