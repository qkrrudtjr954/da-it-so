package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import controller.ItemBbsController;
import delegator.Delegator;
import dto.AbilityBbs;
import dto.Category;
import dto.ItemBbs;
import dto.Person;
import dto.listDto;

public class ListVIew extends JFrame implements ActionListener, MouseListener {
	
	int state;

	private JPanel listPn, thumPn, thumPn1, thumPn2;
	private JLabel imgLa, txtLa;
	private JButton addBtn;

	Delegator de = Delegator.getInstance();
	
	Color mainRed = new Color(218, 0, 0);
	Color mainGray = new Color(250, 250, 250);
	Color mainPink = new Color(255, 174, 174);
	
	ItemBbs Idto;
	AbilityBbs Adto; 
	
	public ListVIew(Category Cdto) {

		this.state = Cdto.getState();

		if (state == 0) {
			// 물건리스트를 띄운다
			// controller 통해서 dao의 ItemList 메소드로 보낸다(인자값 ItemBbs)
		showIList();
			
			
		} else if (state == 1) {
			// 인력리스트를 띄운다
			// controller 통해서 dao의 AbilityList 메소드로 보낸다(인자값 AbilityBbs)			
		showAList();
		}
	}

	public ItemBbs showIList() {
		
		Idto = new ItemBbs(1, 1, "eee", "puppies", "", 
				"", "", "", "/Users/leefrances/Desktop/puppies.jpg", 10000, "강쥐", "강쥐는 사랑입니다", "", 1);
		
		List<ItemBbs>list = de.itemBbsController.list(Idto);
		
		listPn = new JPanel();
		listPn.setLayout(null);
		int thumPnCount = (100 / 2) + 1;

		listPn.setPreferredSize(new Dimension(1280, 170 * thumPnCount));
		listPn.setLocation(0, 0);
		listPn.setBackground(mainPink);

		addBtn = new JButton("+");
		addBtn.setBounds(200, 35, 100, 50);
		// thumPn
		thumPn = new JPanel();
		thumPn.setLayout(null);
		thumPn.setBounds(15, 50, 500, 120);
		thumPn.setBorder(new LineBorder(mainRed, 1));
		thumPn.setBackground(Color.white);
		thumPn.add(addBtn);
		
		int j = 0;
		for (int i = 0; i < list.size(); i++) {

			thumPn1 = new JPanel();
			thumPn1.setLayout(null);

			thumPn2 = new JPanel();
			thumPn2.setLayout(null);

			if (i % 2 == 0) { // 짝수일때(새로운 줄로 넘어갈때)
				thumPn1.setBounds(525, (170 * j) + 50, 500, 120);
				imgLa = new JLabel(new ImageIcon(list.get(i).getMainimgurl()));
				imgLa.addMouseListener(this);
				txtLa = new JLabel(Idto.getTitle() + "\n" + list.get(i).getContent());
				txtLa.addMouseListener(this);
				
				imgLa.setBounds(0, 0, 200, 120);
				imgLa.setBorder(new LineBorder(mainRed, 1));
				txtLa.setBounds(200, 0, 300, 120);
				thumPn1.add(txtLa);
				thumPn1.add(imgLa);
				thumPn1.addMouseListener(this);

				j++;
			} else {
				thumPn1.setBounds(15, (170 * j) + 50, 500, 120);
				imgLa = new JLabel(new ImageIcon(list.get(i).getMainimgurl()));
				imgLa.addMouseListener(this);
				txtLa = new JLabel(Idto.getTitle() + "\n" + list.get(i).getContent());
				txtLa.addMouseListener(this);
				
				imgLa.setBounds(0, 0, 200, 120);
				imgLa.setBorder(new LineBorder(mainRed, 1));
				txtLa.setBounds(200, 0, 300, 120);
				thumPn1.add(txtLa);
				thumPn1.add(imgLa);
				thumPn1.addMouseListener(this);

			}

			thumPn1.setBorder(new LineBorder(mainRed, 1));
			thumPn1.setBackground(Color.white);

			listPn.add(thumPn1);
		}
		listPn.add(thumPn);
		JScrollPane scroll;
		scroll = new JScrollPane(listPn);
		scroll.setBounds(400, 60, 1280, 990);
		scroll.setBackground(mainPink);
		add(scroll);
		setBounds(0, 0, 1680, 1050);
		setLayout(null);
		setVisible(true);

		return Idto;
	}

