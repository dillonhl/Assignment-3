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
	String ordered_product;
	String all_ordered_products = "||";
	int ordered_product_ProductID;
	String ordered_product_SerialNumber;
	String ordered_product_ProductName;
	float ordered_product_SellingPrice;
	float ordered_product_TotalPrice;

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

    void printInvoice(){
    	System.out.println("Invoice ID: " + this.invoice_id);
    	System.out.println("Date: " + this.invoice_creation_date);
    	System.out.println("Customer ID: " + this.customer_id + 
    						", Name: " + this.customer_name + 
    						", Address = " + this.customer_address + 
    						", Sales Tax % = " + this.cust_sales_tax_percent + "%");
    	System.out.println("Salesperson ID: " + this.salesperson_id + ", Name: " + this.salesperson_name);
    	for(Map.Entry<Product, Integer> entry : this.ordered_products.entrySet()) {
    		Product product = entry.getKey();
    		int ordered_quantity = entry.getValue();
       		System.out.printf("Product [ID = %2d, Serial Number = %9s, "
       						 + "Name = %13s, Selling Price = $%3.2f, "
       						 + "Ordered Quantity = %2d, Total Price = $%4.2f] \n",product.product_ID,
       						    product.serial_number, product.product_name, product.selling_price,
       						    ordered_quantity, (product.selling_price * ordered_quantity));

			ordered_product_ProductID = product.product_ID;
			ordered_product_SerialNumber = product.serial_number;
			ordered_product_ProductName = product.product_name;
			ordered_product_SellingPrice = product.selling_price;
			ordered_product_TotalPrice = product.selling_price * ordered_quantity;			
			ordered_product = "[Product ID = " + ordered_product_ProductID + " " + 
								"Serial Number = " + ordered_product_SerialNumber + " " +
								"Product Name = " + ordered_product_ProductName + " " +
								"Selling Price = " + ordered_product_SellingPrice + " " +
								"Ordered Quantity = " + ordered_quantity + " " +
								"Total Price = $" + ordered_product_TotalPrice + "]";
			all_ordered_products = all_ordered_products + "\t" + ordered_product + "||";
    	}
    	System.out.printf("Total Quantity Ordered = %2d \n", this.totalQuantityOrdered);
    	System.out.printf("Pre-tax Sales Total = $%4.2f \n", this.pretax_sales_total);
    	System.out.printf("Sales Tax (%2.1f%%) = $%4.2f \n", this.cust_sales_tax_percent, this.sales_tax_amount);
    	System.out.printf("Delivery fee = $%2.2f \n", this.delivery_charge);
    	System.out.printf("Total Amount = $%4.2f \n \n", this.total_amount);
    }

    
    void saveInvoice(){
    		try {    			
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
        			    String.valueOf(this.all_ordered_products) + "," +
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
