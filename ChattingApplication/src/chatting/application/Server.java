package chatting.application;

import java.awt.*;
import java.awt.event.*;

import java.net.*;

import javax.swing.*;
import java.io.*;

public class Server extends JFrame implements ActionListener{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // bewajh warning htane k liye
	
	JPanel p1;
	JTextField t1;
	JButton b1;
	
	static JTextArea a1;
	
	static ServerSocket skt;
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
	
	Server(){
	
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(7,94, 84));
		p1.setBounds(0,0, 420, 40);
		add(p1);
		
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3.png"));
		Image i2 = i1.getImage().getScaledInstance(18,18, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		
		JLabel l1 =new JLabel(i3);
		l1.setBounds(0,4,25,30);
		p1.add(l1);
		
		
		l1.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent ae) {
				System.exit(0);
			}
		});
		
		
		JLabel l3= new JLabel("Kashi");
		l3.setFont(new Font("SAN_SERIF", Font.BOLD,14));
		l3.setForeground(Color.WHITE);
		l3.setBounds(60,4,95,20);
		p1.add(l3);
		
		
		
		
		
		ImageIcon i14 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/1.png"));
		Image i15 = i14.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT);
		ImageIcon i16 = new ImageIcon(i15);
			
		JLabel l5 =new JLabel(i16);
		l5.setBounds(22,4,33,33);
		p1.add(l5);
		
		
		
		
		JLabel l7 = new JLabel("Active Now");
		l7.setFont(new Font("SAN_SERIF", Font.BOLD,8));
		l7.setForeground(Color.WHITE);
		l7.setBounds(60,20,95,20);
		p1.add(l7);
		
		
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/video.png"));
		Image i5 = i4.getImage().getScaledInstance(18,20, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
			
		JLabel l2 =new JLabel(i6);
		l2.setBounds(145,4,33,33);
		p1.add(l2);
		
		
		
		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/phone.png"));
		Image i8 = i7.getImage().getScaledInstance(18,20, Image.SCALE_DEFAULT);
		ImageIcon i9 = new ImageIcon(i8);
			
		JLabel l6 =new JLabel(i9);
		l6.setBounds(180,4,33,33);
		p1.add(l6);
		
		
		
		ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3icon.png"));
		Image i12 = i11.getImage().getScaledInstance(9,13, Image.SCALE_DEFAULT);
		ImageIcon i13 = new ImageIcon(i12);
			
		JLabel l4 =new JLabel(i13);
		l4.setBounds(205,4,33,33);
		p1.add(l4);
		
		
		
		a1 = new JTextArea();
		a1.setBounds(2,42,246,329);
	//	a1.setBackground(Color.PINK);
		a1.setEditable(false);
		a1.setLineWrap(true);
		//a1.setWrapStyleWord(true);
		add(a1);
		
		
		
		t1 = new JTextField();
		t1.setBounds(4,373,170,25);
		t1.setFont(new Font("SAN_SERIF", Font.BOLD,13));
		add(t1);
	
		
		b1 = new JButton("Send");
		b1.setBounds(177, 373, 69, 24);
		b1.setBackground(new Color(7,94,84));
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		
		
	//	getContentPane().setBackground(Color.YELLOW);
		setLayout(null);
		setSize(250,400);
		setLocation(400,250);
			
		setUndecorated(true);
		setVisible(true);
	
	}
	public void actionPerformed(ActionEvent ae) {
		
		try {
		String out = t1.getText();
		a1.setText(a1.getText()+"\n\t\t"+out);
		dout.writeUTF(out);
		t1.setText("");
		}catch(Exception e) {
			
		}
		
	}
	
	 public static void main(String[] args){
	     new Server().setVisible(true);
	     
	     String msginput = "";
	     
	     try {
	    	 skt = new ServerSocket(6001);
	    	 s = skt.accept();
	    	 din = new DataInputStream(s.getInputStream());
	    	 dout = new DataOutputStream(s.getOutputStream());
	    	 
	    	 msginput = din.readUTF();
	    	 a1.setText(a1.getText()+"\n"+msginput);
	    	 
	    //	 skt.close();
	    	// s.close();
	    	 
	     }catch(Exception e) {
	    	 
	     }
	 }
}
