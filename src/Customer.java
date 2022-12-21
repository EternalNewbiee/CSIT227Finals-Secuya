public class Customer extends Person{
    public Customer(String name,int age){
        super(name,age);
    }

    @Override
    public void greet() {
        super.greet();
        System.out.println("How may I help you?");
    }
}
