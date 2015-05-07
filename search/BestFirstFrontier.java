package search;

import java.util.PriorityQueue;
import java.util.Comparator;

public class BestFirstFrontier implements Frontier {
	
	NodeFunction nfunc;
	int max;
	private Comparator<? super Node> valueComparator = new Comparator<Node>(){
		public int compare(Node n1, Node n2){
			return (int) (n1.value - n2.value);
		}
	};
	
	PriorityQueue<Node> bfsQueue = new PriorityQueue<Node>(10, valueComparator);
	
	public BestFirstFrontier(NodeFunction nf){
		nfunc = nf;
		max =0;
	}
	
	public void addNodetoFrontier(Node n) {
		Node p = n.parent;
		if (p==null){
			n.gn = 0;
		}
		else{
			n.gn = p.gn + n.action.cost();
		}
		n.value = nfunc.nodeFunc(n);
		bfsQueue.add(n);
		if (max<bfsQueue.size())
			max = bfsQueue.size();
	}

	public void clearFrontier() {
		while (!isEmptyFrontier()) {
			bfsQueue.remove();
		}
		max = 0;

	}

	public boolean isEmptyFrontier() {
		if (bfsQueue.isEmpty())
			return true;		
		else
			return false;
	}

	public Node removeNode() {
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
