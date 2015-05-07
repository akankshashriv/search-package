package npuzzle;

import search.Node;
import search.NodeFunction;

public class MisplacedTilesHeuresticFunction implements NodeFunction {

	public int nodeFunc(Node n) {
		Tiles s = (Tiles) n.state;
		int c = 0;
		int lastTileIndex = s.width * s.width - 1;
		for (int index = lastTileIndex - 1; index >=0; --index)
			if (s.tiles[index] != index + 1)
				c++;
		return c;
	}

}