	public AbilityBbs showAList() {

		Adto = new AbilityBbs(0, "eeeseoone", "developer", "/Users/leefrances/Desktop/developer.jpg",
				"", "", "", "개발5년차", "웹사이트 개발, 맡겨만주세요", "", 1);

		List<AbilityBbs> list = de.abilityBbsController.list(Adto);
		
		listPn = new JPanel();
		listPn.setLayout(null);
		int thumPnCount = (100 / 2) + 1;

		listPn.setPreferredSize(new Dimension(1280, 170 * thumPnCount));
		listPn.setLocation(0, 0);
		listPn.setBackground(mainPink);

		addBtn = new JButton("+");
		addBtn.setBounds(200, 35, 100, 50);
		// thumPn
		thumPn = new JPanel();
		thumPn.setLayout(null);
		thumPn.setBounds(15, 50, 500, 120);
		thumPn.setBorder(new LineBorder(mainRed, 1));
		thumPn.setBackground(Color.white);
		thumPn.add(addBtn);
		
		int j = 0;
		for (int i = 0; i < 10; i++) {

			thumPn1 = new JPanel();
			thumPn1.setLayout(null);

			thumPn2 = new JPanel();
			thumPn2.setLayout(null);

			if (i % 2 == 0) { // 짝수일때(새로운 줄로 넘어갈때)
				thumPn1.setBounds(525, (170 * j) + 50, 500, 120);
				imgLa = new JLabel(new ImageIcon(list.get(i).getMainimgurl()));
				imgLa.addMouseListener(this);
				
				txtLa = new JLabel(Adto.getTitle() + "\n" +list.get(i).getContent());
				txtLa.addMouseListener(this);
				
				imgLa.setBounds(0, 0, 200, 120);
				imgLa.setBorder(new LineBorder(mainRed, 1));
				txtLa.setBounds(200, 0, 300, 120);
				thumPn1.add(txtLa);
				thumPn1.add(imgLa);
				thumPn1.addMouseListener(this);
				j++;
			} else {
				thumPn1.setBounds(15, (170 * j) + 50, 500, 120);
				imgLa = new JLabel(new ImageIcon(list.get(i).getMainimgurl()));
				imgLa.addMouseListener(this);
				
				txtLa = new JLabel(Adto.getTitle() + "\n" + list.get(i).getMainimgurl());
				txtLa.addMouseListener(this);

				imgLa.setBounds(0, 0, 200, 120);
				imgLa.setBorder(new LineBorder(mainRed, 1));
				txtLa.setBounds(200, 0, 300, 120);
				thumPn1.add(txtLa);
				thumPn1.add(imgLa);
				thumPn1.addMouseListener(this);

			}
			thumPn1.setBorder(new LineBorder(mainRed, 1));
			thumPn1.setBackground(Color.white);

			listPn.add(thumPn1);
		}
		listPn.add(thumPn);
		JScrollPane scroll;
		scroll = new JScrollPane(listPn);
		scroll.setBounds(400, 60, 1280, 990);
		scroll.setBackground(mainPink);
		add(scroll);
		setBounds(0, 0, 1680, 1050);
		setLayout(null);
		setVisible(true);

		return Adto;
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		Person Pdto =  new Person();
		Pdto.setId("asd");
		
	//Idto = delegator 통해서 컨트롤러 통해서 서비스 통해서 dao  
		new DetailPageView(Idto, Pdto);
		System.out.println("iddto :"+Idto.getContent());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {


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
