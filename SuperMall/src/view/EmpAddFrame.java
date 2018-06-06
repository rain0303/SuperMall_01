package view;

import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import bean.Empinfo;
import service.EmpinfoServer;

public class EmpAddFrame extends JFrame implements ActionListener {
	private JButton  jButton2, jButton5;
	private JLabel jLabel, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6,
			jLabel7, jLabel8, jLabel9;
	private JPasswordField jPasswordField;
	private JTextField jTextField, jTextField3, jTextField4, jTextField5,
			jTextField6;
	private JRadioButton jRadioButton1;
	private JRadioButton jRadioButton2;
	private ButtonGroup buttonGroup;// 定义1个按钮组
	private EmpinfoServer empinfoServer = new EmpinfoServer();
	private Empinfo empinfo = new Empinfo();
	private Empinfo empinfo2 = new Empinfo();
	private JLabel jLabelback;
	private JLabel jLabelback2;
	public EmpAddFrame() {
		this.setSize(600, 550);
		this.setTitle("员工注册窗体");
		this.setLocationRelativeTo(null);
		this.setLayout(null);// 空布局
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.init();
		this.setVisible(true);// 最后
	}

	public EmpAddFrame(Empinfo empinfo3) {
		this.setSize(600, 550);
		this.setTitle("员工管理:修改信息");
		this.setLocationRelativeTo(null);
		this.setLayout(null);// 空布局
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.empinfo2 = empinfo3;
		this.init2();
		this.setVisible(true);// 最后
	}

	public void init() {
		ImageIcon iic = new ImageIcon("images/背景备选2.jpg");
		iic.setImage(iic.getImage().getScaledInstance(600, 550, Image.SCALE_DEFAULT));
		// 为控件添加注册事件
		this.jLabelback=new JLabel(iic);
		this.jLabelback.setBounds(0, 0, 600, 550);
		this.jButton5 = new JButton("添加");
		this.jButton2 = new JButton("返回");
		this.jLabel = new JLabel("姓名：");
		this.jLabel2 = new JLabel("密码：");
		this.jLabel3 = new JLabel("性别：");
		this.jLabel4 = new JLabel("年龄：");
		this.jLabel5 = new JLabel("地址：");
		this.jLabel6 = new JLabel("电话：");
		this.jLabel7 = new JLabel("职位：");
		this.jLabel8 = new JLabel("男");
		this.jLabel9 = new JLabel("女");
		this.jTextField = new JTextField();
		this.jTextField3 = new JTextField();
		this.jTextField4 = new JTextField();
		this.jTextField5 = new JTextField();
		this.jTextField6 = new JTextField();
		this.jPasswordField = new JPasswordField();
		this.jRadioButton1 = new JRadioButton("男");
		this.jRadioButton1.setSelected(true);// 默认
		this.jRadioButton2 = new JRadioButton("女");
		this.buttonGroup = new ButtonGroup();
		this.buttonGroup.add(jRadioButton1);
		this.buttonGroup.add(jRadioButton2);
		this.jButton5.setBounds(130, 420, 120, 30);
		this.jButton2.setBounds(340, 420, 120, 30);// 返回
		this.jLabel.setBounds(130, 50, 60, 30);
		this.jLabel2.setBounds(130, 100, 60, 30);
		this.jLabel3.setBounds(130, 150, 60, 30);
		this.jLabel4.setBounds(130, 200, 60, 30);
		this.jLabel5.setBounds(130, 250, 60, 30);
		this.jLabel6.setBounds(130, 300, 60, 30);
		this.jLabel7.setBounds(130, 350, 60, 30);
		this.jLabel8.setBounds(280, 150, 20, 20);
		this.jLabel9.setBounds(340, 150, 20, 20);
		this.jTextField.setBounds(220, 50, 240, 30);
		this.jPasswordField.setBounds(220, 100, 240, 30);
		this.jRadioButton1.setBounds(295, 150, 20, 20);
		this.jRadioButton2.setBounds(365, 150, 20, 20);
		this.jTextField3.setBounds(220, 200, 240, 30);
		this.jTextField4.setBounds(220, 250, 240, 30);
		this.jTextField5.setBounds(220, 300, 240, 30);
		this.jTextField6.setBounds(220, 350, 240, 30);

		
		this.add(jButton2);
		
		this.add(jButton5);
		this.add(jLabel);
		this.add(jLabel2);
		this.add(jLabel3);
		this.add(jLabel4);
		this.add(jLabel5);
		this.add(jLabel6);
		this.add(jLabel7);
		this.add(jLabel8);
		this.add(jLabel9);
		this.add(jTextField);
		this.add(jRadioButton1);
		this.add(jRadioButton2);
		this.add(jTextField3);
		this.add(jTextField4);
		this.add(jTextField5);
		this.add(jTextField6);
		this.add(jPasswordField);
		this.add(jLabelback);
		this.jButton2.addActionListener(this);
		
		this.jButton5.addActionListener(this);
		this.jTextField.addActionListener(this);
		this.jRadioButton1.addActionListener(this);
		this.jRadioButton2.addActionListener(this);
		this.jTextField3.addActionListener(this);
		this.jTextField4.addActionListener(this);
		this.jTextField5.addActionListener(this);
		this.jTextField6.addActionListener(this);
		this.jPasswordField.addActionListener(this);
	}

