/**
 * @author RenYali
 */
package GUI;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.*;

import MS.*;

public class LinkmanInterface extends JFrame {
	private JButton b1, b2,b3,b4;
	private JTextField t;
	private GroupCustomerInterface father;
	private LinkmanInterface me = this;
	private String signal;
	private JScrollPane scp;
	private JLabel l;
	private String[][] rowData;
	private ShowInformation s = new ShowInformation();
	private JTable table;
	private JTableHeader jth;
	private ConnectDB ct = new ConnectDB();

	public LinkmanInterface(GroupCustomerInterface gci) {
		super("全部联系人信息");
		this.father = gci;
		this.signal = gci.getSignal();
		
		
		rowData = s.ShowGPL(signal);
		this.scp = new JScrollPane();
		this.scp.setBounds(100, 50, 500, 200);
		
		
		Container c = getContentPane();
		c.setLayout(null);
		Init();
		c.add(b1);
		c.add(b2);
		c.add(b3);
		c.add(b4);
		c.add(t);
		c.add(l);
		c.add(scp);
		
		String[] columnNames = {"name","home_phone","email","signal"};
		table=new JTable(rowData,columnNames); //实例化表格   
		this.jth = this.table.getTableHeader();
		scp.getViewport().add(table);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 100, 700, 400);
		setVisible(true);
	}

	private void Init() {
		TextInit();
		ButtonInit();
		LabelInit();
		
	}

	private void ButtonInit() {
		b1 = new JButton("添加");
		b1.setBounds(200, 300, 80, 30);
		b1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				me.dispose();
				new AddLinkman(me,father);
			}

		});
		b2 = new JButton("删除");
		b2.setBounds(300, 300, 80, 30);
		b2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				me.dispose();
				new DeleteLinkman(me,father);
			}

		});
		
		b3 = new JButton("返回");
		b3.setBounds(400, 300, 80, 30);
		b3.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				me.dispose();
				father.setVisible(true);

			}

		});
		
		
		b4 = new JButton("搜索");
		b4.setBounds(450, 260, 80, 30);
		b4.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String s = t.getText().trim();
				if(ct.seekGPL(signal, s)){
					me.dispose();
					new SelectedLinkman(me,s);
				}else{
					JOptionPane.showMessageDialog(null, "联系人不存在",
							"提示", JOptionPane.INFORMATION_MESSAGE);
					t.setText("");
				}

			}

		});
	}

	private void LabelInit() {
		l = new JLabel("information :");
		l.setBounds(130, 10, 500, 50);
		l.setFont(new Font("", 0, 21));
	}
	
	private void TextInit(){
		t = new JTextField("");
		t.setFont(new Font("", 0, 21));
		t.setBounds(180, 260, 200, 30);
		
	}

	public String getSignal() {
		return signal;
	}
}
