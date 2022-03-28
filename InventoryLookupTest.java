import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class InventoryLookupTest {

	@Test
	void test() {
		//parsing a CSV file into Scanner class constructor  
		Store_System system = new Store_System();
		system.displayProducts();
	}
}