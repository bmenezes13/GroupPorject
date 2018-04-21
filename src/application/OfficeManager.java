package application;

import java.util.ArrayList;

public class OfficeManager extends Account{
	public OfficeManager(String first, String last, String addy, String user, String pass) {
		super(first, last, addy, user, pass);
	}
	
		public BikePart getPart(String pname, ArrayList<BikePart> list){
		for(BikePart bp: list) {
			if(pname.equals(bp.getPartName())||pname.equals(bp.getPartNum())) {
				return bp;
			}
		}
		return null;
	}
	public void orderParts(int minimum, ArrayList<BikePart> list) {
		
		int add;
			for(BikePart bp: list){
				if(minimum > bp.getPartQuant()){
					add = minimum-bp.getPartQuant();
					bp.addPartQuant(add);
				}
			}
		}
		
	
	public ArrayList<Invoice> getInvoicesBetweenDates(String person, int startMonth, int startDay, int startYear, int endMonth, int endDay, int endYear, ArrayList<Invoice> list){
		ArrayList<Invoice> invoices = new ArrayList<>();
		for(Invoice i: list) {
			if(person.equalsIgnoreCase(i.getEmployee())) {
				invoices.add(i);
			}
		}
		for(Invoice i: list) {
			if(person.equalsIgnoreCase(i.getCustomer())) {
				invoices.add(i);
			}
		}
		if(startYear == endYear) {
			for(Invoice i: list) {
				if(i.getYear() != startYear) {
					list.remove(i);
				}
			}	
		}
		else {
			for(Invoice i: list) {
				if(i.getYear() > endYear || i.getYear() < startYear) {
					list.remove(i);
				}
			}
		}
		if(startMonth == endMonth) {
			for(Invoice i: list) {
				if(i.getMonth() != startMonth) {
					list.remove(i);
				}
			}
		}
		else {
			for(Invoice i: list) {
				if(i.getMonth() > endMonth || i.getMonth() < startMonth) {
					list.remove(i);
				}
			}
		}
		if(startDay == endDay) {
			for(Invoice i: list) {
				if(i.getDay() != startDay) {
					list.remove(i);
				}
			}
		}
		else {
			for(Invoice i: list) {
				if(i.getDay() > endDay || i.getDay() < startDay) {
					list.remove(i);
				}
			}
		}
		return invoices;
	}
	public double generatePaycheck(String salesAssociate, int startMonth, int startDay, int startYear, int endMonth, int endDay, int endYear, ArrayList<Invoice> slist) {
		double amount = 0;
		ArrayList<Invoice> invoices = getInvoicesBetweenDates(salesAssociate, startMonth, startDay, startYear, endMonth, endDay, endYear, slist);
		for(Invoice temp: invoices) {
			amount += temp.getTotalCost();
		}
		return amount * 0.15;
	}
}

