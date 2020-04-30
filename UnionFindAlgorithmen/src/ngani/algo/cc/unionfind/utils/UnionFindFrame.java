/**
 * 
 */
package ngani.algo.cc.unionfind.utils;

/**
 * @author Diane Ngani
 *
 */
public abstract class UnionFindFrame {
	
	/**
	 * A static final value representing the subclass with the same name. 
	 * Instead of using isInstanceof(), we just give this integer value as parameter.
	 */
	public static final int SIMPLE = 1;
	/**
	 * A static final value representing the subclass with a similar name. The full is RelabelTheSmallerHalf
	 * Instead of using isInstanceof(), we just give this integer value as parameter.
	 */
	public static final int RELABEL = 2;
	/**
	 * A static final value representing the subclass with the same name. 
	 * Instead of using isInstanceof(), we just give this integer value as parameter.
	 */
	public static final int SIMPLETREE = 3;
	/**
	 * A static final value representing the subclass with the same name. 
	 * Instead of using isInstanceof(), we just give this integer value as parameter.
	 */
	public static final int WEIGHTEDUNION = 4;
	/**
	 * A static final value representing the subclass with the same name. 
	 * Instead of using isInstanceof(), we just give this integer value as parameter. 
	 */
	public static final int PATHCOMPRESSION = 5;
	protected int NULL = -1;
	
	
	/**
	 * Initialize an array with the given length and fill it with numbers from 0 to {@code numberOfNodes}
	 * @param numberOfNodes
	 * 
	 */
	public abstract void initialize(int numberOfNodes);
	
	/**
	 * @param node
	 * @return It returns the value of the array saved on index {@code node}
	 * @throws ArrayIndexOutOfBoundsException 
	 */
	public abstract int find(int node) throws ArrayIndexOutOfBoundsException;
	
	/**
	 * Change the set name of all elements existing in the first and second sets to the third name.
	 * At the end, all elements must in the same set.
	 * @param setNameOne
	 * @param setNameTwo 
	 */
	public abstract void union(int setNameOne, int setNameTwo);
	
	/**
	 * Change the set name of all elements existing in the first and second sets to the third name.
	 * At the end, all elements must in the same set.
	 * @param setNameOne
	 * @param setNameTwo 
	 * @param newSetName The name of the new set that should be used.
	 */
	public abstract void union(int setNameOne, int setNameTwo, int newSetName);

	/**
	 * Help method for printing the local variables in the subclasses. 
	 * @param msg some extra message to print before the local variables of the classes.
	 */
	public abstract void logNames(String msg);
	
}