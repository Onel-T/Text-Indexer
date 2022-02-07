import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Query Class
 * Description: Creates binary tree and runs other processes for program
 * @author Onel Toma
 * @version 05/18/20
 */

public class Query {
	private PrintWriter pw;
	private Scanner fileScan;
	private String delims = "[ ]+";
	private String line;
	private Hash hash;
	private ObjectBinaryTree wordTree;
	
	/**
	 * Constructor takes in printwriter and filescanner. Also runs class methods.
	 * @param printWriter printwriter from Xref (csis.txt)
	 * @param fileScanner (getty.txt) from Xref
	 * @throws IOException
	 */
	public Query(PrintWriter printWriter, Scanner fileScanner) throws IOException {
		pw = printWriter;
		fileScan = fileScanner;
		hash = new Hash(printWriter);
		wordTree = new ObjectBinaryTree();
		
		createTree();
		traverseTree();
		searchWord();
	}
	
	/**
	 * Creates the tree of words from getty.txt and prints line number and line
	 */
	private void createTree() {
		int lineCount = 0;
		int wordPos = 0;
		String word = "";
		
		while (fileScan.hasNextLine())
		{
			String[] tokens;

			++lineCount;
			line = fileScan.nextLine();
			System.out.printf( "%2d: %s\n", lineCount, line );
			pw.printf( "%2d: %s\n", lineCount, line );

			tokens = line.split( delims );

			for (int i = 0; i < tokens.length; i++) // Goes through each token in line
			{
				String cleanedWord = "";
				
				wordPos = ( i+1 );
				word = tokens[i].toLowerCase();
				
				for (int j = 0; j < word.length(); j++) // Removes punctuation
				{	
					if( word.charAt(j) >= 97 && word.charAt(j) <= 122 )
					{
						cleanedWord += word.charAt(j);
					}
					else if ( word.charAt(0) == '-' ) //THIS IS STILL BROKEN b/c ++wordpos
					{
						cleanedWord = "a"; // unimportant word
					}
				}
				
				if( hash.isImportant(cleanedWord) == true) // Checks importance
				{
					wordTree.insertBSTDup(new Word(pw,
							cleanedWord, lineCount, wordPos));
				}
			}
		}
	}
	
	/**
	 * Does an inorder traversal of the tree and will display results
	 */
	private void traverseTree() {
		wordTree.inTrav(wordTree.getRoot());
	}
	
	/**
	 * Allows the user to search for a word in the tree. Displays results.
	 */
	private void searchWord() {
		Scanner keyboard = new Scanner(System.in);
		String word = "";
		ObjectTreeNode foundNode;
		Word foundWord;
		
		System.out.println();
		while(word.equals("0") != true)
		{
			System.out.println();
			System.out.print("Search Word (enter 0 to exit): ");
			pw.println();
			pw.print("Search Word (enter 0 to exit): ");
			word = keyboard.nextLine();	
			pw.print(word);
			pw.println();
			
			if (word.equals("0")) 
			{
				System.out.println("Exited");
				pw.println("Exited");
			}
			else 
			{
				foundNode = wordTree.searchBST(new Word(word));
				
				if(foundNode != null)
				{
					foundWord = (Word) foundNode.getInfo();
					foundWord.visit();
				}
				else 
				{
					System.out.println("Word does not exist");
					pw.println("Word does not exist");
				}
			}
		}
		
		keyboard.close();
	}
}
