package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.ImageIcon;

import bean.Goodsinfo;
import service.GoodsinfoServer;

public class GoodsFrame extends JFrame implements ActionListener {
	private JScrollPane jScrollPane;// 滚动面板
	private JTable jTable;// 表格
	private JLabel jLabelback;//背景
	private DefaultTableModel defaultTableModel;// 建模；
	private JButton jButton;// 按钮1
	private JButton jButton3;
	private JButton jButton2;// 按钮2
	private JButton jButton4;// 按钮4
	
	private JLabel jLabel;// 标题
	private JLabel jLabel2;// 根据商品编号查询
	private JLabel jLabel3;// 根据商品名称查询
	private JTextField jTextField;// 编号；
	private JTextField jTextField2;// 名称
	private GoodsinfoServer goodsinfoServer = new GoodsinfoServer();

	public GoodsFrame() {
		this.setSize(600, 550);
		this.setTitle("商品管理");
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.init();
		this.bindData();// 加载数据
		this.setVisible(true);// 最后
	}

	/**
	 * 初始化窗体其他成员控件；
	 */
	public void init() {
		this.jButton = new JButton("修改商品");
		this.jButton3=new JButton("销售记录管理");
		this.jButton2 = new JButton("查询");
		this.jButton4 = new JButton("返回");
		this.jLabel = new JLabel("商品管理");
		this.jLabel2 = new JLabel("商品编号:");
		this.jLabel3 = new JLabel("商品名称:");
		this.jTextField = new JTextField();
		this.jTextField2 = new JTextField();
		this.jScrollPane = new JScrollPane();
		this.jTable = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	
		this.jScrollPane.getViewport().add(jTable);
		Object [] columns=new Object[] { "商品编号", "商品图片", "商品名称", "商品类别", "商品进价", "商品售价",
		"商品数量" };
		
		this.defaultTableModel = new DefaultTableModel(new Object[][] {},columns
				) {
			private static final long serialVersionUID = 1L;
			Class<?>[] types = new Class<?>[] { Object.class, ImageIcon.class,
					String.class, String.class, String.class, Double.class,
					Double.class, Integer.class };

			@Override
			public Class<?> getColumnClass(int columnIndex) {

				return types[columnIndex];

			}
		};
		this.jTable.setModel(defaultTableModel);
		jTable.getColumnModel().getColumn(1).setPreferredWidth(40);

		jTable.setRowHeight(40);

		// 设置坐标；
		this.jScrollPane.setBounds(25, 120, 540, 300);

		/**
		 * 背景虚化
		 */
		
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setOpaque(false);
		jTable.getColumn(columns[0]).setCellRenderer(cellRenderer);
		for (int i = 2; i < columns.length; i++) {
			jTable.getColumn(columns[i]).setCellRenderer(cellRenderer);
		}
		jTable.setOpaque(false);
		this.jScrollPane.setOpaque(false);
		this.jScrollPane.getViewport().setOpaque(false);
		
		this.jLabel.setBounds(250, 30, 100, 30);
		this.jLabel2.setBounds(80, 80, 80, 30);// 根据编号查询；
		this.jTextField.setBounds(160, 80, 80, 30);
		this.jLabel3.setBounds(300, 80, 80, 30);
		this.jTextField2.setBounds(380, 80, 80, 30);
		this.jButton.setBounds(170, 450, 100, 30);
		this.jButton3.setBounds(30, 450, 120, 30);
		this.jButton2.setBounds(290, 450, 100, 30);
		this.jButton4.setBounds(450, 450, 100, 30);
		ImageIcon iic = new ImageIcon("images/背景备选2.jpg");
		iic.setImage(iic.getImage().getScaledInstance(600, 550, Image.SCALE_DEFAULT));
		// 为控件添加注册事件
		this.jLabelback=new JLabel(iic);
		this.jLabelback.setBounds(0, 0, 600, 550);
	
		this.add(jButton);
		this.add(jButton2);
		this.add(jButton3);
		this.add(jButton4);
		this.add(jLabel);
		this.add(jLabel2);
		this.add(jLabel3);
		this.add(jScrollPane);
		// this.add(jTable);
		this.add(jTextField);
		this.add(jTextField2);
		this.add(jLabelback);
		
		this.jButton3.addActionListener(this);
		this.jButton.addActionListener(this);
		this.jButton2.addActionListener(this);
		this.jButton4.addActionListener(this);
	}

