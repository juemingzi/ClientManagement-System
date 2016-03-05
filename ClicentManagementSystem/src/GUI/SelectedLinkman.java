/**
 * @author RenYali
 */
package GUI;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.*;

import MS.*;

public class SelectedLinkman extends JFrame {
	private JButton b1;
	private SelectedLinkman me = this;
	private String signal;
	private String[][] rowData;
	private ShowInformation s = new ShowInformation();
	private JLabel l1,l2,l3,l4,l5;
	private LinkmanInterface father;


	public SelectedLinkman(LinkmanInterface lk,String name) {
		super("联系人信息");
		this.father = lk;
		this.signal = lk.getSignal();
		rowData = s.ShowSGPL(signal,name);
		Container c = getContentPane();
		c.setLayout(null);
		Init();
		c.add(b1);
		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(l4);
		c.add(l5);
	
		this.setBounds(300, 200, 700, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void Init() {
		ButtonInit();
		LabelInit();
	}

	private void ButtonInit() {
		b1 = new JButton("返回");
		b1.setBounds(200, 300, 80, 30);
		b1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				me.dispose();
				father.setVisible(true);
			}

		});
	}

	private void LabelInit(){
		l1 = new JLabel("name :"+rowData[0][0]);
		l1.setBounds(250, 50, 300, 50);
		l1.setFont(new Font("", 0, 21));

		l2 = new JLabel("home_phone :"+rowData[0][1]);
		l2.setBounds(250, 80, 300, 50);
		l2.setFont(new Font("", 0, 21));

		l3 = new JLabel("email :"+rowData[0][2]);
		l3.setBounds(250, 110, 300, 50);
		l3.setFont(new Font("", 0, 21));

		l4 = new JLabel("work_phone :"+rowData[0][3]);
		l4.setBounds(250, 140, 300, 50);
		l4.setFont(new Font("", 0, 21));
		
		l5 = new JLabel("position :"+rowData[0][4]);
		l5.setBounds(250, 170, 300, 50);
		l5.setFont(new Font("", 0, 21));
	}
}
