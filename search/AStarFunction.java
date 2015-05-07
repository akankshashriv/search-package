package search;

public class AStarFunction implements NodeFunction {
	NodeFunction hn;
	
	public AStarFunction(NodeFunction heuresticFunction){
		hn = heuresticFunction;
	}
	
	public int nodeFunc(Node n) {
		return hn.nodeFunc(n) + n.gn;
	}
}
