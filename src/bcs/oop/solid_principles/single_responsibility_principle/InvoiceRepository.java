package bcs.oop.solid_principles.single_responsibility_principle;

import java.util.HashMap;
import java.util.Map;

public class InvoiceRepository {
    private final Map<String, Invoice> invoices = new HashMap<>();

    public void save(Invoice invoice) {
        invoices.put(invoice.getInvoiceNumber(), invoice);
        System.out.println("Invoice " + invoice.getInvoiceNumber() + " saved to database");
    }

    public Invoice findById(String invoiceNumber) {
        return invoices.get(invoiceNumber);
    }

    public boolean exists(String invoiceNumber) {
        return invoices.containsKey(invoiceNumber);
    }
}
