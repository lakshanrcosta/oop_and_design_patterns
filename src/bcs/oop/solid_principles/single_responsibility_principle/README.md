# Single Responsibility Principle (SRP) - Complete Study Guide

## 📚 What is Single Responsibility Principle?

The **Single Responsibility Principle (SRP)** is the first principle of the SOLID design principles, introduced by
Robert C. Martin (Uncle Bob).

### Definition

> **"A class should have only one reason to change"**

This means each class should have only **one responsibility** or **one job to do**.

## 🎯 Core Concepts

### What is a "Responsibility"?

A responsibility is a **reason to change**. If you can think of more than one motive for changing a class, then that
class has more than one responsibility.

### Examples of Different Responsibilities:

- **Data Management**: Storing and managing object state
- **Business Logic**: Implementing business rules and calculations
- **Data Persistence**: Saving/loading data from databases
- **User Interface**: Displaying information to users
- **Communication**: Sending emails, notifications, etc.
- **Formatting**: Converting data to different formats

## 💡 Why is SRP Important?

### Problems with Multiple Responsibilities:

1. **Hard to Maintain**: Changes in one area can break another
2. **Difficult Testing**: You need to set up multiple contexts to test one class
3. **Poor Reusability**: Can't reuse one part without taking the whole class
4. **Tight Coupling**: Different concerns are mixed together
5. **Unclear Code**: Hard to understand what the class actually does

### Benefits of Following SRP:

1. **Easy Maintenance**: Changes are isolated to one class
2. **Simple Testing**: Each class can be tested independently
3. **High Reusability**: Classes can be used in different contexts
4. **Loose Coupling**: Classes are independent of each other
5. **Clear Purpose**: Each class has an obvious, single job

## 🔍 Code Example Breakdown

Our simplified example demonstrates SRP with 4 classes, each having exactly one responsibility:

### 1. Invoice.java - Data Storage Responsibility

```java
public class Invoice {
    private final String invoiceNumber;
    private final String customerName;
    private final double amount;

    // Constructor and getters only
}
```

**What it does:** Stores invoice data
**What it does NOT do:**

- ❌ Format invoices
- ❌ Send emails
- ❌ Save to database
- ❌ Validate business rules

**Why this is good:** If we need to change how invoice data is structured, we only modify this class.

### 2. InvoiceRepository.java - Data Persistence Responsibility

```java
public class InvoiceRepository {
    private final Map<String, Invoice> invoices = new HashMap<>();

    public void save(Invoice invoice) { ...}

    public Invoice findById(String invoiceNumber) { ...}

    public boolean exists(String invoiceNumber) { ...}
}
```

**What it does:** Handles saving and retrieving invoices
**What it does NOT do:**

- ❌ Create invoices
- ❌ Format invoices
- ❌ Send notifications
- ❌ Validate data

**Why this is good:** If we want to change from HashMap to a real database, we only modify this class.

### 3. EmailService.java - Communication Responsibility

```java
public class EmailService {
    public void sendInvoice(Invoice invoice, String recipientEmail) {
        // Send email logic only
    }
}
```

**What it does:** Sends emails
**What it does NOT do:**

- ❌ Store invoices
- ❌ Format invoices
- ❌ Create invoices
- ❌ Validate email addresses

**Why this is good:** If we want to switch from email to SMS, we only modify this class.

### 4. InvoiceGenerator.java - Formatting Responsibility

```java
public class InvoiceGenerator {
    public String generateInvoiceText(Invoice invoice) {
        // Formatting logic only
    }
}
```

**What it does:** Formats invoices for display
**What it does NOT do:**

- ❌ Store invoices
- ❌ Send invoices
- ❌ Validate invoices
- ❌ Calculate totals

**Why this is good:** If we want to change the invoice format, we only modify this class.

## ❌ SRP Violation Example

### What NOT to do - Bad Example:

