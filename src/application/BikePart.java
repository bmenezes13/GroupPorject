
	package application;
	
	/**
	 *
	 * @author user
	 */
	public class BikePart {
	    private String partName;
	        private String partNum;
	        private double listP;
	        private double saleP;
	        private boolean onSale;
	        private int quantity;
	        /** Constructor Method
	        * @param bpName: String part name
	        * @param bpNum: Integer part number
	        * @param bpList: Double list price
	        * @param bpSale: Double sale price
	        * @param bponSale: Boolean of sale condition 
	        * @param quant: Integer of part inventory amount
	        */
	        public BikePart(String bpName, String bpNum, double bpList, double bpSale, boolean bponSale, int quant){
	            this.partName = bpName;
	            this.partNum = bpNum;
	            this.listP = bpList;
	            this.saleP = bpSale;
	            this.onSale = bponSale;
	            this.quantity = quant;}
	        /**
	         * 
	         * @return partName string
	         */
	        public String toString() {
	            return partName;}
	        /**
	         * 
	         * @return partNum integer
	         */
	        public String getPartNum(){
	            return this.partNum;}
	        /**
	         * 
	         * @return partName string
	         */
	        public String getPartName(){
	            return this.partName;}
	        /**
	         * 
	         * @return quantity integer
	         */
	        public int getPartQuant(){
	            return this.quantity;}
	        /**
	         * 
	         * @return onSale boolean
	         */
	        public boolean getOnSale(){
	            return this.onSale;}
	        /**
	         * 
	         * @return listP double
	         */
	        public double getListP(){
	            return this.listP;}
	        /**
	         * 
	         * @return saleP double
	         */
	        public double getSaleP(){
	            return this.saleP;}
	        public double getPrice(){
	            if (this.onSale==true){
	                return this.saleP;
	            }
	            else{
	                return this.listP;
	            }
	        }
	        /**
	         * 
	         * @param n integer of update amount to part quantity
	         * adds param integer to original object quantity integer
	         */
	        public void addPartQuant(int n){
	            this.quantity += n;}
	        /**
	         * sets new quant value with parameter
	         * @param c 
	         */
	        public void setQuant(int c){
	            this.quantity = c;}
	        public void setListP(double lp){
	            this.listP = lp;}
	        public void setSaleP(double sp){
	            this.saleP = sp;}
	        public void setOnSale(boolean os){
	
	
	}
	
	}

