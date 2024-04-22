# Singleton Pattern

- The Singleton pattern ensures that a class has only one instance and provides a global point of access to that instance.

- if you need to access a database connection, a configuration file, or a logger throughout your application, you can use a Singleton to create and reuse one instance of these resources.


- Singleton class never accepts parameters. If it accepts parameter, then it becomes factory. So avoid it.


- Ways to break Singleton pattern:
  1. Reflection API
  2. Deserialization
  3. Cloning
