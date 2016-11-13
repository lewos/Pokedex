package implementacion;

import tda.PokedexTDA;
import Implementaciones.ColaPrioridad;
import TDA.ColaPrioridadTDA;

public class Pokedex implements PokedexTDA{
	
	class NodoTipoABB{
		Tipo tipo;
		ColaPrioridad<Pokemon> pokemones;
		PokedexTDA hijoIzq;
		PokedexTDA hijoDer;
		}

	NodoTipoABB raiz;
	
	public void Inicializar() {
		raiz = null;
	}

	public void Agregar(Pokemon pokemon) {
		/*inserto el pokemon en su nodo tipo, en la colaPrioridad segun los puntosDeCombate */
		if (raiz == null) {
			raiz = new NodoTipoABB();
			raiz.tipo = pokemon.getTipo();
			raiz.pokemones = new ColaPrioridad<Pokemon>();
			raiz.pokemones.InicializarCola();
			raiz.pokemones.AgregarElemento(pokemon, pokemon.getPuntosDeCombate());
			raiz.hijoIzq = new Pokedex();
			raiz.hijoIzq.Inicializar();
			raiz.hijoDer = new Pokedex ();
			raiz.hijoDer.Inicializar();
		}
		/*Se comparan los tipos. Si el compare sale mayor a 0, es porque la raiz viene despues alfabeticamente*/
		else if (raiz.tipo.toString().compareTo(pokemon.getTipo().toString()) > 0)
			raiz.hijoIzq. Agregar(pokemon);
		/*Si el compare es menor a 0, significa que el tipo de la raiz es menor alfabeticamente a la del pokemon nuevo*/
		else if(raiz.tipo.toString().compareTo(pokemon.getTipo().toString()) < 0)
			raiz.hijoDer.Agregar(pokemon);
		/*Los tipos son iguales, se agrega en la colaPrioridad de la raiz*/
		else{
			raiz.pokemones.AgregarElemento(pokemon, pokemon.getPuntosDeCombate());
		}
	}

	public void Transferir(Pokemon pokemon) {
		
		ColaPrioridadTDA<Pokemon> colaPokemonTipoOriginal = this.Recuperar(pokemon.getTipo());
		
		ColaPrioridadTDA<Pokemon> colaPokemonTipoCopia =  new ColaPrioridad<Pokemon>();


		/*busco en el arbol el tipo*/
		/*Si los tipos son iguales, elimino el elemento de la colaPrioridad del nodo*/
		if(raiz.tipo.toString().compareTo(pokemon.getTipo().toString()) == 0){
			//creo una cola auxliar , recorro la colaOriginal y voy agregando pokemones que no sean el que quiero tranferir
			colaPokemonTipoCopia.InicializarCola();
			/*mientras la colaOriginal no esta vacia*/
			while(!colaPokemonTipoOriginal.ColaVacia()){
				try {
					if(colaPokemonTipoOriginal.RecuperarMaxElemento() != pokemon)
					colaPokemonTipoCopia.AgregarElemento(colaPokemonTipoOriginal.RecuperarMaxElemento(),colaPokemonTipoOriginal.RecuperarMaxPrioridad());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			colaPokemonTipoOriginal.EliminarMaxPrioridad();
		
		/* ahora le doy la colaCopia a la original*/
		colaPokemonTipoOriginal = colaPokemonTipoCopia;
		}
		else if (raiz.tipo.toString().compareTo(pokemon.getTipo().toString()) > 0)
			raiz.hijoIzq.Transferir(pokemon);
		else if(raiz.tipo.toString().compareTo(pokemon.getTipo().toString()) < 0)
			raiz.hijoDer.Transferir(pokemon);
	}

	public ColaPrioridadTDA<Pokemon> Recuperar(Tipo tipo) {
		ColaPrioridadTDA<Pokemon> pokemones = new ColaPrioridad<Pokemon>();
		ColaPrioridadTDA<Pokemon> aux = new ColaPrioridad<Pokemon>();
		
		pokemones.InicializarCola();
		aux.InicializarCola();

		if(raiz!=null){
			if(raiz.tipo.toString() == tipo.toString()){
				while(!raiz.pokemones.ColaVacia()){
					try {
						pokemones.AgregarElemento(raiz.pokemones.RecuperarMaxElemento(),raiz.pokemones.RecuperarMaxPrioridad());
					} catch (Exception e) {
						e.printStackTrace();
					}
					try {
						aux.AgregarElemento(raiz.pokemones.RecuperarMaxElemento(),raiz.pokemones.RecuperarMaxPrioridad());
					} catch (Exception e) {
						e.printStackTrace();
					}
					raiz.pokemones.EliminarMaxPrioridad();
				}
				
				while(!aux.ColaVacia()){
					try {
						raiz.pokemones.AgregarElemento(aux.RecuperarMaxElemento(), aux.RecuperarMaxPrioridad());
					} catch (Exception e) {
						e.printStackTrace();
					}
					aux.EliminarMaxPrioridad();
				}
			}
			else if(raiz.tipo.toString().compareTo(tipo.toString()) > 0)
				pokemones = raiz.hijoIzq.Recuperar(tipo);
			else
				pokemones = raiz.hijoDer.Recuperar(tipo);
		}

		return pokemones;
	}
	
}
