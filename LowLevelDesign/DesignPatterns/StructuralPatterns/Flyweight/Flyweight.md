# Flyweight Pattern

>According to GoF, Flyweight design pattern intent is:
<br />
> **Use sharing to support large numbers of fine-grained objects efficiently.**

<br />

- Flyweight design pattern is used when we need to create a lot of Objects of a class. Since every object consumes memory space that can be crucial for low memory devices, such as mobile devices or embedded systems, flyweight design pattern can be applied to reduce the load on memory by sharing objects.

<br />

- Before we apply flyweight design pattern, we need to consider following
factors:
  1. The number of Objects to be created by application should be huge.
  2. The object creation is heavy on memory, and it can be time-consuming
too.
  3. The object properties can be divided into intrinsic and extrinsic properties, extrinsic properties of an Object should be defined by the
  client program.

<br />

- To apply flyweight pattern, we need to divide Object property into intrinsic and extrinsic properties. Intrinsic properties make the Object unique whereas extrinsic properties are set by client code and used to perform different operations. For example, an Object Circle can have extrinsic properties such as color and width.


- For applying flyweight pattern, we need to create a Flyweight factory that
  returns the shared objects. For our example, let’s say we need to create a drawing with lines and Ovals. So we will have an interface Shape and its concrete implementations as Line and Oval. Oval class will have intrinsic property to determine whether to fill the Oval with given color or not whereas Line will not have any intrinsic property.