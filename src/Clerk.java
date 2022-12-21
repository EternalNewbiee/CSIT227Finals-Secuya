public class Clerk extends Employee{
    public Clerk(String name,int age, int months_worked, double salary){
        super(name,age,months_worked,salary);
    }
    @Override
    public void greet() {
        System.out.println("Hello my name is " + super.getName()+ " How may I help you?");
    }
    public String fullInfo() {
        return "clerk," + super.fullInfo();
    }

}
