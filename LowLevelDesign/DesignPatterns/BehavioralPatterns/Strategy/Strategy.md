# Strategy Pattern

- Strategy patter is used when we have multiple algorithm for a specific task and client decides the actual implementation to be used at runtime.

<br />

### Important Points

- We could have used composition to create instance variable for strategies, but we should avoid that as we want the specific strategy to be applied for a particular task, same is followed in Collections.sort() and Arrays.sort() method that take comparator as argument.

- Strategy pattern is useful when we have multiple algorithms for specific task, and we want our application to be flexible to choose any of the algorithm at runtime for specific task.
