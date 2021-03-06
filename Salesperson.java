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
   			while ((line = br.readLine()) != null){  
  				searched_salesprsn = line.split(splitBy);
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
   			} catch (Exception e) {
   				System.out.println("Error: " + e);
   				throw e;
   			}
   		this.commissionsToPay = new LinkedHashMap<Integer,Float>();
   	}

   	void addSalesMade(float sale){
       	this.total_sales_made += sale;
   	}

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
