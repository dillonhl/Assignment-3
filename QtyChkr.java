import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author mslaw
 *
 */
public final class QtyChkr {
	void qtyChk(LinkedHashMap<Product, Integer> ordered_products) throws Exception {
		// TODO Auto-generated method stub
    	for(Map.Entry<Product, Integer> entry : ordered_products.entrySet()) {
    		Product product = entry.getKey();
    		int ordered_qty = entry.getValue();
       		if (ordered_qty > product.inv_quantity) {
       			throw new ExcsveQtyException(String.format("Product ID # %2d of %13s only has %2d in the warehouses. Pls order a smaller number.", 
       					product.product_ID, product.product_name, product.inv_quantity));
       		}else if (ordered_qty < 0) {
       			throw new NegQtyException(String.format("%2d is below 0. Please order a quantity above 0.", ordered_qty));
       		}
    	}
	}
}
