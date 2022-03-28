//import java.sql.Date;
import java.util.*;
import java.io.*;
import java.lang.System;

public class Invoice {
    int invoice_id;
    Date invoice_creation_date;
    Date invoice_closed_date;
    int salesperson_id;
    String salesperson_name;
    int customer_id;
    String customer_name;
    String customer_address;
    float cust_sales_tax_percent;
    LinkedHashMap<Product,Integer> ordered_products;
    int totalQuantity;
    float pretax_sales_total;
    float sales_tax_amount;
    float total_amount;
    float delivery_charge;
    float remaining_balance;
    float discount; 
    float finance_charge;
    
    Invoice(int invoice_id, Customer cust, Salesperson salesprsn, LinkedHashMap<Product,Integer> product_orders, int delivery) {
    	this.invoice_id = invoice_id;
    	this.invoice_creation_date = new Date();
    	this.invoice_closed_date = null;
    	this.customer_id = cust.customer_id;
    	//Look up customer CSV table w ID to fill in name, address, phone #, and sales tax %.
    	this.customer_name = cust.customer_name;
    	this.customer_address = cust.customer_address;
    	this.cust_sales_tax_percent = cust.sales_tax;
    	this.salesperson_id = salesprsn.salesperson_id;
    	this.salesperson_name = salesprsn.salesperson_name;
    	this.ordered_products = product_orders;
    	this.pretax_sales_total = this.sales_tax_amount = 
    			this.total_amount = this.delivery_charge = 
    			this.remaining_balance = this.discount = 
    			this.finance_charge = 0;
    	calc_amounts(delivery);
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
    						", Sales Tax % = " + this.cust_sales_tax_percent + "%");
    	System.out.println("Salesperson ID: " + this.salesperson_id + ", Name: " + this.salesperson_name);
    	//System.out.println(this.ordered_products);
    	for(Map.Entry<Product, Integer> entry : this.ordered_products.entrySet()) {
    		Product product = entry.getKey();
    		int ordered_quantity = entry.getValue();
       		System.out.printf("Product [ID = %2d, Serial Number = %9s, "
       						 + "Name = %13s, Selling Price = $%3.2f, "
       						 + "Ordered Quantity = %2d, Total Price = $%4.2f] \n",product.product_ID,
       						    product.serial_number, product.product_name, product.selling_price,
       						    ordered_quantity, (product.selling_price * ordered_quantity));
       		//this.pretax_sales_total += (product.selling_price * ordered_quantity);
    	}
    	System.out.printf("Pre-tax Sales Total = $%4.2f \n", this.pretax_sales_total);
    	System.out.printf("Sales Tax (%2.1f%%) = $%4.2f \n", this.cust_sales_tax_percent, this.sales_tax_amount);
    	System.out.printf("Delivery fee = $%2.2f \n", this.delivery_charge);
    	System.out.printf("Total Amount = $%4.2f \n", this.total_amount);
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
    
    void calc_amounts(int delivery) {
    	for(Map.Entry<Product, Integer> entry : this.ordered_products.entrySet()) {
    		Product product = entry.getKey();
    		int ordered_quantity = entry.getValue();
       		this.pretax_sales_total += (product.selling_price * ordered_quantity);
    	}
    	this.sales_tax_amount = (this.cust_sales_tax_percent/100) * this.pretax_sales_total;
    	if (delivery == 1) {
    		this.delivery_charge = 5;
    	}
    	this.total_amount = this.pretax_sales_total + this.sales_tax_amount + this.delivery_charge;
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
