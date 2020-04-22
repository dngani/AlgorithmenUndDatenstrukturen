/**
 * 
 */
package ngani.algo.cc;

import ngani.algo.cc.unionfind.Simple;

/**
 * @author Diane Ngani
 *
 */
/**
 * The main of the program. It also contains different methods testing the different implementations of the union-find algorithms
 * */

public class ConnectedComponents {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ConnectedComponents cc = new ConnectedComponents();
		cc.testConnectivity();
	}

	/**
	 * @return the number of connected components 
	 * For example 1 mean all elements are together connected.
	 * {@code n } mean the given graph has n connected subgraphs.
	 */
	public int testConnectivity() {
		// deploy the loop for testing

		// Start point: data about the graph, we want to test.
		int numberOfNodes = 10; // That mean, the graph has #numberOfNodes nodes label from 0 to 9
		int[] edges = { 6, 5, 7, 1, 2, 9, 8, 0, 1, 3 };
		
		Simple uf = new Simple("edges");
		uf.initialize(numberOfNodes);

		int neighbor;
		int node;

		for (int i = 0; i < edges.length; i++) {
			node = uf.find(i);
			neighbor = uf.find(edges[i]);
			uf.union(node, neighbor, node);
		}

		return 0;
	}

}
