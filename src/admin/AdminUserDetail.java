package admin;

import java.awt.Color;
import java.awt.Container;
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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import delegator.Delegator;
import dto.AbilityBbs;
import dto.ItemBbs;
import dto.Person;

public class AdminUserDetail extends JFrame implements ActionListener,MouseListener {
	private JPanel headerPn, headerLogo, sidePn, logoPn, catePn, cate1, cate2, cate3, cate4, cate5, cate6, cate7, cate8,
			cate9, imagePannel, iteminfoPn, itemImagePn, subimagePn, detailPn, subimage1, subimage2, subimage3,
			subimage4, keywordPanel;
	private JButton loginBtn, logoutBtn, signupBtn, MypageBtn, searchBtn, talkBtn, chatBtn;
	private JButton itemListBtn, userListBtn, abilityListBtn;
	private JTextField searchTextF;
	private JLabel titleLb, sellLb, detailtitleLb, priceLb, keywardLb, cateLb, explanationLb;

//	String iconImgUrl = "/Users/parker/Desktop/img/icon/";
	String iconImgUrl = "E:\\icon/";
	
	int itemHeight = 60;
	
	Person person = null;
	List<ItemBbs> itemList = null;
	List<AbilityBbs> abilityList = null;
	
	public AdminUserDetail(Person person, List<ItemBbs> itemList, List<AbilityBbs> abilityList) {
		
		
		this.person = person;
		this.itemList = itemList;
		this.abilityList = abilityList;
		
		Container contentPane = getContentPane();
		
		contentPane.setBounds(0, 0, 1680, 900);
		contentPane.setBackground(Color.white);

		// Header
		Color commonRedColor = new Color(218, 0, 0);
		headerPn = new JPanel();
		headerPn.setBackground(commonRedColor);
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
		
		Delegator delegator = Delegator.getInstance();
		
		if(delegator.getCurrent_user()==null) {
			// loginBtn
			loginBtn = new JButton("로그인");
			loginBtn.setBounds(1190, 20, 100, 30);
			loginBtn.setOpaque(false); // 투명하게
			loginBtn.setBorderPainted(false);// 외곽선 없애줌
			loginBtn.setFont(new Font("로그인", Font.BOLD, 12));
			loginBtn.setBackground(commonRedColor);
			loginBtn.setForeground(Color.white);
			loginBtn.addActionListener(this);
			headerPn.add(loginBtn);
			
			// SignBtn
			signupBtn = new JButton("회원가입");
			signupBtn.setBounds(1130, 20, 100, 30);
			signupBtn.setOpaque(false); // 투명하게
			signupBtn.setBorderPainted(false);// 외곽선 없애줌
			signupBtn.setFont(new Font("회원가입", Font.BOLD, 12));
			signupBtn.setBackground(commonRedColor);
			signupBtn.setForeground(Color.white);
			signupBtn.addActionListener(this);
			headerPn.add(signupBtn);			
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
		searchTextF.setBorder(new LineBorder(commonRedColor, 5));
		sidePn.add(searchTextF);

		// searchBtn
		searchBtn = new JButton(new ImageIcon(iconImgUrl + "search.png"));
		searchBtn.setBounds(300, 160, 40, 40);
		searchBtn.setOpaque(false); // 투명하게
		// searchBtn.setBackground();

		searchBtn.setContentAreaFilled(false);// 내용영역 채우기x

		sidePn.add(searchBtn);
		
		// btnPanel
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(3, 1, 10, 10));
		btnPanel.setBounds(25, 290, 350, 350);
		btnPanel.setBackground(Color.WHITE);

		itemListBtn = new JButton("All Item BBS");
		itemListBtn.setBorder(new LineBorder(commonRedColor, 2));
		itemListBtn.addActionListener(this);
		btnPanel.add(itemListBtn);

		abilityListBtn = new JButton("All Ability BBS");
		abilityListBtn.setBorder(new LineBorder(commonRedColor, 2));
		abilityListBtn.addActionListener(this);
		btnPanel.add(abilityListBtn);

		userListBtn = new JButton("All User");
		userListBtn.setBorder(new LineBorder(commonRedColor, 2));
		userListBtn.addActionListener(this);
		btnPanel.add(userListBtn);

		sidePn.add(btnPanel);

		
		/*
	private int seq;
	private String id;
	private char[] pwd;
	private String phone;
	private String nick;
	private String created_at;
	*/
		// main view
		JPanel main = new JPanel();
		main.setLayout(new GridLayout(5,  1));
		main.setBounds(400, 60, 1280, 500);
		
		JPanel userIDPanel = new JPanel();
		userIDPanel.setLayout(null);
		
		JLabel uesrID = new JLabel();
		uesrID.setText("ID");
		uesrID.setBounds(100, 50, 200, 20);
		userIDPanel.add(uesrID);
		
		JLabel userID2 = new JLabel();
		userID2.setText(person.getId());
		userID2.setBounds(300, 50, 200, 20);
		userIDPanel.add(userID2);
		
		main.add(userIDPanel);
		
		
		JPanel userPhonePanel = new JPanel();
		userPhonePanel.setLayout(null);
		
		JLabel uesrPhone = new JLabel();
		uesrPhone.setText("Phone");
		uesrPhone.setBounds(100, 50, 200, 20);
		userPhonePanel.add(uesrPhone);
		
		JLabel uesrPhone2 = new JLabel();
		uesrPhone2.setText(person.getPhone());
		uesrPhone2.setBounds(300, 50, 200, 20);
		userPhonePanel.add(uesrPhone2);
		
		main.add(userPhonePanel);
		

		
		JPanel userNickPanel = new JPanel();
		userNickPanel.setLayout(null);
		
		JLabel userNick = new JLabel();
		userNick.setText("Phone");
		userNick.setBounds(100, 50, 200, 20);
		userNickPanel.add(userNick);
		
		JLabel userNick2 = new JLabel();
		userNick2.setText(person.getNick());
		userNick2.setBounds(300, 50, 200, 20);
		userNickPanel.add(userNick2);
		
		main.add(userNickPanel);
		


		
		JPanel userCreatedPanel = new JPanel();
		userCreatedPanel.setLayout(null);
		
		JLabel userCreated = new JLabel();
		userCreated.setText("Join date");
		userCreated.setBounds(100, 50, 200, 20);
		userCreatedPanel.add(userCreated);
		
		JLabel userCreated2 = new JLabel();
		userCreated2.setText(person.getCreated_at());
		userCreated2.setBounds(300, 50, 200, 20);
		userCreatedPanel.add(userCreated2);
		
		main.add(userCreatedPanel);
		
		contentPane.add(main);
		
		
		int abilityHeight = abilityList.size() * this.itemHeight;
		int itemHeight = itemList.size() * this.itemHeight;

		JPanel aMain = new JPanel();
		aMain.setLocation(400, 60);
//		aMain.setPreferredSize(new Dimension(630, mainHeight));
		aMain.setLayout(null);

		JScrollPane aScrPane = new JScrollPane(aMain);

		for (int i = 0; i < abilityList.size(); i++) {
			JPanel itemPanel = new JPanel();
			itemPanel.setBounds(50, i * itemHeight + 20, 1000, itemHeight);
			itemPanel.setBorder(new LineBorder(commonRedColor));
			itemPanel.addMouseListener(this);
			itemPanel.setLayout(null);
			itemPanel.setBackground(Color.white);

			JLabel itemUser = new JLabel();
			itemUser.setText(abilityList.get(i).getUser_id());
			itemUser.setBounds(20, 20, 200, 20);
			itemPanel.add(itemUser);

			JLabel itemTitle = new JLabel();
			itemTitle.setText(abilityList.get(i).getTitle());
			itemTitle.setBounds(250, 20, 200, 20);
			itemPanel.add(itemTitle);

			JLabel itemCreated = new JLabel();
			itemCreated.setText(abilityList.get(i).getCreated_at());
			itemCreated.setBounds(860, 20, 140, 20);
			itemPanel.add(itemCreated);

			main.add(itemPanel);
		}

		JScrollPane jscPanel = new JScrollPane(main);
		jscPanel.setBounds(400, 60, 1280, 1000);
		

		contentPane.add(sidePn);
		contentPane.add(headerPn);
		
		setBounds(0, 0, 1680, 730);
		setLayout(null);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton btn = (JButton) e.getSource();

		if (btn == talkBtn) {

		} else if (btn == signupBtn) {

			
			dispose();
		} else if (btn == loginBtn) {

			
			dispose();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
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

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
