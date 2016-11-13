package implementacion;

import tda.ColaTDA;

public class ColaID  implements ColaTDA{
	
    class Nodo {
		Pokemon info;
		Nodo sig;
	}
	
	// Primer elemento de la cola.
	Nodo primero;

	@Override
	public void acolar(Pokemon x) {
		if(primero==null){
			primero= new Nodo();
			primero.info = x;
			primero.sig=null;
		}
		else{
			Nodo recorro = primero;
			while(recorro.sig !=null){
				recorro=recorro.sig;
			}
			Nodo aux = new Nodo();
			aux.info=x;
			aux.sig=null;
			recorro.sig=aux;
		}		
	}

	@Override
	public void desacolar() {
		primero=primero.sig;
	}

	@Override
	public Pokemon primero() {
		return primero.info;
	}

	@Override
	public boolean colaVacia() {
		return (primero ==  null);
	}

	@Override
	public void inicializar() {
		primero = null;
	}

}
