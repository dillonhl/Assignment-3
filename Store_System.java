import java.io.*;
//import java.nio.file.*;
import java.util.*;
//package testing;

public class Store_System {
	private String password;
	public ArrayList<Product> products;
	
	Store_System(){
		/*
		this.password = "awesome_system_150%";
		//parsing a CSV file into Scanner class constructor  
		Store_System system = new Store_System();
		String search_term = "Sony";
		//ArrayList<Product> found_prdcts = system.find_search_results(search_term);
		//system.displaySearchedProducts(found_prdcts);
		//ArrayList<Product> found_product_list = new ArrayList<Product>();
    	String[] searched_product = null;
		try {
    		String line = ""; String splitBy = ",";
			BufferedReader br = new BufferedReader(new FileReader("Product_List.csv"));
			br.readLine();
			//List<String> found_product = Collections.emptyList();
			while ((line = br.readLine()) != null){  
				searched_product = line.split(splitBy);
				//System.out.println("Product [ID = " + product[0] + ", Name = " + product[1] + "]");
				String searched_product_name = searched_product[2];
				if (searched_product_name.contains(search_term)) {
					int found_product_id = Integer.parseInt(searched_product[0]);
					Product found_product = new Product(found_product_id);
					//found_product_list.add(found_product);
					System.out.println(found_product);
				}
			}
			br.close();
			//return found_product_list;
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//system.displayProducts();
	} */
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
    	Invoice invoice = new Invoice(invoice_id, customer, salesperson, ordered_products, delivery);
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

    ArrayList<Product> find_search_results(String search_term) {
    	ArrayList<Product> found_product_list = new ArrayList<Product>();
    	String[] searched_product = null;
		try {
    		String line = ""; String splitBy = ",";
			BufferedReader br = new BufferedReader(new FileReader("Product_List.csv"));
			br.readLine();
			//List<String> found_product = Collections.emptyList();
			while ((line = br.readLine()) != null){  
				searched_product = line.split(splitBy);
				//System.out.println("Product [ID = " + product[0] + ", Name = " + product[1] + "]");
				String searched_product_name = searched_product[2];
				if (searched_product_name.contains(search_term)) {
					int found_product_id = Integer.parseInt(searched_product[0]);
					Product found_product = new Product(found_product_id);
					found_product_list.add(found_product);
				}
			}
			br.close();
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return found_product_list;
    }
    
    void displaySearchedProducts(String searchTerm, ArrayList<Product> products) {
    	Iterator<Product> iter = products.iterator();
    	System.out.println("Products whose names contain " + searchTerm + ":");
    	while(iter.hasNext()) {
    		System.out.println(iter.next());
    	}
    }
}
