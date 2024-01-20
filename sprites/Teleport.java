import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Teleport implements DisplayableSprite {

	private static Image image;
	private boolean visible = false;//this is to hide the teleport hitboxes
	private double centerX = 0;
	private double centerY = 0;
	private double width = 25;
	private double height = 75;
	private boolean dispose = false;	
	
public Teleport(double centerX, double centerY) {
		
		if (image == null && visible) {
			try {
				image = ImageIO.read(new File("res/Sprites/GrassBlock.jpg"));
				System.out.println(this.getClass().toString());
			}
			catch (IOException e) {
				e.printStackTrace();
			}		
		}
		
		this.centerX = centerX;
		this.centerY = centerY;
	}
	


	public Image getImage() {
		return image;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	//DISPLAYABLE
	
	public boolean getVisible() {
		return this.visible;
	}
	
	public double getMinX() {
		return centerX - (width / 2);
	}

	public double getMaxX() {
		return centerX + (width / 2);
	}

	public double getMinY() {
		return centerY - (height / 2);
	}

	public double getMaxY() {
		return centerY + (height / 2);
	}

	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}

	public double getCenterX() {
		return centerX;
	};

	public double getCenterY() {
		return centerY;
	};
	
	
	public boolean getDispose() {
		return dispose;
	}

	public void setDispose(boolean dispose) {
		this.dispose = dispose;
	}

	public void update(Universe universe, KeyboardInput keyboard, long actual_delta_time) {
			
	}

	public void setXCenter(double xCenter) {
		// TODO Auto-generated method stub
		this.centerX = xCenter;
	}
}
