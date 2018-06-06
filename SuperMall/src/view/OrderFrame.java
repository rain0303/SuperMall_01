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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatter;

import service.GoodsinfoServer;
import service.InproInfoService;
import service.SupplierInfoService;
import bean.Emp;
import bean.Goodsinfo;
import bean.InproInfo;
import bean.SupplierInfo;

/****
 * 采购员下订单窗体
 * 
 * @author Administrator
 * 
 */

public class OrderFrame extends JFrame implements ActionListener {
	private JLabel jLabelback;
	private SupplierInfo supplierInfo;
	private Goodsinfo goodsinfo;
	private SupplierInfoService supplierInfoService = new SupplierInfoService();
	private InproInfoService inproInfoService = new InproInfoService();
	private GoodsinfoServer goodsinfoServer = new GoodsinfoServer();
	private InproInfo inproInfo;
	private Emp emp;
	private JButton jButton;
	private JButton jButton2;
	private JLabel jLabel;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JTextField jTextField;
	private JTextField jTextField2;
	private JTextField jTextField3;
	private JTextField jTextField4;
	private JTextField jTextField5;
	private JTextField jTextField6;
	private JTextField jTextField7;
	private JTextField jTextField8;
	private static final String Defaultmat = "yyyy-MM-dd";
	SimpleDateFormat df = new SimpleDateFormat(Defaultmat);// 设置日期格式


	public OrderFrame() {
		this.setSize(600, 550);
		this.setTitle("采购订单窗体 ");
		this.setLocationRelativeTo(null);
		this.setLayout(null);// 空布局
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.init();
		this.setVisible(true);// 最后
	}

	public OrderFrame(SupplierInfo supplierInfo) {
		this.supplierInfo =supplierInfo;
		this.setSize(600, 550);
		this.setTitle("采购订单窗体 ");
		this.setLocationRelativeTo(null);
		this.setLayout(null);// 空布局
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.init();
		supplierInfo = new SupplierInfo();
		
		
		this.setVisible(true);// 最后
	}

