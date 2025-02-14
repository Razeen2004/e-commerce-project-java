# E-Commerce CLI Application by Razeen Baig

## Description
This is a simple command-line e-commerce application built using Java. It demonstrates core Object-Oriented Programming (OOP) concepts such as Encapsulation, Inheritance, Polymorphism, and Abstraction.

## Features
- Add products to a catalog (Electronics and Clothing).
- Add products to a shopping cart.
- View the cart and calculate the total price.
- Checkout using Credit Card or PayPal.
- View order history.

## OOP Concepts Implemented
1. **Encapsulation**: Private fields with public getters/setters in `Product`, `User`, etc.
2. **Inheritance**: `Electronics` and `Clothing` extend the `Product` class.
3. **Polymorphism**: Overridden `displayDetails()` method in subclasses and `processPayment()` in payment methods.
4. **Abstraction**: `Product` as an abstract class and `PaymentMethod` as an interface.
5. **Composition**: `User` has a `ShoppingCart`.
6. **Association**: `Order` links to `PaymentMethod` and products.

## How to Run the Project
1. Ensure you have Java installed on your system.
2. Download or clone the project.
3. Run it and Enjoy!