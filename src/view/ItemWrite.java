package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

import delegator.Delegator;
import dto.AbilityBbs;
import dto.ItemBbs;
import dto.Person;

public class ItemWrite extends JFrame implements ActionListener, MouseListener{

	private JButton loginBtn, logoutBtn, signBtn, MypageBtn, searchBtn, imgAdd1, imgAdd2, imgAdd3, imgAdd4, writeBtn;
	private JTextField searchTextF, titleTextF, img1TextF, img2TextF, img3TextF, img4TextF, keywordTextF;
	private JTextPane contentTextPn;
	private JPanel headerLogo;
	private JComboBox cateCombo;
	
	String icomImgimgUrl = "C:\\icon\\";
	
	private JFileChooser jfc = new JFileChooser();
	private String filename1,filename2,filename3,filename4;
	
	private Person m_personDto;
	
	public ItemWrite(Person personDto) {
	
		m_personDto = personDto;
		
		JLabel cateLb, titleLb, imgLb1, imgLb2, imgLb3, imgLb4, keywLb, contentLb;
		
		JPanel headerPn, sidePn, logoPn, catePn, writePn, cate1, cate2, cate3, cate4, cate5, cate6, cate7, cate8,
		cate9;
		
		//header 
		headerLogo = new JPanel() {
			ImageIcon headerimage = new ImageIcon(icomImgimgUrl+"headerlogo.png");
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(headerimage.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		
		//logo
		logoPn = new JPanel() {
			ImageIcon image = new ImageIcon(icomImgimgUrl+"logo.png");
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		//category 1
		cate1 = new JPanel() {
			ImageIcon cate1Image = new ImageIcon(icomImgimgUrl+"1.png");
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate1Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		//category 2
		cate2 = new JPanel() {
			ImageIcon cate2Image = new ImageIcon(icomImgimgUrl+"2.png");
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate2Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		//category 3
		cate3 = new JPanel() {
			ImageIcon cate3Image = new ImageIcon(icomImgimgUrl+"3.png");
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate3Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		//category 4
		cate4 = new JPanel() {
			ImageIcon cate4Image = new ImageIcon(icomImgimgUrl+"4.png");
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate4Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		//category 5
		cate5 = new JPanel() {
			ImageIcon cate5Image = new ImageIcon(icomImgimgUrl+"5.png");
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate5Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		//category 6
		cate6 = new JPanel() {
			ImageIcon cate6Image = new ImageIcon(icomImgimgUrl+"6.png");
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate6Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		//category 7
		cate7 = new JPanel() {
			ImageIcon cate7Image = new ImageIcon(icomImgimgUrl+"7.png");
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate7Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		//category 8
		cate8 = new JPanel() {
			ImageIcon cate8Image = new ImageIcon(icomImgimgUrl+"8.png");
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate8Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		//category 9
		cate9 = new JPanel() {
			ImageIcon cate9Image = new ImageIcon(icomImgimgUrl+"9.png");
			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(cate9Image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		
		//mainView
		Container cn = getContentPane();

		cn.setBounds(0, 0, 1680, 1050);
		cn.setBackground(Color.white);

		setBounds(0, 0, 1680, 1050);
		setLayout(null);
		setVisible(true);

		// Header
		Color commonColor = new Color(218, 0, 0);
		headerPn = new JPanel();
		headerPn.setBackground(commonColor);
		headerPn.setSize(1680, 60);
		headerPn.setLayout(null);

		// headerlogo
		headerLogo.setBounds(15, 25, 71, 15);
		headerLogo.addMouseListener(this);
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
		
		// sidePn
		Color sideC = new Color(250, 250, 250);
		sidePn = new JPanel();
		sidePn.setBounds(0, 60, 400, 1000);
		sidePn.setLayout(null);
		sidePn.setBackground(sideC);
		
		//logoPn
		logoPn.setBounds(40, 30, 300, 66);
		sidePn.add(logoPn);

		// SearchText
		searchTextF = new JTextField("검색어");
		searchTextF.setBounds(40, 160, 260, 40);
		searchTextF.setBorder(new LineBorder(commonColor, 5));
		sidePn.add(searchTextF);

		// searchBtn
		searchBtn = new JButton(new ImageIcon(icomImgimgUrl+"search.png"));
		searchBtn.setBounds(300, 160, 40, 40);
		searchBtn.setOpaque(false); // 투명하게
		searchBtn.setContentAreaFilled(false);// 내용영역 채우기x
		sidePn.add(searchBtn);

		// catePn
		catePn = new JPanel();
		catePn.setLayout(new GridLayout(3, 3, 10, 10));
		catePn.setBounds(25, 290, 350, 350);
		catePn.setBackground(Color.WHITE);

		//category
		cate1.setBorder(new LineBorder(commonColor, 3));
		cate2.setBorder(new LineBorder(commonColor, 3));
		cate3.setBorder(new LineBorder(commonColor, 3));
		cate4.setBorder(new LineBorder(commonColor, 3));
		cate5.setBorder(new LineBorder(commonColor, 3));
		cate6.setBorder(new LineBorder(commonColor, 3));
		cate7.setBorder(new LineBorder(commonColor, 3));
		cate8.setBorder(new LineBorder(commonColor, 3));
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

		
		//listPn
		writePn = new JPanel();
		writePn.setLayout(null);
		writePn.setBounds(380, 30, 1050, 670);
		
		//category
		cateLb = new JLabel("카테고리");
		cateLb.setBounds(100, 100, 100, 30);		
		writePn.add(cateLb);
		
		String item[] = {"1","2","3","4","5","6","7","8","9"};
		cateCombo = new JComboBox(item);
		cateCombo.setBounds(210, 100, 150, 30);
		writePn.add(cateCombo);
		
		//title
		titleLb = new JLabel("제목");
		titleLb.setBounds(100, 150, 150, 30);
		writePn.add(titleLb);
		
		titleTextF = new JTextField();
		titleTextF.setBounds(210, 150, 150, 30);
		writePn.add(titleTextF);
		
		//img
		imgLb1 = new JLabel("사진1");
		imgLb1.setBounds(100, 190, 100, 30);
		writePn.add(imgLb1);
		
		img1TextF = new JTextField();
		img1TextF.setBounds(210, 190, 300, 30);
		writePn.add(img1TextF);
		
		imgAdd1 = new JButton("이미지 1");
		imgAdd1.setBounds(520, 190, 100, 30);
		imgAdd1.addActionListener(this);
		writePn.add(imgAdd1);
		
		imgLb2 = new JLabel("사진2");
		imgLb2.setBounds(100, 230, 100, 30);
		writePn.add(imgLb2);
		
		img2TextF = new JTextField();
		img2TextF.setBounds(210, 230, 300, 30);
		writePn.add(img2TextF);
		
		imgAdd2 = new JButton("이미지 2");
		imgAdd2.setBounds(520, 230, 100, 30);
		imgAdd2.addActionListener(this);
		writePn.add(imgAdd2);
		
		
		imgLb3 = new JLabel("사진3");
		imgLb3.setBounds(100, 270, 100, 30);
		writePn.add(imgLb3);
		
		img3TextF = new JTextField();
		img3TextF.setBounds(210, 270, 300, 30);
		writePn.add(img3TextF);
		
		imgAdd3 = new JButton("이미지 3");
		imgAdd3.setBounds(520, 270, 100, 30);
		imgAdd3.addActionListener(this);
		writePn.add(imgAdd3);
		
		imgLb4 = new JLabel("사진4");
		imgLb4.setBounds(100, 310, 100, 30);
		writePn.add(imgLb4);
		
		img4TextF = new JTextField();
		img4TextF.setBounds(210, 310, 300, 30);
		writePn.add(img4TextF);
		
		imgAdd3 = new JButton("이미지 4");
		imgAdd3.setBounds(520, 310, 100, 30);
		imgAdd3.addActionListener(this);
		writePn.add(imgAdd3);
		
		//keywLb
		keywLb = new JLabel("키워드");
		keywLb.setBounds(100, 350, 100, 30);
		writePn.add(keywLb);
		
		keywordTextF = new JTextField();
		keywordTextF.setBounds(210, 350, 300, 30);
		writePn.add(keywordTextF);
		
		//content
		contentLb = new JLabel("내용");
		contentLb.setBounds(100, 390, 100, 30);
		writePn.add(contentLb);
		
		contentTextPn = new JTextPane();
		contentTextPn.setBounds(210, 390, 410, 200);
		writePn.add(contentTextPn);
		
		writeBtn = new JButton("등록");
		writeBtn.setBounds(520, 610, 100, 30);
		writeBtn.addActionListener(this);
		writePn.add(writeBtn);
		
		add(sidePn);
		add(headerPn);
		add(writePn);
		
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		System.out.println("==>"+e.getActionCommand());
		if(e.getActionCommand().equals("회원가입")) {
			
		}
		
		if(e.getActionCommand().equals("이미지 1")){
            if(jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
                    // showopendialog 열기 창을 열고 확인 버튼을 눌렀는지 확인
                    img1TextF.setText(jfc.getSelectedFile().toString());
                    filename1 = jfc.getSelectedFile().getName();
                    
            }
		}
		
		if(e.getActionCommand().equals("이미지 2")){
            if(jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
                    // showopendialog 열기 창을 열고 확인 버튼을 눌렀는지 확인
                    img2TextF.setText(jfc.getSelectedFile().toString());
                    filename2 = jfc.getSelectedFile().getName();
            }
		}
		
		if(e.getActionCommand().equals("이미지 3")){
            if(jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
                    // showopendialog 열기 창을 열고 확인 버튼을 눌렀는지 확인
                    img3TextF.setText(jfc.getSelectedFile().toString());
                    filename3 = jfc.getSelectedFile().getName();
            }
		}
		
		if(e.getActionCommand().equals("이미지 4")){
            if(jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
                    // showopendialog 열기 창을 열고 확인 버튼을 눌렀는지 확인
                    img4TextF.setText(jfc.getSelectedFile().toString());
                    filename4 = jfc.getSelectedFile().getName();
            }
		}
		
		if(e.getActionCommand().equals("등록")) {
			
			if(!img1TextF.getText().isEmpty()) {
				filesend fs = new filesend(img1TextF.getText());
			}
			if(!img2TextF.getText().isEmpty()) {
				filesend fs = new filesend(img2TextF.getText());
			}
			if(!img3TextF.getText().isEmpty()) {
				filesend fs = new filesend(img3TextF.getText());
			}
			if(!img4TextF.getText().isEmpty()) {
				filesend fs = new filesend(img4TextF.getText());
			}
			
			ItemBbs itemDto = new ItemBbs();
			itemDto.setCategory_id(cateCombo.getSelectedIndex());
			itemDto.setTitle(titleTextF.getText());
			itemDto.setImgurl1(img1TextF.getText());
			itemDto.setImgurl2(img2TextF.getText());
			itemDto.setImgurl3(img3TextF.getText());
			itemDto.setImgurl4(img4TextF.getText());
			itemDto.setKeyword(keywordTextF.getText());
			itemDto.setContent(contentTextPn.getText());
			
			Delegator delegator = Delegator.getInstance();
			delegator.itemBbsController.itemDetail(itemDto,m_personDto);
			dispose();
		}


	}

		@Override
		public void mouseClicked(MouseEvent e) {
			//headerLogo 클릭 시 Main페이지로
			JPanel headerLogo = (JPanel)e.getComponent();
			
			if(e.getComponent().equals(headerLogo)) {
				Delegator delegator = Delegator.getInstance();
				delegator.abilityBbsController.main();
				dispose();
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
