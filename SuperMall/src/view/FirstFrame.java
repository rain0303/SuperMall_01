package view;

import javax.swing.*;

import org.jvnet.substance.skin.*;

import bean.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import service.*;

/**
 * 在需要使用事件的窗体类中 实现事件接口 在需要使用事件的控件上添加注册事件
 * 
 * @author Administrator
 * 
 */
public class FirstFrame extends JFrame implements ActionListener {
	// 类的成员<=>窗体上面的控件 control<=>class
	private JButton jButton;
	private JButton jButton2;
	private JButton jButton3;
	private JLabel jLabel;
	private JLabel jLabel2;

	public FirstFrame() {

		this.setSize(600, 550);
		this.setTitle("用户登录窗体 ");
		this.setLocationRelativeTo(null);
		this.setLayout(null);// 空布局
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.init();
		this.setVisible(true);// 最后

	}

	/**
	 * 初始化窗体在其它成员
	 */
	public void init() {
		// 实例化
		this.jLabel = new JLabel("职工入口处");
		this.jLabel.setBounds(163, 333, 120, 30);
		ImageIcon iic2 = new ImageIcon("images/超市门口.png");
		iic2.setImage(iic2.getImage().getScaledInstance(120, 90,
				Image.SCALE_DEFAULT));
		this.jButton = new JButton(iic2);
		// 设置坐标
		this.jButton.setBounds(133, 363, 120, 98);
		
		
		ImageIcon iic3 = new ImageIcon("images/后门.png");
		iic3.setImage(iic3.getImage().getScaledInstance(40, 40,
				Image.SCALE_DEFAULT));
		this.jButton2 = new JButton(iic3);
		// 设置坐标
		this.jButton2.setBounds(356, 403, 40, 40);
		
		
		ImageIcon iic4 = new ImageIcon("images/VIP图.jpg");
		iic4.setImage(iic4.getImage().getScaledInstance(50,100,
				Image.SCALE_DEFAULT));
		this.jButton3 = new JButton(iic4);
		// 设置坐标
		this.jButton3.setBounds(430, 350, 50, 100);

		// 添加控制到窗体

		ImageIcon iic = new ImageIcon("images/超市背景.jpg");
		iic.setImage(iic.getImage().getScaledInstance(600, 550,
				Image.SCALE_DEFAULT));
		// 为控件添加注册事件
		this.jLabel2 = new JLabel(iic);
		this.jLabel2.setBounds(0, 0, 600, 550);
		this.jButton.setActionCommand("a");
		this.jButton2.setActionCommand("b");
		this.add(jButton);
		this.add(jButton2);
		this.add(jButton3);
		this.add(jLabel);
		this.add(jLabel2);
		
		this.jButton.addActionListener(this);// 接口做为参数，传实现了接口class
		this.jButton2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("a")) {
		LoginFrame loginFrame = new LoginFrame();
		this.dispose();
		}
		if (e.getActionCommand().equals("b")) {
			VIPFirst vipFirst = new VIPFirst();
			this.dispose();
			}
	}

}
