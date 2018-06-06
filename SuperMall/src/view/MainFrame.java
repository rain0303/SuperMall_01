package view;

import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.DefaultButtonModel;
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

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.eltima.components.ui.DatePicker;

import service.GoodsinfoServer;
import service.SaleInfoService;
import bean.Goodsinfo;
import bean.SaleInfo;

public class MainFrame extends JFrame implements ActionListener {
	private JLabel jLabelback;
	private DatePicker datepick;
	private static final String DefaultFormat = "yyyy-MM-dd ";
	SimpleDateFormat sdf = new SimpleDateFormat(DefaultFormat);
//	private Date date = new Date();
	private Font font = new Font("Times New Roman", Font.BOLD, 14);
	private Dimension dimension = new Dimension(177, 24);
	private JButton jButton;
	private JButton jButton6;//注销
	private JButton jButton7;//查询
	private JButton jButton8; //删除
	private JTextField jTextField;// 编号查询
	private JButton jButton9;//显示报饼状图表 
	private JButton jButton10;//导出excel表
	private JButton jButton11;//显示折线图
	private JButton jButton12;//返回
	private JLabel jLabel;
	private JLabel jLabel2;

	private JTable jTable;
	private DefaultTableModel dtm;
	private JScrollPane jScrollPane;
	private SaleInfoService saleInfoService = new SaleInfoService();
//	private GoodsinfoServer goodsinfoServer = new GoodsinfoServer();
	public MainFrame() {

		this.setSize(600, 550);
		this.setTitle("销售记录管理窗体 ");
		this.setLocationRelativeTo(null);
		this.setLayout(null);// 空布局
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.init();
		this.bindData();
		this.setVisible(true);// 最后
	}

	private void init() {
		JFrame jf = new JFrame("VipinfoFrame");
		ImageIcon iic = new ImageIcon("images/背景备选2.jpg");
		iic.setImage(iic.getImage().getScaledInstance(600, 550, Image.SCALE_DEFAULT));
		// 为控件添加注册事件
		this.jLabelback=new JLabel(iic);
		this.jLabelback.setBounds(0, 0, 600, 550);
		// TODO Auto-generated method stub
		this.jButton = new JButton("刷新");
		this.jButton6 = new JButton("注销");
		this.jButton7 = new JButton("查询");
		this.jButton8 = new JButton("删除记录");
		this.jButton9 = new JButton("显示销量饼状图");
		this.jButton10 = new JButton("导出Excel报表");
		this.jButton11 = new JButton("显示利润折线图");
		this.jButton12 = new JButton("返回");
		this.jLabel = new JLabel("按订单号查询");
		this.jLabel2 = new JLabel("按日期 查询");
		this.jTextField = new JTextField();
		this.jScrollPane = new JScrollPane();
		this.jTable = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		Object [] columns=new Object[] {
				"订单编号", "职员编号","商品编号", "商品名称", "销售数量","会员编号", "盈利", "销售日期"};
		this.dtm = new DefaultTableModel(new Object[][] {},columns );
		// 设置滚动面板和表格的关系
		this.jScrollPane.getViewport().add(jTable);
		// 设置表格与模型的关系
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
		
		// 日历
		datepick = new DatePicker(null, DefaultFormat, font, dimension);// 自定义参数值
		datepick.setBounds(200, 60, 150, 30);
		datepick.setLocale(Locale.CHINA);// 设置国家
		datepick.setTimePanleVisible(true);// 设置时钟面板可见
		// 功能按钮
		this.jButton.setBounds(450, 60, 80, 30);
		this.jButton12.setBounds(450, 410, 80, 30);
		this.jButton6.setBounds(450, 460, 80, 30);
		// 查询
		this.jButton7.setBounds(360, 60, 80, 30);
		this.jButton8.setBounds(30, 410, 160, 30);
		this.jButton9.setBounds(30, 460, 160, 30);
		this.jButton10.setBounds(250, 410, 160, 30);
		this.jButton11.setBounds(250, 460, 160, 30);
		this.jLabel.setBounds(30, 30, 100, 20);
		this.jLabel2.setBounds(200, 30, 100, 20);
		this.jTextField.setBounds(30, 60, 140, 30);
		this.jScrollPane.setBounds(30, 100, 550, 300);
		this.add(jButton);
		this.add(jButton6);
		this.add(jButton7);
		this.add(jButton8);
		this.add(jButton9);
		this.add(jButton10);
		this.add(jButton11);
		this.add(jButton12);
		this.add(datepick);

		this.add(jLabel2);
		this.add(jLabel);
		this.add(jTextField);

		this.add(jScrollPane);
		this.add(jLabelback);
		this.jButton.addActionListener(this);
		this.jButton6.addActionListener(this);
		this.jButton7.addActionListener(this);
		this.jButton8.addActionListener(this);
		this.jButton9.addActionListener(this);
		this.jButton10.addActionListener(this);
		this.jButton11.addActionListener(this);
		this.jButton12.addActionListener(this);
	}

