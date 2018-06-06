package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import service.GoodsinfoServer;
import service.InproInfoService;
import service.SupplierInfoService;
import bean.Goodsinfo;
import bean.InproInfo;
import bean.SupplierInfo;

/***
 * 采购界面
 * 
 * @author Administrator
 * 
 */

public class PurchaseFrame extends JFrame implements ActionListener {
	private JButton jButton;
	private JLabel jLabel;
	private JTextField jTextField;
	private JScrollPane jScrollPane;
	private JTable jTable;
	private DefaultTableModel dtm;
	private SupplierInfoService supplierInfoService = new SupplierInfoService();
	private InproInfoService inproInfoService = new InproInfoService();
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	private JLabel jLabelback;
	public PurchaseFrame() {

		this.setSize(600, 550);
		this.setTitle("采购窗体");
		this.setLocationRelativeTo(null);
		this.setLayout(null);// 空布局
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.init();
		this.bindData();
		this.setVisible(true);

	}

	public void init() {
		JFrame jf = new JFrame("VipinfoFrame");
		ImageIcon iic = new ImageIcon("images/背景备选2.jpg");
		iic.setImage(iic.getImage().getScaledInstance(600, 550, Image.SCALE_DEFAULT));
		// 为控件添加注册事件
		this.jLabelback=new JLabel(iic);
		this.jLabelback.setBounds(0, 0, 600, 550);
		this.jButton = new JButton("查询");
		this.jLabel = new JLabel("请输入您要采购的商品");
		this.jTextField = new JTextField();
		this.jScrollPane = new JScrollPane();
		this.jButton2 = new JButton("采购");
		this.jButton3 = new JButton("返回");
		this.jButton4 = new JButton("查看订单信息");
		this.jButton5 = new JButton("添加供货商");
		this.jTable = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		Object [] columns=new Object[] {
				"编号", "供货商", "电话", "电邮", "地址", "名称", "类别",
				"图片" };
		this.dtm = new DefaultTableModel(new Object[][] {},columns ) {
			private static final long serialVersionUID = 1L;
			Class<?>[] types = new Class<?>[] { Integer.class, String.class,
					String.class, String.class, String.class, String.class,
					Integer.class, ImageIcon.class };

			@Override
			public Class<?> getColumnClass(int columnIndex) {

				return types[columnIndex];

			}
		};

		this.jTable.setModel(dtm);
		this.jScrollPane.getViewport().add(jTable);
		this.jLabel.setBounds(20, 50, 200, 40);
		this.jButton.setBounds(320, 50, 100, 40);
		this.jTextField.setBounds(180, 50, 120, 40);
		this.jScrollPane.setBounds(10, 100, 420, 350);
		/**
		 * 背景虚化
		 */
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setOpaque(false);
		for (int i = 0; i < columns.length-1; i++) {
			jTable.getColumn(columns[i]).setCellRenderer(cellRenderer);
		}
		jTable.setOpaque(false);
		this.jScrollPane.setOpaque(false);
		this.jScrollPane.getViewport().setOpaque(false);
		this.jButton2.setBounds(450, 100, 120, 40);
		this.jButton3.setBounds(450, 180, 120, 40);
		this.jButton4.setBounds(450, 260, 120, 40);
		this.jButton5.setBounds(450, 340, 120, 40);
		this.add(jButton);
		this.add(jLabel);
		this.add(jTextField);
		this.add(jScrollPane);
		this.add(jButton2);
		this.add(jButton3);
		this.add(jButton4);
		this.add(jButton5);
		this.add(jLabelback);
		this.jButton.addActionListener(this);
		this.jButton2.addActionListener(this);
		this.jButton3.addActionListener(this);
		this.jButton4.addActionListener(this);
		this.jButton5.addActionListener(this);
		jTable.getColumnModel().getColumn(0).setPreferredWidth(30);
		jTable.getColumnModel().getColumn(1).setPreferredWidth(30);
		jTable.getColumnModel().getColumn(4).setPreferredWidth(40);
		jTable.getColumnModel().getColumn(5).setPreferredWidth(50);
		jTable.getColumnModel().getColumn(6).setPreferredWidth(40);
		jTable.getColumnModel().getColumn(7).setPreferredWidth(40);
		jTable.setRowHeight(40);
	}

