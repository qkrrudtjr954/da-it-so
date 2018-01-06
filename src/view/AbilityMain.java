package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import dto.AbilityBbs;

public class AbilityMain extends JFrame implements ActionListener {
	
	int state;

	private JPanel listPn, thumPn, thumPn1, thumPn2;
	private JLabel imgLa, txtLa;
	private JButton addBtn;

	Color mainRed = new Color(218, 0, 0);
	Color mainGray = new Color(250, 250, 250);
	Color mainPink = new Color(255, 174, 174);

	AbilityBbs mAbilitydto;
	

	
	public AbilityMain(AbilityBbs dto) {
		
		mAbilitydto = dto;
		
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
		for (int i = 0; i < 100; i++) {

			thumPn1 = new JPanel();
			thumPn1.setLayout(null);

			thumPn2 = new JPanel();
			thumPn2.setLayout(null);
			
			if (i % 2 == 0) { // 짝수일때(새로운 줄로 넘어갈때)
				thumPn1.setBounds(525, (170 * j) + 50, 500, 120);
				imgLa = new JLabel(new ImageIcon("+ dto.getImgurl1() +"));
				txtLa = new JLabel(mAbilitydto.getContent());
				imgLa.setBounds(0, 0, 200, 120);
				imgLa.setBorder(new LineBorder(mainRed, 1));
				txtLa.setBounds(200, 0, 300, 120);
				thumPn1.add(txtLa);
				thumPn1.add(imgLa);
				j++;
				
			} else {
				thumPn1.setBounds(15, (170 * j) + 50, 500, 120);
				imgLa = new JLabel(new ImageIcon(dto.getImgurl1()));
				txtLa = new JLabel(mAbilitydto.getContent());
				imgLa.setBounds(0, 0, 200, 120);
				imgLa.setBorder(new LineBorder(mainRed, 1));
				txtLa.setBounds(200, 0, 300, 120);
				thumPn1.add(txtLa);
				thumPn1.add(imgLa);
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
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
