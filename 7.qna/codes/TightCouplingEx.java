package codes;

class B{
    public void doSomething(){
        System.out.println("Hello");
    }
}

public class TightCouplingEx {

    private B b = new B();
   
    public void execute() {
        b.doSomething();
    }

    public static void main(String[] args) {
        TightCouplingEx cp = new TightCouplingEx();
        cp.execute();
    }
    
}
