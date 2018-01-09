package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import delegator.Delegator;
import dto.Person;

public class Login extends JFrame implements ActionListener {

	private JButton loginBtn, logoutBtn, signBtn;
	private JTextField id;
	private JPasswordField pwd;
	private JButton signInBtn;
	
	

	private JFileChooser jfc = new JFileChooser();

	public Login() {

		String icomImgimgUrl = "/Users/parker/Desktop/img/icon/";

		JPanel headerPn;

		// header
		JPanel headerLogo = new JPanel() {
			ImageIcon headerimage = new ImageIcon(icomImgimgUrl + "headerlogo.png");

			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(headerimage.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};

		// mainView
		Container contentPane = getContentPane();


		// Header
		Color commonRedColor = new Color(218, 0, 0);
		Color commonGrayColor = new Color(250, 250, 250);
		
		headerPn = new JPanel();
		headerPn.setBackground(commonRedColor);
		headerPn.setSize(1680, 60);
		headerPn.setLayout(null);

		Delegator delegator = Delegator.getInstance();

		// headerlogo
		headerLogo.setBounds(15, 25, 71, 15);
		headerLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				delegator.mainController.Main();
			}
		});
		headerPn.add(headerLogo);
		
		
		if(delegator.getCurrent_user()==null) {
			// loginBtn
			loginBtn = new JButton("로그인");
			loginBtn.setBounds(1190, 20, 100, 30);
			loginBtn.setOpaque(false); // 투명하게
			loginBtn.setBorderPainted(false);// 외곽선 없애줌
			loginBtn.setFont(new Font("로그인", Font.BOLD, 12));
			loginBtn.setBackground(commonRedColor);
			loginBtn.setForeground(Color.white);
			headerPn.add(loginBtn);
			
			// SignBtn
			signBtn = new JButton("회원가입");
			signBtn.setBounds(1130, 20, 100, 30);
			signBtn.setOpaque(false); // 투명하게
			signBtn.setBorderPainted(false);// 외곽선 없애줌
			signBtn.setFont(new Font("회원가입", Font.BOLD, 12));
			signBtn.setBackground(commonRedColor);
			signBtn.setForeground(Color.white);
			signBtn.addActionListener(this);
			headerPn.add(signBtn);			
		}else {
			// logoutBtn
			logoutBtn = new JButton("로그아웃");
			logoutBtn.setBounds(1250, 20, 100, 30);
			logoutBtn.setOpaque(false); // 투명하게
			logoutBtn.setBorderPainted(false);// 외곽선 없애줌
			logoutBtn.setFont(new Font("로그아웃", Font.BOLD, 12));
			logoutBtn.setBackground(commonRedColor);
			logoutBtn.setForeground(Color.white);
			headerPn.add(logoutBtn);			
		}
		
		contentPane.add(headerPn);
		

		// main area
		JPanel main = new JPanel();
		main.setLayout(null);
		main.setBackground(new Color(250, 250, 250));
		main.setBounds(0, 60, 1680, 990);
				
		// login area
		JPanel login = new JPanel();
		login.setLayout(null);
		login.setBackground(Color.white);
		login.setBorder(new LineBorder(commonRedColor, 3));
		login.setLocation(340, 200);
		login.setSize(1000, 550);
		
		JPanel loginLogo = new JPanel() {
			ImageIcon headerimage = new ImageIcon(icomImgimgUrl + "logo.png");

			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(headerimage.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		
		loginLogo.setBounds(350, 80, 300, 70);
		login.add(loginLogo);
		
		Font labelFont = new Font("fonts", Font.BOLD, 20);
		
		JLabel idLabel = new JLabel("email");
		idLabel.setBounds(150, 220, 150, 50);
		idLabel.setFont(labelFont);
		login.add(idLabel);
		
		id = new JTextField();
		id.setBounds(300, 220, 400, 50);
		id.setBackground(commonGrayColor);
		login.add(id);
		
		JLabel pwdLabel = new JLabel("password");
		pwdLabel.setBounds(150, 310, 150, 50);
		pwdLabel.setFont(labelFont);
		login.add(pwdLabel);
		
		pwd = new JPasswordField();
		pwd.setBounds(300, 310, 400, 50);
		pwd.setBackground(commonGrayColor);
		login.add(pwd);
		
		signInBtn = new JButton("Sign In");
		signInBtn.setBounds(720, 220, 100, 135);
		signInBtn.setBorder(new LineBorder(commonRedColor, 2));
		signInBtn.addActionListener(this);
		login.add(signInBtn);

		main.add(login);
		contentPane.add(main);
		
		setBounds(0, 0, 1680, 730);
		setLayout(null);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Delegator delegator = Delegator.getInstance();
		Object obj = e.getSource();
		
		if(obj == signInBtn) {
			String _id = id.getText();
			char[] _pwd = pwd.getPassword();
			
			if(_id.length() < 5) {
				JOptionPane.showMessageDialog(null, "id length must be more than 5");
				pwd.setText("");
			}else if(_pwd.length < 5) {
				JOptionPane.showMessageDialog(null, "password length must be more than 5");
				pwd.setText("");
			}else {
				Person person = delegator.personController.signIn(id.getText(), pwd.getPassword());
				
				if(person != null) {
					//	login success
					//delegator.mainController.Main();
					this.dispose();
					
				}else {
					//	login fail
					JOptionPane.showMessageDialog(null, "wrong password");
					pwd.setText("");
				}				
			}
		}else if(obj == loginBtn) {
			delegator.personController.Login();
		}else if(obj == logoutBtn) {
			delegator.personController.Logout();
			this.dispose();
		}else if(obj == signBtn) {
			delegator.personController.SignUp();
			this.dispose();
		}
	}

}
