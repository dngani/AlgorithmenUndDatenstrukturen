/**
 * 
 */
package ngani.algo.cc;

import ngani.algo.cc.unionfind.*;
import ngani.algo.cc.unionfind.utils.UnionFindFrame;

/**
 * @author Diane Ngani
 *
 */
public class ConnectedComponents {

	/**
	 * @return the number of connected components 
	 * For example 1 mean all elements are together connected.
	 * {@code n } mean the given graph has n connected subgraphs.
	 */
	public boolean testConnectivity(int classname, int numberOfNodes, int [] edges) {
		
		UnionFindFrame uf;
		boolean done = false;
		
		switch(classname) {
			case UnionFindFrame.SIMPLE: 
				uf= new Simple(""+classname+numberOfNodes); 
				done = runTest(uf, numberOfNodes, edges);
			case UnionFindFrame.RELABEL: 
				uf= new RelabelTheSmallerHalf(""+classname+numberOfNodes); 
				done = runTest(uf, numberOfNodes, edges);
			case UnionFindFrame.SIMPLETREE: 
				uf= new SimpleTree(""+classname+numberOfNodes);
				done = runTest(uf, numberOfNodes, edges);
			case UnionFindFrame.WEIGHTEDUNION: 
				uf= new WeightedUnion(""+classname+numberOfNodes);
				done = runTest(uf, numberOfNodes, edges);
			case UnionFindFrame.PATHCOMPRESSION: 
				uf= new PathCompression(""+classname+numberOfNodes);
				done = runTest(uf, numberOfNodes, edges);
		}

		return done;
	}
	
	/**
	 * the for loop running on all given edges. The loop is similar for all five union-find solutions
	 * @param uf a subclass instance of the UnionFindFrame
	 * @param numberOfNodes the size of the graph (the number of nodes)
	 * @param edges array representing the edges of the graph
	 * @return true after the execution of the loop
	 */
	private boolean runTest(UnionFindFrame uf, int numberOfNodes, int [] edges) {
		
		uf.initialize(numberOfNodes);

		int neighbor;
		int node;

		for (int i = 0; i < edges.length; i++) {
			node = uf.find(i);
			neighbor = uf.find(edges[i]);
			uf.union(node, neighbor, node);
		}
		
		return true;
	}

}
