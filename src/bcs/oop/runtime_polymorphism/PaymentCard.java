package bcs.oop.runtime_polymorphism;

abstract public class PaymentCard implements PaymentMethod {
    private final String cardNumber;
    private final String cardHolderName;

    public PaymentCard(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }
}
