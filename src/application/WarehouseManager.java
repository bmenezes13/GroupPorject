package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class WarehouseManager extends Account{
	private Warehouse ware;
	 public WarehouseManager(String first, String last, String addy, String user, String pass, Warehouse wh) {
		 super(first, last, addy, user, pass);
		 this.ware=wh;
	 }
	 public Warehouse getWare(){
		 return this.ware;
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
	 public String display(String bpName, ArrayList<Warehouse> db){
	        int count = 0;
	        String output = null;
	        for(int i = 0; i < db.size(); i++){
	            for (BikePart p: db.get(i).getWare()){
	                if (p.getPartName().equals(bpName)||p.getPartNum().equals(bpName)){
	                     output = ("Found in warehouse: "+db.get(i).getName()+": "+"\n" + p.getPartName()+", "+p.getPartNum()+", "
	                             +p.getListP()+", "+p.getSaleP()+", "+p.getOnSale()+
	                             ", "+p.getPartQuant()+"\n");
	                     count += 1;
	                }
	            }
	        }
	        if(count == 0){
	            output = ("No part found in any warehouse");
	        }
	        return output;
	    }
}
