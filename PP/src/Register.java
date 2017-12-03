import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Register extends JFrame {

	private static final long serialVersionUID = 12398L;
	
	private JLabel lun,lp1,lp2,lue,lcat;
	
	private JTextField uname;
	private JPasswordField upass1,upass2;
	private JTextField uemail;
	private JComboBox<String> ucat;
	
	private Register register;
	private JButton reg,back;
	
	private String combo[] = {"New User","Professional"};
	private BorderLayout borderlayout;
	private FlowLayout flowlayout;
	
	// Constructor 
	Register() {
		
		register = this;
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		//ImageIcon img = new ImageIcon("C:\\Users\\James\\workspace\\persnl plner\\src\\pp.png");
		//this.setIconImage(img.getImage());
		
		setSize(350,250);
		setTitle("Personal Planner: Register Page");
		
		IntiComponents();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		reg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!wat_say_bro()) {
					return;
				}
				
				
				Connection conn = null;
				conn = PP.GimmeConnection();
				try {
					String UNAME =  uname.getText();
					String UPASS =  new String(upass1.getPassword());
					String UMAIL =  uemail.getText();
					String UCAT = (String) ucat.getSelectedItem();
					
					Statement stm = conn.createStatement();
					String sql = "insert into username values ('"+UNAME+"','"+UPASS+"','"+UMAIL+"','"+UCAT+"')";
//					System.out.println(sql);
					int rs = stm.executeUpdate(sql);
					
					if(rs==0) {
						PP.throwError("Error", "Unable Failed To Update");
					} else {
						JOptionPane.showMessageDialog (null, "You Have Been Registered .", "Welcome", JOptionPane.INFORMATION_MESSAGE);
					}
					stm.close();
					conn.close();
					
				} catch (SQLException e1) {
					PP.throwError("Error", "Unable Failed To Update");
				}
				
			}

			private boolean wat_say_bro() {
				if(upass1.getPassword().length == 0 || upass2.getPassword().length == 0 ) {
					PP.throwError("Error!!", "Password Field Can't be Empty");
					return false;
				}
				
				if(!Arrays.equals(upass1.getPassword(), upass2.getPassword())) {
					PP.throwError("Error!!", "Retype the passwords as they Didn't Match ");
					return false;
				}
				
				if(uname.getText().length() == 0) {
					PP.throwError("Error!!", "Username Field is Empty!!");
					return false;
				}
				
				if(uemail.getText().length() == 0) {
					PP.throwError("Error!!", "Email Field is Empty!!");
					return false;
				}
				
				return true;
			}
		});
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				register.setVisible(false);
				PP.loginpage.setVisible(true);
			}
		});
		
		addWindowListener(new WindowAdapter() {
			
		
			
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				PP.loginpage.setVisible(true);
					
			}
			
		
		});
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
	} // Constructor 

	private void IntiComponents() {
		// TODO Auto-generated method stub
JPanel p,p1,p2,p3,p4,p5,p6;
		
		borderlayout = new BorderLayout();
		flowlayout = new FlowLayout();
		flowlayout.setAlignment(FlowLayout.LEADING);
		setLayout(borderlayout);
		
		
		p1=new JPanel();
		lun = new JLabel("Enter User Name :       ");
		uname = new JTextField(20);
		p1.add(lun);
		p1.add(uname);
		//add(p1);
		
		p2=new JPanel();
		lp1 = new JLabel("Enter New Password : ");
		upass1 = new JPasswordField(20);
		p2.add(lp1);
		p2.add(upass1);
		//add(p2);
		
		p3=new JPanel();
		lp2 = new JLabel("Re-Enter Password :   ");
		upass2 = new JPasswordField(20);
		p3.add(lp2);
		p3.add(upass2);
		//add(p3);
		
		p4=new JPanel();
		lue = new JLabel("Enter Email Adress :    ");
		uemail = new JTextField(20);
		p4.add(lue);
		p4.add(uemail);
		//add(p4);
		
		p5=new JPanel();
		lcat = new JLabel("Catergoery : ");
		ucat = new JComboBox<String>(combo);
		p5.add(lcat);
		p5.add(ucat);
		//add(p5);
		
		
		p6=new JPanel();
		reg = new JButton("Register");
		back = new JButton("Back");
		p6.add(back);
		p6.add(reg);
		//add(p6);
		
		p=new JPanel();
		p.setLayout(flowlayout);
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		p.add(p5);
		
		add(p, BorderLayout.CENTER);
		add(p6, BorderLayout.SOUTH);
		
	}

}
