package algoritmos;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

import Implementaciones.ColaPrioridad;
import TDA.ColaPrioridadTDA;
import implementacion.ColaID;
import implementacion.Pokedex;
import implementacion.Pokemon;
import implementacion.Tipo;
import tda.ColaTDA;

public class Algoritmos {
	
	/*2. Desarrollar el método público OrdenarPokemones, el cual recibe como parámetro el tipo y la característica por el que se requiere 
	 * ordenar los pokemones y devuelve una ColaTDA con todos los pokemones ordenados según el criterio elegido.*/
	
	public ColaTDA OrdenarPokemones (Pokedex pokedex, Tipo tipo, String parametro) throws Exception{
		
		ColaTDA res = new ColaID();
		res.inicializar();
		
		ColaTDA res2 = new ColaID();
		res2.inicializar();
		
		ColaPrioridadTDA<Pokemon> colaPrioridadOriginal = pokedex.Recuperar(tipo);
		ColaPrioridadTDA<Pokemon> auxcolaPrioridad = new ColaPrioridad<Pokemon>();
		auxcolaPrioridad.InicializarCola();	
		
		
		/*Agrego a la colaPrioridad por el parametro*/
		while(!colaPrioridadOriginal.ColaVacia()){
			auxcolaPrioridad.AgregarElemento(colaPrioridadOriginal.RecuperarMaxElemento(), 
					retornar(colaPrioridadOriginal.RecuperarMaxElemento(), parametro));
			colaPrioridadOriginal.EliminarMaxPrioridad();	
		}

		/*Pasar todo a cola*/
		while(!auxcolaPrioridad.ColaVacia()){
			res.acolar(auxcolaPrioridad.RecuperarMaxElemento());
			//System.out.println(auxcolaPrioridad.RecuperarMaxElemento().getNombre());
			auxcolaPrioridad.EliminarMaxPrioridad();
		}	
		
		return res;
	}
	/*Metodo que utilizo para retornar el valor de la caracteristica por la que quiero ordenar*/
	private double retornar(Pokemon pokemon,String parametro){
		double res;
		
		switch(parametro){
	        case "puntosDeCombate": res = pokemon.getPuntosDeCombate();
	                 break;
	        case "puntosDeSalud": res = pokemon.getPuntosDeSalud();
	                 break;
	        case "ataque": res = (double)pokemon.getAtaque();
	                 break;
	        case "defensa": res = (double)pokemon.getDefensa();
	        		break;
	        case "stamina": res = (double)pokemon.getStamina();
	        		break;
	        default: res = 0;
	                 break;
		}
		
		return res;
	}
	
	/*3.	Desarrollar el método público PokemonesPoderosos, el cual recibirá como parámetro la cantidad de pokemones requeridos y devolverá
	 *  una ColaPrioridadTDA con los pokemones con mayor PC.*/

	public ColaPrioridadTDA<Pokemon>  PokemonesPoderosos(Pokedex pokedex, int cantPokemonesPoderosos) throws Exception{
		
		ColaPrioridadTDA<Pokemon> algo = new ColaPrioridad<Pokemon>();
		algo.InicializarCola();
		
		ColaPrioridadTDA<Pokemon> auxPorTipo = todoElPokedexEnUnaCola(pokedex);
		
		/*entrego la canPokemonesPoderosos de Pokemones de la colaPrioridad*/
		
		while(cantPokemonesPoderosos!=0){
		algo.AgregarElemento(auxPorTipo.RecuperarMaxElemento(), auxPorTipo.RecuperarMaxPrioridad());
		auxPorTipo.EliminarMaxPrioridad();
		cantPokemonesPoderosos--;
		}
		
		return algo;
		
	}

	/*4.	Desarrollar el método público PokemonesDebiles, el cual recibirá como parámetro la cantidad de pokemones requeridos y devolverá
	 *  una ColaPrioridadTDA con los pokemones con menor PC.*/
	
	public ColaPrioridadTDA<Pokemon>  PokemonesDebiles(Pokedex pokedex, int cantPokemonesDebiles) throws Exception{
		
		ColaPrioridadTDA<Pokemon> algo = new ColaPrioridad<Pokemon>();
		algo.InicializarCola();
		
		ColaPrioridadTDA<Pokemon> auxPorTipo = todoElPokedexEnUnaCola(pokedex);
		/*entrego la canPokemonesDebiles de Pokemones de la colaPrioridad*/
		
		while(cantPokemonesDebiles!=0){
		algo.AgregarElemento(auxPorTipo.RecuperarMinElemento(), auxPorTipo.RecuperarMinPrioridad());
		auxPorTipo.EliminarMinPrioridad();
		cantPokemonesDebiles--;
		}
		
		return algo;	
	}
	
	private ColaPrioridadTDA<Pokemon> todoElPokedexEnUnaCola(Pokedex pokedex) throws Exception{
		
		ColaPrioridadTDA<Pokemon> auxPorTipo = new ColaPrioridad<Pokemon>();
		auxPorTipo.InicializarCola();
		
		/*agrego todo el pokedex a la colaPrioridad */
		
		Set<Tipo> elements = EnumSet.allOf(Tipo.class);
		Iterator<Tipo> it = elements.iterator();
		
		while (it.hasNext()) {
		   Tipo tipo = it.next(); 
		   ColaPrioridadTDA<Pokemon> colaAux = pokedex.Recuperar(tipo);
		   while(!colaAux.ColaVacia()){
			   Pokemon cualq = colaAux.RecuperarMaxElemento();
			   auxPorTipo.AgregarElemento(cualq, cualq.getPuntosDeCombate());
			   colaAux.EliminarMaxPrioridad();		   
		   }   
		}

		return auxPorTipo;
	}
	
}
