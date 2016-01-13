package Graphics;

import java.awt.* ;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.* ;

public class MyWindow extends JFrame implements KeyListener
{
	int width1 = 800 ;
	int height1 = 800 ;
	Hero girl ;
	BufferedImage landscape ;
	boolean itemPickedUp;
	public static void main(String[] args)
	{
		new MyWindow() ;
	}
	
	public MyWindow()
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize() ;
		//the Following are JFrame Methods
		setVisible(true) ;
		setSize(width1, height1) ;
		setTitle("Graphics Testing") ;
		setResizable(false) ;
		
		int w = getSize().width ;
		int h = getSize().height ;
		int x = (dim.width - w)/2 ;
		int y = (dim.height - h)/2 ;
		ImageIcon logoicon = new ImageIcon("Logo.png") ;
		Image logo = logoicon.getImage() ;
		setIconImage(logo) ;
		
		setLocation(x,y) ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		
		JLabel jlab = new JLabel("Graphics Testing") ;
		add(jlab) ;
		setLayout(new FlowLayout()) ;
		girl = new Hero("Girl", "/images/heroes/gears.jpeg", 0, 400) ;
		landscape = new BufferedImage(width1, height1, BufferedImage.TYPE_INT_ARGB) ;
		addKeyListener(this) ;
	}
	public void paint(Graphics g)
	{
		BufferedImage image = new BufferedImage(width1, height1, BufferedImage.TYPE_INT_ARGB) ;
		Graphics2D g2 = (Graphics2D)image.getGraphics() ;
		g2.setColor(Color.white) ;
//		girl = new Hero("Girl", "/images/heroes/gears.jpeg", 0, 400) ;
		Hero boy = new Hero("Boy", "/images/heroes/gears2.jpg", 0, 0) ;
//		g2.drawImage(girl.getImage(), girl.getX(), girl.getY(), null) ;
//		g2.setColor(Color.green) ;
//		g2.fillRect(200, 200, 100, 100) ;
//		g2.setColor(Color.red) ;
//		g2.fillOval(50, 100, 200, 200) ;
//		g2.setColor(Color.blue) ;
//		g2.drawOval(50, 100, 200, 200) ;
//		g2.drawArc(300, 100, 200, 200, -180, 180) ;
//		g2.drawString("HELLO", 500, 500) ;
//		g2.drawLine(0,  0, width1, height1) ;
		
			
			
		int squareD = 20 ;
		int margin = 2 ;
		int a = 0 ;
		int b = 0 ;
		int c = 0 ;
		
		for(int x = 0 ; x < width1 ; x += squareD + margin)
		{
			for(int y = 0 ; y < height1 ; y += squareD + margin)
			{
				g2.setColor(new Color(a, b, c)) ;
				if(a < 255)
					a++ ;
				else if(b < 255)
					b++ ;
				else if(c < 255)
					c++ ;
				g2.drawLine(x, y, width1-x, height1-y) ;
				
			}
		}
		g2.fillRect(0, 0, 800, 800) ;
		g2.drawImage(landscape, 0, 0, null) ;
		if(Math.abs(girl.getX()-boy.getX())+Math.abs(girl.getY()-boy.getY()) < 10)
		{
			itemPickedUp = true ;
		}
		g2.drawImage(girl.getImage(), girl.getX(), girl.getY(), null) ;
		g2.drawImage(boy.getImage(), boy.getX(), boy.getY(), null) ;
//		for(int x = 0 ; x < width1 ; x += squareD + margin)
//		{
//			for(int y = 0 ; y < height1 ; y += squareD + margin)
//			{
//				g2.setColor(new Color(a, b, c)) ;
//				g2.fillRect(x,  y, squareD, squareD) ;
//				if(a < 255)
//					a++ ;
//				else if(b < 255)
//					b++ ;
//				else if(c < 255)
//					c++ ;
//				
//			}
//		}
		g.drawImage(image,  0, 0, null) ;
	}
	public void keyPressed(KeyEvent arg0)
	{
		int key = arg0.getKeyCode() ;
		if(key == KeyEvent.VK_UP){
			girl.moveUp() ;
		}
		if(key == KeyEvent.VK_DOWN){
			girl.moveDown() ;
		}
		if(key == KeyEvent.VK_RIGHT){
			girl.moveRight() ;
		}
		if(key == KeyEvent.VK_LEFT){
			girl.moveLeft() ;
		}
		repaint() ;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
