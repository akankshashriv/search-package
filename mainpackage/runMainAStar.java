package mainpackage;

import search.AStarFunction;
import search.BestFirstFrontier;
import search.GoalTest;
import search.GraphSearch;
import search.Node;
import search.NodeFunction;
import search.Search;
import search.TreeSearch;
import npuzzle.MisplacedTilesHeuresticFunction;
import npuzzle.Tiles;
import npuzzle.TilesGoalTest;
import npuzzle.NPuzzlePrinting;

public class runMainAStar {

	public static void main(String[] args) {
		runNpuzzle();
	}

	private static void runNpuzzle(){
		Tiles initialConfiguration = new Tiles(new int[][] {
				{ 7, 4, 2 },
				{ 8, 1, 3 },
				{ 5, 0, 6 }
		});
		Node root = new Node(null, null, initialConfiguration,0);

		GoalTest goalTest = new TilesGoalTest();
		
		NodeFunction hn = new MisplacedTilesHeuresticFunction();
		NodeFunction astar = new AStarFunction(hn);
		
//		Breadth first searches
		BestFirstFrontier bfsfront = new BestFirstFrontier(astar);
		
		TreeSearch treeB = new TreeSearch(bfsfront);
		printSolnpuzz(treeB, root, goalTest, "A* tree");
		bfsfront.clearFrontier();
		
		GraphSearch graphB = new GraphSearch(bfsfront);
		printSolnpuzz(graphB, root, goalTest, "A* graph");

	}

	private static void printSolnpuzz(Search search, Node root, GoalTest goalTest, String str){
		System.out.println("This is a demonstration of " + str + " search on 8-puzzle");
		System.out.println();
		Node sol = search.SearchGoal(root, goalTest);
		new NPuzzlePrinting().printSolution(sol);
		System.out.println("Printing counts:");
		search.printCounts();
		System.out.println();
		System.out.println();
	}

}