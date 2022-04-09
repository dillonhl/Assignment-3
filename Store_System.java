import java.io.*;
import java.util.*;

public class Store_System {
	private String password;
	public LinkedHashMap<Integer, Product> products;
	private CSVManager csvMngr;
	
	Store_System(){
		this.password = "awesome_system_150%";
		this.products = new LinkedHashMap<Integer, Product> ();
		this.csvMngr = new CSVManager();
		importProducts();
		this.csvMngr.initInvoices();
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
			e.printStackTrace();
		}
    }
    
	public ArrayList<Product> findProducts(String searchTerm) {
		return this.csvMngr.findProducts(searchTerm);
	}


	public void displaySearchedProducts(String searchTerm, ArrayList<Product> foundPrdcts) {
		this.csvMngr.displaySearchedProducts(searchTerm, foundPrdcts);
	}
}
