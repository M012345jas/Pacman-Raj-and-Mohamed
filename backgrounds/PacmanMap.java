import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class PacmanMap implements Background{
	
	private static final int BASE = 50;
	private static final int HEIGHT = 50;
	
	//Images
	private Image blocks; // Barrier Blocks
	
	private int maxRows = 0;
	private int maxCols = 0;

	private int map[][] = new int[][] {
		{0,0,0,1,0,0,0,0,0,1,1,1,1,1,1},
		{0,0,0,1,0,0,0,0,0,1,1,1,1,1,1},
		{0,0,0,1,0,0,0,0,0,1,1,1,1,1,1},
		{0,0,0,1,0,0,0,0,0,1,1,1,1,1,1},
		{0,0,0,1,0,0,0,0,0,1,1,1,1,1,1},
		{0,0,0,1,0,0,0,0,0,1,1,1,1,1,1},
		{0,0,0,1,0,0,0,0,0,1,1,1,1,1,1},
		{0,0,0,1,0,0,0,0,0,1,1,1,1,1,1},
		{0,0,0,1,0,0,0,0,0,1,1,1,1,1,1},
		{0,0,0,1,0,0,0,0,0,1,1,1,1,1,1},
		{0,0,0,1,0,0,0,0,0,1,1,1,1,1,1},
		{0,0,0,1,0,0,0,0,0,1,1,1,1,1,1},
		{0,0,0,1,0,0,0,0,0,1,1,1,1,1,1},
		{0,0,0,1,0,0,0,0,0,1,1,1,1,1,1},
		{0,0,0,1,0,0,0,0,0,1,1,1,1,1,1},
		{0,0,0,1,0,0,0,0,0,1,1,1,1,1,1},
		{0,0,0,1,0,0,0,0,0,1,1,1,1,1,1},
		{0,0,0,1,0,0,0,0,0,1,1,1,1,1,1},
		{0,0,0,1,0,0,0,0,0,1,1,1,1,1,1},
		{0,0,0,1,0,0,0,0,0,1,1,1,1,1,1},
		{0,0,0,1,0,0,0,0,0,1,1,1,1,1,1},
	};
	
	public PacmanMap() {
		// TODO Auto-generated constructor stub
		try {
			this.blocks = ImageIO.read(new File("res/Game%20Object%20(Arrays)/Pacman%20Barrier.png"));// Pacman BARRIER
			
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		maxRows = map.length - 1;
    	maxCols = map[0].length - 1;
	}

	@Override
	//Tile Identification
		public Tile getTile(int col  /*x*/, int row  /*y*/) {
			

			Image image = null;
			if (row < 0 || row > maxRows || col < 0 || col > maxCols) {
				image = null;
			}
			
			else if (map[row][col] == 1) {
				image = blocks;
			}
			else {
				image = null;
			}//resolution kinda
			int x = (col * BASE);
			int y = (row * HEIGHT);
					
			Tile newTile = new Tile(image, x, y, BASE, HEIGHT, false);
					
			return newTile;
		}
	
	public ArrayList<DisplayableSprite> getBarriers(){
		ArrayList<DisplayableSprite> barriers = new ArrayList<DisplayableSprite>();
		for (int col = 0; col < map[0].length; col++) {
			for (int row = 0; row < map.length; row++) {
				if((map[row][col] == 1)) {
					barriers.add(new BarrierSprite(col * BASE, row * HEIGHT, (col + 1) * BASE, (row + 1) * HEIGHT, false));
				}
			}
		}
		return barriers;
	}

	@Override
	public int getCol(double x) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRow(double y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getShiftX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getShiftY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setShiftX(double shiftX) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setShiftY(double shiftY) {
		// TODO Auto-generated method stub
		
	}

}
