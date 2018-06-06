package view;

import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

import bean.Empinfo;
import bean.Goodsinfo;
import bean.SaleInfo;
import bean.Vipinfo;
import service.EmpinfoServer;
import service.GoodsinfoServer;
import service.SaleInfoService;
import service.VipinfoServer;

public class OutputFrame extends JFrame implements ActionListener {
	private JLabel jLabel, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6,
			jLabel7, jLabel8, jLabel9, jLabel10, jLabel11, jLabel12, jLabel13,
			jLabel14, jLabel15, jLabel16, jLabel17;
	private JTextField jTextField, jTextField2, jTextField3, jTextField4,
			jTextField5;
	private JLabel jLabelback;
	// 商品名称，编号，数量，vip编号，vip姓名 5lable 5textfiled
	// 商品名称，价格，库存；折扣 8lable
	// 商品图片
	private JButton jButton, jButton2, jButton3, jButton4, jButton5, jButton6,
			jButton7, jButton8, jButton9;
	// 搜索，确认添加，撤销，修改，删除，返回。
	private JScrollPane jScrollPane;
	private DefaultTableModel dtm;
	private JTable jTable;
	private EmpinfoServer empinfoServer = new EmpinfoServer();
	private GoodsinfoServer goodsinfoServer = new GoodsinfoServer();
	private SaleInfoService saleInfoService = new SaleInfoService();
	private VipinfoServer vipinfoServer = new VipinfoServer();
	private Vipinfo vipinfo2 = null;
	private Goodsinfo goodsinfo2 = null;
	private int vipId=88;
	private ArrayList<SaleInfo> saleInfos = new ArrayList<SaleInfo>();
	private ArrayList<Goodsinfo> goodsinfos = new ArrayList<Goodsinfo>();
	private float price, vipPrice;// 原价，折后价
	private float profit;// 原价，折后价
	private int empId=2;
	private static final String Defaultmat = "yyyy-MM-dd";
	private SimpleDateFormat df = new SimpleDateFormat(Defaultmat);// 设置日期格式

	public OutputFrame() {
		this.setSize(600, 550);
		this.setTitle("订单管理：销售");
		this.setLocationRelativeTo(null);
		this.setLayout(null);// 空布局
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.init();
		this.setVisible(true);// 最后
	}

