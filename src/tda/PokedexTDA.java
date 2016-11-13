package tda;

import TDA.ColaPrioridadTDA;
import implementacion.Pokemon;
import implementacion.Tipo;

public interface PokedexTDA {
	/**Inicializa la estructura.
	 * PRE:-
	 * POS: Estructura inicializada*/
	public void Inicializar();
	 /**Agrega un pokemon a la estructura. 
      * PRE: Es necesario que la misma est� inicializada.
	  * POS: Un pokemon mas en el pokedex*/
	public void Agregar(Pokemon pokemon);
	/**Elimina el pokemon de la estructura, transfiri�ndolo al profesor.
	 * PRE: Es necesario que el pokemon exista.
	 * POS: Un pokemon menos en el pokedex*/
	public void	Transferir(Pokemon pokemon);
	/**Recupera todos los pokemones del tipo pasado por par�metro en una ColaPrioridadTDA.
	 * PRE: Es necesario que la estructura est� inicializada.
	 * POS: -*/
	public ColaPrioridadTDA<Pokemon> Recuperar(Tipo tipo);
}