package grafo;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class GrafoMatriz extends Grafo{
	
	private double [][] grafo;
	
	
	public GrafoMatriz(int tam) {
		grafo = new double[tam][tam];
	}

	@Override
	public int getNodos() {
		return grafo.length;
	}

	@Override
	public void setArista(int desde, int hasta, double costo) {
		grafo[desde][hasta] = costo;
		grafo[hasta][desde] = costo;
	}

	@Override
	public Double getArista(int desde, int hasta) {
		return grafo[desde][hasta];
	}

	@Override
	public String toString() {
		String sal = "";

		for (int i = 0; i < this.grafo.length; i++) {
			 sal += "Aristas del Nodo " + (i) + " =";
			for (int j = 0; j < grafo[i].length; j++) {
				 if (this.grafo[i][j] != 0)
					 sal += "(" + j + ", "+ this.grafo[i][j] + ") ";
			}
			sal += "\n";
		}
		return sal;
	}

	@Override
	public double[] dijkstra(int desde) {
		return null;
	}
	
	
	public int welshPowel() {
		
		// Creo la lista ordenada de nodos
		PriorityQueue<NodoColoreo> cola = new PriorityQueue<NodoColoreo>();
		
		for (int i = 0; i < grafo.length; i++) {
			int grado = 0;
			
			for (int j = 0; j < grafo[i].length; j++) {
				if(grafo[i][j] != 0)
					grado ++;
			}
			cola.add(new NodoColoreo(i, grado));
		}
		
		// Desacolo para ir buscando por fila en la matriz
		int [] colores = new int [grafo.length];
		
		while(!cola.isEmpty()) {
			//Inicio de nuevo el color para usar la menor cantidad de color posible
			int color = 1; // Asigno un int distinto por color
			
			NodoColoreo nodoAux = cola.poll();
			System.out.println(nodoAux);
			List<Integer> listaAdyacentes = new LinkedList<Integer>();
			// Reviso en la fila id
			for (int i = 0; i < grafo[nodoAux.getId()].length; i++) {
				if(grafo[nodoAux.getId()][i] != 0) {
					listaAdyacentes.add(i);
				}
			}
			
			PriorityQueue<Integer> coloresOrdenados = new PriorityQueue<Integer>();		
			for (Integer integer : listaAdyacentes) {
				coloresOrdenados.add(colores[integer]); 
			}
			
			int band = 0;
			while(!coloresOrdenados.isEmpty() && band == 0) {
				int colorAux = coloresOrdenados.poll();
				if(colorAux != color) {
					colores[nodoAux.getId()] = color;
					band = 1;
				}else
					color++;
			}
		}
		
		int numCromatico =0;
		for (int i = 0; i < colores.length; i++) {
			if(colores[i] != 0)
				numCromatico ++;
		}
		
		return numCromatico;
	}
	

}
