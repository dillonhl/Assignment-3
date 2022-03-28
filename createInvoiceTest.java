import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

class createInvoiceTest {

	@Test
	void test() {
		Store_System system = new Store_System();
		LinkedHashMap<Product, Integer> ordered_products_1 = new LinkedHashMap<>();
		ordered_products_1.put(new Product(1), 1);
		ordered_products_1.put(new Product(2), 2);
		ordered_products_1.put(new Product(3), 3);
		ordered_products_1.put(new Product(4), 5);
		ordered_products_1.put(new Product(5), 3);
		ordered_products_1.put(new Product(6), 1);
		Invoice invoice = system.createInvoice(1, new Customer(1), new Salesperson(1), ordered_products_1, 0);
		//System.out.println()
		invoice.printInvoice();
	}

}
