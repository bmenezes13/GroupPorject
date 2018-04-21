package application;

	/*
	 * To change this license header, choose License Headers in Project Properties.
	 * To change this template file, choose Tools | Templates
	 * and open the template in the editor.
	 */
	import java.util.Comparator;
	/**
	 *
	 * @author user
	 */
	public class ComparatorByPartName implements Comparator<BikePart>{
	    public int compare(BikePart bp1, BikePart bp2){
	        return bp1.getPartName().compareToIgnoreCase(bp2.getPartName());}
	}


