import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Collections;

/**
 * StudentRegistrationFrame.java
 * This is a class that builds the frame of the main app
 */
public class StudRegGui extends JFrame {

    private static ArrayList<Graduate> graduates;
    private final int TEXTFIELD_LENGTH = 13;
    private JButton addBtn;
    private JButton sortBtn;
    private JButton displayBtn;
    private JTextField idTextField;
    private JTextField surnameTextField;
    private JTextField qualificationTextField;
    private JTextField feeTextField;
    private JComboBox<String> qualificationsComboBox;
    private String[] qualificationsArray = {"NDIPIT", "NCINT", "NDINFT", "None"};

    public StudRegGui() {
        super("STUDENT REGISTRATION");

        setLayout(new GridLayout(3, 1, 1, 3));

        // initializing textFields
        idTextField = new JTextField(TEXTFIELD_LENGTH);
        surnameTextField = new JTextField(TEXTFIELD_LENGTH);
        qualificationTextField = new JTextField(TEXTFIELD_LENGTH);
        feeTextField = new JTextField(TEXTFIELD_LENGTH);

        // creating the graduates list
        graduates = new ArrayList<>();

        // creating the comboBox for qualifications
        qualificationsComboBox = new JComboBox<>(qualificationsArray);
        qualificationsComboBox.setMaximumRowCount(3); // display three rows

        // event handling for combo box
        qualificationsComboBox.addItemListener(i -> {
            if (i.getStateChange() == ItemEvent.SELECTED) {
                if (i.getItem().equals(qualificationsArray[0])) {
                    qualificationsComboBox.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(this, "National Diploma in Information Technology");
                } else if (i.getItem().equals(qualificationsArray[1])) {
                    qualificationsComboBox.setSelectedIndex(1);
                    JOptionPane.showMessageDialog(this, "National Certificate in Information Technology");
                } else if (i.getItem().equals(qualificationsArray[2])) {
                    qualificationsComboBox.setSelectedIndex(2);
                    JOptionPane.showMessageDialog(this, "National Doctorate in Information Technology");
                } else {
                    qualificationsComboBox.setSelectedIndex(3);
                    JOptionPane.showMessageDialog(this, "None");
                }
            }


        });


        add(createPanel("STUDENT", idTextField, surnameTextField, "ID:", "Surname:"));

        add(createPanel("GRADUATE", qualificationsComboBox, feeTextField, "Qualification:", "Fee:"));

        // Operations panel
        JPanel operationsPanel = new JPanel(new GridLayout(1, 3));
        operationsPanel.setBorder(BorderFactory.createTitledBorder("OPERATIONS"));

        addBtn = new JButton("ADD");
        addBtn.addActionListener((event) -> {
            String id = idTextField.getText();
            String surname = surnameTextField.getText();
            String qualification = qualificationsComboBox.getSelectedItem().toString();
            double fee = Double.parseDouble(feeTextField.getText());

            graduates.add(new Graduate(id, surname, 0, qualification, fee)); // adding graduate student to the list

            // empty the fields
            idTextField.setText("");
            surnameTextField.setText("");
//            qualificationTextField.setText("");
            qualificationsComboBox.setSelectedIndex(0);
            feeTextField.setText("");
        });

        sortBtn = new JButton("SORT");
        sortBtn.addActionListener(e ->
                Collections.sort(graduates)
        );


        displayBtn = new JButton("DISPLAY");
        displayBtn.addActionListener((e -> {
            String strGraduates = "";

            for (Graduate g : graduates) {
                strGraduates += String.format("%s\n", g);
            }

            JOptionPane.showMessageDialog(this, strGraduates);
        }));

        // adding components to the frame
        operationsPanel.add(addBtn);
        operationsPanel.add(sortBtn);
        operationsPanel.add(displayBtn);

        add(operationsPanel);
    }


    private JPanel createPanel(String legend, JComponent jComponent1, JComponent jComponent2, String strLabel1, String strLabel2) {
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 3, 1));

        // setting border of mainPanel
        TitledBorder titledBorder = new TitledBorder(legend);
        mainPanel.setBorder(titledBorder);

        // first sub-panel
        JPanel panel1 = new JPanel(new GridLayout(1, 2, 5, 1));

        JLabel label1 = new JLabel(strLabel1);

        panel1.add(label1);
        panel1.add(jComponent1);

        // second sub-panel
        JPanel panel2 = new JPanel(new GridLayout(1, 2, 5, 1));

        JLabel label2 = new JLabel(strLabel2);

        panel2.add(label2);
        panel2.add(jComponent2);

        // adding sub-panels to mainPanel
        mainPanel.add(panel1);
        mainPanel.add(panel2);

        return mainPanel;
    }

    public void createAndShowFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(540, 300);
        this.setVisible(true);
    }

}
