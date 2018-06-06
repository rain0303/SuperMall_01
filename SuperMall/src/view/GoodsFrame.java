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
	private JScrollPane jScrollPane;// �������
	private JTable jTable;// ���
	private JLabel jLabelback;//����
	private DefaultTableModel defaultTableModel;// ��ģ��
	private JButton jButton;// ��ť1
	private JButton jButton3;
	private JButton jButton2;// ��ť2
	private JButton jButton4;// ��ť4
	
	private JLabel jLabel;// ����
	private JLabel jLabel2;// ������Ʒ��Ų�ѯ
	private JLabel jLabel3;// ������Ʒ���Ʋ�ѯ
	private JTextField jTextField;// ��ţ�
	private JTextField jTextField2;// ����
	private GoodsinfoServer goodsinfoServer = new GoodsinfoServer();

	public GoodsFrame() {
		this.setSize(600, 550);
		this.setTitle("��Ʒ����");
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.init();
		this.bindData();// ��������
		this.setVisible(true);// ���
	}

	/**
	 * ��ʼ������������Ա�ؼ���
	 */
	public void init() {
		this.jButton = new JButton("�޸���Ʒ");
		this.jButton3=new JButton("���ۼ�¼����");
		this.jButton2 = new JButton("��ѯ");
		this.jButton4 = new JButton("����");
		this.jLabel = new JLabel("��Ʒ����");
		this.jLabel2 = new JLabel("��Ʒ���:");
		this.jLabel3 = new JLabel("��Ʒ����:");
		this.jTextField = new JTextField();
		this.jTextField2 = new JTextField();
		this.jScrollPane = new JScrollPane();
		this.jTable = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	
		this.jScrollPane.getViewport().add(jTable);
		Object [] columns=new Object[] { "��Ʒ���", "��ƷͼƬ", "��Ʒ����", "��Ʒ���", "��Ʒ����", "��Ʒ�ۼ�",
		"��Ʒ����" };
		
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

		// �������ꣻ
		this.jScrollPane.setBounds(25, 120, 540, 300);

		/**
		 * �����黯
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
		this.jLabel2.setBounds(80, 80, 80, 30);// ���ݱ�Ų�ѯ��
		this.jTextField.setBounds(160, 80, 80, 30);
		this.jLabel3.setBounds(300, 80, 80, 30);
		this.jTextField2.setBounds(380, 80, 80, 30);
		this.jButton.setBounds(170, 450, 100, 30);
		this.jButton3.setBounds(30, 450, 120, 30);
		this.jButton2.setBounds(290, 450, 100, 30);
		this.jButton4.setBounds(450, 450, 100, 30);
		ImageIcon iic = new ImageIcon("images/������ѡ2.jpg");
		iic.setImage(iic.getImage().getScaledInstance(600, 550, Image.SCALE_DEFAULT));
		// Ϊ�ؼ����ע���¼�
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
		if (e.getActionCommand().equals("��ѯ")) {

			try {
			
				// ���� ����
				int goodsid = 0;
				String goodsname = "";
				// 1 �����û����
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
				// view �ռ���� <=>service <=>dao

				ArrayList<Goodsinfo> goodsinfoList = goodsinfoServer
						.selectgoodsinfo(goodsinfo);
				// ʹ������<=>ģ��
				// ��յ�ǰģ���е�����
				// ϸ�� ���� <=>��̬��
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
				JOptionPane.showMessageDialog(this, "����������ݴ���");
			}
		}

		if (e.getActionCommand().equals("�޸���Ʒ")) {
			// �ӱ���л�ȡ�û�ѡ�����

			int index = this.jTable.getSelectedRow();
			// System.out.println(index);
			// �����û�ѡ���� ��ȡ��ǰ�еĵ�Ԫ������� �����е��±�
			// �����
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
				goodsinfo.setGoodsId(Integer.parseInt(goodsid));// String ��װ��
				goodsinfo.setGoodsName(goodsname);
				goodsinfo.setGoodsCategoryName(goodscategoryname);
				goodsinfo.setGoodsCPrice(Double.parseDouble(goodscprice));
				goodsinfo.setGoodsPrice(Double.parseDouble(goodsprice));
				goodsinfo.setGoodsStock(Integer.parseInt(goodsstock));
				goodsinfo.setGoodsPhoto(goodsphoto);
				// �����û��༭��Ϣ����
				// �������봰�� ��֮�䴫������ ���췽��
				GoodsEditFrame goodsEditFrame = new GoodsEditFrame(goodsinfo);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "���ݴ���");
			}
			}
			catch (Exception e1) {
				// TODO: handle exception
			}
		}
		if (e.getActionCommand().equals("���ۼ�¼����")) {
			MainFrame mainFrame = new MainFrame();
			this.dispose();
		}
		if (e.getActionCommand().equals("����")) {
			EmpInfoManageFrame empInfoManageFrame = new EmpInfoManageFrame();
			this.dispose();
		}
	}
}
