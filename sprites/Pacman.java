import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Pacman implements DisplayableSprite {

	private static Image image;	
	private double centerX = 0;
	private double centerY = 0;
	private double width = 50;
	private double height = 55;
	private boolean dispose = false;	

	private final double VELOCITY = 200;

	public Pacman(double centerX, double centerY, double height, double width) {
		this(centerX, centerY);
		
		this.height = height;
		this.width = width;
	}

	
	public Pacman(double centerX, double centerY) {

		this.centerX = centerX;
		this.centerY = centerY;
		
		if (image == null) {
			try { 
				image = ImageIO.read(new File("res/Pacman.png"));
			}
			catch (IOException e) {
				System.out.println(e.toString());
			}		
		}		
	}

	public Image getImage() {
		return image;
	}
	
	//DISPLAYABLE
	
	public boolean getVisible() {
		return true;
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

	public void update(Universe universe, KeyboardInput keyboard, long actual_delta_time) {
		
		double velocityX = 0;
		double velocityY = 0;
		
		
		//LEFT	
		if (keyboard.keyReleased(37)) {
			velocityX = -VELOCITY;
		}
		//UP
		else if (keyboard.keyDown(38)) {
			velocityY = -VELOCITY;			
		}
		// RIGHT
		else if (keyboard.keyDown(39)) {
			velocityX += VELOCITY;
		}
		// DOWN
		else if (keyboard.keyDown(40)) {
			velocityY += VELOCITY;			
		}

		double deltaX = actual_delta_time * 0.001 * velocityX;
        this.centerX += deltaX;
		
		double deltaY = actual_delta_time * 0.001 * velocityY;
    	this.centerY += deltaY;

	}


	@Override
	public void setDispose(boolean dispose) {
		this.dispose = true;
	}


//	@Override
//	public void keyTyped(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	@Override
//    public void keyPressed(KeyEvent e) {
//        int key = e.getKeyCode();
//        
//        double velocityX = 0;
//        double velocityY = 0;
//        
//        if (key == KeyEvent.VK_LEFT) {
//        	velocityX = -VELOCITY;
//            
//        } else if (key == KeyEvent.VK_RIGHT) {
//        	velocityX += VELOCITY;
//        } else if (key == KeyEvent.VK_UP) {
//        	velocityY = -VELOCITY;
//        } else if (key == KeyEvent.VK_DOWN) {
//        	velocityY += VELOCITY;
//        }
//    }
//
//
//	@Override
//	public void keyReleased(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}

}
