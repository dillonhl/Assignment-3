import java.util.LinkedHashMap;

/**
 * 
 */

/**
 * @author mslaw
 *
 */
public final class InvoiceCreator {
	private static final QtyChkr qty_chkr = new QtyChkr();
	
	InvoiceCreator() {

	}
	
	Invoice createInvoice(Customer customer, Salesperson salesperson, LinkedHashMap<Product, Integer> ordered_products, int delivery) throws Exception{
    	try {
			qty_chkr.qtyChk(ordered_products);
		} catch (Exception e) {
			System.out.println("Error: " + e);
			throw e;
		}    	
    	Invoice invoice = new Invoice(customer, salesperson, ordered_products, delivery);
    	return invoice;
    }
}
