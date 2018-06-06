package view;

import javax.swing.*;

import org.jvnet.substance.skin.*;

import bean.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import service.*;

/**
 * ����Ҫʹ���¼��Ĵ������� ʵ���¼��ӿ� ����Ҫʹ���¼��Ŀؼ������ע���¼�
 * 
 * @author Administrator
 * 
 */
public class LoginFrame extends JFrame implements ActionListener {
	// ��ĳ�Ա<=>��������Ŀؼ� control<=>class
	private JLabel jLabelback;
	private JButton jButton;
	private JTextField jTextField;
	private JPasswordField jPasswordField;
	private JComboBox jComboBox;
	public LoginFrame() {
		
		this.setSize(600, 550);
		this.setTitle("�û���¼���� ");
		this.setLocationRelativeTo(null);
		this.setLayout(null);// �ղ���
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.init();
		this.setVisible(true);// ���
		
	}

	/**
	 * ��ʼ��������������Ա
	 */
	public void init() {
		// ʵ����
		ImageIcon iic = new ImageIcon("images/��¼.jpg");
		iic.setImage(iic.getImage().getScaledInstance(600, 550, Image.SCALE_DEFAULT));
		// Ϊ�ؼ����ע���¼�
		this.jLabelback=new JLabel(iic);
		this.jLabelback.setBounds(0, 0, 600, 550);
		this.jTextField=new JTextField();
		this.jPasswordField=new JPasswordField();
		this.jComboBox = new JComboBox();
		this.jComboBox.addItem("����Ա");
		this.jComboBox.addItem("�ۻ�Ա");
		this.jComboBox.addItem("�ɹ�Ա");
		this.jButton=new JButton("��¼");
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
		if (e.getActionCommand().equals("��¼")) {
				// �ռ��������
				String empname = this.jTextField.getText().trim();
				String emppwd =  this.jPasswordField.getText().trim();
				String empjob = this.jComboBox.getSelectedItem().toString();// ����null
				if (empname.equals("") || emppwd.equals("")) {
					JOptionPane.showMessageDialog(this, "��û��������Ϣ");
				} else if(empjob.equals("�ۻ�Ա")) {
					Empinfo empinfo = new Empinfo();
					empinfo.setEmpName(empname);
					empinfo.setEmpPwd(emppwd);
					empinfo.setEmpJob(empjob);
					// ����

					EmpinfoServer empInfoService = new EmpinfoServer();

					try {
						Empinfo u = empInfoService.getEmpInfo(empinfo);
						if (u != null) {
							OutputFrame outputFrame = new OutputFrame();
							this.dispose();

						} else {
							JOptionPane.showMessageDialog(this, "ʧ��");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						// e1.printStackTrace();
						// ui
						JOptionPane.showMessageDialog(this, e1.getMessage());
					}
				}
				else if(empjob.equals("����Ա")) {
					Empinfo empinfo = new Empinfo();
					empinfo.setEmpName(empname);
					empinfo.setEmpPwd(emppwd);
					empinfo.setEmpJob(empjob);
					// ����

					EmpinfoServer empInfoService = new EmpinfoServer();

					try {
						Empinfo u = empInfoService.getEmpInfo(empinfo);
						if (u != null) {
							EmpInfoManageFrame empInfoManageFrame = new EmpInfoManageFrame();
							this.dispose();

						} else {
							JOptionPane.showMessageDialog(this, "ʧ��");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						// e1.printStackTrace();
						// ui
						JOptionPane.showMessageDialog(this, e1.getMessage());
					}
				}
				else if(empjob.equals("�ɹ�Ա")) {
					Empinfo empinfo = new Empinfo();
					empinfo.setEmpName(empname);
					empinfo.setEmpPwd(emppwd);
					empinfo.setEmpJob(empjob);
					// ����

					EmpinfoServer empInfoService = new EmpinfoServer();

					try {
						Empinfo u = empInfoService.getEmpInfo(empinfo);
						if (u != null) {
							PurchaseFrame purchaseFrame = new PurchaseFrame();
							this.dispose();

						} else {
							JOptionPane.showMessageDialog(this, "ʧ��");
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

