//package org.junit.jupiter.api;

import static org.junit.jupiter.api.Assertions.*;
/*
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
*/
import java.util.ArrayList;

//import org.junit.jupiter.api.Test;
import org.junit.Test;

import junit.runner.Version;

public class InventoryLookupTest {
	@Test
	public void findOtherExistingValues() {
		Store_System system = new Store_System();
		String search_term = "900";
		ArrayList<Product> found_prdcts = system.findProducts(search_term);
		system.displaySearchedProducts(search_term, found_prdcts);
	}	
	
	@Test
	public void findNonExistingValues() {
		Store_System system = new Store_System();
		String search_term = "8000";
		ArrayList<Product> found_prdcts = system.findProducts(search_term);
		system.displaySearchedProducts(search_term, found_prdcts);
	}	
	
	@Test
	public void findExistingProduct() {  
		Store_System system = new Store_System();
		String search_term = "Sony";
		ArrayList<Product> found_prdcts = system.findProducts(search_term);
		system.displaySearchedProducts(search_term, found_prdcts);
	}
	
	@Test
	public void findNonExistingProduct() {
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