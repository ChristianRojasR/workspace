package grafo;

public class NodoColoreo implements Comparable<NodoColoreo>{
	
	private int id;
	private int grado;
	
	public NodoColoreo(int id, int grado) {
		this.id = id;
		this.grado = grado;
	}

	@Override
	public String toString() {
		return "( " + id + ", " + grado + ")";
	}

	@Override
	public int compareTo(NodoColoreo o) {
		return o.grado - this.grado;
	}

	public int getId() {
		return id;
	}
	
}
