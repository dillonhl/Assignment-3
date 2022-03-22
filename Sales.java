public class Sales {
    int productID;
    string productName;
    float sellingPrice;
    float retailPrice;
    float unitprofit;
    int quantitySold;
    float totalSales;
    float totalCost;
    float totalProfit;
    float totalProfitPercent;

	string getProductName(){
		return this.productName;
	}

	float getSellingPrice(){
		return this.sellingPrice;
	}

	float getRetailPrice(){
		return this.retailPrice;
	}

	integer getQuantitySold(){
		return this.quantitySold;
	}

	float getTotalSales(){
		return this.totalSales;
	}

	float getTotalCost(){
		return this.totalCost;
	}

	float getTotalProfit(){
		return this.totalProfit;
	}

	float getTotalProfitPercent(){
		return this.totalProfitPercent;
	}
}
