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
	private JButton jButton6;//ע��
	private JButton jButton7;//��ѯ
	private JButton jButton8; //ɾ��
	private JTextField jTextField;// ��Ų�ѯ
	private JButton jButton9;//��ʾ����״ͼ�� 
	private JButton jButton10;//����excel��
	private JButton jButton11;//��ʾ����ͼ
	private JButton jButton12;//����
	private JLabel jLabel;
	private JLabel jLabel2;

	private JTable jTable;
	private DefaultTableModel dtm;
	private JScrollPane jScrollPane;
	private SaleInfoService saleInfoService = new SaleInfoService();
//	private GoodsinfoServer goodsinfoServer = new GoodsinfoServer();
	public MainFrame() {

		this.setSize(600, 550);
		this.setTitle("���ۼ�¼������ ");
		this.setLocationRelativeTo(null);
		this.setLayout(null);// �ղ���
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.init();
		this.bindData();
		this.setVisible(true);// ���
	}

	private void init() {
		JFrame jf = new JFrame("VipinfoFrame");
		ImageIcon iic = new ImageIcon("images/������ѡ2.jpg");
		iic.setImage(iic.getImage().getScaledInstance(600, 550, Image.SCALE_DEFAULT));
		// Ϊ�ؼ����ע���¼�
		this.jLabelback=new JLabel(iic);
		this.jLabelback.setBounds(0, 0, 600, 550);
		// TODO Auto-generated method stub
		this.jButton = new JButton("ˢ��");
		this.jButton6 = new JButton("ע��");
		this.jButton7 = new JButton("��ѯ");
		this.jButton8 = new JButton("ɾ����¼");
		this.jButton9 = new JButton("��ʾ������״ͼ");
		this.jButton10 = new JButton("����Excel����");
		this.jButton11 = new JButton("��ʾ��������ͼ");
		this.jButton12 = new JButton("����");
		this.jLabel = new JLabel("�������Ų�ѯ");
		this.jLabel2 = new JLabel("������ ��ѯ");
		this.jTextField = new JTextField();
		this.jScrollPane = new JScrollPane();
		this.jTable = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		Object [] columns=new Object[] {
				"�������", "ְԱ���","��Ʒ���", "��Ʒ����", "��������","��Ա���", "ӯ��", "��������"};
		this.dtm = new DefaultTableModel(new Object[][] {},columns );
		// ���ù������ͱ��Ĺ�ϵ
		this.jScrollPane.getViewport().add(jTable);
		// ���ñ����ģ�͵Ĺ�ϵ
		this.jTable.setModel(dtm);
		/**
		 * �����黯
		 */
		
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setOpaque(false);
		for (int i = 0; i < columns.length; i++) {
			jTable.getColumn(columns[i]).setCellRenderer(cellRenderer);
		}
		jTable.setOpaque(false);
		this.jScrollPane.setOpaque(false);
		this.jScrollPane.getViewport().setOpaque(false);
		
		// ����
		datepick = new DatePicker(null, DefaultFormat, font, dimension);// �Զ������ֵ
		datepick.setBounds(200, 60, 150, 30);
		datepick.setLocale(Locale.CHINA);// ���ù���
		datepick.setTimePanleVisible(true);// ����ʱ�����ɼ�
		// ���ܰ�ť
		this.jButton.setBounds(450, 60, 80, 30);
		this.jButton12.setBounds(450, 410, 80, 30);
		this.jButton6.setBounds(450, 460, 80, 30);
		// ��ѯ
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
	 * ������
	 */
	public void bindData() {

		// ��̬����
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
		if (e.getActionCommand().equals("ע��")) {
			LoginFrame myLoginFrame = new LoginFrame();
			this.dispose();
			JOptionPane.showMessageDialog(this, "ע���ɹ�");
		}
		if(e.getActionCommand().equals("����")){
			EmpInfoManageFrame empInfoManageFrame = new EmpInfoManageFrame();
		}

		if (e.getActionCommand().equals("��ѯ")) {

			try {
				
				// ���� ����
				int saleid = 0;
				Date saleDate = null;
				String chosedate = this.datepick.getText();
				// String username = "";
				// 1 �����û����
				if (!this.jTextField.getText().equals("")) {
					saleid = Integer.parseInt(this.jTextField.getText().trim());
				}
				if (!this.datepick.getText().equals("")) {
					saleDate = this.sdf.parse(chosedate);
				}
				
				SaleInfo saleinfo = new SaleInfo();
				saleinfo.setSaleid(saleid);
				saleinfo.setSaleDate(saleDate);
				// view �ռ���� <=>service <=>dao
				ArrayList<SaleInfo> saleinfoList = saleInfoService
						.selectSaleinfo(saleinfo);
				// ʹ������<=>ģ��
				// ��յ�ǰģ���е�����
				// ϸ�� ���� <=>��̬��
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
				JOptionPane.showMessageDialog(this, "����������ݴ���");
				
			}
		}
		// ɾ��
		if (e.getActionCommand().equals("ɾ����¼")) {

			int index = this.jTable.getSelectedRow();
			if(index<0){
				JOptionPane.showMessageDialog(this, "��δѡ��Ҫɾ���ļ�¼");
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
						JOptionPane.showMessageDialog(this, "ɾ���ɹ�");
						int count = this.dtm.getRowCount();
						for (int i = 0; i < count; i++) {
							this.dtm.removeRow(0);
						}
						bindData();
					} else {
						JOptionPane.showMessageDialog(this, "ɾ��ʧ��");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					
				}

			}
		}
		if (e.getActionCommand().equals("��ʾ������״ͼ")) {
			ArrayList<SaleInfo> saleinfoList;
			try {
				saleinfoList = saleInfoService.getPieSaleInfo();
				DefaultPieDataset dataset = new DefaultPieDataset();				
				for (int i = 0; i < saleinfoList.size(); i++) {
					dataset.setValue(saleinfoList.get(i).getGoodsName()+"", 
							saleinfoList.get(i).getGoodsNum() );
				}
				 //2. ����chart
				JFreeChart chart = ChartFactory.createPieChart("��Ʒ��������ͼ", dataset,  
		                true, true, true);  
		  
		        Plot cp = chart.getPlot();  
		        cp.setBackgroundPaint(ChartColor.WHITE); // ����ɫ���� 

				// 5. chart ��swing��ʽ���
				ChartFrame pieFrame = new ChartFrame("��Ʒ��������", chart);
				pieFrame.pack();
				pieFrame.setLocationRelativeTo(null);
				pieFrame.setVisible(true);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		
		if (e.getActionCommand().equals("��ʾ��������ͼ")) {
			ArrayList<SaleInfo> saleinfoList;
			try {
				saleinfoList = saleInfoService.getCategorySaleInfo();
		        DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
				for (int i = 0; i < saleinfoList.size(); i++) {
					dataset.addValue(saleinfoList.get(i).getSaleProfit(), "����", 
							saleinfoList.get(i).getSaleDate());
				}
				 //2. ����chart
				JFreeChart chart = ChartFactory.createLineChart("����ͼ ", "����", "����",  
		                dataset, PlotOrientation.VERTICAL, true, true, true);  
		  
		        CategoryPlot cp = chart.getCategoryPlot();  
		        cp.setBackgroundPaint(ChartColor.WHITE); // ����ɫ����  
		        cp.setRangeGridlinePaint(ChartColor.GRAY); // ������ɫ����  
				// 5. chart ��swing��ʽ���
				ChartFrame pieFrame = new ChartFrame("��Ʒ��������", chart);
				pieFrame.pack();
				pieFrame.setLocationRelativeTo(null);
				pieFrame.setVisible(true);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		
		if(e.getActionCommand().equals("����Excel����")){
			
			//����������
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
				WritableWorkbook workbook = Workbook.createWorkbook(new File("E:\\test\\���ۼ�¼��Ϣ.xls"));
				//�����µ�һҳ
				WritableSheet sheet = workbook.createSheet("���ۼ�¼",0);
				//����Ҫ��ʾ������,����һ����Ԫ�񣬵�һ������Ϊ�����꣬�ڶ�������Ϊ�����꣬����������Ϊ����
				Label label1  = new Label(0,0,"���۱��");
				sheet.addCell(label1);
				Label label2  = new Label(1,0,"ְԱ���");
				sheet.addCell(label2);
				Label label3  = new Label(2,0,"��Ʒ���");
				sheet.addCell(label3);
				Label label4  = new Label(3,0,"��Ʒ����");
				sheet.addCell(label4);
				Label label5  = new Label(4,0,"��������");
				sheet.addCell(label5);      
				Label label6  = new Label(5,0,"��Ա���");
				sheet.addCell(label6); 
				Label label7  = new Label(6,0,"ӯ��");
				sheet.addCell(label7);
				Label label8  = new Label(7,0,"��������");
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
				//�Ѵ���������д�뵽������У����ر������
				workbook.write();
				workbook.close();
				int count = this.dtm.getRowCount();
				for (int i = 0; i < count; i++) {
					this.dtm.removeRow(0);
				}
				bindData();
				JOptionPane.showMessageDialog(this, "�������");
				
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	        
		}
		
		if (e.getActionCommand().equals("ˢ��")) {
			MainFrame mainFrame = new MainFrame();
			this.dispose();
			
		}

	}

}
