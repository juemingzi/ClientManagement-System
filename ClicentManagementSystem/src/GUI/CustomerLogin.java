/**
 * @author RenYali
 */
package GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import MS.ConnectDB;
import MS.JudgeSecret;
import MS.ShowInformation;

public class CustomerLogin extends JFrame {

	private TheMain father;
	private JButton b1, b2;
	private JLabel l1, l2;
	private TextField t1, t2;
	private CustomerLogin me = this;
	//private String signal;
	private JudgeSecret js = new JudgeSecret();

	public CustomerLogin(TheMain tm) {
		super("用户登录");
		this.father = tm;
		Container c = getContentPane();
		c.setLayout(null);
		Init();
		c.add(b1);
		c.add(b2);
		c.add(l1);
		c.add(l2);
		c.add(t1);
		c.add(t2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 200, 700, 400);
		setVisible(true);
	}

	private void Init() {
		
		TextFieldInit();
		LabelInit();
		ButtonInit();
	}

	private void ButtonInit() {
		b1 = new JButton("登录");
		b1.setBounds(200, 250, 130, 30);
		b1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String signal = t1.getText();
				String secret = t2.getText();
				if(signal.indexOf("gp") == 0){
					if(js.JudgeGP(signal,secret)){
						
						new GroupCustomerInterface(null,me);
						me.dispose();
					}else{
						JOptionPane.showMessageDialog(null, "用户名或密码不正确", "提示",
								JOptionPane.INFORMATION_MESSAGE);
						t1.setText("");
						t2.setText("");
					}
				}else{
					if(signal.indexOf("ip") == 0){
						if(js.JudgeIP(signal,secret)){
							me.dispose();
							new IndividualCustomer(null,me);
						}else{
							JOptionPane.showMessageDialog(null, "用户名或密码不正确", "提示",
									JOptionPane.INFORMATION_MESSAGE);
							t1.setText("");
							t2.setText("");
						}
					}else{
						JOptionPane.showMessageDialog(null, "该标识非本系统标识，请确认后再登录", "提示",
								JOptionPane.INFORMATION_MESSAGE);
						t1.setText("");
						t2.setText("");
					}
				}
			}

		});
		b2 = new JButton("注册");
		b2.setBounds(350, 250, 130, 30);
		b2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				me.dispose();
				new register(me);
			}

		});
	}

	private void TextFieldInit() {
		t1 = new TextField("");
		t1.setFont(new Font("", 0, 21));
		t1.setBounds(200, 90, 300, 30);

		t2 = new TextField("");
		t2.setEchoChar('*');
		t2.setFont(new Font("", 0, 21));
		t2.setBounds(200, 140, 300, 30);
	}

	private void LabelInit() {
		l1 = new JLabel("标识符");
		l1.setBounds(100, 90, 100, 30);
		l1.setFont(new Font("", 0, 21));

		l2 = new JLabel("密码");
		l2.setBounds(100, 140, 100, 30);
		l2.setFont(new Font("", 0, 21));
	}

	public String getSignal() {
		return this.t1.getText().trim();
	}
}