package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import service.EmpinfoServer;
import bean.Empinfo;
import bean.Goodsinfo;

public class EmpSelectFrame extends JFrame implements ActionListener {
	private JButton jButton3, jButton4, jButton5, jButton6;
	private JLabel jLabel, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6,
			jLabel7;
	private JTextField jTextField, jTextField3, jTextField4, jTextField5;
	private JRadioButton jRadioButton1, jRadioButton2;
	private ButtonGroup buttonGroup;// 定义1个按钮组
	private JScrollPane jScrollPane;
	private JTable jTable;
	private DefaultTableModel dtm;
	private EmpinfoServer empinfoServer = new EmpinfoServer();
	private Empinfo empinfo1 = null;
	private ArrayList<Empinfo> empinfos = new ArrayList<Empinfo>();
	private EmpAddFrame empAddFrame;
	private JLabel jLabelback;
	private Empinfo empinfo2=null;
	
	public EmpSelectFrame() {
		this.setSize(600, 550);
		this.setTitle("员工查询窗体");
		this.setLocationRelativeTo(null);
		this.setLayout(null);// 空布局
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.init();
		this.setVisible(true);// 最后
	}

	private void bindData(ArrayList<Empinfo> empinfos1) {
		int count = this.dtm.getRowCount();

		for (int i = 0; i < count; i++) {
			this.dtm.removeRow(0);
		}
		try {
			for (int i = 0; i < empinfos1.size(); i++) {

				// 一行一行讲数据添加到dtm上
				this.dtm.addRow(new Object[] { empinfos1.get(i).getEmpid(),
						empinfos1.get(i).getEmpName(),
						empinfos1.get(i).getEmpPwd(),
						empinfos1.get(i).getEmpSex(),
						empinfos1.get(i).getEmpAge(),
						empinfos1.get(i).getEmpAdd(),
						empinfos1.get(i).getEmpTel(),
						empinfos1.get(i).getEmpJob() });

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void init() {
		JFrame jf = new JFrame("VipinfoFrame");
		ImageIcon iic = new ImageIcon("images/背景备选2.jpg");
		iic.setImage(iic.getImage().getScaledInstance(600, 550, Image.SCALE_DEFAULT));
		// 为控件添加注册事件
		this.jLabelback=new JLabel(iic);
		this.jLabelback.setBounds(0, 0, 600, 550);
		this.jScrollPane = new JScrollPane();
		this.jTable = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		Object [] columns=new Object[] {
				"编号", "姓名", "密码", "性别", "年龄", "地址", "电话", "职位" };
		this.dtm = new DefaultTableModel(new Object[][] {},columns );

		this.jButton3 = new JButton("修改此员工");
		this.jButton5 = new JButton("查询");
		this.jButton6 = new JButton("返回");
		
		this.jLabel = new JLabel("编号：");
		this.jLabel2 = new JLabel("姓名：");
		this.jLabel3 = new JLabel("性别：");
		this.jLabel5 = new JLabel("职位：");
		this.jLabel6 = new JLabel("男");
		this.jLabel7 = new JLabel("女");

		this.jTextField = new JTextField();
		this.jRadioButton1 = new JRadioButton("男");
		this.jRadioButton2 = new JRadioButton("女");
		this.buttonGroup = new ButtonGroup();
		this.buttonGroup.add(jRadioButton1);
		this.buttonGroup.add(jRadioButton2);
		this.jTextField3 = new JTextField();
		this.jTextField5 = new JTextField();
		this.jScrollPane.getViewport().add(jTable);
		this.jTable.setModel(dtm);
		/**
		 * 背景虚化
		 */
		
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setOpaque(false);
		for (int i = 0; i < columns.length; i++) {
			jTable.getColumn(columns[i]).setCellRenderer(cellRenderer);
		}
		jTable.setOpaque(false);
		this.jScrollPane.setOpaque(false);
		this.jScrollPane.getViewport().setOpaque(false);
		this.jButton5.setBounds(430, 160, 120, 30);
		this.jButton3.setBounds(80, 450, 120, 30);
		this.jButton6.setBounds(360, 450, 120, 30);

		this.jLabel.setBounds(40, 40, 60, 30);
		this.jLabel2.setBounds(40, 80, 60, 30);
		this.jLabel3.setBounds(40, 120, 60, 30);
		this.jLabel5.setBounds(40, 160, 60, 30);
		this.jLabel6.setBounds(175, 120, 60, 30);
		this.jLabel7.setBounds(255, 120, 60, 30);
		this.jTextField.setBounds(130, 40, 250, 30);
		this.jTextField3.setBounds(130, 80, 250, 30);
		this.jRadioButton1.setBounds(190, 125, 20, 20);
		this.jRadioButton2.setBounds(280, 125, 20, 20);
		this.jTextField5.setBounds(130, 160, 250, 30);
		this.jScrollPane.setBounds(40, 220, 510, 200);

		this.add(jButton3);
		this.add(jButton5);
		this.add(jButton6);
		this.add(jLabel);
		this.add(jLabel2);
		this.add(jLabel3);
		this.add(jLabel5);
		this.add(jLabel6);
		this.add(jLabel7);
		this.add(jTextField);
		this.add(jRadioButton1);
		this.add(jRadioButton2);
		this.add(jTextField3);
		this.add(jTextField5);
		this.add(jScrollPane);
		this.add(jLabelback);
		this.jButton3.addActionListener(this);
		this.jButton5.addActionListener(this);
		this.jButton6.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().equals("修改此员工")) {
			int index = this.jTable.getSelectedRow();
			if (index >= 0) {
				if (this.jTable.getValueAt(index, 0) != null
						&& this.jTable.getValueAt(index, 1) != null
						&& this.jTable.getValueAt(index, 2) != null
						&& this.jTable.getValueAt(index, 3) != null
						&& this.jTable.getValueAt(index, 4) != null
						&& this.jTable.getValueAt(index, 5) != null) {
					String empid = this.jTable.getValueAt(index, 0).toString();
					String empname = this.jTable.getValueAt(index, 1)
							.toString();
					String emppwd = this.jTable.getValueAt(index, 2).toString();
					String empsex = this.jTable.getValueAt(index, 3).toString();
					String empage = this.jTable.getValueAt(index, 4).toString();
					String empadd = this.jTable.getValueAt(index, 5).toString();

					Empinfo empinfo = new Empinfo();
					empinfo.setEmpid(Integer.parseInt(empid));// String 包装类
					empinfo.setEmpName(empname);
					empinfo.setEmpPwd(emppwd);
					empinfo.setEmpSex(empsex);
					empinfo.setEmpAge(Integer.parseInt(empage));
					empinfo.setEmpAdd(empadd);

					try {
						empinfo1 = empinfoServer.selectEmpinfo2(empinfo);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					EmpAddFrame empAddFrame = new EmpAddFrame(empinfo1);
					this.dispose();

				} else {
					JOptionPane.showMessageDialog(this, "数据错误");
				}
			} else {
				JOptionPane.showMessageDialog(this, "请选择修改的信息！");

			}

		}
		if (e.getActionCommand().equals("查询")) {
			Empinfo empinfo = new Empinfo();
			boolean flag = false;
			if (!this.jTextField.getText().equals("")) {
				String empid = this.jTextField.getText().toString();
				empinfo.setEmpid(Integer.parseInt(empid));// String 包装类
				flag = true;		
			}
					
			if (!this.jTextField3.getText().equals("")) {
				String empname = this.jTextField3.getText().toString();
				empinfo.setEmpName(empname);
				flag = true;

			}
			if (this.jRadioButton1.isSelected()) {

				String empsex = "男";
				empinfo.setEmpSex(empsex);
				flag = true;

			}
			if (this.jRadioButton2.isSelected()) {
				String empsex = "女";
				empinfo.setEmpSex(empsex);
				flag = true;
			}

			if (!this.jTextField5.getText().equals("")) {
				String empjob = this.jTextField5.getText().toString();
				empinfo.setEmpJob(empjob);
				flag = true;

			}
			try {
				if (flag) {
					empinfos = empinfoServer.selectEmpinfo(empinfo);
					this.bindData(empinfos);
				} else {
					empinfos = empinfoServer.selectAllEmpinfo();
					this.bindData(empinfos);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (e.getActionCommand().equals("返回")) {
			EmpInfoManageFrame empInfoManageFrame = new EmpInfoManageFrame();
			this.dispose();
		}
	}
}
