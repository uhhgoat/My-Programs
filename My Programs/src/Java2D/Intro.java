package Java2D ;
import java.awt.* ;
//import java.awt.FlowLayout ;
//import java.awt.Image ;
//import java.awt.Dimension ;
//import java.awt.Toolkit ;


import javax.swing.* ;
//import javax.swing.JFrame ;
//import javax.swing.ImageIcon ;
//import javax.swing.JLabel ;

public class Intro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame() ;
		frame.setSize(800, 600) ;
		frame.setVisible(true) ;
		frame.setTitle("Title") ;
		
		ImageIcon logoicon = new ImageIcon("Logo.png") ;
		Image logo = logoicon.getImage() ;
		frame.setIconImage(logo) ;
		
		frame.setResizable(false) ;
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize() ;
		int w = frame.getSize().width ;
		int h = frame.getSize().height ;
		int x = (dim.width - w)/2 ;
		int y = (dim.height - h)/2 ;
		
		//move the window
		frame.setLocation(x,y) ;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		
		JLabel jlab = new JLabel("HELLO THERE") ;
		frame.add(jlab) ;
		frame.setLayout(new FlowLayout()) ;
	}

}
