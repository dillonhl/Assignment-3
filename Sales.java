import java.lang.*;

public class Sales {
    int productID;
    String serialNumber;
    String productName;
    float sellingPrice;
    float retailPrice;
    float unitProfit;
    int totalQuantitySold;
    float totalSales;
    float totalCost;
    float totalProfit;
    float totalProfitPercent;

    Sales(Product prdct){
    	this.productID = prdct.product_ID;
    	this.serialNumber = prdct.serial_number;
    	this.productName = prdct.product_name;
    	this.sellingPrice = prdct.selling_price;
    	this.retailPrice = prdct.retail_price;
    	this.unitProfit = this.sellingPrice - this.retailPrice;
    	this.totalQuantitySold = 0;
    	this.totalSales = 0;
    	this.totalCost = prdct.retail_price * prdct.inv_quantity;
    	updateTotalProfit();
    }
    
    void addSales(int qtySold) {
    	this.totalQuantitySold += qtySold;
    	float prod_sale_amt = qtySold * this.sellingPrice;
    	this.totalSales += prod_sale_amt;
    	updateTotalProfit();
    }
    
    void updateTotalProfit() {
    	this.totalProfit = this.totalSales - this.totalCost;
    	this.totalProfitPercent = ((this.totalProfit * 100) / this.totalCost);
    }
    
    @Override
    public String toString() {
    	return String.format("Sales [Product ID = %2d, Product Serial Number = %9s, Product Name = %13s, "
    					   + "Selling Price = $%4.2f, Cost Price = $%4.2f, Unit Profit = $%4.2f, "
    					   + "Total Quantity Sold = %2d, Total Sales = $%4.2f, Total Cost = $%4.2f, "
    					   + "Total Profit = $%4.2f, Total Profit Percent = %4.2f%%]", this.productID, 
    					   this.serialNumber, this.productName, this.sellingPrice, this.retailPrice, 
    					   this.unitProfit, this.totalQuantitySold, this.totalSales, this.totalCost,
    					   this.totalProfit, (this.totalProfitPercent/100));
    }
}