	public void init() {
		ImageIcon iic = new ImageIcon("images/背景备选2.jpg");
		iic.setImage(iic.getImage().getScaledInstance(600, 550, Image.SCALE_DEFAULT));
		// 为控件添加注册事件
		this.jLabelback=new JLabel(iic);
		this.jLabelback.setBounds(0, 0, 600, 550);
		this.jButton = new JButton("确认下单");
		this.jButton2 = new JButton("返回");
		this.jLabel = new JLabel("进货日期");
		this.jLabel2 = new JLabel("供货商编号");
		this.jLabel3 = new JLabel("商品名称");
		this.jLabel4 = new JLabel("商品数量");
		this.jLabel5 = new JLabel("备注");
		this.jLabel6 = new JLabel("职员编号");
		this.jLabel7 = new JLabel("商品类别");
		this.jLabel8 = new JLabel("商品图片");
		
		

		this.jTextField = new JTextField(df.format(new Date()));

		this.jTextField2 = new JTextField(" " + supplierInfo.getDid());
	

		this.jTextField3 = new JTextField(" " + supplierInfo.getGoodsName());
		this.jTextField4 = new JTextField();
		this.jTextField5 = new JTextField();
		this.jTextField6 = new JTextField();
		this.jTextField7 = new JTextField(" "+ supplierInfo.getGoodsCategoryId());
		this.jTextField8 = new JTextField(supplierInfo.getGoodspictures());
		this.jLabel.setBounds(50, 50, 120, 40);
		this.jLabel2.setBounds(50, 100, 120, 40);
		this.jLabel3.setBounds(50, 150, 120, 40);
		this.jLabel4.setBounds(50, 200, 120, 40);
		this.jLabel5.setBounds(50, 250, 120, 40);
		this.jLabel6.setBounds(50, 300, 120, 40);
		this.jLabel7.setBounds(50, 350,120, 40);
		this.jLabel8.setBounds(50, 400,120, 40);
		this.jTextField.setBounds(130, 50, 120, 40);
		this.jTextField2.setBounds(130, 100, 120, 40);
		this.jTextField3.setBounds(130, 150, 120, 40);
		this.jTextField4.setBounds(130, 200, 120, 40);
		this.jTextField5.setBounds(130, 250, 120, 40);
		this.jTextField6.setBounds(130, 300, 120, 40);
		this.jTextField7.setBounds(130, 350, 120, 40);
		this.jTextField8.setBounds(130, 400, 120, 40);
		this.jButton.setBounds(300, 70, 120, 40);
		this.jButton2.setBounds(300, 140, 120, 40);

		this.add(jLabel);
		this.add(jLabel2);
		this.add(jLabel3);
		this.add(jLabel4);
		this.add(jLabel5);
		this.add(jLabel6);
		this.add(jLabel7);
		this.add(jLabel8);
		this.add(jTextField);
		this.add(jTextField2);
		this.add(jTextField3);
		this.add(jTextField4);
		this.add(jTextField5);
		this.add(jTextField6);
		this.add(jTextField7);
		this.add(jTextField8);
		this.add(jButton);
		this.add(jButton2);
		this.add(jLabelback);
		this.jButton.addActionListener(this);
		this.jButton2.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("返回")) {
			PurchaseFrame purchaseFrame = new PurchaseFrame();
			this.dispose();
		}
		if (e.getActionCommand().equals("确认下单")) {
			String index = this.jTextField4.getText();
			if (index.equals("")) {
				JOptionPane.showMessageDialog(this, "商品数量不能为空");

			} else {

				try {

					String prodate = this.jTextField.getText().trim();
					Date date = null;
					date = this.df.parse(prodate);

					int did = Integer.parseInt(this.jTextField2.getText()
							.trim());
					String goodsName = this.jTextField3.getText().trim();
					int goodsNum = Integer.parseInt(this.jTextField4.getText()
							.trim());
					String remark = this.jTextField5.getText().trim();
					int empId = Integer.parseInt(this.jTextField6.getText()
							.trim());
					String goodsPhoto =this.jTextField8.getText();
					String goodsStock=this.jTextField4.getText();

					InproInfo inproInfo = new InproInfo();
				
					inproInfo.setDid(did);
					inproInfo.setProdate(date);
					inproInfo.setGoodsName(goodsName);
					inproInfo.setGoodsNum(goodsNum);
					inproInfo.setRemark(remark);
					inproInfo.setEmpId(empId);
					
					
					try {
						boolean flag = inproInfoService.addInproInfo(inproInfo);
						if (flag) {
							JOptionPane.showMessageDialog(this, "购买成功");
//							this.dispose();	
							// PurchaseFrame purchaseFrame = new
							// PurchaseFrame();
							Goodsinfo goodsinfo = new Goodsinfo();
					
							goodsinfo.setGoodsName(goodsName);
							Goodsinfo g = goodsinfoServer
									.getgoodsInfo1(goodsinfo);
							if (g == null ) {
								goodsinfo.setGoodsCategoryId(supplierInfo.getGoodsCategoryId());
								goodsinfo.setGoodsName(goodsName);
								goodsinfo.setGoodsPhoto(goodsPhoto);
								goodsinfo.setGoodsStock(Integer.parseInt(goodsStock));
								goodsinfoServer.addGoodsInfo1(goodsinfo);
								
			
								

							}
							else{
							
								goodsinfo.setGoodsName(goodsName);
								goodsinfo.setGoodsStock(Integer.parseInt(g.getGoodsStock()+goodsStock));
								goodsinfoServer.updategoodsInfo1(goodsinfo);
								
							}

						} else {
							JOptionPane.showMessageDialog(this, "购买失败");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						// e1.printStackTrace();

						// 弹出对话框
						JOptionPane.showMessageDialog(this, e1.getMessage());
					}

				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}
	}
}