	public void init2() {
		ImageIcon iic = new ImageIcon("images/背景备选2.jpg");
		iic.setImage(iic.getImage().getScaledInstance(600, 550, Image.SCALE_DEFAULT));
		// 为控件添加注册事件
		this.jLabelback2=new JLabel(iic);
		this.jLabelback2.setBounds(0, 0, 600, 550);
		this.jButton5 = new JButton("确认修改");
		this.jButton2 = new JButton("返回");
		this.jLabel = new JLabel("姓名：");
		this.jLabel2 = new JLabel("密码：");
		this.jLabel3 = new JLabel("性别：");
		this.jLabel4 = new JLabel("年龄：");
		this.jLabel5 = new JLabel("地址：");
		this.jLabel6 = new JLabel("电话：");
		this.jLabel7 = new JLabel("职位：");
		this.jLabel8 = new JLabel("男");
		this.jLabel9 = new JLabel("女");
		this.jTextField = new JTextField();
		this.jTextField.setText(this.empinfo2.getEmpName().toString());
		this.jTextField3 = new JTextField();
		this.jTextField3.setText(Integer.toString(this.empinfo2.getEmpAge()));
		this.jTextField4 = new JTextField();
		this.jTextField4.setText(this.empinfo2.getEmpAdd().toString());
		this.jTextField5 = new JTextField();
		this.jTextField5.setText(this.empinfo2.getEmpTel().toString());
		this.jTextField6 = new JTextField();
		this.jTextField6.setText(this.empinfo2.getEmpJob().toString());
		this.jPasswordField = new JPasswordField();
		this.jPasswordField.setText(this.empinfo2.getEmpPwd());
		this.jRadioButton1 = new JRadioButton("男");
		this.jRadioButton2 = new JRadioButton("女");
		if (this.empinfo2.getEmpSex().equals("男")) {
			this.jRadioButton1.setSelected(true);// 默认
		}
		if (this.empinfo2.getEmpSex().equals("女")) {
			this.jRadioButton2.setSelected(true);// 默认
		}
		this.buttonGroup = new ButtonGroup();
		this.buttonGroup.add(jRadioButton1);
		this.buttonGroup.add(jRadioButton2);

		
		this.jButton5.setBounds(130, 470, 120, 30);
		this.jButton2.setBounds(340, 470, 120, 30);// 返回
		this.jLabel.setBounds(130, 90, 60, 30);
		this.jLabel2.setBounds(130, 140, 60, 30);
		this.jLabel3.setBounds(130, 190, 60, 30);
		this.jLabel4.setBounds(130, 240, 60, 30);
		this.jLabel5.setBounds(130, 290, 60, 30);
		this.jLabel6.setBounds(130, 340, 60, 30);
		this.jLabel7.setBounds(130, 390, 60, 30);
		this.jLabel8.setBounds(280, 190, 20, 20);
		this.jLabel9.setBounds(340, 190, 20, 20);
		this.jTextField.setBounds(220, 90, 240, 30);
		this.jPasswordField.setBounds(220, 140, 240, 30);
		this.jRadioButton1.setBounds(295, 190, 20, 20);
		this.jRadioButton2.setBounds(365, 190, 20, 20);
		this.jTextField3.setBounds(220, 240, 240, 30);
		this.jTextField4.setBounds(220, 290, 240, 30);
		this.jTextField5.setBounds(220, 340, 240, 30);
		this.jTextField6.setBounds(220, 390, 240, 30);
		
		this.add(jButton2);
		
		this.add(jButton5);
		this.add(jLabel);
		this.add(jLabel2);
		this.add(jLabel3);
		this.add(jLabel4);
		this.add(jLabel5);
		this.add(jLabel6);
		this.add(jLabel7);
		this.add(jLabel8);
		this.add(jLabel9);
		this.add(jTextField);
		this.add(jRadioButton1);
		this.add(jRadioButton2);
		this.add(jTextField3);
		this.add(jTextField4);
		this.add(jTextField5);
		this.add(jTextField6);
		this.add(jPasswordField);
		this.add(jLabelback2);
		this.jButton2.addActionListener(this);
		
		this.jButton5.addActionListener(this);
		this.jTextField.addActionListener(this);
		this.jRadioButton1.addActionListener(this);
		this.jRadioButton2.addActionListener(this);
		this.jTextField3.addActionListener(this);
		this.jTextField4.addActionListener(this);
		this.jTextField5.addActionListener(this);
		this.jTextField6.addActionListener(this);
		this.jPasswordField.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		if (e.getActionCommand().equals("添加")) {
			try {
				if ((!this.jTextField.getText().equals(""))
						&& (!this.jPasswordField.getText().equals(""))
						&& (this.jRadioButton1.isSelected() || this.jRadioButton2
								.isSelected())
						&& (!this.jTextField3.getText().equals(""))
						&& (!this.jTextField4.getText().equals(""))
						&& (!this.jTextField5.getText().equals(""))
						&& (!this.jTextField6.getText().equals(""))) {
					empinfo.setEmpName(this.jTextField.getText().trim());
					empinfo.setEmpPwd(this.jPasswordField.getText().trim());
					if (this.jRadioButton2.isSelected()) {
						empinfo.setEmpSex("女");
					} else {
						empinfo.setEmpSex("男");
					}
					empinfo.setEmpAge(Integer.parseInt(this.jTextField3
							.getText().trim()));
					empinfo.setEmpAdd(this.jTextField4.getText().trim());
					empinfo.setEmpTel(this.jTextField5.getText().trim());
					empinfo.setEmpJob(this.jTextField6.getText().trim());
					boolean flag = false;
					flag = empinfoServer.addEmpinfo(empinfo);
					if (flag) {
						JOptionPane.showMessageDialog(this, "添加成功");
						EmpInfoManageFrame empInfoManageFrame=new EmpInfoManageFrame();
						this.dispose();
					}

				} else {
					JOptionPane.showMessageDialog(this, "请填写所有信息！");
				}
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, "年龄请填写数字！");
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (e.getActionCommand().equals("返回")) {
//			EmpUpdateFrame empUpdateFrame = new EmpUpdateFrame();
			EmpInfoManageFrame empInfoManageFrame=new EmpInfoManageFrame();
			this.dispose();
		}
		if (e.getActionCommand().equals("确认修改")) {
			if ((!this.jTextField.getText().equals(""))
					&& (!this.jPasswordField.getText().equals(""))
					&& (this.jRadioButton1.isSelected() || this.jRadioButton2
							.isSelected())
					&& (!this.jTextField3.getText().equals(""))
					&& (!this.jTextField4.getText().equals(""))
					&& (!this.jTextField5.getText().equals(""))
					&& (!this.jTextField6.getText().equals(""))) {
				Empinfo empinfo1 = new Empinfo();
				empinfo1.setEmpName(this.jTextField.getText().trim());
				empinfo1.setEmpPwd(this.jPasswordField.getText().trim());
				if (this.jRadioButton2.isSelected()) {
					empinfo1.setEmpSex("女");
				} else {
					empinfo1.setEmpSex("男");
				}
				empinfo1.setEmpAge(Integer.parseInt(this.jTextField3.getText()
						.trim()));
				empinfo1.setEmpAdd(this.jTextField4.getText().trim());
				empinfo1.setEmpTel(this.jTextField5.getText().trim());
				empinfo1.setEmpJob(this.jTextField6.getText().trim());
				boolean flag = false;
				try {
					flag = empinfoServer.updateEmpinfo(empinfo1, empinfo2);
					if (flag) {
						JOptionPane.showMessageDialog(this, "修改成功");
						EmpUpdateFrame empUpdateFrame=new EmpUpdateFrame();
						this.dispose();
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(this, "请填写所有信息");
			}

		}
	}
}
