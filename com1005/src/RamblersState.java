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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	boolean goalPredicate(Search searcher) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	ArrayList<SearchState> getSuccessors(Search searcher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	boolean sameState(SearchState n2) {
		// TODO Auto-generated method stub
		return false;
	}

}
