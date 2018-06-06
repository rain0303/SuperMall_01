package view;

import javax.swing.*;

import org.jvnet.substance.skin.*;

import bean.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import service.*;

/**
 * 在需要使用事件的窗体类中 实现事件接口 在需要使用事件的控件上添加注册事件
 * 
 * @author Administrator
 * 
 */
public class LoginFrame extends JFrame implements ActionListener {
	// 类的成员<=>窗体上面的控件 control<=>class
	private JLabel jLabelback;
	private JButton jButton;
	private JTextField jTextField;
	private JPasswordField jPasswordField;
	private JComboBox jComboBox;
	public LoginFrame() {
		
		this.setSize(600, 550);
		this.setTitle("用户登录窗体 ");
		this.setLocationRelativeTo(null);
		this.setLayout(null);// 空布局
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.init();
		this.setVisible(true);// 最后
		
	}

	/**
	 * 初始化窗体在其它成员
	 */
	public void init() {
		// 实例化
		ImageIcon iic = new ImageIcon("images/登录.jpg");
		iic.setImage(iic.getImage().getScaledInstance(600, 550, Image.SCALE_DEFAULT));
		// 为控件添加注册事件
		this.jLabelback=new JLabel(iic);
		this.jLabelback.setBounds(0, 0, 600, 550);
		this.jTextField=new JTextField();
		this.jPasswordField=new JPasswordField();
		this.jComboBox = new JComboBox();
		this.jComboBox.addItem("管理员");
		this.jComboBox.addItem("售货员");
		this.jComboBox.addItem("采购员");
		this.jButton=new JButton("登录");
		this.jButton.setBounds(200,346, 220, 41);
		this.jTextField.setBounds(270, 230, 145, 25);
		this.jPasswordField.setBounds(270, 265, 145, 25);
		this.jComboBox.setBounds(270, 295, 140, 28);
		this.add(jComboBox);
		this.add(jButton);
		this.add(jTextField);
		this.add(jPasswordField);
		this.add(jLabelback);
		this.jButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("登录")) {
				// 收集完成数据
				String empname = this.jTextField.getText().trim();
				String emppwd =  this.jPasswordField.getText().trim();
				String empjob = this.jComboBox.getSelectedItem().toString();// 不是null
				if (empname.equals("") || emppwd.equals("")) {
					JOptionPane.showMessageDialog(this, "你没有输入信息");
				} else if(empjob.equals("售货员")) {
					Empinfo empinfo = new Empinfo();
					empinfo.setEmpName(empname);
					empinfo.setEmpPwd(emppwd);
					empinfo.setEmpJob(empjob);
					// 调用

					EmpinfoServer empInfoService = new EmpinfoServer();

					try {
						Empinfo u = empInfoService.getEmpInfo(empinfo);
						if (u != null) {
							OutputFrame outputFrame = new OutputFrame();
							this.dispose();

						} else {
							JOptionPane.showMessageDialog(this, "失败");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						// e1.printStackTrace();
						// ui
						JOptionPane.showMessageDialog(this, e1.getMessage());
					}
				}
				else if(empjob.equals("管理员")) {
					Empinfo empinfo = new Empinfo();
					empinfo.setEmpName(empname);
					empinfo.setEmpPwd(emppwd);
					empinfo.setEmpJob(empjob);
					// 调用

					EmpinfoServer empInfoService = new EmpinfoServer();

					try {
						Empinfo u = empInfoService.getEmpInfo(empinfo);
						if (u != null) {
							EmpInfoManageFrame empInfoManageFrame = new EmpInfoManageFrame();
							this.dispose();

						} else {
							JOptionPane.showMessageDialog(this, "失败");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						// e1.printStackTrace();
						// ui
						JOptionPane.showMessageDialog(this, e1.getMessage());
					}
				}
				else if(empjob.equals("采购员")) {
					Empinfo empinfo = new Empinfo();
					empinfo.setEmpName(empname);
					empinfo.setEmpPwd(emppwd);
					empinfo.setEmpJob(empjob);
					// 调用

					EmpinfoServer empInfoService = new EmpinfoServer();

					try {
						Empinfo u = empInfoService.getEmpInfo(empinfo);
						if (u != null) {
							PurchaseFrame purchaseFrame = new PurchaseFrame();
							this.dispose();

						} else {
							JOptionPane.showMessageDialog(this, "失败");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						// e1.printStackTrace();
						// ui
						JOptionPane.showMessageDialog(this, e1.getMessage());
					}
				}
				
			}
			
			
			
		

		}

		
		

	}