	public void bindData() {

		try {

			ArrayList<SupplierInfo> supplierList = supplierInfoService
					.getSupplierInfos(null);

			for (int i = 0; i < supplierList.size(); i++) {

				ImageIcon ImageIcon;
				this.dtm.addRow(new Object[] {
						supplierList.get(i).getDid(),
						supplierList.get(i).getDname(),
						supplierList.get(i).getDtel(),
						supplierList.get(i).getDemail(),
						supplierList.get(i).getDadd(),
						supplierList.get(i).getGoodsName(),
						supplierList.get(i).getGoodsCategoryId(),
						ImageIcon = new ImageIcon(supplierList.get(i)
								.getGoodspictures().trim())

				});
				ImageIcon.setImage(ImageIcon.getImage().getScaledInstance(30,
						30, Image.SCALE_DEFAULT));

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("添加供货商")) {
			SupplierInfoAddJframe supplierInfoAddJframe = new SupplierInfoAddJframe();
			this.dispose();

		}
		if (e.getActionCommand().equals("采购")) {

			// 从表格中获取用户选择的行

			int index = this.jTable.getSelectedRow();
			if (index < 0) {

				JOptionPane.showMessageDialog(this, "您没有选择商家信息");
				return;
			}
			// 根据用户选择行 获取当前行的单元格的数据 根据列的下标
			// 处理空
			if (this.jTable.getValueAt(index, 0) != null
					&& this.jTable.getValueAt(index, 1) != null
					&& this.jTable.getValueAt(index, 2) != null
					&& this.jTable.getValueAt(index, 3) != null
					&& this.jTable.getValueAt(index, 4) != null
					&& this.jTable.getValueAt(index, 5) != null) {
				String did = this.jTable.getValueAt(index, 0).toString();
				String dname = this.jTable.getValueAt(index, 1).toString();
				String dtel = this.jTable.getValueAt(index, 2).toString();
				String demail = this.jTable.getValueAt(index, 3).toString();
				String dadd = this.jTable.getValueAt(index, 4).toString();
				String goodsName = this.jTable.getValueAt(index, 5).toString();
				String goodsCategoryId = this.jTable.getValueAt(index, 6)
						.toString();
				String goodspictures = this.jTable.getValueAt(index, 7)
						.toString();
				SupplierInfo supplierInfo = new SupplierInfo();
				supplierInfo.setDid(Integer.parseInt(did));// String 包装类
				supplierInfo.setDname(dname);
				supplierInfo.setDtel(dtel);
				supplierInfo.setDemail(demail);
				supplierInfo.setDadd(dadd);
				supplierInfo.setGoodsName(goodsName);
				supplierInfo.setGoodsCategoryId(Integer.parseInt(goodsCategoryId));
     			supplierInfo.setGoodspictures(goodspictures);

				// 创建用户编辑信息窗体
				// 窗体类与窗体 类之间传递数据 构造方法
				OrderFrame orderFrame = new OrderFrame(supplierInfo);
				this.dispose();

			} else {
				JOptionPane.showMessageDialog(this, "数据错误");
			}

		}
		if (e.getActionCommand().equals("返回")) {
			LoginFrame loginFrame = new LoginFrame();
			this.dispose();
		}
		if (e.getActionCommand().equals("查看订单信息")) {
			OrderInfoFrame orderInfoFrame = new OrderInfoFrame();
			this.dispose();

		}

		if (e.getActionCommand().equals("查询")) {

			try {

				String goodsName = "";
				if (this.jTextField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "您没有输入商品名称");
				}

				if (!this.jTextField.getText().equals("")) {
					goodsName = this.jTextField.getText().trim();

					Goodsinfo goodsinfo = new Goodsinfo();
					goodsinfo.setGoodsName(goodsName);
					// view 收集完成 <=>service <=>dao

					ArrayList<SupplierInfo> supplierInfoList = supplierInfoService
							.getSupplierInfos(goodsinfo);
					// 使用容器<=>模型
					// 清空当前模型中的数据
					// 细节 集合 <=>动态性
					int count = this.dtm.getRowCount();

					for (int i = 0; i < count; i++) {
						this.dtm.removeRow(0);
					}

					for (int i = 0; i < supplierInfoList.size(); i++) {

						ImageIcon ImageIcon;
						this.dtm.addRow(new Object[] {
								supplierInfoList.get(i).getDid(),
								supplierInfoList.get(i).getDname(),
								supplierInfoList.get(i).getDtel(),
								supplierInfoList.get(i).getDemail(),
								supplierInfoList.get(i).getDadd(),
								supplierInfoList.get(i).getGoodsName(),
								supplierInfoList.get(i).getGoodsCategoryId(),
								ImageIcon = new ImageIcon(supplierInfoList.get(i)
										.getGoodspictures().trim())});
						ImageIcon.setImage(ImageIcon.getImage().getScaledInstance(30,
								30, Image.SCALE_DEFAULT));
						

					}
				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, "您输入的数据错误");
			}
		}

	}

}
