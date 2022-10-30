package RescatarPrincesa;

import java.util.List;

import grafo.GrafoLista;
import grafo.GrafoMatrizNoDirigidos;

public class RecateALaPrincesa {

	public static void main(String[] args) {

		// Creo el grafo
		GrafoMatrizNoDirigidos grafo = new GrafoMatrizNoDirigidos(9);

		grafo.setArista(0, 1, 3);
		grafo.setArista(0, 2, 2);
		grafo.setArista(1, 2, 4);
		grafo.setArista(1, 5, 1);
		grafo.setArista(2, 5, 2);
		grafo.setArista(2, 7, 1);
		grafo.setArista(2, 3, 2);
		grafo.setArista(3, 4, 2);
		grafo.setArista(5, 7, 5);
		grafo.setArista(5, 8, 3);
		
//		GrafoLista grafo = new GrafoLista(9);
//
//		grafo.setArista(0, 1, 3);
//		grafo.setArista(0, 2, 2);
//		grafo.setArista(1, 0, 3);
//		grafo.setArista(1, 2, 4);
//		grafo.setArista(1, 5, 1);
//		grafo.setArista(2, 0, 2);
//		grafo.setArista(2, 1, 4);
//		grafo.setArista(2, 5, 2);
//		grafo.setArista(2, 7, 1);
//		grafo.setArista(2, 3, 2);
//		grafo.setArista(3, 2, 2);
//		grafo.setArista(3, 4, 2);
//		grafo.setArista(4, 3, 2);
//		grafo.setArista(5, 1, 1);
//		grafo.setArista(5, 2, 2);
//		grafo.setArista(5, 7, 5);
//		grafo.setArista(5, 8, 3);
//		grafo.setArista(7, 2, 1);
//		grafo.setArista(7, 5, 5);
//		grafo.setArista(8, 5, 3);

		// mostramos por consola el grafo
		System.out.println(grafo);

		// output es un vec con la distancia de todos los grafos a el origen
		int princesa = 8;
		double[] distancias = grafo.dijkstra(princesa);
		for (int i = 0; i < distancias.length; i++)
			System.out.println("Distancia al nodo " + i + ": " + distancias[i]);

		// Mostramos camino desde la princesa hasta el dragon 1
		int dragon_1 = 7;
		List<Integer> camino1 = grafo.caminoHastaNodo(princesa, dragon_1);

		for (int nroNodo : camino1) {
			System.out.print(nroNodo + " ");
		}
		System.out.println();

		// Mostramos camino desde la princesa hasta el dragon 2
		int dragon_2 = 4;
		List<Integer> camino2 = grafo.caminoHastaNodo(princesa, dragon_2);

		for (int nroNodo : camino2) {
			System.out.print(nroNodo + " ");
		}
		System.out.println();

		// Mostramos camino desde la princesa hasta el principe
		int principe = 0;
		List<Integer> camino3 = grafo.caminoHastaNodo(princesa, principe);

		for (int nroNodo : camino3) {
			System.out.print(nroNodo + " ");
		}
		System.out.println();
	}
}
