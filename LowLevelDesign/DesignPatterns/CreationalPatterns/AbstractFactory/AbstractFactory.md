# Abstract Factory Pattern

- The Abstract Factory Pattern is a Creational Design Pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes, in simpler terms the Abstract Factory Pattern is a way of organizing how you create groups of things that are related to each other.


- Abstract Factory pattern is almost similar to Factory Pattern and is considered as another layer of abstraction over factory pattern.

- So at runtime, the abstract factory is coupled with any desired concrete factory which can create objects of the desired type.

<br />

### Advantages
1. Provides a family of related objects
2. Hides concrete implementations
3. Supports interchangeable components
4. Enhances scalability and maintainability

<br />

### When to Use Abstract Factory Pattern
1. The client is independent of how we create and compose the objects in the system.
2. The system consists of multiple families of objects, and these families are designed to be used together.
3. We need a run-time value to construct a particular dependency.


<br />

> While the pattern is great when creating predefined objects, adding the new ones might be challenging. To support the new type of objects will require changing the AbstractFactory class and all of its subclasses.
