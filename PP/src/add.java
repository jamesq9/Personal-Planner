import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

//import com.michaelbaranov.microba.calendar.DatePicker;
public class add extends JFrame{
  public static void main(String[] args)
  {
	  new add().setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
     
	private static final long serialVersionUID = 65L;
	
	private JLabel lb1,lb2,lb3,lb4,lb5,lb6,notes;
	
	private static JTextField txt_1;
	//final DatePicker datePicker = new DatePicker();
	private static JTextField txt_2;
	private static JTextArea txta;
	private static JComboBox<String> cmb1;
	private static JComboBox<String> cmb2;
	private static JScrollPane sp;
	private static JButton b1;
	private DatePicker dp;
	
	private static JButton b2;
    private static JSpinner spinner;
	private String str1[] = {"Personal","Private"};
	private String str2[] = {"1","2","3","4","5"};
	private BorderLayout borderlayout;
	private FlowLayout flowlayout;
	
 add()
 {
	  
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
	
		setSize(350,320);
		setTitle("Add Events");
		setResizable(false);
		AddingComponents();


		
b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			//	if(!check()) {
				//	return;
				//}
				
				
				//Calendar date =null  ;
				String eventname =  txt_1.getText();
				String subject =  txt_2.getText();
				String category= cmb1.getSelectedItem().toString();
				String priority = cmb2.getSelectedItem().toString();
//java.util.Date  date=  dp.getDate();
   
					int day,mon,year;
				Calendar cal = Calendar.getInstance();
//				cal.setTime(date);
				day = cal.get(Calendar.DAY_OF_MONTH);
				  mon = cal.get(Calendar.MONTH)+1;
				  year = cal.get(Calendar.YEAR);
 int sec,min,hour;
				  sec = cal.get(Calendar.SECOND);
				  min = cal.get(Calendar.MINUTE);
				  hour = cal.get(Calendar.HOUR_OF_DAY);
			
  
//	Statement stm = conn.createStatement();
				String sql = "insert into table_name values ('"+eventname+"','"+subject+"','"+category+"','"+priority+"',''"+txta.getText()+"'','"+day+"/"+mon+"/"+year+" "+hour+":"+min+":"+sec+"')";
//					
//		int rs = stm.executeUpdate(sql);
System.out.println(sql);	
//	if(rs==0) {
				//	PP.throwError("Error", "Unable Failed To Update");
//	} else {
				//	JOptionPane.showMessageDialog (null, "You Have Been Registered .", "Welcome", JOptionPane.INFORMATION_MESSAGE);
//	}
				//stm.close();
				//conn.close();
				
			}

			private boolean check() {
				if(txt_1.getText().length() ==0) {
					PP.throwError("Error!!", "EventField Field Can't be Empty");
					return false;
				}
				
				
				if(txt_2.getText().length() == 0) {
					PP.throwError("Error!!", "Subject Field is Empty!!");
					return false;
				}
				
				return true;
			}
		});
		
b2.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		  setVisible(false);  	
	}
});



setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
 }
 
 /*
 private JComponent buildDatePicker() {
		JPanel panel = new JPanel();
		final DatePicker datePicker = new DatePicker();
		datePicker.setDateFormat(SimpleDateFormat.getDateTimeInstance());
	datePicker.setEnabled(false);
		datePicker.setKeepTime(true);
		datePicker.setStripTime(false);
		datePicker.setShowNumberOfWeek(true);

	//Map ov = new HashMap();


		//datePicker.setColorOverrideMap(ov);

		panel.setLayout(new GridBagLayout());
		panel.add(datePicker, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						5, 5, 5, 5), 0, 0));

		datePicker.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//System.out.println("  datePicker.getDate()");
			}
		});

		return panel;

	}
 */
 /*public static  JSpinner JSpinnerTimeForm() {
	        
	        JSpinner spinner = new JSpinner();
	        spinner.setModel(new SpinnerDateModel());
	        spinner.setEditor(new JSpinner.DateEditor(spinner, "HH:mm:ss"));
	
	     	return spinner;
	    }
	 
	public static  JSpinner JSpinnerDateForm() {
	        
	        JSpinner spin = new JSpinner();
	        spin.setModel(new SpinnerDateModel());
	        spin.setEditor(new JSpinner.DateEditor(spin, "dd-MMM-YYYY"));
			JPanel panel = new JPanel();
			final DatePicker datePicker = new DatePicker();
			datePicker.setDateFormat(SimpleDateFormat.getDateInstance());
		datePicker.setEnabled(false);
	//	datePicker.setKeepTime(true);
		//datePicker.setStripTime(false);
		datePicker.setShowNumberOfWeek(true);

	Map ov = new HashMap();


		datePicker.setColorOverrideMap(ov);

		panel.setLayout(new GridBagLayout());
		panel.add(datePicker, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
				5, 5, 5, 5), 0, 0));
		datePicker.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("  datePicker.getDate()");
			}
		});

   //return panel;
	     	return spin;
	    }
	 */
	
	
		private void AddingComponents() {
			// TODO Auto-generated method stub
	JPanel p,p1,p2,p3,p4,p5,p7,p6,note;
			
			borderlayout = new BorderLayout();
			flowlayout = new FlowLayout();
			flowlayout.setAlignment(FlowLayout.LEADING);
			setLayout(borderlayout);
			
			setBackground(Color.magenta);
			p1=new JPanel();
			lb1 = new JLabel("EventName :  ");
			txt_1 = new JTextField(20);
			p1.add(lb1);
			p1.add(txt_1);
 			 			
			p2=new JPanel();
			lb2 = new JLabel("Category :   ");
			cmb1 = new JComboBox<String>(str1);
			p2.add(lb2);
			p2.add(cmb1);
			
			
			
			p3=new JPanel();
			lb2 = new JLabel("Subject :         ");
			txt_2 = new JTextField(20);
			p3.add(lb2);
			p3.add(txt_2);
			
			
			p4=new JPanel();
			lb4 = new JLabel("Priority : "); 
			cmb2 = new JComboBox<String>(str2);
			p4.add(lb4);
			p4.add(cmb2);
			
			
			note =new JPanel();
			notes=new JLabel("Notes :            ");
			//sp =new JScrollPane();
			txta =new JTextArea(5,30);
			//txta.setEditable(false);
			note.add(notes);
			sp= new JScrollPane(txta);
	//		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	       sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			note.add(sp);
			
			
			
			
			
			/*p5=new JPanel();
			lb5=new JLabel("Time :             ");
			spinner=new JSpinner();
			p5.add(lb5);
		    p5.add(buildDatePicker());
			*/
			
		    p7=new JPanel();
			lb6=new JLabel("Date :             ");
			spinner=new JSpinner();
			p7.add(lb6);
			dp = new DatePicker();
	//		p7.add(dp);
			dp.setDateFormat(SimpleDateFormat.getDateTimeInstance(1,1));
				dp.setKeepTime(true);
		//		dp.setStripTime(false);
		//		dp.setShowNumberOfWeek(true);

	//		p7.add(JSpinnerDateForm());
						
			p6=new JPanel();
			b1 = new JButton("Add");
			b2 = new JButton("Close");
			p6.add(b1);
			p6.add(b2);
			//add(p6);
			
			
			p=new JPanel();
			p.setLayout(flowlayout);
			p.add(p1);
			p.add(p3);
			p.add(p2);
			p.add(p4);
	        p.add(note);
			p.add(p7);
			//p.add(p5);
			add(p, BorderLayout.CENTER);
			add(p6, BorderLayout.SOUTH);

		
	}  

		

 }
  
  
