import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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

    public App() {
        persons = new ArrayList<>();
        // TODO add implementations for all milestones here
        rbCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfMonths.setEditable(false);
                tfSalary.setEditable(false);
            }
        });
        rbClerk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfMonths.setEditable(true);
                tfSalary.setEditable(true);
            }
        });
        rbManager.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfMonths.setEditable(true);
                tfSalary.setEditable(true);
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (rbCustomer.isSelected()){
                   String name = tfName.getText();
                   int age = Integer.parseInt(tfAge.getText());
                   Person p = new Person(name,age);
                   taPersons.append("Customer - " + name + " (" + age + ")\n");
                   tfName.setText("");
                   tfAge.setText("");
               }
               if (rbClerk.isSelected()){
                   String name = tfName.getText();
                   int age = Integer.parseInt(tfAge.getText());
                   int month_worked = Integer.parseInt(tfMonths.getText());
                   double salary = Double.parseDouble(tfSalary.getText());
                   Clerk c = new Clerk(name,age,month_worked,salary);
                   taPersons.append("Clerk - " + name + " (" + age + ")\n");
                   tfName.setText("");
                   tfAge.setText("");
                   tfSalary.setText("");
                   tfMonths.setText("");
               }
                if (rbManager.isSelected()){
                    String name = tfName.getText();
                    int age = Integer.parseInt(tfAge.getText());
                    int month_worked = Integer.parseInt(tfMonths.getText());
                    double salary = Double.parseDouble(tfSalary.getText());
                    Manager m = new Manager(name,age,month_worked,salary);
                    taPersons.append("Manager - " + name + " (" + age + ") \n");
                    tfName.setText("");
                    tfAge.setText("");
                    tfSalary.setText("");
                    tfMonths.setText("");
                }

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

    static void giveReward(int n) {

    }
}
