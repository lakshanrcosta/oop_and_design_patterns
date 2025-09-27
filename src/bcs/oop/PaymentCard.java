package bcs.oop;

abstract public class PaymentCard {
    private String cardNumber;
    private String cardHolderName;

    public PaymentCard(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName(){
        return cardHolderName;

    }

    abstract void pay();
}
