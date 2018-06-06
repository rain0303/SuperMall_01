package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import service.InproInfoService;
import bean.InproInfo;

/***
 * 订单信息修改表
 * 
 * @author Administrator
 * 
 */

public class OrderEditFrame extends JFrame implements ActionListener {
	private JLabel jLabelback;
	private InproInfo inproInfo;
	private JScrollPane jScrollPane;// 滚动面板
	private JTable jTable;// 表格
	private DefaultTableModel defaultTableModel;// 建模；
	private JButton jButton2;// 按钮2W
	private JButton jButton3;// 按钮3
	private JLabel jLabel;// 标题
	private InproInfoService inproInfoService = new InproInfoService();
	private static final String Defaultmat = "yyyy-MM-dd";
	SimpleDateFormat df = new SimpleDateFormat(Defaultmat);// 设置日期格式

	public OrderEditFrame(InproInfo inproInfo) {
		this.inproInfo = inproInfo;
		this.setSize(600, 550);
		this.setTitle("订单修改页面");
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.init();
		this.bindData();// 加载数据
		this.setVisible(true);// 最后
	}

	/**
	 * 初始化窗体其他成员控件；
	 * 
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
		this.jLabel = new JLabel("订单管理");
		this.jScrollPane = new JScrollPane();
		this.jTable = new JTable() {
			// public boolean isCellEditable(int row, int column) {
			// return false;
			// }
		};
		this.jScrollPane.getViewport().add(jTable);
		Object [] columns=new Object[] { "进货编号", "进货日期", "供货商编号", "商品名称", "商品数量", "备注",
		"职员编号" };
		this.defaultTableModel = new DefaultTableModel(new Object[][] {},columns
				) {
			private static final long serialVersionUID = 1L;

		};
		this.jTable.setModel(defaultTableModel);
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

			this.defaultTableModel.addRow(new Object[] { inproInfo.getProId(),
					df.format(inproInfo.getProdate()), inproInfo.getDid(),
					inproInfo.getGoodsName(), inproInfo.getGoodsNum(),
					inproInfo.getRemark(), inproInfo.getEmpId() });

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
			if(index<0){
				JOptionPane.showMessageDialog(this, "您没有选择订单");
			}
			if (this.jTable.getValueAt(index, 0) != null
					&& this.jTable.getValueAt(index, 1) != null
					&& this.jTable.getValueAt(index, 2) != null
					&& this.jTable.getValueAt(index, 3) != null
					&& this.jTable.getValueAt(index, 4) != null
					&& this.jTable.getValueAt(index, 5) != null
					&& this.jTable.getValueAt(index, 6) != null) {
				String proId = this.jTable.getValueAt(index, 0).toString();
				String prodate = this.jTable.getValueAt(index, 1).toString();
				String Did = this.jTable.getValueAt(index, 2).toString();
				String goodsName = this.jTable.getValueAt(index, 3).toString();
				String goodsNum = this.jTable.getValueAt(index, 4).toString();
				String remark = this.jTable.getValueAt(index, 5).toString();
				String empId = this.jTable.getValueAt(index, 6).toString();
				InproInfo inproInfo = new InproInfo();
				inproInfo.setProId(Integer.parseInt(proId));
				inproInfo.setDid(Integer.parseInt(Did));
				inproInfo.setEmpId(Integer.parseInt(empId));
				inproInfo.setGoodsName(goodsName);
				inproInfo.setGoodsNum(Integer.parseInt(goodsNum));
				inproInfo.setRemark(remark);
				Date date = null;
				try {
					date = this.df.parse(prodate);
					inproInfo.setProdate(date);
                                                                                                
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this, "你今天开心么");
				}

				// 创建用户编辑信息窗体
				// 窗体类与窗体 类之间传递数据 构造方法
				boolean flag;
				try {
					flag = inproInfoService.updateInproInfo(inproInfo);
					if (flag) {
						JOptionPane.showMessageDialog(this, "修改成功");
					} else {
						JOptionPane.showMessageDialog(this, "修改失败");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				OrderEditFrame orderEditFrame = new OrderEditFrame(inproInfo);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "数据错误");
			}

		}

		if (e.getActionCommand().equals("返回")) {
			// 从表格中获取用户选择的行

			OrderInfoFrame orderInfoFrame = new OrderInfoFrame();
			this.dispose();

		}
	}
}
