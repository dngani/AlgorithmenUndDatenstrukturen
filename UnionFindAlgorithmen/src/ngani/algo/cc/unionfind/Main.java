/**
 * 
 */
package ngani.algo.cc.unionfind;

import java.util.Random;

import ngani.algo.cc.ConnectedComponents;

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
		
		/*
		 * Generate an array of random values. Given the max value that should be random. 
		 * The result is print on the console. Use copy and paste to set those new values to int [] edges.
		 * This manual method is use to keep the same values for all executed tests.
		 */
		
//		generateRandomEdges(100);
//		generateRandomEdges(500);

		// Start point: data about the graph, we want to test.
		int numberOfNodes = 10; // That mean, the graph has #numberOfNodes nodes label from 0 to 9
		int[] edges = { 6, 5, 7, 1, 2, 9, 8, 0, 1, 3 };
		cc.testConnectivity(numberOfNodes, edges);

//		numberOfNodes = 100;
//		int[] edges100 = { 15,50,74,88,91,66,36,88,23,13,22,17,56,57,52,59,80,78,73,19,53,28,65,72,67,31,48,92,0,28,74,95,16,73,44,94,87,68,6,29,55,0,39,71,31,2,85,15,62,0,58,36,19,8,59,45,25,52,45,48,46,57,22,54,88,34,53,77,11,71,30,56,0,51,24,63,92,32,87,83,46,26,98,93,34,71,94,12,33,38,26,28,90,53,79,39,59,26,55,52};
//		cc.testConnectivity(numberOfNodes,edges100);
//		
//		numberOfNodes = 500;
//		int[] edges500 = { 195,394,492,322,185,65,6,328,207,132,89,59,125,30,30,253,48,11,349,73,263,267,346,120,252,151,117,300,466,357,263,295,298,430,173,161,391,151,440,309,280,498,452,258,248,15,439,346,413,195,209,48,114,460,453,31,7,395,387,187,216,231,254,72,274,11,390,93,493,208,158,420,475,49,284,33,10,52,29,336,189,418,124,451,273,142,471,134,3,350,13,31,251,247,128,69,355,117,459,333,61,484,213,483,452,185,165,387,498,180,9,13,468,235,369,388,347,324,48,99,418,161,390,452,85,453,179,71,229,202,89,63,451,34,9,76,79,83,127,485,253,41,135,180,458,474,216,441,465,128,124,260,190,195,155,47,353,285,137,220,292,436,299,368,222,144,194,349,320,351,363,222,82,81,66,169,375,456,62,298,35,1,243,448,329,437,419,28,329,47,31,182,488,499,269,203,311,180,460,464,387,343,91,383,238,386,456,261,351,60,190,296,248,322,16,318,105,430,210,155,234,259,369,452,333,326,68,69,154,192,422,84,108,130,178,220,20,358,499,18,254,19,348,167,485,88,361,245,368,210,328,59,167,493,422,370,7,453,346,282,233,290,353,354,355,57,237,265,481,10,36,370,45,240,276,3,257,16,12,394,132,382,350,121,372,484,136,156,207,249,397,297,27,127,13,8,96,230,142,29,317,30,150,435,338,487,343,127,460,76,369,378,348,33,158,328,379,494,77,146,43,5,325,283,278,251,53,283,191,236,128,29,359,46,115,283,190,369,428,92,280,101,346,90,343,443,163,281,77,273,329,145,372,474,392,392,318,258,99,368,36,24,391,84,291,98,93,65,221,385,155,413,26,319,57,49,351,485,94,496,68,394,22,420,446,95,116,371,52,232,433,482,283,49,196,111,190,194,189,266,32,340,393,340,133,218,131,199,99,463,309,389,204,130,91,426,218,428,201,249,152,165,68,57,149,52,302,190,120,201,347,420,253,109,44,26,6,173,28,456,494,348,243,375,137,247,383,325,58,38,365,486,177,481,272,305,132,12,277,309,404,365,243,413,81,124,295,262,408,74,48,20,466,400,276,482,29,450,295,20,316,208,54,457,331,483,420,422,45,141,17,347,454,376,48,39,53,158,219,322 };
//		cc.testConnectivity(numberOfNodes,edges500);
//		
//		numberOfNodes = 1000;
//		int[] edges1000 = {};
//		cc.testConnectivity(numberOfNodes,edges4);

//		numberOfNodes = 10000;
//		int[] edges10000 = { 1, 2, 1, 9, 9, 0, 5, 5, 6, 1 };
//		cc.testConnectivity(numberOfNodes, edges10000);

		// Calling the class implementations separatly
//		cc.testConnectivity(UnionFindFrame.SIMPLE,numberOfNodes,edges);
//		System.out.println("+++++++++++++++++++++++++++++++");
//		cc.testConnectivity(UnionFindFrame.RELABEL,numberOfNodes,edges);
//		System.out.println("+++++++++++++++++++++++++++++++");
//		cc.testConnectivity(UnionFindFrame.SIMPLETREE,numberOfNodes,edges);
//		System.out.println("+++++++++++++++++++++++++++++++");
//		cc.testConnectivity(UnionFindFrame.WEIGHTEDUNION,numberOfNodes,edges);
//		System.out.println("+++++++++++++++++++++++++++++++");
//		cc.testConnectivity(UnionFindFrame.PATHCOMPRESSION,numberOfNodes,edges);
	}

	/**
	 * @param maxValue the length of the result array and the max value for the random generator.
	 */
	private static void generateRandomEdges(int maxValue) {

		int[] rEdges = new int[maxValue];

		Random r = new Random(maxValue);
		for (int i = 0; i < rEdges.length; i++) {
			rEdges[i] = r.nextInt(maxValue);
		}

		String result = "{";
		for (int val : rEdges) {
			result += val + ",";
		}
		result = result.substring(0, result.length() - 1) + "}";
		System.out.println(result);

	}

}
