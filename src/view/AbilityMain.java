package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import dto.ItemBbs;
import dto.Person;

public class AbilityMain extends JFrame implements ActionListener {
	
	private JPanel headerPn, headerLogo, sidePn, logoPn, catePn, cate1, cate2, cate3, cate4, cate5, cate6, cate7, cate8, cate9;
	private JButton loginBtn, logoutBtn, signBtn, MypageBtn, searchBtn;
	private JTextField searchTextF;

	private JPanel listPn, thumPn, thumPn1, thumPn2;
	private JLabel imgLa, txtLa;
	private JButton addBtn;

	Color commonColor = new Color(218, 0, 0);
	Color mainRed = new Color(218, 0, 0);
	Color mainGray = new Color(250, 250, 250);
	Color mainPink = new Color(255, 174, 174);

	List<AbilityBbs> abilityList = null;
	
	public AbilityMain(List<AbilityBbs> abilityList) {
		
		this.abilityList = abilityList;
		
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
		for (int i = 0; i < abilityList.size(); i++) {

			thumPn1 = new JPanel();
			thumPn1.setLayout(null);

			thumPn2 = new JPanel();
			thumPn2.setLayout(null);
			
			if (i % 2 == 0) { // 짝수일때(새로운 줄로 넘어갈때)
				thumPn1.setBounds(525, (170 * j) + 50, 500, 120);
				imgLa = new JLabel(new ImageIcon("+ dto.getImgurl1() +"));
				txtLa = new JLabel(abilityList.get(i).getContent());
				imgLa.setBounds(0, 0, 200, 120);
				imgLa.setBorder(new LineBorder(mainRed, 1));
				txtLa.setBounds(200, 0, 300, 120);
				thumPn1.add(txtLa);
				thumPn1.add(imgLa);
				j++;
				
			} else {
				thumPn1.setBounds(15, (170 * j) + 50, 500, 120);
				imgLa = new JLabel(new ImageIcon(abilityList.get(i).getImgurl1()));
				txtLa = new JLabel(abilityList.get(i).getContent());
				imgLa.setBounds(0, 0, 200, 120);
				imgLa.setBorder(new LineBorder(mainRed, 1));
				txtLa.setBounds(200, 0, 300, 120);
				thumPn1.add(txtLa);
				thumPn1.add(imgLa);
			}

			thumPn1.setBorder(new LineBorder(mainRed, 1));
			thumPn1.setBackground(Color.white);

			listPn.add(thumPn1);
			
			// Header
			headerPn = new JPanel();
			headerPn.setBackground(commonColor);
			headerPn.setSize(1680, 60);
			headerPn.setLayout(null);
			
			// headerlogo
			ImageIcon headerimage = new ImageIcon("/Users/leefrances/Desktop/icon/headerlogo.png");
			headerLogo = new JPanel() {
				// ������°� ������
				public void paintComponent(Graphics g) {
					g.drawImage(headerimage.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponents(g);
				}
			};
			headerLogo.setBounds(15, 25, 71, 15);
			headerPn.add(headerLogo);
			// logoutBtn
			logoutBtn = new JButton("�α׾ƿ�");
			logoutBtn.setBounds(1250, 20, 100, 30);
			logoutBtn.setOpaque(false); // �����ϰ�
			logoutBtn.setBorderPainted(false);// �ܰ��� ������
			logoutBtn.setFont(new Font("�α׾ƿ�", Font.BOLD, 12));
			logoutBtn.setBackground(commonColor);
			logoutBtn.setForeground(Color.white);
			// loginBtn
			loginBtn = new JButton("�α���");
			loginBtn.setBounds(1190, 20, 100, 30);
			loginBtn.setOpaque(false); // �����ϰ�
			loginBtn.setBorderPainted(false);// �ܰ��� ������
			loginBtn.setFont(new Font("�α���", Font.BOLD, 12));
			loginBtn.setBackground(commonColor);
			loginBtn.setForeground(Color.white);
			// SignBtn
			signBtn = new JButton("ȸ������");
			signBtn.setBounds(1130, 20, 100, 30);
			signBtn.setOpaque(false); // �����ϰ�
			signBtn.setBorderPainted(false);// �ܰ��� ������
			signBtn.setFont(new Font("ȸ������", Font.BOLD, 12));
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
			
			ImageIcon image = new ImageIcon("/Users/leefrances/Desktop/icon/logo.png");
			logoPn = new JPanel() {
				// ������°� ������
				public void paintComponent(Graphics g) {
					g.drawImage(image.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponents(g);
				}
			};
			logoPn.setBounds(40, 30, 300, 66);
			sidePn.add(logoPn);
			
			// SearchText
			searchTextF = new JTextField("�˻���");
			searchTextF.setBounds(40, 160, 260, 40);
			searchTextF.setBorder(new LineBorder(commonColor, 5));
			sidePn.add(searchTextF);
			// searchBtn
			searchBtn = new JButton(new ImageIcon("/Users/leefrances/Desktop/icon/search.png"));
			searchBtn.setBounds(300, 160, 40, 40);
			searchBtn.setOpaque(false); // �����ϰ�
			// searchBtn.setBackground();
			searchBtn.setContentAreaFilled(false);// ���뿵�� ä���x
			sidePn.add(searchBtn);
			// catePn
			catePn = new JPanel();
			catePn.setLayout(new GridLayout(3, 3, 10, 10));
			catePn.setBounds(25, 290, 350, 350);
			catePn.setBackground(Color.WHITE);
			// ī�Ͱ�
			ImageIcon cate1Image = new ImageIcon("/Users/leefrances/Desktop/icon/1.png");
			cate1 = new JPanel() {
				// ������°� ������
				public void paintComponent(Graphics g) {
					g.drawImage(cate1Image.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponents(g);
				}
			};
			cate1.setBorder(new LineBorder(commonColor, 3));
			// ī�װ� 2
			ImageIcon cate2Image = new ImageIcon("/Users/leefrances/Desktop/icon/2.png");
			cate2 = new JPanel() {
				// ������°� ������
				public void paintComponent(Graphics g) {
					g.drawImage(cate2Image.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponents(g);
				}
			};
			cate2.setBorder(new LineBorder(commonColor, 3));
			// ī�װ� 3
			ImageIcon cate3Image = new ImageIcon("/Users/leefrances/Desktop/icon/3.png");
			cate3 = new JPanel() {
				// ������°� ������
				public void paintComponent(Graphics g) {
					g.drawImage(cate3Image.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponents(g);
				}
			};
			cate3.setBorder(new LineBorder(commonColor, 3));
			// ī�װ�4
			ImageIcon cate4Image = new ImageIcon("/Users/leefrances/Desktop/icon/4.png");
			cate4 = new JPanel() {
				// ������°� ������
				public void paintComponent(Graphics g) {
					g.drawImage(cate4Image.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponents(g);
				}
			};
			cate4.setBorder(new LineBorder(commonColor, 3));
			// ī�װ� 5
			ImageIcon cate5Image = new ImageIcon("/Users/leefrances/Desktop/icon/5.png");
			cate5 = new JPanel() {
				// ������°� ������
				public void paintComponent(Graphics g) {
					g.drawImage(cate5Image.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponents(g);
				}
			};
			cate5.setBorder(new LineBorder(commonColor, 3));
			// ī�װ� 6
			ImageIcon cate6Image = new ImageIcon("/Users/leefrances/Desktop/icon/6.png");
			cate6 = new JPanel() {
				// ������°� ������
				public void paintComponent(Graphics g) {
					g.drawImage(cate6Image.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponents(g);
				}
			};
			cate6.setBorder(new LineBorder(commonColor, 3));
			// ī�װ�7
			ImageIcon cate7Image = new ImageIcon("/Users/leefrances/Desktop/icon/7.png");
			cate7 = new JPanel() {
				// ������°� ������
				public void paintComponent(Graphics g) {
					g.drawImage(cate7Image.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponents(g);
				}
			};
			cate7.setBorder(new LineBorder(commonColor, 3));
			// ī�װ�8
			ImageIcon cate8Image = new ImageIcon("/Users/leefrances/Desktop/icon/8.png");
			cate8 = new JPanel() {
				// ������°� ������
				public void paintComponent(Graphics g) {
					g.drawImage(cate8Image.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponents(g);
				}
			};
			cate8.setBorder(new LineBorder(commonColor, 3));
			// ī�װ�9
			ImageIcon cate9Image = new ImageIcon("/Users/leefrances/Desktop/icon/9.png");
			cate9 = new JPanel() {
				// ������°� ������
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
		}
		
		add(sidePn);
		add(headerPn);
		
		listPn.add(thumPn);
		JScrollPane scroll;
		scroll = new JScrollPane(listPn);
		scroll.setBounds(400, 60, 1280, 990);
		scroll.setBackground(mainPink);
		add(scroll);
		setBounds(0, 0, 1680, 1050);
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
			
		}else {
			//delegator.itemBbsController.itemDetail(m_ItemDto);
		}
	}

}
