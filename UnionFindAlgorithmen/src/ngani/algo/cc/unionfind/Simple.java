/**
 * 
 */
package ngani.algo.cc.unionfind;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import ngani.algo.cc.UnionFindInterface;
import ngani.algo.cc.unionfind.logging.DataFileFormatter;
import ngani.algo.cc.unionfind.logging.LogParameters;
import ngani.algo.cc.unionfind.logging.LoggerFactory;


/**
 * @author Diane Ngani
 *
 */
public class Simple implements UnionFindInterface{

	private int names [];
	private int countFind=0, countUnion=0, countSwaps=0;
	private int recursion, callHierachy=0;
	private static int logID;
	
	private Logger logger = LoggerFactory.getLogger("unionfind.simple", "cc-unionfind-simple.log");
	FileHandler fh;
	
	/**
	 * A simple implementation of the UNION-FIND Algorithm.
	 * @param graphname The Name of the graph which the program will be working on.
	 */
	public Simple(String graphname) {
		try {
			fh = new FileHandler("cc-unionfind"+this.getClass().getSimpleName()+"-"+graphname+"-%g.log", false);
			fh.setFormatter(new DataFileFormatter());
			logger.addHandler(fh);
		} catch (SecurityException e) {	e.printStackTrace(); 
		} catch (IOException e) { e.printStackTrace();}
	}
	
	@Override
	public void initialize(int numberOfNodes) {
		/* Setting the names of the nodes as their own anchor.*/
		logger.entering(this.getClass().getName(), "initialize", new LogParameters(this.nextID(),recursion, callHierachy,numberOfNodes, 0, 0,countFind, countUnion,countSwaps));
		
		names = new int [numberOfNodes];
		for (int i = 0; i < names.length; i++) {
			names[i] = i;
		}
		
		logger.exiting(this.getClass().getName(), "initialize", new LogParameters(this.nextID(),recursion, callHierachy,names.length, 0, 0,countFind, countUnion,countSwaps));
	}

	@Override
	public int find(int node) throws ArrayIndexOutOfBoundsException {
	
		logger.entering(this.getClass().getName(), "find", new LogParameters(this.nextID(),recursion, callHierachy,node, 0, 0,countFind, countUnion,countSwaps));
		countFind++;
		logger.exiting(this.getClass().getName(), "find", new LogParameters(this.nextID(),recursion, callHierachy,names[node], 0, 0,countFind, countUnion,countSwaps));

		/* 
		 * Return the known anchor of the given node index. 
		 */
		return names[node];
	}

	@Override
	public int union(int setNameOne, int setNameTwo, int newSetName) {
		
		/* 
		 * Try to make an union and give a feedback about the action: the number of swaps / changed values.
		 */
		
		logger.entering(this.getClass().getName(), "union",new LogParameters(this.nextID(),recursion, callHierachy,setNameOne, setNameTwo, newSetName,countFind,countUnion,countSwaps));

		callHierachy++;
		for (int i = 0; i < names.length; i++) {
			if (find(i) == setNameOne || find(i) == setNameTwo) {
				names[i] = newSetName;
				countSwaps++;
			}
		}
		
		callHierachy--;
		countUnion++;
		
		logger.exiting(this.getClass().getName(), "union", new LogParameters(this.nextID(),recursion,callHierachy,setNameOne, setNameTwo, newSetName,countFind,countUnion,countSwaps));
		
//		logArray("UNION A="+setNameOne+", B="+setNameTwo+" C="+newSetName);
		return countSwaps;
	}
	
	/**
	 * Increment the intern variable {@code recursion}. Useful for time logging when running a active class instance multiple times for one graph. 
	 */
	public void incrementRercursion() {
		this.recursion ++;
	}
	
	/**
	 * Decrement the intern variable {@code recursion}. Useful for time logging when running a active class instance multiple times for one graph.
	 */
	public void decrementRercursion() {
		this.recursion --;
	}
	
	/**
	 * Internal ID increment for the log entries.
	 * @return The next value for IDs
	 */
	public int nextID() {
		return ++logID;
	}

	private void logArray (String operation) {
		String index=operation+"\n\t\t", values="PARTITION:\t";
		for (int i = 0; i < names.length; i++) {
			index+=i+" ";
			values+=names[i]+" ";
		}
		System.out.println(index+"\n"+values+"\n-----------------");
	}
	
}
