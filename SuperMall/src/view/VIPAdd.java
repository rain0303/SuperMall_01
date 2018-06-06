package view;

import java.awt.Choice;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import bean.Vipinfo;
import service.VipinfoServer;

public class VIPAdd extends JFrame implements ActionListener, ItemListener {
	private JLabel jLabelback;
	private JButton jButton;
	private JButton jButton2;
	private JLabel jLabel;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JTextField jTextField;
	private Choice choice;
	private JRadioButton jRadioButton;// 单选择框
	private JRadioButton jRadioButton2;// 单选择框

	private VipinfoServer vipinfoServer = new VipinfoServer();
	private ButtonGroup buttonGroup;

	public VIPAdd() {

		this.setSize(600, 550);
		this.setTitle("会员注册窗体");
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.init();
		this.setVisible(true);
	}

	private void init() {
		// TODO Auto-generated method stub
		this.jLabel = new JLabel("姓名");
		this.jLabel2 = new JLabel("性别");
		this.jLabel3 = new JLabel("折扣");
		this.jTextField = new JTextField();
		this.jRadioButton = new JRadioButton("男");
		this.jRadioButton.setSelected(true);// 默认选中
		this.jRadioButton2 = new JRadioButton("女");
		this.buttonGroup = new ButtonGroup();
		this.buttonGroup.add(jRadioButton);
		this.buttonGroup.add(jRadioButton2);
		this.jButton = new JButton("添加");
		this.jButton2 = new JButton("返回");
		choice = new Choice();

		this.jLabel.setBounds(170, 140, 50, 30);
		this.jLabel2.setBounds(170, 180, 50, 30);
		this.jLabel3.setBounds(170, 220, 50, 30);
		this.jTextField.setBounds(230, 140, 120, 30);
		this.jRadioButton.setBounds(230, 180, 38, 20);
		this.jRadioButton2.setBounds(290, 180, 38, 20);
		this.choice.setBounds(230, 220, 120, 40);
		this.jButton.setBounds(150, 280, 120, 30);
		this.jButton2.setBounds(290, 280, 120, 30);
		ImageIcon iic = new ImageIcon("images/背景备选.jpg");
		iic.setImage(iic.getImage().getScaledInstance(600, 550, Image.SCALE_DEFAULT));
		// 为控件添加注册事件
		this.jLabelback=new JLabel(iic);
		this.jLabelback.setBounds(0, 0, 600, 550);
		this.add(jLabel);
		this.add(jTextField);
		this.add(jLabel2);
		this.add(jRadioButton);
		this.add(jRadioButton2);
		this.add(jLabel3);
		this.add(choice);
		choice.add("0.7");
		choice.add("0.8");
		choice.add("0.9");
		choice.add("1");
		this.add(jButton);
		this.add(jButton2);
		this.add(jLabelback);
		this.jButton.addActionListener(this);
		this.jButton2.addActionListener(this);
		this.choice.addItemListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("添加")) {
			String vipname = this.jTextField.getText().trim();
			String vipsex = this.jRadioButton.getText().trim();
			// String vipsex2=this.jRadioButton2.getText().trim();
			String vipcut = this.choice.getSelectedItem();
			// 数据转换成对象
			Vipinfo vipinfo = new Vipinfo();
			vipinfo.setVipname(vipname);
			vipinfo.setVipsex(vipsex);
			vipinfo.setVipcut(vipcut);

			try {
				boolean flag = vipinfoServer.addVipinfo(vipinfo);
				if (flag) {
					JOptionPane.showMessageDialog(this, "添加成功");
					VipinfoFrame vipinfoFrame = new VipinfoFrame();
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(this, "添加失败");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, "数据错误");
			}
		}
		if (e.getActionCommand().equals("返回")) {
			VIPFirst vipFirst = new VIPFirst();
			this.dispose();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}
}
