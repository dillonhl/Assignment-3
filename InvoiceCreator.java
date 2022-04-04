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
	
	Invoice createInvoice(int invoice_id, Customer customer, Salesperson salesperson, LinkedHashMap<Product, Integer> ordered_products, int delivery) throws Exception{
    	try {
			qty_chkr.qtyChk(ordered_products);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " + e);
			throw e;
		}    	
    	Invoice invoice = new Invoice(invoice_id, customer, salesperson, ordered_products, delivery);
    	//Invoice creation will also calculate more attributes for invoice, like total amount.
    	return invoice;
    }
}
