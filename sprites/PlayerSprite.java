import java.awt.Image;
import java.awt.Dialog.ModalityType;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

//Updatef
public class PlayerSprite implements DisplayableSprite {
	
	//Physics movement for the Player Sprite in PLATBOUNCE
	private final double ACCCELERATION_X = 700;// acceleration
	private final double ACCCELERATION_Y = 3000;
	private final double MAX_VELOCITY_X = 350;
	private final double MAX_VELOCITY_Y = 350;
	
	private final double DEACCELERATION_X = 1000;
	private final double DEACCELERATION_Y = 1000;
	
	private final double MINIMUM_X_VELOCITY = 0;
	private final double MINIMUM_Y_VELOCITY = 0;
	
	//private final double INITIAL_JUMP_VELOCITY = 1000;
	
	private CollisionDetection collisionDetection;
	private VirtualSprite virtual = new VirtualSprite();

	private static Image/*[]*/ image; //The square brackets are there if we want to do actual animation	
	public static boolean checkpointOneCrossed = false;
	public static boolean checkpointThreeCrossed = false;
	public static boolean checkpointTwoCrossed = false;
	public static boolean checkpointFourCrossed = false;
	private double centerX = 0;
	private double centerY = 0;
	private double width = 50; // in order to acheive victory in the process of making our game, we must use chatgpt this is a joke
	private double height = 50;
	private boolean dispose = false;	
	private long elapsedTime = 0;
	//add one
	private double velocityX = 0;        	//PIXELS PER SECOND
	private double velocityY = 0;			//PIXELS PER SECOND
	//private int score = 0;  This is a comment just in case we change our minds
	// See here is the thing for our game we don't really need a score; just attempts

	private final double VELOCITY = 200;
	
	//Aesthetics
	private double progress = 10;
	

