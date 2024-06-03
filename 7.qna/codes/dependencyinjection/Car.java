package codes.dependencyinjection;

// modify the car class to use the dependency injection
public class Car {
    // instance var
    private Engine engine;

    // param constructor
    // constructor injection
    public Car(Engine engine){
        this.engine=engine;
    }
    
    public void drive(){
        engine.start();
        System.out.println("Car is driving.");
    }
}
