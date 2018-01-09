package admin;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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
import dto.Person;

public class AdminUserList extends JFrame implements ActionListener, MouseListener {

	private JButton searchBtn;
	private JTextField searchTextF;
	private JPanel headerLogo;
	
	List<Person> userList;
	
	JButton itemListBtn, abilityListBtn, userListBtn, chatBtn;
	
	int itemHeight = 80;

//	String icomImgimgUrl = "/Users/parker/Desktop/img/icon/";
	String icomImgimgUrl = "E:\\icon/";

	public AdminUserList(List<Person> userList) {

		this.userList = userList;
		Container contentPane = getContentPane();
		
		contentPane.setBounds(0, 0, 1680, 1050);
		contentPane.setBackground(Color.white);
		
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
		JPanel logoPn = new JPanel() {
			ImageIcon image = new ImageIcon(icomImgimgUrl + "logo.png");

			// 사이즈맞게 배경삽임
			public void paintComponent(Graphics g) {
				g.drawImage(image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};


		// Header
		Color commonRedColor = new Color(218, 0, 0);
		JPanel headerPn = new JPanel();
		headerPn.setBackground(commonRedColor);
		headerPn.setSize(1680, 60);
		headerPn.setLayout(null);

		// headerlogo
		headerLogo.setBounds(15, 25, 71, 15);
		headerPn.add(headerLogo);

		// sidePn
		Color sideC = new Color(250, 250, 250);
		JPanel sidePn = new JPanel();
		sidePn.setBounds(0, 60, 400, 1000);
		sidePn.setLayout(null);
		sidePn.setBackground(sideC);
		
		

		// logoPn
		logoPn.setBounds(40, 30, 300, 66);
		sidePn.add(logoPn);

		// SearchText
		searchTextF = new JTextField("검색어");
		searchTextF.setBounds(40, 160, 260, 40);
		searchTextF.setBorder(new LineBorder(commonRedColor, 5));
		sidePn.add(searchTextF);

		// searchBtn
		searchBtn = new JButton(new ImageIcon(icomImgimgUrl + "search.png"));
		searchBtn.setBounds(300, 160, 40, 40);
		searchBtn.setOpaque(false); // 투명하게
		searchBtn.setContentAreaFilled(false);// 내용영역 채우기x
		sidePn.add(searchBtn);

		// btnPanel
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(4, 1, 10, 10));
		btnPanel.setBounds(25, 290, 350, 350);
		btnPanel.setBackground(Color.WHITE);

		itemListBtn = new JButton("모든 상품글 보기 ");
		itemListBtn.setBorder(new LineBorder(commonRedColor, 2));
		itemListBtn.addActionListener(this);
		btnPanel.add(itemListBtn);

		abilityListBtn = new JButton("모든 인력글 보기 ");
		abilityListBtn.setBorder(new LineBorder(commonRedColor, 2));
		abilityListBtn.addActionListener(this);
		btnPanel.add(abilityListBtn);

		userListBtn = new JButton("모든 유저 정보 보기 ");
		userListBtn.setBorder(new LineBorder(commonRedColor, 2));
		userListBtn.addActionListener(this);
		btnPanel.add(userListBtn);
		
		chatBtn = new JButton("관리자 채팅 열기 ");
		chatBtn.setBorder(new LineBorder(commonRedColor, 2));
		chatBtn.addActionListener(this);
		btnPanel.add(chatBtn);

		sidePn.add(btnPanel);
		
		

		
		// main view
		int mainHeight = userList.size() * this.itemHeight;
		
		
		JPanel main = new JPanel();
		main.setLocation(400, 60);
		main.setPreferredSize(new Dimension(1260, mainHeight));
		main.setLayout(null);
		
		for(int i=0; i<userList.size(); i++) {
			JPanel itemPanel = new JPanel();
			itemPanel.setBounds(10, i*itemHeight, 930, itemHeight);
			itemPanel.setBorder(new LineBorder(commonRedColor));
			itemPanel.addMouseListener(this);
			itemPanel.setLayout(null);
			itemPanel.setBackground(Color.white);
			
			JLabel itemUser = new JLabel();
			itemUser.setText(i+"");
			itemUser.setBounds(10, 25, 130, 20);
			itemPanel.add(itemUser);
			
			JLabel itemTitle = new JLabel();	
			itemTitle.setText(userList.get(i).getId());
			itemTitle.setBounds(140, 20, 200, 20);
			itemPanel.add(itemTitle);
			
//			JLabel itemState = new JLabel();
//			if(itemList.get(i).getState() == 0) {
//				itemState.setText("게시중");
//			} else if(itemList.get(i).getState() == 1) {
//				itemState.setText("완료됨");
//			} else if(itemList.get(i).getState() == 2) {
//				itemState.setText("삭제됨");
//			} else if(itemList.get(i).getState() == 3) {
//				itemState.setText("관리자에 의해 삭제됨");
//			}
//			itemState.setBounds(630, 20, 150, 20);
//			itemPanel.add(itemState);
			
			JLabel itemCreated = new JLabel();
			itemCreated.setText(userList.get(i).getCreated_at());
			itemCreated.setBounds(780, 20, 150, 20);
			itemPanel.add(itemCreated);
			
			main.add(itemPanel);
		}
		
		
		JScrollPane jscPanel = new JScrollPane(main);
		jscPanel.setBounds(400, 60, 950, 690);
		
		
		contentPane.add(jscPanel);
		contentPane.add(sidePn);
		contentPane.add(headerPn);

		setBounds(0, 0, 1350, 750);
		setLayout(null);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Delegator delegator = Delegator.getInstance();
		Object obj = e.getSource();
		
		if(obj == itemListBtn) {
			delegator.adminController.ItemList();
			this.dispose();
		}else if(obj == abilityListBtn) {
			delegator.adminController.AbilityList();
			this.dispose();
		}else if(obj == userListBtn) {
			delegator.adminController.UserList();
			this.dispose();
		} else if(obj == chatBtn) {
			delegator.roomController.RoomList();
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		int y = e.getY();

		if ((y / itemHeight) < userList.size()) {
			Delegator delegator = Delegator.getInstance();
			delegator.adminController.AdminUserDetail(userList.get(y / itemHeight));
			this.dispose();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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
