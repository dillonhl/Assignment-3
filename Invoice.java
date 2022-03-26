import java.sql.Date;
import java.util.*;

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
    
    void Invoice(int cust_ID, int salesprsn_ID) {
    	
    }

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

    }

    void saveInvoice(){

    }

    float calcCommission(){

    }

    void updateInvoice(float payment){
        
    }

    void closeInvoice(){

    }

    void addDiscount(){

    }

    Date getInvoiceClosedData(){

    }

    void addFinanceCharge(float financeCharge){
        
    }
}
