package Java2D;
import java.awt.Image ;
import java.awt.Dimension ;
import java.awt.Toolkit ;

import javax.swing.JFrame ;
import javax.swing.ImageIcon ;

public class Intro2 extends JFrame {

	public Intro2() {
		setSize(800, 600) ;
		setVisible(true) ;
		setTitle("Title") ;
		
		ImageIcon logoicon = new ImageIcon("Logo.png") ;
		Image logo = logoicon.getImage() ;
		setIconImage(logo) ;
		
		setResizable(false) ;
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize() ;
		int w = getSize().width ;
		int h = getSize().height ;
		int x = (dim.width - w)/2 ;
		int y = (dim.height - h)/2 ;
		
		//move the window
		setLocation(x,y) ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		
	}
	public static void main(String[] args) {
		Intro2 frameclass = new Intro2() ;
	}

}
