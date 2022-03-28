import java.io.*;
//import java.nio.file.*;
import java.util.*;
//package testing;

public class Store_System {
	private String password;
	
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

    Invoice createInvoice(int invoice_id, Customer customer, Salesperson salesperson, LinkedHashMap<Product, Integer> ordered_products, int delivery){
    	Invoice invoice = new Invoice(invoice_id, customer, salesperson, ordered_products);
    	//Invoice creation will also calculate more attributes for invoice, like total amount.
    	return invoice;
    }

    void addSalesperson(){

    }

    void displayCustomers() {

    }
    

    void displayProducts(){
    	try {
    		//System.out.println("Our system's Working Directory = " + System.getProperty("user.dir"));
    		//Path currentRelativePath = Paths.get("");
    		//String s = currentRelativePath.toAbsolutePath().toString();
    		//System.out.println("Current absolute path is: " + s);
    		//File f = new File(".\\Assignment-3 Github Folder\\Product_List_Test_for_Java_CSV.csv");
    		String line = "";
    		String splitBy = ",";
   			//parsing a CSV file into BufferedReader class constructor
   			//System.out.println("ReadCSVExample2's Working Directory = " + System.getProperty("user.dir"));
   			BufferedReader br = new BufferedReader(new FileReader("Product_List.csv"));    
   			//reads one line at a time  
   			br.readLine();
   			while ((line = br.readLine()) != null){  
   				int product_id = Integer.parseInt(line.split(splitBy)[0]);
   				Product product = new Product(product_id);
   				System.out.println(product);
   				/*
   				System.out.println("Product [ID = " + product[0] +
   									", Serial Number = " + product[1] +
   									", Name = " + product[2] + 
   									", Warehouse # = " + product[3] + 
   									", Quantity = " + product[4] + 
   									", Selling Price = " + product[5] + 
   									", Cost Price = " + product[6] + "]");
   				*/
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
