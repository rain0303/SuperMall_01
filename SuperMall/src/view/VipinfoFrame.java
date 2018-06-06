package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
//import javax.swing.text.html.AccessibleHTML.TableElementInfo.TableAccessibleContext;

import bean.Vipinfo;

import service.VipinfoServer;

public class VipinfoFrame extends JFrame implements ActionListener {
	private JButton jButton, jButton2, jButton3;
	private JLabel labelback;
	private JLabel jLabel;
	private JLabel jLabel2;
	private JButton jbtnquery;
	private JButton jbtnquery2;
	private JTextField jTextField;
	private JTextField jTextField2;
	private JScrollPane jScrollpane;
	private JTable jTable;
	private DefaultTableModel dtm;
	private Vipinfo vipinfo;
	private VipinfoServer vipinfoServer = new VipinfoServer();
	private ArrayList<Vipinfo> vipinfoList = new ArrayList<Vipinfo>();

	public VipinfoFrame() {
		this.setSize(600, 550);
		this.setTitle("会员管理");
		this.setLocationRelativeTo(null);
		this.setLayout(null);// 空布局
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.init();
		this.bindData();// 加载数据
		this.setVisible(true);// 最后
	}

	private void bindData() {

		try {
			ArrayList<Vipinfo> vipinfoList = vipinfoServer.getAllVipinfo();
			for (int i = 0; i < vipinfoList.size(); i++) {
				// 一行一行讲数据添加到dtm上
				this.dtm.addRow(new Object[] { vipinfoList.get(i).getVipid(),
						vipinfoList.get(i).getVipname(),
						vipinfoList.get(i).getVipsex(),
						vipinfoList.get(i).getVipcut(), });
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void init() {
		// 实例化
		JFrame jf = new JFrame("VipinfoFrame");
		this.jScrollpane = new JScrollPane();
		this.jTable = new JTable();
		this.jTable = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		
		Object [] columns=new Object[] {
				"编号", "姓名", "性别", "折扣(0~1)" };
		this.dtm = new DefaultTableModel(new Object[][] {},columns ) {
			private static final long serialVersionUID = 1L;
			Class<?>[] types = new Class<?>[] { Object.class, String.class,
					String.class, String.class };

			@Override
			public Class<?> getColumnClass(int columnIndex) {

				return types[columnIndex];

			}
		};
		
		// 设置滚动面板和表格的关系
		this.jScrollpane.getViewport().add(jTable);
		// 设置表格与模型的关系
		this.jTable.setModel(dtm);
		jTable.getColumnModel().getColumn(1).setPreferredWidth(80);
		jTable.setRowHeight(40);
		
		
		/**
		 * 背景虚化
		 */
		
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setOpaque(false);
		for (int i = 0; i < columns.length; i++) {
			jTable.getColumn(columns[i]).setCellRenderer(cellRenderer);
		}
		jTable.setOpaque(false);
		this.jScrollpane.setOpaque(false);
		this.jScrollpane.getViewport().setOpaque(false);
		
		this.jButton = new JButton("添加会员信息");
		this.jButton2 = new JButton("删除会员信息");
		this.jButton3 = new JButton("修改会员信息");
		this.jLabel = new JLabel("编号：");
		this.jLabel2 = new JLabel("姓名：");
		this.jbtnquery = new JButton("查询");
		this.jbtnquery2 = new JButton("返回");
		this.jTextField = new JTextField();
		this.jTextField2 = new JTextField();
		// 设置坐标
		this.jLabel.setBounds(70, 60, 60, 30);
		this.jTextField.setBounds(120, 60, 60, 30);
		this.jLabel2.setBounds(230, 60, 60, 30);
		this.jTextField2.setBounds(280, 60, 60, 30);
		this.jbtnquery.setBounds(380, 60, 60, 30);
		this.jbtnquery2.setBounds(460, 60, 60, 30);
		this.jScrollpane.setBounds(40, 120, 400, 300);
		this.jButton.setBounds(460, 180, 120, 30);
		this.jButton2.setBounds(460, 260, 120, 30);
		this.jButton3.setBounds(460, 340, 120, 30);
		ImageIcon iic = new ImageIcon("images/背景备选.jpg");
		iic.setImage(iic.getImage().getScaledInstance(600, 550,
				Image.SCALE_DEFAULT));
		// 为控件添加注册事件
		this.labelback = new JLabel(iic);
		this.labelback.setBounds(0, 0, 600, 550);

		// 添加控件
		this.add(jLabel);
		this.add(jLabel2);
		this.add(jbtnquery);
		this.add(jbtnquery2);
		this.add(jTextField);
		this.add(jTextField2);
		this.add(jScrollpane);
		this.add(jButton);
		this.add(jButton2);
		this.add(jButton3);
		this.add(labelback);

		// 为控件添加注册事件
		this.jbtnquery.addActionListener(this);
		this.jbtnquery2.addActionListener(this);
		this.jButton.addActionListener(this);
		this.jButton2.addActionListener(this);
		this.jButton3.addActionListener(this);
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("查询")) {
			int vipid = 0;
			String vipname = "";
			try {
				if (!this.jTextField.getText().equals("")) {
					vipid = Integer.parseInt(this.jTextField.getText().trim());
				}
				if (!this.jTextField2.getText().equals("")) {
					vipname = this.jTextField2.getText().trim();
				}
				Vipinfo vipinfo = new Vipinfo();
				vipinfo.setVipid(vipid);
				vipinfo.setVipname(vipname);
				ArrayList<Vipinfo> vipinfoList = vipinfoServer
						.getVipinfo(vipinfo);
				int count = this.dtm.getRowCount();
				for (int i = 0; i < count; i++) {
					this.dtm.removeRow(0);
				}
				for (int i = 0; i < vipinfoList.size(); i++) {
					this.dtm.addRow(new Object[] {
							vipinfoList.get(i).getVipid(),
							vipinfoList.get(i).getVipname(),
							vipinfoList.get(i).getVipsex(),
							vipinfoList.get(i).getVipcut(), });
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

		if (e.getActionCommand().equals("添加会员信息")) {
			VipAddFrame vipAddFrame = new VipAddFrame();
			this.dispose();
		}

		if (e.getActionCommand().equals("删除会员信息")) {

			int index = this.jTable.getSelectedRow();
			if (index >= 0) {
				if (this.jTable.getValueAt(index, 0) != null
						&& this.jTable.getValueAt(index, 1) != null
						&& this.jTable.getValueAt(index, 2) != null) {
					String Vipid = this.jTable.getValueAt(index, 0).toString();
					Vipinfo vipinfo = new Vipinfo();

					vipinfo.setVipid(Integer.parseInt(Vipid));
					boolean flag;
					try {

						flag = vipinfoServer.deleteVipinfo(vipinfo);

						if (flag) {
							JOptionPane.showMessageDialog(this, "删除成功");
							int count = this.dtm.getRowCount();
							for (int i = 0; i < count; i++) {
								this.dtm.removeRow(0);
							}
							bindData();
						} else {
							JOptionPane.showMessageDialog(this, "删除失败");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			} else {
				JOptionPane.showMessageDialog(this, "请选择要修改的信息");
			}
		}

		if (e.getActionCommand().equals("修改会员信息")) {

			int index = this.jTable.getSelectedRow();
			if (index >= 0) {
				if (this.jTable.getValueAt(index, 0) != null
						&& this.jTable.getValueAt(index, 1) != null
						&& this.jTable.getValueAt(index, 2) != null) {
					String vipid = this.jTable.getValueAt(index, 0).toString();
					String vipname = this.jTable.getValueAt(index, 1)
							.toString();
					String vipsex = this.jTable.getValueAt(index, 2).toString();
					String vipcut = this.jTable.getValueAt(index, 3).toString();

					Vipinfo vipinfo = new Vipinfo();
					vipinfo.setVipid(Integer.parseInt(vipid));// String 包装类
					vipinfo.setVipname(vipname);
					vipinfo.setVipsex(vipsex);
					vipinfo.setVipcut(vipcut);

					// 创建用户编辑信息窗体
					// 窗体类与窗体 类之间传递数据 构造方法
					VipUpdateFrame vipupdateFrame = new VipUpdateFrame(vipinfo);
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(this, "修改失败");
				}
			} else {
				JOptionPane.showMessageDialog(this, "请选择要修改的信息");
			}
		}

	}
}
