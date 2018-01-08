package view;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import org.omg.CORBA.PUBLIC_MEMBER;

import dto.AbilityBbs;
import dto.Category;
import dto.ItemBbs;



public class mainView extends JFrame implements ActionListener {

	private JPanel headerPn, headerLogo, sidePn, logoPn, catePn, cate1, cate2, cate3, cate4, cate5, cate6, cate7, cate8,
	cate9;
	private JButton loginBtn, logoutBtn, signBtn, MypageBtn, searchBtn;
	private JTextField searchTextF;

	private JPanel listPn;
	Color mainPink = new Color(255, 174, 174);
	Color commonColor = new Color(218, 0, 0);
	
	public mainView() {
		
		Container cn = getContentPane();
		cn.setBounds(0, 0, 1680, 1050);
		cn.setBackground(Color.white);
		
		// Header
		headerPn = new JPanel();
		headerPn.setBackground(commonColor);
		headerPn.setSize(1680, 60);
		headerPn.setLayout(null);
		
		// headerlogo
		ImageIcon headerimage = new ImageIcon("/Users/leeseoone/Desktop/icon/headerlogo.png");
		headerLogo = new JPanel() {
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(headerimage.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
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
		// loginBtn
		loginBtn = new JButton("로그인");
		loginBtn.setBounds(1190, 20, 100, 30);
		loginBtn.setOpaque(false); // 투명하게
		loginBtn.setBorderPainted(false);// 외곽선 없애줌
		loginBtn.setFont(new Font("로그인", Font.BOLD, 12));
		loginBtn.setBackground(commonColor);
		loginBtn.setForeground(Color.white);
		// SignBtn
		signBtn = new JButton("회원가입");
		signBtn.setBounds(1130, 20, 100, 30);
		signBtn.setOpaque(false); // 투명하게
		signBtn.setBorderPainted(false);// 외곽선 없애줌
		signBtn.setFont(new Font("회원가입", Font.BOLD, 12));
		signBtn.setBackground(commonColor);
		signBtn.setForeground(Color.white);
		
		headerPn.add(logoutBtn);
		headerPn.add(loginBtn);
		headerPn.add(signBtn);
		
		// 1050
		// sidePn
		Color sideC = new Color(250, 250, 250);
		sidePn = new JPanel();
		sidePn.setBounds(0, 60, 400, 1000);
		sidePn.setLayout(null);
		sidePn.setBackground(sideC);
		
		ImageIcon image = new ImageIcon("/Users/leeseoone/Desktop/icon/logo.png");
		logoPn = new JPanel() {
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		logoPn.setBounds(40, 30, 300, 66);
		sidePn.add(logoPn);
		
		// SearchText
		searchTextF = new JTextField("검색어");
		searchTextF.setBounds(40, 160, 260, 40);
		searchTextF.setBorder(new LineBorder(commonColor, 5));
		sidePn.add(searchTextF);
		// searchBtn
		searchBtn = new JButton(new ImageIcon("/Users/leeseoone/Desktop/icon/search.png"));
		searchBtn.setBounds(300, 160, 40, 40);
		searchBtn.setOpaque(false); // 투명하게
		// searchBtn.setBackground();
		searchBtn.setContentAreaFilled(false);// 내용영역 채우기x
		sidePn.add(searchBtn);
		// catePn
		catePn = new JPanel();
		catePn.setLayout(new GridLayout(3, 3, 10, 10));
		catePn.setBounds(25, 290, 350, 350);
		catePn.setBackground(Color.WHITE);
		// 카터고리
		ImageIcon cate1Image = new ImageIcon("/Users/leeseoone/Desktop/icon/1.png");
		cate1 = new JPanel() {
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate1Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate1.setBorder(new LineBorder(commonColor, 3));
		// 카테고리 2
		ImageIcon cate2Image = new ImageIcon("/Users/leeseoone/Desktop/icon/2.png");
		cate2 = new JPanel() {
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate2Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate2.setBorder(new LineBorder(commonColor, 3));
		// 카테고리 3
		ImageIcon cate3Image = new ImageIcon("/Users/leeseoone/Desktop/icon/3.png");
		cate3 = new JPanel() {
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate3Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate3.setBorder(new LineBorder(commonColor, 3));
		// 카테고리4
		ImageIcon cate4Image = new ImageIcon("/Users/leeseoone/Desktop/icon/4.png");
		cate4 = new JPanel() {
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate4Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate4.setBorder(new LineBorder(commonColor, 3));
		// 카테고리 5
		ImageIcon cate5Image = new ImageIcon("/Users/leeseoone/Desktop/icon/5.png");
		cate5 = new JPanel() {
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate5Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate5.setBorder(new LineBorder(commonColor, 3));
		// 카테고리 6
		ImageIcon cate6Image = new ImageIcon("/Users/leeseoone/Desktop/icon/6.png");
		cate6 = new JPanel() {
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate6Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate6.setBorder(new LineBorder(commonColor, 3));
		// 카테고리7
		ImageIcon cate7Image = new ImageIcon("/Users/leeseoone/Desktop/icon/7.png");
		cate7 = new JPanel() {
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate7Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate7.setBorder(new LineBorder(commonColor, 3));
		// 카테고리8
		ImageIcon cate8Image = new ImageIcon("/Users/leeseoone/Desktop/icon/8.png");
		cate8 = new JPanel() {
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate8Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate8.setBorder(new LineBorder(commonColor, 3));
		// 카테고리9
		ImageIcon cate9Image = new ImageIcon("/Users/leeseoone/Desktop/icon/9.png");
		cate9 = new JPanel() {
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate9Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate9.setBorder(new LineBorder(commonColor, 3));
		catePn.add(cate1);
		catePn.add(cate2);
		catePn.add(cate3);
		catePn.add(cate4);
		catePn.add(cate5);
		catePn.add(cate6);
		catePn.add(cate7);
		catePn.add(cate8);
		catePn.add(cate9);
		sidePn.add(catePn);
		
		listPn = new JPanel();
		listPn.setLayout(null);
		listPn.setBounds(400, 60, 1280, 1000);
		listPn.setBackground(mainPink);

		Category Cdto = new Category("", "", 0);
		listPn.add(new ListVIew(Cdto));
		
		add(headerPn);
		add(sidePn);
		
        add(listPn);
		setLayout(null);
		setBounds(0,0,1680,1050);
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
