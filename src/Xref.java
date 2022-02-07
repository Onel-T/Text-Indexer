import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Project Description: Reads the getty.txt and creates a searchable 
 * 						cross referance listing of all the words
 * 							 follow the driver class.
 * Author: Onel Toma
 * User Instructions: The user will be prompted to search words
 * 
 * Driver Class
 * Description: Uses main() in order to run the program
 * @author Onel Toma
 */

public class Xref {
	public static void main(String[] args) throws IOException{
		PrintWriter pw = new PrintWriter(new FileWriter("csis.txt")); 
		Scanner fileScan = new Scanner(new File("getty.txt"));
		Query query = new Query(pw, fileScan);
		
		fileScan.close();
		pw.close();
	}

}
