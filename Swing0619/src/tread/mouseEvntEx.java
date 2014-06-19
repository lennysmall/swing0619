package tread;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class mouseEvntEx extends JFrame implements MouseListener {
	JLabel Lb;
	JButton Btn;
	
	public mouseEvntEx() {
		setTitle("마우스 이벤트 예제");
		setLayout(new FlowLayout());
		
		Lb = new JLabel("마우스를 사용해 보세요");
		Btn = new JButton("버튼에 동작하는 마우스 이벤트");
		add(Btn);
		add(Lb);
		Btn.addMouseListener(this);
		setSize(300,200);
		setVisible(true);
	}
	
	public void mousePressed(MouseEvent e) {
		Lb.setText("마우스를 누르고있습니다.");
		Lb.setForeground(Color.magenta);
	}
	
	public void mouseReleased(MouseEvent e) {
		Lb.setText("마우스가 누름해지 되었습니다.");
		Lb.setForeground(Color.red);
	}
	public void mouseClicked(MouseEvent e) {
		Lb.setText("마우스가 클릭되었습니다.");
		Lb.setForeground(Color.blue);
	}
	
	public void mouseEntered(MouseEvent e) {
		Lb.setText("마우스가 들어 왔습니다.");
		Lb.setForeground(Color.cyan);
	}
	
	public void mouseExited(MouseEvent e) {
		Lb.setText("마우스i가 나갔습니다.");
		Lb.setForeground(Color.blue);
	}
	public static void main(String[] args) {
		mouseEvntEx f = new mouseEvntEx();	
	}
}