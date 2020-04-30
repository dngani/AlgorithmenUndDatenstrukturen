/**
 * 
 */
package ngani.algo.cc.unionfind;

import ngani.algo.cc.unionfind.utils.UnionFindFrame;

/**
 * @author Diane Ngani
 *
 */
public class Simple extends UnionFindFrame {
	
	private int names[];
	
	/**
	 * @param graphname
	 */
	public Simple(String graphname) {

	}
	
	@Override
	public void initialize(int numberOfNodes) {
		names = new int [numberOfNodes];
		for (int i = 0; i < names.length; i++) {
			names[i] = i;
		}		
	}

	@Override
	public int find(int node) throws ArrayIndexOutOfBoundsException {
//		System.out.println("find("+node+")");
		return names[node];
	}

	@Override
	public void union(int setNameOne, int setNameTwo) {
		for (int i = 0; i < names.length; i++) {
			if (find(i) == setNameOne || find(i) == setNameTwo) {
				names[i] = setNameOne;
			}
		}
		
//		logNames("UNION A="+setNameOne+", B="+setNameTwo);
	}

	@Override
	public void union(int setNameOne, int setNameTwo, int newSetName) {
		for (int i = 0; i < names.length; i++) {
			if (find(i) == setNameOne || find(i) == setNameTwo) {
				names[i] = newSetName;
			}
		}
		
//		logNames("UNION A="+setNameOne+", B="+setNameTwo+" C="+newSetName);
	}
	
	public void logNames (String msg) {
		String index=msg+"\n\t\t", values="PARTITION:\t";
		for (int i = 0; i < names.length; i++) {
			index+=i+" ";
			values+=names[i]+" ";
		}
		System.out.println(index+"\n"+values+"\n");
	}

}