	public PlayerSprite(double centerX, double centerY, double height, double width) {
		this(centerX, centerY);
		
		this.height = height;
		this.width = width;
	}

	
	public PlayerSprite(double centerX, double centerY) {
		super();
		this.centerX = centerX;
		this.centerY = centerY;
		
		//collision
		collisionDetection = new CollisionDetection();
		
		//change behaviour of bounces, so that only 50% of energy is 'preserved' in horizontal bounce and 0% of energy is preserved in vertical bounce
		//collisionDetection.setBounceFactorX(0.00000001);
		collisionDetection.setBounceFactorX(0.);
		collisionDetection.setBounceFactorY(0); // Unless its zero sprite keeps jumping 
		
		if (image == null) {
			try {
				image = ImageIO.read(new File("res/Sprites/PlayerSprite9.jpg"));
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

	public double getWidth() {//Hello
		return width;
	}

	public double getCenterX() {
		return centerX;
	};

	public double getCenterY() {
		return centerY;
	}
	
	// AKA progess bar
	public double getProgess() {
		return progress;
	}

	public void setProgess(double progress) {
		this.progress = progress;
	}
	
	public boolean getDispose() {
		return dispose;
	}
	
	@Override
	public void setDispose(boolean dispose) {
		this.dispose = dispose;
	}
	
	public void update(Universe universe, KeyboardInput keyboard, long actual_delta_time) {

		this.elapsedTime += actual_delta_time;		
		
		//behaviour is dependant on whether the sprite is on the 'ground' or not. 
//		boolean onGround = isOnGround(universe);
		//checkCollisionWithCheckpoint(universe.getSprites());
		checkCollisionWithCoin(universe.getSprites());
		checkCollisionWithSmallCoin(universe.getSprites());
		checkCollisionWithPortal(universe.getSprites());
		checkCollisionWithPortalSideWays(universe.getSprites());
		//design is to only allow change of x velocity while on ground
//		if (onGround) {
//
//			if (keyboard.keyDown(32)) {
//				this.velocityY -= INITIAL_JUMP_VELOCITY;
//				onGround = false;
//			}
//			
//		
//			
//		}
		
		// UP
		if (keyboard.keyDown(87) || keyboard.keyDown(38)) {
			velocityY -= actual_delta_time * 0.005 * ACCCELERATION_Y;
			if (velocityY < -MAX_VELOCITY_Y) {
				velocityY = -MAX_VELOCITY_Y;
			}
		}
		
		// DOWN
		if (keyboard.keyDown(83) || keyboard.keyDown(40)) {
			velocityY += actual_delta_time * 0.005 * ACCCELERATION_Y;
			if(velocityY > MAX_VELOCITY_Y) {
				velocityY = MAX_VELOCITY_Y;
			}
		}
		
		// RIGHT
		if (keyboard.keyDown(68) || keyboard.keyDown(39)) {
			velocityX += actual_delta_time * 0.005 * ACCCELERATION_X;
			if (velocityX > MAX_VELOCITY_X) {
				velocityX = MAX_VELOCITY_X;
			}
		}
		// LEFT
		 if (keyboard.keyDown(65) || keyboard.keyDown(37)) {
			//ImageRotator.rotate(image, 180);
			velocityX -= actual_delta_time * 0.005 * ACCCELERATION_X;
			if (velocityX < - MAX_VELOCITY_X) {
				velocityX = - MAX_VELOCITY_X;
				
			}
		} 
		
		else {
			if (Math.abs(this.velocityX) > MINIMUM_X_VELOCITY) {
				this.velocityX -= actual_delta_time * 0.001 *  DEACCELERATION_X * Math.signum(this.velocityX);
			}
				
			
			else {
				this.velocityX = 0;
			}
			
			if (Math.abs(this.velocityX) > 0 && Math.abs(this.velocityX) < 20) {
				this.velocityX = 0;
			}
			
			if (Math.abs(this.velocityY) > MINIMUM_Y_VELOCITY) {
				this.velocityY -= actual_delta_time * 0.001 *  DEACCELERATION_Y * Math.signum(this.velocityY);
			}
			
			else {
				this.velocityY = 0;
			}
			
			if (Math.abs(this.velocityY) > 0 && Math.abs(this.velocityY) < 20) {
				this.velocityY = 0;
			}
		}



		//sprite will use 2D bounce calculation; note that this will include all sprites in the universe, not just BarrierSprites
		collisionDetection.calculate2DBounce(virtual, this, universe.getSprites(), velocityX, velocityY, actual_delta_time);
		this.centerX = virtual.getCenterX();
		this.centerY = virtual.getCenterY();
		this.velocityX = virtual.getVelocityX();
		this.velocityY = virtual.getVelocityY();			

//		if (onGround == true) {
//			this.velocityY = 0;
//		} else {
//			this.velocityY = this.velocityY + ACCCELERATION_Y * 0.001 * actual_delta_time;
//		}
//		
		checkDeath(universe);

		// THis piece of code below does not allow movement of the sprite as well as jumping
//		double deltaX = actual_delta_time * 0.001 * velocityX;
//        this.centerX += deltaX;
//		
//		double deltaY = actual_delta_time * 0.001 * velocityY;
//    	this.centerY += deltaY;//hello world
		

	}
	private void checkDeath(Universe universe) {
		
		for (DisplayableSprite sprite : universe.getSprites()) {
			if (sprite instanceof SpikeSprite || sprite instanceof GhostSprite || sprite instanceof HitBox || sprite instanceof HitBoxSideWays) {
				// This does not work; after several attempts ha get it attempts we finally made the spike sprite kill the player
				if (CollisionDetection.overlaps(this.getMinX(), this.getMinY(), this.getMaxX(), this.getMaxY(), sprite.getMinX(),sprite.getMinY(), sprite.getMaxX(), sprite.getMaxY())){
							
					
					
					if (sprite instanceof GhostSprite) {
						this.dispose = true;
						ShellAnimation.setScore(0);

					}
				}
			}
		}
		
		 //This works
//		if (centerY > 2000) {
//			this.dispose = true;
//	
//		}
		
		//ShellAnimation.addScore(0);
		
	}
	
	

//	private boolean isOnGround(Universe universe) {
//		boolean onGround = false;
//		for (DisplayableSprite sprite: universe.getSprites()) {
//			//does the bottom of this sprite touch the top of another sprite?
//			boolean bottomColliding = this.getMaxY() >= (sprite.getMinY()) && this.getMaxY() <= sprite.getMinY();
//			//is this sprite at least partially overlapping another sprite in the x dimension?
//			boolean withinRange = this.getMaxX() > sprite.getMinX() && this.getMinX() < sprite.getMaxX();
//			if (bottomColliding && withinRange) {
//				onGround = true;
//				break;
//			}
//		}
//		return onGround;
//	}
//	
	
	private void checkCollisionWithPortal(ArrayList<DisplayableSprite> sprites) {

		for (DisplayableSprite sprite : sprites) {
			if (sprite instanceof Teleport) {
				if (CollisionDetection.overlaps(this.getMinX(), this.getMinY(), 
						this.getMaxX(), this.getMaxY(), 
						sprite.getMinX(),sprite.getMinY(), 
						sprite.getMaxX(), sprite.getMaxY())) {

					sprite.setDispose(false);
					if (centerX < 15) {
						centerX = 3135;
					}
					
					if (centerX > 3135) {
						centerX = 15;
					}
					break;					
				}
			}
		}

	}
	
	private void checkCollisionWithPortalSideWays(ArrayList<DisplayableSprite> sprites) {

		for (DisplayableSprite sprite : sprites) {
			if (sprite instanceof TeleportSideWays) {
				if (CollisionDetection.overlaps(this.getMinX(), this.getMinY(), 
						this.getMaxX(), this.getMaxY(), 
						sprite.getMinX(),sprite.getMinY(), 
						sprite.getMaxX(), sprite.getMaxY())) {

					sprite.setDispose(false);
					if (centerY < 15) {
						centerY = 3085;
					}
					
					if (centerY > 3085) {
						centerY = 15;
					}
					break;					
				}
			}
		}

	}
	private void checkCollisionWithCoin(ArrayList<DisplayableSprite> sprites) {

		for (DisplayableSprite sprite : sprites) {
			if (sprite instanceof Coin) {
				if (CollisionDetection.overlaps(this.getMinX(), this.getMinY(), 
						this.getMaxX(), this.getMaxY(), 
						sprite.getMinX(),sprite.getMinY(), 
						sprite.getMaxX(), sprite.getMaxY())) {

					sprite.setDispose(true);
					ShellAnimation.addScore(50);
					break;					
				}
			}
		}

	}
	
	public void checkCollisionWithSmallCoin(ArrayList<DisplayableSprite> sprites) {
		
		for (DisplayableSprite sprite : sprites) {
			if(sprite instanceof SmallCoins) {
				if(CollisionDetection.overlaps(this.getMinX(), this.getMinY(), this.getMaxX(), this.getMaxY(), sprite.getMinX(),sprite.getMinY(), sprite.getMaxX(), sprite.getMaxY())){
					sprite.setDispose(true);
					ShellAnimation.addScore(10);
					break;
				}
			}
		}
	}
	
//	private void checkCollisionWithCheckpoint(ArrayList<DisplayableSprite> sprites) {
//		for (DisplayableSprite sprite : sprites) {
//			if (sprite instanceof Endzone  ||  sprite instanceof Endzone2  ||  sprite instanceof Endzone3  ||  sprite instanceof Endzone4) {
//				if (CollisionDetection.overlaps(this.getMinX(), this.getMinY(), 
//						this.getMaxX(), this.getMaxY(), 
//						sprite.getMinX(),sprite.getMinY(), 
//						sprite.getMaxX(), sprite.getMaxY())) {
//					if (sprite instanceof Endzone) {
//						checkpointOneCrossed = true;
//					}
//					if (sprite instanceof Endzone2){
//						checkpointTwoCrossed = true;
//						checkpointOneCrossed = false;
//					}
//					if (sprite instanceof Endzone3) {
//						checkpointThreeCrossed = true;
//						checkpointTwoCrossed = false;
//					}
//					if (sprite instanceof Endzone4) {
//						checkpointFourCrossed = false;
//						checkpointThreeCrossed = false;
//					}
//					break;
//				}
//			}
//		}
//
//	}
	
	public void setXCenter(double xCenter) {
		
		this.centerX = xCenter;
	}
}