	public void bindData() {
		try {
			ArrayList<Goodsinfo> goodsList = goodsinfoServer.getgoodsInfo();
			for (int i = 0; i < goodsList.size(); i++) {
				ImageIcon ImageIcon;
				// String photo=goodsList.get(i).getGoodsPhoto();

				this.defaultTableModel.addRow(new Object[] {
						goodsList.get(i).getGoodsId(),
						ImageIcon = new ImageIcon(goodsList.get(i)
								.getGoodsPhoto()),
						goodsList.get(i).getGoodsName(),
						goodsList.get(i).getGoodsCategoryName(),
						goodsList.get(i).getGoodsCPrice(),
						goodsList.get(i).getGoodsPrice(),
						goodsList.get(i).getGoodsStock() });
				ImageIcon.setImage(ImageIcon.getImage().getScaledInstance(40,
						40, Image.SCALE_DEFAULT));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("查询")) {

			try {
			
				// 参数 场景
				int goodsid = 0;
				String goodsname = "";
				// 1 输入用户编号
				if (!this.jTextField.getText().equals("")) {
					goodsid = Integer
							.parseInt(this.jTextField.getText().trim());
				}
				if (!this.jTextField2.getText().equals("")) {
					goodsname = this.jTextField2.getText().trim();
				}

				Goodsinfo goodsinfo = new Goodsinfo();
				goodsinfo.setGoodsId(goodsid);
				goodsinfo.setGoodsName(goodsname);
				// view 收集完成 <=>service <=>dao

				ArrayList<Goodsinfo> goodsinfoList = goodsinfoServer
						.selectgoodsinfo(goodsinfo);
				// 使用容器<=>模型
				// 清空当前模型中的数据
				// 细节 集合 <=>动态性
				int count = this.defaultTableModel.getRowCount();

				for (int i = 0; i < count; i++) {
					this.defaultTableModel.removeRow(0);
				}

				for (int i = 0; i < goodsinfoList.size(); i++) {
					ImageIcon ImageIcon;
					this.defaultTableModel.addRow(new Object[] {
							goodsinfoList.get(i).getGoodsId(),
							ImageIcon = new ImageIcon(goodsinfoList.get(i)
									.getGoodsPhoto()),
							goodsinfoList.get(i).getGoodsName(),
							goodsinfoList.get(i).getGoodsCategoryName(),
							goodsinfoList.get(i).getGoodsCPrice(),
							goodsinfoList.get(i).getGoodsPrice(),
							goodsinfoList.get(i).getGoodsStock() });
					ImageIcon.setImage(ImageIcon.getImage().getScaledInstance(
							30, 30, Image.SCALE_DEFAULT));

				}
				;
			}

			catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, "您输入的数据错误");
			}
		}

		if (e.getActionCommand().equals("修改商品")) {
			// 从表格中获取用户选择的行

			int index = this.jTable.getSelectedRow();
			// System.out.println(index);
			// 根据用户选择行 获取当前行的单元格的数据 根据列的下标
			// 处理空
			try{
			if (this.jTable.getValueAt(index, 0) != null
					&& this.jTable.getValueAt(index, 1) != null
					&& this.jTable.getValueAt(index, 2) != null) {
				String goodsid = this.jTable.getValueAt(index, 0).toString();
				String goodsphoto = this.jTable.getValueAt(index, 1).toString();
				String goodsname = this.jTable.getValueAt(index, 2).toString();
				String goodscategoryname = this.jTable.getValueAt(index, 3)
						.toString();
				String goodscprice = this.jTable.getValueAt(index, 4)
						.toString();
				String goodsprice = this.jTable.getValueAt(index, 5).toString();
				String goodsstock = this.jTable.getValueAt(index, 6).toString();
				Goodsinfo goodsinfo = new Goodsinfo();
				goodsinfo.setGoodsId(Integer.parseInt(goodsid));// String 包装类
				goodsinfo.setGoodsName(goodsname);
				goodsinfo.setGoodsCategoryName(goodscategoryname);
				goodsinfo.setGoodsCPrice(Double.parseDouble(goodscprice));
				goodsinfo.setGoodsPrice(Double.parseDouble(goodsprice));
				goodsinfo.setGoodsStock(Integer.parseInt(goodsstock));
				goodsinfo.setGoodsPhoto(goodsphoto);
				// 创建用户编辑信息窗体
				// 窗体类与窗体 类之间传递数据 构造方法
				GoodsEditFrame goodsEditFrame = new GoodsEditFrame(goodsinfo);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "数据错误");
			}
			}
			catch (Exception e1) {
				// TODO: handle exception
			}
		}
		if (e.getActionCommand().equals("销售记录管理")) {
			MainFrame mainFrame = new MainFrame();
			this.dispose();
		}
		if (e.getActionCommand().equals("返回")) {
			EmpInfoManageFrame empInfoManageFrame = new EmpInfoManageFrame();
			this.dispose();
		}
	}
}
