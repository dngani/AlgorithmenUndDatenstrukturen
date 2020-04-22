/**
 * 
 */
package ngani.algo.cc.unionfind.logging;

/**
 * @author Diane Ngani
 *
 */
/**
 * Help class for a simple logging of local variables using Logger.entering(...) and Logger.exiting(...) methods.
 * */
public class LogParameters {
	
	int ID;
	int recursion;
	int callHierachy;
	int methodParam1;
	int methodParam2;
	int methodParam3;
	int finds;
	int unions;
	int swaps;
		
	/**
	 * A Constructor with a bunch of parameters
	 * @param id The log ID
	 * @param recursion a counter for recursive calls of the class instance
	 * @param callHierachy a counter to increase or decrease if there is a method call coming from a another method
	 * @param methodParam1 The first parameter of the calling method
	 * @param methodParam2 The second parameter of the calling method
	 * @param methodParam3 The third parameter of the calling method
	 * @param finds Number of find-operations which have been saved by now.
	 * @param unions Number of union-operations which have been saved by now.
	 * @param swaps Number of swap-operations which have been made in the union-method.
	 */
	public LogParameters(int id, int recursion, int callHierachy, int methodParam1, int methodParam2, int methodParam3,int finds, int unions, int swaps) {
		this.ID = id;
		this.recursion = recursion; 
		this.callHierachy = callHierachy;
		this.methodParam1 = methodParam1;
		this.methodParam2 = methodParam2;
		this.methodParam3 = methodParam3;
		this.finds = finds;
		this.unions = unions;
		this.swaps = swaps;		
	}
	
	@Override
	public String toString() {
		return ID+";"+recursion+";"+callHierachy+";"+methodParam1+";"+methodParam2+";"+methodParam3+";"+finds+";"+unions+";"+swaps;
	}

}
