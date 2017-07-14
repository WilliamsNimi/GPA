package gpa;
/*
 * Program Author: NegusNimiWilliams
 * This a GPA application that calculates, and displays grade point average.It also takes certain course details 
 * and displays them on the screen for the user to see. 
 * Further functionality includes deleting courses entered by mistake and ability to load files from a database or 
 * text file as well as been able to save files to text file or database
 * */
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UserInterface extends JFrame{
    
    Container container = getContentPane();
    GridBagConstraints object = new GridBagConstraints();
    
    public static JLabel courseTitle, courseGrade, courseScore, creditUnit, courseDetailsLabel;
    public static JTextField courseTitleTF, courseGradeTF, courseScoreTF, creditUnitTF;
    public static JButton add, calculate;
    AddButtonHandler addHandler;
    CalculateButtonHandler calculateHandler;
    static int qualityPointsSum = 0; 
    static int creditUnitSum = 0;
    static char grade;
    static int credUnit = 0;
    int verticalPosition = 0;
    double gpa2 = 0;

    static UserInterface UI = new UserInterface();
    static Calculate calc = new Calculate();

    //constructor instatiates the individual components of the UI
    public UserInterface(){
        container = getContentPane();
        object = new GridBagConstraints();
        container.setBackground(Color.LIGHT_GRAY);
        container.setLayout(new GridBagLayout());
        object.insets = new Insets(5,5,0,0);
        
        courseTitle = new JLabel("Course Title");
        object.gridx = 0;
        object.gridy = 0;
        container.add(courseTitle, object);
        
        courseGrade = new JLabel("Course Grade");
        object.gridx = 0;
        object.gridy = 1;
        container.add(courseGrade, object);
        
        courseScore = new JLabel("Course Score");
        object.gridx = 0;
        object.gridy = 2;
        container.add(courseScore, object);
        
        creditUnit = new JLabel("Credit Unit");
        object.gridx = 0;
        object.gridy = 3;
        container.add(creditUnit, object);
        
        courseTitleTF = new JTextField(10);
        object.gridx = 1;
        object.gridy = 0;
        container.add(courseTitleTF, object);
        
        courseGradeTF = new JTextField(10);
        object.gridx = 1;
        object.gridy = 1;
        container.add(courseGradeTF, object);
        
        courseScoreTF = new JTextField(10);
        object.gridx = 1;
        object.gridy = 2;
        container.add(courseScoreTF, object);
        
        creditUnitTF = new JTextField(10);
        object.gridx = 1;
        object.gridy = 3;
        container.add(creditUnitTF, object);
        
        add = new JButton("Add");
        object.gridx = 0;
        object.gridy = 4;
        container.add(add, object);
        addHandler = new AddButtonHandler();
        add.addActionListener(addHandler);
        
        calculate = new JButton("Calculate");
        object.gridx = 1;
        object.gridy = 4;
        container.add(calculate, object);
        calculateHandler = new CalculateButtonHandler();
        calculate.addActionListener(calculateHandler);
        
        
        setSize(700,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("GPA");
        setResizable(true);
        
    }
    
    
    //add button accumulates the individual values of the coursegrades and creditUnits
    public class AddButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            grade = courseGradeTF.getText().charAt(0);
            credUnit = Integer.parseInt(creditUnitTF.getText());
            qualityPointsSum += calc.qualityPoint(grade, credUnit);
            creditUnitSum += credUnit;
            
            
            String courseDetails = courseTitleTF.getText()+" "+ courseGradeTF.getText() + " "+ courseScoreTF.getText()+ " "+creditUnitTF.getText();
            courseDetailsLabel = new JLabel(courseDetails);
            object.gridx = 2;
            object.gridy = verticalPosition;
            container.add(courseDetailsLabel, object);
            verticalPosition += 1;
            UI.validate();
        }
        
    }
    
    //calculates and displays the GPA
    public class CalculateButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            double gpa  = calc.GPA(qualityPointsSum, creditUnitSum);
            String result = "GPA: " + gpa + "\nQuality Points: " + qualityPointsSum + "\nTotal Credit Unit: " + creditUnitSum;
            JOptionPane.showMessageDialog(null, result, "GPA", JOptionPane.INFORMATION_MESSAGE );
        }
        
    }
    
    //Add course delete functionality, to allow for correction of mistakes
    
    public static void main(String[] args) {
        UI.setVisible(true);
    }

}
