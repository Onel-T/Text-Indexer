/**
 * LinePosition Class
 * Description: Tracks line num and poition of a word
 * @author Onel Toma
 * @version 05/18/20
 */

public class LinePosition implements Comparable{
	private int lineNumber = 0;
	private int position = 0;
	
	/**
	 * Constructor takes in line number and position
	 * @param lineNum line number word was found on
	 * @param pos position in the line word was found in
	 */
	public LinePosition (int lineNum, int pos) {
		lineNumber = lineNum;
		position = pos;
	}
	
	/**
	 * Getter for line number
	 * @return line number
	 */
	public int getLineNumber() {
		return lineNumber;
	}
	
	/**
	 * Getter for positions
	 * @return position
	 */
	public int getPosition() {
		return position;
	}
	
	/**
	 * Gets line number and position in a format
	 * @return formatted line-position
	 */
	public String getLinePos() {
		return String.format("%d-%d", lineNumber, position);
	}
	
	/**
	 * Orders the line position linked list in word from least to greatest
	 */
	public int compareTo(Object o) {
	LinePosition lp = (LinePosition) o;
	int result = 0;
	
		if(this.lineNumber > lp.lineNumber)
		{
			result = 1;
		}
		else if (this.lineNumber < lp.lineNumber) 
		{
			result = -1;
		}
		else if (this.lineNumber == lp.lineNumber)
		{
			if (this.position > lp.position) 
			{
				result = 1;
			}
			else
			{
			 result = -1;	
			}
		}
		
		return result;
	}
}
