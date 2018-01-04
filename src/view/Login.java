package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class Login extends JFrame implements ActionListener {

	private JButton loginBtn, logoutBtn, signBtn, MypageBtn, searchBtn, imgAdd1, imgAdd2, imgAdd3, writeBtn;
	private JTextField searchTextF, nameTextF, img1TextF, img2TextF, img3TextF, keywTextF;
	private JTextPane contentTextPn;
	private JPanel headerLogo;

	private JFileChooser jfc = new JFileChooser();

	public Login() {

		String icomImgimgUrl = "C:\\icon\\";

		JLabel cateLb, nameLb, imgLb1, imgLb2, imgLb3, keywLb, abilityLb, contentLb;
		JComboBox cateCombo;
		JPanel headerPn, sidePn, logoPn, catePn, writePn, cate1, cate2, cate3, cate4, cate5, cate6, cate7, cate8, cate9;

		// header
		headerLogo = new JPanel() {
			ImageIcon headerimage = new ImageIcon(icomImgimgUrl + "headerlogo.png");

			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(headerimage.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};

		// logo
		logoPn = new JPanel() {
			ImageIcon image = new ImageIcon(icomImgimgUrl + "logo.png");

			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};

		// mainView
		Container contentPane = getContentPane();

		contentPane.setBounds(0, 0, 1680, 1050);
		contentPane.setBackground(Color.white);

		// Header
		Color commonColor = new Color(218, 0, 0);
		headerPn = new JPanel();
		headerPn.setBackground(commonColor);
		headerPn.setSize(1680, 60);
		headerPn.setLayout(null);

		// headerlogo
		headerLogo.setBounds(15, 25, 71, 15);
		headerPn.add(headerLogo);
		// logoutBtn
		logoutBtn = new JButton("로그아웃");
		logoutBtn.setBounds(1250, 20, 100, 30);
		logoutBtn.setOpaque(false); // 투명하게
		logoutBtn.setBorderPainted(false);// 외곽선 없애줌
		logoutBtn.setFont(new Font("로그아웃", Font.BOLD, 12));
		logoutBtn.setBackground(commonColor);
		logoutBtn.setForeground(Color.white);
		headerPn.add(logoutBtn);

		// loginBtn
		loginBtn = new JButton("로그인");
		loginBtn.setBounds(1190, 20, 100, 30);
		loginBtn.setOpaque(false); // 투명하게
		loginBtn.setBorderPainted(false);// 외곽선 없애줌
		loginBtn.setFont(new Font("로그인", Font.BOLD, 12));
		loginBtn.setBackground(commonColor);
		loginBtn.setForeground(Color.white);
		headerPn.add(loginBtn);

		// SignBtn
		signBtn = new JButton("회원가입");
		signBtn.setBounds(1130, 20, 100, 30);
		signBtn.setOpaque(false); // 투명하게
		signBtn.setBorderPainted(false);// 외곽선 없애줌
		signBtn.setFont(new Font("회원가입", Font.BOLD, 12));
		signBtn.setBackground(commonColor);
		signBtn.setForeground(Color.white);
		signBtn.addActionListener(this);
		headerPn.add(signBtn);

		
		contentPane.add(headerPn);
		
		setBounds(0, 0, 1680, 1050);
		setLayout(null);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("==>" + e.getActionCommand());
		if (e.getActionCommand().equals("회원가입")) {

		}

		if (e.getActionCommand().equals("이미지 1")) {
			if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				// showopendialog 열기 창을 열고 확인 버튼을 눌렀는지 확인
				img1TextF.setText(jfc.getSelectedFile().toString());
			}
		}

		if (e.getActionCommand().equals("이미지 2")) {
			if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				// showopendialog 열기 창을 열고 확인 버튼을 눌렀는지 확인
				img2TextF.setText(jfc.getSelectedFile().toString());
			}
		}

		if (e.getActionCommand().equals("이미지 3")) {
			if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				// showopendialog 열기 창을 열고 확인 버튼을 눌렀는지 확인
				img3TextF.setText(jfc.getSelectedFile().toString());
			}
		}

	}

}
