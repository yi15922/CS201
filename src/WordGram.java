import java.util.ArrayList;

/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author Yi Chen
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		myToString = null;
		myHash = 0;

		int counter = 0;
		for (int i = start; i < start + size; i++) {
			myWords[counter] = source[i];
			counter += 1;
		}
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Returns the number of words stored in myWords.
	 * @return int of length
	 */
	public int length(){

		return myWords.length;
	}


	/**
	 * A boolean that returns false when the object passed
	 * is not a WordGram object or if the object's myWords array
	 * is different from the myWords array of this object.
	 * @param o an Object of type WordGram
	 * @return boolean value
	 */
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}

		WordGram wg = (WordGram) o;

		int counter = 0;
		for (String word : wg.myWords) {
			//System.out.println(word + wg.myWords[counter]);
			if (!word.equals(myWords[counter]) || wg.length() != myWords.length) {
				return false;
			}
			counter += 1;
		}

		// TODO: Complete this method

		return true;
	}

	/**
	 * Overrides the hashCode() method and returns the
	 * hash code of the string returned by toString(), stored
	 * in myHash.
	 * @return The hashcode that has been stored to myHash.
	 */
	@Override
	public int hashCode(){
		myHash = this.toString().hashCode();

		return myHash;
	}
	

	/**
	 * Creates a new WordGram that removes the first word of this
	 * WordGram and appends string last at the end.
	 * @param last is last String of returned WordGram
	 * @return the new WordGram.
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);


		int counter = 0;

		for (int i = 1; i < myWords.length; i++) {
			wg.myWords[counter] = myWords[i];
			counter += 1;
		}

		wg.myWords[wg.length()-1] = last;
		return wg;
	}


	/**
	 * Overrides the toString method and returns a string representing
	 * all strings stored in WordGram, stored in myToString.
	 * @return A string representing all strings in WordGram, stored in
	 * myToString.
	 */
	@Override
	public String toString(){
		myToString = String.join(" ", myWords);
		return myToString;
	}


}
