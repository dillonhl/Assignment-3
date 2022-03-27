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
    	this.salesperson_id = salesprsn_ID;
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
    	System.out.println("Our invoices's Working Directory = " + System.getProperty("user.dir"));
    	System.out.println(this.customer_id);
    	System.out.println(this.salesperson_id);
    	System.out.println(this.ordered_products);
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
}
