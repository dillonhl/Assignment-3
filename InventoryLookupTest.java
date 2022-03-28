import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class InventoryLookupTest {

	@Test
	void test1() {  
		Store_System system = new Store_System();
		String search_term = "Sony";
		ArrayList<Product> found_prdcts = system.find_search_results(search_term);
		system.displaySearchedProducts(search_term, found_prdcts);
	}
	
	@Test
	void test2() {
		Store_System system2 = new Store_System();
		String search_term2 = "Disney";
		ArrayList<Product> found_prdcts2 = system2.find_search_results(search_term2);
		system2.displaySearchedProducts(search_term2, found_prdcts2);
	}
}