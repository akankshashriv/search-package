package search;

public interface Frontier {
	public void addNodetoFrontier(Node node);
	public void clearFrontier();
	public boolean isEmptyFrontier();
	public Node removeNode();
	public int maxNodeCount();
	public boolean hasNode(Node childN);
}
