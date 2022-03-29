import java.io.*;
//import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//package testing;

public class Store_System {
	private String password;
	public LinkedHashMap<Integer, Product> products;
	public LinkedHashMap<Integer, Sales> sales;
	
	Store_System(){
		this.password = "awesome_system_150%";
		this.products = new LinkedHashMap<Integer, Product> ();
		this.sales = new LinkedHashMap<Integer, Sales> ();
		importProducts();
		initSales();
		//import_sales();
		/*
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

    void saveInvoice(Invoice invoice) {
    	//Save invoice into Invoice_List.csv
    	Salesperson salesprsn = new Salesperson(invoice.salesperson_id);
    	for(Map.Entry<Product, Integer> entry : invoice.ordered_products.entrySet()) {
    		Product ordered_product = entry.getKey();
    		int ordered_qty = entry.getValue();
    		//Look in this.sales ArrayList for the existing Sales object for that product instead.
    		Sales product_sales = findProductSales(ordered_product);
    		product_sales.addSales(ordered_qty);
    		//System.out.printf("Product quantity in warehouse before order: %2d \n", product.quantity);
    		
    		//These next lines will decrement the quantity of the product in this system's products list, and write that change into the Product_List.csv.
    		Product invntry_product = this.products.get(ordered_product.product_ID);
    		invntry_product.quantity -= ordered_qty;
    		//System.out.printf("New quantity of inventory product ID # %2d : %2d \n", invntry_product.product_ID, invntry_product.quantity);
    		//Put this invntry_product, with this new quantity, back into this.products to update System and CSV info.
    		//Write new inventory quantity of product to that product's line in Product_List.csv:
    		
    		
    		//System.out.printf("Product quantity in warehouse after order: %2d \n", product.quantity);
    		//May change warehouse quantities too, if each product can be in more than one warehouse.
    		System.out.println(product_sales);
    	}
    	float sale_commission = invoice.pretax_sales_total * (salesprsn.commission_rate/100);
    	salesprsn.addCommission(invoice.invoice_id, sale_commission);
    	System.out.println(salesprsn);
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
    
    private Sales findProductSales(Product product) {
    	return this.sales.get(product.product_ID);
    }
    
    private void importProducts() {
    	try {
    		String line = ""; String splitBy = ",";
			BufferedReader br = new BufferedReader(new FileReader("Product_List.csv"));
			br.readLine();
			while ((line = br.readLine()) != null){  
				String [] product = line.split(splitBy);
				int productID = Integer.parseInt(product[0]);
				Product newproduct = new Product(productID);
				this.products.put(productID, newproduct);
			}
			br.close();
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void initSales() {
    	for(Product prdct : this.products.values()) {
    		Sales product_sales = new Sales(prdct);
    		sales.put(prdct.product_ID, product_sales);
    	}
    	//create_CSV(sales, "Sales.csv");
    }
    
    private void create_CSV(LinkedHashMap data, String csvFileName) throws IOException{
    	File csvOutputFile = new File(csvFileName);
    	
    	try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
    		
    	}
    }
    
    public String convertToCSV(String[] data) {
    	return Stream.of(data).map(this::escapeSpclChars).collect(Collectors.joining(","));
    }
    
    public String escapeSpclChars(String data) {
    	String escpdData = data.replaceAll("\\R", "");
    	if (data.contains(",") || data.contains("\"") || data.contains("'")) {
    		data = data.replace("\"", "\"\"");
    		escpdData = "\"" + data + "\"";
    	}
    	return escpdData;
    }
    /*
    String[][] read_CSV(String csv_filepath){
    	String[][] data = null;
		try {
    		String line = ""; String splitBy = ",";
			BufferedReader br = new BufferedReader(new FileReader(csv_filepath));
			br.readLine();
			int line_index = 0;
			while ((line = br.readLine()) != null){  
				String [] data_obj = line.split(splitBy);
				data[line_index] = data_obj;
				line_index++;
			}
			br.close();
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
    }
    
    void print_2D_array(String[][] data) {
    	for (int row = 0; row < data..; row++)
    	{
    		String [] data_row = data[row];
    		for (int column = 0; )
    	}
    } */
}
