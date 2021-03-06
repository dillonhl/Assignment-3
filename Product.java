import java.io.BufferedReader;
import java.io.FileReader;

public class Product {
	int product_ID;
    String serial_number;
    String product_name;
    int warehouse_num;
    int inv_quantity;
    float selling_price;
    float retail_price;

    Product(int product_id) throws Exception{
    	this.product_ID = product_id;
    	String[] searched_product = null;
		try {
    		String line = ""; String splitBy = ",";
			BufferedReader br = new BufferedReader(new FileReader("Product_List.csv"));
			br.readLine();
			while ((line = br.readLine()) != null){  
				searched_product = line.split(splitBy);
				if (Integer.parseInt(searched_product[0]) == product_id) {
					this.serial_number = searched_product[1];
					this.product_name = searched_product[2];
					this.warehouse_num = Integer.parseInt(searched_product[3]);
					this.inv_quantity = Integer.parseInt(searched_product[4]);
					this.selling_price = Float.parseFloat(searched_product[5]);
					this.retail_price = Float.parseFloat(searched_product[6]);
				}
			}
			br.close();
			if (this.product_name == null) {
				throw new ProductNotFoundException(String.format("Product # %4d could not be found. Pls try another product.", product_id));
			}
    	} catch (Exception e) {
			System.out.println("Error: " + e);
			throw e;
		}
    }

    @Override
    public String toString() {
    	return String.format("Product [ID = %2d, Serial Number = %9s, Name = %13s, Warehouse # = %2d, Total Quantity = %2d, "
    						+ "Selling Price = $%3.2f, Cost Price = $%3.2f]", this.product_ID, this.serial_number, this.product_name, 
    						this.warehouse_num, this.inv_quantity, this.selling_price, this.retail_price);
    }
}
