import java.util.ArrayList;

public class OfficeManager {
	ArrayList<BikePart> temporary = new ArrayList<>(); //temporary replacement for allWarehouse.
	ArrayList<Invoice> temporaryInvoices = new ArrayList<>(); //temporary invoices.
	
	public BikePart getPart(int pnum){
		for(BikePart bp: temporary) {
			if(pnum == bp.getPartNumber()) {
				return bp;
			}
		}
		return null;
	}
	public BikePart getPart(String pname){
		for(BikePart bp: temporary) {
			if(pname.equals(bp.getPartName())) {
				return bp;
			}
		}
		return null;
	}
	public void orderParts(int minimum) {
		/*
		int add;
		for(Warehouse wh: <ArrayListWarehouses>){
			for(BikePart bp: warehouse.getWare()){
				if(minimum > bp.getPartQuant()){
					add = minimum-bp.getPartQuant();
					bp.addPartQuant(add);
				}
			}
		}
		*/
	}
	public ArrayList<Invoice> getInvoicesBetweenDates(String person, int startMonth, int startDay, int startYear, int endMonth, int endDay, int endYear){
		ArrayList<Invoice> invoices = new ArrayList<>();
		for(Invoice i: temporaryInvoices) {
			if(person.equalsIgnoreCase(i.getEmployee())) {
				invoices.add(i);
			}
		}
		for(Invoice i: temporaryInvoices) {
			if(person.equalsIgnoreCase(i.getCustomer())) {
				invoices.add(i);
			}
		}
		if(startYear == endYear) {
			for(Invoice i: temporaryInvoices) {
				if(i.getYear() != startYear) {
					temporaryInvoices.remove(i);
				}
			}	
		}
		else {
			for(Invoice i: temporaryInvoices) {
				if(i.getYear() > endYear || i.getYear() < startYear) {
					temporaryInvoices.remove(i);
				}
			}
		}
		if(startMonth == endMonth) {
			for(Invoice i: temporaryInvoices) {
				if(i.getMonth() != startMonth) {
					temporaryInvoices.remove(i);
				}
			}
		}
		else {
			for(Invoice i: temporaryInvoices) {
				if(i.getMonth() > endMonth || i.getMonth() < startMonth) {
					temporaryInvoices.remove(i);
				}
			}
		}
		if(startDay == endDay) {
			for(Invoice i: temporaryInvoices) {
				if(i.getDay() != startDay) {
					temporaryInvoices.remove(i);
				}
			}
		}
		else {
			for(Invoice i: temporaryInvoices) {
				if(i.getDay() > endDay || i.getDay() < startDay) {
					temporaryInvoices.remove(i);
				}
			}
		}
		return invoices;
	}
	public double generatePaycheck(String salesAssociate, int startMonth, int startDay, int startYear, int endMonth, int endDay, int endYear) {
		double amount = 0;
		ArrayList<Invoice> invoices = getInvoicesBetweenDates(salesAssociate, startMonth, startDay, startYear, endMonth, endDay, endYear);
		for(Invoice temp: invoices) {
			amount += temp.getTotalCost();
		}
		return amount * 0.15;
	}
}
