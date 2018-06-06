package view;

import java.awt.Choice;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import bean.Vipinfo;
import service.VipinfoServer;

public class VipUpdateFrame extends JFrame implements ActionListener {
	private JLabel jLabelback;
	private JButton jButton;
	private JButton jButton2;
	private JScrollPane jScrollpane;
	private JTable jTable;
	private DefaultTableModel dtm;
	private Vipinfo vipinfo = null;
	private VipinfoServer vipinfoServer = new VipinfoServer();

	public VipUpdateFrame(Vipinfo vipinfo) {
		this.vipinfo = vipinfo;
		this.setSize(600, 550);
		this.setTitle("会员编辑窗体");
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.init();
		this.bindData();
		this.setVisible(true);
	}

	private void bindData() {
		try {
			// 一行一行讲数据添加到dtm上
			this.dtm.addRow(new Object[] { vipinfo.getVipid(),
					vipinfo.getVipname(), vipinfo.getVipsex(),
					vipinfo.getVipcut(), });

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void init() {
		JFrame jf = new JFrame("VipinfoFrame");
		// TODO Auto-generated method stub
		ImageIcon iic = new ImageIcon("images/背景备选.jpg");
		iic.setImage(iic.getImage().getScaledInstance(600, 550, Image.SCALE_DEFAULT));
		// 为控件添加注册事件
		this.jLabelback=new JLabel(iic);
		this.jLabelback.setBounds(0, 0, 600, 550);
		this.jButton = new JButton("修改");
		this.jButton2 = new JButton("返回");
		this.jScrollpane = new JScrollPane();
		this.jTable = new JTable();
		this.jTable = new JTable() {

		};
		// 设置滚动面板和表格的关系
		this.jScrollpane.getViewport().add(jTable);
		Object[] columns=new Object[] {
				"编号", "姓名", "性别", "折扣(0~1)" };
		this.dtm = new DefaultTableModel(new Object[][] {}, columns) {
			private static final long serialVersionUID = 1L;
			Class<?>[] types = new Class<?>[] { Object.class, String.class,
					String.class, String.class };

			@Override
			public Class<?> getColumnClass(int columnIndex) {

				return types[columnIndex];

			}
		};
		
		
		
		// 设置表格与模型的关系
		this.jTable.setModel(dtm);
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setOpaque(false);
		for (int i = 0; i < columns.length; i++) {
			jTable.getColumn(columns[i]).setCellRenderer(cellRenderer);
		}
		jTable.setOpaque(false);
		this.jScrollpane.setOpaque(false);
		this.jScrollpane.getViewport().setOpaque(false);
		this.jScrollpane.setBounds(40, 100, 510, 200);
		this.jButton.setBounds(120, 340, 120, 30);
		this.jButton2.setBounds(300, 340, 120, 30);

		this.add(jScrollpane);
		this.add(jButton);
		this.add(jButton2);
		this.add(jLabelback);
		this.jButton.addActionListener(this);
		this.jButton2.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("修改")) {
			try {
				int index = this.jTable.getSelectedRow();

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
					boolean flag;
					flag = vipinfoServer.updateVipinfo(vipinfo);
					if (flag) {
						JOptionPane.showMessageDialog(this, "修改成功");
						VipinfoFrame vipinfoFrame = new VipinfoFrame();
						this.dispose();
					} else {
						JOptionPane.showMessageDialog(this, "修改失败");
					}
				}
			}

			catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, "请选择修改的信息！");
			}
		}

		if (e.getActionCommand().equals("返回")) {
			VipinfoFrame vipinfoFrame = new VipinfoFrame();
			this.dispose();
		}
	}

}