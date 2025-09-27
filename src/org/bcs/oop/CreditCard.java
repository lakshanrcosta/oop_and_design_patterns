package org.bcs.oop;

public class CreditCard extends PaymentCard{

    public CreditCard(String cardNumber, String cardHolderName) {
        super(cardNumber, cardHolderName);
    }

    @Override
    void pay() {
        System.out.println("Making a payment with a credit card");
    }
}
