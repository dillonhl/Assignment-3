import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVManager {
	public void displayProducts(){
    	try {
    		String line = "";
    		String splitBy = ",";
   			BufferedReader br = new BufferedReader(new FileReader("Product_List.csv"));
   			br.readLine();
   			while ((line = br.readLine()) != null){  
   				int product_id = Integer.parseInt(line.split(splitBy)[0]);
   				Product product = new Product(product_id);
   				System.out.println(product);
   			}
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void displaySearchedProducts(String searchTerm, ArrayList<Product> products) {
    	Iterator<Product> iter = products.iterator();
    	System.out.println("Products with a field that contains " + searchTerm + ":");
    	while(iter.hasNext()) {
    		System.out.println(iter.next());
    	}
    }
	
	public void initInvoices() {
    	try {
    		FileWriter invcestrm = new FileWriter("Invoice_List.csv");
    		PrintWriter invceInit = new PrintWriter(invcestrm);
    		String [] invoice_hdrs = {"Invoice ID", "Invoice Creation Date",
    				"Invoice Closed Date", "Salesperson ID", 
    				"Salesperson Name", "Customer ID", "Customer Name", 
    				"Customer Address", "Customer Sales Tax %",
    			    "Ordered Products", "Total Quantity", "Pretax Sales Total", 
    			    "Sales Tax Amount", "Delivery Charge", "Total Amount", 
    			    "Remaining Balance", "Discount", "Finance Charge"};
    		String invoice_str = convertToCSV(invoice_hdrs);
    		invceInit.write(invoice_str);
    		invceInit.println();
    		invceInit.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public ArrayList<Product> findProducts(String search_term) {
    	ArrayList<Product> found_product_list = new ArrayList<Product>();
    	String[] searched_product = null;
		try {
    		String line = ""; String splitBy = ",";
			BufferedReader br = new BufferedReader(new FileReader("Product_List.csv"));
			br.readLine();
			while ((line = br.readLine()) != null){  
				searched_product = line.split(splitBy);
				for(int i=0; i<searched_product.length; i++) {
					String searched_keyword = searched_product[i];
					if (searched_keyword.contains(search_term)) {
						int found_product_id = Integer.parseInt(searched_product[0]);
						Product found_product = new Product(found_product_id);
						found_product_list.add(found_product);
					}
				}
			}
			br.close();
    	} catch (Exception e) {
			e.printStackTrace();
		}
		return found_product_list;
    }
	
	public String convertToCSV(String[] data) {
    	return Stream.of(data).map(this::escapeSpclChars).collect(Collectors.joining(","));
    }
    
    public String escapeSpclChars(String data) {
    	String escpdData = data.replaceAll("\\R", "");
    	if (data.contains(",") || data.contains("\"") || data.contains("'")) {
    		data = data.replace("\"", "\"\"");
    		escpdData = "\"" + data + "\"";
    	}
    	return escpdData;
    }
}