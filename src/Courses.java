/*
 * JihoYoo(300813612)
 * November 20, 2015
 * Assignment 4 : GUI Application - Calculate the GPA
 */
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;


public class Courses {

	//PUBLIC VARIABLES+++++++++++++++++++++++++++++++++++++++
	public JLabel _courseNumLabel;
	public JTextField _courseCodeTextField;
	public int _courses;
	public JPanel _contentPanel;
	public String[] _gradeArray= {"A+ 90-100", "A:  80-89","B+ 75-79", "B:  70-74","C+ 65-69", "C:  60-64","D+ 55-59", "D:  50-54","F:  0-49"};
	public JComboBox<String> _hoursComboBox, 
	                         _gradeComboBox;
	
	
	//CONSTRUCTOR+++++++++++++++++++++++++++++++++++++++++++++++++++
	public Courses(JPanel contentPanel,int courses) {
		
		this._contentPanel=contentPanel;
		this._courseNumLabel=new JLabel();
		this._courses = courses;
		this._courseCodeTextField=new JTextField();
		this._hoursComboBox=new JComboBox<String>();
		this._gradeComboBox=new JComboBox<String>();
		this._initialize();
	}

	//INITIALIZE +++++++++++++++++++++++++++++++++++++++++++++
	private void _initialize()
	{
		//Location of courses ++++++++++++++++++++++++++++++++++++++++++++
		int location=85+this._courses*25;
		
		//Location of Course Number Label ++++++++++++++++++++++++++++++++++++++++++++
		this._courseNumLabel.setText(this._courses+"");
		this._courseNumLabel.setBounds(10,location,20,20);
		this._contentPanel.add(this._courseNumLabel);
		
		//Location of Course Code Text Field ++++++++++++++++++++++++++++++++++++++++++++
		this._courseCodeTextField.setBounds(50,location,75,20);
		this._courseCodeTextField.setBackground(new Color(0, 255, 255));
		this._contentPanel.add(this._courseCodeTextField);
		
		//Location of Credit Hours Combo Box ++++++++++++++++++++++++++++++++++++++++++++
		this._hoursComboBox.setBounds(200,location,75,20);
		this._hoursComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"2", "3", "4", "5"}));
		this._hoursComboBox.setBackground(new Color(0, 255, 255));
		this._contentPanel.add(this._hoursComboBox);
		
		//Location of Grades Combo Box ++++++++++++++++++++++++++++++++++++++++++++
		this._gradeComboBox.setBounds(350,location,100,20);
		this._gradeComboBox.setModel(new DefaultComboBoxModel<String>(_gradeArray));
		this._gradeComboBox.setBackground(new Color(0, 255, 255));
		this._contentPanel.add(this._gradeComboBox);
		
		//Update UI  ++++++++++++++++++++++++++++++++++++++++++++
		this._contentPanel.updateUI();
	}
}

