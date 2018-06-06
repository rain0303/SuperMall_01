package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import bean.SupplierInfo;

/****
 * ������ϸ��Ϣ����
 * 
 * @author Administrator
 * 
 */

public class OrderInfoFrame extends JFrame implements ActionListener {
	private JLabel jLabelback;
	private JScrollPane jScrollPane;
	private JTable jTable;
	private DefaultTableModel dtm;
	private InproInfo inproInfo;
	private InproInfoService inproInfoService = new InproInfoService();
	private JLabel jLabel;
	private JButton jButton;
	private JButton jButton2;
	private JButton jButton3;
	private static final String Defaultmat = "yyyy-MM-dd";
	SimpleDateFormat df = new SimpleDateFormat(Defaultmat);// �������ڸ�ʽ

	public OrderInfoFrame() {
		this.setSize(600, 550);
		this.setTitle("������ϸ��Ϣ���� ");
		this.setLocationRelativeTo(null);
		this.setLayout(null);// �ղ���
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.init();
		this.bindData();
		this.setVisible(true);// ���
	}

	public void init() {
		ImageIcon iic = new ImageIcon("images/������ѡ2.jpg");
		iic.setImage(iic.getImage().getScaledInstance(600, 550, Image.SCALE_DEFAULT));
		// Ϊ�ؼ����ע���¼�
		this.jLabelback=new JLabel(iic);
		this.jLabelback.setBounds(0, 0, 600, 550);
		JFrame jf = new JFrame("VipinfoFrame");
		this.jTable = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		Object [] columns=new Object[] {
				"�������", "��������", "�����̱��", "��Ʒ����", "��Ʒ����", "��ע", "ְԱ���" };
		this.dtm = new DefaultTableModel(new Object[][] {},columns );
		this.jScrollPane = new JScrollPane();
		this.jLabel = new JLabel("������ϸ��Ϣ��");
		this.jButton = new JButton("�޸Ķ���");
		this.jButton2 = new JButton("ɾ������");
		this.jButton3 = new JButton("����");
		this.jLabel.setBounds(210, 30, 120, 40);
		this.jButton.setBounds(120, 320, 120, 40);
		this.jButton2.setBounds(250, 320, 120, 40);
		this.jButton3.setBounds(380, 320, 120, 40);
		this.jScrollPane.getViewport().add(jTable);
		this.jTable.setModel(dtm);
		this.jScrollPane.setBounds(40, 80, 500, 200);
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
		
		this.add(jScrollPane);
		
		this.add(jLabel);
		this.add(jButton);
		this.add(jButton2);
		this.add(jButton3);
		this.add(jLabelback);
		this.jButton.addActionListener(this);
		this.jButton2.addActionListener(this);
		this.jButton3.addActionListener(this);
	}

	public void bindData() {

		try {

			ArrayList<InproInfo> inproInfoList = inproInfoService
					.getInproInfo();

			for (int i = 0; i < inproInfoList.size(); i++) {

				this.dtm.addRow(new Object[] { inproInfoList.get(i).getProId(),
						inproInfoList.get(i).getProdate(),
						inproInfoList.get(i).getDid(),
						inproInfoList.get(i).getGoodsName(),
						inproInfoList.get(i).getGoodsNum(),
						inproInfoList.get(i).getRemark(),
						inproInfoList.get(i).getEmpId() });

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("����")) {
			PurchaseFrame purchaseFrame = new PurchaseFrame();
			this.dispose();
		}

		if (e.getActionCommand().equals("�޸Ķ���")) {
			int index = this.jTable.getSelectedRow();
			if (index < 0) {
				JOptionPane.showMessageDialog(this, "��û��ѡ�񶩵�");
				return;
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
				inproInfo.setProId(Integer.parseInt(proId));// String ��װ��
				inproInfo.setGoodsNum(Integer.parseInt(goodsNum));
				inproInfo.setRemark(remark);
				inproInfo.setGoodsName(goodsName);
				inproInfo.setEmpId(Integer.parseInt(empId));
				inproInfo.setDid(Integer.parseInt(Did));

				Date date = null;
				try {
					date = this.df.parse(prodate);
					inproInfo.setProdate(date);

				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				OrderEditFrame orderEditFrame = new OrderEditFrame(inproInfo);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "���ݴ���");
			}

		}
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("ɾ������")) {

			int index = this.jTable.getSelectedRow();
			if (index < 0) {
				JOptionPane.showMessageDialog(this, "��û��ѡ�񶩵�");
				return;
			}
			if (this.jTable.getValueAt(index, 0) != null
					&& this.jTable.getValueAt(index, 1) != null
					&& this.jTable.getValueAt(index, 2) != null
					&& this.jTable.getValueAt(index, 3) != null
					&& this.jTable.getValueAt(index, 4) != null
					&& this.jTable.getValueAt(index, 5) != null) {
				String proId = this.jTable.getValueAt(index, 0).toString();
				InproInfo inproInfo = new InproInfo();
				inproInfo.setProId(Integer.parseInt(proId));
				boolean flag;
				try {
					flag = inproInfoService.deleteInproInfo(inproInfo);

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
					e1.printStackTrace();
				}

			}
		}

	}

}
