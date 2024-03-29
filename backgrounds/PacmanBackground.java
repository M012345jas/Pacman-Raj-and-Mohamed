import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PacmanBackground implements Background {

    private Image GDbackground;
    private int backgroundWidth = 0;
    private int backgroundHeight = 0;
    private int offsetX = 0;
    private double shiftX = 0;
    private double shiftY = 3550; // Background shifted down

    public PacmanBackground() {
    	try {

    		this.GDbackground = ImageIO.read(new File("res/pacmanSprites/Greenbackground.png"));// we need a new image
    		backgroundWidth = (int) (GDbackground.getWidth(null) * 6);
    		backgroundHeight = (int) (GDbackground.getWidth(null)* 8);
    		
//    		backgroundWidth = GDbackground.getWidth(null);
//    		backgroundHeight = GDbackground.getHeight(null);
    		
    		offsetX = backgroundWidth / 2;
    	}
    	catch (IOException e) {
    		System.out.println(e.toString());
    	}
    }
	
    public Tile getTile(int col, int row) {
		//row is an index of tiles, with 0 being the at the origin
		//col is an index of tiles, with 0 being the at the origin
		int x = (col * backgroundWidth) - offsetX;
		int y = (row * backgroundHeight);
		Tile newTile = null;
		
		if (row == -1 ) {
			newTile = new Tile(GDbackground, x, y, backgroundWidth, backgroundHeight, false);
		} else {
			newTile = new Tile(null, x, y, backgroundWidth, backgroundHeight, false);
		}
			
		
		
		return newTile;
	}
	

	
	public int getCol(double x) {
		int col = (int) ((x - offsetX)  / backgroundWidth);
//		int col = (int) (x / backgroundWidth);
		if (x < 0) {
			return col - 1;
		}
		else {
			return col;
		}
	}

	public int getRow(double y) {
		//which row is y sitting at?
		int row = 0;

		row = (int) (y / backgroundHeight);
		if (y < 0) {
			return row - 1;
		}
		else {
			return row;
		}
	}
	
//	public int getCol(double x) {
//		//which col is x sitting at?
//		int col = 0;
//		if (backgroundWidth != 0) {
//			col = (int) (x / backgroundWidth);
//			if (x < 0) {
//				return col - 1;
//			}
//			else {
//				return col;
//			}
//		}
//		else {
//			return 0;
//		}
//	}

//	public int getRow(double y) {
//		//which row is y sitting at?
//		int row = 0;
//		
//		if (backgroundHeight != 0) {
//			row = (int) (y / backgroundHeight);
//			if (y < 0) {
//				return row - 1;
//			}
//			else {
//				return row;
//			}
//		}
//		else {
//			return 0;
//		}
//	}
	
	@Override
	public double getShiftX() {
		return shiftX;
	}

	@Override
	public double getShiftY() {
		return shiftY;
	}

	@Override
	public void setShiftX(double shiftX) {
		//ignore
		this.shiftX = shiftX;
	}

	@Override
	public void setShiftY(double shiftY) {
		//ignore
		this.shiftY = shiftY;
	}

}
