import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Endzone4 implements DisplayableSprite {

	private static Image image;
	private boolean visible = true;
	private double centerX = 0;
	private double centerY = 0;
	private double width = 50;
	private double height = 70;
	private boolean dispose = false;
	private boolean collisionWithPlayer = false;
	
	private CollisionDetection collisionDetection;
	private VirtualSprite virtual = new VirtualSprite();
		
	public Endzone4(double centerX, double centerY) {
		
		if (image == null && visible) {
			try {
				image = ImageIO.read(new File("res/Sprites/checkpoint.png"));
				System.out.println(this.getClass().toString());
			}
			catch (IOException e) {
				e.printStackTrace();
			}		
		}
		
		this.centerX = centerX;
		this.centerY = centerY;
		collisionDetection = new CollisionDetection();
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
		return this.dispose;
	}
	
	public void setDispose(boolean dispose) {
		this.dispose = dispose;
	}

	public void update(Universe universe, KeyboardInput keyboard, long actual_delta_time) {
		//checkDeath(universe);
		
	}
	
//	private void checkDeath(Universe universe) {
//		// TODO Auto-generated method stub
//		for (DisplayableSprite sprite : universe.getSprites()) {
//			if (sprite instanceof playerSprite) {
//				// This does not work; after several attempts ha get it attempts we finally made the spike sprite kill the player
//				if (CollisionDetection.overlaps(this.getMinX(), this.getMinY(), this.getMaxX(), this.getMaxY(), sprite.getMinX(),sprite.getMinY(), sprite.getMaxX(), sprite.getMaxY())){
//					if (sprite instanceof playerSprite) {
//						this.dispose = true;
//					}
//				}
//			}
//		}
//	}


	// This is very important
	public boolean getCollisionWithPlayer(){
		return collisionWithPlayer;
	}
	
	public void setXCenter(double xCenter) {
		// TODO Auto-generated method stub
		this.centerX = xCenter;
	}
	
}
