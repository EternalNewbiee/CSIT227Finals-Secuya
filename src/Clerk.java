public class Clerk extends Employee{
    public Clerk(String name,int age, int months_worked, double salary){
        super(name,age,months_worked,salary);
    }
    @Override
    public void greet() {
        super.greet();
        System.out.println("How may I help you?");
    }
}
