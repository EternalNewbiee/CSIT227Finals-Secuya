public class Manager extends Employee{
    public Manager(String name,int age, int months_worked, double salary){
        super(name,age,months_worked,salary);
    }
    @Override
    public String fullInfo() {
        return "man," + super.fullInfo();
    }

}
