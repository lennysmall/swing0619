package add;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoveTest implements ActionListener{
	JButton btn;
	JButton btn1;
	JPanel panel;
	JFrame frm;
	int i = 1;
	
	public void createGUI(){
		frm = new JFrame();
		frm.setSize(300, 300);
		frm.setLayout(new GridLayout(2,1));
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		btn = new JButton("버튼추가");
		
		btn.setBounds(20, 20, 100, 30);
		btn.addActionListener(this);
		btn1 = new JButton("버튼추가1");
		
		frm.add(btn,"North");
		frm.add(btn1,"North1");
		frm.add(panel);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new MoveTest().createGUI();
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn1 = new JButton("Button"+i);
		i++;
		
		panel.add(btn1);
		frm.validate();
	}
}
