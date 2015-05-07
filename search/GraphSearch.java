package search;

import java.util.HashSet;
import java.util.Set;

public class GraphSearch implements Search {

	Frontier front;
	int c, d;
	Set<State> explored = new HashSet<State>();

	public Node SearchGoal(Node root, GoalTest goal) {

		front.addNodetoFrontier(root);
		while (!front.isEmptyFrontier()){
			Node n = front.removeNode();
			if (goal.isGoal(n.state))
				return n;
			d++;
			for (Action action : n.state.getApplicableActions()) {
				State newState = n.state.getActionResult(action);

				if (!explored.contains(newState)) {
					Node childN = new Node(n, action, newState, d);
					if(!front.hasNode(childN)){
						explored.add(newState);
						front.addNodetoFrontier(childN);
					}
					c++;
				}
			}
		}
		return null;
	}

	public GraphSearch(Frontier f){
		front = f;
		c=0;
		d=0;
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
