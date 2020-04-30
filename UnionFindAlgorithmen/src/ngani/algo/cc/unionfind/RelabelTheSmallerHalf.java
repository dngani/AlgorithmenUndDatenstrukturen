/**
 * 
 */
package ngani.algo.cc.unionfind;

import java.util.ArrayList;
import java.util.Iterator;

import ngani.algo.cc.unionfind.utils.UnionFindFrame;

/**
 * @author Diane Ngani
 *
 */
public class RelabelTheSmallerHalf extends UnionFindFrame {
	
	private int names[];
	private int sizes[];
	private ArrayList<ArrayList<Integer>> L;
	
	/**
	 * @param graphname
	 */
	public RelabelTheSmallerHalf (String graphname) {

	}	

	@Override
	public void initialize(int numberOfNodes) {
		names = new int [numberOfNodes];
		sizes = new int [numberOfNodes];
		L = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < names.length; i++) {
			names[i] = i;
			sizes[i] = 1;
			L.add(new ArrayList<Integer>());
			L.get(i).add(i);
		}		
	}

	@Override
	public int find(int node) throws ArrayIndexOutOfBoundsException {
//		System.out.println("find("+node+")");
		return names[node];
	}

	@Override
	public void union(int setNameOne, int setNameTwo) {
		int smallerSet;
		int biggerSet;
		
		if(sizes[setNameOne] <= sizes[setNameOne]) {
			smallerSet = setNameOne;
			biggerSet = setNameTwo;
		}else {
			smallerSet = setNameTwo;
			biggerSet = setNameOne;
		}
		
		Iterator<Integer> it = L.get(smallerSet).iterator();
		while(it.hasNext()) {
			names[(int) it.next()] = biggerSet;
		}
		
		sizes[biggerSet] += sizes[smallerSet];
		L.get(biggerSet).addAll(L.get(smallerSet));
		L.get(smallerSet).clear();
		
//		logNames("UNION A="+setNameOne+", B="+setNameTwo);
	}

	@Override
	public void union(int setNameOne, int setNameTwo, int newSetName) {
		int smallerSet;
		int biggerSet;
		
		if(sizes[setNameOne] <= sizes[setNameOne]) {
			smallerSet = setNameOne;
			biggerSet = setNameTwo;
		}else {
			smallerSet = setNameTwo;
			biggerSet = setNameOne;
		}
		
		Iterator<Integer> it = L.get(smallerSet).iterator();
		while(it.hasNext()) {
			names[(int) it.next()] = biggerSet;
		}
		
		sizes[biggerSet] += sizes[smallerSet];
		L.get(biggerSet).addAll(L.get(smallerSet));
		L.get(smallerSet).clear();
		
//		logNames("UNION A="+setNameOne+", B="+setNameTwo);
		
	}
	
	public void logNames (String msg) {
		String index=msg+"\n\t\t", 
				values="PARTITION:\t",
				size="SIZE:\t\t";
		for (int i = 0; i < names.length; i++) {
			index+=i+" ";
			values+=names[i]+" ";
			size+=sizes[i]+" ";
		}
		System.out.println(index+"\n"+values+"\n"+size+"\n");
	}

}
