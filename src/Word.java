import java.io.PrintWriter;

/**
 * Word Class
 * Description: Has the information for a word
 * @author Onel Toma
 */

public class Word implements TreeComparable{
	private String word;
	private int wordCount;
	private PrintWriter pw;
	private ObjectList wordList;
	private LinePosition linePosition;
	
	/**
	 * Constructor for word class
	 * @param printWriter sent in from Query
	 * @param word the word given
	 * @param lineNum the line number word was found on
	 * @param pos the position on the line the word was found on
	 */
	public Word(PrintWriter printWriter, String word, int lineNum, int pos) {
		this.word = word;
		wordList = new ObjectList();
		wordCount = 1;
		pw = printWriter;
		linePosition = new LinePosition(lineNum, pos);
	}
	
	/**
	 * Constructor for when the word is being searched
	 * @param word the word being searched
	 */
	public Word(String word) {
		this.word = word;
	}

	/**
	 * For a word that has re occurred.
	 * Increments wordCount, adds line num and pos to linked list
	 * @param o the word that has made another appearance
	 */
	public void operate(Object o) {
		++wordCount;
		Word word = (Word) o;
		wordList.insert(new LinePosition(word.linePosition.getLineNumber(),
				word.linePosition.getPosition()));
	}

	/**
	 * Compares the word inside of two word objects
	 * @return the number based on comparison
	 */
	public int compareTo(Object o) {
		Word w = (Word) o;
		
		int result = this.word.compareTo( w.word );
		
		return result;
	}

	/**
	 * Outputs word, line pos, and position in a nice format
	 */
	public void visit() {
		ObjectListNode head = wordList.getFirstNode();
		
		System.out.println();
		System.out.printf( String.format( "%-14s%-5d%-7s", word, wordCount,
				linePosition.getLinePos()));
		
		pw.println();
		pw.printf( String.format( "%-14s%-5d%-7s", word, wordCount,
				linePosition.getLinePos()));
		
		while(head != null)
		{
			LinePosition tempLinePos;
			tempLinePos = (LinePosition) head.getInfo();
			
			System.out.printf( String.format( "%-7s", tempLinePos.getLinePos()));
			pw.printf( String.format( "%-7s", tempLinePos.getLinePos()));
			head = head.getNext();
		}
		System.out.println();
		pw.println();
	}

}
