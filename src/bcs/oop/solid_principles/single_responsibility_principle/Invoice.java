package bcs.oop.solid_principles.single_responsibility_principle;

/**
 * Invoice class following Single Responsibility Principle
 * Responsibility: Store and manage invoice data only
 */
public class Invoice {
    private final String invoiceNumber;
    private final String customerName;
    private final double amount;

    public Invoice(String invoiceNumber, String customerName, double amount) {
        this.invoiceNumber = invoiceNumber;
        this.customerName = customerName;
        this.amount = amount;
    }

    // Getters only - no business logic
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }
}
