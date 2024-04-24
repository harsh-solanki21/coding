# Facade Pattern

- It is used to help client applications to easily interact with the system.

<br />

###### According to GoF Facade design pattern is:
> Provide a unified interface to a set of interfaces in a subsystem. Facade pattern defines a higher-level interface that makes the subsystem easier to use.

<br />

### Important Points
- Facade pattern is more like a helper for client applications, it doesn't hide subsystem interfaces from the client. Whether to use Facade or not is completely dependent on client code.

- Facade pattern can be applied at any point of development, usually when the number of interfaces grow and system gets complex.

- Facade pattern should be applied for similar kind of interfaces, its
  purpose is to provide a single interface rather than multiple interfaces
  that does the similar kind of jobs.

- We can use `Factory pattern` with `Facade` to provide better interface to
  client systems.
