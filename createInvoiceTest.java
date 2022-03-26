import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.*;

class createInvoiceTest {

	@Test
	void test1() {
		System system = new System();
		Map<Integer, Integer> ordered_products_1 = new HashMap<>();
		ordered_products_1.put(1, 1);
		/*
		ordered_products_1.put(2, 2);
		ordered_products_1.put(3, 3);
		ordered_products_1.put(4, 5);
		ordered_products_1.put(5, 3);
		ordered_products_1.put(6, 1);
		*/
		Invoice invoice = system.createInvoice(0, 0, ordered_products_1, 0);
		invoice.printInvoice();
	}

}
