package main;

import grafo.GrafoMatriz;

public class AppColoreo {

	public static void main(String[] args) {
		
		GrafoMatriz grafo = new GrafoMatriz(7);
		
		grafo.setArista(0, 1, 1);
		grafo.setArista(1, 3, 1);
		grafo.setArista(1, 2, 1);
		grafo.setArista(2, 4, 1);
		grafo.setArista(4, 5, 1);
		
		System.out.println(grafo);
		
		System.out.println(grafo.welshPowel());
	}
}
