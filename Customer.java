import java.io.BufferedReader;
import java.io.FileReader;

public class Customer {
    int customer_id;
    String customer_name;
    String customer_address;
    int phone_number;
    float sales_tax;

    public Customer(int cust_id) throws Exception {
        this.customer_id = cust_id;
        String[] searched_customer = null;
		try {
    		String line = ""; String splitBy = ",";
			BufferedReader br = new BufferedReader(new FileReader("Customer_List.csv"));
			br.readLine();
			while ((line = br.readLine()) != null){  
				searched_customer = line.split(splitBy);
				if (Integer.parseInt(searched_customer[0]) == cust_id) {
					this.customer_name = searched_customer[1];
					this.customer_address = searched_customer[2];
					this.phone_number = Integer.parseInt(searched_customer[3]);
					this.sales_tax = Float.parseFloat(searched_customer[4]);
				}
			}
			br.close();
			if (this.customer_name == null) {
				throw new CustNotFoundExcptn(String.format("Customer # %2d could not be found. Pls enter another customer.",  cust_id));
			}
    	} catch (Exception e) {
			System.out.println("Error: " + e);
			throw e;
		}
    }
}
