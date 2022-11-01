package grafo;

public class NodoKruskal {
	
	private int salida;
	private int llegada;
	private double peso;
	
	public NodoKruskal(int salida, int llegada, double peso) {
		this.salida = salida;
		this.llegada = llegada;
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "NodoKruskal [salida=" + salida + ", llegada=" + llegada + ", peso=" + peso + "]";
	}
	
}
