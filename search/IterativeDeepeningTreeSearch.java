package search;

public class IterativeDeepeningTreeSearch implements Search {

	DepthFirstFrontier front, f;
	int c, d, maxdepth;

	public Node SearchGoal(Node root, GoalTest goal) {
		boolean max=false;
		front = new DepthFirstFrontier();
		front.addNodetoFrontier(root);
//		f = new DepthFirstFrontier();
//		f.addNodetoFrontier(root);
		while (!max){			
			while (!front.isEmptyFrontier()){
				Node n = front.removeNode();
				max = true;
				if (goal.isGoal(n.state))
					return n;
				else {
					if (n.depth<=maxdepth || n.depth==0) {
						d++;
						boolean child=false;
						for (Action action : n.state.getApplicableActions()) {
							State newState = n.state.getActionResult(action);
							front.addNodetoFrontier(new Node(n, action, newState,d));
//							f.addNodetoFrontier(new Node(n, action, newState,d));
							c++;
							System.out.print(d);
							System.out.print(" ");
							child = true;
						}
						if (child){
							if (maxdepth<d){
								maxdepth++;
							}
							max = false;
							child = false;
							System.out.println(maxdepth);
							System.out.println();
						}
					}
				}
			}
			front.addNodetoFrontier(root);
		}
		return null;
	}

	public IterativeDeepeningTreeSearch(){
		this.c = 0;
		this.d=0;
		this.maxdepth=1;
	}


	public void printCounts(){
		System.out.print("Total nodes generated during the search :");
		System.out.print(c);
		System.out.println();
		System.out.print("Maximum nodes in the frontier :");
		System.out.print(front.maxNodeCount());
		System.out.println();
	}
}
