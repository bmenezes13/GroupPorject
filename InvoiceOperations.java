import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InvoiceOperations {
	public void writeInvoices(ArrayList<Invoice> invoices) {
		try {
			FileWriter fileWriter = new FileWriter("Invoices.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for(Invoice i: invoices) {
				bufferedWriter.write(i.getMonth()+"/"+i.getDay()+"/"+i.getYear());
				bufferedWriter.newLine();
				bufferedWriter.write(i.getEmployee()+","+i.getCustomer());
				bufferedWriter.newLine();
				for(BikePart bp: i.getBpSold()) {
					bufferedWriter.write(" "+bp.toString());
					bufferedWriter.newLine();
				}
				bufferedWriter.write("Total Cost: "+i.getTotalCost());
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
		}
		catch(IOException ex) {
			System.out.println("Error Writing to Invoices.txt");
		}
	}
	public ArrayList<Invoice> readInvoices(){
		try {
			ArrayList<Invoice> invoices = new ArrayList<>();
			File file = new File("Invoices.txt");
			Scanner read = new Scanner(file);
			while (read.hasNextLine()) {
				String[] date = read.nextLine().split("/");
				String[] customerEmployee = read.nextLine().split(",");
				Boolean hasBikeParts = true;
				ArrayList<BikePart> bikeparts = new ArrayList<>();
				while(hasBikeParts) {
					String line = read.nextLine();
					if(line.startsWith(" ")) {
						String[] pv = line.split(",");
						BikePart bp = new BikePart(pv[0],Integer.parseInt(pv[1]),Double.parseDouble(pv[2]),Double.parseDouble(pv[3]),Boolean.parseBoolean(pv[4]),Integer.parseInt(pv[5]));
						bikeparts.add(bp);
					}
					else {
						hasBikeParts = false;
					}
				}
				double totalCost = read.nextDouble();
				read.nextLine();
				read.nextLine(); //There is a space between each invoice.
				Invoice invoice = new Invoice(totalCost,Integer.parseInt(date[1]),Integer.parseInt(date[0]),Integer.parseInt(date[2]),customerEmployee[1],customerEmployee[0],bikeparts);
				invoices.add(invoice);
			}
			read.close();
			return invoices;
		}
		catch(FileNotFoundException ex){
			System.out.println("Invoices.txt wasn't found");
			return null;
		}
	}
}
/* What an invoice looks like:
XX/XX/XX
Employee,Customer
 pbname,pbnum,listprice,salesprice,saleBoolean,quantity.
 pbname,pbnum,listprice,salesprice,saleBoolean,quantity.
 pbname,pbnum,listprice,salesprice,saleBoolean,quantity.
 pbname,pbnum,listprice,salesprice,saleBoolean,quantity.
 pbname,pbnum,listprice,salesprice,saleBoolean,quantity.
 pbname,pbnum,listprice,salesprice,saleBoolean,quantity.
 pbname,pbnum,listprice,salesprice,saleBoolean,quantity.
 pbname,pbnum,listprice,salesprice,saleBoolean,quantity.
 pbname,pbnum,listprice,salesprice,saleBoolean,quantity.
 pbname,pbnum,listprice,salesprice,saleBoolean,quantity.
 pbname,pbnum,listprice,salesprice,saleBoolean,quantity.
Total Cost: XX.XX

*/
