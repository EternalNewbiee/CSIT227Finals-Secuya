public class Customer extends Person{
    public Customer(String name,int age){
        super(name,age);
    }
    @Override
    public String fullInfo() {
        return "cus," + super.fullInfo();
    }
}
