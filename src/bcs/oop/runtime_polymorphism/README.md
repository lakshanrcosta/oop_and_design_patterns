# Java Runtime Polymorphism Example: Payment System

This project demonstrates **runtime polymorphism** in Java using a simple payment processing system. It shows how
interfaces, abstract classes, and method overriding enable flexible and extensible code.

---

## OOP Theory: Classes, Objects, Interfaces, and Polymorphism

### What is a Class?

A **class** is like a blueprint or template for creating objects. It defines the properties (fields/attributes) and
behaviors (methods/functions) that the objects created from the class will have.

*Example:*

```java
class Dog {
    String name;

    void bark() {
        System.out.println(name + " says woof!");
    }
}
```

### What is an Object?

An **object** is an instance of a class. It is a real entity in your program that has state (data) and behavior (
methods).

*Example:*

```java
Dog myDog = new Dog();
myDog.name ="Buddy";
        myDog.

bark(); // Output: Buddy says woof!
```

### What is an Interface?

An **interface** is a contract that defines what methods a class must implement, but not how they are implemented.
Interfaces allow you to specify a set of behaviors that different classes can share, even if they are not related by
inheritance.

*Example:*

```java
interface Animal {
    void makeSound();
}

class Cat implements Animal {
    public void makeSound() {
        System.out.println("Meow");
    }
}
```

### What is Polymorphism?

**Polymorphism** means "many forms." In OOP, it allows objects of different classes to be treated as objects of a common
super type (like an interface or superclass). The actual method that gets called is determined at runtime, depending on
the object's real type.

*Example:*

```java
Animal a = new Cat();
a.

makeSound(); // Output: Meow
```

---

## Explanation (Step-by-Step)

1. **Define an Interface:**
    - `PaymentMethod` is an interface. It says every payment method must have a `pay()` and `getCardNumber()` method.

2. **Create Abstract and Concrete Classes:**
    - `PaymentCard` is an abstract class (cannot be used directly) that stores card info and implements `PaymentMethod`.
    - `CreditCard` and `DebitCard` are real classes that extend `PaymentCard` and provide their own way to pay.
    - `Upi` is a class that implements `PaymentMethod` directly, using a UPI ID instead of a card number.

3. **Store Payment Methods:**
    - `PaymentService` keeps a list (map) of payment methods. You can add any payment method (card or UPI) to it.

4. **Make Payments:**
    - When you call `makePayment`, the service finds the payment method by name and calls its `pay()` method.
    - The actual code that runs depends on the real type (credit card, debit card, or UPI) — this is polymorphism in
      action!

5. **Client Code:**
    - The `Client` class shows how to add different payment methods and make payments. The same code works for all
      types.

---

## Theory: What is Runtime Polymorphism?

**Polymorphism** is an OOP principle where objects of different classes can be treated as objects of a common super
type. **Runtime polymorphism** (dynamic method dispatch) means the method to be executed is determined at runtime, not
compile time. This is achieved via:

- **Interfaces or abstract classes**
- **Method overriding**
- **Supertype references pointing to subtype objects**

### Why is this important?

Runtime polymorphism allows you to write code that works with objects of different types in a uniform way. This makes
your code more flexible, extensible, and easier to maintain. You can add new types (e.g., new payment methods) without
changing the code that uses the interface.

## Project Structure

- `PaymentMethod.java`: Interface defining the contract for all payment methods.
- `PaymentCard.java`: Abstract class for card-based payment methods, implements `PaymentMethod`.
- `CreditCard.java`, `DebitCard.java`: Concrete classes for specific card types, extend `PaymentCard`.
- `Upi.java`: Concrete class for UPI payments, implements `PaymentMethod` directly.
- `PaymentService.java`: Service class that stores and uses payment methods polymorphically.
- `Client.java`: Demo class to run the example.

## How the Code Works

### 1. Interface and Abstract Class

- `PaymentMethod` interface defines `pay()` and `getCardNumber()` methods. Any payment type must implement these
  methods.
- `PaymentCard` is an abstract class for cards, storing card number and holder name, and providing a default
  `getCardNumber()` implementation. It cannot be instantiated directly, but provides shared logic for its subclasses.

### 2. Concrete Implementations

- `CreditCard` and `DebitCard` extend `PaymentCard` and override `pay()` to provide specific behavior for each card
  type. They inherit the card number and holder name logic from `PaymentCard`.
- `Upi` implements `PaymentMethod` directly, using a UPI ID instead of a card number. This shows that not all payment
  methods need to be cards, but they all follow the same contract.

### 3. Service Usage

- `PaymentService` stores payment methods in a HashMap and provides methods to add and use them.
- The `makePayment` method demonstrates polymorphism: it calls `pay()` on a `PaymentMethod` reference, but the actual
  implementation that runs depends on the real object type.

### 4. Polymorphism in Action

- All payment methods are stored as `PaymentMethod` references in the `PaymentService` map. This means the service is
  decoupled from the concrete implementations.
- At runtime, the correct `pay()` and `getCardNumber()` implementations are called based on the actual object type (
  e.g., `CreditCard`, `DebitCard`, or `Upi`).

## Example Output

```
Adding payment method: CreditCard
Adding payment method: DebitCard
Adding payment method: UPI

=== Making Payments ===
Processing payment of $150.75 using CreditCard with card number: 4010-5678-9012-3456
Making a payment with a credit card
Processing payment of $200.0 using DebitCard with card number: 9876-5432-1098-7654
Making a payment with a debit card
Processing payment of $50.25 using UPI with card number: john@upi
Making a payment with UPI. UpiId: john@upi
```

## OOP Principles Demonstrated

- **Abstraction**: Client code uses the `PaymentMethod` interface, not concrete classes. This hides implementation
  details.
- **Polymorphism**: Same method call (`pay()`) results in different behaviors depending on the object type.
- **Encapsulation**: Card details are private and accessed via methods, not directly.
- **Inheritance**: `CreditCard` and `DebitCard` inherit from `PaymentCard`.
- **Open/Closed Principle**: New payment types can be added without modifying existing code, as long as they implement
  the interface.
- **Single Responsibility Principle**: Each class has a clear responsibility (e.g., payment logic, service logic).

## How to Run

1. Compile all Java files in the `src/bcs/oop/runtime_polymorphism/` directory.
2. Run the `Client` class.

## Further Reading

- [Java Polymorphism (Oracle Docs)](https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html)
- [Effective Java, Item 20: Prefer interfaces to abstract classes]

This example is a practical demonstration of how runtime polymorphism enables flexible, maintainable, and extensible
code in Java.
