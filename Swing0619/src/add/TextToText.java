package add;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextToText implements MouseListener{
	JPanel panelCenter;
	JButton btn;
	JButton btnAdd;
	JButton btnMove;
	Point startPoint;
	JTextField put1;
	JTextField put2;
	JTextField put3;


	public void createGUI(){
		JFrame frm= new JFrame("Mouse1");
		frm.setBounds(200, 150, 300, 400);


		panelCenter = new JPanel();
		panelCenter.setLayout(null);
		//중앙패널 배치관리자는 없음
		JLabel label1 = new JLabel("+");

		//북쪽 버튼 2개 만듬
		btnAdd= new JButton("결과");
		btnAdd.setBounds(100, 130, 95, 30);
		put1 = new JTextField(10);
		put1.setBounds(40, 55, 95, 30);
		put2 = new JTextField(10);
		put2.setBounds(160, 55, 95, 30);
		put3 = new JTextField(10);
		put3.setBounds(100, 185, 95, 30);
		label1.setBounds(145, 55, 95, 30);
		btnAdd.addMouseListener(this);
		put1.setHorizontalAlignment(JTextField.RIGHT);
		put2.setHorizontalAlignment(JTextField.RIGHT);
		put3.setHorizontalAlignment(JTextField.RIGHT);

		//버튼두개를 북쪽에 붙임
		panelCenter.add(btnAdd);
		panelCenter.add(put1);
		panelCenter.add(put2);
		panelCenter.add(put3);
		panelCenter.add(label1);
		//패널을 프레임에 붙임

		frm.add(panelCenter, "Center");

		//빨간버튼누르면 닫기되는 버튼 3과JFrame.EXIT_ON_CLOSE는 같은 동작
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//프레임을 그려넣음
		frm.setVisible(true);

	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new TextToText().createGUI();

			}
		});

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int one = Integer.parseInt(put1.getText());
		int two = Integer.parseInt(put2.getText());
		put3.setText(Integer.toString(one+two));			
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}





}