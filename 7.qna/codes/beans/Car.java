package codes.beans;

public class Car {
    private Engine engine;

    public Car(Engine engine){
        this.engine = engine;
    }

    public void drive(){
        engine.start();
        System.out.println("car is driving");
    }
    
}
