/**
 * @author RenYali
 */
package GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ManagerLogin extends JFrame{
	
	private TheMain father;
	private JButton b1,b2;
	private JLabel Jl1,Jl2;
	private TextField JF1,JF2;
	private ManagerLogin me = this;
	private boolean bl = false;
	
	public ManagerLogin(TheMain tm)
	{
		super("管理员登录");
		this.father = tm;
		Container c = getContentPane();
		c.setLayout(null);
		Init();
		c.add(b1);
		c.add(b2);
		c.add(Jl1);
		c.add(Jl2);
		c.add(JF1);
		c.add(JF2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 200,700, 400);
		setVisible(true);
	}
	
	private void Init(){
		LabelInit();
		TextFieldInit();
		ButtonInit();
	}
	
	private void ButtonInit(){
		String s1 = "manager";
		String s2 = "manager";
		b1 = new JButton("登录");
		b1.setBounds(200, 200, 130, 30);
		b1.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				if(s1.equals(JF1.getText())&&s2.equals(JF2.getText())){
					bl = true;
				}else{
					JOptionPane.showMessageDialog(null, "用户名或密码错误", "提示", JOptionPane.INFORMATION_MESSAGE);
					JF1.setText("");
					JF2.setText("");
				}
				if(bl){
					me.dispose();
					new ManagerInterface();
				}
			}
			
		});
		b2 = new JButton("取消");
		b2.setBounds(350, 200, 130, 30);
	    b2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				me.dispose();
				father.setVisible(true);
			}
	    	 
		});
	}
	
	private void TextFieldInit(){
		JF1 = new TextField("");
		JF1.setFont(new Font("",0,21));
		JF1.setBounds(250, 60, 300, 30);
		
		JF2 = new TextField("");
		JF2.setFont(new Font("",0,21));
		JF2.setBounds(250, 110, 300, 30);
		JF2.setEchoChar('*');
	}
	
	private void LabelInit(){
		Jl1 = new JLabel("用户名");
		Jl1.setBounds(150, 60, 100, 30);
		Jl1.setFont(new Font("",0,21));
		
		Jl2 = new JLabel("密码");
		Jl2.setBounds(150, 110, 100, 30);
		Jl2.setFont(new Font("",0,21));
	}
}