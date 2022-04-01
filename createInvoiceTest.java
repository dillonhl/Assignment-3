import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

class createInvoiceTest {

	@Test
	void test() {
		Store_System system = new Store_System();
		Customer cust = new Customer(1);
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
	}

}
