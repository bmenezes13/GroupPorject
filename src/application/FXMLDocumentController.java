package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

	
	/*
	 * To change this license header, choose License Headers in Project Properties.
	 * To change this template file, choose Tools | Templates
	 * and open the template in the editor.
	 */

	import java.net.URL;
	import java.util.ResourceBundle;
	import javafx.application.Platform;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.fxml.Initializable;
	import javafx.scene.control.Button;
	import javafx.scene.control.Label;
	import javafx.scene.control.TextArea;
	import javafx.scene.control.TextField;
	import java.util.ArrayList;
	import java.util.Scanner;
	import java.io.*;
	import java.util.Collections;
	import java.util.Date;
	import java.util.Comparator;
	/**
	 *
	 * @author user
	 */
	public class FXMLDocumentController implements Initializable {
	    
	    @FXML
	    private TextArea output;
	    @FXML
	    private TextField input;
	    @FXML
	    private Button readButton, displayButton, sellButton, enterButton, quitButton,
	            sortNameButton, sortNumButton, moveButton, addButton, helpButton;
	    ArrayList<Warehouse> db = new ArrayList<Warehouse>();
	    ArrayList<BikePart> main = new ArrayList<BikePart>();
	    Warehouse mainDB = new Warehouse("mainWh", main);

	    
	    @FXML
	    private void helpAction(ActionEvent event){
	        output.appendText("Read: inventoryfile.txt"+"\n");
	        output.appendText("Move: deliveryfile.txt"+"\n");
	        output.appendText("Enter: warehouse name, bikepart attributes w/ commas but no spaces"+"\n");
	        output.appendText("Add: sales van name"+"\n");
	        output.appendText("Display: partname"+"\n");
	        output.appendText("Sell: warehouse name, partnumber"+"\n");
	    }
	    
	    @FXML
	    private void readAction(ActionEvent event) {
	        try{
	                File fileInput = new File(input.getText());
	                Scanner fileSC = new Scanner(fileInput);
	                while(fileSC.hasNextLine()){
	                    String line = fileSC.nextLine();
	                    String[] elements = line.split(",");
	                    BikePart newBP = new BikePart(elements[0],elements[1],
	                        Double.parseDouble(elements[2]),Double.parseDouble(elements[3]),
	                        Boolean.parseBoolean(elements[4]),Integer.parseInt(elements[5]));

	                boolean b = false;
	                for (BikePart p : main){
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
	                    main.add(newBP);
	                }
	                }
	                output.appendText("File found, main warehouse updated" + "\n");
	            }
	                catch(FileNotFoundException exception){
	                    output.appendText("File does not exist." + "\n");
	                }
	            }
	            
	            
	    
	    @FXML
	    private void displayAction(ActionEvent event){
	        String bpName = input.getText();
	        int count = 0;
	        for(int i = 0; i < db.size(); i++){
	            for (BikePart p: db.get(i).getWare()){
	                if (p.getPartName().equals(bpName)){
	                     output.appendText("Found in warehouse: "+db.get(i).getName()+": "+"\n");
	                     output.appendText(p.getPartName()+", "+p.getPartNum()+", "
	                             +p.getListP()+", "+p.getSaleP()+", "+p.getOnSale()+
	                             ", "+p.getPartQuant()+"\n");
	                     count += 1;
	                }
	            }
	        }
	        if(count == 0){
	            output.appendText("No part found in any warehouse");
	        }
	    }
	    @FXML
	    private void sellAction(ActionEvent event){
	        String in = input.getText();
	        String[] sellements = in.split(", ");
	        String whName = sellements[0];
	        String bpNum = sellements[1];
	        int count = 0;
	        for(Warehouse s:db){
	            if(s.getName().equals(whName)){
	                for(BikePart se:s.getWare()){
	                    if (se.getPartNum().equals(bpNum)){
	                        output.appendText(se.getPartName()+" sold for "+se.getPrice()+"\n");
	                        Date date = new Date();
	                        output.appendText(date.toString());
	                        se.addPartQuant(-1);
	                        count += 1;
	                    }
	                }
	            }
	        }
	        if (count == 0){
	            output.appendText("No part found in warehouse: "+whName);
	        }
	    }
	    @FXML
	    private void enterAction(ActionEvent event){
	        String in = input.getText();
	        String[] stelements = in.split(", ");
	        String whName = stelements[0];
	        String[] elements = stelements[1].split(",");
	        BikePart newBP = new BikePart(elements[0], elements[1], 
	                Double.parseDouble(elements[2]), Double.parseDouble(elements[3]),
	                Boolean.parseBoolean(elements[4]), Integer.parseInt(elements[5]));
	        for(Warehouse e:db){
	            if(e.getName().equals(whName)){
	                int count = 0;
	                for(BikePart en:e.getWare()){
	                    if(en.getPartName().equals(newBP.getPartName())){
	                        en.setListP(newBP.getListP());
	                        en.setSaleP(newBP.getSaleP());
	                        en.setOnSale(newBP.getOnSale());
	                        en.addPartQuant(newBP.getPartQuant());
	                        count += 1;
	                    }
	                }
	                if (count == 0){
	                    e.getWare().add(newBP);
	                }
	            }
	        }
	        output.appendText("BikePart " + newBP.getPartName() + " has been added" + "\n");
	        
	    }
	    @FXML private void sortNameAction(ActionEvent event){
	        for(int i = 0; i < db.size(); i++){
	            Comparator<BikePart> nameSorter = (Comparator<BikePart>) new ComparatorByPartName();
	            Collections.sort(db.get(i).getWare(), nameSorter);
	            output.appendText("Warehouse: " + db.get(i).getName()+"\n");
	            for(int j = 0; j<db.get(i).getWare().size(); j++){
	                output.appendText(db.get(i).getWare().get(j).getPartName() + "," + 
	                                db.get(i).getWare().get(j).getPartNum() + "," +
	                                db.get(i).getWare().get(j).getListP() + "," +
	                                db.get(i).getWare().get(j).getSaleP() + "," +
	                                db.get(i).getWare().get(j).getOnSale() + "," +
	                                db.get(i).getWare().get(j).getPartQuant() + "\n");
	            }
	        }
	    }
	    @FXML private void sortNumAction(ActionEvent event){
	        for(int i = 0; i < db.size(); i++){
	            Comparator<BikePart> numSorter = (Comparator<BikePart>) new ComparatorByPartNumber();
	            Collections.sort(db.get(i).getWare(), numSorter);
	            output.appendText("Warehouse: " + db.get(i).getName()+"\n");
	            for(int j = 0; j<db.get(i).getWare().size(); j++){
	                output.appendText(db.get(i).getWare().get(j).getPartName() + "," + 
	                                db.get(i).getWare().get(j).getPartNum() + "," +
	                                db.get(i).getWare().get(j).getListP() + "," +
	                                db.get(i).getWare().get(j).getSaleP() + "," +
	                                db.get(i).getWare().get(j).getOnSale() + "," +
	                                db.get(i).getWare().get(j).getPartQuant() + "\n");
	            }
	        }
	    }
	    @FXML private void moveAction(ActionEvent event){
	        File inputmove = new File(input.getText());
	        try{
	            ArrayList<BikePart> move = new ArrayList<BikePart>();
	            Scanner moveSC = new Scanner(inputmove);
	            String direct = moveSC.nextLine();
	            String[] directions = direct.split(",");
	            String origin = null;
	            if(directions[0].equals("mainWarehouse")){
	                origin = "mainWh";
	            }
	            else{
	                origin = directions[0];
	            }
	            String destination = directions[1];
	            for(Warehouse m:db){
	                if(m.getName().equals(origin)){
	                    while(moveSC.hasNext()){
	                        String line = moveSC.nextLine();
	                        String[] nameQuant = line.split(",");
	                        String partName = nameQuant[0];
	                        int quant = Integer.parseInt(nameQuant[1]);
	                        for(BikePart o:m.getWare()){
	                            if (o.getPartName().equals(partName)){
	                                o.addPartQuant(--quant);
	                                BikePart p = o;
	                                p.setQuant(quant);
	                                move.add(p);
	                            }
	                        }
	                    }
	                }
	            }
	            for(Warehouse w:db){
	                if(w.getName().equals(destination)){
	                    for(int i = 0; i < move.size(); i++){
	                        int count = 0;
	                        for(BikePart a:w.getWare()){
	                            if (a.getPartName().equals(move.get(i).getPartName())){
	                                a.addPartQuant(move.get(i).getPartQuant());
	                                count =+ 1;
	                            }
	                        }
	                        if (count == 0){
	                            w.getWare().add(move.get(i));
	                        }
	                    }
	                    
	                    
	                }
	            }
	            
	            
	        }
	        catch (FileNotFoundException e){
	            output.appendText("File not found." + "\n");
	        }
	    }
	    @FXML private void addAction(ActionEvent event){
	        String name = input.getText();
	        Warehouse added = new Warehouse(name, new ArrayList<BikePart>());
	        db.add(added);
	        output.appendText("Warehouse added");
	    }
	    @FXML
	    private void quitAction(ActionEvent event){
	        try {
	            File outputFile = new File("WarehouseDB.txt");
	            FileWriter fw = new FileWriter(outputFile);
	            Writer outputWriter = new BufferedWriter(fw);
	            int sz = main.size();
	            for (int i = 0; i < sz; i++){
	                outputWriter.write(main.get(i).getPartName() + "," + 
	                     main.get(i).getPartNum() + "," +
	                     main.get(i).getListP() + "," +
	                     main.get(i).getSaleP() + "," +
	                     main.get(i).getOnSale() + "," +
	                     main.get(i).getPartQuant() + "\n");
	                
	                }
	                outputWriter.close();
	                } catch (Exception e){
	                    System.out.println("File writing error");
	                }
	        Platform.exit();
	    }
	    @Override
	    public void initialize(URL url, ResourceBundle rb){
	        Scanner sc = new Scanner(System.in);
	        db.add(mainDB);
	        try{
	            File outputFile = new File("WarehouseDB.txt");
	            Scanner wbSC = new Scanner(outputFile);
	            while(wbSC.hasNextLine()){
	                String line = wbSC.nextLine();
	                String[] elements = line.split(",");
	                BikePart bp = new BikePart(elements[0], elements[1], 
	                Double.parseDouble(elements[2]), Double.parseDouble(elements[3]),
	                Boolean.parseBoolean(elements[4]), Integer.parseInt(elements[5]));
	                main.add(bp);   
	            }
	            output.appendText("Previous database found:" + "\n");
	            for (int i = 0; i < main.size(); i++){
	                    output.appendText(main.get(i).getPartName() + "," + 
	                                main.get(i).getPartNum() + "," +
	                                main.get(i).getListP() + "," +
	                                main.get(i).getSaleP() + "," +
	                                main.get(i).getOnSale() + "," +
	                                main.get(i).getPartQuant() + "\n");
	            
	        }
	        }
	        catch (FileNotFoundException e) {
	            output.appendText("No previous database found..." + "\n");
	        }
	    }    
	    
	

	}

