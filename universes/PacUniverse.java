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

		player1 = new PlayerSprite(1575,1900);  //400, 650  //16000

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
		//sprites.add(new Endzone4(23750, 714.5));

		
		//Coin
		sprites.add(new Coin(125,2975));
		sprites.add(new Coin(125,150));
		sprites.add(new Coin(3025,150));
		sprites.add(new Coin(3025,2975));
		
		//Smaller Coins
		sprites.add(new SmallCoins(225,2965));
		sprites.add(new SmallCoins(325,2965));
		sprites.add(new SmallCoins(425,2965));
		sprites.add(new SmallCoins(525,2965));
		sprites.add(new SmallCoins(625,2965));
		sprites.add(new SmallCoins(725,2965));
		sprites.add(new SmallCoins(825,2965));
		sprites.add(new SmallCoins(925,2965));
		sprites.add(new SmallCoins(1025,2965));
		sprites.add(new SmallCoins(1125,2965));
		sprites.add(new SmallCoins(1225,2965));
		sprites.add(new SmallCoins(1325,2965));
		sprites.add(new SmallCoins(1425,2965));
		sprites.add(new SmallCoins(1525,2965));
		sprites.add(new SmallCoins(1625,2965));
		sprites.add(new SmallCoins(1725,2965));
		sprites.add(new SmallCoins(1825,2965));
		sprites.add(new SmallCoins(1925,2965));
		sprites.add(new SmallCoins(2025,2965));
		sprites.add(new SmallCoins(2125,2965));
		sprites.add(new SmallCoins(2225,2965));
		sprites.add(new SmallCoins(2325,2965));
		sprites.add(new SmallCoins(2425,2965));
		sprites.add(new SmallCoins(2525,2965));
		sprites.add(new SmallCoins(2625,2965));
		sprites.add(new SmallCoins(2725,2965));
		sprites.add(new SmallCoins(2825,2965));
		sprites.add(new SmallCoins(2925,2965));
		
		sprites.add(new SmallCoins(225,125));
		sprites.add(new SmallCoins(325,125));
		sprites.add(new SmallCoins(425,125));
		sprites.add(new SmallCoins(525,125));
		sprites.add(new SmallCoins(625,125));
		sprites.add(new SmallCoins(725,125));
		sprites.add(new SmallCoins(825,125));
		sprites.add(new SmallCoins(925,125));
		sprites.add(new SmallCoins(1025,125));
		sprites.add(new SmallCoins(1125,125));
		sprites.add(new SmallCoins(1225,125));
		sprites.add(new SmallCoins(1325,125));
		sprites.add(new SmallCoins(1425,125));
		sprites.add(new SmallCoins(1525,125));
		sprites.add(new SmallCoins(1625,125));
		sprites.add(new SmallCoins(1725,125));
		sprites.add(new SmallCoins(1825,125));
		sprites.add(new SmallCoins(1925,125));
		sprites.add(new SmallCoins(2025,125));
		sprites.add(new SmallCoins(2125,125));
		sprites.add(new SmallCoins(2225,125));
		sprites.add(new SmallCoins(2325,125));
		sprites.add(new SmallCoins(2425,125));
		sprites.add(new SmallCoins(2525,125));
		sprites.add(new SmallCoins(2625,125));
		sprites.add(new SmallCoins(2725,125));
		sprites.add(new SmallCoins(2825,125));
		sprites.add(new SmallCoins(2925,125));

		sprites.add(new SmallCoins(3025,225));
		sprites.add(new SmallCoins(3025,325));
		sprites.add(new SmallCoins(3025,425));
		sprites.add(new SmallCoins(3025,525));
		sprites.add(new SmallCoins(3025,625));
		sprites.add(new SmallCoins(3025,725));
		sprites.add(new SmallCoins(3025,825));
		sprites.add(new SmallCoins(3025,925));
		sprites.add(new SmallCoins(3025,1025));
		sprites.add(new SmallCoins(3025,1125));
		sprites.add(new SmallCoins(3025,1225));
		sprites.add(new SmallCoins(3025,1325));
		sprites.add(new SmallCoins(3025,1425));
	//	sprites.add(new SmallCoins(3025,1525));
		sprites.add(new SmallCoins(3025,1625));
		sprites.add(new SmallCoins(3025,1725));
		sprites.add(new SmallCoins(3025,1825));
		sprites.add(new SmallCoins(3025,1925));
		sprites.add(new SmallCoins(3025,2025));
		sprites.add(new SmallCoins(3025,2125));
		sprites.add(new SmallCoins(3025,2225));
		sprites.add(new SmallCoins(3025,2325));
		sprites.add(new SmallCoins(3025,2425));
		sprites.add(new SmallCoins(3025,2525));
		sprites.add(new SmallCoins(3025,2625));
		sprites.add(new SmallCoins(3025,2725));
		sprites.add(new SmallCoins(3025,2825));

		sprites.add(new SmallCoins(125,225));
		sprites.add(new SmallCoins(125,325));
		sprites.add(new SmallCoins(125,425));
		sprites.add(new SmallCoins(125,525));
		sprites.add(new SmallCoins(125,625));
		sprites.add(new SmallCoins(125,725));
		sprites.add(new SmallCoins(125,825));
		sprites.add(new SmallCoins(125,925));
		sprites.add(new SmallCoins(125,1025));
		sprites.add(new SmallCoins(125,1125));
		sprites.add(new SmallCoins(125,1225));
		sprites.add(new SmallCoins(125,1325));
		sprites.add(new SmallCoins(125,1425));
	//	sprites.add(new SmallCoins(125));
		sprites.add(new SmallCoins(125,1625));
		sprites.add(new SmallCoins(125,1725));
		sprites.add(new SmallCoins(125,1825));
		sprites.add(new SmallCoins(125,1925));
		sprites.add(new SmallCoins(125,2025));
		sprites.add(new SmallCoins(125,2125));
		sprites.add(new SmallCoins(125,2225));
		sprites.add(new SmallCoins(125,2325));
		sprites.add(new SmallCoins(125,2425));
		sprites.add(new SmallCoins(125,2525));
		sprites.add(new SmallCoins(125,2625));
		sprites.add(new SmallCoins(125,2725));
		sprites.add(new SmallCoins(125,2825));
		
		sprites.add(new SmallCoins(300,325));
		sprites.add(new SmallCoins(400,325));
		sprites.add(new SmallCoins(500,325));
		sprites.add(new SmallCoins(600,325));
		sprites.add(new SmallCoins(600,245));
		sprites.add(new SmallCoins(300,405));
		sprites.add(new SmallCoins(300,485));
		sprites.add(new SmallCoins(400,485));
		sprites.add(new SmallCoins(450,585));
		sprites.add(new SmallCoins(300,565));
		sprites.add(new SmallCoins(225,565));
//		
//		//Hit boxes
//		sprites.add(new HitBox(13075, 435));
//		
		//Ghost Sprite
		sprites.add(new GhostSprite(1575, 1675));


		
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
		
		if (ShellAnimation.getScore() >= 13900) {
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