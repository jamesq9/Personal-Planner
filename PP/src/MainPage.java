import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;


public class MainPage extends JFrame {

	private static final long serialVersionUID = 4561312334L;

	private MainPage mainpage;
	private JPanel p1,p2,p3,p1_cent,p1_right,p1_left;
	private JButton add,sub,signout;
	private JLabel welcome,sort_by,notes;
	private JComboBox<String> options;
	
	private JTextArea default_textArea;
	private JScrollPane scrolling;
	private JTable table;
	
	private String combo_options[] = {"Date","Priority","Catergorey","Alpabeticaly","This week"};
	private String event_oPtions[] = {"NAME","Categorey","Subject","Priority","On Date","Days Left"};
	private String table_contents[][] = {{"NULL","NULL","NULL","NULL","NULL","NULL"},
			{"NULL","NULL","NULL","NULL","NULL","NULL"},
			{"NULL","NULL","NULL","NULL","NULL","NULL"},
			{"NULL","NULL","NULL","NULL","NULL","NULL"},
			{"NULL","NULL","NULL","NULL","NULL","NULL"}};
	
	private String uname;
	private String event_notes="Click on an Event to know its Event Notes.";
	
	public MainPage(String s) {
		
		mainpage = this;
		uname=s;
		initComponent();
		
	}

	private void initComponent() {
		// TODO Auto-generated method stub
		setSize(1000,700);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		ImageIcon img = new ImageIcon("C:\\Users\\James\\workspace\\Persnl Plner\\src\\pp.png");
		this.setIconImage(img.getImage());
		setTitle("Personal Planner");
		setLayout(new BorderLayout());
		
		
		//Creating Top Panel.
		p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		p1.setPreferredSize((new Dimension(1000,40)));
		
		add(p1,BorderLayout.NORTH);
		// end of top panel.
		
		//adding stuff to top panel aka p1
		add= new JButton("+");
		sub = new JButton("-");
		signout = new JButton("Sign Out");
		
		p1_cent = new JPanel();
		
		FlowLayout fl = new FlowLayout();
		fl.setAlignment(FlowLayout.CENTER);
		p1_cent.setLayout(fl);
		
		
		p1_right = new JPanel();
		p1_right.setLayout(new FlowLayout());
		
		p1_left = new JPanel();
		
		p1_left.setLayout(new FlowLayout());
		
		welcome = new JLabel("   Welcome Back "+uname+"!");
		welcome.setFont(new Font("Garamond", Font.BOLD, 22));
		sort_by = new JLabel("Sort Things by ");
		options = new JComboBox<String>(combo_options);
		
		p1_left.add(add);
		p1_left.add(sub);
		p1_cent.add(welcome);
		p1_right.add(sort_by);
		p1_right.add(options);
		p1.add(p1_cent,BorderLayout.CENTER);
		p1_right.add(signout);
		p1.add(p1_right,BorderLayout.EAST);
		p1.add(p1_left,BorderLayout.WEST);
		//done adding stuff to top panel aka p1
		
		// adding events to p1
			add.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					new add();
				}
			});
		
		
		//done adding tings to p1
		
		
		// Creating Center Panel.
		p2=new JPanel();
		p2.setLayout(new BorderLayout());
		p2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		p2.setPreferredSize(new Dimension(700,660));
		add(p2,BorderLayout.CENTER);
		//End of Center Panel.
		
		//adding things to p2
		p2.add(new JLabel("Events"),BorderLayout.NORTH);
		table = new JTable(){
			 /**
			 * 
			 */
			private static final long serialVersionUID = 7763820329L;

			public boolean isCellEditable(int row, int col)  
	            {  
	                return false;  
	            }  
		};
		table.setModel(new DefaultTableModel(table_contents,event_oPtions));
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		table.enableInputMethods(false);
		p2.add(scrollPane,BorderLayout.CENTER);
		//Done adding things to p2
		
		
		
		//Creating RIght Panel
		p3=new JPanel();
		p3.setLayout(new BorderLayout());
		p3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		p3.setPreferredSize(new Dimension(300,660));
		add(p3,BorderLayout.EAST);
		// End of Right Panel
		
		
		//Adding stuff to p3
		
		notes = new JLabel("Notes:-");
		p3.add(notes,BorderLayout.NORTH);
		default_textArea = new JTextArea(event_notes);
		default_textArea.setWrapStyleWord(true);
		default_textArea.setLineWrap(true);
		default_textArea.setEditable(false);;
		scrolling = new JScrollPane(default_textArea);
		scrolling.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrolling.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		p3.add(scrolling,BorderLayout.CENTER);
		//End of Adding stuff to p3
		
		
		sub.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			try{
				int selection = table.getSelectedRow();
				((DefaultTableModel)table.getModel()).removeRow(selection);
				//table.updateUI();
			}catch(ArrayIndexOutOfBoundsException ee) {
				PP.throwError("Error", "NO Event Selected");
			}
			}
		});
		
		
		signout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
				PP.loginpage.setVisible(true);
				LoginPage.cleanPass();
			}
		});
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		
	}
	
}
