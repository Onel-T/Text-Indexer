import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Project Title: TomaOnel - Binary Trees Lab
 * Project Description: Reads the getty.txt and creates a searchable 
 * 						cross referance listing of all the words
 * Version or Date: 05/18/20
 * How to Start the Project: The driver class is made to create a setup for the rest 
 * 							 of the program. Other classes are then created to 
 * 							 follow the driver class.
 * Author: Onel Toma
 * Palomar ID: 011925847
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
