import java.util.*;
import java.util.Random;
public class RunRamblersBB {
	public static void main(String[] arg) {
	TerrainMap tm = new TerrainMap("src/tmc.pgm");
	Random random = new Random();
	
	int startX=random.nextInt(tm.getWidth());
	int startY=random.nextInt(tm.getDepth());
	int goalX=random.nextInt(tm.getWidth());
	int goalY=random.nextInt(tm.getDepth());
	
	Coords start=new Coords(startY, startX);
	Coords goal=new Coords(goalY, goalX);
	
	
	RamblersSearch searcher = new RamblersSearch(tm,goal); 
    SearchState initState = (SearchState) new RamblersState(start,0);
    String res_astar = searcher.runSearch(initState, "AStar");
    
    System.out.println(res_astar);
    System.out.println( "Start:("+startY+", "+startX+") and the Goal:("+goalY+". "+goalX+")");
    
}}
