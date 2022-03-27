import java.io.*;
import java.nio.file.*;
import java.util.*;
//package testing;

public class Store_System {
	String password;
	
	Store_System(){
		
	}
	

    void resetPassword(String current_password, String new_password){

    }

    void enterPassword(String password){

    }

    void verifyPassword(String password){

    }

    void displayPasswordErrorMsg(){

    }
/*
    Customer searchCustomer(String name){
    	//return Customer with that name
    }
*/
    void createCustomer(String address, String phone, float salesTax){

    }

    Invoice createInvoice(int customer_id, int salesperson_id, HashMap<Integer, Integer> ordered_products, int delivery){
    	Invoice invoice = new Invoice(customer_id, salesperson_id, ordered_products);
    	
    	return invoice;
    }

    void addSalesperson(){

    }

    void displayCustomers() {

    }
    

    void displayProducts(){
    	try {
    		System.out.println("Our system's Working Directory = " + System.getProperty("user.dir"));
    		//Path currentRelativePath = Paths.get("");
    		//String s = currentRelativePath.toAbsolutePath().toString();
    		//System.out.println("Current absolute path is: " + s);
    		File f = new File(".\\Assignment-3 Github Folder\\Product_List_Test_for_Java_CSV.csv");
			Scanner sc = new Scanner(f);
			sc.useDelimiter(",");   //sets the delimiter pattern  
			while (sc.hasNext())  //returns a boolean value  
				{  
				System.out.print(sc.next() + ",  ");  //find and returns the next complete token from this scanner  
				}   
			sc.close();  //closes the scanner  
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
