import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LoginPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1234523L;

	private JTextField uname;
	private JPasswordField upass;
	private JButton b_login;
	private JButton b_register;
	private static LoginPage loginpage;
	private String password;
	
	
	public static void cleanPass() {
		loginpage.upass.setText("");
		
	}
	
	
	public LoginPage() {

		loginpage = this;
		setSize(250, 140);
		setTitle("Personal Planner : Login Page");
	
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		ImageIcon img = new ImageIcon("C:\\Users\\James\\workspace\\Persnl Plner\\src\\pp.png");
		this.setIconImage(img.getImage());
		
		IntiComponent();
		this.getContentPane().setBackground( Color.BLACK );
			
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		b_register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Register();
				loginpage.setVisible(false);
				
			}
		});
		
		
		b_login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					Connection conn = null;
					conn = PP.GimmeConnection();
					
					Statement stm = conn.createStatement();
					String sql = "select upass from username where uname="+"'"+uname.getText()+"'";
					ResultSet rs = stm.executeQuery(sql);
					
					if(rs.next()) {
					String s1 = rs.getString("upass");
					password = new String( upass.getPassword() );
							if( password.equals(s1) ) {
							new MainPage(uname.getText());
							loginpage.setVisible(false);
						} else {
							PP.throwError("Invalid Password ", " The Password is Incorrect .");
						}
					
					} else {
						PP.throwError("Invalid Username ", "The Username Doesn't seem to Exist.");
						stm.close();
						conn.close();
						return;
					} 
					stm.close();
					conn.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					PP.throwError( "Invalid Username ", "The Username Doesn't seem to Exist.");
				} catch (NullPointerException e) {
					PP.throwError("Invalid Password", "Empty Password is inavlid Please Enter a valid Password.");
					//e.printStackTrace();
				}

			}

		});

			} // login page


	private void IntiComponent() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();

		JLabel lbl1, lbl2;
		lbl1 = new JLabel("Username");
		lbl2 = new JLabel("Password");

		uname = new JTextField(15);

		upass = new JPasswordField(15);

		b_login = new JButton();
		b_register = new JButton();
		b_login.setText("Login");
		b_register.setText("Register");

		p2.add(lbl1);
		p2.add(uname);
		p.add(p2);
		p3.add(lbl2);
		p3.add(upass);
		p.add(p3);
		p4.add(b_register);
		p4.add(b_login);
		p.add(p4);
		add(p);

	}

}
