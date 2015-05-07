package search;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstFrontier implements Frontier {
	int max;
	Queue<Node> bfsQueue = new LinkedList<Node>();

	public BreadthFirstFrontier(){
		max=0;
	}

	public void addNodetoFrontier(Node node){
		bfsQueue.add(node);
		if (max<bfsQueue.size())
			max = bfsQueue.size();
	}

	public void clearFrontier(){
		while (!isEmptyFrontier()) {
			bfsQueue.remove();
		}
		max = 0;
	}

	public boolean isEmptyFrontier(){
		if (bfsQueue.isEmpty())
			return true;		
		else
			return false;

	}
	public Node removeNode(){
		return bfsQueue.remove();
	}

	public int maxNodeCount() {
		return max;
	}

	public boolean hasNode(Node childN) {
		if(bfsQueue.contains(childN))
			return true;
		return false;
	}
}
