/**
 * 
 */
package ngani.algo.cc.unionfind;

import ngani.algo.cc.unionfind.utils.UnionFindFrame;

/**
 * @author Diane Ngani
 *
 */
public class WeightedUnion extends UnionFindFrame {
	
	private int names[];
	private int sizes[];
	private int vater[];
	private int wurzel[];
	
	/**
	 * @param graphname
	 */
	public WeightedUnion (String graphname) {

	}	
	
	@Override
	public void initialize(int numberOfNodes) {
		names = new int [numberOfNodes];
		vater = new int [numberOfNodes];
		wurzel = new int [numberOfNodes];
		sizes = new int [numberOfNodes];
		for (int i = 0; i < names.length; i++) {
			names[i] = i;
			vater[i] = NULL;
			wurzel[i] = i;
			sizes[i] = 1;
		}		
	}
	@Override
	public int find(int node) throws ArrayIndexOutOfBoundsException {
		while( vater[node] != NULL) {
			node = vater[node];
		}
//		System.out.println("find("+node+") = "+names[node]);
		return names[node];
	}
	@Override
	public void union(int setNameOne, int setNameTwo) {
		int r1 = wurzel[setNameOne];
		int r2 = wurzel[setNameTwo];
		
		int smallerSet;
		int biggerSet;
		
		if(sizes[r1] <= sizes[r2]) {
			smallerSet = r1;
			biggerSet = r2;
		}else {
			smallerSet = r2;
			biggerSet = r1;
		}
		
		vater[smallerSet] = biggerSet;
//		names[biggerSet] = newSetName;
//		wurzel[newSetName] = biggerSet;
		sizes[biggerSet] += sizes[smallerSet];
		
//		logNames("UNION A="+setNameOne+", B="+setNameTwo+" C="+newSetName);
		
	}
	@Override
	public void union(int setNameOne, int setNameTwo, int newSetName) {
		
		int r1 = wurzel[setNameOne];
		int r2 = wurzel[setNameTwo];
		
		int smallerSet;
		int biggerSet;
		
		if(sizes[r1] <= sizes[r2]) {
			smallerSet = r1;
			biggerSet = r2;
		}else {
			smallerSet = r2;
			biggerSet = r1;
		}
		
		vater[smallerSet] = biggerSet;
		names[biggerSet] = newSetName;
		wurzel[newSetName] = biggerSet;
		sizes[biggerSet] += sizes[smallerSet];
		
//		logNames("UNION A="+setNameOne+", B="+setNameTwo+" C="+newSetName);
	}
	
	public void logNames (String msg) {
		String index=msg+"\n\t\t", 
				values="PARTITION:\t",
				vatern="VATER:\t\t",
				wurzeln="WURZEL:\t\t",
				size="SIZES:\t\t";
		for (int i = 0; i < names.length; i++) {
			index+=i+" ";
			values+=names[i]+" ";
			vatern+=vater[i]+" ";
			wurzeln+=wurzel[i]+" ";
			size+=sizes[i]+" ";
		}
		System.out.println(index+"\n"+values+"\n"+vatern+"\n"+wurzeln+"\n"+size+"\n");
	}
	

}
