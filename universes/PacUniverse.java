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
		sprites.add(new SmallCoins(2150,565));
		sprites.add(new SmallCoins(2150,490));
		sprites.add(new SmallCoins(2150,415));
		sprites.add(new SmallCoins(2150,340));
		sprites.add(new SmallCoins(2150,265));
		sprites.add(new SmallCoins(2150,190));
		
		sprites.add(new SmallCoins(2280,410));
		sprites.add(new SmallCoins(2400,210));
		sprites.add(new SmallCoins(2400,310));
		sprites.add(new SmallCoins(2400,410));
		sprites.add(new SmallCoins(2400,510));
		sprites.add(new SmallCoins(2400,610));
		sprites.add(new SmallCoins(2400,660));
		sprites.add(new SmallCoins(2300,660));
		sprites.add(new SmallCoins(2200,660));
		sprites.add(new SmallCoins(2100,660));
		sprites.add(new SmallCoins(2000,660));
		sprites.add(new SmallCoins(1900,660));
		sprites.add(new SmallCoins(1800,660));
		sprites.add(new SmallCoins(1700,660));
		sprites.add(new SmallCoins(2000,560));
		sprites.add(new SmallCoins(2000,460));
		sprites.add(new SmallCoins(2000,360));
		sprites.add(new SmallCoins(2000,260));
		sprites.add(new SmallCoins(1900,360));
		sprites.add(new SmallCoins(1900,260));
		sprites.add(new SmallCoins(1900,460));
		sprites.add(new SmallCoins(1900,560));
		
		sprites.add(new SmallCoins(1750,360));
		sprites.add(new SmallCoins(1750,460));
		sprites.add(new SmallCoins(1650,460));
		sprites.add(new SmallCoins(1550,460));
		sprites.add(new SmallCoins(1475,460));
		sprites.add(new SmallCoins(1390,460));
		sprites.add(new SmallCoins(1390,360));
		sprites.add(new SmallCoins(1260,360));
		sprites.add(new SmallCoins(1260,260));
		sprites.add(new SmallCoins(1260,460));
		sprites.add(new SmallCoins(1260,560));
		sprites.add(new SmallCoins(1170,360));
		sprites.add(new SmallCoins(1170,260));
		sprites.add(new SmallCoins(1170,460));
		sprites.add(new SmallCoins(1170,560));
		sprites.add(new SmallCoins(1170,660));
		sprites.add(new SmallCoins(1270,660));
		sprites.add(new SmallCoins(1370,660));
		sprites.add(new SmallCoins(1470,660));
		sprites.add(new SmallCoins(1070,660));
		sprites.add(new SmallCoins(885,660));
		sprites.add(new SmallCoins(770,660));
		sprites.add(new SmallCoins(770,560));
		sprites.add(new SmallCoins(770,460));
		sprites.add(new SmallCoins(770,360));
		sprites.add(new SmallCoins(770,260));
		sprites.add(new SmallCoins(985,660));
		sprites.add(new SmallCoins(985,560));
		sprites.add(new SmallCoins(985,460));
		sprites.add(new SmallCoins(985,360));
		sprites.add(new SmallCoins(985,260));
		sprites.add(new SmallCoins(875,410));
		sprites.add(new SmallCoins(770,460));
		
		sprites.add(new SmallCoins(630,560));
		sprites.add(new SmallCoins(630,660));
		sprites.add(new SmallCoins(630,760));
		sprites.add(new SmallCoins(630,860));
		sprites.add(new SmallCoins(630,960));
		sprites.add(new SmallCoins(545,960));
		sprites.add(new SmallCoins(450,960));
		sprites.add(new SmallCoins(450,860));
		sprites.add(new SmallCoins(450,760));
		sprites.add(new SmallCoins(450,660));
		sprites.add(new SmallCoins(350,960));
		
		sprites.add(new SmallCoins(350,1060));
		sprites.add(new SmallCoins(350,1160));
		sprites.add(new SmallCoins(450,1160));
		sprites.add(new SmallCoins(550,1160));
		sprites.add(new SmallCoins(650,1160));
		sprites.add(new SmallCoins(550,1260));
		sprites.add(new SmallCoins(550,1360));
		sprites.add(new SmallCoins(550,1460));
		sprites.add(new SmallCoins(450,1460));
		sprites.add(new SmallCoins(350,1460));
		sprites.add(new SmallCoins(350,1580));
		sprites.add(new SmallCoins(450,1580));
		sprites.add(new SmallCoins(450,1680));
		sprites.add(new SmallCoins(550,1580));
		sprites.add(new SmallCoins(550,1680));
		sprites.add(new SmallCoins(740,1160));
		sprites.add(new SmallCoins(740,1260));
		sprites.add(new SmallCoins(740,1360));
		sprites.add(new SmallCoins(740,1460));
		sprites.add(new SmallCoins(740,1560));
		sprites.add(new SmallCoins(740,1660));
		sprites.add(new SmallCoins(740,1760));
		sprites.add(new SmallCoins(740,1860));
		sprites.add(new SmallCoins(640,1860));
		sprites.add(new SmallCoins(540,1860));
		sprites.add(new SmallCoins(440,1860));
		sprites.add(new SmallCoins(340,1860));
		sprites.add(new SmallCoins(340,1960));
		sprites.add(new SmallCoins(340,2060));
		sprites.add(new SmallCoins(340,2160));
		sprites.add(new SmallCoins(740,1980));
		sprites.add(new SmallCoins(640,1980));
		sprites.add(new SmallCoins(540,1980));
		sprites.add(new SmallCoins(540,2080));
		sprites.add(new SmallCoins(540,2160));
		sprites.add(new SmallCoins(440,2160));
		
		sprites.add(new SmallCoins(440,2260));
		sprites.add(new SmallCoins(440,2360));
		sprites.add(new SmallCoins(440,2460));
		sprites.add(new SmallCoins(440,2560));
		sprites.add(new SmallCoins(340,2560));
		sprites.add(new SmallCoins(240,2560));
		sprites.add(new SmallCoins(300,2660));
		sprites.add(new SmallCoins(300,2760));
		sprites.add(new SmallCoins(400,2760));
		sprites.add(new SmallCoins(500,2760));
		sprites.add(new SmallCoins(600,2760));
		sprites.add(new SmallCoins(580,2860));
		
		sprites.add(new SmallCoins(640,2160));
		sprites.add(new SmallCoins(640,2260));
		sprites.add(new SmallCoins(640,2360));
		sprites.add(new SmallCoins(640,2460));
		sprites.add(new SmallCoins(640,2560));
		sprites.add(new SmallCoins(740,2560));
		sprites.add(new SmallCoins(740,2660));
		sprites.add(new SmallCoins(1020,2660));
		sprites.add(new SmallCoins(1020,2560));
		sprites.add(new SmallCoins(1020,2460));
		sprites.add(new SmallCoins(920,2460));
		sprites.add(new SmallCoins(820,2460));
		sprites.add(new SmallCoins(820,2360));
		sprites.add(new SmallCoins(920,2360));
		sprites.add(new SmallCoins(1020,2760));
		sprites.add(new SmallCoins(1020,2860));
		sprites.add(new SmallCoins(870,2700));
		sprites.add(new SmallCoins(740,2760));
		sprites.add(new SmallCoins(740,2860));
		
		sprites.add(new SmallCoins(1120,2460));
		sprites.add(new SmallCoins(1220,2460));
		sprites.add(new SmallCoins(1320,2460));
		sprites.add(new SmallCoins(1420,2460));
		sprites.add(new SmallCoins(1520,2460));
		sprites.add(new SmallCoins(1520,2410));
		sprites.add(new SmallCoins(1420,2410));
		sprites.add(new SmallCoins(1320,2410));
		sprites.add(new SmallCoins(1220,2410));
		sprites.add(new SmallCoins(1120,2410));
		sprites.add(new SmallCoins(1120,2310));
		
		sprites.add(new SmallCoins(1220,2560));
		sprites.add(new SmallCoins(1220,2630));
		sprites.add(new SmallCoins(1220,2730));
		sprites.add(new SmallCoins(1220,2830));
		sprites.add(new SmallCoins(1320,2800));
		sprites.add(new SmallCoins(1400,2800));
		sprites.add(new SmallCoins(1400,2700));
		sprites.add(new SmallCoins(1400,2600));
		sprites.add(new SmallCoins(1480,2600));
		sprites.add(new SmallCoins(1580,2600));
		sprites.add(new SmallCoins(1660,2600));
		sprites.add(new SmallCoins(1750,2600));
		sprites.add(new SmallCoins(1520,2800));
		sprites.add(new SmallCoins(1750,2700));
		sprites.add(new SmallCoins(1750,2800));
		sprites.add(new SmallCoins(1650,2800));
		sprites.add(new SmallCoins(1850,2800));
		sprites.add(new SmallCoins(1920,2830));
		sprites.add(new SmallCoins(1920,2730));
		sprites.add(new SmallCoins(1920,2630));
		sprites.add(new SmallCoins(1920,2560));
		sprites.add(new SmallCoins(1930,2470));
		sprites.add(new SmallCoins(1830,2470));
		sprites.add(new SmallCoins(1730,2470));
		sprites.add(new SmallCoins(2030,2470));
		sprites.add(new SmallCoins(1630,2470));
		sprites.add(new SmallCoins(1630,2410));
		sprites.add(new SmallCoins(1730,2410));
		sprites.add(new SmallCoins(2030,2310));
		sprites.add(new SmallCoins(1830,2410));
		sprites.add(new SmallCoins(1930,2410));
		sprites.add(new SmallCoins(2030,2410));
		
		sprites.add(new SmallCoins(2130,2470));
		sprites.add(new SmallCoins(2230,2470));
		sprites.add(new SmallCoins(2330,2470));
		sprites.add(new SmallCoins(2230,2470));
		sprites.add(new SmallCoins(2330,2370));
		sprites.add(new SmallCoins(2230,2370));
		sprites.add(new SmallCoins(2130,2570));
		sprites.add(new SmallCoins(2130,2670));
		sprites.add(new SmallCoins(2130,2770));
		sprites.add(new SmallCoins(2130,2870));
		sprites.add(new SmallCoins(2280,2690));
		sprites.add(new SmallCoins(2410,2870));
		sprites.add(new SmallCoins(2410,2770));
		sprites.add(new SmallCoins(2410,2670));
		sprites.add(new SmallCoins(2410,2570));
		sprites.add(new SmallCoins(2410,2470));
		sprites.add(new SmallCoins(2510,2570));
		sprites.add(new SmallCoins(2510,2470));
		sprites.add(new SmallCoins(2510,2370));
		sprites.add(new SmallCoins(2510,2270));
		sprites.add(new SmallCoins(2510,2170));
		
		sprites.add(new SmallCoins(2610,2170));
		sprites.add(new SmallCoins(2710,1990));
		sprites.add(new SmallCoins(2410,1790));
		sprites.add(new SmallCoins(2410,1690));
		sprites.add(new SmallCoins(2410,1590));
		sprites.add(new SmallCoins(2410,1490));
		sprites.add(new SmallCoins(2410,1390));
		sprites.add(new SmallCoins(2410,1290));
		sprites.add(new SmallCoins(2410,1190));
		sprites.add(new SmallCoins(2610,1990));
		sprites.add(new SmallCoins(2510,1990));
		sprites.add(new SmallCoins(2410,1990));
		sprites.add(new SmallCoins(2410,1870));
		sprites.add(new SmallCoins(2510,1870));
		sprites.add(new SmallCoins(2610,1870));
		sprites.add(new SmallCoins(2710,1870));
		sprites.add(new SmallCoins(2810,1870));
		sprites.add(new SmallCoins(2710,2090));
		sprites.add(new SmallCoins(2710,2170));
		sprites.add(new SmallCoins(2710,2270));
		sprites.add(new SmallCoins(2710,2370));
		sprites.add(new SmallCoins(2710,2470));
		sprites.add(new SmallCoins(2710,2570));
		sprites.add(new SmallCoins(2810,2170));
		
		sprites.add(new SmallCoins(2830,2570));
		sprites.add(new SmallCoins(2930,2550));
		sprites.add(new SmallCoins(2830,2670));
		sprites.add(new SmallCoins(2830,2770));
		sprites.add(new SmallCoins(2730,2770));
		sprites.add(new SmallCoins(2630,2770));
		sprites.add(new SmallCoins(2530,2770));
		sprites.add(new SmallCoins(2570,2870));
		sprites.add(new SmallCoins(2830,2070));
		sprites.add(new SmallCoins(2830,1970));
		
		sprites.add(new SmallCoins(2530,1190));
		sprites.add(new SmallCoins(2630,1190));
		sprites.add(new SmallCoins(2630,1270));
		sprites.add(new SmallCoins(2630,1370));
		sprites.add(new SmallCoins(2630,1470));
		sprites.add(new SmallCoins(2730,1490));
		sprites.add(new SmallCoins(2830,1490));
		sprites.add(new SmallCoins(2830,1590));
		sprites.add(new SmallCoins(2730,1590));
		sprites.add(new SmallCoins(2630,1590));
		sprites.add(new SmallCoins(2630,1690));
		sprites.add(new SmallCoins(2730,1690));
		sprites.add(new SmallCoins(2730,1190));
		sprites.add(new SmallCoins(2830,1190));
		
		sprites.add(new SmallCoins(2830,1090));
		sprites.add(new SmallCoins(2830,990));
		sprites.add(new SmallCoins(2630,990));
		sprites.add(new SmallCoins(2530,990));
		sprites.add(new SmallCoins(2530,890));
		sprites.add(new SmallCoins(2530,790));
		sprites.add(new SmallCoins(2530,690));
		sprites.add(new SmallCoins(2530,590));
		sprites.add(new SmallCoins(2530,490));
		sprites.add(new SmallCoins(2730,990));
		sprites.add(new SmallCoins(2730,890));
		sprites.add(new SmallCoins(2730,790));
		sprites.add(new SmallCoins(2730,690));
		sprites.add(new SmallCoins(2730,590));
		sprites.add(new SmallCoins(2730,510));
		sprites.add(new SmallCoins(2830,410));
		sprites.add(new SmallCoins(2830,340));
		sprites.add(new SmallCoins(2530,250));
		sprites.add(new SmallCoins(2730,330));
		sprites.add(new SmallCoins(2630,330));
		sprites.add(new SmallCoins(2530,330));
		sprites.add(new SmallCoins(2830,490));
		sprites.add(new SmallCoins(2830,590));
		sprites.add(new SmallCoins(2930,590));
		
		
		
		
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
		
		if (ShellAnimation.getScore() >= 50000) {
			return true;
		}
		else {	
			return false;//ff
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