import java.io.*;
//import java.nio.file.*;
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
    	//Calc more attributes for invoice, like total cost.
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
    		//File f = new File(".\\Assignment-3 Github Folder\\Product_List_Test_for_Java_CSV.csv");
    		String line = "";
    		String splitBy = ",";
   			//parsing a CSV file into BufferedReader class constructor
   			//System.out.println("ReadCSVExample2's Working Directory = " + System.getProperty("user.dir"));
   			BufferedReader br = new BufferedReader(new FileReader(".\\Assignment-3 Github Folder\\Product_List_Test_for_Java_CSV.csv"));    
   			//reads one line at a time  
   			while ((line = br.readLine()) != null){  
   				String[] product = line.split(splitBy);
   				System.out.println("Product [ID = " + product[0] + ", Name = " + product[1] + ", Warehouse # = " + product[2] + ", Quantity = " + product[3] + ", Selling Price = " + product[4] + ", Cost Price = " + product[5] + "]");
   			}
   				/*
    		Scanner sc = new Scanner(f);
			sc.useDelimiter(",");   //sets the delimiter pattern  
			while (sc.hasNext())  //returns a boolean value  
				{  
				System.out.print(sc.next() + ",  ");  //find and returns the next complete token from this scanner  
				}   
			sc.close();  //closes the scanner
			*/  
    	} catch (Exception e) {
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
