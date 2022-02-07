import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Hash Class
 * Description: Creates the hash table and contains hash function
 * @author Onel Toma
 */

public class Hash {
	private int tableSize = 37;
	private String[] hashTable = new String[tableSize];
	private PrintWriter pw;
	private Scanner fileScan;
	private String word;
	
	/**
	 * Constructor for Hash takes in printwriter and calls class methods
	 * @param printWriter
	 * @throws IOException
	 */
	public Hash(PrintWriter printWriter) throws IOException {
		pw = printWriter;
		printDescription();
		createHashTable();
		displayTable();
		displayLoadFactor();
	}
	
	/**
	 * Creates hash table using linear probing and prints collision stats
	 * @throws IOException
	 */
	private void createHashTable() throws IOException{
		fileScan = new Scanner(new File( "unimportant.txt" ));
		
		int hashValue = 0;
		int hashCollisions = 0;
		int resolutionCollisions = 0;
		int totalCollisions = 0;

		for (int i = 0; i < 27; i++)
		{
			word = fileScan.nextLine();
			hashValue = getHash( word );
			
			if( hashTable[hashValue] == null )
			{
				hashTable[hashValue] = word;
			}
			else // linear probe
			{
				hashCollisions++;
				hashValue = ( hashValue + 1 ) % tableSize;
				
				while( hashTable[hashValue] != null )
				{
					hashValue = ( hashValue + 1 ) % tableSize;
					resolutionCollisions++;
				}
			
				hashTable[hashValue] = word;
			}
			
		}
		
		totalCollisions += ( hashCollisions + resolutionCollisions );
		
		System.out.println("\nCollision Stats:");
		System.out.printf( "Hash Function Collisions: %d\n", hashCollisions );
		System.out.printf( "Resolution Collisions: %d\n", resolutionCollisions );
		System.out.printf( "Total Collisions: %d\n", totalCollisions );
		
		pw.println("\nCollision Stats:");
		pw.printf( "Hash Function Collisions: %d\n", hashCollisions );
		pw.printf( "Resolution Collisions: %d\n", resolutionCollisions );
		pw.printf( "Total Collisions: %d\n", totalCollisions );
		
		fileScan.close();
	}
	
	/**
	 * Uses a hash function to get the hash key for a string
	 * @param s String that is sent in
	 * @return the hash value for the string
	 */
	private int getHash(String s) {
		String lowerS = s.toLowerCase();
		int stringValue = 0;
		
		for (int i = 0; i < s.length(); i++) 
		{
			stringValue += lowerS.charAt(i);
		}
		
		return ( stringValue * 83 ) % tableSize;
	}
	
	/**
	 * Checks the importance of a word by looking through hash table
	 * @param word the string to be checked
	 * @return true if important, false if not
	 */
	public boolean isImportant(String word) {
		
		int hashedWord = getHash(word);
		boolean bool = true;

		while (hashTable[hashedWord] != null)
		{
			if (word.equals(hashTable[hashedWord]))
			{
				bool = false;
				break;
			}
			else
			{
				hashedWord = (hashedWord + 1) % tableSize;
			}
		}

		return bool;
	}
	
	/**
	 * Prints a description of hash function
	 */
	public void printDescription() {
		System.out.println("Hash Function Description:");
		System.out.println("The hash function take the ascii value of each character"
				+ "\nand adds it to a total ascii value for the string."
				+ "\nThe total stringValue is then multiplied by 83 and then "
				+ "\nmodulo table size to get the value within range of the table.");
		
		pw.println("Hash Function Description:");
		pw.println("The hash function take the ascii value of each character"
				+ "\nand adds it to a total ascii value for the string."
				+ "\nThe total stringValue is then multiplied by 83 and then "
				+ "\nmodulo table size to get the value within range of the table.");
	}
	
	/**
	 * Displays the hash table
	 */
	public void displayTable() {
		System.out.println("\nDisplay of Hash Table:");
		pw.println("\nDisplay of Hash Table:");
		for (int i = 0; i < hashTable.length; i++) 
		{
			if (hashTable[i] == null)
			{
				System.out.print(String.format("%-3d%-8s\n", i, ""));
				pw.print(String.format("%-3d%-8s\n", i, ""));
			}
			else 
			{
				System.out.print(String.format("%-3d%-8s\n", i, hashTable[i]));
				pw.print(String.format("%-3d%-8s\n", i, hashTable[i]));
			}
			System.out.println();
			pw.println();
		}
	}
	
	/**
	 * Calculates load factor and displays it
	 */
	public void displayLoadFactor() {
		double loadFactor = 0;
		
		for (int i = 0; i < hashTable.length; i++) 
		{
			if (hashTable[i] != null) 
			{
				++loadFactor;
			}
		}
		
		loadFactor /= tableSize;
		
		System.out.printf("Load Factor: %.2f\n\n", loadFactor);
		pw.printf("Load Factor: %.2f\n\n", loadFactor);
	}
}
