package Graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Hero
{
	BufferedImage sprite ;
	String name ;
	int x ;
	int y ;
	public Hero(String name, String imageLocation, int locationX, int locationY)
	{
		this.name = name ;
		int width = 400 ;
		int height = 200 ;
		x = locationX ;
		y = locationY ;
		sprite = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB) ;
		URL url = getClass().getResource(imageLocation) ;
		try {
			BufferedImage original = ImageIO.read(url) ;
			Graphics2D g = (Graphics2D) sprite.getGraphics() ;
			int w = original.getWidth() ;
			int h = original.getHeight() ;
			//what to draw, where to start (x,y), width and height of canvas (w,h)
			//where to start fro, original (x,y)
			//width of original, height (w,h)
			//null
			g.drawImage(original, 0, 0, width, height, 0, 0, w, h, null) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BufferedImage getImage()
	{
		return sprite ;
	}
	
	public String getName()
	{
		return name ;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void moveUp() {
		// TODO Auto-generated method stub
		y-- ;
	}

	public void moveDown() {
		// TODO Auto-generated method stub
		y++ ;
	}

	public void moveRight() {
		// TODO Auto-generated method stub
		x++ ;
	}

	public void moveLeft() {
		// TODO Auto-generated method stub
		x-- ;
	}
}
