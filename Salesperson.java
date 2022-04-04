import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Salesperson {
	int salesperson_id;
    String salesperson_name;
   	float commission_rate;
   	LinkedHashMap<Integer,Float> commissionsToPay;
   	float total_commission_earned;
   	float total_sales_made;

   	Salesperson(int salesprsn_id) throws Exception{
   		this.salesperson_id = salesprsn_id;
   		String[] searched_salesprsn = null;
   		this.commissionsToPay = new LinkedHashMap<Integer, Float>();
   		try {
   			String line = ""; String splitBy = ",";
   			BufferedReader br = new BufferedReader(new FileReader("Salesperson_List.csv"));
   			br.readLine();
   			//List<String> found_product = Collections.emptyList();
   			while ((line = br.readLine()) != null){  
  				searched_salesprsn = line.split(splitBy);
   				//System.out.println("Product [ID = " + product[0] + ", Name = " + product[1] + "]");
   				if (Integer.parseInt(searched_salesprsn[0]) == salesprsn_id) {
   					this.salesperson_name = searched_salesprsn[1];
   					this.commission_rate = Float.parseFloat(searched_salesprsn[2]);
   					this.total_commission_earned = Float.parseFloat(searched_salesprsn[3]);
   					this.total_sales_made = Float.parseFloat(searched_salesprsn[4]);
   				}
   			}
   			if (this.salesperson_name == null) {
   				throw new SalesprsnNotFoundExcptn(String.format("Salesperson # %2d could not be found. Pls find another one.", salesprsn_id));
   			}
   			br.close();
   			//return found_product;
   			} catch (Exception e) {
   				// TODO Auto-generated catch block
   				System.out.println("Error: " + e);
   				throw e;
   			}
   		this.commissionsToPay = new LinkedHashMap<Integer,Float>();
   	}
   	/*
	int getID(){
   		return salesperson_id;
   	}

   	float getCommissionRate(){
       	return commission_rate;
   	}

   	void setCommissionRate(float commission)
   	{
       	commission_rate = commission;
   	}

   	void checkOffCommission(int invoice_id){

    }
	
/*
   	HashMap<int,float> getCommissionsToPay(){

    }

   	float getCommissionEarned(){
       	return total_commission_earned;
   	}
*/
   	void addSalesMade(float sale){
       	this.total_sales_made += sale;
   	}
/*
   	float getTotalSalesMade() {

    }
*/
   	void addCommission(int invoice_id, float sale_commission){
   		this.commissionsToPay.put(invoice_id, sale_commission);
   		this.total_commission_earned += sale_commission;
   	}
	
   	@Override
   	public String toString() {
   		return String.format("Salesperson [ID = %2d, Name = %20s, "
   			+ "Commission Rate = %3d%%, Total Commission Earned "
   			+ "= $%4.2f, Total Sales Made = $%4.2f]", this.salesperson_id,
   			this.salesperson_name, this.commission_rate,
   			this.total_commission_earned, this.total_sales_made);
   	}
	
}
