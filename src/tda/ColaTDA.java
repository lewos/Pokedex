package tda;

import implementacion.Pokemon;

public interface ColaTDA {
	
		// Inicialzada
		void acolar(Pokemon x);
		// Inicialzada y no vac�a
		void desacolar();
		// Inicialzada y no vac�a
		Pokemon primero();
		// Inicialzada\
		boolean colaVacia();

		void inicializar();
	
}
