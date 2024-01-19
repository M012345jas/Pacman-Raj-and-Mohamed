
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HitBox implements DisplayableSprite {

	private static Image image;
	private boolean visible = true;
	private double centerX = 0;
	private double centerY = 0;
	private double width = 23;
	private double height = 30;
	private boolean dispose = false;	
	
	public HitBox(double minX, double minY, double maxX, double maxY, boolean visible) {
		
		if (image == null && visible) {
			try {
				image = ImageIO.read(new File("res/Sprites/Hitboxes.png"));
			}
			catch (IOException e) {
				e.printStackTrace();
			}		
		}
		
		this.centerX = (minX + maxX) / 2;
		this.centerY = (minY + maxY) / 2;
		this.width = maxX - minX;
		this.height = maxY - minY;
		this.visible = visible;
		
	}
	

	public HitBox(double centerX, double centerY) {
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
		return false;
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