	private void bindData(ArrayList<SaleInfo> saleInfos) {
		int count = this.dtm.getRowCount();
		for (int i = 0; i < count; i++) {
			this.dtm.removeRow(0);
		}
		try {
			for (int i = 0; i < saleInfos.size(); i++) {
				// 一行一行讲数据添加到dtm上
				this.dtm.addRow(new Object[] { saleInfos.get(i).getGoodsid(),
						goodsinfos.get(i).getGoodsName(),
						goodsinfos.get(i).getGoodsPrice(),
						saleInfos.get(i).getGoodsNum() });

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	public void init() {
		ImageIcon iic = new ImageIcon("images/背景备选2.jpg");
		iic.setImage(iic.getImage().getScaledInstance(600, 550, Image.SCALE_DEFAULT));
		// 为控件添加注册事件
		this.jLabelback=new JLabel(iic);
		this.jLabelback.setBounds(0, 0, 600, 550);
		JFrame jf = new JFrame("OutputFrame");
		this.jScrollPane = new JScrollPane();
		this.jTable = new JTable() {

		};
		Object [] columns=new Object[] {
				"商品编号", "商品名称", "商品价格", "商品数量" };
		this.dtm = new DefaultTableModel(new Object[][] {}, columns);

		this.jButton = new JButton("搜索");
		this.jButton5 = new JButton("删除");
		this.jButton6 = new JButton("返回");
		this.jButton2 = new JButton("确认添加");
		this.jButton7 = new JButton("搜索vip");
		this.jButton8 = new JButton("结算");
		this.jButton9 = new JButton("完成");

		// 商品名称，编号，数量，6
		// 商品名称，价格，库存；6
		this.jLabel = new JLabel("商品名称：");
		this.jLabel2 = new JLabel("商品编号：");
		this.jLabel3 = new JLabel("商品名称：");
		this.jLabel4 = new JLabel();
		this.jLabel5 = new JLabel("商品价格：");
		this.jLabel6 = new JLabel();
		this.jLabel7 = new JLabel("当前库存：");
		this.jLabel8 = new JLabel();
		this.jLabel9 = new JLabel("商品数量：");
		this.jLabel10 = new JLabel("vip编号：");
		this.jLabel12 = new JLabel("折扣：");
		this.jLabel13 = new JLabel("1");
		this.jLabel14 = new JLabel("应付款：");
		this.jLabel15 = new JLabel();
		this.jLabel16 = new JLabel("折后价：");
		this.jLabel17 = new JLabel();

		this.jTextField = new JTextField();
		this.jTextField2 = new JTextField();
		this.jTextField3 = new JTextField();
		this.jTextField4 = new JTextField();
		this.jScrollPane.getViewport().add(jTable);
		this.jTable.setModel(dtm);
		this.jScrollPane.setBounds(350, 220, 230, 200);

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
		this.jButton.setBounds(220, 80, 120, 30);// "搜索"
		this.jButton5.setBounds(430, 40, 120, 30);// "删除"
		this.jButton6.setBounds(430, 120, 120, 30);// "返回"
		this.jButton2.setBounds(140, 460, 120, 30);// "确认添加"
		this.jButton7.setBounds(220, 280, 120, 30);// "搜索vip"
		this.jButton8.setBounds(0, 460, 100, 30);// "结算"
		this.jButton9.setBounds(450, 460, 100, 30);// "完成"

		this.jLabel.setBounds(40, 40, 80, 30);// "商品名称："
		this.jLabel2.setBounds(40, 80, 80, 30);// "商品编号："
		this.jLabel3.setBounds(40, 120, 80, 30);// "商品名称："
		this.jLabel4.setBounds(130, 120, 80, 30);// "水果"
		this.jLabel5.setBounds(40, 160, 80, 30);// "商品价格："
		this.jLabel6.setBounds(130, 160, 80, 30);// "10.5"
		this.jLabel7.setBounds(40, 200, 80, 30);// "当前库存："
		this.jLabel8.setBounds(130, 200, 80, 30);// "100"
		this.jLabel9.setBounds(40, 240, 80, 30);// "商品数量："
		this.jLabel10.setBounds(40, 280, 80, 30);// "vip编号："
		this.jLabel12.setBounds(40, 320, 80, 30);// "vip折扣："
		this.jLabel13.setBounds(130, 320, 80, 30);// "0.8"
		this.jLabel14.setBounds(40, 360, 80, 30);// "应付款："
		this.jLabel15.setBounds(130, 360, 80, 30);// "100元"
		this.jLabel16.setBounds(40, 400, 80, 30);// "折后价："
		this.jLabel17.setBounds(130, 400, 80, 30);// "80元："

		this.jTextField.setBounds(130, 40, 80, 30);// "商品名称："
		this.jTextField2.setBounds(130, 80, 80, 30);// "商品编号："
		this.jTextField3.setBounds(130, 240, 80, 30);// "商品数量："
		this.jTextField4.setBounds(130, 280, 80, 30);// "vip编号："


		this.add(jButton);
		this.add(jButton2);
		this.add(jButton5);
		this.add(jButton6);
		this.add(jButton7);
		this.add(jButton8);
		this.add(jButton9);

		this.add(jLabel);
		this.add(jLabel2);
		this.add(jLabel3);
		this.add(jLabel4);
		this.add(jLabel5);
		this.add(jLabel6);
		this.add(jLabel7);
		this.add(jLabel8);
		this.add(jLabel9);
		this.add(jLabel10);
		this.add(jLabel12);
		this.add(jLabel13);
		this.add(jLabel14);
		this.add(jLabel15);
		this.add(jLabel16);
		this.add(jLabel17);

		this.add(jTextField);
		this.add(jTextField2);
		this.add(jTextField3);
		this.add(jTextField4);
		this.add(jScrollPane);
		this.add(jLabelback);
		this.jButton.addActionListener(this);// "搜索"
		this.jButton2.addActionListener(this);// "确认添加"
		this.jButton5.addActionListener(this);// "删除"
		this.jButton6.addActionListener(this);// "返回"
		this.jButton7.addActionListener(this);// "搜索vip"
		this.jButton8.addActionListener(this);// "搜索"
		this.jButton9.addActionListener(this);// "搜索"

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			if (e.getActionCommand().equals("搜索vip")) {

				if (!this.jTextField4.getText().equals("")) {
					Vipinfo vipinfo = new Vipinfo();
					vipinfo.setVipid(Integer.parseInt(this.jTextField4
							.getText().trim()));
					
					vipinfo2 = vipinfoServer.getVipinfo2(vipinfo);
					if(vipinfo2.getVipname()!=null){
					    this.jLabel13.setText(vipinfo2.getVipcut());
					    vipId=Integer.parseInt(this.jTextField4.getText());
					    
					}
					else {
						JOptionPane.showMessageDialog(this, "此会员不存在！");
					}	
				} else {
					JOptionPane.showMessageDialog(this, "请输入会员编号");
				}
			}
			if (e.getActionCommand().equals("搜索")) {
				if ((!this.jTextField.getText().equals(""))
						|| (!this.jTextField2.getText().equals(""))) {
					Goodsinfo goodsinfo = new Goodsinfo();
					if (!this.jTextField.getText().equals("")) {
						goodsinfo.setGoodsName(this.jTextField.getText()
								.toString().trim());
					}
					if (!this.jTextField2.getText().equals("")) {
						goodsinfo.setGoodsId(Integer.parseInt(this.jTextField2
								.getText().toString().trim()));
					}
					goodsinfo2 = goodsinfoServer.getgoodsInfo(goodsinfo);
				
					if (goodsinfo2 != null) {
						this.jLabel4.setText(goodsinfo2.getGoodsName());
						this.jLabel6.setText("" + goodsinfo2.getGoodsPrice());
						this.jLabel8.setText("" + goodsinfo2.getGoodsStock());
					} else {
						JOptionPane.showMessageDialog(this, "此商品不存在！");
					}
				}
				else {
					JOptionPane.showMessageDialog(this, "请输入商品编号或名称");
				}
			}
			if (e.getActionCommand().equals("确认添加")) {
				if ((!this.jTextField3.getText().equals(""))
						&& (!this.jLabel4.getText().equals(""))) {
				if(Integer.parseInt(this.jTextField3.getText()) > goodsinfo2.getGoodsStock()){
					JOptionPane.showMessageDialog(this, "库存不足");
				}
				else{
					SaleInfo saleInfo = new SaleInfo();
					saleInfo.setGoodsNum(Integer.parseInt(this.jTextField3
							.getText().toString().trim()));
					saleInfo.setGoodsid(goodsinfo2.getGoodsId());
					saleInfo.setVipid(vipId);				
					saleInfo.setEmpid(empId);
					saleInfo.setSaleDate(new Date());
					if (!this.jLabel13.getText().equals("1")) {
						saleInfo.setVipid(vipinfo2.getVipid());
					}
					boolean flag = true;
					for (int i = 0; i < saleInfos.size(); i++) {
						if (saleInfos.get(i).getGoodsid() == saleInfo
								.getGoodsid()) {
							saleInfos.get(i).setGoodsNum(saleInfos.get(i).getGoodsNum()+ saleInfo.getGoodsNum());
							flag = false;
							break;
						}

					}
					
					if (flag) {
						saleInfos.add(saleInfo);
						goodsinfos.add(goodsinfo2);
					}
					this.bindData(saleInfos);
				} 
//				else {
//					JOptionPane.showMessageDialog(this, "请输入商品信息及数量");
//
//				}
			}
			}
			if (e.getActionCommand().equals("结算")) {
				for (int i = 0; i < saleInfos.size(); i++) {
					price += (float) (saleInfos.get(i).getGoodsNum() * goodsinfos
							.get(i).getGoodsPrice());
					vipPrice += (float) (saleInfos.get(i).getGoodsNum()
							* goodsinfos.get(i).getGoodsPrice() * Double
							.parseDouble(this.jLabel13.getText().trim()));
					this.jLabel15.setText("" + price);
					this.jLabel17.setText("" + vipPrice);
					profit=(float) (saleInfos.get(i).getGoodsNum()
							* goodsinfos.get(i).getGoodsPrice() * Double
							.parseDouble(this.jLabel13.getText().trim())-saleInfos.get(i).getGoodsNum()*goodsinfos.get(i).getGoodsCPrice());
					saleInfos.get(i).setSaleProfit(profit);
				}
				if (saleInfos.size() == 0) {
					JOptionPane.showMessageDialog(this, "请添加商品！");
				}
			}

			if (e.getActionCommand().equals("删除")) {
				try {
					int index = this.jTable.getSelectedRow();
					if (index >= 0) {
						if (this.jTable.getValueAt(index, 0) != null) {
							String goodsId = this.jTable.getValueAt(index, 0)
									.toString();
							for (int i = 0; i < saleInfos.size(); i++) {
								if (saleInfos.get(i).getGoodsid() == Integer
										.parseInt(goodsId)) {
									saleInfos.remove(i);
									goodsinfos.remove(i);
									break;
								}
							}
							this.bindData(saleInfos);
						} else {
							JOptionPane.showMessageDialog(this, "数据错误");
						}
					} else {
						JOptionPane.showMessageDialog(this, "请选择删除的信息！");

					}
				} catch (NumberFormatException e1) {
					
					JOptionPane.showMessageDialog(this, "年龄请填写数字！");
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}
			if (e.getActionCommand().equals("完成")) {
				if(saleInfos.get(0).getSaleProfit()!=0){
				for (int i = 0; i < saleInfos.size(); i++) {
						saleInfoService.addsaleInfo(saleInfos.get(i));
						saleInfoService.updategoodsStock(saleInfos.get(i));
				}
				JOptionPane.showMessageDialog(this, "添加完成");

				this.dispose();
				OutputFrame outputFrame = new OutputFrame();
				
				}
				else 
						JOptionPane.showMessageDialog(this, "请先结算");

			}
			
			if (e.getActionCommand().equals("返回")) {
				FirstFrame firstFrame = new FirstFrame();
				this.dispose();
			}
			
			

		} catch (NumberFormatException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(this, "请输入数字");
		} catch (HeadlessException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
	
	

}
