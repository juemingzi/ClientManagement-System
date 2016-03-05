/**
 * @author RenYali
 */
package GUI;

/**
 * 客户信息管理系统
 * @author RenYali
 *首页
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TheMain extends JFrame {

	private JButton b1 = new JButton("管理员登录");
	private JButton b2 = new JButton("用户登录");
	private int type;
	private TheMain me = this;

	public static void main(String[] args) {
		new TheMain();
	}

	public TheMain() {
		super("欢迎登录客户管理系统");
		Container c = getContentPane();
		c.setLayout(null);
		Init();
		c.add(b1);
		c.add(b2);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}

		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 200, 700, 400);
		setVisible(true);
	}

	private void Init() {
		b1.setBounds(270, 100, 130, 30);
		b1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("选择管理员登录");
				new ManagerLogin(me);
				me.dispose();
			}

		});
		b2.setBounds(270, 190, 130, 30);
		b2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("选择用户登录");
				new CustomerLogin(me);
				me.dispose();
			}

		});
	}

}
