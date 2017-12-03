import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;

//import com.michaelbaranov.microba.calendar.DatePicker;
//import com.michaelbaranov.microba.calendar.DatePickerCellEditor;


import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.awt.*;
import java.awt.event.*;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
public class addd extends JFrame{
	private static JFrame frame;
	private static JPanel panel;
	private static JLabel lb1,lb2,lb3,lb4;
	private static JTextField txt_1,txt_2;
	private static JButton b,b2,b3;
	private static JComboBox cmb1,cmb2;
	
	JPanel p1,p2,p3,p4,p5,p6;
	
	addd() {
	 
		frame =new JFrame();
	    p1=new JPanel();
	    p2=new JPanel();
	    p3=new JPanel();
	    p4=new JPanel();
	    p5=new JPanel();
	    p6=new JPanel();
	    lb1=new JLabel("EventName");
		lb2=new JLabel("Category");
		lb3=new JLabel("Subject");
		lb4=new JLabel("Priority");
		txt_1=new JTextField(15);
		txt_2=new JTextField(15);
		String str1[]={"Private","Professional"};
		String str2[]={"1","2","3","4","5"};
		cmb1=new JComboBox(str1);
		cmb2=new JComboBox(str2);
         b2=new JButton("CLOSE");
         b3=new JButton("ADD");
        // b=new JButton("DataPicker");
         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frame.getContentPane().setLayout(new BorderLayout());

JPanel p=new JPanel();

//p.add(p,BorderLayout.CENTER);

p1.add(lb1);
p1.add(txt_1);
p.add(p1,BorderLayout.NORTH);
p2.add(lb2);
p2.add(cmb1);
p.add(p2,BorderLayout.NORTH);
p3.add(lb3);
p3.add(txt_2);
p.add(p3,BorderLayout.NORTH);
p4.add(lb4);
p4.add(cmb2);
p.add(p4,BorderLayout.NORTH);
p5.add(buildDatePicker());
p.add(p5,BorderLayout.NORTH);
p6.add(b2);
p6.add(b3);
p.add(p6,BorderLayout.NORTH);
getContentPane().add(p);
setSize(300,300);
setVisible(true);
b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
	     
           setVisible(false);
	}
	
});
b3.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent arg0) {
  add dp= new add();
   
}

});

	}





private JComponent buildDatePicker() {
		JPanel panel = new JPanel();
		final DatePicker datePicker = new DatePicker();
		datePicker.setDateFormat(SimpleDateFormat.getDateTimeInstance());
	//datePicker.setEnabled(false);
		datePicker.setKeepTime(true);
		//datePicker.setStripTime(false);
		//datePicker.setShowNumberOfWeek(true);

	Map ov = new HashMap();


		//datePicker.setColorOverrideMap(ov);

		panel.setLayout(new GridBagLayout());
		//panel.add(datePicker, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
			//	GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
				//5, 5, 5, 5), 0, 0));

		//datePicker.addActionListener(new ActionListener() {

		//	public void actionPerformed(ActionEvent e) {
			//	System.out.println(""+ txt_1.getText()+","+ cmb1.getSelectedItem().toString()+"," + txt_2.getText()+","+ cmb2.getSelectedItem().toString()+"," + datePicker.getDate());
			}
	//	});

	//	return panel;

	//}

/*	private JComponent buildCellEditor() {
		JPanel panel = new JPanel();
		DatePicker datePicker = new DatePicker();

		datePicker.setDropdownFocusable(true);

		DatePickerCellEditor cellEditor = new DatePickerCellEditor(datePicker);
		cellEditor.setClickCountToStart(2);

		panel.setLayout(new GridBagLayout());
		return panel;
   }
 */
	 	
 public static void main(String[] args)
 {
	 addd dp =new addd();
	 //dp.add();
 }
}