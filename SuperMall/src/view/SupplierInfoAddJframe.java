package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import service.GoodsinfoServer;
import service.InproInfoService;
import service.SupplierInfoService;
import bean.Emp;
import bean.Goodsinfo;
import bean.InproInfo;
import bean.SupplierInfo;

/****
 * 添加供货商信息界面
 * 
 * @author Administrator
 * 
 */

public class SupplierInfoAddJframe extends JFrame implements ActionListener,
		MouseListener {
	private SupplierInfo supplierInfo;
	private Goodsinfo goodsinfo = new Goodsinfo();
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
	private JFileChooser filechooser;
	private JLabel jLabelback;
	
	public SupplierInfoAddJframe() {
		this.setSize(600, 550);
		this.setTitle("添加供应商窗体 ");
		this.setLocationRelativeTo(null);
		this.setLayout(null);// 空布局
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.init();
		this.setVisible(true);// 最后
	}

	public void init() {
		ImageIcon iic = new ImageIcon("images/背景备选2.jpg");
		iic.setImage(iic.getImage().getScaledInstance(600, 550, Image.SCALE_DEFAULT));
		// 为控件添加注册事件
		this.jLabelback=new JLabel(iic);
		this.jLabelback.setBounds(0, 0, 600, 550);
		this.jButton = new JButton("添加");
		this.jButton2 = new JButton("返回");
		this.jLabel2 = new JLabel("供货商姓名");
		this.jLabel3 = new JLabel("供货商电话");
		this.jLabel4 = new JLabel("供货商电邮");
		this.jLabel5 = new JLabel("供货商地址");
		this.jLabel6 = new JLabel("商品名称");
		this.jLabel7 = new JLabel("商品类别");
		this.jLabel8 = new JLabel("商品图片");

		this.jTextField2 = new JTextField();
		this.jTextField3 = new JTextField();
		this.jTextField4 = new JTextField();
		this.jTextField5 = new JTextField();
		this.jTextField6 = new JTextField();
		this.jTextField7 = new JTextField();
		this.jTextField8 = new JTextField();
		this.jTextField8.setActionCommand("addP");

		this.jLabel2.setBounds(50, 50, 120, 40);
		this.jLabel3.setBounds(50, 100, 120, 40);
		this.jLabel4.setBounds(50, 150, 120, 40);
		this.jLabel5.setBounds(50, 200, 120, 40);
		this.jLabel6.setBounds(50, 250, 120, 40);
		this.jLabel7.setBounds(50, 300, 120, 40);
		this.jLabel8.setBounds(50, 350, 120, 40);

		this.jTextField2.setBounds(130, 50, 120, 40);
		this.jTextField3.setBounds(130, 100, 120, 40);
		this.jTextField4.setBounds(130, 150, 120, 40);
		this.jTextField5.setBounds(130, 200, 120, 40);
		this.jTextField6.setBounds(130, 250, 120, 40);
		this.jTextField7.setBounds(130, 300, 120, 40);
		this.jTextField8.setBounds(130, 350, 120, 40);
		this.jButton.setBounds(300, 150, 120, 40);
		this.jButton2.setBounds(300, 250, 120, 40);
		this.add(jLabel2);
		this.add(jLabel3);
		this.add(jLabel4);
		this.add(jLabel5);
		this.add(jLabel6);
		this.add(jLabel7);
		this.add(jLabel8);
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
		this.jTextField8.addMouseListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("addP")) {
		}
		if (e.getActionCommand().equals("返回")) {
			PurchaseFrame purchaseFrame = new PurchaseFrame();
			this.dispose();
		}
		if (e.getActionCommand().equals("添加")) {
			String index2 = this.jTextField2.getText();
			String index3 = this.jTextField3.getText();
			String index4 = this.jTextField4.getText();
			String index5 = this.jTextField5.getText();
			String index6 = this.jTextField6.getText();
			String index7 = this.jTextField7.getText();
			String index8 = this.jTextField8.getText();
			if (index2.equals("")) {
				JOptionPane.showMessageDialog(this, "供货商姓名不能为空");
			} else if (index3.equals("")) {
				JOptionPane.showMessageDialog(this, "供货商电话不能为空");
			} else if (index4.equals("")) {
				JOptionPane.showMessageDialog(this, "供货商电邮不能为空");
			} else if (index5.equals("")) {
				JOptionPane.showMessageDialog(this, "供货商地址不能为空");
			} else if (index6.equals("")) {
				JOptionPane.showMessageDialog(this, "商品名称不能为空");
			} else if (index7.equals("")) {
				JOptionPane.showMessageDialog(this, "商品类别名称不能为空");
			} else if (index8.equals("")) {
				JOptionPane.showMessageDialog(this, "商品图片不能为空");
			} else {
				String dname = this.jTextField2.getText();
				String dtel = this.jTextField3.getText();
				String demail = this.jTextField4.getText();
				String dadd = this.jTextField5.getText();
				String goodsName = this.jTextField6.getText();
				String goodsCategoryId = this.jTextField7.getText();
				String goodspictures = "images/"
						+ this.jTextField8.getText().trim();// xx.jpg
				SupplierInfo supplierInfo = new SupplierInfo();

				supplierInfo.setDname(dname);
				supplierInfo.setDtel(dtel);
				supplierInfo.setDemail(demail);
				supplierInfo.setDadd(dadd);
				supplierInfo.setGoodsName(goodsName);

				supplierInfo.setGoodsCategoryId(Integer.parseInt(goodsCategoryId));
				supplierInfo.setGoodspictures(goodspictures);

				// try {
				boolean flag;
				try {
					flag = supplierInfoService.addSupplierinfo(supplierInfo);
					if (flag) {
						JOptionPane.showMessageDialog(this, "添加成功");
						// /***
						// * 添加数量到商品表
						// */
						// // goodsinfo.setGoodsId(goodsId);
						// goodsinfoServer.addGoodsInfo(goodsinfo);
						// goodsinfo.getGoodsStock();
						// System.out.println("goodsStock"
						// + goodsinfo.getGoodsStock());
						// inproInfo.getGoodsNum();

						this.dispose();
						PurchaseFrame purchaseFrame = new PurchaseFrame();
					} else {
						JOptionPane.showMessageDialog(this, "添加失败");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			// } catch (Exception e1) {
			// // TODO Auto-generated catch block
			// // e1.printStackTrace();
			//
			// // 弹出对话框
			// JOptionPane.showMessageDialog(this, e1.getMessage());
			// // }

			// } catch (ParseException e1) {
			// // TODO Auto-generated catch block
			// e1.printStackTrace();
			// }

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		filechooser = new JFileChooser();

		int returnVal = filechooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			// + chooser.getSelectedFile().getName()

			try {
				jTextField8.setText(filechooser.getSelectedFile().getName());

				File file = new File(filechooser.getSelectedFile()
						.getAbsolutePath());
				FileInputStream fileInputStream = new FileInputStream(file);
				BufferedInputStream bufferedInputStream = new BufferedInputStream(
						fileInputStream);

				byte[] b = new byte[10240];
				int count = bufferedInputStream.read(b, 0, 10240);
				FileOutputStream fileOutputStream = new FileOutputStream(
						"images/" + filechooser.getSelectedFile().getName());
				while (count > 0) {

					// write
					fileOutputStream.write(b, 0, count);

					count = bufferedInputStream.read(b, 0, 10240);

				}
				fileInputStream.close();
				bufferedInputStream.close();
				fileOutputStream.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
