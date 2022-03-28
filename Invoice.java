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
    		//String [] product = find_product(product_id);
    		String[] searched_product = null;
    		try {
        		String line = ""; String splitBy = ",";
    			BufferedReader br = new BufferedReader(new FileReader("Product_List.csv"));
    			br.readLine();
    			//List<String> found_product = Collections.emptyList();
    			while ((line = br.readLine()) != null){  
    				searched_product = line.split(splitBy);
    				//System.out.println("Product [ID = " + product[0] + ", Name = " + product[1] + "]");
    				if (Integer.parseInt(searched_product[0]) == product_id) {
    					break;
    				}
    			}
    			br.close();
    			//return found_product;
        	} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		int ordered_quantity = entry.getValue();
    		System.out.println("Product_ID = " + product_id +
    				", Product_Name = " + searched_product[1] +
    				", Warehouse # = " + searched_product[2] +
    				", Total Quantity = " + searched_product[3] + 
    				", Selling Price = " + searched_product[4] + 
    				", Cost Price = " + searched_product[5] +
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
				String[] searched_customer = line.split(splitBy);
				//System.out.println("Customer [ID = " + customer[0] + ", Name = " + customer[1] + ", Address = " + customer[2] + ", Phone Number = " + customer[3] + ", Sales Tax = " + customer[4] + "%]");
				int searched_customer_id = Integer.parseInt(searched_customer[0]);
				if (customer_id == searched_customer_id) {
					this.customer_name = searched_customer[1];
					this.customer_address = searched_customer[2];
					this.salesTaxPercent = Float.parseFloat(searched_customer[4]);
				}
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
				String[] searched_salesperson = line.split(splitBy);
				//System.out.println("Salesperson [ID = " + salesperson[0] + ", Name = " + salesperson[1] + "]");
				int searched_salesperson_id = Integer.parseInt(searched_salesperson[0]);
				if (salesperson_id == searched_salesperson_id) {
					this.salesperson_name = searched_salesperson[1];
				}
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
/*
    private List<String> find_product(int product_id) {
    	try {
    		String line = ""; String splitBy = ",";
			BufferedReader br = new BufferedReader(new FileReader("Product_List.csv"));
			br.readLine();
			List<String> found_product = Collections.emptyList();
			while ((line = br.readLine()) != null){  
				String[] product = line.split(splitBy);
				//System.out.println("Product [ID = " + product[0] + ", Name = " + product[1] + "]");
				if (product[0] == String.valueOf(product_id)) {
					List<String> found_prod_list = Arrays.asList(product);
					found_product = found_prod_list;
					break;
				}
			}
			br.close();
			return found_product;
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
