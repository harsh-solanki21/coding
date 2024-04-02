# Single Responsibility Principle

- **A class should have one, and only one, reason to change.**


- If a Class has many responsibilities, it increases the possibility of bugs because making changes to one of its responsibilities, could affect the other ones without you knowing.


- Requirements change over time. Each of them also changes the responsibility of at least one class. The more responsibilities your class has, the more often you need to change it. If your class implements multiple responsibilities, they are no longer independent of each other.


### A Simple Question to Validate Your Design
- You can avoid the problems by asking a simple question before you make any changes: What is the responsibility of your class/component/microservice?

- If your answer includes the word “and”, you’re most likely breaking the single responsibility principle. Then it’s better to take a step back and rethink your current approach. There is most likely a better way to implement it.
