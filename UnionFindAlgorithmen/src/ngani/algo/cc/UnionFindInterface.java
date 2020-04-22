/**
 * 
 */
package ngani.algo.cc;

/**
 * @author Diane Ngani
 *
 */
public interface UnionFindInterface {
	
	/**
	 * Initialize an array with the given length and fill it with numbers from 0 to {@code numberOfNodes}
	 * @param numberOfNodes
	 * 
	 */
	public void initialize(int numberOfNodes);
	
	/**
	 * @param node
	 * @return It returns the value of the array saved on index {@code node}
	 * @throws ArrayIndexOutOfBoundsException 
	 */
	public int find(int node) throws ArrayIndexOutOfBoundsException;
	
	/**
	 * Change the set name of all elements existing in the first and second sets to the third name.
	 * At the end, all elements must in the same set.
	 * @param setNameOne
	 * @param setNameTwo 
	 * @param newSetName The name of the new set which contains ...
	 * @return the total number of names changes / swaps that have been done.
	 */
	public int union(int setNameOne, int setNameTwo, int newSetName);
	
}