	/**
	 * 绑定数据
	 */
	public void bindData() {

		// 动态数据
		try {
			ArrayList<SaleInfo> saleinfoList = saleInfoService.getSaleInfo();
			for (int i = 0; i < saleinfoList.size(); i++) {

				this.dtm.addRow(new Object[] {

						saleinfoList.get(i).getSaleid(),
						saleinfoList.get(i).getEmpid(),
						saleinfoList.get(i).getGoodsid(),
						saleinfoList.get(i).getGoodsName(),
						saleinfoList.get(i).getGoodsNum(),
						saleinfoList.get(i).getVipid(),
						saleinfoList.get(i).getSaleProfit(),
						saleinfoList.get(i).getSaleDate()});
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("注销")) {
			LoginFrame myLoginFrame = new LoginFrame();
			this.dispose();
			JOptionPane.showMessageDialog(this, "注销成功");
		}
		if(e.getActionCommand().equals("返回")){
			EmpInfoManageFrame empInfoManageFrame = new EmpInfoManageFrame();
		}

		if (e.getActionCommand().equals("查询")) {

			try {
				
				// 参数 场景
				int saleid = 0;
				Date saleDate = null;
				String chosedate = this.datepick.getText();
				// String username = "";
				// 1 输入用户编号
				if (!this.jTextField.getText().equals("")) {
					saleid = Integer.parseInt(this.jTextField.getText().trim());
				}
				if (!this.datepick.getText().equals("")) {
					saleDate = this.sdf.parse(chosedate);
				}
				
				SaleInfo saleinfo = new SaleInfo();
				saleinfo.setSaleid(saleid);
				saleinfo.setSaleDate(saleDate);
				// view 收集完成 <=>service <=>dao
				ArrayList<SaleInfo> saleinfoList = saleInfoService
						.selectSaleinfo(saleinfo);
				// 使用容器<=>模型
				// 清空当前模型中的数据
				// 细节 集合 <=>动态性
				int count = this.dtm.getRowCount();

				for (int i = 0; i < count; i++) {
					this.dtm.removeRow(0);
				}

				for (int i = 0; i < saleinfoList.size(); i++) {

					this.dtm.addRow(new Object[] {
							saleinfoList.get(i).getSaleid(),
							saleinfoList.get(i).getEmpid(),
							saleinfoList.get(i).getGoodsid(),
							saleinfoList.get(i).getGoodsName(),
							saleinfoList.get(i).getGoodsNum(),
							saleinfoList.get(i).getVipid(),
							saleinfoList.get(i).getSaleProfit(),
							saleinfoList.get(i).getSaleDate()});
				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, "您输入的数据错误");
				
			}
		}
		// 删除
		if (e.getActionCommand().equals("删除记录")) {

			int index = this.jTable.getSelectedRow();
			if(index<0){
				JOptionPane.showMessageDialog(this, "您未选择要删除的记录");
				return;
			}
				if (this.jTable.getValueAt(index, 0) != null) 
				{
					
				String Saleid = this.jTable.getValueAt(index, 0).toString();
				SaleInfo saleInfo = new SaleInfo();
				saleInfo.setSaleid(Integer.parseInt(Saleid));
				boolean flag;
				try {
					flag = saleInfoService.deletegoodsInfo(saleInfo);

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
					
				}

			}
		}
		if (e.getActionCommand().equals("显示销量饼状图")) {
			ArrayList<SaleInfo> saleinfoList;
			try {
				saleinfoList = saleInfoService.getPieSaleInfo();
				DefaultPieDataset dataset = new DefaultPieDataset();				
				for (int i = 0; i < saleinfoList.size(); i++) {
					dataset.setValue(saleinfoList.get(i).getGoodsName()+"", 
							saleinfoList.get(i).getGoodsNum() );
				}
				 //2. 构造chart
				JFreeChart chart = ChartFactory.createPieChart("商品销量比率图", dataset,  
		                true, true, true);  
		  
		        Plot cp = chart.getPlot();  
		        cp.setBackgroundPaint(ChartColor.WHITE); // 背景色设置 

				// 5. chart 以swing形式输出
				ChartFrame pieFrame = new ChartFrame("商品销量报表", chart);
				pieFrame.pack();
				pieFrame.setLocationRelativeTo(null);
				pieFrame.setVisible(true);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		
		if (e.getActionCommand().equals("显示利润折线图")) {
			ArrayList<SaleInfo> saleinfoList;
			try {
				saleinfoList = saleInfoService.getCategorySaleInfo();
		        DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
				for (int i = 0; i < saleinfoList.size(); i++) {
					dataset.addValue(saleinfoList.get(i).getSaleProfit(), "利润", 
							saleinfoList.get(i).getSaleDate());
				}
				 //2. 构造chart
				JFreeChart chart = ChartFactory.createLineChart("利润图 ", "日期", "利润",  
		                dataset, PlotOrientation.VERTICAL, true, true, true);  
		  
		        CategoryPlot cp = chart.getCategoryPlot();  
		        cp.setBackgroundPaint(ChartColor.WHITE); // 背景色设置  
		        cp.setRangeGridlinePaint(ChartColor.GRAY); // 网格线色设置  
				// 5. chart 以swing形式输出
				ChartFrame pieFrame = new ChartFrame("商品销量报表", chart);
				pieFrame.pack();
				pieFrame.setLocationRelativeTo(null);
				pieFrame.setVisible(true);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		
		if(e.getActionCommand().equals("导出Excel报表")){
			
			//创建工作薄
	        try {
	        		ArrayList<SaleInfo> saleinfoList;
					saleinfoList = saleInfoService.getSaleInfo();
			for (int i = 0; i < saleinfoList.size(); i++) {

				this.dtm.addRow(new Object[] {

						saleinfoList.get(i).getSaleid(),
						saleinfoList.get(i).getEmpid(),
						saleinfoList.get(i).getGoodsid(),
						saleinfoList.get(i).getGoodsName(),
						saleinfoList.get(i).getGoodsNum(),
						saleinfoList.get(i).getVipid(),
						saleinfoList.get(i).getSaleProfit(),
						saleinfoList.get(i).getSaleDate() });
			}
			
//			FileDialog fileDialog=new FileDialog(this);
//			fileDialog.setVisible(true);
				WritableWorkbook workbook = Workbook.createWorkbook(new File("E:\\test\\销售记录信息.xls"));
				//创建新的一页
				WritableSheet sheet = workbook.createSheet("销售记录",0);
				//创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
				Label label1  = new Label(0,0,"销售编号");
				sheet.addCell(label1);
				Label label2  = new Label(1,0,"职员编号");
				sheet.addCell(label2);
				Label label3  = new Label(2,0,"商品编号");
				sheet.addCell(label3);
				Label label4  = new Label(3,0,"商品名称");
				sheet.addCell(label4);
				Label label5  = new Label(4,0,"销售数量");
				sheet.addCell(label5);      
				Label label6  = new Label(5,0,"会员编号");
				sheet.addCell(label6); 
				Label label7  = new Label(6,0,"盈利");
				sheet.addCell(label7);
				Label label8  = new Label(7,0,"销售日期");
				sheet.addCell(label8); 
				
				for(int i=0;i<saleinfoList.size();i++){
				    
					Label l1 = new Label(0,i+1,saleinfoList.get(i).getSaleid()+"");
					Label l2 = new Label(1, i+1, saleinfoList.get(i).getEmpid()+"");
					Label l3 = new Label(2, i+1, saleinfoList.get(i).getGoodsid()+"");
					Label l4 = new Label(3, i+1, saleinfoList.get(i).getGoodsName()+"");
					Label l5 = new Label(4, i+1, saleinfoList.get(i).getGoodsNum()+"");
					Label l6 = new Label(5, i+1, saleinfoList.get(i).getVipid()+"");
					Label l7 = new Label(6, i+1, saleinfoList.get(i).getSaleProfit()+"");
					Label l8 = new Label(7, i+1, saleinfoList.get(i).getSaleDate()+"");
					
					sheet.addCell(l1);
					sheet.addCell(l2);
					sheet.addCell(l3);
					sheet.addCell(l4);
					sheet.addCell(l5);
					sheet.addCell(l6);
					sheet.addCell(l7);
					sheet.addCell(l8);
				}
				//把创建的内容写入到输出流中，并关闭输出流
				workbook.write();
				workbook.close();
				int count = this.dtm.getRowCount();
				for (int i = 0; i < count; i++) {
					this.dtm.removeRow(0);
				}
				bindData();
				JOptionPane.showMessageDialog(this, "导出完成");
				
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	        
		}
		
		if (e.getActionCommand().equals("刷新")) {
			MainFrame mainFrame = new MainFrame();
			this.dispose();
			
		}

	}

}
