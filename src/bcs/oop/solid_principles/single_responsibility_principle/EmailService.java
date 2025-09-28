package bcs.oop.solid_principles.single_responsibility_principle;

public class EmailService {

    public void sendInvoice(Invoice invoice, String recipientEmail) {
        System.out.println("Sending invoice " + invoice.getInvoiceNumber() +
                " to: " + recipientEmail);
        System.out.println("Email sent successfully!");
    }
}
