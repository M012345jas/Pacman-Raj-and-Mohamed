import java.awt.Frame;
import java.util.ArrayList;

public class PacUniverse implements Universe {


	private boolean complete = false;	//flflfl;
	private boolean inEndZone = false;
	private Background background = null;
	private ArrayList<Background> backgrounds = null;
	private DisplayableSprite player1 = null;
	private ArrayList<DisplayableSprite> sprites = new ArrayList<DisplayableSprite>();
	private ArrayList<DisplayableSprite> disposalList = new ArrayList<DisplayableSprite>();
	private double xCenter = 0; //Debatable
	private double yCenter = 0;
	private int attempts = 0;
	
	public PacUniverse() {
		super();
		backgrounds = new ArrayList<Background>();
		background = new PacmanBackground();
		backgrounds.add(background);

		//import map/barriers
		background = new PacmanGameMap();
		ArrayList<DisplayableSprite> barriers = ((PacmanGameMap)background).getBarriers();
		this.sprites.addAll(barriers);
		//this.sprites.addAll( ((GameMap)background).getSpike());

		backgrounds.add(background);
		this.setXCenter(0);
		this.setYCenter(0);

		player1 = new PlayerSprite(1575,1575);  //400, 650  //16000

		sprites.add(player1);
		
		//These sprite hitbox will be used to teleport pacman across the map
		sprites.add(new Teleport(15,975));
		sprites.add(new Teleport(15,2125));
		
		sprites.add(new Teleport(3135,975));
		sprites.add(new Teleport(3135,2125));
		
		sprites.add(new TeleportSideWays(975,15));
		sprites.add(new TeleportSideWays(2175,15));
		
		sprites.add(new TeleportSideWays(975,3085));
		sprites.add(new TeleportSideWays(2175,3085));
		
//		sprites.add(new Endzone(4000,714.5)); //It spawns a this sprite in the universe
//		/*sprites.add(new TreehouseSprite(200, 550));*/ // This tree house just does not really if the theme
//		
//		sprites.add(new Endzone2(12000, 714.5));
//		sprites.add(new Endzone3(19500, 714.5));
//		
		sprites.add(new Endzone4(23750, 714.5));

		
		//Secret coins
		sprites.add(new Coin(300,625));
		sprites.add(new Coin(14800,370));
		sprites.add(new Coin(22787.5, 620));
		
		//Hit boxes
		sprites.add(new HitBox(13075, 435));
		
		//Ghost Sprite
		sprites.add(new GhostSprite(400, 2001));


		
		if (PlayerSprite.checkpointOneCrossed == true) {
			player1 = new PlayerSprite(4000,714.5);
			sprites.add(player1);
		}
		
		if (PlayerSprite.checkpointTwoCrossed == true) {
			player1 = new PlayerSprite(12000, 714.5);
			sprites.add(player1);
		}
		
		if (PlayerSprite.checkpointThreeCrossed == true) {
			player1 = new PlayerSprite(19500, 714.5);
			sprites.add(player1);
		}
		
		
	}

	@Override
	public double getScale() {// Camera zoom usage
		return 0.154;
	}

	@Override
	public double getXCenter() {
		return this.xCenter;
	}

	@Override
	public double getYCenter() {
		return this.yCenter;
	}

	@Override
	public void setXCenter(double xCenter) {
		this.xCenter = xCenter;
	}

	@Override
	public void setYCenter(double yCenter) {
		this.yCenter = yCenter;
	}

	@Override
	public boolean isComplete() {
		return complete;
	}

	@Override
	public void setComplete(boolean complete) {
		//this.complete = complete;
	}
		
	@Override
	public DisplayableSprite getPlayer1() {
		return player1;
	}

	@Override
	public boolean centerOnPlayer() {
		return false ;  //that took so long to find
	}

	@Override
	public ArrayList<DisplayableSprite> getSprites() { 
		return sprites;
	}
	
//	public int getTarget() {
//		return this.target;
//	}
	
	public int getAttempts() {
		return attempts;
	}

	@Override
	public ArrayList<Background> getBackgrounds() {
		return backgrounds;
	}
	// This is important to distinguish the end
	public boolean levelCompleted() {

		boolean returnValue = false;
		// Why is it that when the playerSprite die it shows the winFrame
		for (DisplayableSprite sprite : sprites) {
			if (sprite instanceof PlayerSprite) {
				returnValue = true;
				break;
			}
		}

		return returnValue;
	}

	@Override
	public void update(KeyboardInput keyboard, long actual_delta_time) {
		//Complete means restart
		if (keyboard.keyDownOnce(27)) {
			complete = true;
		}
		
		for (int i = 0; i < sprites.size(); i++) {
			DisplayableSprite sprite = sprites.get(i);
			sprite.update(this, keyboard, actual_delta_time);
    	} 
		updateSprites(keyboard, actual_delta_time);
		disposeSprites();
		
		if (detectInEndZone() ) {
			this.inEndZone = true;
		}
	}
	
	private boolean detectInEndZone() {
		
		if (this.player1.getCenterX() > 23750) {
			return true;
		}
		else {	
			return false;
		}
	}
	
	protected void updateSprites(KeyboardInput keyboard, long actual_delta_time) {

		if (player1.getDispose()==true) {
			complete = true;
			
		}
    	   	
    }

	protected void disposeSprites() {
        
    	//collect a list of sprites to dispose
    	//this is done in a temporary list to avoid a concurrent modification exception
		for (int i = 0; i < sprites.size(); i++) {
			DisplayableSprite sprite = sprites.get(i);
    		if (sprite.getDispose() == true) {
    			disposalList.add(sprite);
    		}
    	}
		
		//go through the list of sprites to dispose
		//note that the sprites are being removed from the original list
		for (int i = 0; i < disposalList.size(); i++) {
			DisplayableSprite sprite = disposalList.get(i);
			sprites.remove(sprite);
    	}
		
		//clear disposal list if necessary
    	if (disposalList.size() > 0) {
    		disposalList.clear();
    	}
    }
	public String toString() {
		return "Pacman";
	}

	
	public boolean isInEndZone() {
		return inEndZone;		
	}
	
	public void exitEndZone() {
		inEndZone = false;
		this.player1.setXCenter( this.player1.getCenterX() - 23350);
	}

	
}