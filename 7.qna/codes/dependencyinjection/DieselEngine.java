package codes.dependencyinjection;

// implement the engine interfce
public class DieselEngine implements Engine{
    @Override
    public void start(){
        System.out.println("Diesel engine started");
    }
    
}
