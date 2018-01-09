package view;

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
import dto.AbilityBbs;
import dto.Category;
import dto.ItemBbs;
import dto.Person;

public class AbilityDetail extends JFrame implements ActionListener,MouseListener {
	private JPanel headerPn, headerLogo, sidePn, logoPn, catePn, cate1, cate2, cate3, cate4, cate5, cate6, cate7, cate8,
			cate9, imagePannel, iteminfoPn, itemImagePn, subimagePn, detailPn, subimage1, subimage2, subimage3,
			subimage4;
	private JButton loginBtn, logoutBtn, signupBtn, MypageBtn, searchBtn, talkBtn, chatBtn;
	private JTextField searchTextF;
	private JLabel titleLb, sellLb, detailtitleLb, cateLb, explanationLb;

	String iconImgUrl = "C:\\icon\\";
	AbilityBbs m_abilityDto = null;
	List<Category> m_categoryList = null;
	
	//삭제버튼추가필요
	//완료 버튼 추가 시 STATE 1로 변경 STATE = 0 등록시 STATE = 1 완료 STATE = 2 삭제 STATE = 3 관리자에의한 삭제
	public AbilityDetail(AbilityBbs abilityDto, List<Category> categoryList) {

		Delegator delegator = Delegator.getInstance();
		this.m_abilityDto = abilityDto;
		this.m_categoryList = categoryList;
		
		Container cn = getContentPane();
		
		cn.setBounds(0, 0, 1350, 750);
		cn.setBackground(Color.white);

		// Header
		Color commonColor = new Color(218, 0, 0);
		headerPn = new JPanel();
		headerPn.setBackground(commonColor);
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
			loginBtn.setBounds(1240, 20, 100, 30);
			loginBtn.setOpaque(false); // 투명하게
			loginBtn.setBorderPainted(false);// 외곽선 없애줌
			loginBtn.setFont(new Font("로그인", Font.BOLD, 12));
			loginBtn.setBackground(commonColor);
			loginBtn.setForeground(Color.white);
			loginBtn.addActionListener(this);
			headerPn.add(loginBtn);
			
			// SignBtn
			signupBtn = new JButton("회원가입");
			signupBtn.setBounds(1180, 20, 100, 30);
			signupBtn.setOpaque(false); // 투명하게
			signupBtn.setBorderPainted(false);// 외곽선 없애줌
			signupBtn.setFont(new Font("회원가입", Font.BOLD, 12));
			signupBtn.setBackground(commonColor);
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
			logoutBtn.setBackground(commonColor);
			logoutBtn.setForeground(Color.white);
			logoutBtn.addActionListener(this);
			headerPn.add(logoutBtn);			
		}

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
		
		String category_id[] = new String[9];
		
		for (int i = 0; i < m_categoryList.size(); i++) {
			category_id[i] = String.valueOf(m_categoryList.get(i).getSeq()); 
		}

