package grafo;

public class UnionFind {
	
	private int id [];

	public UnionFind(int max) {
		id = new int [max];
		
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}
	
	public int find(int p) {
		
		while(p != id[p]) {
			p = id[p];
		}
		
		return p;
	}
	
	public boolean union(int p, int q) {
		
		int i = find(p);
		int j = find(q);
		
		if(i == j)
			return false;
		
		id[i] = j;
			return true;
	}
	
	public int[] getId() {
		return id;
	}

}
