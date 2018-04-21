package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SalesAssociate extends Account {
	private ArrayList<Invoice> invoices;
	private Warehouse van;
	 public SalesAssociate(String first, String last, String addy, String user, String pass, Warehouse wh, ArrayList<Invoice> list) {
		 super(first, last, addy, user, pass);
		 this.van = wh;
		 this.invoices = list;
	 }
	 public Warehouse getWare(){
		 return this.van;
	 }
	 public void createInvoice(double totalCost, int day, int month, int year, String customer, String employee, ArrayList<BikePart> bpSold) {
		 this.invoices.add(new Invoice(totalCost, day, month, year, customer, employee, bpSold));
	 }
	


	 public void read(String filename, ArrayList<BikePart> list) {
	        try{
	                File fileInput = new File(filename);
	                Scanner fileSC = new Scanner(fileInput);
	                while(fileSC.hasNextLine()){
	                    String line = fileSC.nextLine();
	                    String[] elements = line.split(",");
	                    BikePart newBP = new BikePart(elements[0],elements[1],
	                        Double.parseDouble(elements[2]),Double.parseDouble(elements[3]),
	                        Boolean.parseBoolean(elements[4]),Integer.parseInt(elements[5]));

	                boolean b = false;
	                for (BikePart p : list){
	                    if (p.getPartNum().equals(newBP.getPartNum())){
	                        p.setQuant(newBP.getPartQuant());
	                        p.setListP(newBP.getListP());
	                        p.setSaleP(newBP.getSaleP());
	                        p.setOnSale(newBP.getOnSale());
	                        b = true;
	                        break;
	                    }
	                }

	                if (!b) {
	                    list.add(newBP);
	                }
	                }
	            }
	                catch(FileNotFoundException exception){
	                    System.out.println("File not found.");
	                }
	            }
}
