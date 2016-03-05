package GUI;

/**
 * @author RenYali
 *
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import MS.*;

public class register extends JFrame {
	private JButton b1, b2;
	private CustomerLogin father;
	private JFrame me = this;
	private JLabel l1, l2, l3, l4, l5, l6, l7;
	private JTextField t1, t2, t3, t4, t5, t6;
	private boolean ty = false;
	private ConnectDB cd = new ConnectDB();

	public static void main(String[] args) {
		// new register();
	}

	public register(CustomerLogin cl) {

		super("用户注册");
		this.father = cl;
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				father.setVisible(true);
				super.windowClosing(e);

			}

		});

		Container c = getContentPane();
		c.setLayout(null);
		Init();

		c.add(b1);
		c.add(b2);
		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(l4);
		c.add(l5);
		c.add(l6);
		c.add(l7);
		c.add(t1);
		c.add(t2);
		c.add(t3);
		c.add(t4);
		c.add(t5);
		c.add(t6);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setBounds(300, 200, 700, 400);
		setVisible(true);
	}

	private void Init() {
		
		LableInit();
		TextFieldInit();
		ButtonInit();
	}

	private void ButtonInit() {
		b1 = new JButton("确定");
		b1.setBounds(200, 300, 130, 30);
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				String s1 = t1.getText().trim();
				String s2 = t2.getText().trim();
				String s3 = t3.getText().trim();
				String s4 = t4.getText().trim();
				String s5 = t5.getText().trim();
				String s6 = t6.getText().trim();
				String random = s1;
				if (s2.equals(s3) && s2 != null && s3 != null) {
					if (s6.equals("gp") || s6.equals("ip")) {
						if (s6.equals("gp")) {
							random = "gp"+random;
							if (cd.addGP(s1, s2, s4, s5, random)) {
								JOptionPane.showMessageDialog(null, "注册成功",
										"提示", JOptionPane.INFORMATION_MESSAGE);
								ty = true;
							} else {
								JOptionPane.showMessageDialog(null, "注册失败",
										"提示", JOptionPane.INFORMATION_MESSAGE);
							}
						} else {
							random = "ip"+random;
							if (cd.addIP(s1, s2, s4, s5, random)) {
								JOptionPane.showMessageDialog(null, "注册成功",
										"提示", JOptionPane.INFORMATION_MESSAGE);
								ty = true;
							} else {
								JOptionPane.showMessageDialog(null, "注册失败",
										"提示", JOptionPane.INFORMATION_MESSAGE);
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "请正确填写客户类型", "提示",
								JOptionPane.INFORMATION_MESSAGE);
						t6.setText("");
					}
				} else {
					JOptionPane.showMessageDialog(null, "两次密码不同，请重新设置", "提示",
							JOptionPane.INFORMATION_MESSAGE);
					t2.setText("");
					t3.setText("");
				}
				if (ty) {
					JOptionPane.showMessageDialog(null, "请用标识码登录：" + random,
							"提示", JOptionPane.INFORMATION_MESSAGE);
					father.setVisible(true);
					me.dispose();
				}
			}
		});

		b2 = new JButton("返回");
		b2.setBounds(350, 300, 130, 30);
		b2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				father.setVisible(true);
				me.dispose();
			}
		});
	}

	private void LableInit() {
		l1 = new JLabel("用户名");
		l1.setBounds(100, 50, 100, 50);
		l1.setFont(new Font("", 0, 21));

		l2 = new JLabel("密码");
		l2.setBounds(100, 80, 100, 50);
		l2.setFont(new Font("", 0, 21));

		l3 = new JLabel("再输密码");
		l3.setBounds(100, 110, 100, 50);
		l3.setFont(new Font("", 0, 21));

		l4 = new JLabel("住宅电话");
		l4.setBounds(100, 140, 100, 50);
		l4.setFont(new Font("", 0, 21));

		l5 = new JLabel("email");
		l5.setBounds(100, 170, 100, 50);
		l5.setFont(new Font("", 0, 21));

		l6 = new JLabel("客户类型");
		l6.setBounds(100, 200, 100, 50);
		l6.setFont(new Font("", 0, 21));

		l7 = new JLabel("gp：集团客户；ip：个人客户");
		l7.setBounds(100, 230, 300, 50);
		l7.setFont(new Font("", 0, 21));
	}

	private void TextFieldInit() {
		t1 = new JTextField("");
		t1.setFont(new Font("", 0, 21));
		t1.setBounds(200, 50, 300, 30);

		t2 = new JTextField("");
		t2.setFont(new Font("", 0, 21));
		t2.setBounds(200, 82, 300, 30);

		t3 = new JTextField("");
		t3.setFont(new Font("", 0, 21));
		t3.setBounds(200, 114, 300, 30);

		t4 = new JTextField("");
		t4.setFont(new Font("", 0, 21));
		t4.setBounds(200, 146, 300, 30);

		t5 = new JTextField("");
		t5.setFont(new Font("", 0, 21));
		t5.setBounds(200, 178, 300, 30);

		t6 = new JTextField("");
		t6.setFont(new Font("", 0, 21));
		t6.setBounds(200, 210, 300, 30);
	}
}
