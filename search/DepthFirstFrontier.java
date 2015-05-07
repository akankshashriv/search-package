package search;

import java.util.Stack;

public class DepthFirstFrontier implements Frontier {
	int max;
	Stack<Node> dfsStack = new Stack<Node>();

	public DepthFirstFrontier(){
		max=0;
	}

	public void addNodetoFrontier(Node node) {
		dfsStack.push(node);
		if (max<dfsStack.size())
			max = dfsStack.size();
	}

	public void clearFrontier() {
		while(!isEmptyFrontier()){
			dfsStack.pop();
		}
		max = 0;
	}

	public boolean isEmptyFrontier() {
		if (dfsStack.isEmpty()){
			return true;
		}


		return false;
	}

	public Node removeNode() {
		return dfsStack.pop();
	}

	public int maxNodeCount() {
		return max;
	}

	public boolean hasNode(Node childN) {
		if(dfsStack.contains(childN))
			return true;
		return false;
	}

}
