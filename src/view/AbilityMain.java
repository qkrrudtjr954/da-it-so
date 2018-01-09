package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import delegator.Delegator;
import dto.AbilityBbs;
import dto.Person;

public class AbilityMain extends JFrame implements ActionListener, MouseListener{
	//list panel
	private JPanel listPn, thumPn, thumPn1, thumPn2;
	private JLabel imgLa, txtLa;
	private JButton addBtn;
	
	//side panel
	private JPanel headerPn, headerLogo, sidePn, logoPn, catePn, cate1, cate2, cate3, cate4, cate5, cate6, cate7, cate8,
	cate9, detailPn;
	private JButton loginBtn, logoutBtn, signBtn, MypageBtn, searchBtn, talkBtn, chatBtn;
	private JTextField searchTextF;
	
	//imgurl
	String iconImgUrl = "C:\\icon\\";

	Color mainRed = new Color(218, 0, 0);
	Color mainGray = new Color(250, 250, 250);
	Color mainPink = new Color(255, 174, 174);

	List<AbilityBbs> m_abilityList = null;
	
	public AbilityMain(List<AbilityBbs> abilityList) {
		
		Delegator delegator = Delegator.getInstance();
		this.m_abilityList = abilityList;
		
		
		// Header
		Color commonColor = new Color(218, 0, 0);
		headerPn = new JPanel();
		headerPn.setBackground(commonColor);
		headerPn.setSize(1680, 60);
		headerPn.setLayout(null);

		// detailPn
		detailPn = new JPanel();
		detailPn.setBackground(Color.white);
		detailPn.setLocation(0, 0);
		detailPn.setPreferredSize(new Dimension(1005, 1500));
		detailPn.setLayout(null);

		JScrollPane scrollPane = new JScrollPane(detailPn);
		scrollPane.setBounds(400, 60, 1100, 900);
		scrollPane.setBackground(Color.black);
		// scrollPane.add(detailPn);

		// headerlogo
		ImageIcon headerimage = new ImageIcon(iconImgUrl + "headerlogo.png");
		headerLogo = new JPanel() {
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(headerimage.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		headerLogo.setBounds(15, 25, 71, 15);
		headerLogo.addMouseListener(this);
		headerPn.add(headerLogo);
		
		if(delegator.getCurrent_user()==null) {
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
		}else {
			// logoutBtn
			logoutBtn = new JButton("로그아웃");
			logoutBtn.setBounds(1250, 20, 100, 30);
			logoutBtn.setOpaque(false); // 투명하게
			logoutBtn.setBorderPainted(false);// 외곽선 없애줌
			logoutBtn.setFont(new Font("로그아웃", Font.BOLD, 12));
			logoutBtn.setBackground(commonColor);
			logoutBtn.setForeground(Color.white);
			headerPn.add(logoutBtn);			
		}

		// 1050
		// sidePn
		Color sideC = new Color(250, 250, 250);
		sidePn = new JPanel();
		sidePn.setBounds(0, 60, 400, 1000);
		sidePn.setLayout(null);
		sidePn.setBackground(sideC);

		ImageIcon image = new ImageIcon(iconImgUrl + "logo.png");
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
		searchBtn = new JButton(new ImageIcon(iconImgUrl + "search.png"));
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

		ImageIcon cate1Image = new ImageIcon(iconImgUrl + "1.png");
		cate1 = new JPanel() {
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate1Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate1.setBorder(new LineBorder(commonColor, 3));
		cate1.addMouseListener(this);
		// 카테고리 2
		ImageIcon cate2Image = new ImageIcon(iconImgUrl + "2.png");
		cate2 = new JPanel() {
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate2Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate2.setBorder(new LineBorder(commonColor, 3));
		cate2.addMouseListener(this);
		// 카테고리 3
		ImageIcon cate3Image = new ImageIcon(iconImgUrl + "3.png");
		cate3 = new JPanel() {
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate3Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate3.setBorder(new LineBorder(commonColor, 3));
		cate3.addMouseListener(this);
		// 카테고리4
		ImageIcon cate4Image = new ImageIcon(iconImgUrl + "4.png");
		cate4 = new JPanel() {
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate4Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate4.setBorder(new LineBorder(commonColor, 3));
		cate4.addMouseListener(this);
		// 카테고리 5
		ImageIcon cate5Image = new ImageIcon(iconImgUrl + "5.png");
		cate5 = new JPanel() {
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate5Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate5.setBorder(new LineBorder(commonColor, 3));
		cate5.addMouseListener(this);
		// 카테고리 6
		ImageIcon cate6Image = new ImageIcon(iconImgUrl + "6.png");
		cate6 = new JPanel() {
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate6Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate6.setBorder(new LineBorder(commonColor, 3));
		cate6.addMouseListener(this);
		// 카테고리7
		ImageIcon cate7Image = new ImageIcon(iconImgUrl + "7.png");
		cate7 = new JPanel() {
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate7Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate7.setBorder(new LineBorder(commonColor, 3));
		cate7.addMouseListener(this);
		// 카테고리8
		ImageIcon cate8Image = new ImageIcon(iconImgUrl + "8.png");
		cate8 = new JPanel() {
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate8Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate8.setBorder(new LineBorder(commonColor, 3));
		cate8.addMouseListener(this);
		// 카테고리9
		ImageIcon cate9Image = new ImageIcon(iconImgUrl + "9.png");
		cate9 = new JPanel() {
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate9Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate9.setBorder(new LineBorder(commonColor, 3));
		cate9.addMouseListener(this);
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
		int thumPnCount = (100 / 2) + 1;

		listPn.setPreferredSize(new Dimension(1280, 170 * thumPnCount));
		listPn.setLocation(0, 0);
		listPn.setBackground(mainPink);
		

		addBtn = new JButton("+");
		addBtn.setBounds(200, 35, 100, 50);
		addBtn.addActionListener(this);
		
		// thumPn
		thumPn = new JPanel();
		thumPn.setLayout(null);
		thumPn.setBounds(15, 50, 500, 120);
		thumPn.setBorder(new LineBorder(mainRed, 1));
		thumPn.setBackground(Color.white);
		thumPn.add(addBtn);
		
		int j = 0;
		for (int i = 0; i < m_abilityList.size(); i++) {

			thumPn1 = new JPanel();
			thumPn1.setLayout(null);

			thumPn2 = new JPanel();
			thumPn2.setLayout(null);
			
			if (i % 2 == 0) { // 짝수일때(새로운 줄로 넘어갈때)
				thumPn1.setBounds(525, (170 * j) + 50, 500, 120);
				imgLa = new JLabel(new ImageIcon("+ dto.getImgurl1() +"));
				txtLa = new JLabel(m_abilityList.get(i).getContent());
				imgLa.setBounds(0, 0, 200, 120);
				imgLa.setBorder(new LineBorder(mainRed, 1));
				txtLa.setBounds(200, 0, 300, 120);
				thumPn1.add(txtLa);
				thumPn1.add(imgLa);
				j++;
				
			} else {
				thumPn1.setBounds(15, (170 * j) + 50, 500, 120);
				imgLa = new JLabel(new ImageIcon(m_abilityList.get(i).getImgurl1()));
				txtLa = new JLabel(m_abilityList.get(i).getContent());
				imgLa.setBounds(0, 0, 200, 120);
				imgLa.setBorder(new LineBorder(mainRed, 1));
				txtLa.setBounds(200, 0, 300, 120);
				thumPn1.add(txtLa);
				thumPn1.add(imgLa);
			}

			thumPn1.setBorder(new LineBorder(mainRed, 1));
			thumPn1.setBackground(Color.white);
			thumPn1.addMouseListener(this);

			listPn.add(thumPn1);
		}
		listPn.add(thumPn);
		JScrollPane scroll;
		scroll = new JScrollPane(listPn);
		scroll.setBounds(400, 60, 1280, 990);
		scroll.setBackground(mainPink);
		add(scroll);
		add(sidePn);
		add(headerPn);
		setBounds(0, 0, 1680, 730);
		setLayout(null);
		setVisible(true);	
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Delegator delegator = Delegator.getInstance();
		Person personDto = null;
		
		Object obj = e.getSource();
		
		if( obj== addBtn ) {
			System.out.println("Ability AddBtn Click");
			
			personDto = delegator.getCurrent_user();
			
			if(personDto == null) {
				delegator.personController.Login();
			}else {
				delegator.abilityBbsController.AbilityWrite(personDto);
				this.dispose();
			}	
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		JPanel thumPn1 = (JPanel)e.getComponent();
		//System.out.println(e.getComponent().equals(thumPn1));
		
		System.out.println("x,y ==>"+thumPn1.getX() +"," +thumPn1.getY());
		
		Delegator delegator = Delegator.getInstance();
		AbilityBbs abilitySelect = null;
		
		int i =0;
		int j =0;
		
		if(thumPn1.getX()==15) {
			i=0;
		}else if(thumPn1.getX()==525) {
			i=1;
		}
		
		j = thumPn1.getY()/170;
		
		if(thumPn1.getX()==525 && thumPn1.getY()==50) {
			abilitySelect = m_abilityList.get(0);
			delegator.abilityBbsController.AbilityDetail(abilitySelect);
		}else {
			abilitySelect = m_abilityList.get(i+j);
			delegator.abilityBbsController.AbilityDetail(abilitySelect);
		}

		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
