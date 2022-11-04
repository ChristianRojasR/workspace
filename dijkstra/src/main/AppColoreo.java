package main;

import grafo.GrafoMatrizNoDirigidos;

public class AppColoreo {

	public static void main(String[] args) {
		
		GrafoMatrizNoDirigidos grafo = new GrafoMatrizNoDirigidos(6);
		
		grafo.setArista(0, 1, 1);
		grafo.setArista(1, 3, 1);
		grafo.setArista(1, 2, 1);
		grafo.setArista(2, 4, 1);
		grafo.setArista(4, 5, 1);
		
		System.out.println(grafo);
		
		for (int i = 0; i < 6; i++) {
			System.out.println(grafo.welshPowel()[i]);
		}

	}
}
