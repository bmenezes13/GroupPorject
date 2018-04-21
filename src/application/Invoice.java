package application;

import java.util.ArrayList;

public class Invoice {
	private double totalCost;
		private int day;
		private int month;
		private int year;
		private String customer;
		private String employee;
		private ArrayList<BikePart> bpSold = new ArrayList<>();
		
		public Invoice(double totalCost, int day, int month, int year, String customer, String employee, ArrayList<BikePart> bpSold) {
			this.totalCost = totalCost;
			this.day = day;
			this.month = month;
			this.year = year;
			this.customer = customer;
			this.employee = employee;
			this.bpSold = bpSold;
		}
		
		//Getters
		public double getTotalCost() {
			return totalCost;
		}
		public int getDay() {
			return day;
		}
		public int getMonth() {
			return month;
		}
		public int getYear() {
			return year;
		}
		public String getCustomer() {
			return customer;
		}
		public String getEmployee() {
			return employee;
		}
		public ArrayList<BikePart> getBpSold() {
			return bpSold;
		}
		//Setters
		public void setTotalCost(double totalCost) {
			this.totalCost = totalCost;
		}
		public void setDay(int day) {
			this.day = day;
		}
		public void setMonth(int month) {
			this.month = month;
		}
		public void setYear(int year) {
			this.year = year;
		}
		public void setCustomer(String customer) {
			this.customer = customer;
		}
		public void setEmployee(String employee) {
			this.employee = employee;
		}
		public void setBpSold(ArrayList<BikePart> bpSold) {
			this.bpSold = bpSold;
		}
	}

