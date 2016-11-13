package tda;

import implementacion.Pokemon;

public interface ColaTDA {
	
		// Inicialzada
		void acolar(Pokemon x);
		// Inicialzada y no vacía
		void desacolar();
		// Inicialzada y no vacía
		Pokemon primero();
		// Inicialzada\
		boolean colaVacia();

		void inicializar();
	
}
