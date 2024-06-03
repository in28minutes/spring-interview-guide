package codes;

interface Service{
    void doSomething();
}

class B1 implements Service{
    @Override
    public void doSomething(){
        System.out.println("Hi from class b");
    }
}

public class LooseCouplingEx {
    private Service service;
    
    public LooseCouplingEx(Service service){
        this.service = service;
    }

    public void execute(){
        service.doSomething();
    }

    public static void main(String[] args) {
        // Using the loosely coupled setup
        // A depends on an interface Service rather than a concrete class B
        // You can change the implementation of B or use a different implementation of Service without changing A
        Service b=new B1();
        LooseCouplingEx ls=new LooseCouplingEx(b);
        ls.execute();

    }
}
