package GUI;

/**
 * @author RenYali
 */
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import MS.*;

public class AddLinkman extends JFrame {
	private LinkmanInterface father;
	private JLabel l1, l2, l3, l4, l5;
	private JButton b1, b2;
	private JTextField t1, t2, t3, t4, t5;
	private AddLinkman me = this;
	private GroupCustomerInterface gci;
	private String signal;
	private ConnectDB cd = new ConnectDB();
	private String s1, s2, s3, s4, s5;

	public AddLinkman(LinkmanInterface lk,GroupCustomerInterface gci) {
		super("添加联系人");
		this.gci = gci;
		this.father = lk;
		this.signal = lk.getSignal();
		Container c = getContentPane();
		c.setLayout(null);
		Init();
		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(l4);
		c.add(l5);
		c.add(t1);
		c.add(t2);
		c.add(t3);
		c.add(t4);
		c.add(t5);
		c.add(b1);
		c.add(b2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 200, 700, 400);
		setVisible(true);
	}

	private void Init() {
		LabelInit();
		TextFieldInit();
		ButtonInit();
	}

	private void ButtonInit() {
		b1 = new JButton("添加");
		b1.setBounds(200, 300, 130, 30);
		
		
		b1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				s1 = t1.getText().trim();
				s2 = t2.getText().trim();
				s3 = t3.getText().trim();
				s4 = t4.getText().trim();
				s5 = t5.getText().trim();
				if (t1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "姓名不可为空", "提示",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					if (cd.addGPL(s1, s2, s3, s4, s5, signal)) {
						JOptionPane.showMessageDialog(null, "添加成功点击确定返回联系人主页",
								"提示", JOptionPane.INFORMATION_MESSAGE);
						me.dispose();
						//father.setVisible(true);
						new LinkmanInterface(gci);
					}
				}
			}

		});
		b2 = new JButton("取消");
		b2.setBounds(350, 300, 130, 30);
		b2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (true) {
					me.dispose();
					father.setVisible(true);
				}
			}

		});
	}

	private void LabelInit() {
		l1 = new JLabel("姓名");
		l1.setBounds(100, 60, 100, 50);
		l1.setFont(new Font("", 0, 21));

		l2 = new JLabel("住宅电话");
		l2.setBounds(100, 90, 100, 50);
		l2.setFont(new Font("", 0, 21));

		l3 = new JLabel("email");
		l3.setBounds(100, 120, 100, 50);
		l3.setFont(new Font("", 0, 21));

		l4 = new JLabel("办公电话");
		l4.setBounds(100, 150, 100, 50);
		l4.setFont(new Font("", 0, 21));

		l5 = new JLabel("职位");
		l5.setBounds(100, 180, 100, 50);
		l5.setFont(new Font("", 0, 21));
	}

	private void TextFieldInit() {
		t1 = new JTextField("");
		t1.setFont(new Font("", 0, 21));
		t1.setBounds(200, 60, 300, 30);

		t2 = new JTextField("");
		t2.setFont(new Font("", 0, 21));
		t2.setBounds(200, 90, 300, 30);

		t3 = new JTextField("");
		t3.setFont(new Font("", 0, 21));
		t3.setBounds(200, 120, 300, 30);

		t4 = new JTextField("");
		t4.setFont(new Font("", 0, 21));
		t4.setBounds(200, 150, 300, 30);

		t5 = new JTextField("");
		t5.setFont(new Font("", 0, 21));
		t5.setBounds(200, 180, 300, 30);
	}
	private String getString(){
		return signal;
	}
}
