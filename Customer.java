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
			//List<String> found_product = Collections.emptyList();
			while ((line = br.readLine()) != null){  
				searched_customer = line.split(splitBy);
				//System.out.println("Product [ID = " + product[0] + ", Name = " + product[1] + "]");
				if (Integer.parseInt(searched_customer[0]) == cust_id) {
					this.customer_name = searched_customer[1];
					this.customer_address = searched_customer[2];
					this.phone_number = Integer.parseInt(searched_customer[3]);
					this.sales_tax = Float.parseFloat(searched_customer[4]);
				}
			}
			if (this.customer_name == null) {
				throw new CustNotFoundExcptn(String.format("Customer # %2d could not be found. Pls enter another customer.",  cust_id));
			}
			br.close();
			//return found_product;
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " + e);
			throw e;
		}
        /*
    	customer_name = name;
        customer_address = address;
        phone_number = phone;
        sales_tax = tax;
        */
    }

    int getID(){
        return customer_id;
    }

    String getCustomerName() {
        return customer_name;
    }

    String getCustomerAddress() {
        return customer_address;
    }

    void setPhone(int phone){
        phone_number = phone;
    }
    
    int getPhone(){
        return phone_number;
    }
    
    void setSalesTax(float salesTax){
        sales_tax = salesTax;
    }
    
    float getSalesTax(){
        return sales_tax;
    }
    

}
