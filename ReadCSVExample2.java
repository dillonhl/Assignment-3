import java.io.*;  
//import com.opencsv.CSVReader;
public class ReadCSVExample2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("ReadCSVExample2's Working Directory = " + System.getProperty("user.dir"));
		String line = "";
		String splitBy = ",";
		try{  
			//parsing a CSV file into BufferedReader class constructor
			//System.out.println("ReadCSVExample2's Working Directory = " + System.getProperty("user.dir"));
			BufferedReader br = new BufferedReader(new FileReader("Customer_List.csv"));    
			//reads one line at a time  
			br.readLine();
			while ((line = br.readLine()) != null){  
				String[] customer = line.split(splitBy);
				System.out.println("Customer [ID = " + customer[0] + 
									", Name = " + customer[1] + 
									", Address = " + customer[2] + 
									", Phone Number = " + customer[3] + 
									", Sales Tax = " + customer[4] + "%]");  
			}  
		}catch (Exception e){  
			e.printStackTrace();  
		} 
	}
}