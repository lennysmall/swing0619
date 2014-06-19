package add;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Mouse1 implements MouseListener{
	JPanel panelCenter;
	JButton btn;
	JButton btnAdd;
	JButton btnMove;
	Point startPoint;
	JButton btnOut;

	public void createGUI(){
		JFrame frm= new JFrame("Mouse1");
		frm.setBounds(200, 150, 300, 400);

		JPanel panelNorth = new JPanel();
		JPanel panelSouth = new JPanel();
		//북쪽에 패널을 생성해서 버튼두개를 추가할 위치를 만든다
		panelNorth.setLayout(new GridLayout(1,2,5,2));
		panelSouth.setLayout(new GridLayout(1,2));

		panelCenter = new JPanel();
		
		//중앙패널 배치관리자는 없음
		panelCenter.setLayout(null);
		
		//북쪽 버튼 2개 만듬
		btnAdd= new JButton("버튼1");
		btnMove=new JButton("버튼2");
		btnOut = new JButton("출력창");
		
		
		btnAdd.addMouseListener(this);
		btnMove.addMouseListener(this);

		//버튼에 각각의 액션리스너를 등록
	
		
		//버튼두개를 북쪽에 붙임
		panelNorth.add(btnAdd);
		panelNorth.add(btnMove);
		panelSouth.add(btnOut);

		//패널을 프레임에 붙임
		frm.add(panelNorth, "North");
		frm.add(panelCenter, "Center");
		frm.add(panelSouth, "South");

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
			new Mouse1().createGUI();
		}
	});

}
@Override
public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
//	btnOut.setText("마우스가 클릭 됐습니다.");
//	btnOut.setForeground(Color.blue);
}
@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	btnOut.setText("마우스가 들어 왔습니다.");
	btnOut.setForeground(Color.black);
}
@Override
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	btnOut.setText("마우스가 나갔 습니다.");
	btnOut.setForeground(Color.black);
}
@Override
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	btnOut.setText("마우스를 누르고 있습니다.");
	btnOut.setForeground(Color.red);
}
@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	btnOut.setText("마우스가 누름해지.");
	btnOut.setForeground(Color.red);
}
}