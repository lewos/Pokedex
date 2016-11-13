package principal;

import Implementaciones.ColaPrioridad;
import TDA.ColaPrioridadTDA;
import algoritmos.Algoritmos;
import implementacion.Pokedex;
import implementacion.Pokemon;
import implementacion.Tipo;
import tda.ColaTDA;

public class Prueba {
	
	public static void main(String[]args) throws Exception{
		/*Creo pokemones*/
		Pokemon pikachu = new Pokemon("Pikachu", 50, 50, Tipo.ELECTRICO, 50, 50, 100);
		Pokemon charmander = new Pokemon("Charmander", 800, 70, Tipo.FUEGO, 100, 75, 100);
		Pokemon machop = new Pokemon("Machop", 250, 300, Tipo.ROCA, 180, 240, 240);
		Pokemon onyx = new Pokemon("Onyx", 180, 350, Tipo.ROCA, 170, 290, 280);
		Pokemon squirtle = new Pokemon("Squirtle", 5, 65, Tipo.AGUA, 50, 50, 60);
		
		Pokemon flareon = new Pokemon("Flareon", 80, 70, Tipo.FUEGO, 12, 75, 100);
		Pokemon magmar = new Pokemon("Magmar", 80, 70, Tipo.FUEGO, 120, 75, 100);
		Pokemon ponytah = new Pokemon("Ponytah", 10, 70, Tipo.FUEGO, 500, 75, 100);
		
		/*Creo el pokedex y lo inicializo*/
		Pokedex elPokedex = new Pokedex();
		elPokedex.Inicializar();
		
		/*Agrego los elementos en el pokedex*/
		elPokedex.Agregar(charmander);
		elPokedex.Agregar(machop);
		elPokedex.Agregar(pikachu);
		elPokedex.Agregar(squirtle);
		elPokedex.Agregar(onyx);
		elPokedex.Agregar(flareon);
		elPokedex.Agregar(magmar);
		elPokedex.Agregar(ponytah);
		
	/*	ColaPrioridadTDA<Pokemon> pokemonesDeRoca = new ColaPrioridad<Pokemon>();
		pokemonesDeRoca = elPokedex.Recuperar(Tipo.ROCA);
		
		Pokemon poke = pokemonesDeRoca.RecuperarMaxElemento();
		Double	prioridad = pokemonesDeRoca.RecuperarMaxPrioridad();
		System.out.println("Pokemon:"+poke.getNombre()+" prioridad:"+prioridad);
		pokemonesDeRoca.EliminarMaxPrioridad();
		poke = pokemonesDeRoca.RecuperarMaxElemento();
		prioridad = pokemonesDeRoca.RecuperarMaxPrioridad();
		System.out.println("Pokemon:"+poke.getNombre()+" prioridad:"+prioridad);
		pokemonesDeRoca.EliminarMaxPrioridad();
		if(pokemonesDeRoca != null)
			System.out.println("La ColaPrioridad no esta vacia");
		*/
		Algoritmos a = new Algoritmos();
		
		
		

		System.out.println("Pokemones de FUEGO POR ATAQUE ---------------------------------------------------------------------------------\n");
		ColaTDA cola = a.OrdenarPokemones(elPokedex,Tipo.FUEGO,"ataque");
		while(!cola.colaVacia()){
			System.out.println("Pokemon: " + cola.primero().getNombre() + "\n" +
							   "Ataque: "  + cola.primero().getAtaque() + "\n" );
			cola.desacolar();
		}
		
		
		System.out.println("Pokemones de FUEGO POR puntosDeCombate -----------------------------------------------------------------------\n");
		ColaTDA cola2 = a.OrdenarPokemones(elPokedex,Tipo.FUEGO,"puntosDeCombate");
		while(!cola2.colaVacia()){
			System.out.println("Pokemon: " + cola2.primero().getNombre() + "\n" +
							   "puntosDeCombate: "  + cola2.primero().getPuntosDeCombate() + "\n" );
			cola2.desacolar();
		}
	
		System.out.println("Los mas Poderosos ------------------------------------------------------------------------------------------\n");

		ColaPrioridadTDA<Pokemon> algoritmo2 = a.PokemonesPoderosos(elPokedex, 6);
		
		while(!algoritmo2.ColaVacia()){
			System.out.println("Pokemon: " + algoritmo2.RecuperarMaxElemento().getNombre() + "\n" +
					 "PC: "+ algoritmo2.RecuperarMaxPrioridad() + "\n");
			algoritmo2.EliminarMaxPrioridad();
		}
		
		
		/**no se pq no puedo utilizar 2 algoritmos al mismo tiempo, la cola me queda vacia*/
		Algoritmos a1 = new Algoritmos();	
		System.out.println("Los mas Debiles --------------------------------------------------------------------------------------------\n");
		
		ColaPrioridadTDA<Pokemon> algoritmo3 = a1.PokemonesDebiles(elPokedex, 6);
		while(!algoritmo3.ColaVacia()){
			System.out.println("Pokemon: " + algoritmo3.RecuperarMinElemento().getNombre() + "\n" +
					 "PC: "+ algoritmo3.RecuperarMinPrioridad()+ "\n");
			algoritmo3.EliminarMinPrioridad();
		}

		
		
	}
}
