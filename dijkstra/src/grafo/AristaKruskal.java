package grafo;

public class AristaKruskal implements Comparable<AristaKruskal>{
	
	private int desde;
	private int hasta;
	double costo;
	
	public AristaKruskal(int desde, int hasta, double costo) {
		super();
		this.desde = desde;
		this.hasta = hasta;
		this.costo = costo;
	}

	@Override
	public int compareTo(AristaKruskal o) {
		return (int)(this.costo - o.costo);
	}

	@Override
	public String toString() {
		return "(" + desde + ", " + hasta + ", " + costo + ")";
	}

	public int getDesde() {
		return desde;
	}

	public int getHasta() {
		return hasta;
	}

	public double getCosto() {
		return costo;
	}
	
}
