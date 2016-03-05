/**
 * @author RenYali
 */
package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import MS.*;

public class DeleteLinkman extends JFrame {
	private LinkmanInterface father;
	private JLabel l1;
	private JButton b1, b2, b3;
	private JTextField t1;
	private DeleteLinkman me = this;
	private String signal;
	private ConnectDB cd = new ConnectDB();
	private String s = null;
	private GroupCustomerInterface gci;

	public DeleteLinkman(LinkmanInterface lk,GroupCustomerInterface gci) {
		super("ɾ����ϵ��");
		this.gci = gci;
		this.father = lk;
		signal = lk.getSignal();
		Container c = getContentPane();
		c.setLayout(null);
		Init();
		c.add(l1);
		c.add(t1);
		c.add(b1);
		c.add(b2);
		
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
		b1 = new JButton("ȷ��");
		b1.setBounds(200, 200, 130, 30);
		b1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				s = t1.getText();
				if (s.equals("")) {
					JOptionPane.showMessageDialog(null, "�û�������Ϊ��", "��ʾ",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					if (cd.seekGPL(signal, s)&&cd.deleteGPL(s,signal)) {
						JOptionPane.showMessageDialog(null, "��ϵ����ɾ�����ȷ��������ϵ����ҳ", "��ʾ",
								JOptionPane.INFORMATION_MESSAGE);
						new LinkmanInterface(gci);
					} else {
						JOptionPane.showMessageDialog(null, "ɾ��ʧ��ԭ�����Ϊ��ϵ�˲�����", "��ʾ",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}

		});
		b2 = new JButton("ȡ��");
		b2.setBounds(350, 200, 130, 30);
		b2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				father.setVisible(true);
				me.dispose();
			}

		});
	}

	private void TextFieldInit() {
		t1 = new JTextField("");
		t1.setFont(new Font("", 0, 21));
		t1.setBounds(270, 120, 300, 30);
	}

	private void LabelInit() {
		l1 = new JLabel("����");
		l1.setBounds(170, 120, 100, 30);
		l1.setFont(new Font("", 0, 21));

	}
}
