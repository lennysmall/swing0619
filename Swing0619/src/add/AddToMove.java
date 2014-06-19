package add;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AddToMove {
	JPanel panelCenter;
	JButton btn;
	JButton btnAdd;
	JButton btnMove;
	Point startPoint;

	public void createGUI(){
		JFrame frm= new JFrame("AddToMove");
		frm.setBounds(200, 150, 300, 400);

		JPanel panelNorth = new JPanel();
		//북쪽에 패널을 생성해서 버튼두개를 추가할 위치를 만든다
		panelNorth.setLayout(new GridLayout(1,2,5,2));

		panelCenter = new JPanel();
		//중앙패널 배치관리자는 없음
		panelCenter.setLayout(null);

		//북쪽 버튼 2개 만듬
		btnAdd= new JButton("버튼추가");
		btnMove=new JButton("이동");

		//버튼에 각각의 액션리스너를 등록
		btnAdd.addActionListener(new ButtonAdd());
		//이동을 비활성 시키는 메소드, 이동버튼 비활성화
		btnMove.setEnabled(false);
		//버튼에 각각의 액션리스너를 등록
		btnMove.addActionListener(new ButtonMove());

		//버튼두개를 북쪽에 붙임
		panelNorth.add(btnAdd);
		panelNorth.add(btnMove);

		//패널을 프레임에 붙임
		frm.add(panelNorth, "North");
		frm.add(panelCenter, "Center");

		//빨간버튼누르면 닫기되는 버튼 3과JFrame.EXIT_ON_CLOSE는 같은 동작
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//프레임을 그려넣음
		frm.setVisible(true);
	}
	//버튼이 추가됐을때 작동하는클래스
	class ButtonAdd implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			btn = new JButton("버튼");
			//imageIcon icon = new ImageIcon("image/12.gif) 그림지정시
			//btn = new MyBuootn(icon);

			//시작시점
			startPoint = new Point(10,10);
			//btn은 적정크기를 가져온다

			//넓이와 높이를 설정한다. 규모 ,공간
			//getPreferredSize 그림크기에 맞게 버튼크기조정
			Dimension dim =btn.getPreferredSize();
			//dim.width,(int)dim.getHeight 둘다됨
			btn.setBounds(startPoint.x, startPoint.y, dim.width,(int)dim.getHeight());

			panelCenter.add(btn);
			panelCenter.repaint();
			btnMove.setEnabled(true);
			btnAdd.setEnabled(false);
		}}

	class ButtonMove implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Thread th = new MyTread();
			th.start();

		}}

	class MyTread extends Thread{
		@Override
		public void run() {
			for(int i=startPoint.x; i<200; i++){
				final int finalI= i;
				//러너블 =익명클래스. 생성자는 못만듬
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						btn.setLocation(finalI, finalI);
					}
				});
				try{Thread.sleep(500);

				}catch(InterruptedException e){

				}
			}
		}
	}

	
	
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new AddToMove().createGUI();
			}
		});

	}

}
