import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

class createInvoiceTest {

	Store_System system = new Store_System();
	int num_of_custs = 5;
	int num_of_salesppl = 2;
	@Test
	void test() {
		try {
			//Store_System system = new Store_System();
			Customer cust = new Customer(2);
			Salesperson salesprsn = new Salesperson(1);
			LinkedHashMap<Product, Integer> ordered_products_1 = new LinkedHashMap<>();
			ordered_products_1.put(new Product(1001), 1);
			ordered_products_1.put(new Product(1002), 2);
			ordered_products_1.put(new Product(1003), 3);
			ordered_products_1.put(new Product(1004), 5);
			ordered_products_1.put(new Product(1005), 3);
			ordered_products_1.put(new Product(1006), 1);
			Invoice invoice = system.createInvoice(1, cust, salesprsn, ordered_products_1, 1);
			//System.out.println()
			invoice.printInvoice();
			//Save invoice, update sales and inventory, record commission for salesperson, etc.
			system.saveInvoice(invoice);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void test2() {
		try {
			//Store_System system = new Store_System();
			Customer cust2 = new Customer(1);
			Salesperson salesprsn2 = new Salesperson(2);
			LinkedHashMap<Product, Integer> ordered_products_2 = new LinkedHashMap<>();
			ordered_products_2.put(new Product(1004), 6);
			ordered_products_2.put(new Product(1003), 3);
			Invoice invoice2 = system.createInvoice(2, cust2, salesprsn2, ordered_products_2, 0);
			invoice2.printInvoice();
			system.saveInvoice(invoice2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void test3_TooBigOfAnOrder() {
		try {
			Customer cust3 = new Customer(3);
			Salesperson salesprsn3 = new Salesperson(1);
			LinkedHashMap<Product, Integer> ordered_products_3 = new LinkedHashMap<>();
			ordered_products_3.put(new Product(1001), 4);
			assertThrows(ExcsveQtyException.class, ()->{Invoice invoice3 = system.createInvoice(2, cust3, salesprsn3, ordered_products_3, 1);});

			//invoice3.printInvoice();
			//system.saveInvoice(invoice3);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void test4_NegativeOrder() {
		try {
			Customer cust4 = new Customer(4);
			Salesperson salesprsn4 = new Salesperson(2);
			LinkedHashMap<Product, Integer> ordered_products_4 = new LinkedHashMap<>();
			ordered_products_4.put(new Product(1002), -4);
			assertThrows(NegQtyException.class, ()->{Invoice invoice4 = system.createInvoice(2, cust4, salesprsn4, ordered_products_4, 0);});
			//invoice4.printInvoice();
			//system.saveInvoice(invoice4);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test5_invalid_cust() {
		try {
			assertThrows(CustNotFoundExcptn.class, ()->{Customer cust5 = new Customer(10);});
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Test
	void test6_invalid_salesprsn() {
		try {
			assertThrows(SalesprsnNotFoundExcptn.class, ()->{Salesperson salesprsn5 = new Salesperson(7);});
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	@Test
	void test7_invalid_product() {
		try {
			assertThrows(ProductNotFoundException.class, ()->{Product product11 = new Product(1234);});
		}catch (Exception e) {
			System.out.println("Error: "+ e);
		}
	}
}