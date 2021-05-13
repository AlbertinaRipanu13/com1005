																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																						import java.util.ArrayList;

public class RamblersState extends SearchState {

	//point for this state
		private Coords point;
		
		//constructor
		//A* - has estRemCost now
	    public RamblersState(Coords pt, int lc){
	    	point=pt;
		    localCost=lc;
		    //estRemCost=rc;
		}
		
	  //accessors
	    public int getPointx(){
	      return point.getx();
	    }
		
	    public int getPointy() {
	    	return point.gety();
	    }
		
	    
		
		@Override
		boolean goalPredicate(Search searcher) {
			// TODO Auto-generated method stub
			RamblersSearch rsearcher=(RamblersSearch) searcher;
			int x= rsearcher.getGoalX();
			int y= rsearcher.getGoalY();
			if( x==point.getx ()&& y==point.gety() )
				return true;
			return false;
		}

		@Override
		ArrayList<SearchState> getSuccessors(Search searcher) {
			// TODO local cost
			RamblersSearch rsearcher= (RamblersSearch) searcher;
			TerrainMap map=rsearcher.getMap();
			int[][] tmap=map.getTmap();//nu stiu daca e declarat ok
			ArrayList<SearchState> succs = new ArrayList();
			int lc=0;
			int x=point.getx();
			int y=point.gety();
			
			//succesor E
			if(x>=0 && x<map.getWidth()-1){
				if(tmap[y][x]>=tmap[y][x+1])
					lc=1;
				else 
					lc=1+Math.abs(tmap[y][x+1]-tmap[y][x]);
				succs.add(new RamblersState (new Coords(y,x+1),lc));}
			
			//succesor W
		    if(x>0 && x<=map.getWidth()-1) {
		    	if(tmap[y][x]>=tmap[y][x-1])
					lc=1;
				else 
					lc=1+Math.abs(tmap[y][x-1]-tmap[y][x]);
		    	succs.add(new RamblersState(new Coords(y,x-1),lc));}
		    
		    //succesor S
		    if(y>=0 && y<map.getDepth()-1) {
		    	if(tmap[y][x]>=tmap[y+1][x])
					lc=1;
				else 
					lc=1+Math.abs(tmap[y+1][x]-tmap[y][x]);
				succs.add(new RamblersState(new Coords(y+1,x),lc));}
		    
		    //succesor N
			if(y>0 && y<=map.getDepth()-1) {
				if(tmap[y][x]>=tmap[y-1][x])
					lc=1;
				else 
					lc=1+Math.abs(tmap[y-1][x]-tmap[y][x]);
			    succs.add(new RamblersState(new Coords(y-1,x),lc));}
			
			return succs; 
		}

		@Override
		boolean sameState(SearchState n2) {
			// TODO Auto-generated method stub
			RamblersState n=(RamblersState) n2;
			if((n.getPointx()==point.getx())&&(n.getPointy()==getPointy()))
				return true;
			return false;
		}


}
