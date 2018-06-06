package view;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import service.EmpinfoServer;
import bean.Empinfo;

public class EmpUpdateFrame extends JFrame implements ActionListener {

	private JButton jButton2, jButton3, jButton5, jButton6, jButton7, jButton8;
	private JLabel jLabel11, jLabel, jLabel2;
	private JTextField jTextField, jTextField2;
	private JScrollPane jScrollPane;// 滚动面板
	private JTable jTable;// 表格
	private DefaultTableModel dtm;
	private EmpinfoServer empinfoServer = new EmpinfoServer();
	private Empinfo empinfo1 = null;
	private ArrayList<Empinfo> empinfos = new ArrayList<Empinfo>();
	private ArrayList<Empinfo> empinfos2 = null;
	private EmpAddFrame empAddFrame;
	private JLabel jLabelback;
	public EmpUpdateFrame() {
		this.setSize(600, 550);
		this.setTitle("员工编辑窗体");
		this.setLocationRelativeTo(null);
		this.setLayout(null);// 空布局
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.init();
		this.bindData();// 加载数据
		this.setVisible(true);// 最后
	}

	private void bindData() {
		// TODO Auto-generated method stub
		int count = this.dtm.getRowCount();

		for (int i = 0; i < count; i++) {
			this.dtm.removeRow(0);
		}
		try {
			empinfos = empinfoServer.selectAllEmpinfo();
			for (int i = 0; i < empinfos.size(); i++) {
				// 一行一行讲数据添加到dtm上
				this.dtm.addRow(new Object[] { empinfos.get(i).getEmpid(),
						empinfos.get(i).getEmpName(),
						empinfos.get(i).getEmpPwd(),
						empinfos.get(i).getEmpSex(),
						empinfos.get(i).getEmpAge(),
						empinfos.get(i).getEmpJob() });

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	    private void bindData(ArrayList<Empinfo> empinfos1) {
		int count = this.dtm.getRowCount();

		for (int i = 0; i < count; i++) {
			this.dtm.removeRow(0);
		}
		// TODO Auto-generated method stub
		try {
			for (int i = 0; i < empinfos1.size(); i++) {
				this.dtm.addRow(new Object[] { empinfos1.get(i).getEmpid(),
						empinfos1.get(i).getEmpName(),
						empinfos1.get(i).getEmpPwd(),
						empinfos1.get(i).getEmpSex(),
						empinfos1.get(i).getEmpAge(),
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
		/**
		 * 面板
		 */
		this.jScrollPane = new JScrollPane();
		this.jTable = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		Object [] columns=new Object[] {
				"编号", "姓名", "密码", "性别", "年龄", "职位" };
		this.dtm = new DefaultTableModel(new Object[][] {}, columns);

		this.jButton5 = new JButton("修改");
		this.jButton6 = new JButton("返回");
		this.jButton8 = new JButton("查询");
		this.jLabel = new JLabel("员工编号");
		this.jLabel2 = new JLabel("员工姓名");
		this.jTextField = new JTextField();
		this.jTextField2 = new JTextField();
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
		this.jButton8.setBounds(440, 40, 60, 30);
		this.jButton5.setBounds(80, 440, 120, 30);
		this.jButton6.setBounds(330, 440, 120, 30);
		this.jLabel.setBounds(40, 40, 60, 30);
		this.jLabel2.setBounds(240, 40, 60, 30);
		this.jTextField.setBounds(110, 40, 120, 30);
		this.jTextField2.setBounds(310, 40, 120, 30);
		this.jScrollPane.setBounds(40, 120, 500, 300);

		this.add(jButton5);
		this.add(jButton6);
		this.add(jButton8);
		this.add(jLabel);
		this.add(jLabel2);
		this.add(jTextField);
		this.add(jTextField2);
		this.add(jScrollPane);
		this.add(jLabelback);
		this.jButton5.addActionListener(this);
		this.jButton6.addActionListener(this);
		this.jButton8.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("查询")) {
			if ((!this.jTextField.getText().equals(""))
					|| (!this.jTextField2.getText().equals(""))) {
				Empinfo empinfo2 = new Empinfo();
				if (!this.jTextField.getText().equals("")) {
					empinfo2.setEmpid(Integer.parseInt(this.jTextField
							.getText().toString().trim()));
				}
				if (!this.jTextField2.getText().equals("")) {
					empinfo2.setEmpName(this.jTextField2.getText().toString()
							.trim());
				}
				try {
					empinfos2 = empinfoServer.selectEmpinfo(empinfo2);
					this.bindData(empinfos2);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				this.bindData();
			}
		}
		if (e.getActionCommand().equals("修改")) {
			try {
				int index = this.jTable.getSelectedRow();
				if (index >= 0) {
					if (this.jTable.getValueAt(index, 0) != null
							&& this.jTable.getValueAt(index, 1) != null
							&& this.jTable.getValueAt(index, 2) != null
							&& this.jTable.getValueAt(index, 3) != null
							&& this.jTable.getValueAt(index, 4) != null
							&& this.jTable.getValueAt(index, 5) != null) {
						String empid = this.jTable.getValueAt(index, 0)
								.toString();
						String empname = this.jTable.getValueAt(index, 1)
								.toString();
						String emppwd = this.jTable.getValueAt(index, 2)
								.toString();
						String empsex = this.jTable.getValueAt(index, 3)
								.toString();
						String empage = this.jTable.getValueAt(index, 4)
								.toString();
						String empjob = this.jTable.getValueAt(index, 5)
								.toString();

						Empinfo empinfo = new Empinfo();
						empinfo.setEmpid(Integer.parseInt(empid));// String 包装类
						empinfo.setEmpName(empname);
						empinfo.setEmpPwd(emppwd);
						empinfo.setEmpSex(empsex);
						empinfo.setEmpAge(Integer.parseInt(empage));
						empinfo.setEmpJob(empjob);
						empinfo1 = empinfoServer.selectEmpinfo2(empinfo);
						this.empAddFrame = new EmpAddFrame(empinfo1);
						this.dispose();
					} else {
						JOptionPane.showMessageDialog(this, "数据错误");
					}
				} else {
					JOptionPane.showMessageDialog(this, "请选择修改的信息！");

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
			EmpInfoManageFrame empInfoManageFrame = new EmpInfoManageFrame();
			this.dispose();
		}
	}
}
