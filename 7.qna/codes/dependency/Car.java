package codes.dependency;

public class Car {
    //private instance var of type Engine
    private Engine engine;

    //constructor of the car class w/ new instance if Engine class
    public Car(){
        this.engine=new Engine();
    }

    public void execute(){
        engine.start();
        System.out.println("Car is driving.");
    }

}
