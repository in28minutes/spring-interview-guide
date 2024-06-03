package codes.dependencyinjection;

//inject dependencies into the main method
public class Main {
    public static void main(String[] args) {
        Engine pe=new PetrolEngine();
        Car car=new Car(pe);
        car.drive();

        Engine de=new DieselEngine();
        Car car2=new Car(de);
        car2.drive();
    }
    
}
