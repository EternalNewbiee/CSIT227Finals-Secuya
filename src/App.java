import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.IllegalFormatFlagsException;
import java.util.List;

public class App extends JFrame{
    private JPanel pnlMain;
    private JRadioButton rbCustomer;
    private JRadioButton rbClerk;
    private JRadioButton rbManager;
    private JTextField tfName;
    private JTextArea taPersons;
    private JButton btnSave;
    private JTextField tfAge;
    private JTextField tfMonths;
    private JTextField tfSalary;
    private JButton btnClear;
    private JTextField tfLoad;
    private JButton btnLoad;
    private JButton btnSayHi;
    private JButton btnSavePerson;
    private JButton btnLoadPerson;
    private JButton btnReward;


    private List<Person> persons;

    public int index = 0;

    public App() {
        persons = new ArrayList<>();
        taPersons.setEditable(false);
        tfMonths.setEditable(false);
        tfSalary.setEditable(false);
        // TODO add implementations for all milestones here

        rbCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfName.setEditable(true);
                tfAge.setEditable(true);
                tfMonths.setEditable(false);
                tfSalary.setEditable(false);
                tfSalary.setText("");
                tfMonths.setText("");
            }
        });
        rbClerk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfName.setEditable(true);
                tfAge.setEditable(true);
                tfMonths.setEditable(true);
                tfSalary.setEditable(true);
            }
        });
        rbManager.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfName.setEditable(true);
                tfAge.setEditable(true);
                tfMonths.setEditable(true);
                tfSalary.setEditable(true);
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(numCheck(tfName.getText())) throw new Exception("Name Invalid");

                    if (rbCustomer.isSelected()) {
                        String name = tfName.getText();
                        int age = Integer.parseInt(tfAge.getText());
                        if(age <= 0) throw new Exception("INVALID AGE");
                        if( tfAge.getText().isEmpty() || tfName.getText().isEmpty()) throw new Exception("EMPTY TEXT FIELD");
                        Customer c = new Customer(name, age);
                        persons.add(c);
                        taPersons.append((index+1)+ ". Customer - " + name + " (" + age + ")\n");
                        tfName.setText("");
                        tfAge.setText("");
                        index++;
                    }
                    if (rbClerk.isSelected()) {
                        String name = tfName.getText();
                        int age = Integer.parseInt(tfAge.getText());
                        int month_worked = Integer.parseInt(tfMonths.getText());
                        double salary = Double.parseDouble(tfSalary.getText());
                        if(age <= 0) throw new Exception("INVALID AGE");
                        if(month_worked < 0 || salary < 0) throw new Exception("INVALID INPUT: NEGATIVE VALUES");
                        if( tfAge.getText().isEmpty() || tfName.getText().isEmpty() || tfMonths.getText().isEmpty() ||
                                tfSalary.getText().isEmpty()) throw new Exception("EMPTY TEXT FIELD");
                        Clerk c = new Clerk(name, age, month_worked, salary);
                        persons.add(c);
                        taPersons.append((index+1)+ ". Clerk - " + name + " (" + age + ")\n");
                        tfName.setText("");
                        tfAge.setText("");
                        tfSalary.setText("");
                        tfMonths.setText("");
                        index++;
                    }
                    if (rbManager.isSelected()) {
                        String name = tfName.getText();
                        int age = Integer.parseInt(tfAge.getText());
                        int month_worked = Integer.parseInt(tfMonths.getText());
                        double salary = Double.parseDouble(tfSalary.getText());
                        if(age <= 0) throw new Exception("INVALID AGE");
                        if(month_worked < 0 || salary < 0) throw new Exception("INVALID INPUT: NEGATIVE VALUES");
                        if( tfAge.getText().isEmpty() || tfName.getText().isEmpty() || tfMonths.getText().isEmpty() ||
                                tfSalary.getText().isEmpty()) throw new Exception("EMPTY TEXT FIELD");
                        Manager m = new Manager(name, age, month_worked, salary);
                        persons.add(m);
                        taPersons.append((index+1)+ ". Manager - " + name + " (" + age + ") \n");
                        tfName.setText("");
                        tfAge.setText("");
                        tfSalary.setText("");
                        tfMonths.setText("");
                        index++;
                    }
                }catch (NumberFormatException num){
                    JOptionPane.showMessageDialog(null, "INVALID INPUT", "ERROR", JOptionPane.ERROR_MESSAGE);
                    tfAge.setText("");
                    tfSalary.setText("");
                    tfMonths.setText("");
                    }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rbCustomer.setSelected(true);
                tfName.setEditable(true);
                tfAge.setEditable(true);
                tfMonths.setEditable(false);
                tfSalary.setEditable(false);
                tfName.setText("");
                tfAge.setText("");
                tfSalary.setText("");
                tfMonths.setText("");
            }
        });

        btnSayHi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Person p:persons) {
                    if(p instanceof Clerk){
                        Clerk cler = (Clerk) p;
                        cler = (Clerk) p;
                        cler.greet();
                        continue;
                    }
                   p.greet();
                }
            }
        });

        btnLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfName.setEditable(false);
                tfSalary.setEditable(false);
                tfAge.setEditable(false);
                tfMonths.setEditable(false);
                int ctr = 1;
                int pos = Integer.parseInt(tfLoad.getText());
                for(Person pip: persons){
                    if(pos==ctr){
                        tfName.setText(pip.getName());
                        String age = Integer.toString(pip.getAge());
                        tfAge.setText(age);
                        rbCustomer.setSelected(true);
                        if(pip instanceof Employee){
                            Employee emp = (Employee) pip;
                            String salary = Double.toString(emp.getSalary());
                            String months = Integer.toString(emp.getMonths_worked());
                            tfMonths.setText(months);
                            tfSalary.setText(salary);
                            if(pip instanceof Clerk) rbClerk.setSelected(true);
                            if(pip instanceof Manager) rbManager.setSelected(true);
                        }
                    }
                    ctr++;//
                }
            }
        });

        btnReward.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pos = Integer.parseInt(tfLoad.getText());
                giveReward(pos-1);
            }
        });

        btnSavePerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });

        btnLoadPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadFile();
            }
        });
    }

    public static void main(String[] args) {
        App app = new App();
        app.setContentPane(app.pnlMain);
        app.setSize(700, 700);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    void giveReward(int n) {
        try {
            Person person = persons.get(n);
            if(person instanceof Clerk) {
                Clerk clerk = (Clerk) person;
                if(clerk.getMonths_worked() == 0 ) throw new ArithmeticException();
                if(clerk.getMonths_worked() > 12) throw new Exception();
                JOptionPane.showMessageDialog(null, "Clerk " + clerk.getName() + " has been rewarded with " + String.format("%.2f", clerk.thirteenthmonth()));
            } else if(person instanceof Manager) {
                Manager manager = (Manager) person;
                if (manager.getMonths_worked() == 0 ) throw new ArithmeticException();
                JOptionPane.showMessageDialog(null, "Manager " + manager.getName() + " has been rewarded with " + String.format("%.2f", manager.thirteenthmonth()));
            } else {
                throw new IllegalArgumentException();
            }
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(null, "Invalid months");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Not an employee");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "There are only 12 months in a year dummy");
        }
    }
    void saveFile() {
        try(BufferedWriter file = new BufferedWriter(new FileWriter("persons.txt"))) {
          file.write(taPersons.getText());
        } catch (IOException e) {
        }

        try(BufferedWriter file = new BufferedWriter(new FileWriter("fullInfo.txt"))) {
            for(Person p: persons){
                if(p instanceof Manager){
                    Manager m = (Manager) p;
                    file.write(m.fullInfo());
                }
                if(p instanceof Clerk){
                    Clerk cler = (Clerk) p;
                    file.write(cler.fullInfo());
                }
                if(p instanceof Customer){
                    Customer c = (Customer) p;
                    file.write(c.fullInfo());
                }
                file.newLine();
            }
        } catch (IOException e) {
        }
    }
    void loadFile() {
        try(BufferedReader file = new BufferedReader(new FileReader("persons.txt"))) {
            String str = file.readLine();
            while(str != null){
                taPersons.append(str + "\n");
                str = file.readLine();
            }

        } catch (IOException e) {
        }
        try(BufferedReader file = new BufferedReader(new FileReader("fullInfo.txt"))) {
            String str = file.readLine();
            while(str != null){
                String[] ln = str.split(",");
                String name = ln[0];
                if(ln[0].equals("cus")){
                    Customer marion = new Customer(ln[1],Integer.parseInt(ln[2]));
                    persons.add(marion);
                }
                if(ln[0].equals("man")){
                    Manager josh = new Manager(ln[1],Integer.parseInt(ln[2]),Integer.parseInt(ln[2]),Double.parseDouble(ln[3]));
                    persons.add(josh);
                }
                if(ln[0].equals("clerk")){
                    Clerk cc = new Clerk(ln[1],Integer.parseInt(ln[2]),Integer.parseInt(ln[2]),Double.parseDouble(ln[3]));
                    persons.add(cc);
                }
                str = file.readLine();
            }
        } catch (IOException e) {
        }
    }
    boolean numCheck(String n){
        try{
            int num = Integer.parseInt(n);
        }catch(Exception e){
            return false;
        }
        return true;
    }
}
