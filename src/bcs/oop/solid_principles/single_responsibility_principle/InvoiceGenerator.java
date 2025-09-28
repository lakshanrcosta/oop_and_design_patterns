package bcs.oop.solid_principles.single_responsibility_principle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceGenerator {

    public List<Map<String, Object>> generateInvoiceData(Invoice invoice) {
        List<Map<String, Object>> invoiceList = new ArrayList<>();

        Map<String, Object> invoiceData = new HashMap<>();
        invoiceData.put("InvoiceNumber", invoice.getInvoiceNumber());
        invoiceData.put("Customer", invoice.getCustomerName());
        invoiceData.put("Amount", invoice.getAmount());

        invoiceList.add(invoiceData);
        return invoiceList;
    }

    // Helper method to convert structured data to readable text for display
    public String generateInvoiceText(Invoice invoice) {
        List<Map<String, Object>> data = generateInvoiceData(invoice);
        Map<String, Object> invoiceData = data.getFirst();

        return "==== INVOICE ====\n" +
                "Number: " + invoiceData.get("InvoiceNumber") + "\n" +
                "Customer: " + invoiceData.get("Customer") + "\n" +
                "Amount: $" + invoiceData.get("Amount") + "\n" +
                "=================\n";
    }
}
