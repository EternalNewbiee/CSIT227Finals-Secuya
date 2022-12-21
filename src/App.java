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
        tfMonths.setEditable(false);
        tfSalary.setEditable(false);
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
                try {
                    if (rbCustomer.isSelected()) {
                        String name = tfName.getText();
                        int age = Integer.parseInt(tfAge.getText());
                        if(age <= 0) throw (new Exception());
                        if( tfAge.getText().isEmpty() || tfName.getText().isEmpty()) throw (new Exception());
                        if( tfMonths.getText().isEmpty() == false||
                                tfSalary.getText().isEmpty() == false) throw (new Exception());
                        Person p = new Person(name, age);
                        taPersons.append("Customer - " + name + " (" + age + ")\n");
                        tfName.setText("");
                        tfAge.setText("");

                    }
                    if (rbClerk.isSelected()) {
                        String name = tfName.getText();
                        int age = Integer.parseInt(tfAge.getText());
                        int month_worked = Integer.parseInt(tfMonths.getText());
                        double salary = Double.parseDouble(tfSalary.getText());
                        if(age <= 0 || month_worked < 0 || salary < 0) throw (new Exception());
                        if( tfAge.getText().isEmpty() || tfName.getText().isEmpty() || tfMonths.getText().isEmpty() ||
                                tfSalary.getText().isEmpty()) throw (new Exception());
                        Clerk c = new Clerk(name, age, month_worked, salary);
                        taPersons.append("Clerk - " + name + " (" + age + ")\n");
                        tfName.setText("");
                        tfAge.setText("");
                        tfSalary.setText("");
                        tfMonths.setText("");
                    }
                    if (rbManager.isSelected()) {
                        String name = tfName.getText();
                        int age = Integer.parseInt(tfAge.getText());
                        int month_worked = Integer.parseInt(tfMonths.getText());
                        double salary = Double.parseDouble(tfSalary.getText());
                        if( tfAge.getText().isEmpty() || tfName.getText().isEmpty() || tfMonths.getText().isEmpty() ||
                                tfSalary.getText().isEmpty()) throw (new Exception());
                        if(age <= 0 || month_worked < 0 || salary < 0) throw (new Exception());
                        Manager m = new Manager(name, age, month_worked, salary);
                        taPersons.append("Manager - " + name + " (" + age + ") \n");
                        tfName.setText("");
                        tfAge.setText("");
                        tfSalary.setText("");
                        tfMonths.setText("");
                    }
                }catch (NumberFormatException num){
                    JOptionPane.showMessageDialog(null, "INVALID INPUT", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "INVALID INPUT", "ERROR", JOptionPane.ERROR_MESSAGE);
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
