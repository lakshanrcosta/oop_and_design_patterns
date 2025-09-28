package bcs.oop.runtime_polymorphism;

public class Client {
    public static void main(String[] args) {

        PaymentService paymentService = new PaymentService();

        paymentService.addPaymentMethod("CreditCard", new CreditCard("4010-5678-9012-3456", "John Doe"));
        paymentService.addPaymentMethod("DebitCard", new DebitCard("9876-5432-1098-7654", "Jane Smith"));
        paymentService.addPaymentMethod("UPI", new Upi("john@upi"));

        System.out.println("\n=== Making Payments ===");
        paymentService.makePayment("CreditCard", 150.75);
        paymentService.makePayment("DebitCard", 200.00);
        paymentService.makePayment("UPI", 50.25);
    }
}
