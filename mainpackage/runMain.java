package mainpackage;

import search.BreadthFirstFrontier;
import search.DepthFirstFrontier;
import search.GoalTest;
import search.GraphSearch;
import search.IterativeDeepeningTreeSearch;
import search.Node;
import search.Search;
import search.TreeSearch;
import tour.Cities;
import tour.City;
import tour.SetUpRomania;
import tour.TourGoalTest;
import tour.TourPrinting;
import tour.TourState;
import npuzzle.Tiles;
import npuzzle.TilesGoalTest;
import npuzzle.NPuzzlePrinting;

public class runMain {

	public static void main(String[] args) {
		runNpuzzle();
		runTour();
	}

	private static void runNpuzzle(){
		Tiles initialConfiguration = new Tiles(new int[][] {
				{ 7, 4, 2 },
				{ 8, 1, 3 },
				{ 5, 0, 6 }
		});
		Node root = new Node(null, null, initialConfiguration,0);

		GoalTest goalTest = new TilesGoalTest();

		
//		Breadth first searches
		BreadthFirstFrontier bfsfront = new BreadthFirstFrontier();
		
		TreeSearch treeB = new TreeSearch(bfsfront);
		printSolnpuzz(treeB, root, goalTest, "breadth-first tree");
		bfsfront.clearFrontier();
		
		GraphSearch graphB = new GraphSearch(bfsfront);
		printSolnpuzz(graphB, root, goalTest, "breadth-first graph");


//		Depth first searches
		DepthFirstFrontier dfsfront = new DepthFirstFrontier();
//		
//		TreeSearch treeD = new TreeSearch(dfsfront);
//		printSolnpuzz(treeD, root, goalTest, "depth-first tree");
//		dfsfront.clearFrontier();			
	
		GraphSearch graphD = new GraphSearch(dfsfront);
		printSolnpuzz(graphD, root, goalTest, "depth-first graph");

	}

	private static void printSolnpuzz(Search search, Node root, GoalTest goalTest, String str){
		System.out.println("This is a demonstration of " + str + " search on 8-puzzle");
		System.out.println();
		Node sol = search.SearchGoal(root, goalTest);
		//new NPuzzlePrinting().printSolution(sol);
		System.out.println("Printing counts:");
		search.printCounts();
		System.out.println();
		System.out.println();
	}

	private static void runTour() {
		// TODO Auto-generated method stub
		Cities romania = SetUpRomania.getRomaniaMapSmall();
		City startCity = romania.getState("Bucharest");
		Node root = new Node(null, null, new TourState(startCity), 0);

		GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);

		
		//Breadth first searches
		BreadthFirstFrontier bfsfront = new BreadthFirstFrontier();

		TreeSearch treeB = new TreeSearch(bfsfront);
		printSolTour(treeB, root, goalTest, "breadth-first tree");
		bfsfront.clearFrontier();
		
		GraphSearch graphB = new GraphSearch(bfsfront);
		printSolTour(graphB, root, goalTest, "breadth-first graph");
		
		
		//Depth first searches
		DepthFirstFrontier dfsfront = new DepthFirstFrontier();

//		TreeSearch treeD = new TreeSearch(dfsfront);
//		printSolTour(treeD, root, goalTest, "depth-first tree");
//		dfsfront.clearFrontier();			

		GraphSearch graphD = new GraphSearch(dfsfront);
		printSolTour(graphD, root, goalTest, "depth-first graph");

	}

	private static void printSolTour(Search search, Node root, GoalTest goalTest, String str){
		System.out.println("This is a demonstration of " + str + " search on Romania Tour");
		System.out.println();
		Node sol = search.SearchGoal(root, goalTest);
		//new TourPrinting().printSolution(sol);
		System.out.println("Printing counts:");
		search.printCounts();
		System.out.println();
		System.out.println();
	}
}
