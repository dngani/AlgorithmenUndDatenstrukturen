/**
 * 
 */
package ngani.algo.cc.unionfind;

import ngani.algo.cc.ConnectedComponents;
import ngani.algo.cc.unionfind.utils.UnionFindFrame;

/**
 * @author Diane Ngani
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ConnectedComponents cc = new ConnectedComponents();
		
		// Start point: data about the graph, we want to test.
		int numberOfNodes = 10; // That mean, the graph has #numberOfNodes nodes label from 0 to 9
		int[] edges = { 6, 5, 7, 1, 2, 9, 8, 0, 1, 3 };
				
		cc.testConnectivity(UnionFindFrame.SIMPLE,numberOfNodes,edges);
		cc.testConnectivity(UnionFindFrame.RELABEL,numberOfNodes,edges);
		cc.testConnectivity(UnionFindFrame.SIMPLETREE,numberOfNodes,edges);
		cc.testConnectivity(UnionFindFrame.WEIGHTEDUNION,numberOfNodes,edges);
		cc.testConnectivity(UnionFindFrame.PATHCOMPRESSION,numberOfNodes,edges);
	}

}
