package codes.dependencyinjection;

// implement the engine interface
public class PetrolEngine implements Engine{
    @Override
    public void start(){
        System.out.println("Petrol engine started");
    }
    
}
