import java.util.HashMap;

public class Salesperson {
    private int salesperson_id;
    String salesperson_name;
    float commission_rate;
    HashMap<int,float> commissionsToPay;
    float total_commissioned_earned;
    float total_sales_made;

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
*/
    float getCommissionEarned(){
        return total_commissioned_earned;
    }

    void addSalesMade(float sale){
        total_sales_made += sale;
    }

    float getTotalSalesMade() {

    }

    void addCommission(int invoice_id){

    }
}
