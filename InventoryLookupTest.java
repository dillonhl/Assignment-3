import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class InventoryLookupTest {

	@Test
	void test() {
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
	}
}