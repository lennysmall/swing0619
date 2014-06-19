package add;

import java.awt.Dimension;
import java.beans.Transient;

import javax.swing.ImageIcon;
import javax.swing.JButton;

class MyButton extends JButton{
	public MyButton(ImageIcon icon){
		super(icon);
	}
	public MyButton(String title){
		super(title);
	}
	public MyButton() {
	}
	
	@Override
	@Transient
	public Dimension getPreferredSize() {
		Dimension dim = super.getPreferredSize();
		dim.setSize(dim.width+100, dim.height);
		return dim;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
