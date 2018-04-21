	package application;
	
	import java.util.ArrayList;
	
	/**
	 *
	 * @author user
	 */
	public class Warehouse {
	    private String whName;
	    private ArrayList<BikePart> wareH;
	    
	    public Warehouse(String name, ArrayList<BikePart> partList){
	        this.whName = name;
	        this.wareH = partList;
	    }
	    public String getName(){
	        return this.whName;
	    }
	    public ArrayList<BikePart> getWare(){
	        return this.wareH;
	    }
	}

