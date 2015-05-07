package search;

public class TreeSearch implements Search {

	Frontier front;
	int c,d;

	public Node SearchGoal(Node root, GoalTest goal) {
		
		front.addNodetoFrontier(root);
		c++;
		while (!front.isEmptyFrontier()){
			Node n = front.removeNode();
			d=n.depth;
			if (goal.isGoal(n.state))
				return n;
			else {
				d++;
				for (Action action : n.state.getApplicableActions()) {
					State newState = n.state.getActionResult(action);
					front.addNodetoFrontier(new Node(n, action, newState, d));
					c++;
				}
			}
		}
		return null;
	}

	public TreeSearch(Frontier f){
		this.front = f;
		this.c = 0;
		this.d=0;
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
