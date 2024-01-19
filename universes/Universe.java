import java.awt.Frame;
import java.util.ArrayList;

public interface Universe {

	//STATIC VARIABLES
	
	//INSTANCE VARIABLES

	public double getScale();


	public double getXCenter();
	public double getYCenter();
	
	public void setXCenter(double xCenter);
	public void setYCenter(double yCenter);
	
	public boolean isInEndZone();
	public boolean isComplete();
	public void setComplete(boolean complete);
	public void exitEndZone();
	
	public DisplayableSprite getPlayer1();
	public boolean centerOnPlayer();

	public ArrayList<DisplayableSprite> getSprites();	
	public ArrayList<Background> getBackgrounds();		

	public void update(KeyboardInput keyboard, long actual_delta_time);


	public int getAttempts();


	public boolean levelCompleted();


    
	
}
