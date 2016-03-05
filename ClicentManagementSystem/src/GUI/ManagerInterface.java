/**
 * @author RenYali
 */
package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import MS.*;

public class ManagerInterface extends JFrame {
	private ManagerLogin father;
	private JLabel l1;
	private JButton b1, b2, b3;
	private JTextField t1;
	private ManagerInterface me = this;
	private ConnectDB cd = new ConnectDB();

	public ManagerInterface() {
		super("����Ա�ѵ�½");
		Container c = getContentPane();
		c.setLayout(null);
		Init();
		c.add(l1);
		c.add(t1);
		c.add(b1);
		c.add(b2);
		c.add(b3);
		
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
		b1 = new JButton("����");
		b1.setBounds(200, 250, 100, 30);
		b1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String signal = t1.getText().trim();
System.out.println("���ң�signal   = "+signal);
				if(signal.indexOf("gp")!=0&&signal.indexOf("ip")!=0){
					JOptionPane.showMessageDialog(null, "�ͻ���ʶ����", "��ʾ",
							JOptionPane.INFORMATION_MESSAGE);
				}
				if (signal.indexOf("gp") == 0||signal.indexOf("ip")==0){
					if(signal.indexOf("gp")==0&&cd.seekGP(signal)){
						new GroupCustomerInterface(me,null);
					}else{
						if(cd.seekIP(signal))
							new IndividualCustomer(me,null);
						else{
							JOptionPane.showMessageDialog(null, "�ͻ�������", "��ʾ",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			}

		});
		b2 = new JButton("ɾ��");
		b2.setBounds(320, 250, 100, 30);
		b2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String signal = t1.getText().trim();
				
				if(signal.indexOf("gp")!=0&&signal.indexOf("ip")!=0){
					JOptionPane.showMessageDialog(null, "�ͻ���ʶ����", "��ʾ",
							JOptionPane.INFORMATION_MESSAGE);
				}
				if (signal.indexOf("gp") == 0||signal.indexOf("ip")==0){
					if(signal.indexOf("gp")==0&&cd.seekGP(signal)){
						cd.deleteGP(signal);
						JOptionPane.showMessageDialog(null, "�ͻ���ɾ��", "��ʾ",
								JOptionPane.INFORMATION_MESSAGE);
						t1.setText("");
					}else{
						if(cd.seekIP(signal)){
							cd.deleteIP(signal);
							JOptionPane.showMessageDialog(null, "�ͻ���ɾ��", "��ʾ",
									JOptionPane.INFORMATION_MESSAGE);
							t1.setText("");
						}else{
							JOptionPane.showMessageDialog(null, "�ͻ�������", "��ʾ",
									JOptionPane.INFORMATION_MESSAGE);
							t1.setText("");
						}
					}
				}
			}
		});
		b3 = new JButton("�˳�");
		b3.setBounds(440, 250, 100, 30);
		b3.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

		});
	}

	private void TextFieldInit() {
		t1 = new JTextField("");
		t1.setFont(new Font("", 0, 21));
		t1.setBounds(270, 120, 300, 30);
	}

	private void LabelInit() {
		l1 = new JLabel("��ʶ");
		l1.setBounds(170, 120, 100, 30);
		l1.setFont(new Font("", 0, 21));

	}

	public String getSignal() {
		return t1.getText().trim();
	}

}
