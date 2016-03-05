/**
 * @author RenYali
 */
package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import MS.*;

public class GroupCustomerInterface extends JFrame {
	private JButton b1, b2;
	private GroupCustomerInterface me = this;
	private ManagerInterface father;
	private String signal;
	private JLabel l1,l2,l3,l4;
	private String[][] rowData;
	private ShowInformation s = new ShowInformation();

	public GroupCustomerInterface(ManagerInterface mi, CustomerLogin cl) {
		super("欢迎登录集团客户主页");
		this.father = mi;
		if (mi == null) {
			signal = cl.getSignal();// ////此处需要显示客户的全部个人信息
		} else {
			signal = mi.getSignal();
		}
		rowData = s.ShowGP(signal);

		Container c = getContentPane();
		c.setLayout(null);
		Init();
		c.add(b1);
		c.add(b2);
		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(l4);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 200, 700, 400);
		setVisible(true);
	}

	private void Init() {
		ButtonInit();
		LabelInit();
	}

	private void ButtonInit() {
		b1 = new JButton("联系人信息");
		b1.setBounds(200, 300, 130, 30);
		b1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				me.dispose();
				new LinkmanInterface(me);
			}

		});
		b2 = new JButton("退出");
		b2.setBounds(350, 300, 130, 30);
		b2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(father != null){
					me.dispose();
					father.setVisible(true);
				}else{
				System.exit(0);
				}
			}

		});
	}

	private void LabelInit() {
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

	public String getSignal() {
		return signal;
	}
}
