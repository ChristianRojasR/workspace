package main;

import grafo.GrafoMatrizNoDirigidos;

public class AppKuskal {
	public static void main(String[] args) {
		GrafoMatrizNoDirigidos grafo = new GrafoMatrizNoDirigidos(4);
		
		grafo.setArista(0, 1, 3);
		grafo.setArista(0, 2, 5);
		grafo.setArista(1, 2, 1);
		grafo.setArista(2, 3, 1);
		
		System.out.println(grafo);
		
		// Vemos el costo
		
		System.out.println("Costo = " + grafo.kruskal());
		
		for (int i = 0; i < 4; i++) {
			System.out.println(grafo.getRepresentantes()[i]);
		}

	}
}
