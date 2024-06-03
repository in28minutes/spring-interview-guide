### 1.Loose Coupling vs Tight Coupling
**Tight Coupling**

Tight coupling refers to a situation where components in a system are highly dependent on each other. This means that a change in one component often necessitates changes in other components. Tight coupling can lead to systems that are hard to maintain, test, and extend because the interconnectedness means that altering one part of the system has wide-ranging effects.

**Example of Tight Coupling:**

Consider a class `A` that uses a class `B` directly:

```java
class B {
    public void doSomething() {
        System.out.println("Doing something in B");
    }
}

class A {
    private B b = new B();

    public void execute() {
        b.doSomething();
    }
}
```

In this example, `A` is tightly coupled to `B`. If `B` changes (e.g., if the method `doSomething` is renamed or its parameters change), `A` also needs to be updated to accommodate these changes.

**Loose Coupling**

Loose coupling refers to a situation where components in a system have little or no knowledge of the definitions of other components. This makes the system more modular, easier to maintain, test, and extend because changes in one component are less likely to impact others.

**Example of Loose Coupling:**

Using interfaces or dependency injection can help achieve loose coupling. Here's how the above example can be refactored for loose coupling:

```java
interface Service {
    void doSomething();
}

class B implements Service {
    public void doSomething() {
        System.out.println("Doing something in B");
    }
}

class A {
    private Service service;

    public A(Service service) {
        this.service = service;
    }

    public void execute() {
        service.doSomething();
    }
}
```

In this example, `A` depends on an interface `Service` rather than a concrete class `B`. This way, `A` is not directly dependent on `B`. You can change the implementation of `B` or use a different implementation of `Service` without changing `A`:

```java
class AnotherService implements Service {
    public void doSomething() {
        System.out.println("Doing something in AnotherService");
    }
}

// Using the loosely coupled setup
Service service = new AnotherService();
A a = new A(service);
a.execute();  // Output: Doing something in AnotherService
```

**Benefits of Loose Coupling:**
- **Flexibility**: Components can be replaced or updated independently.
- **Maintainability**: Easier to understand, test, and modify.
- **Scalability**: New features or components can be added without significant refactoring.
- **Reusability**: Components can be reused in different contexts.

In summary, tight coupling creates a rigid system where components are heavily interdependent, whereas loose coupling promotes a more modular, flexible, and maintainable system.****
****

### 2.What is Dependency?

- A **dependency** in software engineering is a relationship where one component or module relies on another to function. 
- Dependencies can be between classes, functions, modules, services, or even entire applications. 
- Managing dependencies is crucial for building maintainable, scalable, and flexible software.

#### Example of Dependency

Consider two classes, `Car` and `Engine`. The `Car` class depends on the `Engine` class to function:

```java
public class Engine {
    public void start() {
        System.out.println("Engine started");
    }
}

public class Car {
    private Engine engine;

    public Car() {
        this.engine = new Engine(); // Car depends on Engine
    }

    public void drive() {
        engine.start();
        System.out.println("Car is driving");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.drive();
    }
}
```

In this example, `Car` is tightly coupled to `Engine`, meaning `Car` directly creates an instance of `Engine` and relies on it to function.

### 3.What is Dependency Injection?

- **Dependency Injection (DI)** is a design pattern used to achieve Inversion of Control (IoC) between classes and their dependencies. 
- Instead of a class creating its dependencies, they are provided externally. 
- This promotes loose coupling and makes the code more modular, testable, and maintainable.

#### Example of Dependency Injection

Using the same `Car` and `Engine` example, but applying dependency injection:

1. **Define the Engine Interface:**

```java
public interface Engine {
    void start();
}
```

2. **Implement the Engine Interface:**

```java
public class PetrolEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Petrol engine started");
    }
}

public class DieselEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Diesel engine started");
    }
}
```

3. **Modify the Car Class to Use Dependency Injection:**

```java
public class Car {
    private Engine engine;

    // Constructor Injection
    public Car(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        System.out.println("Car is driving");
    }
}
```

4. **Inject Dependencies in the Main Method:**

```java
public class Main {
    public static void main(String[] args) {
        Engine petrolEngine = new PetrolEngine();
        Car carWithPetrolEngine = new Car(petrolEngine);
        carWithPetrolEngine.drive();

        Engine dieselEngine = new DieselEngine();
        Car carWithDieselEngine = new Car(dieselEngine);
        carWithDieselEngine.drive();
    }
}
```

### Benefits of Dependency Injection

1. **Loose Coupling:** By injecting dependencies, classes are less dependent on specific implementations, making the system more flexible.
2. **Testability:** Dependencies can be easily mocked or stubbed, making unit testing simpler and more effective.
3. **Maintainability:** Changes in dependencies require minimal changes in dependent classes.
4. **Reusability:** Components can be reused with different dependencies without modification.

### Types of Dependency Injection

1. **Constructor Injection:** Dependencies are provided through a class constructor.
    ```java
    public class Car {
        private Engine engine;

        public Car(Engine engine) {
            this.engine = engine;
        }
    }
    ```

2. **Setter Injection:** Dependencies are provided through setter methods.
    ```java
    public class Car {
        private Engine engine;

        public void setEngine(Engine engine) {
            this.engine = engine;
        }
    }
    ```

3. **Interface Injection:** Dependencies are provided through an interface. (Less common)
    ```java
    public interface Engine {
        void injectCar(Car car);
    }
    ```

### Conclusion

Dependency and Dependency Injection are core concepts in software design that promote modularity, flexibility, and testability. By externalizing the creation and management of dependencies, you can build more maintainable and adaptable software systems.
