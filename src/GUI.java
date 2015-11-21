/*
 * JihoYoo(300813612)
 * November 20, 2015
 * Assignment 4 : GUI Application - Calculate the GPA
 */
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame implements ActionListener{

	//PRIVATE VARIABLES+++++++++++++++++++++++++++++++++
	private JPanel _contentPanel;
	private JLabel _creditHoursEarnedLabel, 
	               _currentGPALabel, 
	               _numberOfCoursesLabel,
	               _courseNumLabel,
	               _courseCodeLabel,
	               _creditComboLabel,
	               _gradeLabel,
	               _newGPALabel;
	private JTextField _creditHoursEarnedTextField, 
	                   _currentGPATextField;
	private JComboBox<String> _numberOfCoursesComboBox;
	private JButton _calculateButton;
	private String[] _numberOfCourses;
	private ArrayList<Courses> _coursesArrayList;
	private int _currentNumCourses;
	
	private double[] _gradeArray= {4.5,4.0,3.5,3.0,2.5,2.0,1.5,1.0,0.0};
	
	//PUBLIC VARIABLES +++++++++++++++++++++++++++++++++++
	public int _hours,_totalCreditHours,
	   		   _gradeIndex,
	   		   _totalGPA,
	   		   _currentHours;
		   double currentGPA,
		          grade,	        	  
		          _gpa;
		   
	// CONSTRUCTOR +++++++++++++++++++++++++++++++++++++++++++++++
	public GUI() {
		setTitle("GPA Calculator");
		this._initialize();
		this._coursesArray();
		this._addComponents();	
		
	}
	
	// INITIALIZE +++++++++++++++++++++++++++++++++++++++++++
	private void _initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 380);			
		this.setResizable(false);
		this._contentPanel = new JPanel();
		this._contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this._contentPanel);
		
		//Set Window Location ++++++++++++++++++++++++++++++++++++++++++++++
		this._contentPanel.setLayout(null);			
		this.setLocationRelativeTo(null);
		
	}
	
	//Add Labels and text fields ++++++++++++++++++++++++++++++++++++++++++++++
		private void _addComponents() {	
			
			//Credit Hours Earned Label +++++++++++++++++++++++
			this._creditHoursEarnedLabel= new JLabel("Credit Hours Earned:");
		    this._creditHoursEarnedLabel.setBounds(10, 13, 150, 15);
			this._contentPanel.add(this._creditHoursEarnedLabel);
			
			//Credit Hours Earned Text Field +++++++++++++++++++++++
			this._creditHoursEarnedTextField = new JTextField(_currentHours+"");
			this._creditHoursEarnedTextField.setBackground(new Color(0, 255, 255));
			this._creditHoursEarnedTextField.setBounds(168, 10, 60, 20);
			this._contentPanel.add(this._creditHoursEarnedTextField);
			
			//Current GPA Label +++++++++++++++++++++++
			this._currentGPALabel = new JLabel("Current GPA:");
			this._currentGPALabel.setBounds(245, 13, 150, 15);
			this._contentPanel.add(this._currentGPALabel);
			
			//Current GPA Text Field +++++++++++++++++++++++
			this._currentGPATextField = new JTextField(""+currentGPA);
			this._currentGPATextField.setBackground(new Color(0, 255, 255));
			this._currentGPATextField.setBounds(360, 10, 100, 20);
			this._contentPanel.add(this._currentGPATextField);
			
			//Number of Courses Label +++++++++++++++++++++++
			this._numberOfCoursesLabel = new JLabel("Number of Courses:");
			this._numberOfCoursesLabel.setBounds(245, 44, 160, 15);
			this._contentPanel.add(this._numberOfCoursesLabel);
			
			//Number of Courses ComboBox +++++++++++++++++++++++
			this._numberOfCoursesComboBox = new JComboBox<String>();
			this._numberOfCoursesComboBox.setModel(new DefaultComboBoxModel(this._numberOfCourses));
			this._numberOfCoursesComboBox.setSelectedIndex(this._currentNumCourses);
			this._numberOfCoursesComboBox.setBounds(410, 41, 50, 20);
			this._numberOfCoursesComboBox.setBackground(new Color(0, 255, 255));
			this._contentPanel.add(this._numberOfCoursesComboBox);
			
			//Course Number Label ++++++++++++++++++++++++++++++++++++++++++++++
			this._courseNumLabel= new JLabel("Nr:");
			this._courseNumLabel.setBounds(10,85,20,20);
			this._contentPanel.add(this._courseNumLabel);
			
			//Course Code Label ++++++++++++++++++++++++++++++++++++++++++++++
			this._courseCodeLabel= new JLabel("Course Code:");
			this._courseCodeLabel.setBounds(50,85,80,20);
			this._contentPanel.add(this._courseCodeLabel);
			
			//Credit Hours Label ++++++++++++++++++++++++++++++++++++++++++++++
			this._creditComboLabel= new JLabel("Credit Hours:");
			this._creditComboLabel.setBounds(200,85,75,20);
			this._contentPanel.add(this._creditComboLabel);
			
			//Grades Label ++++++++++++++++++++++++++++++++++++++++++++++
			this._gradeLabel= new JLabel("Grade:");
			this._gradeLabel.setBounds(350,85,75,20);
			this._contentPanel.add(this._gradeLabel);
			
			//Event Handler ++++++++++++++++++++++++++++++++++++++++++++++++
			this._numberOfCoursesComboBox.addActionListener(this);
			
			
			
		}
		// Courses Array ++++++++++++++++++++++++++++++++++++++++++++++
	private void _coursesArray() {
		
		this._numberOfCourses = new String[5]; //show up to 5 courses
		
		for(int count=0; count < this._numberOfCourses.length; count++) {
			this._numberOfCourses[count]= count + 1 + "";
		}
	}

	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource()==this._numberOfCoursesComboBox)
		{
			
			//New Array List ++++++++++++++++++++++++++++++++++++++++++++++++
			this._coursesArrayList = new ArrayList<Courses>();
			this._currentNumCourses = this._numberOfCoursesComboBox.getSelectedIndex();
			int index;
			
			//Validate current credit hours and current GPA text fields
			this._validateInput();
			this._contentPanel.removeAll();
			this._addComponents();
			
			
			//Courses Array List ++++++++++++++++++++++++++++++++++++++++++++++++
			for(index = 0; index <= this._currentNumCourses; index++) {
				this._coursesArrayList.add(new Courses(this._contentPanel,index+1));					
			}
			
			//Add Result of GPA+++++++++++++++++++++++++++++++++++++++++++++++++++++++
			this._addResult();
			
			//Add Calculate Button++++++++++++++++++++++++++++++++++++++++++++++++++++
			this._addCalculateButton();
			
			this._contentPanel.updateUI();
		}	
		
		if(event.getSource()==this._calculateButton)
		{
			int i;
			_totalGPA=0;
			_totalCreditHours=0;
				
			//Calculate total hours and total quality points
			for(i=0;i<=this._currentNumCourses;i++)
			{
				//Get credit hours for each course
				_hours=Integer.parseInt(this._coursesArrayList.get(i)._hoursComboBox.getSelectedItem()+"");
				//Total hours +++++++++++++++++++++++++++++++++++++++++++
				_totalCreditHours+=_hours;
				
				//Get grade index for each course ++++++++++++++++++++++++++++
				_gradeIndex=this._coursesArrayList.get(i)._gradeComboBox.getSelectedIndex();
				//Get points for grade obtained ++++++++++++++++++++++++++++
				grade=this._gradeArray[_gradeIndex];
				_totalGPA+=_hours*grade;
			}	
			
			this._validateInput();
			
			_totalCreditHours+=_currentHours;
			_totalGPA+=currentGPA*_currentHours;
			this._gpa=(double)_totalGPA/_totalCreditHours;
			
			//Result of GPA ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			this._newGPALabel.setText(String.format("Your GPA is: %.2f",this._gpa));
			
			this._contentPanel.updateUI();
		}
	}

	private void _validateInput() {
		
		try {
			_currentHours=Integer.parseInt(this._creditHoursEarnedTextField.getText());
			
		} catch (Exception e) {
			this._creditHoursEarnedTextField.setText("0");
			_currentHours=0;
		}
		try {
			currentGPA=Double.parseDouble(this._currentGPATextField.getText());
			
		} catch (Exception e) {
			this._currentGPATextField.setText("0");
			currentGPA=0;
		}
	}

	//Add Result +++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private void _addResult() {
		
		//Result of GPA
		this._newGPALabel=new JLabel(String.format("Your GPA is: %.2f",this._gpa));
		this._newGPALabel.setBounds(175,300,150,20);
		this._contentPanel.add(this._newGPALabel);
		
		
	}
	//Add Calculate Button +++++++++++++++++++++++++++++++++++++++++++++++++
	private void _addCalculateButton(){
	//Calculate Button +++++++++++++++++++++++++++++++++++++++++++
				this._calculateButton=new JButton("Calculate");
				this._calculateButton.setBounds(350,250,100,20);
				this._contentPanel.add(this._calculateButton);
				this._calculateButton.addActionListener(this);
	}
}

