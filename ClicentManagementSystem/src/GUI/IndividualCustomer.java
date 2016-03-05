package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import MS.*;

public class IndividualCustomer extends JFrame {
	private JButton b1;
	private IndividualCustomer me = this;
	private ManagerInterface father;
	private CustomerLogin cl;
	private String signal;
	private JTable table;
	private JLabel l1,l2,l3,l4;
	private ShowInformation s = new ShowInformation();
	private String[][] rowData;
	private int ty = 0;

	public IndividualCustomer(ManagerInterface mi,CustomerLogin cl) {
		super("欢迎登录个人客户主页");
		
		if(cl != null){
			this.signal = cl.getSignal();//此处需要显示客户的全部个人信息
		}else{
			ty = 1;
			this.father = mi;
			this.signal = mi.getSignal();
		}
		
		rowData = s.ShowIP(signal);
		
		Container c = getContentPane();
		c.setLayout(null);
		Init();
		c.add(b1);
		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(l4);
	
		this.setBounds(300, 200, 700, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void Init() {
		ButtonInit();
		LabelInit();
	}

	private void ButtonInit() {
		b1 = new JButton("退出");
		b1.setBounds(260, 300, 130, 30);
		b1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(ty != 0){
					me.dispose();
					father.setVisible(true);
				}else{
					System.exit(0);
					
				}
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

		l4 = new JLabel("signal :"+rowData[0][3]);
		l4.setBounds(250, 140, 300, 50);
		l4.setFont(new Font("", 0, 21));
	}
}
