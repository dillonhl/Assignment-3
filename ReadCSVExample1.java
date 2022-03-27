import java.io.*;  
import java.util.Scanner;
public class ReadCSVExample1 {
	public static void main(String[] args) throws Exception{  
		//parsing a CSV file into Scanner class constructor  
		System.out.println("ReadCSVExample1's Working Directory = " + System.getProperty("user.dir"));
		Scanner sc = new Scanner(new File("Product_List_Test_for_Java_CSV.csv"));  
		sc.useDelimiter(",");   //sets the delimiter pattern  
		while (sc.hasNext())  //returns a boolean value  
			{  
			System.out.print(sc.next() + ",  ");  //find and returns the next complete token from this scanner  
			}   
		sc.close();  //closes the scanner  
	}  
}
