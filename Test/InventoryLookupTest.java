//import static org.junit.jupiter.api.Assertions.*;
/*
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
*/
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import junit.runner.Version;

class InventoryLookupTest {
	@Test
	void findOtherExistingValues() {
		Store_System system = new Store_System();
		String search_term = "900";
		ArrayList<Product> found_prdcts = system.findProducts(search_term);
		system.displaySearchedProducts(search_term, found_prdcts);
	}	
	
	@Test
	void findNonExistingValues() {
		Store_System system = new Store_System();
		String search_term = "8000";
		ArrayList<Product> found_prdcts = system.findProducts(search_term);
		system.displaySearchedProducts(search_term, found_prdcts);
	}	
	
	@Test
	void findExistingProduct() {  
		Store_System system = new Store_System();
		String search_term = "Sony";
		ArrayList<Product> found_prdcts = system.findProducts(search_term);
		system.displaySearchedProducts(search_term, found_prdcts);
	}
	
	@Test
	void findNonExistingProduct() {
		Store_System system = new Store_System();
		String search_term = "Disney";
		ArrayList<Product> found_prdcts = system.findProducts(search_term);
		system.displaySearchedProducts(search_term, found_prdcts);
	}
	/*
	@Test
	void printJunitVersion() {
		System.out.println("JUnit version is: " + Version.id());
	}
	*/
}