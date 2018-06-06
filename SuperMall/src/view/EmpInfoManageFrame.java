package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EmpInfoManageFrame extends JFrame implements ActionListener {
	private JButton jButton, jButton2, jButton3, jButton4, jButton5, jButton6;
	private JLabel jLabel;

	public EmpInfoManageFrame() {
		this.setSize(600, 550);
		this.setTitle("管理员管理界面");
		this.setLocationRelativeTo(null);
		this.setLayout(null);// 空布局
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.init();
		this.setVisible(true);// 最后
	}

	public void init() {

		// this.jButton = new JButton("添加员工信息");
		ImageIcon iic = new ImageIcon("images/添加2.png");
		iic.setImage(iic.getImage().getScaledInstance(136, 103,
				Image.SCALE_DEFAULT));
		this.jButton = new JButton(iic);
		// 设置坐标
		this.jButton.setBounds(239, 146, 136, 103);
		ImageIcon iic2 = new ImageIcon("images/VIP2.png");
		iic2.setImage(iic2.getImage().getScaledInstance(136, 103,
				Image.SCALE_DEFAULT));
		this.jButton2 = new JButton(iic2);
		// 设置坐标
		ImageIcon iic3 = new ImageIcon("images/修改2.png");
		iic3.setImage(iic3.getImage().getScaledInstance(136, 103,
				Image.SCALE_DEFAULT));
		this.jButton3 = new JButton(iic3);
		// 设置坐标
		ImageIcon iic4 = new ImageIcon("images/查询2.png");
		iic4.setImage(iic4.getImage().getScaledInstance(136, 103,
				Image.SCALE_DEFAULT));
		this.jButton4 = new JButton(iic4);
		// 设置坐标
		ImageIcon iic5 = new ImageIcon("images/库存2.png");
		iic5.setImage(iic5.getImage().getScaledInstance(136, 103,
				Image.SCALE_DEFAULT));
		this.jButton5 = new JButton(iic5);
		// 设置坐标

		ImageIcon iic6 = new ImageIcon("images/返回2.png");
		iic6.setImage(iic6.getImage().getScaledInstance(136, 103,
				Image.SCALE_DEFAULT));
		this.jButton6 = new JButton(iic6);
		this.jButton.setBounds(239, 146, 136, 103);
		this.jButton2.setBounds(100, 146, 136, 103);
		this.jButton3.setBounds(380, 146, 136, 103);
		this.jButton4.setBounds(100, 252, 136, 103);
		this.jButton5.setBounds(239, 252, 136, 103);
		this.jButton6.setBounds(380, 252, 136, 103);
		this.jButton.setActionCommand("添加员工信息");
		this.jButton2.setActionCommand("VIP信息管理");
		this.jButton3.setActionCommand("修改员工信息");
		this.jButton4.setActionCommand("查询员工信息");
		this.jButton5.setActionCommand("库存信息管理");
		this.jButton6.setActionCommand("返回登录界面");
		ImageIcon iic7 = new ImageIcon("images/管理员管理界面.jpg");
		iic7.setImage(iic7.getImage().getScaledInstance(600, 550,
				Image.SCALE_DEFAULT));
		// 为控件添加注册事件
		this.jLabel = new JLabel(iic7);
		this.jLabel.setBounds(0, 0, 600, 550);
		
		this.add(jButton);
		this.add(jButton3);
		this.add(jButton4);
		this.add(jButton2);
		this.add(jButton5);
		this.add(jButton6);
		this.add(jLabel);
		this.jButton.addActionListener(this);
		this.jButton3.addActionListener(this);
		this.jButton4.addActionListener(this);
		this.jButton2.addActionListener(this);
		this.jButton5.addActionListener(this);
		this.jButton6.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("添加员工信息")) {
			EmpAddFrame empAddFrame = new EmpAddFrame();
			this.dispose();
		}
		if (e.getActionCommand().equals("修改员工信息")) {
			EmpUpdateFrame empUpdateFrame = new EmpUpdateFrame();
			this.dispose();
		}
		if (e.getActionCommand().equals("查询员工信息")) {
			EmpSelectFrame empSelectFrame = new EmpSelectFrame();
			this.dispose();
		}
		if (e.getActionCommand().equals("VIP信息管理")) {
			VipinfoFrame vipinfoFrame = new VipinfoFrame();
			this.dispose();
		}
		if (e.getActionCommand().equals("库存信息管理")) {
			GoodsFrame goodsFrame = new GoodsFrame();
			this.dispose();
		}
		if (e.getActionCommand().equals("返回登录界面")) {
			LoginFrame loginFrame = new LoginFrame();
			this.dispose();
		}

	}

}
