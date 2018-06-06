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

public class GoodsEditFrame extends JFrame implements ActionListener {
	private Goodsinfo goodsinfo;
	private JScrollPane jScrollPane;// 滚动面板
	private JTable jTable;// 表格
	private DefaultTableModel defaultTableModel;// 建模；
	private JButton jButton2;// 按钮2W
	private JButton jButton3;// 按钮3
	private JLabel jLabel;// 标题
	private JLabel jLabelback;
	private GoodsinfoServer goodsinfoServer = new GoodsinfoServer();

	public GoodsEditFrame(Goodsinfo goodsinfo) {
		this.goodsinfo=goodsinfo;
		this.setSize(600, 550);
		this.setTitle("商品修改页面");
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.init();
		this.bindData();// 加载数据
		this.setVisible(true);// 最后
	}

	/**
	 * 初始化窗体其他成员控件；
	 * @param goodsinfo 
	 */
	public void init() {
		JFrame jf = new JFrame("VipinfoFrame");
		ImageIcon iic = new ImageIcon("images/背景备选2.jpg");
		iic.setImage(iic.getImage().getScaledInstance(600, 550, Image.SCALE_DEFAULT));
		// 为控件添加注册事件
		this.jLabelback=new JLabel(iic);
		this.jLabelback.setBounds(0, 0, 600, 550);
		this.jButton2 = new JButton("确认修改");
		this.jButton3 = new JButton("返回");
		this.jLabel = new JLabel("商品管理");
		this.jScrollPane = new JScrollPane();
		this.jTable = new JTable() {
		};
		Object [] columns=new Object[] { "商品编号", "商品图片", "商品名称", "商品类别", "商品进价",
				"商品售价", "商品数量" };
		this.jScrollPane.getViewport().add(jTable);
		this.defaultTableModel = new DefaultTableModel(new Object[][] {},
				columns) {
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
		jTable.getColumnModel().getColumn(1).setPreferredWidth(80);
		jTable.setRowHeight(40);
		// 设置坐标；
		this.jScrollPane.setBounds(25, 120, 540, 300);
		

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
		this.jLabel.setBounds(250, 30, 100, 30);
		this.jButton2.setBounds(180, 450, 100, 30);
		this.jButton3.setBounds(330, 450, 100, 30);
		this.add(jButton2);
		this.add(jButton3);
		this.add(jLabel);
		this.add(jScrollPane);
		this.add(jLabelback);
		// this.add(jTable);
		this.jButton2.addActionListener(this);
		this.jButton3.addActionListener(this);
		
	}

	public void bindData() {
		try {
				ImageIcon ImageIcon;
				// String photo=goodsList.get(i).getGoodsPhoto();
				this.defaultTableModel.addRow(new Object[] {
						goodsinfo.getGoodsId(),
						ImageIcon = new ImageIcon(goodsinfo
								.getGoodsPhoto()),
								goodsinfo.getGoodsName(),
								goodsinfo.getGoodsCategoryName(),
								goodsinfo.getGoodsCPrice(),
								goodsinfo.getGoodsPrice(),
								goodsinfo.getGoodsStock() });
				ImageIcon.setImage(ImageIcon.getImage().getScaledInstance(30,
						30, Image.SCALE_DEFAULT));
			}

		
	catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("确认修改")) {
			int index = this.jTable.getSelectedRow();
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
				boolean flag;
				try {
					flag = goodsinfoServer.updategoodsInfo(goodsinfo);
					if (flag) {
						JOptionPane.showMessageDialog(this, "修改成功");
					} else {
						JOptionPane.showMessageDialog(this, "修改失败");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				GoodsEditFrame goodsEditFrame = new GoodsEditFrame(goodsinfo);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "数据错误");
			}
			
		
		}
		
		if (e.getActionCommand().equals("返回")) {
			// 从表格中获取用户选择的行

			GoodsFrame goodsFrame = new GoodsFrame();
			this.dispose();

		}
	}

}
