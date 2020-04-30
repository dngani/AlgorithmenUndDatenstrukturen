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
	 * @param numberOfNodes the size of the graph
	 * @param edges maximum one edge per node
	 * @return the number of connected components 
	 * For example 1 mean all elements are together connected.
	 * {@code n } mean the given graph has n connected subgraphs.
	 */
	public boolean testConnectivity(int numberOfNodes, int [] edges) {
		
		System.out.println("------------------------------\n"+"Number of nodes: "+numberOfNodes+"\n"
				+"EDGES:\t"+arrayToString(edges)+"\n------------------------------");
		UnionFindFrame uf;
		boolean done = false;
		
		// Test Simple
		uf= new Simple("Simple"+numberOfNodes); 
		done = runTest(uf, numberOfNodes, edges);
		uf.logNames("++++SIMPLE+++++");
		
		// Test Relabel the Smaller Half
		uf= new RelabelTheSmallerHalf("RelabelTheSmallerHalf"+numberOfNodes); 
		done = runTest(uf, numberOfNodes, edges);
		uf.logNames("++++RELABEL+++++");
		
		// Test SimpleTree
		uf= new SimpleTree("SimpleTree"+numberOfNodes);
		done = runTest(uf, numberOfNodes, edges);
		uf.logNames("++++SIMPLETREE+++++");
		
		// Test weighted Union
		uf= new WeightedUnion("WeightedUnion"+numberOfNodes);
		done = runTest(uf, numberOfNodes, edges);
		uf.logNames("++++WEIGTHEDUNION+++++");
		
		// Test Path Compression
		uf= new PathCompression("PathCompression"+numberOfNodes);
		done = runTest(uf, numberOfNodes, edges);
		uf.logNames("++++PATHCOMPRESSION+++++");
		
		return done;
	}

	/**
	 * @param classname the name of the class instance, which should be used
	 * @param numberOfNodes the size of the graph
	 * @param edges maximum one edge per node
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
				uf.logNames("++++SIMPLE+++++");
				break;
			case UnionFindFrame.RELABEL: 
				uf= new RelabelTheSmallerHalf(""+classname+numberOfNodes); 
				done = runTest(uf, numberOfNodes, edges);
				uf.logNames("++++RELABEL+++++");
				break;
			case UnionFindFrame.SIMPLETREE: 
				uf= new SimpleTree(""+classname+numberOfNodes);
				done = runTest(uf, numberOfNodes, edges);
				uf.logNames("++++SIMPLETREE+++++");
				break;
			case UnionFindFrame.WEIGHTEDUNION: 
				uf= new WeightedUnion(""+classname+numberOfNodes);
				done = runTest(uf, numberOfNodes, edges);
				uf.logNames("++++WEIGTHEDUNION+++++");
				break;
			case UnionFindFrame.PATHCOMPRESSION: 
				uf= new PathCompression(""+classname+numberOfNodes);
				done = runTest(uf, numberOfNodes, edges);
				uf.logNames("++++PATHCOMPRESSION+++++");
				break;
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
			if(node != neighbor) {
				uf.union(node, neighbor, node);
			}
		}
		
		return true;
	}
	
	private String arrayToString(int [] values) {
		String result = "[";
		for(int val: values) {
			result+=val+",";
		}
		result = result.substring(0, result.length()-1)+"]";
	return result;
	}

}
