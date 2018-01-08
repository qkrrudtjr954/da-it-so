package admin;

import java.awt.Color;
import java.awt.Component;
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

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controller.ItemBbsController;
import delegator.Delegator;
import dto.ItemBbs;
import dto.Person;

public class AdminItemDetail extends JFrame implements ActionListener,MouseListener {
	private JPanel headerPn, headerLogo, sidePn, logoPn, catePn, cate1, cate2, cate3, cate4, cate5, cate6, cate7, cate8,
			cate9, imagePannel, iteminfoPn, itemImagePn, subimagePn, detailPn, subimage1, subimage2, subimage3,
			subimage4, keywordPanel;
	private JButton loginBtn, logoutBtn, signupBtn, MypageBtn, searchBtn, talkBtn, chatBtn;
	private JButton itemListBtn, userListBtn, abilityListBtn;
	private JTextField searchTextF;
	private JLabel titleLb, sellLb, detailtitleLb, priceLb, keywardLb, cateLb, explanationLb;

	String iconImgUrl = "C:\\icon\\";
	Person person = null;
	ItemBbs item = null; 
	public AdminItemDetail(ItemBbs itemDto, Person person) {
		
		this.item = itemDto;
		this.person = person;
		
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

		// sidePn.setBounds(0, 60, 400, 1000);
		// imagePannel
		imagePannel = new JPanel();
		imagePannel.setBounds(70, 20, 420, 650);
		imagePannel.setLayout(null);
		imagePannel.setBorder(new LineBorder(Color.red, 2));
		imagePannel.setBackground(Color.white);
		// titleLb
		titleLb = new JLabel(item.getTitle());
		titleLb.setFont(new Font(item.getTitle(), Font.BOLD, 25));
		titleLb.setBounds(10, 30, 400, 30);
		titleLb.setOpaque(false);
		titleLb.setBackground(Color.DARK_GRAY);

		imagePannel.add(titleLb);
		// Seller
		
		sellLb = new JLabel(person.getId());
		sellLb.setBounds(10, 75, 400, 20);
		sellLb.setFont(new Font(person.getId(), Font.BOLD, 12));
		sellLb.setOpaque(false);

		imagePannel.add(sellLb);
		// itemImage
		itemImagePn = new JPanel() {
			ImageIcon itemImage = new ImageIcon(item.getImgurl1());

			public void paintComponent(Graphics g) {
				g.drawImage(itemImage.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		itemImagePn.setBounds(10, 115, 400, 500);
		imagePannel.add(itemImagePn);

		// itemsub
		subimagePn = new JPanel();
		subimagePn.setLayout(new GridLayout(1, 4, 10, 5));
		subimagePn.setBounds(10, 530, 400, 90);
		// subimagePn.setBackground(Color.PINK);

		// 서브 이미지1
		subimage1 = new JPanel() {
			ImageIcon image1 = new ImageIcon(item.getImgurl1());

			public void paintComponent(Graphics g) {
				g.drawImage(image1.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		subimagePn.add(subimage1);

		// 서브이미지2
		subimage2 = new JPanel() {
			ImageIcon image2 = new ImageIcon(item.getImgurl2());

			public void paintComponent(Graphics g) {
				g.drawImage(image2.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		subimagePn.add(subimage2);
		// 서브이미지3
		subimage3 = new JPanel() {
			ImageIcon image3 = new ImageIcon(item.getImgurl3());

			public void paintComponent(Graphics g) {
				g.drawImage(image3.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		subimagePn.add(subimage3);

		// 서브이미지4
		subimage4 = new JPanel() {
			ImageIcon image4 = new ImageIcon(item.getImgurl4());

			public void paintComponent(Graphics g) {
				g.drawImage(image4.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		subimagePn.add(subimage4);

		imagePannel.add(subimagePn);
		detailPn.add(imagePannel);

		// itemdetailPn

		iteminfoPn = new JPanel();
		iteminfoPn.setLayout(null);
		iteminfoPn.setBounds(580, 135, 340, 400);
		iteminfoPn.setBackground(Color.white);
		iteminfoPn.setBorder(new LineBorder(Color.red,2));

		// detailtitleLb
		detailtitleLb = new JLabel(item.getTitle());
		detailtitleLb.setBounds(10, 10, 340, 30);
		detailtitleLb.setFont(new Font(item.getTitle(), Font.BOLD, 20));
		iteminfoPn.add(detailtitleLb);
	

		// detailprice
		priceLb = new JLabel(item.getPrice() + "");
		priceLb.setBounds(10, 40, 340, 30);
		priceLb.setFont(new Font(item.getPrice() + "", Font.BOLD, 15));
		iteminfoPn.add(priceLb);

		// keyword
		
		String key = item.getKeyword();
		System.out.println("key값 : "+key);
		int rowSize = 0;
		String[] keyarray;
		keyarray = new String[rowSize * 3]; 
		keyarray = key.split("-key-");
		System.out.println("keyarray:"+keyarray[0]);
		System.out.println("keyarraylength :"+keyarray.length);
	
		if(keyarray.length%3 == 0) {
			rowSize = keyarray.length/3;
		}else {
			rowSize = keyarray.length/3+1;
		}
		
		JPanel keywordPanel = new JPanel();
		keywordPanel.setLocation(10, 70);
		keywordPanel.setSize(240, 30*rowSize);
		keywordPanel.setBackground(Color.white);
		keywordPanel.setLayout(null);
		
		JLabel keywordLabel[][] = new JLabel[rowSize][3];
	
		int k=0;
		for(int i=0; i<rowSize; i++) {
			for(int j=0; j<keyarray.length; j++) {
			
				keywordLabel[i][j]= new JLabel();
				keywordLabel[i][j].setOpaque(true);
				keywordLabel[i][j].setBackground(Color.pink);
				keywordLabel[i][j].setHorizontalAlignment(SwingConstants.LEFT);
				keywordLabel[i][j].setText("#"+keyarray[k]);
				keywordLabel[i][j].setSize(70, 30);
				keywordLabel[i][j].setLocation((j*80), (i*40));
				System.out.println(keywordLabel[i][j].getBounds());
				keywordPanel.add(keywordLabel[i][j]);
				k++;
			}
		}
		
		iteminfoPn.add(keywordPanel);
		
		//categori
		cateLb = new JLabel("카테고리 : "+item.getCategory_id()); 
		cateLb.setBounds(10, 100, 80, 30);
		cateLb.setOpaque(true);
		cateLb.setBackground(Color.white);
		iteminfoPn.add(cateLb);

		//item explanation
		explanationLb = new JLabel("저품 설명 : "+item.getContent());
		explanationLb.setBounds(10,150 , 300, 10*item.getContent().length());
		explanationLb.setOpaque(true);
		explanationLb.setBackground(Color.white);
		explanationLb.setVerticalAlignment(SwingConstants.TOP);
		iteminfoPn.add(explanationLb);
		
		

		// chatBtn
		chatBtn = new JButton(new ImageIcon(iconImgUrl + "chatting.png"));
		chatBtn.setBounds(630, 555, 240, 34);
		chatBtn.setOpaque(false);
		chatBtn.setBorderPainted(false);
		chatBtn.setFocusPainted(false);

		detailPn.add(chatBtn);
		detailPn.add(iteminfoPn);

		contentPane.add(sidePn);
		contentPane.add(headerPn);
		contentPane.add(scrollPane);
		
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