		ImageIcon cate1Image = new ImageIcon(iconImgUrl + "1.png");
		cate1 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(cate1Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate1.setBorder(new LineBorder(commonColor, 3));
		
		if(category_id[0] != null) {
			cate1.setName(category_id[0]);
			cate1.addMouseListener(this);
		}

		//  2
		ImageIcon cate2Image = new ImageIcon(iconImgUrl + "2.png");
		cate2 = new JPanel() {
			
			public void paintComponent(Graphics g) {
				g.drawImage(cate2Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate2.setBorder(new LineBorder(commonColor, 3));
		if(category_id[1] != null) {
			cate2.setName(category_id[1]);
			cate2.addMouseListener(this);
		}
		//  3
		ImageIcon cate3Image = new ImageIcon(iconImgUrl + "3.png");
		cate3 = new JPanel() {
			
			public void paintComponent(Graphics g) {
				g.drawImage(cate3Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate3.setBorder(new LineBorder(commonColor, 3));
		if(category_id[2] != null) {
			cate3.setName(category_id[2]);
			cate3.addMouseListener(this);
		}
		// 4
		ImageIcon cate4Image = new ImageIcon(iconImgUrl + "4.png");
		cate4 = new JPanel() {
			
			public void paintComponent(Graphics g) {
				g.drawImage(cate4Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate4.setBorder(new LineBorder(commonColor, 3));

		if(category_id[3] != null) {
			cate4.setName(category_id[3]);
			cate4.addMouseListener(this);
		}
		
		//  5
		ImageIcon cate5Image = new ImageIcon(iconImgUrl + "5.png");
		cate5 = new JPanel() {
			
			public void paintComponent(Graphics g) {
				g.drawImage(cate5Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate5.setBorder(new LineBorder(commonColor, 3));
		if(category_id[4] != null) {
			cate5.setName(category_id[4]);
			cate5.addMouseListener(this);
		}
		//  6
		ImageIcon cate6Image = new ImageIcon(iconImgUrl + "6.png");
		cate6 = new JPanel() {
			
			public void paintComponent(Graphics g) {
				g.drawImage(cate6Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate6.setBorder(new LineBorder(commonColor, 3));
		if(category_id[5] != null) {
			cate6.setName(category_id[5]);
			cate6.addMouseListener(this);
		}
		// 7
		ImageIcon cate7Image = new ImageIcon(iconImgUrl + "7.png");
		cate7 = new JPanel() {
			
			public void paintComponent(Graphics g) {
				g.drawImage(cate7Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate7.setBorder(new LineBorder(commonColor, 3));
		
		if(category_id[6] != null) {
			cate7.setName(category_id[6]);
			cate7.addMouseListener(this);
		}

		ImageIcon cate8Image = new ImageIcon(iconImgUrl + "8.png");
		cate8 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(cate8Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate8.setBorder(new LineBorder(commonColor, 3));
		
		if(category_id[7] != null) {
			cate8.setName(category_id[7]);
			cate8.addMouseListener(this);
		}
		// 9
		ImageIcon cate9Image = new ImageIcon(iconImgUrl + "9.png");
		cate9 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(cate9Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		cate9.setBorder(new LineBorder(commonColor, 3));
		if(category_id[8] != null) {
			cate9.setName(category_id[8]);
			cate9.addMouseListener(this);
		}
		
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

		// imagePannel
		imagePannel = new JPanel();
		imagePannel.setBounds(70, 20, 420, 650);
		imagePannel.setLayout(null);
		imagePannel.setBorder(new LineBorder(Color.red, 2));
		imagePannel.setBackground(Color.white);
		// titleLb
		titleLb = new JLabel(m_abilityDto.getTitle());
		titleLb.setFont(new Font(m_abilityDto.getTitle(), Font.BOLD, 25));
		titleLb.setBounds(10, 30, 400, 30);
		titleLb.setOpaque(false);
		titleLb.setBackground(Color.DARK_GRAY);

		imagePannel.add(titleLb);
		
		// Seller
		
		sellLb = new JLabel("작성자 : "+m_abilityDto.getUser_id());
		sellLb.setBounds(10, 75, 400, 20);
		sellLb.setFont(new Font(m_abilityDto.getUser_id(), Font.BOLD, 12));
		sellLb.setOpaque(false);

		imagePannel.add(sellLb);
		// itemImage
		itemImagePn = new JPanel() {
			ImageIcon itemImage = new ImageIcon(m_abilityDto.getImgurl1());

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
			ImageIcon image1 = new ImageIcon(m_abilityDto.getImgurl1());

			public void paintComponent(Graphics g) {
				g.drawImage(image1.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		subimagePn.add(subimage1);

		// 서브이미지2
		subimage2 = new JPanel() {
			ImageIcon image2 = new ImageIcon(m_abilityDto.getImgurl2());

			public void paintComponent(Graphics g) {
				g.drawImage(image2.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		subimagePn.add(subimage2);
		// 서브이미지3
		subimage3 = new JPanel() {
			ImageIcon image3 = new ImageIcon(m_abilityDto.getImgurl3());

			public void paintComponent(Graphics g) {
				g.drawImage(image3.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		subimagePn.add(subimage3);

		// 서브이미지4
		subimage4 = new JPanel() {
			ImageIcon image4 = new ImageIcon(m_abilityDto.getImgurl4());

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
		iteminfoPn.setBounds(550, 135, 340, 400);
		iteminfoPn.setBackground(Color.white);
		iteminfoPn.setBorder(new LineBorder(Color.red,2));

		// detailtitleLb
		detailtitleLb = new JLabel(m_abilityDto.getTitle());
		detailtitleLb.setBounds(10, 10, 340, 30);
		detailtitleLb.setFont(new Font(m_abilityDto.getTitle(), Font.BOLD, 20));
		iteminfoPn.add(detailtitleLb);

		// Ability
		
		String key = m_abilityDto.getAbility();
		System.out.println("key값 : "+key);
		int rowSize = 0;
		String[] keyarray;
		keyarray = new String[rowSize * 3]; 
		keyarray = key.split("-key-");
	
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
				
				keywordPanel.add(keywordLabel[i][j]);
				k++;
			}
		}
		
		iteminfoPn.add(keywordPanel);
		
		//categori
		cateLb = new JLabel("카테고리 : "+m_abilityDto.getCategory_id()); 
		cateLb.setBounds(10, 100, 80, 30);
		cateLb.setOpaque(true);
		cateLb.setBackground(Color.white);
		iteminfoPn.add(cateLb);

		//item explanation
		explanationLb = new JLabel("저품 설명 : "+m_abilityDto.getContent());
		explanationLb.setBounds(10,150 , 300, 10*m_abilityDto.getContent().length());
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

		add(sidePn);
		add(headerPn);
		add(scrollPane);
		setBounds(0, 0, 1350, 750);
		setLayout(null);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();
		Delegator delegator = Delegator.getInstance();
		

		if (obj == talkBtn) {
			if (delegator.getCurrent_user() == null) {
				delegator.roomController.checkRoom(sellLb.getText());
				dispose();
			}
		} else if(obj == loginBtn) {
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
			delegator.abilityBbsController.searchList(searchWord);
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Delegator delegator = Delegator.getInstance();
		Object obj = e.getSource();
		int category_id = 99;
		
		//Header event
		if(obj == headerLogo){
			delegator.mainController.Main();
			this.dispose();
		}

		//Side Category event
		if(obj == cate1){
			category_id = Integer.parseInt(cate1.getName());
			delegator.abilityBbsController.SelectAbilityCategories(category_id);
			this.dispose();
		}else if(obj == cate2) {
			category_id = Integer.parseInt(cate2.getName());
			delegator.abilityBbsController.SelectAbilityCategories(category_id);
			this.dispose();
		}else if(obj == cate3) {
			category_id = Integer.parseInt(cate3.getName());
			delegator.abilityBbsController.SelectAbilityCategories(category_id);
			this.dispose();
		}else if(obj == cate4) {
			category_id = Integer.parseInt(cate4.getName());
			delegator.abilityBbsController.SelectAbilityCategories(category_id);
			this.dispose();
		}else if(obj == cate5) {
			category_id = Integer.parseInt(cate5.getName());
			delegator.abilityBbsController.SelectAbilityCategories(category_id);
			this.dispose();
		}else if(obj == cate6) {
			category_id = Integer.parseInt(cate6.getName());
			delegator.abilityBbsController.SelectAbilityCategories(category_id);
			this.dispose();
		}else if(obj == cate7) {
			category_id = Integer.parseInt(cate7.getName());
			delegator.abilityBbsController.SelectAbilityCategories(category_id);
			this.dispose();
		}else if(obj == cate8) {
			category_id = Integer.parseInt(cate8.getName());
			delegator.abilityBbsController.SelectAbilityCategories(category_id);
			this.dispose();
		}else if(obj == cate9) {
			category_id = Integer.parseInt(cate9.getName());
			delegator.abilityBbsController.SelectAbilityCategories(category_id);
			this.dispose();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}
