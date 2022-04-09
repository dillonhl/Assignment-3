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
    int totalQuantityOrdered;
    float pretax_sales_total;
    float sales_tax_amount;
    float delivery_charge;
    float total_amount;
    float remaining_balance;
    float discount; 
    float finance_charge;
	
	Invoice(Customer cust, Salesperson salesprsn, LinkedHashMap<Product,Integer> product_orders, int delivery) {
    	this.invoice_creation_date = new Date();
    	this.invoice_closed_date = null;
    	this.salesperson_id = salesprsn.salesperson_id;
    	this.salesperson_name = salesprsn.salesperson_name;
    	this.customer_id = cust.customer_id;
    	this.customer_name = cust.customer_name;
    	this.customer_address = cust.customer_address;
    	this.cust_sales_tax_percent = cust.sales_tax;
    	this.invoice_id = this.invoice_creation_date.hashCode() + this.customer_id;
    	this.ordered_products = product_orders;
    	for (Integer orderedQty : this.ordered_products.values()) {
    		this.totalQuantityOrdered += orderedQty;
    	}
    	this.pretax_sales_total = this.sales_tax_amount = 
    			this.delivery_charge = this.total_amount =
    			this.remaining_balance = this.discount = 
    			this.finance_charge = 0;
    	calc_amounts(delivery);
    }

    String saveProductListString(){
    	String all_ordered_products = "||";
    	for(Map.Entry<Product, Integer> entry : this.ordered_products.entrySet()) {
    		Product product = entry.getKey();
    		int ordered_quantity = entry.getValue();
       		int ordered_product_ProductID = product.product_ID;
			String ordered_product_SerialNumber = product.serial_number;
			String ordered_product_ProductName = product.product_name;
			Float ordered_product_SellingPrice = product.selling_price;
			Float ordered_product_TotalPrice = product.selling_price * ordered_quantity;			
			String ordered_product = "[Product ID = " + ordered_product_ProductID + "; " + 
								"Serial Number = " + ordered_product_SerialNumber + "; " +
								"Product Name = " + ordered_product_ProductName + "; " +
								"Selling Price = " + ordered_product_SellingPrice + "; " +
								"Ordered Quantity = " + ordered_quantity + "; " +
								"Total Price = $" + ordered_product_TotalPrice + "]";
			all_ordered_products = all_ordered_products + "\t" + ordered_product + "||";
    	}
    	return all_ordered_products;
    }

    
    void saveInvoice(){
    		try {
    			String product_list = saveProductListString();
        		FileWriter fw = new FileWriter("Invoice_List.csv", true);
        		BufferedWriter bw = new BufferedWriter(fw);
        		PrintWriter pw = new PrintWriter(bw);
        		pw.println(String.valueOf(this.invoice_id) + "," +
        				String.valueOf(this.invoice_creation_date) + "," +
        				String.valueOf(this.invoice_closed_date) + "," +
        			    String.valueOf(this.salesperson_id) + "," +
        			    this.salesperson_name + "," +
        			    String.valueOf(this.customer_id) + "," +
        			    this.customer_name + "," +
        			    this.customer_address + "," +
        			    String.valueOf(this.cust_sales_tax_percent) + "," +
        			    //String.valueOf(this.ordered_products) + "," +
        			    String.valueOf(product_list) + "," +
        			    String.valueOf(this.totalQuantityOrdered) + "," +
        			    String.valueOf(this.pretax_sales_total) + "," +
        			    String.valueOf(this.sales_tax_amount) + "," +
        			    String.valueOf(this.delivery_charge) + "," +
        			    String.valueOf(this.total_amount) + "," +
        			    String.valueOf(this.remaining_balance) + "," +
        			    String.valueOf(this.discount) + "," +
        			    String.valueOf(this.finance_charge));    
        		pw.flush();
        		pw.close();
        		System.out.println("Invoice saved.");  	
    		}
    		catch (Exception e) {
    			System.out.println("ERROR! - File is open.");
    		}
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
}
