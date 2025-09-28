package bcs.oop.solid_principles.single_responsibility_principle;

import java.util.List;
import java.util.Map;

public class Client {
    public static void main(String[] args) {

        // Create our service objects (each with ONE responsibility)
        InvoiceRepository repository = new InvoiceRepository();
        EmailService emailService = new EmailService();
        InvoiceGenerator generator = new InvoiceGenerator();

        // 1. Create an invoice (Invoice class: store data only)
        Invoice invoice = new Invoice("INV-001", "John Smith", 250.75);
        System.out.println("Created invoice: " + invoice.getInvoiceNumber() +
                " for customer: " + invoice.getCustomerName() +
                " with amount: $" + invoice.getAmount());
        System.out.println();

        // 2. Save invoice (InvoiceRepository class: handle storage only)
        repository.save(invoice);
        System.out.println();

        // 3. Generate structured invoice data (InvoiceGenerator class: format only)
        List<Map<String, Object>> invoiceData = generator.generateInvoiceData(invoice);
        System.out.println("Generated Invoice Data (Structured Object):");
        System.out.println(invoiceData);
        System.out.println();

        // 4. Generate readable invoice text (alternative format)
        String invoiceText = generator.generateInvoiceText(invoice);
        System.out.println("Generated Invoice (Text Format):");
        System.out.println(invoiceText);

        // 5. Send invoice by email (EmailService class: send emails only)
        emailService.sendInvoice(invoice, "john.smith@email.com");
        System.out.println();

        // 6. Retrieve invoice (InvoiceRepository class: retrieve data only)
        Invoice retrieved = repository.findById("INV-001");
        System.out.println("Retrieved invoice: " + retrieved.getInvoiceNumber() +
                " for customer: " + retrieved.getCustomerName() +
                " with amount: $" + retrieved.getAmount());
        System.out.println();
    }
}
