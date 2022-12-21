public class Person {
    // TODO implement Person and its subclasses in other Java files
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String fullInfo(){
        return (name+","+ age);
    }
    public void greet(){
        System.out.println("Hello my name is " + this.name);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