```java
public class BadInvoiceManager {
    // Multiple responsibilities in one class - VIOLATES SRP!

    // Data storage
    private String invoiceNumber;
    private double amount;

    // Business logic
    public void calculateTax() { ...}

    // Data persistence
    public void saveToDatabase() { ...}

    // Email sending
    public void sendByEmail(String email) { ...}

    // Formatting
    public String generatePDF() { ...}

    public String generateHTML() { ...}
}
```

### Problems with this approach:

1. **Multiple reasons to change:**
    - Database schema changes → modify saveToDatabase()
    - Email provider changes → modify sendByEmail()
    - PDF format changes → modify generatePDF()
    - Tax calculation changes → modify calculateTax()

2. **Testing nightmare:**
    - To test email functionality, you need database setup
    - To test PDF generation, you need valid invoice data
    - Cannot test components independently

3. **Reusability issues:**
    - Cannot reuse email functionality for other purposes
    - Cannot use formatting logic without invoice logic

## ✅ SRP Solution - Good Example:

Our solution separates concerns into different classes:

- `Invoice` → Data storage
- `InvoiceRepository` → Data persistence
- `EmailService` → Communication
- `InvoiceGenerator` → Formatting

Each class can be:

- **Modified independently**
- **Tested separately**
- **Reused in other contexts**
- **Understood easily**

## 🔄 How Classes Work Together

```java
// Each class does its ONE job
Invoice invoice = new Invoice("INV-001", "John", 250.75);  // Data storage
repository.

save(invoice);                                   // Data persistence

String text = generator.generateInvoiceText(invoice);      // Formatting
emailService.

sendInvoice(invoice, "john@email.com");      // Communication
```

## 🎓 Study Tips

### How to Identify SRP Violations:

1. **Count responsibilities**: List what the class does. If more than one major thing, it probably violates SRP
2. **Reason to change test**: How many different reasons could cause you to modify this class?
3. **Method grouping**: Do methods in the class deal with completely different concerns?
4. **Dependency analysis**: Does the class depend on many different types of external systems?

### How to Apply SRP:

1. **Identify responsibilities**: List all the things your class does
2. **Group related functionality**: Which methods belong together?
3. **Extract classes**: Create new classes for each responsibility
4. **Define clear interfaces**: Make classes communicate through well-defined methods
5. **Test independently**: Ensure each class can be tested on its own

## 📝 Practice Exercises

1. **Identify violations**: Look at existing code and identify classes that violate SRP
2. **Refactor exercise**: Take a "God class" and split it into multiple classes following SRP
3. **Design exercise**: Design a simple library management system following SRP

## 🔗 Real-World Applications

### Common Patterns Following SRP:

- **Repository Pattern**: Separate data access from business logic
- **Service Layer Pattern**: Separate business operations from controllers
- **Strategy Pattern**: Separate different algorithms into different classes
- **Observer Pattern**: Separate notification logic from business logic

### Examples in Popular Frameworks:

- **Spring Framework**: Controllers, Services, Repositories have separate responsibilities
- **Android Development**: Activities (UI), Models (data), Services (background tasks)
- **Web Development**: Controllers (request handling), Models (data), Views (presentation)

## 📋 Summary Checklist

When designing a class, ask yourself:

- [ ] Does this class have only one reason to change?
- [ ] Can I describe what this class does in one simple sentence?
- [ ] Are all methods in this class related to the same responsibility?
- [ ] Can I test this class independently of others?
- [ ] Can I reuse this class in different contexts?

If you answered "no" to any of these questions, consider refactoring to better follow SRP!

## 🎯 Key Takeaways

1. **One class, one responsibility** - Keep it simple and focused
2. **Separate concerns** - Don't mix data, business logic, persistence, and presentation
3. **Think about change** - Classes with fewer responsibilities are easier to modify
4. **Test independently** - Each class should be testable on its own
5. **Reuse components** - Well-designed classes can be used in multiple contexts

Remember: SRP is about creating **maintainable, testable, and reusable** code by giving each class a clear, single
purpose!
