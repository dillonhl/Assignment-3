import java.sql.Date;
import java.util.*;
import java.io.*;
import java.lang.System;

public class Invoice {
    private int invoice_id;
    private Date invoice_creation_date;
    private Date invoice_closed_date;
    private int salesperson_id;
    private String salesperson_name;
    private int customer_id;
    private String customer_name;
    private String customer_address;
    private Float salesTaxPercent;
    private HashMap<Integer,Integer> ordered_products;
    float delivery_charge;
    int totalQuantity;
    float pretax_sales_total;
    float sales_tax_amount;
    float total_amount;
    float remaining_balance;
    float discount; 
    float finance_charge;
    
    Invoice(int cust_ID, int salesprsn_ID, HashMap<Integer,Integer> product_orders) {
    	this.customer_id = cust_ID;
    	//Look up customer CSV table w ID to fill in name, address, phone #, and sales tax %.
    	add_customer_info(customer_id);
    	this.salesperson_id = salesprsn_ID;
    	add_salesperson_info(salesperson_id);
    	this.ordered_products = product_orders;
    }

    //I'm not sure if this method is even necessary anymore.
    void addProduct(int productID, int quantity_ordered){

    }

    void displayQuantityErrorMessage(){

    }

    void displayProductByWarehouse(int productID){

    }

    void selectQtyFromWarehouse(int warehouse_num, int productID, int quantity){

    }

    void applySalesTax(){

    }

    void addDeliveryCharge(float deliveryCharge){

    }

    void printInvoice(){
    	//System.out.println("Our invoices's Working Directory = " + System.getProperty("user.dir"));
    	System.out.println("Customer ID: " + this.customer_id + 
    						", Name: " + this.customer_name + 
    						", Address = " + this.customer_address + 
    						", Sales Tax % = " + this.salesTaxPercent + "%");
    	System.out.println("Salesperson ID: " + this.salesperson_id + ", Name: " + this.salesperson_name);
    	//System.out.println(this.ordered_products);
    	for(Map.Entry<Integer, Integer> entry : this.ordered_products.entrySet()) {
    		int product_id = entry.getKey();
    		String [] product = find_product(product_id);
    		int ordered_quantity = entry.getValue();
    		System.out.println("Product_ID = " + product_id +
    				"Product_Name = " + product[1] +
    				", Warehouse # = " + product[2] +
    				", Total Quantity = " + product[3] + 
    				", Selling Price = " + product[4] + 
    				", Cost Price = " + product[5] +
    				", Ordered Quantity = " + ordered_quantity);
    	}
    }

    void saveInvoice(){

    }
/*
    float calcCommission(){

    }
*/
    void updateInvoice(float payment){
        
    }

    void closeInvoice(){

    }

    void addDiscount(){

    }
/*
    Date getInvoiceClosedData(){

    }
*/
    void addFinanceCharge(float financeCharge){
        
    }
    
    private void add_customer_info(int customer_id) {
    	try {
    		String line = ""; String splitBy = ",";
			BufferedReader br = new BufferedReader(new FileReader("Customer_List.csv"));
			br.readLine();
			while ((line = br.readLine()) != null){  
				String[] customer = line.split(splitBy);
				//System.out.println("Customer [ID = " + customer[0] + ", Name = " + customer[1] + ", Address = " + customer[2] + ", Phone Number = " + customer[3] + ", Sales Tax = " + customer[4] + "%]");
				this.customer_name = customer[1];
				this.customer_address = customer[2];
				this.salesTaxPercent = Float.parseFloat(customer[4]);
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void add_salesperson_info(int salesperson_id) {
    	try {
    		String line = ""; String splitBy = ",";
			BufferedReader br = new BufferedReader(new FileReader("Salesperson_List.csv"));
			br.readLine();
			while ((line = br.readLine()) != null){  
				String[] salesperson = line.split(splitBy);
				//System.out.println("Salesperson [ID = " + salesperson[0] + ", Name = " + salesperson[1] + "]");
				this.salesperson_name = salesperson[1];
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private String[] find_product(int product_id) {
    	try {
    		String line = ""; String splitBy = ",";
			BufferedReader br = new BufferedReader(new FileReader("Product_List.csv"));
			br.readLine();
			//String[] found_product;
			while ((line = br.readLine()) != null){  
				String[] product = line.split(splitBy);
				//System.out.println("Product [ID = " + product[0] + ", Name = " + product[1] + "]");
				if (product[0] == String.valueOf(product_id)) {
					br.close();
					return product;
				}
			}
			br.close();
			return [""];
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /*
    private String[] find_info(String csv_file_dir) {
    	try {
    		String line = ""; String splitBy = ",";
			BufferedReader br = new BufferedReader(new FileReader(csv));
			br.readLine();
			while ((line = br.readLine()) != null){  
				String[] info = line.split(splitBy);
			}
			br.close();
			return product
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    } */
}
