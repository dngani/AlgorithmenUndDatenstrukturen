/**
 * 
 */
package ngani.algo.cc.unionfind;

import ngani.algo.cc.unionfind.utils.UnionFindFrame;

/**
 * @author Diane Ngani
 *
 */
public class SimpleTree extends UnionFindFrame {
	
	private int names[];
	private int vater[];
	private int wurzel[];

	/**
	 * @param graphname
	 */
	public SimpleTree (String graphname) {

	}	
	
	@Override
	public void initialize(int numberOfNodes) {
		names = new int [numberOfNodes];
		vater = new int [numberOfNodes];
		wurzel = new int [numberOfNodes];
		for (int i = 0; i < names.length; i++) {
			names[i] = i;
			vater[i] = NULL;
			wurzel[i] = i;
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
		vater[r1] = r2;
		names[r2] = setNameOne;
		wurzel[setNameOne] = r2;
		
//		logNames("UNION A="+setNameOne+", B="+setNameTwo);
	}

	@Override
	public void union(int setNameOne, int setNameTwo, int newSetName) {
		int r1 = wurzel[setNameOne];
		int r2 = wurzel[setNameTwo];
		vater[r1] = r2;
		names[r2] = newSetName;
		wurzel[newSetName] = r2;
		
//		logNames("UNION A="+setNameOne+", B="+setNameTwo+" C="+newSetName);
	}
	
	public void logNames (String msg) {
		String index=msg+"\n\t\t", 
				values="PARTITION:\t",
				vatern="VATER:\t\t",
				wurzeln="WURZEL:\t\t";
		for (int i = 0; i < names.length; i++) {
			index+=i+" ";
			values+=names[i]+" ";
			vatern+=vater[i]+" ";
			wurzeln+=wurzel[i]+" ";
		}
		System.out.println(index+"\n"+values+"\n"+vatern+"\n"+wurzeln+"\n");
	}

}
