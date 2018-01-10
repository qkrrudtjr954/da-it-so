package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
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
import dto.Category;
import dto.ItemBbs;
import dto.Person;

public class ItemMain extends JFrame implements ActionListener, MouseListener {
	//side panel
	private JPanel headerPn, headerLogo, sidePn, logoPn, catePn, cate1, cate2, cate3, cate4, cate5, cate6, cate7, cate8,
	cate9, detailPn;
	private JButton loginBtn, logoutBtn, signupBtn, MypageBtn, searchBtn;
	private JTextField searchTextF;

	//list panel
	private JPanel listPn, thumPn, thumPn1, thumPn2;
	private JLabel imgLa, txtLa;
	private JButton addBtn;

	JPanel category;

//	String iconImgUrl = "C:\\icon\\";
	String iconImgUrl = "/Users/parker/Desktop/img/icon/";

	Color mainRed = new Color(218, 0, 0);
	Color mainGray = new Color(250, 250, 250);
	Color mainPink = new Color(255, 174, 174);

	List<ItemBbs> m_itemList;
	List<ItemBbs> itemSearchList;
	List<Category> m_categoryList;

	public ItemMain(List<ItemBbs> itemList, List<Category> categoryList) {
		Delegator delegator = Delegator.getInstance();

		this.m_itemList = itemList;
		this.m_categoryList = categoryList;

		// Header
		Color commonRedColor = new Color(218, 0, 0);
		headerPn = new JPanel();
		headerPn.setBackground(commonRedColor);
		headerPn.setSize(1350, 60);
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
		ImageIcon headerimage = new ImageIcon("/Users/leefrances/Desktop/icon/headerlogo.png");
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
			loginBtn.setBounds(1240, 20, 100, 30);
			loginBtn.setOpaque(false); // 투명하게
			loginBtn.setBorderPainted(false);// 외곽선 없애줌
			loginBtn.setFont(new Font("로그인", Font.BOLD, 12));
			loginBtn.setBackground(mainRed);
			loginBtn.setForeground(Color.white);
			loginBtn.addActionListener(this);
			headerPn.add(loginBtn);

			// SignBtn
			signupBtn = new JButton("회원가입");
			signupBtn.setBounds(1180, 20, 100, 30);
			signupBtn.setOpaque(false); // 투명하게
			signupBtn.setBorderPainted(false);// 외곽선 없애줌
			signupBtn.setFont(new Font("회원가입", Font.BOLD, 12));
			signupBtn.setBackground(mainRed);
			signupBtn.setForeground(Color.white);
			signupBtn.addActionListener(this);
			headerPn.add(signupBtn);
		}else {
			// logoutBtn
			logoutBtn = new JButton("로그아웃");
			logoutBtn.setBounds(1240, 20, 100, 30);
			logoutBtn.setOpaque(false); // 투명하게
			logoutBtn.setBorderPainted(false);// 외곽선 없애줌
			logoutBtn.setFont(new Font("로그아웃", Font.BOLD, 12));
			logoutBtn.setBackground(mainRed);
			logoutBtn.setForeground(Color.white);
			logoutBtn.addActionListener(this);
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
		searchBtn.addActionListener(this);
		sidePn.add(searchBtn);

		// catePn
		catePn = new JPanel();
		catePn.setLayout(new GridLayout(3, 3, 10, 10));
		catePn.setBounds(25, 290, 350, 350);
		catePn.setBackground(Color.WHITE);

		for(int i=0; i < categoryList.size(); i++) {
			ImageIcon categoryImage = new ImageIcon(iconImgUrl + categoryList.get(i).getTitle() +".png");

			JPanel category = new JPanel() {
				public void paintComponent(Graphics g) {
					g.drawImage(categoryImage.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponents(g);
				}
			};
			category.setBorder(new LineBorder(commonRedColor, 2));
			category.setName(categoryList.get(i).getSeq()+"");
			category.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					int seq = Integer.parseInt(category.getName());

					Delegator delegator = Delegator.getInstance();
					delegator.itemBbsController.SelectItemCategories(seq);
					dispose();
				}
			});
			catePn.add(category);
		}

		sidePn.add(catePn);

		listPn = new JPanel();
		listPn.setLayout(null);
		int thumPnCount = (100 / 2) + 1;

		listPn.setPreferredSize(new Dimension(1280, 170 * thumPnCount));
		listPn.setLocation(0, 0);
		listPn.setBackground(mainPink);

		addBtn = new JButton("+");
		addBtn.setBounds(170, 35, 100, 50);
		addBtn.addActionListener(this);

		// thumPn
		thumPn = new JPanel();
		thumPn.setLayout(null);
		thumPn.setBounds(15, 50, 440, 120);
		thumPn.setBorder(new LineBorder(mainRed, 1));
		thumPn.setBackground(Color.white);
		thumPn.add(addBtn);

		int j = 0;
		for (int i = 0; i < itemList.size(); i++) {

			thumPn1 = new JPanel();
			thumPn1.setLayout(null);

			if (i % 2 == 0) { // 짝수일때(새로운 줄로 넘어갈때)
				thumPn1.setBounds(460, (170 * j) + 50, 440, 120);
				thumPn1.setName(String.valueOf(i));

				if(itemList.get(i).getImgurl1() == null) {
					imgLa = new JLabel(new ImageIcon("/Users/leefrances/Desktop/noimage.png"));
				}else {
					imgLa = new JLabel(new ImageIcon(itemList.get(i).getImgurl1()));
				}
				txtLa = new JLabel("<html>"+ itemList.get(i).getTitle() +"<br/>"+
						itemList.get(i).getContent()+"</html>");
				imgLa.setBounds(0, 0, 200, 120);
				imgLa.setBorder(new LineBorder(mainRed, 1));
				txtLa.setBounds(200, 0, 300, 120);
				thumPn1.add(txtLa);
				thumPn1.add(imgLa);
				j++;

			} else {
				thumPn1.setBounds(15, (170 * j) + 50, 440, 120);
				thumPn1.setName(String.valueOf(i));
				if(itemList.get(i).getImgurl1() == null) {
					imgLa = new JLabel(new ImageIcon("/Users/leefrances/Desktop/noimage.png"));
				}else {
					imgLa = new JLabel(new ImageIcon(itemList.get(i).getImgurl1()));
				}
				txtLa = new JLabel("<html>"+ itemList.get(i).getTitle() +"<br/>"+
						itemList.get(i).getContent()+"</html>");
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


		add(sidePn);
		add(headerPn);

		listPn.add(thumPn);
		JScrollPane scroll;
		scroll = new JScrollPane(listPn);
		scroll.setBounds(400, 60, 935, 990);
		scroll.setBackground(mainPink);
		add(sidePn);
		add(headerPn);
		add(scroll);

		setBounds(0, 0, 1350, 750);

		setLayout(null);
		setVisible(true);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Delegator delegator = Delegator.getInstance();
		Object obj = e.getSource();
		Person personDto = null;

		if( obj== addBtn ) {
			System.out.println("addBtn Click");

			personDto = delegator.getCurrent_user();

			if(personDto == null) {
				delegator.personController.Login();
				this.dispose();
			}else {
				delegator.itemBbsController.itemWrite(personDto);
				this.dispose();
			}
		}else if(obj == loginBtn) {
			delegator.personController.Login();
			this.dispose();
		}else if(obj == signupBtn) {
			delegator.personController.SignUp();
			this.dispose();
		}else if(obj == logoutBtn) {
			delegator.personController.Logout();
			this.dispose();
		}else if(obj == searchBtn) {
			System.out.println("searchBtn Click");
			String searchWord = searchTextF.getText();
			System.out.println("searchTextF :" + searchTextF);

			delegator.itemBbsController.searchList(searchWord);

		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		JPanel thumPn1 = (JPanel)e.getComponent();
		this.thumPn1 = thumPn1;

		Object obj = e.getSource();



		Delegator delegator = Delegator.getInstance();
		ItemBbs itemSelect = null;
		int itemNum = 0;
		int category_id = 99;

		//List event
		if(obj == thumPn1 && obj != headerLogo && obj != cate1 && obj != cate2 && obj != cate3 && obj != cate4
				&& obj != cate5 && obj != cate6 && obj != cate7 && obj != cate8 && obj != cate9) {
			System.out.println("thumPn1 GetName==>"+thumPn1.getName());
			itemNum = Integer.parseInt(thumPn1.getName());

			if(!m_itemList.isEmpty()) {
				itemSelect = m_itemList.get(itemNum);
				delegator.itemBbsController.itemDetail(itemSelect);
				this.dispose();
			}
		}

		//Header event
		if(obj == headerLogo){
			delegator.mainController.Main();
			this.dispose();
		}

		//Side Category event
		if(obj == cate1){
			category_id = Integer.parseInt(cate1.getName());
			delegator.itemBbsController.SelectItemCategories(category_id);
			this.dispose();
		}else if(obj == cate2) {
			category_id = Integer.parseInt(cate2.getName());
			delegator.itemBbsController.SelectItemCategories(category_id);
			this.dispose();
		}else if(obj == cate3) {
			category_id = Integer.parseInt(cate3.getName());
			delegator.itemBbsController.SelectItemCategories(category_id);
			this.dispose();
		}else if(obj == cate4) {
			category_id = Integer.parseInt(cate4.getName());
			delegator.itemBbsController.SelectItemCategories(category_id);
			this.dispose();
		}else if(obj == cate5) {
			category_id = Integer.parseInt(cate5.getName());
			delegator.itemBbsController.SelectItemCategories(category_id);
			this.dispose();
		}else if(obj == cate6) {
			category_id = Integer.parseInt(cate6.getName());
			delegator.itemBbsController.SelectItemCategories(category_id);
			this.dispose();
		}else if(obj == cate7) {
			category_id = Integer.parseInt(cate7.getName());
			delegator.itemBbsController.SelectItemCategories(category_id);
			this.dispose();
		}else if(obj == cate8) {
			category_id = Integer.parseInt(cate8.getName());
			delegator.itemBbsController.SelectItemCategories(category_id);
			this.dispose();
		}else if(obj == cate9) {
			category_id = Integer.parseInt(cate9.getName());
			delegator.itemBbsController.SelectItemCategories(category_id);
			this.dispose();
		}


	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}

}
