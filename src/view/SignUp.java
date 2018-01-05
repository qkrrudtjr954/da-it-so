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

public class SignUp extends JFrame implements ActionListener {

	private JButton loginBtn, logoutBtn, signBtn, checkIdBtn;
	private JTextField id, phone, nick;
	private JPasswordField pwd, pwd2;
	private JButton signUpBtn;
	private boolean hidden = false;
	
	

	private JFileChooser jfc = new JFileChooser();

	public SignUp() {

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
		login.setLocation(340, 150);
		login.setSize(1000, 700);
		
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
		
		JLabel titleLabel = new JLabel("회원 가입");
		titleLabel.setBounds(450, 170, 300, 50);
		titleLabel.setFont(new Font("font", Font.BOLD, 30));
		titleLabel.setForeground(commonRedColor);
		login.add(titleLabel);
		
		JLabel idLabel = new JLabel("email");
		idLabel.setBounds(150, 240, 150, 50);
		idLabel.setFont(labelFont);
		login.add(idLabel);
		
		id = new JTextField();
		id.setBounds(300, 240, 300, 50);
		id.setBackground(commonGrayColor);
		login.add(id);
		
		checkIdBtn = new JButton("중복 확인");
		checkIdBtn.setBounds(600, 240, 100, 50);
		checkIdBtn.setBorder(new LineBorder(commonRedColor, 2));
		checkIdBtn.addActionListener(this);
		login.add(checkIdBtn);
		
		JLabel pwdLabel = new JLabel("password");
		pwdLabel.setBounds(150, 300, 150, 50);
		pwdLabel.setFont(labelFont);
		login.add(pwdLabel);
		
		pwd = new JPasswordField();
		pwd.setBounds(300, 300, 400, 50);
		pwd.setBackground(commonGrayColor);
		login.add(pwd);
		
		JLabel pwd2Label = new JLabel("password");
		pwd2Label.setBounds(150, 360, 150, 50);
		pwd2Label.setFont(labelFont);
		login.add(pwd2Label);
		
		pwd2 = new JPasswordField();
		pwd2.setBounds(300, 360, 400, 50);
		pwd2.setBackground(commonGrayColor);
		login.add(pwd2);
		
		JLabel nickLabel = new JLabel("nickname");
		nickLabel.setBounds(150, 420, 150, 50);
		nickLabel.setFont(labelFont);
		login.add(nickLabel);
		
		nick = new JTextField();
		nick.setBounds(300, 420, 400, 50);
		nick.setBackground(commonGrayColor);
		login.add(nick);
		
		JLabel phoneLabel = new JLabel("phone");
		phoneLabel.setBounds(150, 480, 150, 50);
		phoneLabel.setFont(labelFont);
		login.add(phoneLabel);
		
		phone = new JTextField();
		phone.setBounds(300, 480, 400, 50);
		phone.setBackground(commonGrayColor);
		login.add(phone);
		
		
		signUpBtn = new JButton("Sign Up");
		signUpBtn.setBounds(550, 560, 150, 50);
		signUpBtn.setBorder(new LineBorder(commonRedColor, 2));
		signUpBtn.addActionListener(this);
		login.add(signUpBtn);

		main.add(login);
		contentPane.add(main);
		
		setBounds(0, 0, 1680, 1050);
		setLayout(null);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Delegator delegator = Delegator.getInstance();
		Object obj = e.getSource();
		
		if(obj == signUpBtn) {
			String _id = id.getText();
			char[] _pwd = pwd.getPassword();
			
			System.out.println(hidden);
			
			if(_id.length() < 5) {
				JOptionPane.showMessageDialog(null, "id length must be more than 5");
				pwd.setText("");
			}else if(_pwd.length < 5) {
				JOptionPane.showMessageDialog(null, "password length must be more than 5");
				pwd.setText("");
			}else if(!checkPwd()){
				JOptionPane.showMessageDialog(null, "비밀 번호가 일치하지 않습니다.");
				pwd.setText("");
				pwd2.setText("");
			}else if(!checkPhone()){
				JOptionPane.showMessageDialog(null, "전화번호는 숫자만 입력해주세요. ");
			}else {
				Person person = new Person();
				person.setId(id.getText());
				person.setPwd(pwd.getPassword());
				person.setNick(nick.getText());
				person.setPhone(phone.getText());
				
				Person resultPerson = null;
				
				if(hidden) {
					resultPerson = delegator.personController.insert(person);

					if(resultPerson != null) {
						JOptionPane.showMessageDialog(null, "회원 가입에 성공했습니다. ");
						delegator.personController.Login();
						this.dispose();
					}else {
						JOptionPane.showMessageDialog(null, "회원 가입에 실패했습니다. 다시 시도해주세요. ");
						pwd.setText("");
						pwd2.setText("");
					}				
				}else {
					JOptionPane.showMessageDialog(null, "아이디 중복 확인을 해주세요.");
				}
			}
		}else if(obj == loginBtn) {
			delegator.personController.Login();
		}else if(obj == logoutBtn) {
			delegator.personController.Logout();
			this.dispose();
		}else if(obj == checkIdBtn) {
			boolean result = delegator.personController.checkId(id.getText());
			
			if(result) {
				JOptionPane.showMessageDialog(null, "사용 가능한 아이디 입니다. ");
				hidden = true;
			}else {
				JOptionPane.showMessageDialog(null, "이미 사용중 아이디 입니다. ");
				hidden = false;
			}
		}
	}
	
	// 비밀번호가 같은지 확인하는 메소드 
	private boolean checkPwd() {
		char[] _pwd1 = pwd.getPassword();
		char[] _pwd2 = pwd2.getPassword();
		
		if(_pwd1.length != _pwd2.length) {
			return false;
		}else {
			for(int i=0; i<_pwd1.length; i++) {
				if(_pwd1[i]!=_pwd2[i]) {
					return false;
				}
			}			
		}
		return true;
	}
	
	private boolean checkPhone() {
		String _phone = phone.getText();
		
		for(int i=0; i<_phone.length(); i++) {
			char ch = _phone.charAt(i);
			if( (int)ch < 47 || (int)ch > 58) {
				return false;
			}
		}
		return true;
	}
}
