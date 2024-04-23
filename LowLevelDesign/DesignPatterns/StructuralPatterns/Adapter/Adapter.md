# Adapter Pattern

- It is used so that two unrelated interfaces can work together. The object that joins these unrelated interface is called an Adapter.

- Multiple Adapters can be used.

<br />

- While implementing Adapter pattern, there are 2 approaches – `Class
  Adapter` and `Object Adapter`, however both these approaches produce same
  result.

1. Class Adapter – This form uses java inheritance and extends the
   source interface, in our case Socket class.
2. Object Adapter – This form uses Java Composition and adapter
   contains the source object.

> Notice that both the adapter implementations are almost same, and they
implement the SocketAdapter interface. The adapter interface can also be an
abstract class.
