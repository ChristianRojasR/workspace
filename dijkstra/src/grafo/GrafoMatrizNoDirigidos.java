package grafo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class GrafoMatrizNoDirigidos extends Grafo {

	// grafo implementado matriz de adyacencia con nodos no dirigidos
	private double[][] grafo;
	private int[] predecesores = null;
	private int[] representantes = null;

	public GrafoMatrizNoDirigidos(int tamanio) {

		// Al ser no dirigidos unicamente necesito guardar una vez la arista
		grafo = new double[tamanio][];
		for (int i = 0; i < tamanio; i++) {
			grafo[i] = new double[i];
		}
	}

	@Override
	public int getNodos() {
		return this.grafo.length;
	}

	@Override
	public void setArista(int desde, int hasta, double costo) {
		// Cambio la prioridad de los indices porque normalmente se leen los nodos de
		// menor a mayor
		this.grafo[hasta][desde] = costo;
	}

	public void actualizarMatriz() {
		for (int i = 0; i < grafo.length; i++) {
			for (int j = 0; j < grafo[i].length; j++) {
				if (this.grafo[i][j] == 0)
					this.grafo[i][j] = Double.MAX_VALUE;
			}
		}
	}

	@Override
	public Double getArista(int desde, int hasta) {
		return this.grafo[desde][hasta];
	}

	@Override
	public String toString() {
		String sal = "";

		for (int i = 1; i < this.grafo.length; i++) {
			 sal += "Aristas del Nodo " + (i) + " =";
			for (int j = 0; j < grafo[i].length; j++) {
				 if (this.grafo[i][j] != 0)
					 sal += "(" + j + ", "+ this.grafo[i][j] + ") ";
			}
			sal += "\n";
		}
		return sal;
	}

	public double[] dijkstra(int desde) {
		double[] distancias = new double[getNodos()];
		this.predecesores = new int[getNodos()];

		Set<Integer> s = new HashSet<Integer>();
		s.add(desde);

		Set<Integer> vMenosS = new HashSet<Integer>();

		// cargo vMenosS con todos los nodos excepto el que se encuentra ya en s
		
		for (int i = 0; i < this.getNodos(); i++) {
			if (desde != i)
				vMenosS.add(i);
		}

		// Se inicializa el vector distancias con infinito en todas las posiciones
		
		for (int i = 0; i < distancias.length; i++) {
			distancias[i] = Double.MAX_VALUE;
		}

		distancias[desde] = 0;

		// Se inicializa vector de predecesores con el nodo inicial
		
		for (int i = 0; i < this.predecesores.length; i++) {
			this.predecesores[i] = desde;
		}
		
		// Antes cambio los valores 0 por un "infinito" para los que no tiene contacto entre si
		this.actualizarMatriz();
		
		// Primer paso: se carga en distancias todas las distancias a nodos directos
		// desde el nodo inicial
		
		for (int i = 0; i < this.grafo[desde].length; i++) {
				distancias[i] = this.grafo[desde][i];
		}

		// Segundo y n pasos... Mientras vMenosS no sea vacio
		
		while(!vMenosS.isEmpty()) {
			boolean bandera = false;
			double min = 0;
			int w = 0;
			
			for (Integer integer : vMenosS) {
				if (!bandera) {
					min = distancias[integer];
					w = integer;
					
					bandera = true;
				} else {
					if (distancias[integer] < min) {
						min = distancias[integer];
						w = integer;
					}
				}
			}
			vMenosS.remove(w);
			s.add(w);
			
			boolean seEncontro = false;
			for (int i = 0; i < this.grafo[w].length; i++) {
					if (distancias[i] > distancias[w] + this.grafo[w][i]) {
						distancias[i] = distancias[w] + this.grafo[w][i];
						this.predecesores[i] = w;
						seEncontro = true;
					}
			}
			if (!seEncontro) {
				for (int i = this.grafo[w].length + 1; i < this.getNodos(); i++) {
					if (distancias[i] > distancias[w] + this.grafo[i][w]) {
						distancias[i] = distancias[w] + this.grafo[i][w];
						this.predecesores[i] = w;
						seEncontro = true;
					}
				}
			}
		}

		return distancias;
	}

	public int[] getPredecesores() {
		return this.predecesores;
	}

	public List<Integer> caminoHastaNodo(int desde, int nodo) {

		List<Integer> lista = new LinkedList<Integer>();
		Stack<Integer> pila = new Stack<Integer>();
		

		pila.add(nodo);
		while (this.predecesores[nodo] != desde) {
			pila.add(this.predecesores[nodo]);
			nodo = this.predecesores[nodo];
		}
		pila.add(desde);

		while (!pila.isEmpty()) {
			lista.add(pila.pop());
		}

		return lista;
	}
	
	public int kruskal() {
		
		this.actualizarMatriz();
		
		// Ordenamos las aristas de menor a mayor y conservamos la informacion
		PriorityQueue<AristaKruskal> colaDeAristas = new PriorityQueue<AristaKruskal>();
		
		for (int i = 0; i < grafo.length; i++) {
			for (int j = 0; j < grafo[i].length; j++) {
				if(this.grafo[i][j] != Double.MAX_VALUE)
					colaDeAristas.add(new AristaKruskal(i, j, this.grafo[i][j]));		
			}
		}
		
		//Emepzamos a unir los n nodos entre si
		int costo = 0;
		UnionFind unionFind = new UnionFind(grafo.length);
		
		while(!colaDeAristas.isEmpty()) {
			AristaKruskal aristaAux = colaDeAristas.poll();
			System.out.println(aristaAux);
			
			if(unionFind.union(aristaAux.getDesde(), aristaAux.getHasta()))
				costo += aristaAux.getCosto();
		}
		
		// Obtengo el vector de representantes desde unionFind
		representantes = unionFind.getId();
		
		return costo;
	}

	public int[] getRepresentantes() {
		return representantes;
	}
	
	public int[] welshPowel() {
		
		this.actualizarMatriz();
		
		// Creo la lista ordenada de nodos
		PriorityQueue<NodoColoreo> cola = new PriorityQueue<NodoColoreo>();
		
		for (int i = 0; i < grafo.length; i++) {
			int grado = 0;
			
			for (int j = 0; j < grafo[i].length; j++) {
				if(grafo[i][j] != Double.MAX_VALUE)
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
			List<Integer> listaAdyacentes = new LinkedList<Integer>();
			// Reviso en la fila id
			for (int i = 0; i < grafo[nodoAux.getId()].length; i++) {
				if(grafo[nodoAux.getId()][i] != Double.MAX_VALUE) {
					listaAdyacentes.add(i);
				}
			}
			
			PriorityQueue<Integer> coloresOrdenados = new PriorityQueue<Integer>();		
			for (Integer integer : listaAdyacentes) {
				coloresOrdenados.add(colores[integer]); 
			}
			
			while(coloresOrdenados.isEmpty()) {
				if(coloresOrdenados.poll() == color)
					colores[nodoAux.getId()] = color;
				else
					color++;
			}
		}
		
		return colores;
	}
	
}
