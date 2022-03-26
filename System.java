import java.util.*;

public class System {
    String password;
    
    void resetPassword(String current_password, String new_password){

    }

    void enterPassword(String password){

    }

    void verifyPassword(String password){

    }

    void displayPasswordErrorMsg(){

    }

    Customer searchCustomer(String name){
    	//return Customer with that name
    }

    void createCustomer(String address, String phone, float salesTax){

    }

    Invoice createInvoice(int customer_id, int salesperson_id, Map<Integer, Integer> ordered_products, int delivery){
    	Invoice invoice = new Invoice(customer_id, salesperson_id);
    	//more stuff.
    }

    void addSalesperson(){

    }

    void displayCustomers() {

    }
    

    void displayProducts() {

    }

    void displayLowInventory() {

    }

    void displayProductsByWarehouse() {

    }

    void displayOpenInvoices() {

    }

    void displayClosedInvoices() {

    }

    void displaySalespeople() {

    }    
}
